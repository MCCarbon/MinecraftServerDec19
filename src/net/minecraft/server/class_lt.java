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

public class class_lt implements class_id, class_ks {
	private static final Logger c = LogManager.getLogger();
	public final class_ek a;
	private final MinecraftServer d;
	public class_lm b;
	private int e;
	private int f;
	private int g;
	private boolean h;
	private int i;
	private long j;
	private long k;
	private int l;
	private int m;
	private class_nu n = new class_nu();
	private double o;
	private double p;
	private double q;
	private boolean r = true;

	public class_lt(MinecraftServer var1, class_ek var2, class_lm var3) {
		d = var1;
		a = var2;
		var2.a(this);
		b = var3;
		var3.a = this;
	}

	@Override
	public void c() {
		h = false;
		++e;
		d.c.a("keepAlive");
		if ((e - k) > 40L) {
			k = e;
			j = this.d();
			i = (int) j;
			this.a((new class_go(i)));
		}

		d.c.b();
		if (l > 0) {
			--l;
		}

		if (m > 0) {
			--m;
		}

		if ((b.E() > 0L) && (d.aC() > 0) && ((MinecraftServer.aB() - b.E()) > d.aC() * 1000 * 60)) {
			this.c("You have been idle for too long!");
		}

	}

	public class_ek a() {
		return a;
	}

	public void c(String var1) {
		final class_fa var2 = new class_fa(var1);
		a.a(new class_gj(var2), new GenericFutureListener() {
			@Override
			public void operationComplete(Future var1) throws Exception {
				a.a(var2);
			}
		}, new GenericFutureListener[0]);
		a.k();
		Futures.getUnchecked(d.a(new Runnable() {
			@Override
			public void run() {
				a.l();
			}
		}));
	}

	@Override
	public void a(class_iu var1) {
		class_fh.a(var1, this, b.v());
		b.a(var1.a(), var1.b(), var1.c(), var1.d());
	}

	private boolean b(class_iq var1) {
		return !Doubles.isFinite(var1.a()) || !Doubles.isFinite(var1.b()) || !Doubles.isFinite(var1.c()) || !Floats.isFinite(var1.e()) || !Floats.isFinite(var1.d());
	}

