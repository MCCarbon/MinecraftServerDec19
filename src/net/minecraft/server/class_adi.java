package net.minecraft.server;


public class class_adi extends class_acn {
	private final class_lm a;

	public class_adi(class_lm var1) {
		a = var1;
	}

	@Override
	protected void b(class_acm var1, int var2) {
		super.b(var1, var2);
		a.a.a((new class_gh(var1, var2)));
	}

	@Override
	protected void c(class_acm var1) {
		super.c(var1);
		a.a.a((new class_gh(var1, 0)));
	}
}
