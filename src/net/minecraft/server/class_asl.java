package net.minecraft.server;

import java.util.Random;

public class class_asl extends class_asp {
	private BlockTallPlant.class_b_in_class_ajo a;

	public void a(BlockTallPlant.class_b_in_class_ajo var1) {
		a = var1;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		boolean var4 = false;

		for (int var5 = 0; var5 < 64; ++var5) {
			class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var6) && (!var1.t.m() || (var6.o() < 254)) && Blocks.cF.c(var1, var6)) {
				Blocks.cF.a(var1, var6, a, 2);
				var4 = true;
			}
		}

		return var4;
	}
}
