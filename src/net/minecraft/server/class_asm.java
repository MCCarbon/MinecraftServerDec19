package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_asm extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		Iterator var4 = class_cj.b(var3.a(-1, -2, -1), var3.a(1, 2, 1)).iterator();

		while (true) {
			while (var4.hasNext()) {
				class_cj.class_a_in_class_cj var5 = (class_cj.class_a_in_class_cj) var4.next();
				boolean var6 = var5.n() == var3.n();
				boolean var7 = var5.o() == var3.o();
				boolean var8 = var5.p() == var3.p();
				boolean var9 = Math.abs(var5.o() - var3.o()) == 2;
				if (var6 && var7 && var8) {
					a(var1, new class_cj(var5), Blocks.END_GATEWAY.getBlockData());
				} else if (var7) {
					a(var1, var5, Blocks.AIR.getBlockData());
				} else if (var9 && var6 && var8) {
					a(var1, var5, Blocks.BEDROCK.getBlockData());
				} else if ((var6 || var8) && !var9) {
					a(var1, var5, Blocks.BEDROCK.getBlockData());
				} else {
					a(var1, var5, Blocks.AIR.getBlockData());
				}
			}

			return true;
		}
	}
}
