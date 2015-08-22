package net.minecraft.server;

import java.util.Random;

public class class_pr {
	private static final Random a = new Random();

	public static void a(class_ago var0, class_cj var1, class_pp var2) {
		a(var0, var1.n(), var1.o(), var1.p(), var2);
	}

	public static void a(class_ago var0, class_qx var1, class_pp var2) {
		a(var0, var1.s, var1.t, var1.u, var2);
	}

	private static void a(class_ago var0, double var1, double var3, double var5, class_pp var7) {
		for (int var8 = 0; var8 < var7.n_(); ++var8) {
			class_aco var9 = var7.a(var8);
			if (var9 != null) {
				a(var0, var1, var3, var5, var9);
			}
		}

	}

	public static void a(class_ago var0, double var1, double var3, double var5, class_aco var7) {
		float var8 = (a.nextFloat() * 0.8F) + 0.1F;
		float var9 = (a.nextFloat() * 0.8F) + 0.1F;
		float var10 = (a.nextFloat() * 0.8F) + 0.1F;

		while (var7.b > 0) {
			int var11 = a.nextInt(21) + 10;
			if (var11 > var7.b) {
				var11 = var7.b;
			}

			var7.b -= var11;
			class_xg var12 = new class_xg(var0, var1 + var8, var3 + var9, var5 + var10, new class_aco(var7.b(), var11, var7.i()));
			if (var7.n()) {
				var12.j().d((class_dn) var7.o().b());
			}

			float var13 = 0.05F;
			var12.v = a.nextGaussian() * var13;
			var12.w = (a.nextGaussian() * var13) + 0.20000000298023224D;
			var12.x = a.nextGaussian() * var13;
			var0.a(var12);
		}

	}
}
