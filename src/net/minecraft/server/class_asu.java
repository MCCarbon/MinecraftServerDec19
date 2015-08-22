package net.minecraft.server;

import java.util.Random;

public class class_asu extends class_asp {
	private final class_ail a;
	private final boolean b;

	public class_asu(class_ail var1, boolean var2) {
		a = var1;
		b = var2;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		if (var1.p(var3.a()).c() != class_aim.aV) {
			return false;
		} else if ((var1.p(var3).c().v() != class_avq.a) && (var1.p(var3).c() != class_aim.aV)) {
			return false;
		} else {
			int var4 = 0;
			if (var1.p(var3.e()).c() == class_aim.aV) {
				++var4;
			}

			if (var1.p(var3.f()).c() == class_aim.aV) {
				++var4;
			}

			if (var1.p(var3.c()).c() == class_aim.aV) {
				++var4;
			}

			if (var1.p(var3.d()).c() == class_aim.aV) {
				++var4;
			}

			if (var1.p(var3.b()).c() == class_aim.aV) {
				++var4;
			}

			int var5 = 0;
			if (var1.d(var3.e())) {
				++var5;
			}

			if (var1.d(var3.f())) {
				++var5;
			}

			if (var1.d(var3.c())) {
				++var5;
			}

			if (var1.d(var3.d())) {
				++var5;
			}

			if (var1.d(var3.b())) {
				++var5;
			}

			if ((!b && (var4 == 4) && (var5 == 1)) || (var4 == 5)) {
				var1.a(var3, a.S(), 2);
				var1.a(a, var3, var2);
			}

			return true;
		}
	}
}
