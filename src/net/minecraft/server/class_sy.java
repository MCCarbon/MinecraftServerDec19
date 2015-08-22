package net.minecraft.server;


public class class_sy extends class_sr {
	private class_yp b;
	private class_yp c;
	private class_ago d;
	private int e;
	class_uv a;

	public class_sy(class_yp var1) {
		b = var1;
		d = var1.o;
		this.a(3);
	}

	@Override
	public boolean a() {
		if (b.k() != 0) {
			return false;
		} else if (b.bj().nextInt(500) != 0) {
			return false;
		} else {
			a = d.ag().a(new class_cj(b), 0);
			if (a == null) {
				return false;
			} else if (f() && b.o(true)) {
				class_qx var1 = d.a(class_yp.class, b.aX().b(8.0D, 3.0D, 8.0D), b);
				if (var1 == null) {
					return false;
				} else {
					c = (class_yp) var1;
					return (c.k() == 0) && c.o(true);
				}
			} else {
				return false;
			}
		}
	}

	@Override
	public void c() {
		e = 300;
		b.m(true);
	}

	@Override
	public void d() {
		a = null;
		c = null;
		b.m(false);
	}

	@Override
	public boolean b() {
		return (e >= 0) && f() && (b.k() == 0) && b.o(false);
	}

	@Override
	public void e() {
		--e;
		b.q().a(c, 10.0F, 30.0F);
		if (b.h(c) > 2.25D) {
			b.u().a(c, 0.25D);
		} else if ((e == 0) && c.cF()) {
			g();
		}

		if (b.bj().nextInt(35) == 0) {
			d.a(b, (byte) 12);
		}

	}

	private boolean f() {
		if (!a.i()) {
			return false;
		} else {
			int var1 = (int) ((a.c()) * 0.35D);
			return a.e() < var1;
		}
	}

	private void g() {
		class_yp var1 = b.b(c);
		c.b(6000);
		b.b(6000);
		c.p(false);
		b.p(false);
		var1.b(-24000);
		var1.b(b.s, b.t, b.u, 0.0F, 0.0F);
		d.a(var1);
		d.a(var1, (byte) 12);
	}
}
