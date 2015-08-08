package net.minecraft.server;

import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.util.concurrent.Futures;

public class PlayerConnection implements PacketListenerPlayIn, ITickAble {

	private static final Logger logger = LogManager.getLogger();

	public final NetworkManager networkManager;
	private final MinecraftServer minecraftServer;
	public EntityPlayer player;
	private int e;
	private int f;
	private int g;
	private boolean h;
	private int i;
	private long j;
	private long k;
	private int l;
	private int m;
	private IntHashMap n = new IntHashMap();
	private double o;
	private double p;
	private double q;
	private boolean r = true;

	public PlayerConnection(MinecraftServer var1, NetworkManager var2, EntityPlayer var3) {
		minecraftServer = var1;
		networkManager = var2;
		var2.setPacketListener(this);
		player = var3;
		var3.playerConnection = this;
	}

	@Override
	public void tick() {
		h = false;
		++e;
		minecraftServer.c.a("keepAlive");
		if ((e - k) > 40L) {
			k = e;
			j = this.d();
			i = (int) j;
			this.sendPacket((new PacketPlayOutKeepAlive(i)));
		}

		minecraftServer.c.b();
		if (l > 0) {
			--l;
		}

		if (m > 0) {
			--m;
		}

		if ((player.D() > 0L) && (minecraftServer.aA() > 0) && ((MinecraftServer.az() - player.D()) > minecraftServer.aA() * 1000 * 60)) {
			c("You have been idle for too long!");
		}

	}

	public NetworkManager a() {
		return networkManager;
	}

	public void c(String var1) {
		final ChatComponentText var2 = new ChatComponentText(var1);
		networkManager.sendPacket(new PacketPlayOutKickDisconnect(var2), new GenericFutureListener() {
			@Override
			public void operationComplete(Future var1) throws Exception {
				networkManager.close(var2);
			}
		}, new GenericFutureListener[0]);
		networkManager.disableAutoRead();
		Futures.getUnchecked(minecraftServer.a(new Runnable() {
			@Override
			public void run() {
				networkManager.handleDisconnection();
			}
		}));
	}

	@Override
	public void handle(PacketPlayInSteerVehicle var1) {
		class_fh.a(var1, this, player.u());
		player.a(var1.getSideSpeed(), var1.getForwardSpeed(), var1.isJump(), var1.isUnmount());
	}

	private boolean b(PacketPlayInFlying var1) {
		return !Doubles.isFinite(var1.getX()) || !Doubles.isFinite(var1.getY()) || !Doubles.isFinite(var1.getZ()) || !Floats.isFinite(var1.getPitch()) || !Floats.isFinite(var1.getYaw());
	}

