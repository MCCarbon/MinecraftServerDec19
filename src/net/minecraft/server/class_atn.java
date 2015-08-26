package net.minecraft.server;

import java.util.Random;

public class class_atn extends class_asp {
	private Block a;

	public class_atn(Block var1) {
		a = var1;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		if (var1.p(var3.a()).c() != Blocks.STONE) {
			return false;
		} else if (var1.p(var3.b()).c() != Blocks.STONE) {
			return false;
		} else if ((var1.p(var3).c().v() != class_avq.a) && (var1.p(var3).c() != Blocks.STONE)) {
			return false;
		} else {
			int var4 = 0;
			if (var1.p(var3.e()).c() == Blocks.STONE) {
				++var4;
			}

			if (var1.p(var3.f()).c() == Blocks.STONE) {
				++var4;
			}

			if (var1.p(var3.c()).c() == Blocks.STONE) {
				++var4;
			}

			if (var1.p(var3.d()).c() == Blocks.STONE) {
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

			if ((var4 == 3) && (var5 == 1)) {
				var1.a(var3, a.S(), 2);
				var1.a(a, var3, var2);
			}

			return true;
		}
	}
}
