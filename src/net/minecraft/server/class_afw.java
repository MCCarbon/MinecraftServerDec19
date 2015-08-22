package net.minecraft.server;


public class class_afw extends class_afj {
	public class_afw(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.c, var2);
		this.c("waterWalker");
	}

	@Override
	public int a(int var1) {
		return var1 * 10;
	}

	@Override
	public int b(int var1) {
		return this.a(var1) + 15;
	}

	@Override
	public int b() {
		return 3;
	}
}
