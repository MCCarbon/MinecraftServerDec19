package net.minecraft.server;


public class class_tt extends class_sr {
	private class_ro a;
	private boolean b;

	public class_tt(class_ro var1) {
		a = var1;
		this.a(5);
	}

	@Override
	public boolean a() {
		if (!a.cE()) {
			return false;
		} else if (a.Y()) {
			return false;
		} else if (!a.C) {
			return false;
		} else {
			class_rg var1 = a.cH();
			return var1 == null ? true : ((a.h(var1) < 144.0D) && (var1.bk() != null) ? false : b);
		}
	}

	@Override
	public void c() {
		a.u().n();
		a.o(true);
	}

	@Override
	public void d() {
		a.o(false);
	}

	public void a(boolean var1) {
		b = var1;
	}
}
