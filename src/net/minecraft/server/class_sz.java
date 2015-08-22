package net.minecraft.server;


public class class_sz extends class_sr {
	class_ago a;
	protected class_rn b;
	int c;
	double d;
	boolean e;
	class_axc f;
	Class g;
	private int h;
	private double i;
	private double j;
	private double k;

	public class_sz(class_rn var1, Class var2, double var3, boolean var5) {
		this(var1, var3, var5);
		g = var2;
	}

	public class_sz(class_rn var1, double var2, boolean var4) {
		b = var1;
		a = var1.o;
		d = var2;
		e = var4;
		this.a(3);
	}

	@Override
	public boolean a() {
		class_rg var1 = b.w();
		if (var1 == null) {
			return false;
		} else if (!var1.al()) {
			return false;
		} else if ((g != null) && !g.isAssignableFrom(var1.getClass())) {
			return false;
		} else {
			f = b.u().a(var1);
			return f != null;
		}
	}

	@Override
	public boolean b() {
		class_rg var1 = b.w();
		return var1 == null ? false : (!var1.al() ? false : (!e ? !b.u().m() : b.e(new class_cj(var1))));
	}

	@Override
	public void c() {
		b.u().a(f, d);
		h = 0;
	}

	@Override
	public void d() {
		b.u().n();
	}

	@Override
	public void e() {
		class_rg var1 = b.w();
		b.q().a(var1, 30.0F, 30.0F);
		double var2 = b.e(var1.s, var1.aX().b, var1.u);
		double var4 = this.a(var1);
		--h;
		if ((e || b.v().a(var1)) && (h <= 0) && (((i == 0.0D) && (j == 0.0D) && (k == 0.0D)) || (var1.e(i, j, k) >= 1.0D) || (b.bj().nextFloat() < 0.05F))) {
			i = var1.s;
			j = var1.aX().b;
			k = var1.u;
			h = 4 + b.bj().nextInt(7);
			if (var2 > 1024.0D) {
				h += 10;
			} else if (var2 > 256.0D) {
				h += 5;
			}

			if (!b.u().a(var1, d)) {
				h += 15;
			}
		}

		c = Math.max(c - 1, 0);
		if ((var2 <= var4) && (c <= 0)) {
			c = 20;
			b.a(class_pu.a);
			b.r(var1);
		}

	}

	protected double a(class_rg var1) {
		return (b.J * 2.0F * b.J * 2.0F) + var1.J;
	}
}
