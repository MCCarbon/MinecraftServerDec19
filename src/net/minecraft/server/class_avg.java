package net.minecraft.server;

import java.util.Random;

public class class_avg extends class_avl {
	private class_avf[] a;
	private int b;

	public class_avg(Random var1, int var2) {
		b = var2;
		a = new class_avf[var2];

		for (int var3 = 0; var3 < var2; ++var3) {
			a[var3] = new class_avf(var1);
		}

	}

	public double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7, double var8, double var10, double var12) {
		if (var1 == null) {
			var1 = new double[var5 * var6 * var7];
		} else {
			for (int var14 = 0; var14 < var1.length; ++var14) {
				var1[var14] = 0.0D;
			}
		}

		double var27 = 1.0D;

		for (int var16 = 0; var16 < b; ++var16) {
			double var17 = var2 * var27 * var8;
			double var19 = var3 * var27 * var10;
			double var21 = var4 * var27 * var12;
			long var23 = class_oa.d(var17);
			long var25 = class_oa.d(var21);
			var17 -= var23;
			var21 -= var25;
			var23 %= 16777216L;
			var25 %= 16777216L;
			var17 += var23;
			var21 += var25;
			a[var16].a(var1, var17, var19, var21, var5, var6, var7, var8 * var27, var10 * var27, var12 * var27, var27);
			var27 /= 2.0D;
		}

		return var1;
	}

	public double[] a(double[] var1, int var2, int var3, int var4, int var5, double var6, double var8, double var10) {
		return this.a(var1, var2, 10, var3, var4, 1, var5, var6, 1.0D, var8);
	}
}