	@Override
	public void a(class_iq var1) {
		class_fh.a(var1, this, b.v());
		if (b(var1)) {
			this.c("Invalid move packet received");
		} else {
			class_ll var2 = d.a(b.am);
			h = true;
			if (!b.i) {
				double var3 = b.s;
				double var5 = b.t;
				double var7 = b.u;
				double var9 = 0.0D;
				double var11 = var1.a() - o;
				double var13 = var1.b() - p;
				double var15 = var1.c() - q;
				if (var1.g()) {
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
					if (b.m != null) {
						float var44 = b.y;
						float var18 = b.z;
						b.m.ao();
						var19 = b.s;
						var21 = b.t;
						var23 = b.u;
						if (var1.h()) {
							var44 = var1.d();
							var18 = var1.e();
						}

						b.C = var1.f();
						b.h_();
						b.a(var19, var21, var23, var44, var18);
						if (b.m != null) {
							b.m.ao();
						}

						d.ar().d(b);
						if (b.m != null) {
							if (var9 > 4.0D) {
								Entity var45 = b.m;
								b.a.a((new class_ia(var45)));
								this.a(b.s, b.t, b.u, b.y, b.z);
							}

							b.m.ai = true;
						}

						if (r) {
							o = b.s;
							p = b.t;
							q = b.u;
						}

						var2.g(b);
						return;
					}

					if (b.bQ()) {
						b.h_();
						b.a(o, p, q, b.y, b.z);
						var2.g(b);
						return;
					}

					double var17 = b.t;
					o = b.s;
					p = b.t;
					q = b.u;
					var19 = b.s;
					var21 = b.t;
					var23 = b.u;
					float var25 = b.y;
					float var26 = b.z;
					if (var1.g() && (var1.b() == -999.0D)) {
						var1.a(false);
					}

					if (var1.g()) {
						var19 = var1.a();
						var21 = var1.b();
						var23 = var1.c();
						if ((Math.abs(var1.a()) > 3.0E7D) || (Math.abs(var1.c()) > 3.0E7D)) {
							this.c("Illegal position");
							return;
						}
					}

					if (var1.h()) {
						var25 = var1.d();
						var26 = var1.e();
					}

					b.h_();
					b.a(o, p, q, var25, var26);
					if (!r) {
						return;
					}

					double var27 = var19 - b.s;
					double var29 = var21 - b.t;
					double var31 = var23 - b.u;
					double var33 = (b.v * b.v) + (b.w * b.w) + (b.x * b.x);
					double var35 = (var27 * var27) + (var29 * var29) + (var31 * var31);
					if (((var35 - var33) > 100.0D) && (!d.V() || !d.U().equals(b.e_()))) {
						c.warn(b.e_() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var27 + ", " + var29 + ", " + var31 + ")");
						this.a(o, p, q, b.y, b.z);
						return;
					}

					float var37 = 0.0625F;
					boolean var38 = var2.a(b, b.aX().d(var37, var37, var37)).isEmpty();
					if (b.C && !var1.f() && (var29 > 0.0D)) {
						b.bM();
					}

					b.d(var27, var29, var31);
					b.C = var1.f();
					double var39 = var29;
					var27 = var19 - b.s;
					var29 = var21 - b.t;
					if ((var29 > -0.5D) || (var29 < 0.5D)) {
						var29 = 0.0D;
					}

					var31 = var23 - b.u;
					var35 = (var27 * var27) + (var29 * var29) + (var31 * var31);
					boolean var41 = false;
					if ((var35 > 0.0625D) && !b.bQ() && !b.c.d()) {
						var41 = true;
						c.warn(b.e_() + " moved wrongly!");
					}

					b.a(var19, var21, var23, var25, var26);
					b.k(b.s - var3, b.t - var5, b.u - var7);
					if (!b.T) {
						boolean var42 = var2.a(b, b.aX().d(var37, var37, var37)).isEmpty();
						if (var38 && (var41 || !var42) && !b.bQ()) {
							this.a(o, p, q, var25, var26);
							return;
						}
					}

					class_ayk var43 = b.aX().b(var37, var37, var37).a(0.0D, -0.55D, 0.0D);
					if (!d.am() && !b.bI.c && !var2.c(var43) && !b.a(class_qs.y)) {
						if (var39 >= -0.03125D) {
							++g;
							if (g > 80) {
								c.warn(b.e_() + " was kicked for floating too long!");
								this.c("Flying is not enabled on this server");
								return;
							}
						}
					} else {
						g = 0;
					}

					b.C = var1.f();
					d.ar().d(b);
					b.a(b.t - var17, var1.f());
				} else if ((e - f) > 20) {
					this.a(o, p, q, b.y, b.z);
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
		if (var9.contains(class_fi.class_a_in_class_fi.a)) {
			o += b.s;
		}

		if (var9.contains(class_fi.class_a_in_class_fi.b)) {
			p += b.t;
		}

		if (var9.contains(class_fi.class_a_in_class_fi.c)) {
			q += b.u;
		}

		float var10 = var7;
		float var11 = var8;
		if (var9.contains(class_fi.class_a_in_class_fi.d)) {
			var10 = var7 + b.y;
		}

		if (var9.contains(class_fi.class_a_in_class_fi.e)) {
			var11 = var8 + b.z;
		}

		b.a(o, p, q, var10, var11);
		b.a.a((new class_fi(var1, var3, var5, var7, var8, var9)));
	}

	@Override
	public void a(class_is var1) {
		class_fh.a(var1, this, b.v());
		class_ll var2 = d.a(b.am);
		class_cj var3 = var1.a();
		b.A();
		switch (class_lt.SyntheticClass_1.a[var1.c().ordinal()]) {
			case 1:
				if (!b.w()) {
					class_aco var12 = b.b(class_pu.b);
					b.a(class_pu.b, b.b(class_pu.a));
					b.a(class_pu.a, var12);
				}

				return;
			case 2:
				if (!b.w()) {
					b.a(false);
				}

				return;
			case 3:
				if (!b.w()) {
					b.a(true);
				}

				return;
			case 4:
				b.cd();
				return;
			case 5:
			case 6:
			case 7:
				double var4 = b.s - (var3.n() + 0.5D);
				double var6 = (b.t - (var3.o() + 0.5D)) + 1.5D;
				double var8 = b.u - (var3.p() + 0.5D);
				double var10 = (var4 * var4) + (var6 * var6) + (var8 * var8);
				if (var10 > 36.0D) {
					return;
				} else if (var3.o() >= d.ap()) {
					return;
				} else {
					if (var1.c() == class_is.class_a_in_class_is.a) {
						if (!d.a(var2, var3, b) && var2.ah().a(var3)) {
							b.c.a(var3, var1.b());
						} else {
							b.a.a((new class_fv(var2, var3)));
						}
					} else {
						if (var1.c() == class_is.class_a_in_class_is.c) {
							b.c.a(var3);
						} else if (var1.c() == class_is.class_a_in_class_is.b) {
							b.c.e();
						}

						if (var2.p(var3).c().v() != class_avq.a) {
							b.a.a((new class_fv(var2, var3)));
						}
					}

					return;
				}
			default:
				throw new IllegalArgumentException("Invalid player action");
		}
	}

	@Override
	public void a(class_jb var1) {
		class_fh.a(var1, this, b.v());
		class_ll var2 = d.a(b.am);
		class_pu var3 = var1.c();
		class_aco var4 = b.b(var3);
		class_cj var5 = var1.a();
		class_cq var6 = var1.b();
		b.A();
		if ((var5.o() >= (d.ap() - 1)) && ((var6 == class_cq.b) || (var5.o() >= d.ap()))) {
			class_fb var7 = new class_fb("build.tooHigh", new Object[] { Integer.valueOf(d.ap()) });
			var7.b().a(EnumChatFormat.RED);
			b.a.a((new class_fz(var7)));
		} else if (r && (b.e(var5.n() + 0.5D, var5.o() + 0.5D, var5.p() + 0.5D) < 64.0D) && !d.a(var2, var5, b) && var2.ah().a(var5)) {
			b.c.a(b, var2, var4, var3, var5, var6, var1.d(), var1.e(), var1.f());
		}

		b.a.a((new class_fv(var2, var5)));
		b.a.a((new class_fv(var2, var5.a(var6))));
		var4 = b.b(var3);
		if ((var4 != null) && (var4.b == 0)) {
			b.a(var3, (class_aco) null);
			var4 = null;
		}

	}

	@Override
	public void a(class_jc var1) {
		class_fh.a(var1, this, b.v());
		class_ll var2 = d.a(b.am);
		class_pu var3 = var1.a();
		class_aco var4 = b.b(var3);
		b.A();
		if (var4 != null) {
			b.c.a(b, var2, var4, var3);
			var4 = b.b(var3);
			if ((var4 != null) && (var4.b == 0)) {
				b.a(var3, (class_aco) null);
				var4 = null;
			}

		}
	}

	@Override
	public void a(class_ja var1) {
		class_fh.a(var1, this, b.v());
		if (b.w()) {
			Entity var2 = null;
			class_ll[] var3 = d.d;
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				class_ll var6 = var3[var5];
				if (var6 != null) {
					var2 = var1.a(var6);
					if (var2 != null) {
						break;
					}
				}
			}

			if (var2 != null) {
				b.e(b);
				b.a((Entity) null);
				if (var2.o != b.o) {
					class_ll var7 = b.v();
					class_ll var8 = (class_ll) var2.o;
					b.am = var2.am;
					this.a((new class_hf(b.am, var7.ac(), var7.R().t(), b.c.b())));
					var7.f(b);
					b.I = false;
					b.b(var2.s, var2.t, var2.u, var2.y, var2.z);
					if (b.al()) {
						var7.a(b, false);
						var8.a(b);
						var8.a(b, false);
					}

					b.a(var8);
					d.ar().a(b, var7);
					b.a(var2.s, var2.t, var2.u);
					b.c.a(var8);
					d.ar().b(b, var8);
					d.ar().f(b);
				} else {
					b.a(var2.s, var2.t, var2.u);
				}
			}
		}

	}

	@Override
	public void a(class_iv var1) {
	}

	@Override
	public void a(class_eu var1) {
		c.info(b.e_() + " lost connection: " + var1);
		d.aJ();
		class_fb var2 = new class_fb("multiplayer.player.left", new Object[] { b.f_() });
		var2.b().a(EnumChatFormat.YELLOW);
		d.ar().a(var2);
		b.r();
		d.ar().e(b);
		if (d.V() && b.e_().equals(d.U())) {
			c.info("Stopping singleplayer server as player logged out");
			d.w();
		}

	}

	public void a(final class_ff var1) {
		if (var1 instanceof class_fz) {
			class_fz var2 = (class_fz) var1;
			class_yu.class_b_in_class_yu var3 = b.z();
			if (var3 == class_yu.class_b_in_class_yu.c) {
				return;
			}

			if ((var3 == class_yu.class_b_in_class_yu.b) && !var2.b()) {
				return;
			}
		}

		try {
			a.a(var1);
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
	public void a(class_iw var1) {
		class_fh.a(var1, this, b.v());
		if ((var1.a() >= 0) && (var1.a() < class_yt.i())) {
			b.bq.d = var1.a();
			b.A();
		} else {
			c.warn(b.e_() + " tried to set an invalid carried item");
		}
	}

	@Override
	public void a(class_ig var1) {
		class_fh.a(var1, this, b.v());
		if (b.z() == class_yu.class_b_in_class_yu.c) {
			class_fb var4 = new class_fb("chat.cannotSend", new Object[0]);
			var4.b().a(EnumChatFormat.RED);
			this.a((new class_fz(var4)));
		} else {
			b.A();
			String var2 = var1.a();
			var2 = StringUtils.normalizeSpace(var2);

			for (int var3 = 0; var3 < var2.length(); ++var3) {
				if (!class_f.a(var2.charAt(var3))) {
					this.c("Illegal characters in chat");
					return;
				}
			}

			if (var2.startsWith("/")) {
				this.d(var2);
			} else {
				class_fb var5 = new class_fb("chat.type.text", new Object[] { b.f_(), var2 });
				d.ar().a(var5, false);
			}

			l += 20;
			if ((l > 200) && !d.ar().h(b.cl())) {
				this.c("disconnect.spam");
			}

		}
	}

	private void d(String var1) {
		d.R().a(b, var1);
	}

	@Override
	public void a(class_iz var1) {
		class_fh.a(var1, this, b.v());
		b.A();
		b.a(var1.a());
	}

	@Override
	public void a(class_it var1) {
		class_fh.a(var1, this, b.v());
		b.A();
		switch (class_lt.SyntheticClass_1.b[var1.b().ordinal()]) {
			case 1:
				b.c(true);
				break;
			case 2:
				b.c(false);
				break;
			case 3:
				b.d(true);
				break;
			case 4:
				b.d(false);
				break;
			case 5:
				b.a(false, true, true);
				r = false;
				break;
			case 6:
				if (b.m instanceof class_vf) {
					((class_vf) b.m).o(var1.c());
				}
				break;
			case 7:
				if (b.m instanceof class_vf) {
					((class_vf) b.m).c(b);
				}
				break;
			default:
				throw new IllegalArgumentException("Invalid client command!");
		}

	}

	@Override
	public void a(class_io var1) {
		class_fh.a(var1, this, b.v());
		class_ll var2 = d.a(b.am);
		Entity var3 = var1.a(var2);
		b.A();
		if (var3 != null) {
			boolean var4 = b.t(var3);
			double var5 = 36.0D;
			if (!var4) {
				var5 = 9.0D;
			}

			if (b.h(var3) < var5) {
				class_pu var7;
				class_aco var8;
				if (var1.a() == class_io.class_a_in_class_io.a) {
					var7 = var1.b();
					var8 = b.b(var7);
					b.a(var3, var8, var7);
				} else if (var1.a() == class_io.class_a_in_class_io.c) {
					var7 = var1.b();
					var8 = b.b(var7);
					var3.a(b, var1.c(), var8, var7);
				} else if (var1.a() == class_io.class_a_in_class_io.b) {
					if ((var3 instanceof class_xg) || (var3 instanceof class_rd) || (var3 instanceof class_yx) || (var3 == b)) {
						this.c("Attempting to attack an invalid entity");
						d.f("Player " + b.e_() + " tried to attack an invalid entity");
						return;
					}

					b.f(var3);
				}
			}
		}

	}

	@Override
	public void a(class_ih var1) {
		class_fh.a(var1, this, b.v());
		b.A();
		class_ih.class_a_in_class_ih var2 = var1.a();
		switch (class_lt.SyntheticClass_1.c[var2.ordinal()]) {
			case 1:
				if (b.i) {
					b = d.ar().a(b, 0, true);
				} else if (b.v().R().s()) {
					if (d.V() && b.e_().equals(d.U())) {
						b.a.c("You have died. Game over, man, it\'s game over!");
						d.ac();
					} else {
						class_mk var3 = new class_mk(b.cl(), (Date) null, "(You just lost the game)", (Date) null, "Death in Hardcore");
						d.ar().h().a(var3);
						b.a.c("You have died. Game over, man, it\'s game over!");
					}
				} else {
					if (b.bu() > 0.0F) {
						return;
					}

					b = d.ar().a(b, 0, false);
				}
				break;
			case 2:
				b.B().a(b);
				break;
			case 3:
				b.b(class_my.f);
		}

	}

	@Override
	public void a(class_im var1) {
		class_fh.a(var1, this, b.v());
		b.q();
	}

	@Override
	public void a(class_il var1) {
		class_fh.a(var1, this, b.v());
		b.A();
		if ((b.bs.d == var1.a()) && b.bs.c(b)) {
			if (b.w()) {
				ArrayList var2 = Lists.newArrayList();

				for (int var3 = 0; var3 < b.bs.c.size(); ++var3) {
					var2.add(((class_aas) b.bs.c.get(var3)).d());
				}

				b.a(b.bs, var2);
			} else {
				class_aco var5 = b.bs.a(var1.b(), var1.c(), var1.f(), b);
				if (class_aco.b(var1.e(), var5)) {
					b.a.a((new class_gb(var1.a(), var1.d(), true)));
					b.g = true;
					b.bs.b();
					b.p();
					b.g = false;
				} else {
					n.a(b.bs.d, Short.valueOf(var1.d()));
					b.a.a((new class_gb(var1.a(), var1.d(), false)));
					b.bs.a(b, false);
					ArrayList var6 = Lists.newArrayList();

					for (int var4 = 0; var4 < b.bs.c.size(); ++var4) {
						var6.add(((class_aas) b.bs.c.get(var4)).d());
					}

					b.a(b.bs, var6);
				}
			}
		}

	}

	@Override
	public void a(class_ik var1) {
		class_fh.a(var1, this, b.v());
		b.A();
		if ((b.bs.d == var1.a()) && b.bs.c(b) && !b.w()) {
			b.bs.a(b, var1.b());
			b.bs.b();
		}

	}

	@Override
	public void a(class_ix var1) {
		class_fh.a(var1, this, b.v());
		if (b.c.d()) {
			boolean var2 = var1.a() < 0;
			class_aco var3 = var1.b();
			if ((var3 != null) && var3.n() && var3.o().b("BlockEntityTag", 10)) {
				class_dn var4 = var3.o().o("BlockEntityTag");
				if (var4.e("x") && var4.e("y") && var4.e("z")) {
					class_cj var5 = new class_cj(var4.h("x"), var4.h("y"), var4.h("z"));
					TileEntity var6 = b.o.s(var5);
					if (var6 != null) {
						class_dn var7 = new class_dn();
						var6.b(var7);
						var7.q("x");
						var7.q("y");
						var7.q("z");
						var3.a("BlockEntityTag", var7);
					}
				}
			}

			boolean var8 = (var1.a() >= 1) && (var1.a() <= 45);
			boolean var9 = (var3 == null) || (var3.b() != null);
			boolean var10 = (var3 == null) || ((var3.i() >= 0) && (var3.b <= 64) && (var3.b > 0));
			if (var8 && var9 && var10) {
				if (var3 == null) {
					b.br.a(var1.a(), (class_aco) null);
				} else {
					b.br.a(var1.a(), var3);
				}

				b.br.a(b, true);
			} else if (var2 && var9 && var10 && (m < 200)) {
				m += 20;
				class_xg var11 = b.a(var3, true);
				if (var11 != null) {
					var11.i();
				}
			}
		}

	}

	@Override
	public void a(class_ij var1) {
		class_fh.a(var1, this, b.v());
		Short var2 = (Short) n.a(b.bs.d);
		if ((var2 != null) && (var1.b() == var2.shortValue()) && (b.bs.d == var1.a()) && !b.bs.c(b) && !b.w()) {
			b.bs.a(b, true);
		}

	}

	@Override
	public void a(class_iy var1) {
		class_fh.a(var1, this, b.v());
		b.A();
		class_ll var2 = d.a(b.am);
		class_cj var3 = var1.a();
		if (var2.e(var3)) {
			TileEntity var4 = var2.s(var3);
			if (!(var4 instanceof class_aoz)) {
				return;
			}

			class_aoz var5 = (class_aoz) var4;
			if (!var5.b() || (var5.c() != b)) {
				d.f("Player " + b.e_() + " just tried to change non-editable sign");
				return;
			}

			class_eu[] var6 = var1.b();

			for (int var7 = 0; var7 < var6.length; ++var7) {
				var5.a[var7] = new class_fa(EnumChatFormat.stripFormat(var6[var7].c()));
			}

			var5.o_();
			var2.h(var3);
		}

	}

	@Override
	public void a(class_ip var1) {
		if (var1.a() == i) {
			int var2 = (int) (this.d() - j);
			b.h = ((b.h * 3) + var2) / 4;
		}

	}

	private long d() {
		return System.nanoTime() / 1000000L;
	}

	@Override
	public void a(class_ir var1) {
		class_fh.a(var1, this, b.v());
		b.bI.b = var1.b() && b.bI.c;
	}

	@Override
	public void a(class_ie var1) {
		class_fh.a(var1, this, b.v());
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = d.a(b, var1.a(), var1.b(), var1.c()).iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			var2.add(var4);
		}

		b.a.a((new class_fy((String[]) var2.toArray(new String[var2.size()]))));
	}

	@Override
	public void a(class_ii var1) {
		class_fh.a(var1, this, b.v());
		b.a(var1);
	}

	@Override
	public void a(class_in var1) {
		class_fh.a(var1, this, b.v());
		PacketDataSerializer var2;
		class_aco var97;
		class_aco var105;
		if ("MC|BEdit".equals(var1.a())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer(var1.b()));

			try {
				var97 = var2.k();
				if (var97 == null) {
					return;
				}

				if (!class_aea.b(var97.o())) {
					throw new IOException("Invalid book tag!");
				}

				var105 = b.bG();
				if (var105 == null) {
					return;
				}

				if ((var97.b() == Items.bR) && (var97.b() == var105.b())) {
					var105.a("pages", var97.o().c("pages", 8));
				}
			} catch (Exception var85) {
				c.error("Couldn\'t handle book info", var85);
			} finally {
				var2.release();
			}
		} else if ("MC|BSign".equals(var1.a())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer(var1.b()));

			try {
				var97 = var2.k();
				if (var97 == null) {
					return;
				}

				if (!class_aeb.b(var97.o())) {
					throw new IOException("Invalid book tag!");
				}

				var105 = b.bG();
				if (var105 == null) {
					return;
				}

				if ((var97.b() == Items.bS) && (var105.b() == Items.bR)) {
					var105.a("author", (new class_ea(b.e_())));
					var105.a("title", (new class_ea(var97.o().l("title"))));
					var105.a("pages", var97.o().c("pages", 8));
					var105.a(Items.bS);
				}
			} catch (Exception var83) {
				c.error("Couldn\'t sign book", var83);
			} finally {
				var2.release();
			}
		} else if ("MC|TrSel".equals(var1.a())) {
			try {
				int var88 = var1.b().readInt();
				class_zu var94 = b.bs;
				if (var94 instanceof class_aan) {
					((class_aan) var94).d(var88);
				}
			} catch (Exception var82) {
				c.error("Couldn\'t select trade", var82);
			}
		} else if ("MC|AdvCmd".equals(var1.a())) {
			if (!d.an()) {
				b.a((new class_fb("advMode.notEnabled", new Object[0])));
				return;
			}

			if (!b.a(2, "") || !b.bI.d) {
				b.a((new class_fb("advMode.notAllowed", new Object[0])));
				return;
			}

			var2 = var1.b();

			try {
				byte var92 = var2.readByte();
				class_age var98 = null;
				if (var92 == 0) {
					TileEntity var100 = b.o.s(new class_cj(var2.readInt(), var2.readInt(), var2.readInt()));
					if (var100 instanceof class_aol) {
						var98 = ((class_aol) var100).b();
					}
				} else if (var92 == 1) {
					Entity var102 = b.o.a(var2.readInt());
					if (var102 instanceof class_xj) {
						var98 = ((class_xj) var102).i();
					}
				}

				String var103 = var2.c(var2.readableBytes());
				boolean var106 = var2.readBoolean();
				if (var98 != null) {
					var98.a(var103);
					var98.a(var106);
					if (!var106) {
						var98.b((class_eu) null);
					}

					var98.h();
					b.a((new class_fb("advMode.setCommand.success", new Object[] { var103 })));
				}
			} catch (Exception var80) {
				c.error("Couldn\'t set command block", var80);
			} finally {
				var2.release();
			}
		} else {
			String var7;
			if ("MC|AutoCmd".equals(var1.a())) {
				if (!d.an()) {
					b.a((new class_fb("advMode.notEnabled", new Object[0])));
					return;
				}

				if (!b.a(2, "") || !b.bI.d) {
					b.a((new class_fb("advMode.notAllowed", new Object[0])));
					return;
				}

				var2 = var1.b();

				try {
					class_age var3 = null;
					class_aol var4 = null;
					class_cj var5 = new class_cj(var2.readInt(), var2.readInt(), var2.readInt());
					TileEntity var6 = b.o.s(var5);
					if (var6 instanceof class_aol) {
						var4 = (class_aol) var6;
						var3 = var4.b();
					}

					var7 = var2.c(var2.readableBytes());
					boolean var8 = var2.readBoolean();
					class_aol.class_a_in_class_aol var9 = class_aol.class_a_in_class_aol.valueOf(var2.c(16));
					boolean var10 = var2.readBoolean();
					if (var3 != null) {
						class_cq var11 = (class_cq) b.o.p(var5).b(class_ajc.a);
						class_apn var12;
						switch (class_lt.SyntheticClass_1.d[var9.ordinal()]) {
							case 1:
								var12 = Blocks.dd.S();
								b.o.a(var5, var12.a(class_ajc.a, var11), 2);
								break;
							case 2:
								var12 = Blocks.dc.S();
								b.o.a(var5, var12.a(class_ajc.a, var11), 2);
								break;
							case 3:
								var12 = Blocks.bX.S();
								b.o.a(var5, var12.a(class_ajc.a, var11), 2);
						}

						var6.D();
						b.o.a(var5, var6);
						var3.a(var7);
						var3.a(var8);
						if (!var8) {
							var3.b((class_eu) null);
						}

						var4.b(var10);
						var3.h();
						if (!class_of.b(var7)) {
							b.a((new class_fb("advMode.setCommand.success", new Object[] { var7 })));
						}
					}
				} catch (Exception var78) {
					c.error("Couldn\'t set command block", var78);
				} finally {
					var2.release();
				}
			} else if ("MC|Beacon".equals(var1.a())) {
				if (b.bs instanceof class_zx) {
					try {
						var2 = var1.b();
						int var89 = var2.readInt();
						int var93 = var2.readInt();
						class_zx var95 = (class_zx) b.bs;
						class_aas var101 = var95.a(0);
						if (var101.e()) {
							var101.a(1);
							class_pp var107 = var95.e();
							var107.b(1, var89);
							var107.b(2, var93);
							var107.o_();
						}
					} catch (Exception var77) {
						c.error("Couldn\'t set beacon", var77);
					}
				}
			} else if ("MC|ItemName".equals(var1.a())) {
				if (b.bs instanceof class_zw) {
					class_zw var87 = (class_zw) b.bs;
					if ((var1.b() != null) && (var1.b().readableBytes() >= 1)) {
						String var90 = class_f.a(var1.b().c(32767));
						if (var90.length() <= 30) {
							var87.a(var90);
						}
					} else {
						var87.a("");
					}
				}
			} else if ("MC|Struct".equals(var1.a())) {
				var2 = var1.b();

				try {
					if (b.a(4, "") && b.bI.d) {
						class_cj var91 = new class_cj(var2.readInt(), var2.readInt(), var2.readInt());
						TileEntity var96 = b.o.s(var91);
						if (var96 instanceof class_apb) {
							class_apb var99 = (class_apb) var96;
							byte var104 = var2.readByte();
							var7 = var2.c(32);
							var99.a(class_apb.class_a_in_class_apb.valueOf(var7));
							var99.a(var2.c(64));
							var99.b(new class_cj(var2.readInt(), var2.readInt(), var2.readInt()));
							var99.c(new class_cj(var2.readInt(), var2.readInt(), var2.readInt()));
							String var108 = var2.c(32);
							var99.a(Block.class_a_in_class_ail.valueOf(var108));
							String var109 = var2.c(32);
							var99.a(Block.class_c_in_class_ail.valueOf(var109));
							var99.b(var2.c(128));
							var99.a(var2.readBoolean());
							if (var104 == 2) {
								if (var99.m()) {
									b.b((new class_fa("Structure saved")));
								} else {
									b.b((new class_fa("Structure NOT saved")));
								}
							} else if (var104 == 3) {
								if (var99.n()) {
									b.b((new class_fa("Structure loaded")));
								} else {
									b.b((new class_fa("Structure prepared")));
								}
							} else if ((var104 == 4) && var99.l()) {
								b.b((new class_fa("Size detected")));
							}

							var99.o_();
							b.o.h(var91);
						}
					}
				} catch (Exception var75) {
					c.error("Couldn\'t set structure block", var75);
				} finally {
					var2.release();
				}
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
		static final int[] c;
		// $FF: synthetic field
		static final int[] d = new int[class_aol.class_a_in_class_aol.values().length];

		static {
			try {
				d[class_aol.class_a_in_class_aol.a.ordinal()] = 1;
			} catch (NoSuchFieldError var20) {
				;
			}

			try {
				d[class_aol.class_a_in_class_aol.b.ordinal()] = 2;
			} catch (NoSuchFieldError var19) {
				;
			}

			try {
				d[class_aol.class_a_in_class_aol.c.ordinal()] = 3;
			} catch (NoSuchFieldError var18) {
				;
			}

			c = new int[class_ih.class_a_in_class_ih.values().length];

			try {
				c[class_ih.class_a_in_class_ih.a.ordinal()] = 1;
			} catch (NoSuchFieldError var17) {
				;
			}

			try {
				c[class_ih.class_a_in_class_ih.b.ordinal()] = 2;
			} catch (NoSuchFieldError var16) {
				;
			}

			try {
				c[class_ih.class_a_in_class_ih.c.ordinal()] = 3;
			} catch (NoSuchFieldError var15) {
				;
			}

			b = new int[class_it.class_a_in_class_it.values().length];

			try {
				b[class_it.class_a_in_class_it.a.ordinal()] = 1;
			} catch (NoSuchFieldError var14) {
				;
			}

			try {
				b[class_it.class_a_in_class_it.b.ordinal()] = 2;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[class_it.class_a_in_class_it.d.ordinal()] = 3;
			} catch (NoSuchFieldError var12) {
				;
			}

			try {
				b[class_it.class_a_in_class_it.e.ordinal()] = 4;
			} catch (NoSuchFieldError var11) {
				;
			}

			try {
				b[class_it.class_a_in_class_it.c.ordinal()] = 5;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				b[class_it.class_a_in_class_it.f.ordinal()] = 6;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				b[class_it.class_a_in_class_it.g.ordinal()] = 7;
			} catch (NoSuchFieldError var8) {
				;
			}

			a = new int[class_is.class_a_in_class_is.values().length];

			try {
				a[class_is.class_a_in_class_is.g.ordinal()] = 1;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				a[class_is.class_a_in_class_is.e.ordinal()] = 2;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_is.class_a_in_class_is.d.ordinal()] = 3;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_is.class_a_in_class_is.f.ordinal()] = 4;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_is.class_a_in_class_is.a.ordinal()] = 5;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_is.class_a_in_class_is.b.ordinal()] = 6;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_is.class_a_in_class_is.c.ordinal()] = 7;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
