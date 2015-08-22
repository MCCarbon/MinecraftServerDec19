package net.minecraft.server;

import java.util.Arrays;
import java.util.List;

public class class_wy extends class_qx {
	private static final List d;
	private static final List e;
	private static final List f;
	private int g = -1;
	private int h = -1;
	private int i = -1;
	private class_ail as;
	private boolean at;
	public int a;
	public class_yu b;
	private int au;
	private int av;
	private int aw;
	private int ax;
	private int ay;
	private float az;
	public class_qx c;
	private int aA;
	private double aB;
	private double aC;
	private double aD;
	private double aE;
	private double aF;

	public static List i() {
		return f;
	}

	public class_wy(class_ago var1) {
		super(var1);
		this.a(0.25F, 0.25F);
		ah = true;
	}

	public class_wy(class_ago var1, class_yu var2) {
		super(var1);
		ah = true;
		b = var2;
		b.bO = this;
		this.a(0.25F, 0.25F);
		this.b(var2.s, var2.t + var2.aY(), var2.u, var2.y, var2.z);
		s -= class_oa.b((y / 180.0F) * 3.1415927F) * 0.16F;
		t -= 0.10000000149011612D;
		u -= class_oa.a((y / 180.0F) * 3.1415927F) * 0.16F;
		this.b(s, t, u);
		float var3 = 0.4F;
		v = -class_oa.a((y / 180.0F) * 3.1415927F) * class_oa.b((z / 180.0F) * 3.1415927F) * var3;
		x = class_oa.b((y / 180.0F) * 3.1415927F) * class_oa.b((z / 180.0F) * 3.1415927F) * var3;
		w = -class_oa.a((z / 180.0F) * 3.1415927F) * var3;
		this.c(v, w, x, 1.5F, 1.0F);
	}

	@Override
	protected void h() {
	}

	public void c(double var1, double var3, double var5, float var7, float var8) {
		float var9 = class_oa.a((var1 * var1) + (var3 * var3) + (var5 * var5));
		var1 /= var9;
		var3 /= var9;
		var5 /= var9;
		var1 += V.nextGaussian() * 0.007499999832361937D * var8;
		var3 += V.nextGaussian() * 0.007499999832361937D * var8;
		var5 += V.nextGaussian() * 0.007499999832361937D * var8;
		var1 *= var7;
		var3 *= var7;
		var5 *= var7;
		v = var1;
		w = var3;
		x = var5;
		float var10 = class_oa.a((var1 * var1) + (var5 * var5));
		A = y = (float) ((class_oa.b(var1, var5) * 180.0D) / 3.1415927410125732D);
		B = z = (float) ((class_oa.b(var3, var10) * 180.0D) / 3.1415927410125732D);
		au = 0;
	}

