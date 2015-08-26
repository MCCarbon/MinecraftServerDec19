package net.minecraft.server;

import java.util.Random;

public class class_asi extends class_asp {
	private Block a;
	private int b;

	public class_asi(int var1) {
		a = Blocks.aL;
		b = var1;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		if (var1.p(var3).c().v() != class_avq.h) {
			return false;
		} else {
			int var4 = var2.nextInt(b - 2) + 2;
			byte var5 = 1;

			for (int var6 = var3.n() - var4; var6 <= (var3.n() + var4); ++var6) {
				for (int var7 = var3.p() - var4; var7 <= (var3.p() + var4); ++var7) {
					int var8 = var6 - var3.n();
					int var9 = var7 - var3.p();
					if (((var8 * var8) + (var9 * var9)) <= (var4 * var4)) {
						for (int var10 = var3.o() - var5; var10 <= (var3.o() + var5); ++var10) {
							class_cj var11 = new class_cj(var6, var10, var7);
							Block var12 = var1.p(var11).c();
							if ((var12 == Blocks.DIRT) || (var12 == Blocks.aL)) {
								var1.a(var11, a.S(), 2);
							}
						}
					}
				}
			}

			return true;
		}
	}
}
