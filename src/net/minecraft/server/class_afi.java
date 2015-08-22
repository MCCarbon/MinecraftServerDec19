package net.minecraft.server;


public class class_afi extends class_afj {
	protected class_afi(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.h, var2);
		this.c("digging");
	}

	@Override
	public int a(int var1) {
		return 1 + (10 * (var1 - 1));
	}

	@Override
	public int b(int var1) {
		return super.a(var1) + 50;
	}

	@Override
	public int b() {
		return 5;
	}

	@Override
	public boolean a(class_aco var1) {
		return var1.b() == Items.bg ? true : super.a(var1);
	}
}
