package net.minecraft.server;

import java.util.Random;

public class class_ati extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (int var4 = 0; var4 < 20; ++var4) {
			class_cj var5 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
			if (var1.d(var5)) {
				class_cj var6 = var5.b();
				if ((var1.p(var6.e()).c().v() == class_avq.h) || (var1.p(var6.f()).c().v() == class_avq.h) || (var1.p(var6.c()).c().v() == class_avq.h) || (var1.p(var6.d()).c().v() == class_avq.h)) {
					int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

					for (int var8 = 0; var8 < var7; ++var8) {
						if (Blocks.aM.d(var1, var5)) {
							var1.a(var5.b(var8), Blocks.aM.S(), 2);
						}
					}
				}
			}
		}

		return true;
	}
}