	@Override
	public void r_() {
		super.r_();
		if (aA > 0) {
			double var29 = s + ((aB - s) / aA);
			double var30 = t + ((aC - t) / aA);
			double var31 = u + ((aD - u) / aA);
			double var7 = class_oa.g(aE - y);
			y = (float) (y + (var7 / aA));
			z = (float) (z + ((aF - z) / aA));
			--aA;
			this.b(var29, var30, var31);
			this.b(y, z);
		} else {
			if (!o.D) {
				class_aco var1 = b.bG();
				if (b.I || !b.al() || (var1 == null) || (var1.b() != class_acq.aT) || (this.h(b) > 1024.0D)) {
					L();
					b.bO = null;
					return;
				}

				if (c != null) {
					if (!c.I) {
						s = c.s;
						double var10002 = c.K;
						t = c.aX().b + (var10002 * 0.8D);
						u = c.u;
						return;
					}

					c = null;
				}
			}

			if (a > 0) {
				--a;
			}

			if (at) {
				if (o.p(new class_cj(g, h, i)).c() == as) {
					++au;
					if (au == 1200) {
						L();
					}

					return;
				}

				at = false;
				v *= V.nextFloat() * 0.2F;
				w *= V.nextFloat() * 0.2F;
				x *= V.nextFloat() * 0.2F;
				au = 0;
				av = 0;
			} else {
				++av;
			}

			class_aym var28 = new class_aym(s, t, u);
			class_aym var2 = new class_aym(s + v, t + w, u + x);
			class_ayl var3 = o.a(var28, var2);
			var28 = new class_aym(s, t, u);
			var2 = new class_aym(s + v, t + w, u + x);
			if (var3 != null) {
				var2 = new class_aym(var3.c.a, var3.c.b, var3.c.c);
			}

			class_qx var4 = null;
			List var5 = o.b(this, aX().a(v, w, x).b(1.0D, 1.0D, 1.0D));
			double var6 = 0.0D;

			double var13;
			for (int var8 = 0; var8 < var5.size(); ++var8) {
				class_qx var9 = (class_qx) var5.get(var8);
				if (var9.ag() && ((var9 != b) || (av >= 5))) {
					float var10 = 0.3F;
					class_ayk var11 = var9.aX().b(var10, var10, var10);
					class_ayl var12 = var11.a(var28, var2);
					if (var12 != null) {
						var13 = var28.g(var12.c);
						if ((var13 < var6) || (var6 == 0.0D)) {
							var4 = var9;
							var6 = var13;
						}
					}
				}
			}

			if (var4 != null) {
				var3 = new class_ayl(var4);
			}

			if (var3 != null) {
				if (var3.d != null) {
					if (var3.d.a(class_qi.a((class_qx) this, (class_qx) b), 0.0F)) {
						c = var3.d;
					}
				} else {
					at = true;
				}
			}

			if (!at) {
				this.d(v, w, x);
				float var32 = class_oa.a((v * v) + (x * x));
				y = (float) ((class_oa.b(v, x) * 180.0D) / 3.1415927410125732D);

				for (z = (float) ((class_oa.b(w, var32) * 180.0D) / 3.1415927410125732D); (z - B) < -180.0F; B -= 360.0F) {
					;
				}

				while ((z - B) >= 180.0F) {
					B += 360.0F;
				}

				while ((y - A) < -180.0F) {
					A -= 360.0F;
				}

				while ((y - A) >= 180.0F) {
					A += 360.0F;
				}

				z = B + ((z - B) * 0.2F);
				y = A + ((y - A) * 0.2F);
				float var33 = 0.92F;
				if (C || D) {
					var33 = 0.5F;
				}

				byte var34 = 5;
				double var35 = 0.0D;

				double var19;
				for (int var36 = 0; var36 < var34; ++var36) {
					class_ayk var14 = aX();
					double var15 = var14.e - var14.b;
					double var17 = var14.b + ((var15 * var36) / var34);
					var19 = var14.b + ((var15 * (var36 + 1)) / var34);
					class_ayk var21 = new class_ayk(var14.a, var17, var14.c, var14.d, var19, var14.f);
					if (o.b(var21, class_avq.h)) {
						var35 += 1.0D / var34;
					}
				}

				if (!o.D && (var35 > 0.0D)) {
					class_ll var37 = (class_ll) o;
					int var38 = 1;
					class_cj var39 = (new class_cj(this)).a();
					if ((V.nextFloat() < 0.25F) && o.C(var39)) {
						var38 = 2;
					}

					if ((V.nextFloat() < 0.5F) && !o.i(var39)) {
						--var38;
					}

					if (aw > 0) {
						--aw;
						if (aw <= 0) {
							ax = 0;
							ay = 0;
						}
					} else {
						float var16;
						float var18;
						double var23;
						class_ail var25;
						float var40;
						double var41;
						if (ay > 0) {
							ay -= var38;
							if (ay <= 0) {
								w -= 0.20000000298023224D;
								this.a("random.splash", 0.25F, 1.0F + ((V.nextFloat() - V.nextFloat()) * 0.4F));
								var16 = class_oa.c(aX().b);
								var37.a(class_cy.e, s, var16 + 1.0F, u, (int) (1.0F + (J * 20.0F)), J, 0.0D, J, 0.20000000298023224D, new int[0]);
								var37.a(class_cy.g, s, var16 + 1.0F, u, (int) (1.0F + (J * 20.0F)), J, 0.0D, J, 0.20000000298023224D, new int[0]);
								aw = class_oa.a(V, 10, 30);
							} else {
								az = (float) (az + (V.nextGaussian() * 4.0D));
								var16 = az * 0.017453292F;
								var40 = class_oa.a(var16);
								var18 = class_oa.b(var16);
								var19 = s + var40 * ay * 0.1F;
								var41 = class_oa.c(aX().b) + 1.0F;
								var23 = u + var18 * ay * 0.1F;
								var25 = var37.p(new class_cj((int) var19, (int) var41 - 1, (int) var23)).c();
								if ((var25 == class_aim.j) || (var25 == class_aim.i)) {
									if (V.nextFloat() < 0.15F) {
										var37.a(class_cy.e, var19, var41 - 0.10000000149011612D, var23, 1, var40, 0.1D, var18, 0.0D, new int[0]);
									}

									float var26 = var40 * 0.04F;
									float var27 = var18 * 0.04F;
									var37.a(class_cy.g, var19, var41, var23, 0, var27, 0.01D, (-var26), 1.0D, new int[0]);
									var37.a(class_cy.g, var19, var41, var23, 0, (-var27), 0.01D, var26, 1.0D, new int[0]);
								}
							}
						} else if (ax > 0) {
							ax -= var38;
							var16 = 0.15F;
							if (ax < 20) {
								var16 = (float) (var16 + ((20 - ax) * 0.05D));
							} else if (ax < 40) {
								var16 = (float) (var16 + ((40 - ax) * 0.02D));
							} else if (ax < 60) {
								var16 = (float) (var16 + ((60 - ax) * 0.01D));
							}

							if (V.nextFloat() < var16) {
								var40 = class_oa.a(V, 0.0F, 360.0F) * 0.017453292F;
								var18 = class_oa.a(V, 25.0F, 60.0F);
								var19 = s + class_oa.a(var40) * var18 * 0.1F;
								var41 = class_oa.c(aX().b) + 1.0F;
								var23 = u + class_oa.b(var40) * var18 * 0.1F;
								var25 = var37.p(new class_cj((int) var19, (int) var41 - 1, (int) var23)).c();
								if ((var25 == class_aim.j) || (var25 == class_aim.i)) {
									var37.a(class_cy.f, var19, var41, var23, 2 + V.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D, new int[0]);
								}
							}

							if (ax <= 0) {
								az = class_oa.a(V, 0.0F, 360.0F);
								ay = class_oa.a(V, 20, 80);
							}
						} else {
							ax = class_oa.a(V, 100, 900);
							ax -= class_afl.g(b) * 20 * 5;
						}
					}

					if (aw > 0) {
						w -= V.nextFloat() * V.nextFloat() * V.nextFloat() * 0.2D;
					}
				}

				var13 = (var35 * 2.0D) - 1.0D;
				w += 0.03999999910593033D * var13;
				if (var35 > 0.0D) {
					var33 = (float) (var33 * 0.9D);
					w *= 0.8D;
				}

				v *= var33;
				w *= var33;
				x *= var33;
				this.b(s, t, u);
			}
		}
	}

