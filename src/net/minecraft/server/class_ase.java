package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_ase extends class_asp {
	private final List a;
	private final int b;

	public class_ase(List var1, int var2) {
		a = var1;
		b = var2;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		Block var4;
		while ((((var4 = var1.p(var3).c()).v() == class_avq.a) || (var4.v() == class_avq.j)) && (var3.o() > 1)) {
			var3 = var3.b();
		}

		if (var3.o() < 1) {
			return false;
		} else {
			var3 = var3.a();

			for (int var5 = 0; var5 < 4; ++var5) {
				class_cj var6 = var3.a(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
				if (var1.d(var6) && class_ago.a(var1, var6.b())) {
					var1.a(var6, Blocks.ae.S(), 2);
					TileEntity var7 = var1.s(var6);
					if (var7 instanceof class_aok) {
						class_oj.a(var2, a, ((class_aok) var7), b);
					}

					class_cj var8 = var6.f();
					class_cj var9 = var6.e();
					class_cj var10 = var6.c();
					class_cj var11 = var6.d();
					if (var1.d(var9) && class_ago.a(var1, var9.b())) {
						var1.a(var9, Blocks.aa.S(), 2);
					}

					if (var1.d(var8) && class_ago.a(var1, var8.b())) {
						var1.a(var8, Blocks.aa.S(), 2);
					}

					if (var1.d(var10) && class_ago.a(var1, var10.b())) {
						var1.a(var10, Blocks.aa.S(), 2);
					}

					if (var1.d(var11) && class_ago.a(var1, var11.b())) {
						var1.a(var11, Blocks.aa.S(), 2);
					}

					return true;
				}
			}

			return false;
		}
	}
}
