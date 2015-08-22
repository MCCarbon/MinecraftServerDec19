package net.minecraft.server;


public class class_afp extends class_afj {
	protected class_afp(class_afj.class_a_in_class_afj var1, class_afk var2, class_rc... var3) {
		super(var1, var2, var3);
		this.c("fishingSpeed");
	}

	@Override
	public int a(int var1) {
		return 15 + ((var1 - 1) * 9);
	}

	@Override
	public int b(int var1) {
		return super.a(var1) + 50;
	}

	@Override
	public int b() {
		return 3;
	}
}
