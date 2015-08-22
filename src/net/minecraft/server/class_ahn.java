package net.minecraft.server;

import java.util.Arrays;
import java.util.Random;

public class class_ahn extends class_ahb {
	private class_apn[] aD;
	private long aE;
	private class_avh aF;
	private class_avh aG;
	private class_avh aH;
	private boolean aI;
	private boolean aJ;

	public class_ahn(int var1, boolean var2, boolean var3) {
		super(var1);
		aI = var2;
		aJ = var3;
		this.b();
		this.a(2.0F, 0.0F);
		au.clear();
		ak = Blocks.m.S().a(class_ams.a, class_ams.class_a_in_class_ams.b);
		al = Blocks.cu.S();
		as.A = -999;
		as.D = 20;
		as.F = 3;
		as.G = 5;
		as.B = 0;
		au.clear();
		if (var3) {
			as.A = 5;
		}

	}

	@Override
	public class_asa a(Random var1) {
		return aA;
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		super.a(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
		if ((aD == null) || (aE != var1.L())) {
			this.a(var1.L());
		}

		if ((aF == null) || (aG == null) || (aE != var1.L())) {
			Random var8 = new Random(aE);
			aF = new class_avh(var8, 4);
			aG = new class_avh(var8, 1);
		}

		aE = var1.L();
		double var22 = 0.0D;
		int var10;
		int var11;
		if (aI) {
			var10 = (var4 & -16) + (var5 & 15);
			var11 = (var5 & -16) + (var4 & 15);
			double var12 = Math.min(Math.abs(var6), aF.a(var10 * 0.25D, var11 * 0.25D));
			if (var12 > 0.0D) {
				double var14 = 0.001953125D;
				double var16 = Math.abs(aG.a(var10 * var14, var11 * var14));
				var22 = var12 * var12 * 2.5D;
				double var18 = Math.ceil(var16 * 50.0D) + 14.0D;
				if (var22 > var18) {
					var22 = var18;
				}

				var22 += 64.0D;
			}
		}

		var10 = var4 & 15;
		var11 = var5 & 15;
		int var23 = var1.H();
		class_apn var13 = Blocks.cu.S();
		class_apn var24 = al;
		int var15 = (int) ((var6 / 3.0D) + 3.0D + (var2.nextDouble() * 0.25D));
		boolean var25 = Math.cos((var6 / 3.0D) * 3.141592653589793D) > 0.0D;
		int var17 = -1;
		boolean var26 = false;

		for (int var19 = 255; var19 >= 0; --var19) {
			if ((var3.a(var11, var19, var10).c().v() == class_avq.a) && (var19 < (int) var22)) {
				var3.a(var11, var19, var10, Blocks.b.S());
			}

			if (var19 <= var2.nextInt(5)) {
				var3.a(var11, var19, var10, Blocks.h.S());
			} else {
				class_apn var20 = var3.a(var11, var19, var10);
				if (var20.c().v() == class_avq.a) {
					var17 = -1;
				} else if (var20.c() == Blocks.b) {
					class_apn var21;
					if (var17 == -1) {
						var26 = false;
						if (var15 <= 0) {
							var13 = null;
							var24 = Blocks.b.S();
						} else if ((var19 >= (var23 - 4)) && (var19 <= (var23 + 1))) {
							var13 = Blocks.cu.S();
							var24 = al;
						}

						if ((var19 < var23) && ((var13 == null) || (var13.c().v() == class_avq.a))) {
							var13 = Blocks.j.S();
						}

						var17 = var15 + Math.max(0, var19 - var23);
						if (var19 < (var23 - 1)) {
							var3.a(var11, var19, var10, var24);
							if (var24.c() == Blocks.cu) {
								var3.a(var11, var19, var10, var24.c().S().a(class_ajb.a, class_abt.b));
							}
						} else if (aJ && (var19 > (86 + (var15 * 2)))) {
							if (var25) {
								var3.a(var11, var19, var10, Blocks.d.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.b));
							} else {
								var3.a(var11, var19, var10, Blocks.c.S());
							}
						} else if (var19 <= (var23 + 3 + var15)) {
							var3.a(var11, var19, var10, ak);
							var26 = true;
						} else {
							if ((var19 >= 64) && (var19 <= 127)) {
								if (var25) {
									var21 = Blocks.cz.S();
								} else {
									var21 = this.a(var4, var19, var5);
								}
							} else {
								var21 = Blocks.cu.S().a(class_ajb.a, class_abt.b);
							}

							var3.a(var11, var19, var10, var21);
						}
					} else if (var17 > 0) {
						--var17;
						if (var26) {
							var3.a(var11, var19, var10, Blocks.cu.S().a(class_ajb.a, class_abt.b));
						} else {
							var21 = this.a(var4, var19, var5);
							var3.a(var11, var19, var10, var21);
						}
					}
				}
			}
		}

	}

