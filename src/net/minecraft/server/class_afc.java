package net.minecraft.server;


public class class_afc extends class_afj {
	public class_afc(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.k, var2);
		this.c("arrowDamage");
	}

	@Override
	public int a(int var1) {
		return 1 + ((var1 - 1) * 10);
	}

	@Override
	public int b(int var1) {
		return this.a(var1) + 15;
	}

	@Override
	public int b() {
		return 5;
	}
}
