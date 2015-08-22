package net.minecraft.server;

import java.util.Random;

public class class_att extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 10; ++var4) {
			int var5 = (var3.n() + var2.nextInt(8)) - var2.nextInt(8);
			int var6 = (var3.o() + var2.nextInt(4)) - var2.nextInt(4);
			int var7 = (var3.p() + var2.nextInt(8)) - var2.nextInt(8);
			if (var1.d(new class_cj(var5, var6, var7)) && Blocks.bx.c(var1, new class_cj(var5, var6, var7))) {
				var1.a((new class_cj(var5, var6, var7)), Blocks.bx.S(), 2);
			}
		}

		return true;
	}
}
