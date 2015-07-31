package net.minecraft.server;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import javax.crypto.SecretKey;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.NetworkManager;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.Packet;
import net.minecraft.server.class_jh;
import net.minecraft.server.class_ji;
import net.minecraft.server.class_jj;
import net.minecraft.server.class_jk;
import net.minecraft.server.class_jl;
import net.minecraft.server.class_jm;
import net.minecraft.server.class_jn;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_ni;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lq implements class_jl, class_kn {
	private static final AtomicInteger b = new AtomicInteger(0);
	private static final Logger c = LogManager.getLogger();
	private static final Random d = new Random();
	private final byte[] e = new byte[4];
	private final MinecraftServer f;
	public final NetworkManager a;
	private class_lq.class_a_in_class_lq g;
	private int h;
	private GameProfile i;
	private String j;
	private SecretKey k;
	private class_lh l;

	public class_lq(MinecraftServer var1, NetworkManager var2) {
		this.g = class_lq.class_a_in_class_lq.a;
		this.j = "";
		this.f = var1;
		this.a = var2;
		d.nextBytes(this.e);
	}

	public void c() {
		if (this.g == class_lq.class_a_in_class_lq.d) {
			this.b();
		} else if (this.g == class_lq.class_a_in_class_lq.e) {
			class_lh var1 = this.f.ap().a(this.i.getId());
			if (var1 == null) {
				this.g = class_lq.class_a_in_class_lq.d;
				this.f.ap().a(this.a, this.l);
				this.l = null;
			}
		}

		if (this.h++ == 600) {
			this.a("Took too long to log in");
		}

	}

	public void a(String var1) {
		try {
			c.info("Disconnecting " + this.d() + ": " + var1);
			class_fa var2 = new class_fa(var1);
			this.a.sendPacket((Packet) (new class_jk(var2)));
			this.a.close((IChatBaseComponent) var2);
		} catch (Exception var3) {
			c.error((String) "Error whilst disconnecting player", (Throwable) var3);
		}

	}

	public void b() {
		if (!this.i.isComplete()) {
			this.i = this.a(this.i);
		}

		String var1 = this.f.ap().a(this.a.getAddress(), this.i);
		if (var1 != null) {
			this.a(var1);
		} else {
			this.g = class_lq.class_a_in_class_lq.f;
			if (this.f.aK() >= 0 && !this.a.isLocal()) {
				this.a.sendPacket(new class_jj(this.f.aK()), new ChannelFutureListener() {
					public void operationComplete(ChannelFuture var1) throws Exception {
						class_lq.this.a.setCompression(class_lq.this.f.aK());
					}
				}, new GenericFutureListener[0]);
			}

			this.a.sendPacket((Packet) (new class_jh(this.i)));
			class_lh var2 = this.f.ap().a(this.i.getId());
			if (var2 != null) {
				this.g = class_lq.class_a_in_class_lq.e;
				this.l = this.f.ap().g(this.i);
			} else {
				this.f.ap().a(this.a, this.f.ap().g(this.i));
			}
		}

	}

	public void disconnect(IChatBaseComponent var1) {
		c.info(this.d() + " lost connection: " + var1.c());
	}

	public String d() {
		return this.i != null ? this.i.toString() + " (" + this.a.getAddress().toString() + ")" : String.valueOf(this.a.getAddress());
	}

	public void a(class_jm var1) {
		Validate.validState(this.g == class_lq.class_a_in_class_lq.a, "Unexpected hello packet", new Object[0]);
		this.i = var1.a();
		if (this.f.af() && !this.a.isLocal()) {
			this.g = class_lq.class_a_in_class_lq.b;
			this.a.sendPacket((Packet) (new class_ji(this.j, this.f.Q().getPublic(), this.e)));
		} else {
			this.g = class_lq.class_a_in_class_lq.d;
		}

	}

	public void a(class_jn var1) {
		Validate.validState(this.g == class_lq.class_a_in_class_lq.b, "Unexpected key packet", new Object[0]);
		PrivateKey var2 = this.f.Q().getPrivate();
		if (!Arrays.equals(this.e, var1.b(var2))) {
			throw new IllegalStateException("Invalid nonce!");
		} else {
			this.k = var1.a(var2);
			this.g = class_lq.class_a_in_class_lq.c;
			this.a.enableEncryption(this.k);
			(new Thread("User Authenticator #" + b.incrementAndGet()) {
				public void run() {
					GameProfile var1 = class_lq.this.i;

					try {
						String var2 = (new BigInteger(class_ni.a(class_lq.this.j, class_lq.this.f.Q().getPublic(), class_lq.this.k))).toString(16);
						class_lq.this.i = class_lq.this.f.aD().hasJoinedServer(new GameProfile((UUID) null, var1.getName()), var2);
						if (class_lq.this.i != null) {
							class_lq.c.info("UUID of player " + class_lq.this.i.getName() + " is " + class_lq.this.i.getId());
							class_lq.this.g = class_lq.class_a_in_class_lq.d;
						} else if (class_lq.this.f.T()) {
							class_lq.c.warn("Failed to verify username but will let them in anyway!");
							class_lq.this.i = class_lq.this.a(var1);
							class_lq.this.g = class_lq.class_a_in_class_lq.d;
						} else {
							class_lq.this.a("Failed to verify username!");
							class_lq.c.error("Username \'" + class_lq.this.i.getName() + "\' tried to join with an invalid session");
						}
					} catch (AuthenticationUnavailableException var3) {
						if (class_lq.this.f.T()) {
							class_lq.c.warn("Authentication servers are down but will let them in anyway!");
							class_lq.this.i = class_lq.this.a(var1);
							class_lq.this.g = class_lq.class_a_in_class_lq.d;
						} else {
							class_lq.this.a("Authentication servers are down. Please try again later, sorry!");
							class_lq.c.error("Couldn\'t verify username because servers are unavailable");
						}
					}

				}
			}).start();
		}
	}

	protected GameProfile a(GameProfile var1) {
		UUID var2 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1.getName()).getBytes(Charsets.UTF_8));
		return new GameProfile(var2, var1.getName());
	}

	static enum class_a_in_class_lq {
		a, b, c, d, e, f;
	}
}
