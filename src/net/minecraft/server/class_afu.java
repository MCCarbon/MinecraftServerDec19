package net.minecraft.server;

import java.util.Random;

public class class_afu extends class_afj {
	public class_afu(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.e, var2);
		this.c("thorns");
	}

	@Override
	public int a(int var1) {
		return 10 + (20 * (var1 - 1));
	}

	@Override
	public int b(int var1) {
		return super.a(var1) + 50;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public boolean a(class_aco var1) {
		return var1.b() instanceof class_aav ? true : super.a(var1);
	}

	@Override
	public void b(class_rg var1, class_qx var2, int var3) {
		Random var4 = var1.bj();
		class_aco var5 = class_afl.b(class_afn.h, var1);
		if (a(var3, var4)) {
			if (var2 != null) {
				var2.a(class_qi.a((class_qx) var1), b(var3, var4));
				var2.a("damage.thorns", 0.5F, 1.0F);
			}

			if (var5 != null) {
				var5.a(3, var1);
			}
		} else if (var5 != null) {
			var5.a(1, var1);
		}

	}

	public static boolean a(int var0, Random var1) {
		return var0 <= 0 ? false : var1.nextFloat() < (0.15F * var0);
	}

	public static int b(int var0, Random var1) {
		return var0 > 10 ? var0 - 10 : 1 + var1.nextInt(4);
	}
}