	private void a(long var1) {
		aD = new class_apn[64];
		Arrays.fill(aD, Blocks.cz.S());
		Random var3 = new Random(var1);
		aH = new class_avh(var3, 1);

		int var4;
		for (var4 = 0; var4 < 64; ++var4) {
			var4 += var3.nextInt(5) + 1;
			if (var4 < 64) {
				aD[var4] = Blocks.cu.S().a(class_ajb.a, class_abt.b);
			}
		}

		var4 = var3.nextInt(4) + 2;

		int var5;
		int var6;
		int var7;
		int var8;
		for (var5 = 0; var5 < var4; ++var5) {
			var6 = var3.nextInt(3) + 1;
			var7 = var3.nextInt(64);

			for (var8 = 0; ((var7 + var8) < 64) && (var8 < var6); ++var8) {
				aD[var7 + var8] = Blocks.cu.S().a(class_ajb.a, class_abt.e);
			}
		}

		var5 = var3.nextInt(4) + 2;

		int var9;
		for (var6 = 0; var6 < var5; ++var6) {
			var7 = var3.nextInt(3) + 2;
			var8 = var3.nextInt(64);

			for (var9 = 0; ((var8 + var9) < 64) && (var9 < var7); ++var9) {
				aD[var8 + var9] = Blocks.cu.S().a(class_ajb.a, class_abt.m);
			}
		}

		var6 = var3.nextInt(4) + 2;

		for (var7 = 0; var7 < var6; ++var7) {
			var8 = var3.nextInt(3) + 1;
			var9 = var3.nextInt(64);

			for (int var10 = 0; ((var9 + var10) < 64) && (var10 < var8); ++var10) {
				aD[var9 + var10] = Blocks.cu.S().a(class_ajb.a, class_abt.o);
			}
		}

		var7 = var3.nextInt(3) + 3;
		var8 = 0;

		for (var9 = 0; var9 < var7; ++var9) {
			byte var12 = 1;
			var8 += var3.nextInt(16) + 4;

			for (int var11 = 0; ((var8 + var11) < 64) && (var11 < var12); ++var11) {
				aD[var8 + var11] = Blocks.cu.S().a(class_ajb.a, class_abt.a);
				if (((var8 + var11) > 1) && var3.nextBoolean()) {
					aD[(var8 + var11) - 1] = Blocks.cu.S().a(class_ajb.a, class_abt.i);
				}

				if (((var8 + var11) < 63) && var3.nextBoolean()) {
					aD[var8 + var11 + 1] = Blocks.cu.S().a(class_ajb.a, class_abt.i);
				}
			}
		}

	}

	private class_apn a(int var1, int var2, int var3) {
		int var4 = (int) Math.round(aH.a((var1 * 1.0D) / 512.0D, (var1 * 1.0D) / 512.0D) * 2.0D);
		return aD[(var2 + var4 + 64) % 64];
	}

	@Override
	protected class_ahb d(int var1) {
		boolean var2 = az == class_ahb.aa.az;
		class_ahn var3 = new class_ahn(var1, var2, aJ);
		if (!var2) {
			var3.a(g);
			var3.a(ah + " M");
		} else {
			var3.a(ah + " (Bryce)");
		}

		var3.a(ai, true);
		return var3;
	}
}
