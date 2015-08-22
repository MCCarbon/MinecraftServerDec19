package net.minecraft.server;


public class class_tp extends class_sr {
	private final class_yh a;
	private class_rg b;
	private int c = -1;
	private double d;
	private int e;
	private int f;
	private int g;
	private float h;
	private float i;

	public class_tp(class_yh var1, double var2, int var4, int var5, float var6) {
		a = var1;
		d = var2;
		f = var4;
		g = var5;
		h = var6;
		i = var6 * var6;
		this.a(3);
	}

	@Override
	public boolean a() {
		class_rg var1 = a.w();
		if (var1 == null) {
			return false;
		} else {
			b = var1;
			return f();
		}
	}

	protected boolean f() {
		return (a.bG() != null) && (a.bG().b() == class_acq.f);
	}

	@Override
	public boolean b() {
		return (this.a() || !a.u().m()) && f();
	}

	@Override
	public void c() {
		super.c();
		a.a(true);
	}

	@Override
	public void d() {
		super.c();
		a.a(false);
		b = null;
		e = 0;
		c = -1;
		a.ce();
	}

	@Override
	public void e() {
		double var1 = a.e(b.s, b.aX().b, b.u);
		boolean var3 = a.v().a(b);
		boolean var4 = e > 0;
		if (var3 != var4) {
			e = 0;
		}

		if (var3) {
			++e;
		} else {
			--e;
		}

		if ((var1 <= i) && (e >= 20)) {
			a.u().n();
		} else {
			a.u().a(b, d);
		}

		a.q().a(b, 30.0F, 30.0F);
		if (a.bX()) {
			if (!var3 && (e < -60)) {
				a.ce();
			} else if (var3) {
				int var5 = a.cc();
				if (var5 >= 20) {
					a.ce();
					a.a(b, class_abg.b(var5));
					c = f;
				}
			}
		} else if ((--c <= 0) && (e >= -60)) {
			a.c(class_pu.a);
		}

	}
}
