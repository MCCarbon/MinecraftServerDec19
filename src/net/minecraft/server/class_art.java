package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_art implements class_aqk {
	private Random h;
	private class_avg i;
	private class_avg j;
	private class_avg k;
	private class_avh l;
	public class_avg a;
	public class_avg b;
	public class_avg c;
	private class_ago m;
	private final boolean n;
	private class_agt o;
	private final double[] p;
	private final float[] q;
	private class_arm r;
	private class_ail s;
	private double[] t;
	private class_arr u;
	private class_aum v;
	private class_auu w;
	private class_aud x;
	private class_auk y;
	private class_arr z;
	private class_aui A;
	private class_ahb[] B;
	double[] d;
	double[] e;
	double[] f;
	double[] g;

	public class_art(class_ago var1, long var2, boolean var4, String var5) {
		s = class_aim.j;
		t = new double[256];
		u = new class_arq();
		v = new class_aum();
		w = new class_auu();
		x = new class_aud();
		y = new class_auk();
		z = new class_ark();
		A = new class_aui();
		m = var1;
		n = var4;
		o = var1.R().t();
		h = new Random(var2);
		i = new class_avg(h, 16);
		j = new class_avg(h, 16);
		k = new class_avg(h, 8);
		l = new class_avh(h, 4);
		a = new class_avg(h, 10);
		b = new class_avg(h, 16);
		c = new class_avg(h, 8);
		p = new double[825];
		q = new float[25];

		for (int var6 = -2; var6 <= 2; ++var6) {
			for (int var7 = -2; var7 <= 2; ++var7) {
				float var8 = 10.0F / class_oa.c((var6 * var6) + (var7 * var7) + 0.2F);
				q[var6 + 2 + ((var7 + 2) * 5)] = var8;
			}
		}

		if (var5 != null) {
			r = class_arm.class_a_in_class_arm.a(var5).b();
			s = r.E ? class_aim.l : class_aim.j;
			var1.b(r.q);
		}

	}

	public void a(int var1, int var2, class_arl var3) {
		B = m.y().a(B, (var1 * 4) - 2, (var2 * 4) - 2, 10, 10);
		this.a(var1 * 4, 0, var2 * 4);

		for (int var4 = 0; var4 < 4; ++var4) {
			int var5 = var4 * 5;
			int var6 = (var4 + 1) * 5;

			for (int var7 = 0; var7 < 4; ++var7) {
				int var8 = (var5 + var7) * 33;
				int var9 = (var5 + var7 + 1) * 33;
				int var10 = (var6 + var7) * 33;
				int var11 = (var6 + var7 + 1) * 33;

				for (int var12 = 0; var12 < 32; ++var12) {
					double var13 = 0.125D;
					double var15 = p[var8 + var12];
					double var17 = p[var9 + var12];
					double var19 = p[var10 + var12];
					double var21 = p[var11 + var12];
					double var23 = (p[var8 + var12 + 1] - var15) * var13;
					double var25 = (p[var9 + var12 + 1] - var17) * var13;
					double var27 = (p[var10 + var12 + 1] - var19) * var13;
					double var29 = (p[var11 + var12 + 1] - var21) * var13;

					for (int var31 = 0; var31 < 8; ++var31) {
						double var32 = 0.25D;
						double var34 = var15;
						double var36 = var17;
						double var38 = (var19 - var15) * var32;
						double var40 = (var21 - var17) * var32;

						for (int var42 = 0; var42 < 4; ++var42) {
							double var43 = 0.25D;
							double var47 = (var36 - var34) * var43;
							double var45 = var34 - var47;

							for (int var49 = 0; var49 < 4; ++var49) {
								if ((var45 += var47) > 0.0D) {
									var3.a((var4 * 4) + var42, (var12 * 8) + var31, (var7 * 4) + var49, class_aim.b.S());
								} else if (((var12 * 8) + var31) < r.q) {
									var3.a((var4 * 4) + var42, (var12 * 8) + var31, (var7 * 4) + var49, s.S());
								}
							}

							var34 += var38;
							var36 += var40;
						}

						var15 += var23;
						var17 += var25;
						var19 += var27;
						var21 += var29;
					}
				}
			}
		}

	}

	public void a(int var1, int var2, class_arl var3, class_ahb[] var4) {
		double var5 = 0.03125D;
		t = l.a(t, var1 * 16, var2 * 16, 16, 16, var5 * 2.0D, var5 * 2.0D, 1.0D);

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				class_ahb var9 = var4[var8 + (var7 * 16)];
				var9.a(m, h, var3, (var1 * 16) + var7, (var2 * 16) + var8, t[var8 + (var7 * 16)]);
			}
		}

	}

	@Override
	public class_aqn d(int var1, int var2) {
		h.setSeed((var1 * 341873128712L) + (var2 * 132897987541L));
		class_arl var3 = new class_arl();
		this.a(var1, var2, var3);
		B = m.y().b(B, var1 * 16, var2 * 16, 16, 16);
		this.a(var1, var2, var3, B);
		if (r.r) {
			u.a(this, m, var1, var2, var3);
		}

		if (r.z) {
			z.a(this, m, var1, var2, var3);
		}

		if (r.w && n) {
			x.a(this, m, var1, var2, var3);
		}

		if (r.v && n) {
			w.a(this, m, var1, var2, var3);
		}

		if (r.u && n) {
			v.a(this, m, var1, var2, var3);
		}

		if (r.x && n) {
			y.a(this, m, var1, var2, var3);
		}

		if (r.y && n) {
			A.a(this, m, var1, var2, var3);
		}

		class_aqn var4 = new class_aqn(m, var3, var1, var2);
		byte[] var5 = var4.l();

		for (int var6 = 0; var6 < var5.length; ++var6) {
			var5[var6] = (byte) B[var6].az;
		}

		var4.b();
		return var4;
	}

	private void a(int var1, int var2, int var3) {
		g = b.a(g, var1, var3, 5, 5, r.e, r.f, r.g);
		float var4 = r.a;
		float var5 = r.b;
		d = k.a(d, var1, var2, var3, 5, 33, 5, var4 / r.h, var5 / r.i, var4 / r.j);
		e = i.a(e, var1, var2, var3, 5, 33, 5, var4, var5, var4);
		f = j.a(f, var1, var2, var3, 5, 33, 5, var4, var5, var4);
		boolean var37 = false;
		boolean var36 = false;
		int var6 = 0;
		int var7 = 0;

		for (int var8 = 0; var8 < 5; ++var8) {
			for (int var9 = 0; var9 < 5; ++var9) {
				float var10 = 0.0F;
				float var11 = 0.0F;
				float var12 = 0.0F;
				byte var13 = 2;
				class_ahb var14 = B[var8 + 2 + ((var9 + 2) * 10)];

				for (int var15 = -var13; var15 <= var13; ++var15) {
					for (int var16 = -var13; var16 <= var13; ++var16) {
						class_ahb var17 = B[var8 + var15 + 2 + ((var9 + var16 + 2) * 10)];
						float var18 = r.n + (var17.an * r.m);
						float var19 = r.p + (var17.ao * r.o);
						if ((o == class_agt.e) && (var18 > 0.0F)) {
							var18 = 1.0F + (var18 * 2.0F);
							var19 = 1.0F + (var19 * 4.0F);
						}

						float var20 = q[var15 + 2 + ((var16 + 2) * 5)] / (var18 + 2.0F);
						if (var17.an > var14.an) {
							var20 /= 2.0F;
						}

						var10 += var19 * var20;
						var11 += var18 * var20;
						var12 += var20;
					}
				}

				var10 /= var12;
				var11 /= var12;
				var10 = (var10 * 0.9F) + 0.1F;
				var11 = ((var11 * 4.0F) - 1.0F) / 8.0F;
				double var38 = g[var7] / 8000.0D;
				if (var38 < 0.0D) {
					var38 = -var38 * 0.3D;
				}

				var38 = (var38 * 3.0D) - 2.0D;
				if (var38 < 0.0D) {
					var38 /= 2.0D;
					if (var38 < -1.0D) {
						var38 = -1.0D;
					}

					var38 /= 1.4D;
					var38 /= 2.0D;
				} else {
					if (var38 > 1.0D) {
						var38 = 1.0D;
					}

					var38 /= 8.0D;
				}

				++var7;
				double var39 = var11;
				double var40 = var10;
				var39 += var38 * 0.2D;
				var39 = (var39 * r.k) / 8.0D;
				double var21 = r.k + (var39 * 4.0D);

				for (int var23 = 0; var23 < 33; ++var23) {
					double var24 = ((var23 - var21) * r.l * 128.0D) / 256.0D / var40;
					if (var24 < 0.0D) {
						var24 *= 4.0D;
					}

					double var26 = e[var6] / r.d;
					double var28 = f[var6] / r.c;
					double var30 = ((d[var6] / 10.0D) + 1.0D) / 2.0D;
					double var32 = class_oa.b(var26, var28, var30) - var24;
					if (var23 > 29) {
						double var34 = (var23 - 29) / 3.0F;
						var32 = (var32 * (1.0D - var34)) + (-10.0D * var34);
					}

					p[var6] = var32;
					++var6;
				}
			}
		}

	}

	@Override
	public boolean a(int var1, int var2) {
		return true;
	}

	@Override
	public void a(class_aqk var1, int var2, int var3) {
		class_ajz.N = true;
		int var4 = var2 * 16;
		int var5 = var3 * 16;
		class_cj var6 = new class_cj(var4, 0, var5);
		class_ahb var7 = m.b(var6.a(16, 0, 16));
		h.setSeed(m.L());
		long var8 = ((h.nextLong() / 2L) * 2L) + 1L;
		long var10 = ((h.nextLong() / 2L) * 2L) + 1L;
		h.setSeed(((var2 * var8) + (var3 * var10)) ^ m.L());
		boolean var12 = false;
		class_agi var13 = new class_agi(var2, var3);
		if (r.w && n) {
			x.a(m, h, var13);
		}

		if (r.v && n) {
			var12 = w.a(m, h, var13);
		}

		if (r.u && n) {
			v.a(m, h, var13);
		}

		if (r.x && n) {
			y.a(m, h, var13);
		}

		if (r.y && n) {
			A.a(m, h, var13);
		}

		int var14;
		int var15;
		int var16;
		if ((var7 != class_ahb.r) && (var7 != class_ahb.G) && r.A && !var12 && (h.nextInt(r.B) == 0)) {
			var14 = h.nextInt(16) + 8;
			var15 = h.nextInt(256);
			var16 = h.nextInt(16) + 8;
			(new class_asy(class_aim.j)).b(m, h, var6.a(var14, var15, var16));
		}

		if (!var12 && (h.nextInt(r.D / 10) == 0) && r.C) {
			var14 = h.nextInt(16) + 8;
			var15 = h.nextInt(h.nextInt(248) + 8);
			var16 = h.nextInt(16) + 8;
			if ((var15 < m.H()) || (h.nextInt(r.D / 8) == 0)) {
				(new class_asy(class_aim.l)).b(m, h, var6.a(var14, var15, var16));
			}
		}

		if (r.s) {
			for (var14 = 0; var14 < r.t; ++var14) {
				var15 = h.nextInt(16) + 8;
				var16 = h.nextInt(256);
				int var17 = h.nextInt(16) + 8;
				(new class_ate()).b(m, h, var6.a(var15, var16, var17));
			}
		}

		var7.a(m, h, new class_cj(var4, 0, var5));
		class_agv.a(m, var7, var4 + 8, var5 + 8, 16, 16, h);
		var6 = var6.a(8, 0, 8);

		for (var14 = 0; var14 < 16; ++var14) {
			for (var15 = 0; var15 < 16; ++var15) {
				class_cj var18 = m.q(var6.a(var14, 0, var15));
				class_cj var19 = var18.b();
				if (m.v(var19)) {
					m.a(var19, class_aim.aI.S(), 2);
				}

				if (m.f(var18, true)) {
					m.a(var18, class_aim.aH.S(), 2);
				}
			}
		}

		class_ajz.N = false;
	}

	@Override
	public boolean a(class_aqk var1, class_aqn var2, int var3, int var4) {
		boolean var5 = false;
		if (r.y && n && (var2.x() < 3600L)) {
			var5 |= A.a(m, h, new class_agi(var3, var4));
		}

		return var5;
	}

	@Override
	public boolean a(boolean var1, class_oc var2) {
		return true;
	}

	@Override
	public void c() {
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean e() {
		return true;
	}

	@Override
	public String f() {
		return "RandomLevelSource";
	}

	@Override
	public List a(class_ri var1, class_cj var2) {
		class_ahb var3 = m.b(var2);
		if (n) {
			if ((var1 == class_ri.a) && y.a(var2)) {
				return y.b();
			}

			if ((var1 == class_ri.a) && r.y && A.a(m, var2)) {
				return A.b();
			}
		}

		return var3.a(var1);
	}

	@Override
	public class_cj a(class_ago var1, String var2, class_cj var3) {
		return "Stronghold".equals(var2) && (v != null) ? v.b(var1, var3) : null;
	}

	@Override
	public int g() {
		return 0;
	}

	@Override
	public void a(class_aqn var1, int var2, int var3) {
		if (r.w && n) {
			x.a(this, m, var2, var3, (class_arl) null);
		}

		if (r.v && n) {
			w.a(this, m, var2, var3, (class_arl) null);
		}

		if (r.u && n) {
			v.a(this, m, var2, var3, (class_arl) null);
		}

		if (r.x && n) {
			y.a(this, m, var2, var3, (class_arl) null);
		}

		if (r.y && n) {
			A.a(this, m, var2, var3, (class_arl) null);
		}

	}

	@Override
	public class_aqn a(class_cj var1) {
		return this.d(var1.n() >> 4, var1.p() >> 4);
	}
}
