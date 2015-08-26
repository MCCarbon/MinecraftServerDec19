package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

import com.google.common.base.Predicates;

public class class_ask extends class_asp {
	private static final class_apv a;
	private final class_apn b;
	private final class_apn c;
	private final class_apn d;

	public class_ask() {
		b = Blocks.STONE_SLAB.S().a(class_anm.N, class_anm.class_a_in_class_anm.b).a(BlockStepAbstract.a, BlockStepAbstract.class_a_in_class_akq.b);
		c = Blocks.SANDSTONE.S();
		d = Blocks.FLOWING_WATER.S();
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		while (var1.d(var3) && (var3.o() > 2)) {
			var3 = var3.b();
		}

		if (!a.a(var1.p(var3))) {
			return false;
		} else {
			int var4;
			int var5;
			for (var4 = -2; var4 <= 2; ++var4) {
				for (var5 = -2; var5 <= 2; ++var5) {
					if (var1.d(var3.a(var4, -1, var5)) && var1.d(var3.a(var4, -2, var5))) {
						return false;
					}
				}
			}

			for (var4 = -1; var4 <= 0; ++var4) {
				for (var5 = -2; var5 <= 2; ++var5) {
					for (int var6 = -2; var6 <= 2; ++var6) {
						var1.a(var3.a(var5, var4, var6), c, 2);
					}
				}
			}

			var1.a(var3, d, 2);
			Iterator var7 = class_cq.class_c_in_class_cq.a.iterator();

			while (var7.hasNext()) {
				class_cq var8 = (class_cq) var7.next();
				var1.a(var3.a(var8), d, 2);
			}

			for (var4 = -2; var4 <= 2; ++var4) {
				for (var5 = -2; var5 <= 2; ++var5) {
					if ((var4 == -2) || (var4 == 2) || (var5 == -2) || (var5 == 2)) {
						var1.a(var3.a(var4, 1, var5), c, 2);
					}
				}
			}

			var1.a(var3.a(2, 1, 0), b, 2);
			var1.a(var3.a(-2, 1, 0), b, 2);
			var1.a(var3.a(0, 1, 2), b, 2);
			var1.a(var3.a(0, 1, -2), b, 2);

			for (var4 = -1; var4 <= 1; ++var4) {
				for (var5 = -1; var5 <= 1; ++var5) {
					if ((var4 == 0) && (var5 == 0)) {
						var1.a(var3.a(var4, 4, var5), c, 2);
					} else {
						var1.a(var3.a(var4, 4, var5), b, 2);
					}
				}
			}

			for (var4 = 1; var4 <= 3; ++var4) {
				var1.a(var3.a(-1, var4, -1), c, 2);
				var1.a(var3.a(-1, var4, 1), c, 2);
				var1.a(var3.a(1, var4, -1), c, 2);
				var1.a(var3.a(1, var4, 1), c, 2);
			}

			return true;
		}
	}

	static {
		a = class_apv.a(Blocks.SAND).a(BlockSand.a, Predicates.equalTo(BlockSand.class_a_in_class_ams.a));
	}
}
