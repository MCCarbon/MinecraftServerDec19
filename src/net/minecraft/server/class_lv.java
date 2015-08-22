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

public class class_lv implements class_jm, class_ks {
	private static final AtomicInteger b = new AtomicInteger(0);
	private static final Logger c = LogManager.getLogger();
	private static final Random d = new Random();
	private final byte[] e = new byte[4];
	private final MinecraftServer f;
	public final class_ek a;
	private class_lv.class_a_in_class_lv g;
	private int h;
	private GameProfile i;
	private String j;
	private SecretKey k;
	private class_lm l;

	public class_lv(MinecraftServer var1, class_ek var2) {
		g = class_lv.class_a_in_class_lv.a;
		j = "";
		f = var1;
		a = var2;
		d.nextBytes(e);
	}

	@Override
	public void c() {
		if (g == class_lv.class_a_in_class_lv.d) {
			b();
		} else if (g == class_lv.class_a_in_class_lv.e) {
			class_lm var1 = f.ar().a(i.getId());
			if (var1 == null) {
				g = class_lv.class_a_in_class_lv.d;
				f.ar().a(a, l);
				l = null;
			}
		}

		if (h++ == 600) {
			this.a("Took too long to log in");
		}

	}

	public void a(String var1) {
		try {
			c.info("Disconnecting " + d() + ": " + var1);
			class_fa var2 = new class_fa(var1);
			a.a((new class_jl(var2)));
			a.a(var2);
		} catch (Exception var3) {
			c.error("Error whilst disconnecting player", var3);
		}

	}

	public void b() {
		if (!i.isComplete()) {
			i = this.a(i);
		}

		String var1 = f.ar().a(a.b(), i);
		if (var1 != null) {
			this.a(var1);
		} else {
			g = class_lv.class_a_in_class_lv.f;
			if ((f.aM() >= 0) && !a.c()) {
				a.a(new class_jk(f.aM()), new ChannelFutureListener() {
					@Override
					public void operationComplete(ChannelFuture var1) throws Exception {
						a.a(f.aM());
					}
				}, new GenericFutureListener[0]);
			}

			a.a((new class_ji(i)));
			class_lm var2 = f.ar().a(i.getId());
			if (var2 != null) {
				g = class_lv.class_a_in_class_lv.e;
				l = f.ar().g(i);
			} else {
				f.ar().a(a, f.ar().g(i));
			}
		}

	}

	@Override
	public void a(class_eu var1) {
		c.info(d() + " lost connection: " + var1.c());
	}

	public String d() {
		return i != null ? i.toString() + " (" + a.b().toString() + ")" : String.valueOf(a.b());
	}

	@Override
	public void a(class_jn var1) {
		Validate.validState(g == class_lv.class_a_in_class_lv.a, "Unexpected hello packet", new Object[0]);
		i = var1.a();
		if (f.ah() && !a.c()) {
			g = class_lv.class_a_in_class_lv.b;
			a.a((new class_jj(j, f.S().getPublic(), e)));
		} else {
			g = class_lv.class_a_in_class_lv.d;
		}

	}

	@Override
	public void a(class_jo var1) {
		Validate.validState(g == class_lv.class_a_in_class_lv.b, "Unexpected key packet", new Object[0]);
		PrivateKey var2 = f.S().getPrivate();
		if (!Arrays.equals(e, var1.b(var2))) {
			throw new IllegalStateException("Invalid nonce!");
		} else {
			k = var1.a(var2);
			g = class_lv.class_a_in_class_lv.c;
			a.a(k);
			(new Thread("User Authenticator #" + b.incrementAndGet()) {
				@Override
				public void run() {
					GameProfile var1 = i;

					try {
						String var2 = (new BigInteger(class_no.a(j, f.S().getPublic(), k))).toString(16);
						i = f.aF().hasJoinedServer(new GameProfile((UUID) null, var1.getName()), var2);
						if (i != null) {
							class_lv.c.info("UUID of player " + i.getName() + " is " + i.getId());
							g = class_lv.class_a_in_class_lv.d;
						} else if (f.V()) {
							class_lv.c.warn("Failed to verify username but will let them in anyway!");
							i = class_lv.this.a(var1);
							g = class_lv.class_a_in_class_lv.d;
						} else {
							class_lv.this.a("Failed to verify username!");
							class_lv.c.error("Username \'" + i.getName() + "\' tried to join with an invalid session");
						}
					} catch (AuthenticationUnavailableException var3) {
						if (f.V()) {
							class_lv.c.warn("Authentication servers are down but will let them in anyway!");
							i = class_lv.this.a(var1);
							g = class_lv.class_a_in_class_lv.d;
						} else {
							class_lv.this.a("Authentication servers are down. Please try again later, sorry!");
							class_lv.c.error("Couldn\'t verify username because servers are unavailable");
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

	static enum class_a_in_class_lv {
		a,
		b,
		c,
		d,
		e,
		f;
	}
}
