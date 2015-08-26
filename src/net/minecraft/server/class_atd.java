package net.minecraft.server;

import java.util.Random;

public class class_atd extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (Blocks.bk.c(var1, var5) && (var1.p(var5.b()).c() == Blocks.GRASS)) {
				var1.a(var5, Blocks.bk.S(), 2);
			}
		}

		return true;
	}
}
