package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_aru implements class_aqk {
	private Random f;
	private class_avg g;
	private class_avg h;
	private class_avg i;
	public class_avg a;
	public class_avg b;
	private class_ago j;
	private class_aub k = new class_aub(this);
	private class_avk l;
	private double[] m;
	private class_ahb[] n;
	double[] c;
	double[] d;
	double[] e;
	private class_asn o = new class_asn();

	public class_aru(class_ago var1, long var2) {
		j = var1;
		f = new Random(var2);
		g = new class_avg(f, 16);
		h = new class_avg(f, 16);
		i = new class_avg(f, 8);
		a = new class_avg(f, 10);
		b = new class_avg(f, 16);
		l = new class_avk(f);
	}

	public void a(int var1, int var2, class_arl var3) {
		byte var4 = 2;
		int var5 = var4 + 1;
		byte var6 = 33;
		int var7 = var4 + 1;
		m = this.a(m, var1 * var4, 0, var2 * var4, var5, var6, var7);

		for (int var8 = 0; var8 < var4; ++var8) {
			for (int var9 = 0; var9 < var4; ++var9) {
				for (int var10 = 0; var10 < 32; ++var10) {
					double var11 = 0.25D;
					double var13 = m[((((var8 + 0) * var7) + var9 + 0) * var6) + var10 + 0];
					double var15 = m[((((var8 + 0) * var7) + var9 + 1) * var6) + var10 + 0];
					double var17 = m[((((var8 + 1) * var7) + var9 + 0) * var6) + var10 + 0];
					double var19 = m[((((var8 + 1) * var7) + var9 + 1) * var6) + var10 + 0];
					double var21 = (m[((((var8 + 0) * var7) + var9 + 0) * var6) + var10 + 1] - var13) * var11;
					double var23 = (m[((((var8 + 0) * var7) + var9 + 1) * var6) + var10 + 1] - var15) * var11;
					double var25 = (m[((((var8 + 1) * var7) + var9 + 0) * var6) + var10 + 1] - var17) * var11;
					double var27 = (m[((((var8 + 1) * var7) + var9 + 1) * var6) + var10 + 1] - var19) * var11;

					for (int var29 = 0; var29 < 4; ++var29) {
						double var30 = 0.125D;
						double var32 = var13;
						double var34 = var15;
						double var36 = (var17 - var13) * var30;
						double var38 = (var19 - var15) * var30;

						for (int var40 = 0; var40 < 8; ++var40) {
							double var41 = 0.125D;
							double var43 = var32;
							double var45 = (var34 - var32) * var41;

							for (int var47 = 0; var47 < 8; ++var47) {
								class_apn var48 = null;
								if (var43 > 0.0D) {
									var48 = Blocks.END_STONE.S();
								}

								int var49 = var40 + (var8 * 8);
								int var50 = var29 + (var10 * 4);
								int var51 = var47 + (var9 * 8);
								var3.a(var49, var50, var51, var48);
								var43 += var45;
							}

							var32 += var36;
							var34 += var38;
						}

						var13 += var21;
						var15 += var23;
						var17 += var25;
						var19 += var27;
					}
				}
			}
		}

	}

	public void a(class_arl var1) {
		for (int var2 = 0; var2 < 16; ++var2) {
			for (int var3 = 0; var3 < 16; ++var3) {
				byte var4 = 1;
				int var5 = -1;
				class_apn var6 = Blocks.END_STONE.S();
				class_apn var7 = Blocks.END_STONE.S();

				for (int var8 = 127; var8 >= 0; --var8) {
					class_apn var9 = var1.a(var2, var8, var3);
					if (var9.c().v() == class_avq.a) {
						var5 = -1;
					} else if (var9.c() == Blocks.STONE) {
						if (var5 == -1) {
							if (var4 <= 0) {
								var6 = Blocks.AIR.S();
								var7 = Blocks.END_STONE.S();
							}

							var5 = var4;
							if (var8 >= 0) {
								var1.a(var2, var8, var3, var6);
							} else {
								var1.a(var2, var8, var3, var7);
							}
						} else if (var5 > 0) {
							--var5;
							var1.a(var2, var8, var3, var7);
						}
					}
				}
			}
		}

	}

	@Override
	public class_aqn d(int var1, int var2) {
		f.setSeed((var1 * 341873128712L) + (var2 * 132897987541L));
		class_arl var3 = new class_arl();
		n = j.y().b(n, var1 * 16, var2 * 16, 16, 16);
		this.a(var1, var2, var3);
		this.a(var3);
		k.a(this, j, var1, var2, var3);
		class_aqn var4 = new class_aqn(j, var3, var1, var2);
		byte[] var5 = var4.l();

		for (int var6 = 0; var6 < var5.length; ++var6) {
			var5[var6] = (byte) n[var6].az;
		}

		var4.b();
		return var4;
	}

	private float a(int var1, int var2, int var3, int var4) {
		float var5 = (var1 * 2) + var3;
		float var6 = (var2 * 2) + var4;
		float var7 = 100.0F - (MathHelper.c((var5 * var5) + (var6 * var6)) * 8.0F);
		if (var7 > 80.0F) {
			var7 = 80.0F;
		}

		if (var7 < -100.0F) {
			var7 = -100.0F;
		}

		for (int var8 = -12; var8 <= 12; ++var8) {
			for (int var9 = -12; var9 <= 12; ++var9) {
				int var10 = var1 + var8;
				int var11 = var2 + var9;
				if ((((var10 * var10) + (var11 * var11)) > 4096) && (l.a(var10, var11) < -0.8999999761581421D)) {
					float var12 = (((MathHelper.a(var10) * 3439) + (MathHelper.a(var11) * 147)) % 13) + 9;
					var5 = var3 - (var8 * 2);
					var6 = var4 - (var9 * 2);
					float var13 = 100.0F - (MathHelper.c((var5 * var5) + (var6 * var6)) * var12);
					if (var13 > 80.0F) {
						var13 = 80.0F;
					}

					if (var13 < -100.0F) {
						var13 = -100.0F;
					}

					if (var13 > var7) {
						var7 = var13;
					}
				}
			}
		}

		return var7;
	}

	public boolean b(int var1, int var2) {
		return (((var1 * var1) + (var2 * var2)) > 4096) && (this.a(var1, var2, 1, 1) >= 0.0F);
	}

	private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var1 == null) {
			var1 = new double[var5 * var6 * var7];
		}

		double var8 = 684.412D;
		double var10 = 684.412D;
		var8 *= 2.0D;
		c = i.a(c, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
		d = g.a(d, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		e = h.a(e, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		int var12 = var2 / 2;
		int var13 = var4 / 2;
		int var14 = 0;

		for (int var15 = 0; var15 < var5; ++var15) {
			for (int var16 = 0; var16 < var7; ++var16) {
				float var17 = this.a(var12, var13, var15, var16);

				for (int var18 = 0; var18 < var6; ++var18) {
					double var19 = 0.0D;
					double var21 = d[var14] / 512.0D;
					double var23 = e[var14] / 512.0D;
					double var25 = ((c[var14] / 10.0D) + 1.0D) / 2.0D;
					if (var25 < 0.0D) {
						var19 = var21;
					} else if (var25 > 1.0D) {
						var19 = var23;
					} else {
						var19 = var21 + ((var23 - var21) * var25);
					}

					var19 -= 8.0D;
					var19 += var17;
					byte var27 = 2;
					double var28;
					if (var18 > ((var6 / 2) - var27)) {
						var28 = (var18 - ((var6 / 2) - var27)) / 64.0F;
						var28 = MathHelper.a(var28, 0.0D, 1.0D);
						var19 = (var19 * (1.0D - var28)) + (-3000.0D * var28);
					}

					var27 = 8;
					if (var18 < var27) {
						var28 = (var27 - var18) / (var27 - 1.0F);
						var19 = (var19 * (1.0D - var28)) + (-30.0D * var28);
					}

					var1[var14] = var19;
					++var14;
				}
			}
		}

		return var1;
	}

	@Override
	public boolean a(int var1, int var2) {
		return true;
	}

	@Override
	public void a(class_aqk var1, int var2, int var3) {
		class_ajz.N = true;
		class_cj var4 = new class_cj(var2 * 16, 0, var3 * 16);
		k.a(j, f, new class_agi(var2, var3));
		j.b(var4.a(16, 0, 16)).a(j, j.s, var4);
		if (((var2 * var2) + (var3 * var3)) > 4096) {
			float var5 = this.a(var2, var3, 1, 1);
			if ((var5 < -20.0F) && (f.nextInt(14) == 0)) {
				o.b(j, f, var4.a(f.nextInt(16) + 8, 55 + f.nextInt(16), f.nextInt(16) + 8));
				if (f.nextInt(4) == 0) {
					o.b(j, f, var4.a(f.nextInt(16) + 8, 55 + f.nextInt(16), f.nextInt(16) + 8));
				}
			}

			int var6 = f.nextInt(5);

			for (int var7 = 0; var7 < var6; ++var7) {
				int var8 = f.nextInt(16) + 8;
				int var9 = f.nextInt(16) + 8;
				int var10 = j.m(var4.a(var8, 0, var9)).o();
				if (var10 > 0) {
					int var11 = var10 - 1;
					if (j.d(var4.a(var8, var11 + 1, var9)) && (j.p(var4.a(var8, var11, var9)).c() == Blocks.END_STONE)) {
						class_aix.a(j, var4.a(var8, var11 + 1, var9), f, 8);
					}
				}
			}
		}

		class_ajz.N = false;
	}

	@Override
	public boolean a(class_aqk var1, class_aqn var2, int var3, int var4) {
		return false;
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
		return j.b(var2).a(var1);
	}

	@Override
	public class_cj a(class_ago var1, String var2, class_cj var3) {
		return null;
	}

	@Override
	public int g() {
		return 0;
	}

	@Override
	public void a(class_aqn var1, int var2, int var3) {
	}

	@Override
	public class_aqn a(class_cj var1) {
		return this.d(var1.n() >> 4, var1.p() >> 4);
	}
}
