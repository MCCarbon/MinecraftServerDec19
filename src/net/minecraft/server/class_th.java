package net.minecraft.server;


public class class_th extends class_sr {
	private class_vp a;
	private class_yp b;
	private int c;

	public class_th(class_vp var1) {
		a = var1;
		this.a(3);
	}

	@Override
	public boolean a() {
		if (!a.o.z()) {
			return false;
		} else if (a.bj().nextInt(8000) != 0) {
			return false;
		} else {
			b = (class_yp) a.o.a(class_yp.class, a.aX().b(6.0D, 2.0D, 6.0D), a);
			return b != null;
		}
	}

	@Override
	public boolean b() {
		return c > 0;
	}

	@Override
	public void c() {
		c = 400;
		a.a(true);
	}

	@Override
	public void d() {
		a.a(false);
		b = null;
	}

	@Override
	public void e() {
		a.q().a(b, 30.0F, 30.0F);
		--c;
	}
}
