package net.minecraft.server;

public class class_bz extends Exception {
	private final Object[] a;

	public class_bz(String var1, Object... var2) {
		super(var1);
		a = var2;
	}

	public Object[] a() {
		return a;
	}
}