	@Override
	public void handle(PacketPlayInFlying var1) {
		class_fh.a(var1, this, player.u());
		if (b(var1)) {
			c("Invalid move packet received");
		} else {
			WorldServer var2 = minecraftServer.getWorldServer(player.dimension);
			h = true;
			if (!player.i) {
				double var3 = player.locX;
				double var5 = player.locY;
				double var7 = player.locZ;
				double var9 = 0.0D;
				double var11 = var1.getX() - o;
				double var13 = var1.getY() - p;
				double var15 = var1.getZ() - q;
				if (var1.hasPos()) {
					var9 = (var11 * var11) + (var13 * var13) + (var15 * var15);
					if (!r && (var9 < 0.25D)) {
						r = true;
					}
				}

				if (r) {
					f = e;
					double var19;
					double var21;
					double var23;
					if (player.vehicle != null) {
						float var44 = player.yaw;
						float var18 = player.pitch;
						player.vehicle.al();
						var19 = player.locX;
						var21 = player.locY;
						var23 = player.locZ;
						if (var1.hasLook()) {
							var44 = var1.getYaw();
							var18 = var1.getPitch();
						}

						player.onGround = var1.isOnGround();
						player.l();
						player.a(var19, var21, var23, var44, var18);
						if (player.vehicle != null) {
							player.vehicle.al();
						}

						minecraftServer.getPlayerList().d(player);
						if (player.vehicle != null) {
							if (var9 > 4.0D) {
								Entity var45 = player.vehicle;
								player.playerConnection.sendPacket((new PacketPlayOutEntityTeleport(var45)));
								this.a(player.locX, player.locY, player.locZ, player.yaw, player.pitch);
							}

							player.vehicle.ai = true;
						}

						if (r) {
							o = player.locX;
							p = player.locY;
							q = player.locZ;
						}

						var2.g(player);
						return;
					}

					if (player.isSleeping()) {
						player.l();
						player.a(o, p, q, player.yaw, player.pitch);
						var2.g(player);
						return;
					}

					double var17 = player.locY;
					o = player.locX;
					p = player.locY;
					q = player.locZ;
					var19 = player.locX;
					var21 = player.locY;
					var23 = player.locZ;
					float var25 = player.yaw;
					float var26 = player.pitch;
					if (var1.hasPos() && (var1.getY() == -999.0D)) {
						var1.setHasPos(false);
					}

					if (var1.hasPos()) {
						var19 = var1.getX();
						var21 = var1.getY();
						var23 = var1.getZ();
						if ((Math.abs(var1.getX()) > 3.0E7D) || (Math.abs(var1.getZ()) > 3.0E7D)) {
							c("Illegal position");
							return;
						}
					}

					if (var1.hasLook()) {
						var25 = var1.getYaw();
						var26 = var1.getPitch();
					}

					player.l();
					player.a(o, p, q, var25, var26);
					if (!r) {
						return;
					}

					double var27 = var19 - player.locX;
					double var29 = var21 - player.locY;
					double var31 = var23 - player.locZ;
					double var33 = (player.motX * player.motX) + (player.motY * player.motY) + (player.motZ * player.motZ);
					double var35 = (var27 * var27) + (var29 * var29) + (var31 * var31);
					if (((var35 - var33) > 100.0D) && (!minecraftServer.isLocal() || !minecraftServer.S().equals(player.getName()))) {
						logger.warn(player.getName() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var27 + ", " + var29 + ", " + var31 + ")");
						this.a(o, p, q, player.yaw, player.pitch);
						return;
					}

					float var37 = 0.0625F;
					boolean var38 = var2.getCubes(player, player.getBoundingBox().d(var37, var37, var37)).isEmpty();
					if (player.onGround && !var1.isOnGround() && (var29 > 0.0D)) {
						player.bG();
					}

					player.d(var27, var29, var31);
					player.onGround = var1.isOnGround();
					double var39 = var29;
					var27 = var19 - player.locX;
					var29 = var21 - player.locY;
					if ((var29 > -0.5D) || (var29 < 0.5D)) {
						var29 = 0.0D;
					}

					var31 = var23 - player.locZ;
					var35 = (var27 * var27) + (var29 * var29) + (var31 * var31);
					boolean var41 = false;
					if ((var35 > 0.0625D) && !player.isSleeping() && !player.playerInteractManager.d()) {
						var41 = true;
						logger.warn(player.getName() + " moved wrongly!");
					}

					player.a(var19, var21, var23, var25, var26);
					player.k(player.locX - var3, player.locY - var5, player.locZ - var7);
					if (!player.noclip) {
						boolean var42 = var2.getCubes(player, player.getBoundingBox().d(var37, var37, var37)).isEmpty();
						if (var38 && (var41 || !var42) && !player.isSleeping()) {
							this.a(o, p, q, var25, var26);
							return;
						}
					}

					AxisAlignedBB var43 = player.getBoundingBox().grow(var37, var37, var37).add(0.0D, -0.55D, 0.0D);
					if (!(minecraftServer.ak() || player.abilities.mayfly || var2.c(var43) || player.hasEffect(MobEffectList.y))) {
						if (var39 >= -0.03125D) {
							++g;
							if (g > 80) {
								logger.warn(player.getName() + " was kicked for floating too long!");
								c("Flying is not enabled on this server");
								return;
							}
						}
					} else {
						g = 0;
					}

					player.onGround = var1.isOnGround();
					minecraftServer.getPlayerList().d(player);
					player.a(player.locY - var17, var1.isOnGround());
				} else if ((e - f) > 20) {
					this.a(o, p, q, player.yaw, player.pitch);
				}

			}
		}
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.a(var1, var3, var5, var7, var8, Collections.emptySet());
	}

	public void a(double var1, double var3, double var5, float var7, float var8, Set var9) {
		r = false;
		o = var1;
		p = var3;
		q = var5;
		if (var9.contains(PacketPlayOutPosition.class_a_in_class_fi.a)) {
			o += player.locX;
		}

		if (var9.contains(PacketPlayOutPosition.class_a_in_class_fi.b)) {
			p += player.locY;
		}

		if (var9.contains(PacketPlayOutPosition.class_a_in_class_fi.c)) {
			q += player.locZ;
		}

		float var10 = var7;
		float var11 = var8;
		if (var9.contains(PacketPlayOutPosition.class_a_in_class_fi.d)) {
			var10 = var7 + player.yaw;
		}

		if (var9.contains(PacketPlayOutPosition.class_a_in_class_fi.e)) {
			var11 = var8 + player.pitch;
		}

		player.a(o, p, q, var10, var11);
		player.playerConnection.sendPacket((new PacketPlayOutPosition(var1, var3, var5, var7, var8, var9)));
	}

