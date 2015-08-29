package net.minecraft.server;

import java.util.Random;

public class class_atq extends class_asp {
	private final class_apn a;

	public class_atq(BlockLongGrass.class_a_in_class_ano var1) {
		a = Blocks.TALLGRASS.getBlockData().a(BlockLongGrass.a, var1);
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		Block var4;
		while ((((var4 = var1.p(var3).c()).v() == class_avq.a) || (var4.v() == class_avq.j)) && (var3.o() > 0)) {
			var3 = var3.b();
		}

		for (int var5 = 0; var5 < 128; ++var5) {
			class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var6) && Blocks.TALLGRASS.g(var1, var6, a)) {
				var1.a(var6, a, 2);
			}
		}

		return true;
	}
}
