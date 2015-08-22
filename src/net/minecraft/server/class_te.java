package net.minecraft.server;


public class class_te extends class_sr {
	private class_rn a;
	private class_rg b;
	private double c;
	private double d;
	private double e;
	private double f;
	private float g;

	public class_te(class_rn var1, double var2, float var4) {
		a = var1;
		f = var2;
		g = var4;
		this.a(1);
	}

	@Override
	public boolean a() {
		b = a.w();
		if (b == null) {
			return false;
		} else if (b.h(a) > g * g) {
			return false;
		} else {
			class_aym var1 = class_us.a(a, 16, 7, new class_aym(b.s, b.t, b.u));
			if (var1 == null) {
				return false;
			} else {
				c = var1.a;
				d = var1.b;
				e = var1.c;
				return true;
			}
		}
	}

	@Override
	public boolean b() {
		return !a.u().m() && b.al() && (b.h(a) < g * g);
	}

	@Override
	public void d() {
		b = null;
	}

	@Override
	public void c() {
		a.u().a(c, d, e, f);
	}
}