	@Override
	public void b(class_dn var1) {
		var1.a("xTile", g);
		var1.a("yTile", h);
		var1.a("zTile", i);
		class_ke var2 = (class_ke) class_ail.c.b(as);
		var1.a("inTile", var2 == null ? "" : var2.toString());
		var1.a("shake", (byte) a);
		var1.a("inGround", (byte) (at ? 1 : 0));
	}

	@Override
	public void a(class_dn var1) {
		g = var1.h("xTile");
		h = var1.h("yTile");
		i = var1.h("zTile");
		if (var1.b("inTile", 8)) {
			as = class_ail.b(var1.l("inTile"));
		} else {
			as = class_ail.c(var1.f("inTile") & 255);
		}

		a = var1.f("shake") & 255;
		at = var1.f("inGround") == 1;
	}

	public int j() {
		if (o.D) {
			return 0;
		} else {
			byte var1 = 0;
			if (c != null) {
				double var2 = b.s - s;
				double var4 = b.t - t;
				double var6 = b.u - u;
				double var8 = class_oa.a((var2 * var2) + (var4 * var4) + (var6 * var6));
				double var10 = 0.1D;
				c.v += var2 * var10;
				c.w += (var4 * var10) + (class_oa.a(var8) * 0.08D);
				c.x += var6 * var10;
				var1 = 3;
			} else if (aw > 0) {
				class_xg var13 = new class_xg(o, s, t, u, this.k());
				double var3 = b.s - s;
				double var5 = b.t - t;
				double var7 = b.u - u;
				double var9 = class_oa.a((var3 * var3) + (var5 * var5) + (var7 * var7));
				double var11 = 0.1D;
				var13.v = var3 * var11;
				var13.w = (var5 * var11) + (class_oa.a(var9) * 0.08D);
				var13.x = var7 * var11;
				o.a(var13);
				b.o.a((new class_rd(b.o, b.s, b.t + 0.5D, b.u + 0.5D, V.nextInt(6) + 1)));
				var1 = 1;
			}

			if (at) {
				var1 = 2;
			}

			L();
			b.bO = null;
			return var1;
		}
	}

