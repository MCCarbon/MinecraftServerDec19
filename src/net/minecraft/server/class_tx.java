package net.minecraft.server;


public class class_tx extends class_sr {
	private class_yp a;

	public class_tx(class_yp var1) {
		a = var1;
		this.a(5);
	}

	@Override
	public boolean a() {
		if (!a.al()) {
			return false;
		} else if (a.Y()) {
			return false;
		} else if (!a.C) {
			return false;
		} else if (a.G) {
			return false;
		} else {
			class_yu var1 = a.t_();
			return var1 == null ? false : (a.h(var1) > 16.0D ? false : var1.bs instanceof class_zu);
		}
	}

	@Override
	public void c() {
		a.u().n();
	}

	@Override
	public void d() {
		a.a((class_yu) null);
	}
}
