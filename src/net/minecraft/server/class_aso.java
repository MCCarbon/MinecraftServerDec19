package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_aso extends class_asp {
	public static final class_cj a = new class_cj(0, 0, 0);
	public static final class_cj b;
	private final boolean c;

	public class_aso(boolean var1) {
		c = var1;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		Iterator var4 = class_cj.b(new class_cj(var3.n() - 4, var3.o() - 1, var3.p() - 4), new class_cj(var3.n() + 4, var3.o() + 32, var3.p() + 4)).iterator();

		while (var4.hasNext()) {
			class_cj.class_a_in_class_cj var5 = (class_cj.class_a_in_class_cj) var4.next();
			double var6 = var5.d(var3.n(), var5.o(), var3.p());
			if (var6 <= 3.5D) {
				if (var5.o() < var3.o()) {
					if (var6 <= 2.5D) {
						a(var1, var5, class_aim.h.S());
					} else if (var5.o() < var3.o()) {
						a(var1, var5, class_aim.bH.S());
					}
				} else if (var5.o() > var3.o()) {
					a(var1, var5, class_aim.a.S());
				} else if (var6 > 2.5D) {
					a(var1, var5, class_aim.h.S());
				} else if (c) {
					a(var1, new class_cj(var5), class_aim.bF.S());
				} else {
					a(var1, new class_cj(var5), class_aim.a.S());
				}
			}
		}

		for (int var8 = 0; var8 < 4; ++var8) {
			a(var1, var3.b(var8), class_aim.h.S());
		}

		class_cj var9 = var3.b(2);
		Iterator var10 = class_cq.class_c_in_class_cq.a.iterator();

		while (var10.hasNext()) {
			class_cq var11 = (class_cq) var10.next();
			a(var1, var9.a(var11), class_aim.aa.S().a(class_anr.a, var11));
		}

		return true;
	}

	static {
		b = new class_cj((a.n() - 4) & -16, 0, (a.p() - 4) & -16);
	}
}
