package net.minecraft.server;

import java.util.Random;

public class class_asj extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		Block var4;
		while ((((var4 = var1.p(var3).c()).v() == class_avq.a) || (var4.v() == class_avq.j)) && (var3.o() > 0)) {
			var3 = var3.b();
		}

		for (int var5 = 0; var5 < 4; ++var5) {
			class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var6) && Blocks.DEADBUSH.g(var1, var6, Blocks.DEADBUSH.S())) {
				var1.a(var6, Blocks.DEADBUSH.S(), 2);
			}
		}

		return true;
	}
}