	@Override
	public void handle(PacketPlayInBlockDig var1) {
		class_fh.a(var1, this, player.u());
		WorldServer var2 = minecraftServer.getWorldServer(player.dimension);
		BlockPosition var3 = var1.getPosition();
		player.z();
		switch (PlayerConnection.SyntheticClass_1.a[var1.getDigType().ordinal()]) {
			case 1:
				if (!player.isSpectator()) {
					ItemStack var12 = player.getItemInHand(EnumUsedHand.OFF_HAND);
					player.a(EnumUsedHand.OFF_HAND, player.getItemInHand(EnumUsedHand.MAIN_HAND));
					player.a(EnumUsedHand.MAIN_HAND, var12);
				}

				return;
			case 2:
				if (!player.isSpectator()) {
					player.a(false);
				}

				return;
			case 3:
				if (!player.isSpectator()) {
					player.a(true);
				}

				return;
			case 4:
				player.bY();
				return;
			case 5:
			case 6:
			case 7:
				double var4 = player.locX - (var3.getX() + 0.5D);
				double var6 = (player.locY - (var3.getY() + 0.5D)) + 1.5D;
				double var8 = player.locZ - (var3.getZ() + 0.5D);
				double var10 = (var4 * var4) + (var6 * var6) + (var8 * var8);
				if (var10 > 36.0D) {
					return;
				} else if (var3.getY() >= minecraftServer.an()) {
					return;
				} else {
					if (var1.getDigType() == PacketPlayInBlockDig.EnumPlayerDigType.START_DESTROY_BLOCK) {
						if (!minecraftServer.a(var2, var3, player) && var2.ag().a(var3)) {
							player.playerInteractManager.a(var3, var1.getFace());
						} else {
							player.playerConnection.sendPacket((new PacketPlayOutBlockChange(var2, var3)));
						}
					} else {
						if (var1.getDigType() == PacketPlayInBlockDig.EnumPlayerDigType.STOP_DESTROY_BLOCK) {
							player.playerInteractManager.a(var3);
						} else if (var1.getDigType() == PacketPlayInBlockDig.EnumPlayerDigType.ABORT_DESTROY_BLOCK) {
							player.playerInteractManager.e();
						}

						if (var2.getType(var3).getBlock().getMaterial() != Material.AIR) {
							player.playerConnection.sendPacket((new PacketPlayOutBlockChange(var2, var3)));
						}
					}

					return;
				}
			default:
				throw new IllegalArgumentException("Invalid player action");
		}
	}

	@Override
	public void handle(PacketPlayInBlockPlace var1) {
		class_fh.a(var1, this, player.u());
		WorldServer worldserver = minecraftServer.getWorldServer(player.dimension);
		EnumUsedHand hand = var1.getHand();
		ItemStack itemstack = player.getItemInHand(hand);
		BlockPosition position = var1.getPosition();
		EnumDirection face = var1.getDirection();
		player.z();
		if ((position.getY() >= (minecraftServer.an() - 1)) && ((face == EnumDirection.UP) || (position.getY() >= minecraftServer.an()))) {
			ChatMessage var7 = new ChatMessage("build.tooHigh", new Object[] { Integer.valueOf(minecraftServer.an()) });
			var7.getChatModifier().a(EnumChatFormat.RED);
			player.playerConnection.sendPacket((new PacketPlayOutChat(var7)));
		} else if (r && (player.e(position.getX() + 0.5D, position.getY() + 0.5D, position.getZ() + 0.5D) < 64.0D) && !minecraftServer.a(worldserver, position, player) && worldserver.ag().a(position)) {
			player.playerInteractManager.interact(player, worldserver, itemstack, hand, position, face, var1.getCursorX(), var1.getCursorY(), var1.getCursorZ());
		}

		player.playerConnection.sendPacket((new PacketPlayOutBlockChange(worldserver, position)));
		player.playerConnection.sendPacket((new PacketPlayOutBlockChange(worldserver, position.shift(face))));
		itemstack = player.getItemInHand(hand);
		if ((itemstack != null) && (itemstack.count == 0)) {
			player.a(hand, (ItemStack) null);
			itemstack = null;
		}

	}

	@Override
	public void handle(PacketPlayInUseItem var1) {
		class_fh.a(var1, this, player.u());
		WorldServer var2 = minecraftServer.getWorldServer(player.dimension);
		EnumUsedHand var3 = var1.getActiveHand();
		ItemStack var4 = player.getItemInHand(var3);
		player.z();
		if (var4 != null) {
			player.playerInteractManager.useItem(player, var2, var4, var3);
			var4 = player.getItemInHand(var3);
			if ((var4 != null) && (var4.count == 0)) {
				player.a(var3, (ItemStack) null);
				var4 = null;
			}

		}
	}

