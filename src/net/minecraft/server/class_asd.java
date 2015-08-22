package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_asd extends class_asp {
	private final class_ail a;
	private final int b;

	public class_asd(class_ail var1, int var2) {
		super(false);
		a = var1;
		b = var2;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		while (true) {
			label50: {
			if (var3.o() > 3) {
				if (var1.d(var3.b())) {
					break label50;
				}

				class_ail var4 = var1.p(var3.b()).c();
				if ((var4 != class_aim.c) && (var4 != class_aim.d) && (var4 != class_aim.b)) {
					break label50;
				}
			}

			if (var3.o() <= 3) {
				return false;
			}

			int var12 = b;

			for (int var5 = 0; (var12 >= 0) && (var5 < 3); ++var5) {
				int var6 = var12 + var2.nextInt(2);
				int var7 = var12 + var2.nextInt(2);
				int var8 = var12 + var2.nextInt(2);
				float var9 = ((var6 + var7 + var8) * 0.333F) + 0.5F;
				Iterator var10 = class_cj.a(var3.a(-var6, -var7, -var8), var3.a(var6, var7, var8)).iterator();

				while (var10.hasNext()) {
					class_cj var11 = (class_cj) var10.next();
					if (var11.i(var3) <= var9 * var9) {
						var1.a(var11, a.S(), 4);
					}
				}

				var3 = var3.a(-(var12 + 1) + var2.nextInt(2 + (var12 * 2)), 0 - var2.nextInt(2), -(var12 + 1) + var2.nextInt(2 + (var12 * 2)));
			}

			return true;
		}

		var3 = var3.b();
		}
	}
}
