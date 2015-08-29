package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_arp implements class_aqk {
	private final class_ago h;
	private final boolean i;
	private final Random j;
	private double[] k = new double[256];
	private double[] l = new double[256];
	private double[] m = new double[256];
	private double[] n;
	private final class_avg o;
	private final class_avg p;
	private final class_avg q;
	private final class_avg r;
	private final class_avg s;
	public final class_avg a;
	public final class_avg b;
	private final class_ass t = new class_ass();
	private final class_asz u = new class_asz();
	private final class_ast v = new class_ast();
	private final class_asp w;
	private final class_asu x;
	private final class_asu y;
	private final class_asf z;
	private final class_asf A;
	private final class_aug B;
	private final class_arr C;
	double[] c;
	double[] d;
	double[] e;
	double[] f;
	double[] g;

	public class_arp(class_ago var1, boolean var2, long var3) {
		w = new class_atf(Blocks.QUARTZ_ORE.getBlockData(), 14, class_apu.a(Blocks.NETHERRACK));
		x = new class_asu(Blocks.FLOWING_LAVA, true);
		y = new class_asu(Blocks.FLOWING_LAVA, false);
		z = new class_asf(Blocks.BROWN_MUSHROOM);
		A = new class_asf(Blocks.RED_MUSHROOM);
		B = new class_aug();
		C = new class_ars();
		h = var1;
		i = var2;
		j = new Random(var3);
		o = new class_avg(j, 16);
		p = new class_avg(j, 16);
		q = new class_avg(j, 8);
		r = new class_avg(j, 4);
		s = new class_avg(j, 4);
		a = new class_avg(j, 10);
		b = new class_avg(j, 16);
		var1.b(63);
	}

	public void a(int var1, int var2, class_arl var3) {
		byte var4 = 4;
		int var5 = (h.H() / 2) + 1;
		int var6 = var4 + 1;
		byte var7 = 17;
		int var8 = var4 + 1;
		n = this.a(n, var1 * var4, 0, var2 * var4, var6, var7, var8);

		for (int var9 = 0; var9 < var4; ++var9) {
			for (int var10 = 0; var10 < var4; ++var10) {
				for (int var11 = 0; var11 < 16; ++var11) {
					double var12 = 0.125D;
					double var14 = n[((((var9 + 0) * var8) + var10 + 0) * var7) + var11 + 0];
					double var16 = n[((((var9 + 0) * var8) + var10 + 1) * var7) + var11 + 0];
					double var18 = n[((((var9 + 1) * var8) + var10 + 0) * var7) + var11 + 0];
					double var20 = n[((((var9 + 1) * var8) + var10 + 1) * var7) + var11 + 0];
					double var22 = (n[((((var9 + 0) * var8) + var10 + 0) * var7) + var11 + 1] - var14) * var12;
					double var24 = (n[((((var9 + 0) * var8) + var10 + 1) * var7) + var11 + 1] - var16) * var12;
					double var26 = (n[((((var9 + 1) * var8) + var10 + 0) * var7) + var11 + 1] - var18) * var12;
					double var28 = (n[((((var9 + 1) * var8) + var10 + 1) * var7) + var11 + 1] - var20) * var12;

					for (int var30 = 0; var30 < 8; ++var30) {
						double var31 = 0.25D;
						double var33 = var14;
						double var35 = var16;
						double var37 = (var18 - var14) * var31;
						double var39 = (var20 - var16) * var31;

						for (int var41 = 0; var41 < 4; ++var41) {
							double var42 = 0.25D;
							double var44 = var33;
							double var46 = (var35 - var33) * var42;

							for (int var48 = 0; var48 < 4; ++var48) {
								class_apn var49 = null;
								if (((var11 * 8) + var30) < var5) {
									var49 = Blocks.LAVA.getBlockData();
								}

								if (var44 > 0.0D) {
									var49 = Blocks.NETHERRACK.getBlockData();
								}

								int var50 = var41 + (var9 * 4);
								int var51 = var30 + (var11 * 8);
								int var52 = var48 + (var10 * 4);
								var3.a(var50, var51, var52, var49);
								var44 += var46;
							}

							var33 += var37;
							var35 += var39;
						}

						var14 += var22;
						var16 += var24;
						var18 += var26;
						var20 += var28;
					}
				}
			}
		}

	}

	public void b(int var1, int var2, class_arl var3) {
		int var4 = h.H() + 1;
		double var5 = 0.03125D;
		k = r.a(k, var1 * 16, var2 * 16, 0, 16, 16, 1, var5, var5, 1.0D);
		l = r.a(l, var1 * 16, 109, var2 * 16, 16, 1, 16, var5, 1.0D, var5);
		m = s.a(m, var1 * 16, var2 * 16, 0, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				boolean var9 = (k[var7 + (var8 * 16)] + (j.nextDouble() * 0.2D)) > 0.0D;
				boolean var10 = (l[var7 + (var8 * 16)] + (j.nextDouble() * 0.2D)) > 0.0D;
				int var11 = (int) ((m[var7 + (var8 * 16)] / 3.0D) + 3.0D + (j.nextDouble() * 0.25D));
				int var12 = -1;
				class_apn var13 = Blocks.NETHERRACK.getBlockData();
				class_apn var14 = Blocks.NETHERRACK.getBlockData();

				for (int var15 = 127; var15 >= 0; --var15) {
					if ((var15 < (127 - j.nextInt(5))) && (var15 > j.nextInt(5))) {
						class_apn var16 = var3.a(var8, var15, var7);
						if ((var16.c() != null) && (var16.c().v() != class_avq.a)) {
							if (var16.c() == Blocks.NETHERRACK) {
								if (var12 == -1) {
									if (var11 <= 0) {
										var13 = null;
										var14 = Blocks.NETHERRACK.getBlockData();
									} else if ((var15 >= (var4 - 4)) && (var15 <= (var4 + 1))) {
										var13 = Blocks.NETHERRACK.getBlockData();
										var14 = Blocks.NETHERRACK.getBlockData();
										if (var10) {
											var13 = Blocks.GRAVEL.getBlockData();
											var14 = Blocks.NETHERRACK.getBlockData();
										}

										if (var9) {
											var13 = Blocks.SOUL_SAND.getBlockData();
											var14 = Blocks.SOUL_SAND.getBlockData();
										}
									}

									if ((var15 < var4) && ((var13 == null) || (var13.c().v() == class_avq.a))) {
										var13 = Blocks.LAVA.getBlockData();
									}

									var12 = var11;
									if (var15 >= (var4 - 1)) {
										var3.a(var8, var15, var7, var13);
									} else {
										var3.a(var8, var15, var7, var14);
									}
								} else if (var12 > 0) {
									--var12;
									var3.a(var8, var15, var7, var14);
								}
							}
						} else {
							var12 = -1;
						}
					} else {
						var3.a(var8, var15, var7, Blocks.BEDROCK.getBlockData());
					}
				}
			}
		}

	}

	@Override
	public class_aqn d(int var1, int var2) {
		j.setSeed((var1 * 341873128712L) + (var2 * 132897987541L));
		class_arl var3 = new class_arl();
		this.a(var1, var2, var3);
		b(var1, var2, var3);
		C.a(this, h, var1, var2, var3);
		if (i) {
			B.a(this, h, var1, var2, var3);
		}

		class_aqn var4 = new class_aqn(h, var3, var1, var2);
		class_ahb[] var5 = h.y().b((class_ahb[]) null, var1 * 16, var2 * 16, 16, 16);
		byte[] var6 = var4.l();

		for (int var7 = 0; var7 < var6.length; ++var7) {
			var6[var7] = (byte) var5[var7].az;
		}

		var4.m();
		return var4;
	}

	private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var1 == null) {
			var1 = new double[var5 * var6 * var7];
		}

		double var8 = 684.412D;
		double var10 = 2053.236D;
		f = a.a(f, var2, var3, var4, var5, 1, var7, 1.0D, 0.0D, 1.0D);
		g = b.a(g, var2, var3, var4, var5, 1, var7, 100.0D, 0.0D, 100.0D);
		c = q.a(c, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 60.0D, var8 / 80.0D);
		d = o.a(d, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		e = p.a(e, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		int var12 = 0;
		double[] var13 = new double[var6];

		int var14;
		for (var14 = 0; var14 < var6; ++var14) {
			var13[var14] = Math.cos((var14 * 3.141592653589793D * 6.0D) / var6) * 2.0D;
			double var15 = var14;
			if (var14 > (var6 / 2)) {
				var15 = var6 - 1 - var14;
			}

			if (var15 < 4.0D) {
				var15 = 4.0D - var15;
				var13[var14] -= var15 * var15 * var15 * 10.0D;
			}
		}

		for (var14 = 0; var14 < var5; ++var14) {
			for (int var31 = 0; var31 < var7; ++var31) {
				double var16 = 0.0D;

				for (int var18 = 0; var18 < var6; ++var18) {
					double var19 = 0.0D;
					double var21 = var13[var18];
					double var23 = d[var12] / 512.0D;
					double var25 = e[var12] / 512.0D;
					double var27 = ((c[var12] / 10.0D) + 1.0D) / 2.0D;
					if (var27 < 0.0D) {
						var19 = var23;
					} else if (var27 > 1.0D) {
						var19 = var25;
					} else {
						var19 = var23 + ((var25 - var23) * var27);
					}

					var19 -= var21;
					double var29;
					if (var18 > (var6 - 4)) {
						var29 = (var18 - (var6 - 4)) / 3.0F;
						var19 = (var19 * (1.0D - var29)) + (-10.0D * var29);
					}

					if (var18 < var16) {
						var29 = (var16 - var18) / 4.0D;
						var29 = MathHelper.a(var29, 0.0D, 1.0D);
						var19 = (var19 * (1.0D - var29)) + (-10.0D * var29);
					}

					var1[var12] = var19;
					++var12;
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
		class_agi var5 = new class_agi(var2, var3);
		B.a(h, j, var5);

		int var6;
		for (var6 = 0; var6 < 8; ++var6) {
			y.b(h, j, var4.a(j.nextInt(16) + 8, j.nextInt(120) + 4, j.nextInt(16) + 8));
		}

		for (var6 = 0; var6 < (j.nextInt(j.nextInt(10) + 1) + 1); ++var6) {
			t.b(h, j, var4.a(j.nextInt(16) + 8, j.nextInt(120) + 4, j.nextInt(16) + 8));
		}

		for (var6 = 0; var6 < j.nextInt(j.nextInt(10) + 1); ++var6) {
			u.b(h, j, var4.a(j.nextInt(16) + 8, j.nextInt(120) + 4, j.nextInt(16) + 8));
		}

		for (var6 = 0; var6 < 10; ++var6) {
			v.b(h, j, var4.a(j.nextInt(16) + 8, j.nextInt(128), j.nextInt(16) + 8));
		}

		if (j.nextBoolean()) {
			z.b(h, j, var4.a(j.nextInt(16) + 8, j.nextInt(128), j.nextInt(16) + 8));
		}

		if (j.nextBoolean()) {
			A.b(h, j, var4.a(j.nextInt(16) + 8, j.nextInt(128), j.nextInt(16) + 8));
		}

		for (var6 = 0; var6 < 16; ++var6) {
			w.b(h, j, var4.a(j.nextInt(16), j.nextInt(108) + 10, j.nextInt(16)));
		}

		for (var6 = 0; var6 < 16; ++var6) {
			x.b(h, j, var4.a(j.nextInt(16), j.nextInt(108) + 10, j.nextInt(16)));
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
		return "HellRandomLevelSource";
	}

	@Override
	public List a(class_ri var1, class_cj var2) {
		if (var1 == class_ri.a) {
			if (B.b(var2)) {
				return B.b();
			}

			if (B.a(h, var2) && (h.p(var2.b()).c() == Blocks.NETHER_BRICK)) {
				return B.b();
			}
		}

		class_ahb var3 = h.b(var2);
		return var3.a(var1);
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
		B.a(this, h, var2, var3, (class_arl) null);
	}

	@Override
	public class_aqn a(class_cj var1) {
		return this.d(var1.n() >> 4, var1.p() >> 4);
	}
}
