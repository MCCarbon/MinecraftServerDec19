package net.minecraft.server;

import java.util.Random;

public class class_asq extends class_asp {
	private BlockFlowers a;
	private class_apn b;

	public class_asq(BlockFlowers var1, BlockFlowers.class_a_in_class_ake var2) {
		this.a(var1, var2);
	}

	public void a(BlockFlowers var1, BlockFlowers.class_a_in_class_ake var2) {
		a = var1;
		b = var1.getBlockData().a(var1.n(), var2);
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && (!var1.t.m() || (var5.o() < 255)) && a.g(var1, var5, b)) {
				var1.a(var5, b, 2);
			}
		}

		return true;
	}
}
