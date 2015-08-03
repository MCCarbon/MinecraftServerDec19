package net.minecraft.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.GenericFutureListener;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.crypto.SecretKey;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;

public class LoginListener implements PacketLoginInListener, ITickAble {

	private static final AtomicInteger counter = new AtomicInteger(0);
	private static final Logger loogger = LogManager.getLogger();
	private static final Random random = new Random();

	private final byte[] verifyToken = new byte[4];
	private final MinecraftServer mcserver;
	public final NetworkManager networkManager;
	private LoginListener.State state;
	private int ticks;
	private GameProfile gameProfile;
	private String serverId;
	private SecretKey secretKey;
	private EntityPlayer player;

	public LoginListener(MinecraftServer var1, NetworkManager var2) {
		state = LoginListener.State.HELLO;
		serverId = "";
		mcserver = var1;
		networkManager = var2;
		random.nextBytes(verifyToken);
	}

	@Override
	public void tick() {
		if (state == LoginListener.State.READY_TO_ACCEPT) {
			login();
		} else if (state == LoginListener.State.DELAY_ACCEPT) {
			EntityPlayer var1 = mcserver.getPlayerList().getPlayer(gameProfile.getId());
			if (var1 == null) {
				state = LoginListener.State.READY_TO_ACCEPT;
				mcserver.getPlayerList().processLogin(networkManager, player);
				player = null;
			}
		}

		if (ticks++ == 600) {
			kick("Took too long to log in");
		}
	}

	public void kick(String reason) {
		try {
			loogger.info("Disconnecting " + getName() + ": " + reason);
			ChatComponentText message = new ChatComponentText(reason);
			networkManager.sendPacket(new PacketLoginOutDisconnect(message));
			networkManager.close(message);
		} catch (Exception e) {
			loogger.error("Error whilst disconnecting player", e);
		}

	}

	@SuppressWarnings("unchecked")
	public void login() {
		if (!gameProfile.isComplete()) {
			gameProfile = generateOfflineModeUUID(gameProfile);
		}

		String kickreason = mcserver.getPlayerList().getKickReason(networkManager.getAddress(), gameProfile);
		if (kickreason != null) {
			kick(kickreason);
		} else {
			state = LoginListener.State.ACCEPTED;
			if ((mcserver.getCompressionThreshold() >= 0) && !networkManager.isLocal()) {
				networkManager.sendPacket(new PacketLoginOutSetCompression(mcserver.getCompressionThreshold()), new ChannelFutureListener() {
					@Override
					public void operationComplete(ChannelFuture future) throws Exception {
						networkManager.setCompression(mcserver.getCompressionThreshold());
					}
				}, new GenericFutureListener[0]);
			}

			networkManager.sendPacket((new PacketLoginOutSuccess(gameProfile)));
			EntityPlayer otherplayer = mcserver.getPlayerList().getPlayer(gameProfile.getId());
			if (otherplayer != null) {
				state = LoginListener.State.DELAY_ACCEPT;
				player = mcserver.getPlayerList().addPlayer(gameProfile);
			} else {
				mcserver.getPlayerList().processLogin(networkManager, mcserver.getPlayerList().addPlayer(gameProfile));
			}
		}

	}

	@Override
	public void disconnect(IChatBaseComponent message) {
		loogger.info(getName() + " lost connection: " + message.c());
	}

	public String getName() {
		return gameProfile != null ? gameProfile.toString() + " (" + networkManager.getAddress().toString() + ")" : String.valueOf(networkManager.getAddress());
	}

	@Override
	public void handle(PacketLoginInStart packet) {
		Validate.validState(state == LoginListener.State.HELLO, "Unexpected hello packet", new Object[0]);
		gameProfile = packet.getGameProfile();
		if (mcserver.isOnlineMode() && !networkManager.isLocal()) {
			state = LoginListener.State.KEY;
			networkManager.sendPacket(new PacketLoginOutEncryptionBegin(serverId, mcserver.getKeyPair().getPublic(), verifyToken));
		} else {
			state = LoginListener.State.READY_TO_ACCEPT;
		}

	}

	@Override
	public void handle(PacketLoginInEncryptionBegin packet) {
		Validate.validState(state == LoginListener.State.KEY, "Unexpected key packet", new Object[0]);
		PrivateKey privatekey = mcserver.getKeyPair().getPrivate();
		if (!Arrays.equals(verifyToken, packet.getVerifyToken(privatekey))) {
			throw new IllegalStateException("Invalid nonce!");
		} else {
			secretKey = packet.getSecreyKey(privatekey);
			state = LoginListener.State.AUTHENTICATING;
			networkManager.enableEncryption(secretKey);
			new Thread("User Authenticator #" + counter.incrementAndGet()) {
				@Override
				public void run() {
					GameProfile var1 = gameProfile;

					try {
						String var2 = (new BigInteger(MinecraftEncryption.hashKeys(serverId, mcserver.getKeyPair().getPublic(), secretKey))).toString(16);
						gameProfile = mcserver.aD().hasJoinedServer(new GameProfile((UUID) null, var1.getName()), var2);
						if (gameProfile != null) {
							LoginListener.loogger.info("UUID of player " + gameProfile.getName() + " is " + gameProfile.getId());
							state = LoginListener.State.READY_TO_ACCEPT;
						} else if (mcserver.isLocal()) {
							LoginListener.loogger.warn("Failed to verify username but will let them in anyway!");
							gameProfile = LoginListener.this.generateOfflineModeUUID(var1);
							state = LoginListener.State.READY_TO_ACCEPT;
						} else {
							LoginListener.this.kick("Failed to verify username!");
							LoginListener.loogger.error("Username \'" + gameProfile.getName() + "\' tried to join with PORKCHOP invalid session");
						}
					} catch (AuthenticationUnavailableException e) {
						if (mcserver.isLocal()) {
							LoginListener.loogger.warn("Authentication servers are down but will let them in anyway!");
							gameProfile = LoginListener.this.generateOfflineModeUUID(var1);
							state = LoginListener.State.READY_TO_ACCEPT;
						} else {
							LoginListener.this.kick("Authentication servers are down. Please try again later, sorry!");
							LoginListener.loogger.error("Couldn\'STONE_SHOVEL verify username because servers are unavailable");
						}
					}

				}
			}.start();
		}
	}

	protected GameProfile generateOfflineModeUUID(GameProfile profile) {
		UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + profile.getName()).getBytes(Charsets.UTF_8));
		return new GameProfile(uuid, profile.getName());
	}

	static enum State {
		HELLO, KEY, AUTHENTICATING, READY_TO_ACCEPT, DELAY_ACCEPT, ACCEPTED;
	}

}
