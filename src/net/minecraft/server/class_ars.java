package net.minecraft.server;

import java.util.Random;

public class class_ars extends class_arr {
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

		boolean var52 = false;
		if (var15 == -1) {
			var15 = var16 / 2;
			var52 = true;
		}

		int var27 = var25.nextInt(var16 / 2) + (var16 / 4);

		for (boolean var28 = var25.nextInt(6) == 0; var15 < var16; ++var15) {
			double var29 = 1.5D + MathHelper.a((var15 * 3.1415927F) / var16) * var12 * 1.0F;
			double var31 = var29 * var17;
			float var33 = MathHelper.b(var14);
			float var34 = MathHelper.a(var14);
			var6 += MathHelper.b(var13) * var33;
			var8 += var34;
			var10 += MathHelper.a(var13) * var33;
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
			if (!var52 && (var15 == var27) && (var12 > 1.0F)) {
				this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, (var25.nextFloat() * 0.5F) + 0.5F, var13 - 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
				this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, (var25.nextFloat() * 0.5F) + 0.5F, var13 + 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
				return;
			}

			if (var52 || (var25.nextInt(4) != 0)) {
				double var35 = var6 - var19;
				double var37 = var10 - var21;
				double var39 = var16 - var15;
				double var41 = var12 + 2.0F + 16.0F;
				if ((((var35 * var35) + (var37 * var37)) - (var39 * var39)) > (var41 * var41)) {
					return;
				}

				if ((var6 >= (var19 - 16.0D - (var29 * 2.0D))) && (var10 >= (var21 - 16.0D - (var29 * 2.0D))) && (var6 <= (var19 + 16.0D + (var29 * 2.0D))) && (var10 <= (var21 + 16.0D + (var29 * 2.0D)))) {
					int var53 = MathHelper.c(var6 - var29) - (var3 * 16) - 1;
					int var36 = (MathHelper.c(var6 + var29) - (var3 * 16)) + 1;
					int var54 = MathHelper.c(var8 - var31) - 1;
					int var38 = MathHelper.c(var8 + var31) + 1;
					int var55 = MathHelper.c(var10 - var29) - (var4 * 16) - 1;
					int var40 = (MathHelper.c(var10 + var29) - (var4 * 16)) + 1;
					if (var53 < 0) {
						var53 = 0;
					}

					if (var36 > 16) {
						var36 = 16;
					}

					if (var54 < 1) {
						var54 = 1;
					}

					if (var38 > 120) {
						var38 = 120;
					}

					if (var55 < 0) {
						var55 = 0;
					}

					if (var40 > 16) {
						var40 = 16;
					}

					boolean var56 = false;

					int var42;
					for (var42 = var53; !var56 && (var42 < var36); ++var42) {
						for (int var43 = var55; !var56 && (var43 < var40); ++var43) {
							for (int var44 = var38 + 1; !var56 && (var44 >= (var54 - 1)); --var44) {
								if ((var44 >= 0) && (var44 < 128)) {
									class_apn var45 = var5.a(var42, var44, var43);
									if ((var45.c() == Blocks.FLOWING_LAVA) || (var45.c() == Blocks.LAVA)) {
										var56 = true;
									}

									if ((var44 != (var54 - 1)) && (var42 != var53) && (var42 != (var36 - 1)) && (var43 != var55) && (var43 != (var40 - 1))) {
										var44 = var54;
									}
								}
							}
						}
					}

					if (!var56) {
						for (var42 = var53; var42 < var36; ++var42) {
							double var57 = ((var42 + (var3 * 16) + 0.5D) - var6) / var29;

							for (int var58 = var55; var58 < var40; ++var58) {
								double var46 = ((var58 + (var4 * 16) + 0.5D) - var10) / var29;

								for (int var48 = var38; var48 > var54; --var48) {
									double var49 = ((var48 - 1 + 0.5D) - var8) / var31;
									if ((var49 > -0.7D) && (((var57 * var57) + (var49 * var49) + (var46 * var46)) < 1.0D)) {
										class_apn var51 = var5.a(var42, var48, var58);
										if ((var51.c() == Blocks.NETHERRACK) || (var51.c() == Blocks.DIRT) || (var51.c() == Blocks.GRASS)) {
											var5.a(var42, var48, var58, Blocks.AIR.getBlockData());
										}
									}
								}
							}
						}

						if (var52) {
							break;
						}
					}
				}
			}
		}

	}

	@Override
	protected void a(class_ago var1, int var2, int var3, int var4, int var5, class_arl var6) {
		int var7 = b.nextInt(b.nextInt(b.nextInt(10) + 1) + 1);
		if (b.nextInt(5) != 0) {
			var7 = 0;
		}

		for (int var8 = 0; var8 < var7; ++var8) {
			double var9 = (var2 * 16) + b.nextInt(16);
			double var11 = b.nextInt(128);
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
				this.a(b.nextLong(), var4, var5, var6, var9, var11, var13, var19 * 2.0F, var17, var18, 0, 0, 0.5D);
			}
		}

	}
}
