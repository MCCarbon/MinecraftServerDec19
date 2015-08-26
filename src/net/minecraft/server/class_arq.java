package net.minecraft.server;

import java.util.Random;

import com.google.common.base.Objects;

public class class_arq extends class_arr {
	protected void a(long var1, int var3, int var4, class_arl var5, double var6, double var8, double var10) {
		this.a(var1, var3, var4, var5, var6, var8, var10, 1.0F + (b.nextFloat() * 6.0F), 0.0F, 0.0F, -1, -1, 0.5D);
	}

	protected void a(long var1, int var3, int var4, class_arl var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
		double var19 = (var3 * 16) + 8;
		double var21 = (var4 * 16) + 8;
		float var23 = 0.0F;
		float var24 = 0.0F;
		Random var25 = new Random(var1);
		if (var16 <= 0) {
			int var26 = (a * 16) - 16;
			var16 = var26 - var25.nextInt(var26 / 4);
		}

		boolean var55 = false;
		if (var15 == -1) {
			var15 = var16 / 2;
			var55 = true;
		}

		int var27 = var25.nextInt(var16 / 2) + (var16 / 4);

		for (boolean var28 = var25.nextInt(6) == 0; var15 < var16; ++var15) {
			double var29 = 1.5D + class_oa.a((var15 * 3.1415927F) / var16) * var12 * 1.0F;
			double var31 = var29 * var17;
			float var33 = class_oa.b(var14);
			float var34 = class_oa.a(var14);
			var6 += class_oa.b(var13) * var33;
			var8 += var34;
			var10 += class_oa.a(var13) * var33;
			if (var28) {
				var14 *= 0.92F;
			} else {
				var14 *= 0.7F;
			}

			var14 += var24 * 0.1F;
			var13 += var23 * 0.1F;
			var24 *= 0.9F;
			var23 *= 0.75F;
			var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
			var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
			if (!var55 && (var15 == var27) && (var12 > 1.0F) && (var16 > 0)) {
				this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, (var25.nextFloat() * 0.5F) + 0.5F, var13 - 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
				this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, (var25.nextFloat() * 0.5F) + 0.5F, var13 + 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
				return;
			}

			if (var55 || (var25.nextInt(4) != 0)) {
				double var35 = var6 - var19;
				double var37 = var10 - var21;
				double var39 = var16 - var15;
				double var41 = var12 + 2.0F + 16.0F;
				if ((((var35 * var35) + (var37 * var37)) - (var39 * var39)) > (var41 * var41)) {
					return;
				}

				if ((var6 >= (var19 - 16.0D - (var29 * 2.0D))) && (var10 >= (var21 - 16.0D - (var29 * 2.0D))) && (var6 <= (var19 + 16.0D + (var29 * 2.0D))) && (var10 <= (var21 + 16.0D + (var29 * 2.0D)))) {
					int var56 = class_oa.c(var6 - var29) - (var3 * 16) - 1;
					int var36 = (class_oa.c(var6 + var29) - (var3 * 16)) + 1;
					int var57 = class_oa.c(var8 - var31) - 1;
					int var38 = class_oa.c(var8 + var31) + 1;
					int var58 = class_oa.c(var10 - var29) - (var4 * 16) - 1;
					int var40 = (class_oa.c(var10 + var29) - (var4 * 16)) + 1;
					if (var56 < 0) {
						var56 = 0;
					}

					if (var36 > 16) {
						var36 = 16;
					}

					if (var57 < 1) {
						var57 = 1;
					}

					if (var38 > 248) {
						var38 = 248;
					}

					if (var58 < 0) {
						var58 = 0;
					}

					if (var40 > 16) {
						var40 = 16;
					}

					boolean var59 = false;

					int var43;
					for (int var42 = var56; !var59 && (var42 < var36); ++var42) {
						for (var43 = var58; !var59 && (var43 < var40); ++var43) {
							for (int var44 = var38 + 1; !var59 && (var44 >= (var57 - 1)); --var44) {
								if ((var44 >= 0) && (var44 < 256)) {
									class_apn var45 = var5.a(var42, var44, var43);
									if ((var45.c() == Blocks.FLOWING_WATER) || (var45.c() == Blocks.WATER)) {
										var59 = true;
									}

									if ((var44 != (var57 - 1)) && (var42 != var56) && (var42 != (var36 - 1)) && (var43 != var58) && (var43 != (var40 - 1))) {
										var44 = var57;
									}
								}
							}
						}
					}

					if (!var59) {
						class_cj.class_a_in_class_cj var60 = new class_cj.class_a_in_class_cj();

						for (var43 = var56; var43 < var36; ++var43) {
							double var61 = ((var43 + (var3 * 16) + 0.5D) - var6) / var29;

							for (int var46 = var58; var46 < var40; ++var46) {
								double var47 = ((var46 + (var4 * 16) + 0.5D) - var10) / var29;
								boolean var49 = false;
								if (((var61 * var61) + (var47 * var47)) < 1.0D) {
									for (int var50 = var38; var50 > var57; --var50) {
										double var51 = ((var50 - 1 + 0.5D) - var8) / var31;
										if ((var51 > -0.7D) && (((var61 * var61) + (var51 * var51) + (var47 * var47)) < 1.0D)) {
											class_apn var53 = var5.a(var43, var50, var46);
											class_apn var54 = Objects.firstNonNull(var5.a(var43, var50 + 1, var46), Blocks.AIR.S());
											if ((var53.c() == Blocks.GRASS) || (var53.c() == Blocks.bw)) {
												var49 = true;
											}

											if (this.a(var53, var54)) {
												if ((var50 - 1) < 10) {
													var5.a(var43, var50, var46, Blocks.LAVA.S());
												} else {
													var5.a(var43, var50, var46, Blocks.AIR.S());
													if (var54.c() == Blocks.SAND) {
														var5.a(var43, var50 + 1, var46, var54.b(BlockSand.a) == BlockSand.class_a_in_class_ams.b ? Blocks.cM.S() : Blocks.SANDSTONE.S());
													}

													if (var49 && (var5.a(var43, var50 - 1, var46).c() == Blocks.DIRT)) {
														var60.c(var43 + (var3 * 16), 0, var46 + (var4 * 16));
														var5.a(var43, var50 - 1, var46, c.b(var60).ak.c().S());
													}
												}
											}
										}
									}
								}
							}
						}

						if (var55) {
							break;
						}
					}
				}
			}
		}

	}

