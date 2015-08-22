package net.minecraft.server;

import java.util.Random;

public class class_asf extends class_asp {
	private class_aiq a;

	public class_asf(class_aiq var1) {
		a = var1;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && (!var1.t.m() || (var5.o() < 255)) && a.g(var1, var5, a.S())) {
				var1.a(var5, a.S(), 2);
			}
		}

		return true;
	}
}
