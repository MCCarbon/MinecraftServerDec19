package net.minecraft.server;

import java.util.Random;

public class class_ass extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && (var1.p(var5.b()).c() == Blocks.aV)) {
				var1.a(var5, Blocks.ab.S(), 2);
			}
		}

		return true;
	}
}
