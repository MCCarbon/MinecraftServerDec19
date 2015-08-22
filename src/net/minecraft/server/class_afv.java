package net.minecraft.server;


public class class_afv extends class_afj {
	protected class_afv(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.h, var2);
		this.c("untouching");
	}

	@Override
	public int a(int var1) {
		return 15;
	}

	@Override
	public int b(int var1) {
		return super.a(var1) + 50;
	}

	@Override
	public int b() {
		return 1;
	}

	@Override
	public boolean a(class_afj var1) {
		return super.a(var1) && (var1 != class_afn.s);
	}

	@Override
	public boolean a(class_aco var1) {
		return var1.b() == class_acq.bg ? true : super.a(var1);
	}
}
