package net.minecraft.server;


public class class_aff extends class_afj {
	public class_aff(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.k, var2);
		this.c("arrowKnockback");
	}

	@Override
	public int a(int var1) {
		return 12 + ((var1 - 1) * 20);
	}

	@Override
	public int b(int var1) {
		return this.a(var1) + 25;
	}

	@Override
	public int b() {
		return 2;
	}
}
