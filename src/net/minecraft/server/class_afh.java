package net.minecraft.server;

import java.util.Random;

public class class_afh extends class_afj {
	protected class_afh(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.j, var2);
		this.c("durability");
	}

	@Override
	public int a(int var1) {
		return 5 + ((var1 - 1) * 8);
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
		return var1.e() ? true : super.a(var1);
	}

	public static boolean a(class_aco var0, int var1, Random var2) {
		return (var0.b() instanceof class_aav) && (var2.nextFloat() < 0.6F) ? false : var2.nextInt(var1 + 1) > 0;
	}
}