	protected boolean a(class_apn var1, class_apn var2) {
		return var1.c() == Blocks.STONE ? true : (var1.c() == Blocks.DIRT ? true : (var1.c() == Blocks.GRASS ? true : (var1.c() == Blocks.cz ? true : (var1.c() == Blocks.cu ? true : (var1.c() == Blocks.SANDSTONE ? true : (var1.c() == Blocks.cM ? true : (var1.c() == Blocks.bw ? true : (var1.c() == Blocks.aH ? true : ((var1.c() == Blocks.SAND) || (var1.c() == Blocks.GRAVEL)) && (var2.c().v() != class_avq.h)))))))));
	}

	@Override
	protected void a(class_ago var1, int var2, int var3, int var4, int var5, class_arl var6) {
		int var7 = b.nextInt(b.nextInt(b.nextInt(15) + 1) + 1);
		if (b.nextInt(7) != 0) {
			var7 = 0;
		}

		for (int var8 = 0; var8 < var7; ++var8) {
			double var9 = (var2 * 16) + b.nextInt(16);
			double var11 = b.nextInt(b.nextInt(120) + 8);
			double var13 = (var3 * 16) + b.nextInt(16);
			int var15 = 1;
			if (b.nextInt(4) == 0) {
				this.a(b.nextLong(), var4, var5, var6, var9, var11, var13);
				var15 += b.nextInt(4);
			}

			for (int var16 = 0; var16 < var15; ++var16) {
				float var17 = b.nextFloat() * 3.1415927F * 2.0F;
				float var18 = ((b.nextFloat() - 0.5F) * 2.0F) / 8.0F;
				float var19 = (b.nextFloat() * 2.0F) + b.nextFloat();
				if (b.nextInt(10) == 0) {
					var19 *= (b.nextFloat() * b.nextFloat() * 3.0F) + 1.0F;
				}

				this.a(b.nextLong(), var4, var5, var6, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
			}
		}

	}
}
