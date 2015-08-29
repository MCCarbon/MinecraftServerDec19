package net.minecraft.server;


public class class_sw extends class_sr {
	protected EntityInsentient a;
	protected Entity b;
	protected float c;
	private int e;
	private float f;
	protected Class d;

	public class_sw(EntityInsentient var1, Class var2, float var3) {
		a = var1;
		d = var2;
		c = var3;
		f = 0.02F;
		this.a(2);
	}

	public class_sw(EntityInsentient var1, Class var2, float var3, float var4) {
		a = var1;
		d = var2;
		c = var3;
		f = var4;
		this.a(2);
	}

	@Override
	public boolean a() {
		if (a.bj().nextFloat() >= f) {
			return false;
		} else {
			if (a.w() != null) {
				b = a.w();
			}

			if (d == class_yu.class) {
				b = a.o.a(a, c);
			} else {
				b = a.o.a(d, a.aX().b(c, 3.0D, c), a);
			}

			return b != null;
		}
	}

	@Override
	public boolean b() {
		return !b.al() ? false : (a.h(b) > c * c ? false : e > 0);
	}

	@Override
	public void c() {
		e = 40 + a.bj().nextInt(40);
	}

	@Override
	public void d() {
		b = null;
	}

	@Override
	public void e() {
		a.q().a(b.s, b.t + b.aY(), b.u, a.ci(), a.ch());
		--e;
	}
}
