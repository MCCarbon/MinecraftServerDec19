package net.minecraft.server;

import java.util.Random;

import com.google.common.base.Predicate;

public class class_atf extends class_asp {
	private final class_apn a;
	private final int b;
	private final Predicate c;

	public class_atf(class_apn var1, int var2) {
		this(var1, var2, class_apu.a(Blocks.STONE));
	}

	public class_atf(class_apn var1, int var2, Predicate var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		float var4 = var2.nextFloat() * 3.1415927F;
		double var5 = var3.n() + 8 + ((MathHelper.a(var4) * b) / 8.0F);
		double var7 = var3.n() + 8 - ((MathHelper.a(var4) * b) / 8.0F);
		double var9 = var3.p() + 8 + ((MathHelper.b(var4) * b) / 8.0F);
		double var11 = var3.p() + 8 - ((MathHelper.b(var4) * b) / 8.0F);
		double var13 = (var3.o() + var2.nextInt(3)) - 2;
		double var15 = (var3.o() + var2.nextInt(3)) - 2;

		for (int var17 = 0; var17 < b; ++var17) {
			float var18 = (float) var17 / (float) b;
			double var19 = var5 + ((var7 - var5) * var18);
			double var21 = var13 + ((var15 - var13) * var18);
			double var23 = var9 + ((var11 - var9) * var18);
			double var25 = (var2.nextDouble() * b) / 16.0D;
			double var27 = ((MathHelper.a(3.1415927F * var18) + 1.0F) * var25) + 1.0D;
			double var29 = ((MathHelper.a(3.1415927F * var18) + 1.0F) * var25) + 1.0D;
			int var31 = MathHelper.c(var19 - (var27 / 2.0D));
			int var32 = MathHelper.c(var21 - (var29 / 2.0D));
			int var33 = MathHelper.c(var23 - (var27 / 2.0D));
			int var34 = MathHelper.c(var19 + (var27 / 2.0D));
			int var35 = MathHelper.c(var21 + (var29 / 2.0D));
			int var36 = MathHelper.c(var23 + (var27 / 2.0D));

			for (int var37 = var31; var37 <= var34; ++var37) {
				double var38 = ((var37 + 0.5D) - var19) / (var27 / 2.0D);
				if ((var38 * var38) < 1.0D) {
					for (int var40 = var32; var40 <= var35; ++var40) {
						double var41 = ((var40 + 0.5D) - var21) / (var29 / 2.0D);
						if (((var38 * var38) + (var41 * var41)) < 1.0D) {
							for (int var43 = var33; var43 <= var36; ++var43) {
								double var44 = ((var43 + 0.5D) - var23) / (var27 / 2.0D);
								if (((var38 * var38) + (var41 * var41) + (var44 * var44)) < 1.0D) {
									class_cj var46 = new class_cj(var37, var40, var43);
									if (c.apply(var1.p(var46))) {
										var1.a(var46, a, 2);
									}
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
}
