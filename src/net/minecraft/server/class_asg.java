package net.minecraft.server;

import java.util.Random;

public class class_asg extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 10; ++var4) {
			class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5)) {
				int var6 = 1 + var2.nextInt(var2.nextInt(3) + 1);

				for (int var7 = 0; var7 < var6; ++var7) {
					if (Blocks.CACTUS.d(var1, var5)) {
						var1.a(var5.b(var7), Blocks.CACTUS.S(), 2);
					}
				}
			}
		}

		return true;
	}
}