	private class_aco k() {
		float var1 = o.s.nextFloat();
		int var2 = class_afl.f(b);
		int var3 = class_afl.g(b);
		float var4 = 0.1F - (var2 * 0.025F) - (var3 * 0.01F);
		float var5 = (0.05F + (var2 * 0.01F)) - (var3 * 0.01F);
		var4 = class_oa.a(var4, 0.0F, 1.0F);
		var5 = class_oa.a(var5, 0.0F, 1.0F);
		if (var1 < var4) {
			b.b(class_nh.E);
			return ((class_wz) class_oi.a(V, d)).a(V);
		} else {
			var1 -= var4;
			if (var1 < var5) {
				b.b(class_nh.F);
				return ((class_wz) class_oi.a(V, e)).a(V);
			} else {
				float var10000 = var1 - var5;
				b.b(class_nh.D);
				return ((class_wz) class_oi.a(V, f)).a(V);
			}
		}
	}

	@Override
	public void L() {
		super.L();
		if (b != null) {
			b.bO = null;
		}

	}

	static {
		d = Arrays.asList(new class_wz[] { (new class_wz(new class_aco(class_acq.V), 10)).a(0.9F), new class_wz(new class_aco(class_acq.aH), 10), new class_wz(new class_aco(class_acq.aZ), 10), new class_wz(new class_aco(class_acq.bB), 10), new class_wz(new class_aco(class_acq.H), 5), (new class_wz(new class_aco(class_acq.aT), 2)).a(0.9F), new class_wz(new class_aco(class_acq.B), 10), new class_wz(new class_aco(class_acq.A), 5), new class_wz(new class_aco(class_acq.aY, 10, class_abt.p.b()), 1),
				new class_wz(new class_aco(class_aim.bR), 10), new class_wz(new class_aco(class_acq.bv), 10) });
		e = Arrays.asList(new class_wz[] { new class_wz(new class_aco(class_aim.bx), 1), new class_wz(new class_aco(class_acq.ct), 1), new class_wz(new class_aco(class_acq.aC), 1), (new class_wz(new class_aco(class_acq.f), 1)).a(0.25F).a(), (new class_wz(new class_aco(class_acq.aT), 1)).a(0.25F).a(), (new class_wz(new class_aco(class_acq.aN), 1)).a() });
		f = Arrays.asList(new class_wz[] { new class_wz(new class_aco(class_acq.aW, 1, class_acf.class_a_in_class_acf.a.a()), 60), new class_wz(new class_aco(class_acq.aW, 1, class_acf.class_a_in_class_acf.b.a()), 25), new class_wz(new class_aco(class_acq.aW, 1, class_acf.class_a_in_class_acf.c.a()), 2), new class_wz(new class_aco(class_acq.aW, 1, class_acf.class_a_in_class_acf.d.a()), 13) });
	}
}
