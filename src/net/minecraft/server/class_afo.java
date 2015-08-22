package net.minecraft.server;


public class class_afo extends class_afj {
	protected class_afo(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.g, var2);
		this.c("fire");
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
		return 2;
	}
}
