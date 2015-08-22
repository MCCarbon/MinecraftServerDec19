package net.minecraft.server;


public class class_afs extends class_afj {
	public class_afs(class_afj.class_a_in_class_afj var1, class_rc... var2) {
		super(var1, class_afk.f, var2);
		this.c("oxygen");
	}

	@Override
	public int a(int var1) {
		return 10 * var1;
	}

	@Override
	public int b(int var1) {
		return this.a(var1) + 30;
	}

	@Override
	public int b() {
		return 3;
	}
}
