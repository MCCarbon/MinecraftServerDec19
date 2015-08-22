package net.minecraft.server;


public class class_cp extends class_dd {
	private final Object a;

	public class_cp(Object var1) {
		a = var1;
	}

	@Override
	public Object c(Object var1) {
		Object var2 = super.c(var1);
		return var2 == null ? a : var2;
	}
}
