package net.minecraft.server;


public class class_tz extends class_sz {
	private final class_yl h;

	public class_tz(class_yl var1, Class var2, double var3, boolean var5) {
		super(var1, var2, var3, var5);
		h = var1;
	}

	@Override
	public void c() {
		super.c();
		h.a(true);
	}

	@Override
	public void d() {
		super.d();
		h.a(false);
	}
}
