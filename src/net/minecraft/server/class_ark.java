package net.minecraft.server;

import java.util.Random;

public class class_ark extends class_arr {
	private float[] d = new float[1024];

	protected void a(long var1, int var3, int var4, class_arl var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
		Random var19 = new Random(var1);
		double var20 = (var3 * 16) + 8;
		double var22 = (var4 * 16) + 8;
		float var24 = 0.0F;
		float var25 = 0.0F;
		if (var16 <= 0) {
			int var26 = (a * 16) - 16;
			var16 = var26 - var19.nextInt(var26 / 4);
		}

		boolean var53 = false;
		if (var15 == -1) {
			var15 = var16 / 2;
			var53 = true;
		}

		float var27 = 1.0F;

		for (int var28 = 0; var28 < 256; ++var28) {
			if ((var28 == 0) || (var19.nextInt(3) == 0)) {
				var27 = 1.0F + (var19.nextFloat() * var19.nextFloat() * 1.0F);
			}

			d[var28] = var27 * var27;
		}

		for (; var15 < var16; ++var15) {
			double var54 = 1.5D + class_oa.a((var15 * 3.1415927F) / var16) * var12 * 1.0F;
			double var30 = var54 * var17;
			var54 *= (var19.nextFloat() * 0.25D) + 0.75D;
			var30 *= (var19.nextFloat() * 0.25D) + 0.75D;
			float var32 = class_oa.b(var14);
			float var33 = class_oa.a(var14);
			var6 += class_oa.b(var13) * var32;
			var8 += var33;
			var10 += class_oa.a(var13) * var32;
			var14 *= 0.7F;
			var14 += var25 * 0.05F;
			var13 += var24 * 0.05F;
			var25 *= 0.8F;
			var24 *= 0.5F;
			var25 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 2.0F;
			var24 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 4.0F;
			if (var53 || (var19.nextInt(4) != 0)) {
				double var34 = var6 - var20;
				double var36 = var10 - var22;
				double var38 = var16 - var15;
				double var40 = var12 + 2.0F + 16.0F;
				if ((((var34 * var34) + (var36 * var36)) - (var38 * var38)) > (var40 * var40)) {
					return;
				}

				if ((var6 >= (var20 - 16.0D - (var54 * 2.0D))) && (var10 >= (var22 - 16.0D - (var54 * 2.0D))) && (var6 <= (var20 + 16.0D + (var54 * 2.0D))) && (var10 <= (var22 + 16.0D + (var54 * 2.0D)))) {
					int var55 = class_oa.c(var6 - var54) - (var3 * 16) - 1;
					int var35 = (class_oa.c(var6 + var54) - (var3 * 16)) + 1;
					int var56 = class_oa.c(var8 - var30) - 1;
					int var37 = class_oa.c(var8 + var30) + 1;
					int var57 = class_oa.c(var10 - var54) - (var4 * 16) - 1;
					int var39 = (class_oa.c(var10 + var54) - (var4 * 16)) + 1;
					if (var55 < 0) {
						var55 = 0;
					}

					if (var35 > 16) {
						var35 = 16;
					}

					if (var56 < 1) {
						var56 = 1;
					}

					if (var37 > 248) {
						var37 = 248;
					}

					if (var57 < 0) {
						var57 = 0;
					}

					if (var39 > 16) {
						var39 = 16;
					}

					boolean var58 = false;

					int var42;
					for (int var41 = var55; !var58 && (var41 < var35); ++var41) {
						for (var42 = var57; !var58 && (var42 < var39); ++var42) {
							for (int var43 = var37 + 1; !var58 && (var43 >= (var56 - 1)); --var43) {
								if ((var43 >= 0) && (var43 < 256)) {
									class_apn var44 = var5.a(var41, var43, var42);
									if ((var44.c() == Blocks.i) || (var44.c() == Blocks.j)) {
										var58 = true;
									}

									if ((var43 != (var56 - 1)) && (var41 != var55) && (var41 != (var35 - 1)) && (var42 != var57) && (var42 != (var39 - 1))) {
										var43 = var56;
									}
								}
							}
						}
					}

					if (!var58) {
						class_cj.class_a_in_class_cj var59 = new class_cj.class_a_in_class_cj();

						for (var42 = var55; var42 < var35; ++var42) {
							double var60 = ((var42 + (var3 * 16) + 0.5D) - var6) / var54;

							for (int var45 = var57; var45 < var39; ++var45) {
								double var46 = ((var45 + (var4 * 16) + 0.5D) - var10) / var54;
								boolean var48 = false;
								if (((var60 * var60) + (var46 * var46)) < 1.0D) {
									for (int var49 = var37; var49 > var56; --var49) {
										double var50 = ((var49 - 1 + 0.5D) - var8) / var30;
										if (((((var60 * var60) + (var46 * var46)) * d[var49 - 1]) + ((var50 * var50) / 6.0D)) < 1.0D) {
											class_apn var52 = var5.a(var42, var49, var45);
											if (var52.c() == Blocks.c) {
												var48 = true;
											}

											if ((var52.c() == Blocks.b) || (var52.c() == Blocks.d) || (var52.c() == Blocks.c)) {
												if ((var49 - 1) < 10) {
													var5.a(var42, var49, var45, Blocks.k.S());
												} else {
													var5.a(var42, var49, var45, Blocks.a.S());
													if (var48 && (var5.a(var42, var49 - 1, var45).c() == Blocks.d)) {
														var59.c(var42 + (var3 * 16), 0, var45 + (var4 * 16));
														var5.a(var42, var49 - 1, var45, c.b(var59).ak);
													}
												}
											}
										}
									}
								}
							}
						}

						if (var53) {
							break;
						}
					}
				}
			}
		}

	}

	@Override
	protected void a(class_ago var1, int var2, int var3, int var4, int var5, class_arl var6) {
		if (b.nextInt(50) == 0) {
			double var7 = (var2 * 16) + b.nextInt(16);
			double var9 = b.nextInt(b.nextInt(40) + 8) + 20;
			double var11 = (var3 * 16) + b.nextInt(16);
			byte var13 = 1;

			for (int var14 = 0; var14 < var13; ++var14) {
				float var15 = b.nextFloat() * 3.1415927F * 2.0F;
				float var16 = ((b.nextFloat() - 0.5F) * 2.0F) / 8.0F;
				float var17 = ((b.nextFloat() * 2.0F) + b.nextFloat()) * 2.0F;
				this.a(b.nextLong(), var4, var5, var6, var7, var9, var11, var17, var15, var16, 0, 0, 3.0D);
			}

		}
	}
}
