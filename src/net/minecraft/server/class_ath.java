package net.minecraft.server;

import java.util.Random;

public class class_ath extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && (var1.p(var5.b()).c() == Blocks.GRASS) && Blocks.PUMPKIN.c(var1, var5)) {
				var1.a(var5, Blocks.PUMPKIN.getBlockData().a(class_akx.O, class_cq.class_c_in_class_cq.a.a(var2)), 2);
			}
		}

		return true;
	}
}
