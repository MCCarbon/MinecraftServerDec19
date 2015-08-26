package net.minecraft.server;

import java.util.Random;

public class class_us {
	private static class_aym a = new class_aym(0.0D, 0.0D, 0.0D);

	public static class_aym a(class_rn var0, int var1, int var2) {
		return c(var0, var1, var2, (class_aym) null);
	}

	public static class_aym a(class_rn var0, int var1, int var2, class_aym var3) {
		a = var3.a(var0.s, var0.t, var0.u);
		return c(var0, var1, var2, a);
	}

	public static class_aym b(class_rn var0, int var1, int var2, class_aym var3) {
		a = (new class_aym(var0.s, var0.t, var0.u)).d(var3);
		return c(var0, var1, var2, a);
	}

	private static class_aym c(class_rn var0, int var1, int var2, class_aym var3) {
		Random var4 = var0.bj();
		boolean var5 = false;
		int var6 = 0;
		int var7 = 0;
		int var8 = 0;
		float var9 = -99999.0F;
		boolean var10;
		if (var0.cD()) {
			double var11 = var0.cA().c(MathHelper.c(var0.s), MathHelper.c(var0.t), MathHelper.c(var0.u)) + 4.0D;
			double var13 = var0.cB() + var1;
			var10 = var11 < (var13 * var13);
		} else {
			var10 = false;
		}

		for (int var17 = 0; var17 < 10; ++var17) {
			int var12 = var4.nextInt((2 * var1) + 1) - var1;
			int var18 = var4.nextInt((2 * var2) + 1) - var2;
			int var14 = var4.nextInt((2 * var1) + 1) - var1;
			if ((var3 == null) || (((var12 * var3.a) + (var14 * var3.c)) >= 0.0D)) {
				class_cj var15;
				if (var0.cD() && (var1 > 1)) {
					var15 = var0.cA();
					if (var0.s > var15.n()) {
						var12 -= var4.nextInt(var1 / 2);
					} else {
						var12 += var4.nextInt(var1 / 2);
					}

					if (var0.u > var15.p()) {
						var14 -= var4.nextInt(var1 / 2);
					} else {
						var14 += var4.nextInt(var1 / 2);
					}
				}

				var12 += MathHelper.c(var0.s);
				var18 += MathHelper.c(var0.t);
				var14 += MathHelper.c(var0.u);
				var15 = new class_cj(var12, var18, var14);
				if (!var10 || var0.e(var15)) {
					float var16 = var0.a(var15);
					if (var16 > var9) {
						var9 = var16;
						var6 = var12;
						var7 = var18;
						var8 = var14;
						var5 = true;
					}
				}
			}
		}

		if (var5) {
			return new class_aym(var6, var7, var8);
		} else {
			return null;
		}
	}
}
