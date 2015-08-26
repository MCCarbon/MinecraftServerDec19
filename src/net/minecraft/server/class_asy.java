package net.minecraft.server;

import java.util.Random;

public class class_asy extends class_asp {
	private Block a;

	public class_asy(Block var1) {
		a = var1;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (var3 = var3.a(-8, 0, -8); (var3.o() > 5) && var1.d(var3); var3 = var3.b()) {
			;
		}

		if (var3.o() <= 4) {
			return false;
		} else {
			var3 = var3.c(4);
			boolean[] var4 = new boolean[2048];
			int var5 = var2.nextInt(4) + 4;

			int var6;
			for (var6 = 0; var6 < var5; ++var6) {
				double var7 = (var2.nextDouble() * 6.0D) + 3.0D;
				double var9 = (var2.nextDouble() * 4.0D) + 2.0D;
				double var11 = (var2.nextDouble() * 6.0D) + 3.0D;
				double var13 = (var2.nextDouble() * (16.0D - var7 - 2.0D)) + 1.0D + (var7 / 2.0D);
				double var15 = (var2.nextDouble() * (8.0D - var9 - 4.0D)) + 2.0D + (var9 / 2.0D);
				double var17 = (var2.nextDouble() * (16.0D - var11 - 2.0D)) + 1.0D + (var11 / 2.0D);

				for (int var19 = 1; var19 < 15; ++var19) {
					for (int var20 = 1; var20 < 15; ++var20) {
						for (int var21 = 1; var21 < 7; ++var21) {
							double var22 = (var19 - var13) / (var7 / 2.0D);
							double var24 = (var21 - var15) / (var9 / 2.0D);
							double var26 = (var20 - var17) / (var11 / 2.0D);
							double var28 = (var22 * var22) + (var24 * var24) + (var26 * var26);
							if (var28 < 1.0D) {
								var4[(((var19 * 16) + var20) * 8) + var21] = true;
							}
						}
					}
				}
			}

			int var8;
			int var30;
			boolean var31;
			for (var6 = 0; var6 < 16; ++var6) {
				for (var30 = 0; var30 < 16; ++var30) {
					for (var8 = 0; var8 < 8; ++var8) {
						var31 = !var4[(((var6 * 16) + var30) * 8) + var8] && (((var6 < 15) && var4[((((var6 + 1) * 16) + var30) * 8) + var8]) || ((var6 > 0) && var4[((((var6 - 1) * 16) + var30) * 8) + var8]) || ((var30 < 15) && var4[(((var6 * 16) + var30 + 1) * 8) + var8]) || ((var30 > 0) && var4[(((var6 * 16) + (var30 - 1)) * 8) + var8]) || ((var8 < 7) && var4[(((var6 * 16) + var30) * 8) + var8 + 1]) || ((var8 > 0) && var4[(((var6 * 16) + var30) * 8) + (var8 - 1)]));
						if (var31) {
							class_avq var10 = var1.p(var3.a(var6, var8, var30)).c().v();
							if ((var8 >= 4) && var10.d()) {
								return false;
							}

							if ((var8 < 4) && !var10.a() && (var1.p(var3.a(var6, var8, var30)).c() != a)) {
								return false;
							}
						}
					}
				}
			}

			for (var6 = 0; var6 < 16; ++var6) {
				for (var30 = 0; var30 < 16; ++var30) {
					for (var8 = 0; var8 < 8; ++var8) {
						if (var4[(((var6 * 16) + var30) * 8) + var8]) {
							var1.a(var3.a(var6, var8, var30), var8 >= 4 ? Blocks.AIR.S() : a.S(), 2);
						}
					}
				}
			}

			for (var6 = 0; var6 < 16; ++var6) {
				for (var30 = 0; var30 < 16; ++var30) {
					for (var8 = 4; var8 < 8; ++var8) {
						if (var4[(((var6 * 16) + var30) * 8) + var8]) {
							class_cj var32 = var3.a(var6, var8 - 1, var30);
							if ((var1.p(var32).c() == Blocks.DIRT) && (var1.b(class_agu.a, var3.a(var6, var8, var30)) > 0)) {
								class_ahb var33 = var1.b(var32);
								if (var33.ak.c() == Blocks.bw) {
									var1.a(var32, Blocks.bw.S(), 2);
								} else {
									var1.a(var32, Blocks.GRASS.S(), 2);
								}
							}
						}
					}
				}
			}

			if (a.v() == class_avq.i) {
				for (var6 = 0; var6 < 16; ++var6) {
					for (var30 = 0; var30 < 16; ++var30) {
						for (var8 = 0; var8 < 8; ++var8) {
							var31 = !var4[(((var6 * 16) + var30) * 8) + var8] && (((var6 < 15) && var4[((((var6 + 1) * 16) + var30) * 8) + var8]) || ((var6 > 0) && var4[((((var6 - 1) * 16) + var30) * 8) + var8]) || ((var30 < 15) && var4[(((var6 * 16) + var30 + 1) * 8) + var8]) || ((var30 > 0) && var4[(((var6 * 16) + (var30 - 1)) * 8) + var8]) || ((var8 < 7) && var4[(((var6 * 16) + var30) * 8) + var8 + 1]) || ((var8 > 0) && var4[(((var6 * 16) + var30) * 8) + (var8 - 1)]));
							if (var31 && ((var8 < 4) || (var2.nextInt(2) != 0)) && var1.p(var3.a(var6, var8, var30)).c().v().a()) {
								var1.a(var3.a(var6, var8, var30), Blocks.STONE.S(), 2);
							}
						}
					}
				}
			}

			if (a.v() == class_avq.h) {
				for (var6 = 0; var6 < 16; ++var6) {
					for (var30 = 0; var30 < 16; ++var30) {
						byte var34 = 4;
						if (var1.v(var3.a(var6, var34, var30))) {
							var1.a(var3.a(var6, var34, var30), Blocks.aI.S(), 2);
						}
					}
				}
			}

			return true;
		}
	}
}
