package net.minecraft.server;

import java.util.Random;

public class class_ats extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		for (; var3.o() < 128; var3 = var3.a()) {
			if (var1.d(var3)) {
				class_cq[] var4 = class_cq.class_c_in_class_cq.a.a();
				int var5 = var4.length;

				for (int var6 = 0; var6 < var5; ++var6) {
					class_cq var7 = var4[var6];
					if (Blocks.VINE.b(var1, var3, var7)) {
						class_apn var8 = Blocks.VINE.getBlockData().a(class_anw.b, Boolean.valueOf(var7 == class_cq.c)).a(class_anw.N, Boolean.valueOf(var7 == class_cq.f)).a(class_anw.O, Boolean.valueOf(var7 == class_cq.d)).a(class_anw.P, Boolean.valueOf(var7 == class_cq.e));
						var1.a(var3, var8, 2);
						break;
					}
				}
			} else {
				var3 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
			}
		}

		return true;
	}
}