	@Override
	public void handle(PacketPlayInSpectate var1) {
		class_fh.a(var1, this, player.u());
		if (player.isSpectator()) {
			Entity var2 = null;
			WorldServer[] var3 = minecraftServer.d;
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				WorldServer var6 = var3[var5];
				if (var6 != null) {
					var2 = var1.getEntity(var6);
					if (var2 != null) {
						break;
					}
				}
			}

			if (var2 != null) {
				player.e(player);
				player.a((Entity) null);
				if (var2.world != player.world) {
					WorldServer var7 = player.u();
					WorldServer var8 = (WorldServer) var2.world;
					player.dimension = var2.dimension;
					this.sendPacket((new PacketPlayOutRespawn(player.dimension, var7.ab(), var7.Q().u(), player.playerInteractManager.getGameMode())));
					var7.f(player);
					player.dead = false;
					player.b(var2.locX, var2.locY, var2.locZ, var2.yaw, var2.pitch);
					if (player.isAlive()) {
						var7.a(player, false);
						var8.addEntity(player);
						var8.a(player, false);
					}

					player.a(var8);
					minecraftServer.getPlayerList().a(player, var7);
					player.enderTeleportTo(var2.locX, var2.locY, var2.locZ);
					player.playerInteractManager.a(var8);
					minecraftServer.getPlayerList().b(player, var8);
					minecraftServer.getPlayerList().f(player);
				} else {
					player.enderTeleportTo(var2.locX, var2.locY, var2.locZ);
				}
			}
		}

	}

	@Override
	public void handle(PacketPlayInResourcePackStatus var1) {
	}

	@Override
	public void disconnect(IChatBaseComponent var1) {
		logger.info(player.getName() + " lost connection: " + var1);
		minecraftServer.aH();
		ChatMessage var2 = new ChatMessage("multiplayer.player.left", new Object[] { player.getScoreboardDisplayName() });
		var2.getChatModifier().a(EnumChatFormat.YELLOW);
		minecraftServer.getPlayerList().a(var2);
		player.q();
		minecraftServer.getPlayerList().e(player);
		if (minecraftServer.isLocal() && player.getName().equals(minecraftServer.S())) {
			logger.info("Stopping singleplayer server as player logged out");
			minecraftServer.w();
		}

	}

	public void sendPacket(final Packet var1) {
		if (var1 instanceof PacketPlayOutChat) {
			PacketPlayOutChat var2 = (PacketPlayOutChat) var1;
			EntityHuman.ChatMode var3 = player.y();
			if (var3 == EntityHuman.ChatMode.HIDDEN) {
				return;
			}

			if ((var3 == EntityHuman.ChatMode.SYSTEM) && !var2.b()) {
				return;
			}
		}

		try {
			networkManager.sendPacket(var1);
		} catch (Throwable var5) {
			class_b var6 = class_b.a(var5, "Sending packet");
			class_c var4 = var6.a("Packet being sent");
			var4.a("Packet class", new Callable() {
				public String a() throws Exception {
					return var1.getClass().getCanonicalName();
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
			throw new class_e(var6);
		}
	}

	@Override
	public void handle(PacketPlayInHeldItemSlot var1) {
		class_fh.a(var1, this, player.u());
		if ((var1.getSlot() >= 0) && (var1.getSlot() < PlayerInventory.i())) {
			player.inventory.itemInHandIndex = var1.getSlot();
			player.z();
		} else {
			logger.warn(player.getName() + " tried to set an invalid carried item");
		}
	}

	@Override
	public void handle(PacketPlayInChat var1) {
		class_fh.a(var1, this, player.u());
		if (player.y() == EntityHuman.ChatMode.HIDDEN) {
			ChatMessage var4 = new ChatMessage("chat.cannotSend", new Object[0]);
			var4.getChatModifier().a(EnumChatFormat.RED);
			this.sendPacket((new PacketPlayOutChat(var4)));
		} else {
			player.z();
			String var2 = var1.getMessage();
			var2 = StringUtils.normalizeSpace(var2);

			for (int var3 = 0; var3 < var2.length(); ++var3) {
				if (!class_f.a(var2.charAt(var3))) {
					c("Illegal characters in chat");
					return;
				}
			}

			if (var2.startsWith("/")) {
				this.d(var2);
			} else {
				ChatMessage var5 = new ChatMessage("chat.type.text", new Object[] { player.getScoreboardDisplayName(), var2 });
				minecraftServer.getPlayerList().a(var5, false);
			}

			l += 20;
			if ((l > 200) && !minecraftServer.getPlayerList().h(player.cf())) {
				c("disconnect.spam");
			}

		}
	}

	private void d(String var1) {
		minecraftServer.P().a(player, var1);
	}

	@Override
	public void handle(PacketPlayInArmAnimation var1) {
		class_fh.a(var1, this, player.u());
		player.z();
		player.a(var1.getHand());
	}

	@Override
	public void handle(PacketPlayInEntityAction var1) {
		class_fh.a(var1, this, player.u());
		player.z();
		switch (PlayerConnection.SyntheticClass_1.b[var1.getAction().ordinal()]) {
			case 1:
				player.c(true);
				break;
			case 2:
				player.c(false);
				break;
			case 3:
				player.d(true);
				break;
			case 4:
				player.d(false);
				break;
			case 5:
				player.a(false, true, true);
				r = false;
				break;
			case 6:
				if (player.vehicle instanceof EntityHorse) {
					((EntityHorse) player.vehicle).q(var1.getJumpBoost());
				}
				break;
			case 7:
				if (player.vehicle instanceof EntityHorse) {
					((EntityHorse) player.vehicle).c(player);
				}
				break;
			default:
				throw new IllegalArgumentException("Invalid client command!");
		}

	}

	@Override
	public void handle(PacketPlayInUseEntity var1) {
		class_fh.a(var1, this, player.u());
		WorldServer var2 = minecraftServer.getWorldServer(player.dimension);
		Entity var3 = var1.getEntity(var2);
		player.z();
		if (var3 != null) {
			boolean var4 = player.t(var3);
			double var5 = 36.0D;
			if (!var4) {
				var5 = 9.0D;
			}

			if (player.h(var3) < var5) {
				EnumUsedHand var7;
				ItemStack var8;
				if (var1.getUseAction() == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT) {
					var7 = var1.getUsedHand();
					var8 = player.getItemInHand(var7);
					player.a(var3, var8, var7);
				} else if (var1.getUseAction() == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT_AT) {
					var7 = var1.getUsedHand();
					var8 = player.getItemInHand(var7);
					var3.a(player, var1.getInteractAt(), var8, var7);
				} else if (var1.getUseAction() == PacketPlayInUseEntity.EnumEntityUseAction.ATTACK) {
					if ((var3 instanceof EntityItem) || (var3 instanceof EntityExperienceOrb) || (var3 instanceof EntityArrow) || (var3 == player)) {
						c("Attempting to attack an invalid entity");
						minecraftServer.f("Player " + player.getName() + " tried to attack an invalid entity");
						return;
					}

					player.f(var3);
				}
			}
		}

	}

	@Override
	public void handle(PacketPlayInClientCommand var1) {
		class_fh.a(var1, this, player.u());
		player.z();
		PacketPlayInClientCommand.EnumClientCommand var2 = var1.a();
		switch (PlayerConnection.SyntheticClass_1.c[var2.ordinal()]) {
			case 1:
				if (player.i) {
					player = minecraftServer.getPlayerList().a(player, 0, true);
				} else if (player.u().Q().t()) {
					if (minecraftServer.isLocal() && player.getName().equals(minecraftServer.S())) {
						player.playerConnection.c("You have died. Game over, man, it\'s game over!");
						minecraftServer.aa();
					} else {
						class_mf var3 = new class_mf(player.cf(), (Date) null, "(You just lost the game)", (Date) null, "Death in Hardcore");
						minecraftServer.getPlayerList().h().a(var3);
						player.playerConnection.c("You have died. Game over, man, it\'s game over!");
					}
				} else {
					if (player.getHealth() > 0.0F) {
						return;
					}

					player = minecraftServer.getPlayerList().a(player, 0, false);
				}
				break;
			case 2:
				player.A().a(player);
				break;
			case 3:
				player.b(class_mt.f);
		}

	}

	@Override
	public void handle(PacketPlayInCloseWindow var1) {
		class_fh.a(var1, this, player.u());
		player.p();
	}

	@Override
	public void handle(PacketPlayInWindowClick var1) {
		class_fh.a(var1, this, player.u());
		player.z();
		if ((player.br.d == var1.getWindowId()) && player.br.c(player)) {
			if (player.isSpectator()) {
				ArrayList var2 = Lists.newArrayList();

				for (int var3 = 0; var3 < player.br.c.size(); ++var3) {
					var2.add(((class_yx) player.br.c.get(var3)).d());
				}

				player.a(player.br, var2);
			} else {
				ItemStack var5 = player.br.a(var1.getSlot(), var1.getButton(), var1.getMode(), player);
				if (ItemStack.b(var1.getItemStack(), var5)) {
					player.playerConnection.sendPacket((new PacketPlayOutTransaction(var1.getWindowId(), var1.getActionCounter(), true)));
					player.g = true;
					player.br.b();
					player.o();
					player.g = false;
				} else {
					n.a(player.br.d, Short.valueOf(var1.getActionCounter()));
					player.playerConnection.sendPacket((new PacketPlayOutTransaction(var1.getWindowId(), var1.getActionCounter(), false)));
					player.br.a(player, false);
					ArrayList var6 = Lists.newArrayList();

					for (int var4 = 0; var4 < player.br.c.size(); ++var4) {
						var6.add(((class_yx) player.br.c.get(var4)).d());
					}

					player.a(player.br, var6);
				}
			}
		}

	}

	@Override
	public void handle(PacketPlayInEnchantItem var1) {
		class_fh.a(var1, this, player.u());
		player.z();
		if ((player.br.d == var1.getWindowId()) && player.br.c(player) && !player.isSpectator()) {
			player.br.a(player, var1.getEnchantment());
			player.br.b();
		}

	}

	@Override
	public void handle(PacketPlayInSetCreativeSlot var1) {
		class_fh.a(var1, this, player.u());
		if (player.playerInteractManager.d()) {
			boolean var2 = var1.getSlot() < 0;
			ItemStack var3 = var1.getItemStack();
			if ((var3 != null) && var3.hasTag() && var3.getTag().hasOfType("BlockEntityTag", 10)) {
				NBTTagCompound var4 = var3.getTag().getCompound("BlockEntityTag");
				if (var4.has("x") && var4.has("y") && var4.has("z")) {
					BlockPosition var5 = new BlockPosition(var4.getInt("x"), var4.getInt("y"), var4.getInt("z"));
					TileEntity var6 = player.world.getTileEntity(var5);
					if (var6 != null) {
						NBTTagCompound var7 = new NBTTagCompound();
						var6.write(var7);
						var7.remove("x");
						var7.remove("y");
						var7.remove("z");
						var3.addTag("BlockEntityTag", var7);
					}
				}
			}

			boolean var8 = (var1.getSlot() >= 1) && (var1.getSlot() <= 45);
			boolean var9 = (var3 == null) || (var3.getItem() != null);
			boolean var10 = (var3 == null) || ((var3.i() >= 0) && (var3.count <= 64) && (var3.count > 0));
			if (var8 && var9 && var10) {
				if (var3 == null) {
					player.bq.a(var1.getSlot(), (ItemStack) null);
				} else {
					player.bq.a(var1.getSlot(), var3);
				}

				player.bq.a(player, true);
			} else if (var2 && var9 && var10 && (m < 200)) {
				m += 20;
				EntityItem var11 = player.a(var3, true);
				if (var11 != null) {
					var11.j();
				}
			}
		}

	}

	@Override
	public void handle(PacketPlayInTransaction var1) {
		class_fh.a(var1, this, player.u());
		Short var2 = (Short) n.a(player.br.d);
		if ((var2 != null) && (var1.getActionNumber() == var2.shortValue()) && (player.br.d == var1.getWindowId()) && !player.br.c(player) && !player.isSpectator()) {
			player.br.a(player, true);
		}

	}

	@Override
	public void handle(PacketPlayInUpdateSign var1) {
		class_fh.a(var1, this, player.u());
		player.z();
		WorldServer var2 = minecraftServer.getWorldServer(player.dimension);
		BlockPosition var3 = var1.getPosition();
		if (var2.isLoaded(var3)) {
			TileEntity var4 = var2.getTileEntity(var3);
			if (!(var4 instanceof TileEntitySign)) {
				return;
			}

			TileEntitySign var5 = (TileEntitySign) var4;
			if (!var5.b() || (var5.c() != player)) {
				minecraftServer.f("Player " + player.getName() + " just tried to change non-editable sign");
				return;
			}

			IChatBaseComponent[] var6 = var1.getLines();

			for (int var7 = 0; var7 < var6.length; ++var7) {
				var5.lines[var7] = new ChatComponentText(EnumChatFormat.stripFormatting(var6[var7].c()));
			}

			var5.update();
			var2.notify(var3);
		}

	}

	@Override
	public void handle(PacketPlayInKeepAlive var1) {
		if (var1.getKeepAliveId() == i) {
			int var2 = (int) (this.d() - j);
			player.h = ((player.h * 3) + var2) / 4;
		}

	}

	private long d() {
		return System.nanoTime() / 1000000L;
	}

	@Override
	public void handle(PacketPlayInAbilities var1) {
		class_fh.a(var1, this, player.u());
		player.abilities.flying = var1.isFlying() && player.abilities.mayfly;
	}

	@Override
	public void handle(PacketPlayInTabComplete var1) {
		class_fh.a(var1, this, player.u());
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = minecraftServer.a(player, var1.getText(), var1.getPosition()).iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			var2.add(var4);
		}

		player.playerConnection.sendPacket((new PacketPlayOutTabComplete((String[]) var2.toArray(new String[var2.size()]))));
	}

	@Override
	public void handle(PacketPlayInSettings var1) {
		class_fh.a(var1, this, player.u());
		player.a(var1);
	}

	@Override
	public void handle(PacketPlayInCustomPayload var1) {
		class_fh.a(var1, this, player.u());
		ItemStack var67;
		ItemStack var72;
		PacketDataSerializer var61;
		if ("MC|BEdit".equals(var1.getTag())) {
			var61 = new PacketDataSerializer(Unpooled.wrappedBuffer(var1.getData()));

			try {
				var67 = var61.readItemStack();
				if (var67 != null) {
					if (!ItemBookAndQuill.b(var67.getTag())) {
						throw new IOException("Invalid book tag!");
					}

					var72 = player.bA();
					if (var72 == null) {
						return;
					}

					if ((var67.getItem() == Items.WRITABLE_BOOK) && (var67.getItem() == var72.getItem())) {
						var72.addTag("pages", var67.getTag().getList("pages", 8));
					}

					return;
				}
			} catch (Exception var57) {
				logger.error("Couldn\'t handle book info", var57);
				return;
			} finally {
				var61.release();
			}

			return;
		} else if ("MC|BSign".equals(var1.getTag())) {
			var61 = new PacketDataSerializer(Unpooled.wrappedBuffer(var1.getData()));

			try {
				var67 = var61.readItemStack();
				if (var67 == null) {
					return;
				}

				if (!ItemWrittenBook.b(var67.getTag())) {
					throw new IOException("Invalid book tag!");
				}

				var72 = player.bA();
				if (var72 != null) {
					if ((var67.getItem() == Items.WRITTEN_BOOK) && (var72.getItem() == Items.WRITABLE_BOOK)) {
						var72.addTag("author", (new NBTTagString(player.getName())));
						var72.addTag("title", (new NBTTagString(var67.getTag().getString("title"))));
						var72.addTag("pages", var67.getTag().getList("pages", 8));
						var72.a(Items.WRITTEN_BOOK);
					}

					return;
				}
			} catch (Exception var59) {
				logger.error("Couldn\'t sign book", var59);
				return;
			} finally {
				var61.release();
			}

			return;
		} else if ("MC|TrSel".equals(var1.getTag())) {
			try {
				int var2 = var1.getData().readInt();
				Container var3 = player.br;
				if (var3 instanceof class_ys) {
					((class_ys) var3).d(var2);
				}
			} catch (Exception var56) {
				logger.error("Couldn\'t select trade", var56);
			}
		} else if ("MC|AdvCdm".equals(var1.getTag())) {
			if (!minecraftServer.al()) {
				player.a((new ChatMessage("advMode.notEnabled", new Object[0])));
			} else if (player.a(2, "") && player.abilities.instabuild) {
				var61 = var1.getData();

				try {
					byte var63 = var61.readByte();
					class_aed var4 = null;
					if (var63 == 0) {
						TileEntity var5 = player.world.getTileEntity(new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt()));
						if (var5 instanceof TileEntityCommand) {
							var4 = ((TileEntityCommand) var5).b();
						}
					} else if (var63 == 1) {
						Entity var69 = player.world.getEntityById(var61.readInt());
						if (var69 instanceof EntityMinecartCommandBlock) {
							var4 = ((EntityMinecartCommandBlock) var69).j();
						}
					}

					String var71 = var61.readString(var61.readableBytes());
					boolean var6 = var61.readBoolean();
					if (var4 != null) {
						var4.a(var71);
						var4.a(var6);
						if (!var6) {
							var4.b((IChatBaseComponent) null);
						}

						var4.h();
						player.a((new ChatMessage("advMode.setCommand.success", new Object[] { var71 })));
					}
				} catch (Exception var54) {
					logger.error("Couldn\'t set command block", var54);
				} finally {
					var61.release();
				}
			} else {
				player.a((new ChatMessage("advMode.notAllowed", new Object[0])));
			}
		} else if ("MC|Beacon".equals(var1.getTag())) {
			if (player.br instanceof class_yc) {
				try {
					var61 = var1.getData();
					int var64 = var61.readInt();
					int var68 = var61.readInt();
					class_yc var73 = (class_yc) player.br;
					class_yx var74 = var73.a(0);
					if (var74.e()) {
						var74.a(1);
						IInventory var7 = var73.e();
						var7.setProperty(1, var64);
						var7.setProperty(2, var68);
						var7.update();
					}
				} catch (Exception var53) {
					logger.error("Couldn\'t set beacon", var53);
				}
			}
		} else if ("MC|ItemName".equals(var1.getTag())) {
			if (player.br instanceof class_yb) {
				class_yb var62 = (class_yb) player.br;
				if ((var1.getData() != null) && (var1.getData().readableBytes() >= 1)) {
					String var65 = class_f.a(var1.getData().readString(32767));
					if (var65.length() <= 30) {
						var62.a(var65);
					}
				} else {
					var62.a("");
				}
			}
		} else if ("MC|Struct".equals(var1.getTag())) {
			var61 = var1.getData();

			try {
				if (player.a(4, "") && player.abilities.instabuild) {
					BlockPosition var66 = new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt());
					TileEntity var70 = player.world.getTileEntity(var66);
					if (var70 instanceof TileEntityStructure) {
						TileEntityStructure var75 = (TileEntityStructure) var70;
						byte var76 = var61.readByte();
						String var77 = var61.readString(32);
						var75.a(TileEntityStructure.EnumMode.valueOf(var77));
						var75.a(var61.readString(64));
						var75.b(new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt()));
						var75.c(new BlockPosition(var61.readInt(), var61.readInt(), var61.readInt()));
						String var8 = var61.readString(32);
						var75.a(Block.class_a_in_class_agj.valueOf(var8));
						String var9 = var61.readString(32);
						var75.a(Block.EnumRotation.valueOf(var9));
						var75.b(var61.readString(128));
						var75.a(var61.readBoolean());
						if (var76 == 2) {
							if (var75.m()) {
								player.b((new ChatComponentText("Structure saved")));
							} else {
								player.b((new ChatComponentText("Structure NOT saved")));
							}
						} else if (var76 == 3) {
							if (var75.n()) {
								player.b((new ChatComponentText("Structure loaded")));
							} else {
								player.b((new ChatComponentText("Structure prepared")));
							}
						} else if ((var76 == 4) && var75.l()) {
							player.b((new ChatComponentText("Size detected")));
						}

						var75.update();
						player.world.notify(var66);
					}
				}
			} catch (Exception var51) {
				logger.error("Couldn\'t set structure block", var51);
			} finally {
				var61.release();
			}
		}

	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[PacketPlayInClientCommand.EnumClientCommand.values().length];

		static {
			try {
				c[PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN.ordinal()] = 1;
			} catch (NoSuchFieldError var17) {
				;
			}

			try {
				c[PacketPlayInClientCommand.EnumClientCommand.REQUEST_STATS.ordinal()] = 2;
			} catch (NoSuchFieldError var16) {
				;
			}

			try {
				c[PacketPlayInClientCommand.EnumClientCommand.OPEN_INVENTORY_ACHIEVEMENT.ordinal()] = 3;
			} catch (NoSuchFieldError var15) {
				;
			}

			b = new int[PacketPlayInEntityAction.EnumPlayerAction.values().length];

			try {
				b[PacketPlayInEntityAction.EnumPlayerAction.START_SNEAKING.ordinal()] = 1;
			} catch (NoSuchFieldError var14) {
				;
			}

			try {
				b[PacketPlayInEntityAction.EnumPlayerAction.STOP_SNEAKING.ordinal()] = 2;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[PacketPlayInEntityAction.EnumPlayerAction.START_SPRINTING.ordinal()] = 3;
			} catch (NoSuchFieldError var12) {
				;
			}

			try {
				b[PacketPlayInEntityAction.EnumPlayerAction.STOP_SPRINTING.ordinal()] = 4;
			} catch (NoSuchFieldError var11) {
				;
			}

			try {
				b[PacketPlayInEntityAction.EnumPlayerAction.STOP_SLEEPING.ordinal()] = 5;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				b[PacketPlayInEntityAction.EnumPlayerAction.RIDING_JUMP.ordinal()] = 6;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				b[PacketPlayInEntityAction.EnumPlayerAction.OPEN_INVENTORY.ordinal()] = 7;
			} catch (NoSuchFieldError var8) {
				;
			}

			a = new int[PacketPlayInBlockDig.EnumPlayerDigType.values().length];

			try {
				a[PacketPlayInBlockDig.EnumPlayerDigType.SWAP_HELD_ITEMS.ordinal()] = 1;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				a[PacketPlayInBlockDig.EnumPlayerDigType.DROP_ITEM.ordinal()] = 2;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[PacketPlayInBlockDig.EnumPlayerDigType.DROP_ALL_ITEMS.ordinal()] = 3;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[PacketPlayInBlockDig.EnumPlayerDigType.RELEASE_USE_ITEM.ordinal()] = 4;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[PacketPlayInBlockDig.EnumPlayerDigType.START_DESTROY_BLOCK.ordinal()] = 5;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[PacketPlayInBlockDig.EnumPlayerDigType.ABORT_DESTROY_BLOCK.ordinal()] = 6;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[PacketPlayInBlockDig.EnumPlayerDigType.STOP_DESTROY_BLOCK.ordinal()] = 7;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
