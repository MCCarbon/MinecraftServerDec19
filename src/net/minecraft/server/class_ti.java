package net.minecraft.server;


public class class_ti extends class_sl {
	boolean g;
	int h;

	public class_ti(class_rh var1, boolean var2) {
		super(var1);
		a = var1;
		g = var2;
	}

	@Override
	public boolean b() {
		return g && (h > 0) && super.b();
	}

	@Override
	public void c() {
		h = 20;
		c.a(a.o, b, true);
	}

	@Override
	public void d() {
		if (g) {
			c.a(a.o, b, false);
		}

	}

	@Override
	public void e() {
		--h;
		super.e();
	}
}
