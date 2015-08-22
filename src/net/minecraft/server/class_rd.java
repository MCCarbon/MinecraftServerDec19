package net.minecraft.server;


public class class_rd extends Entity {
	public int a;
	public int b;
	public int c;
	private int d = 5;
	private int e;
	private class_yu f;
	private int g;

	public class_rd(class_ago var1, double var2, double var4, double var6, int var8) {
		super(var1);
		this.a(0.5F, 0.5F);
		this.b(var2, var4, var6);
		y = (float) (Math.random() * 360.0D);
		v = (float) ((Math.random() * 0.20000000298023224D) - 0.10000000149011612D) * 2.0F;
		w = (float) (Math.random() * 0.2D) * 2.0F;
		x = (float) ((Math.random() * 0.20000000298023224D) - 0.10000000149011612D) * 2.0F;
		e = var8;
	}

	@Override
	protected boolean U() {
		return false;
	}

	public class_rd(class_ago var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	@Override
	protected void h() {
	}

	@Override
	public void r_() {
		super.r_();
		if (c > 0) {
			--c;
		}

		p = s;
		q = t;
		r = u;
		w -= 0.029999999329447746D;
		if (o.p(new class_cj(this)).c().v() == class_avq.i) {
			w = 0.20000000298023224D;
			v = (V.nextFloat() - V.nextFloat()) * 0.2F;
			x = (V.nextFloat() - V.nextFloat()) * 0.2F;
			this.a("random.fizz", 0.4F, 2.0F + (V.nextFloat() * 0.4F));
		}

		this.j(s, (aX().b + aX().e) / 2.0D, u);
		double var1 = 8.0D;
		if (g < ((a - 20) + (G() % 100))) {
			if ((f == null) || (f.h(this) > (var1 * var1))) {
				f = o.a(this, var1);
			}

			g = a;
		}

		if ((f != null) && f.w()) {
			f = null;
		}

		if (f != null) {
			double var3 = (f.s - s) / var1;
			double var5 = ((f.t + f.aY()) - t) / var1;
			double var7 = (f.u - u) / var1;
			double var9 = Math.sqrt((var3 * var3) + (var5 * var5) + (var7 * var7));
			double var11 = 1.0D - var9;
			if (var11 > 0.0D) {
				var11 *= var11;
				v += (var3 / var9) * var11 * 0.1D;
				w += (var5 / var9) * var11 * 0.1D;
				x += (var7 / var9) * var11 * 0.1D;
			}
		}

		this.d(v, w, x);
		float var13 = 0.98F;
		if (C) {
			var13 = o.p(new class_cj(class_oa.c(s), class_oa.c(aX().b) - 1, class_oa.c(u))).c().L * 0.98F;
		}

		v *= var13;
		w *= 0.9800000190734863D;
		x *= var13;
		if (C) {
			w *= -0.8999999761581421D;
		}

		++a;
		++b;
		if (b >= 6000) {
			L();
		}

	}

	@Override
	public boolean Z() {
		return o.a(aX(), class_avq.h, this);
	}

	@Override
	protected void f(int var1) {
		this.a(class_qi.a, var1);
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			af();
			d = (int) (d - var2);
			if (d <= 0) {
				L();
			}

			return false;
		}
	}

	@Override
	public void b(class_dn var1) {
		var1.a("Health", (short) d);
		var1.a("Age", (short) b);
		var1.a("Value", (short) e);
	}

	@Override
	public void a(class_dn var1) {
		d = var1.g("Health");
		b = var1.g("Age");
		e = var1.g("Value");
	}

	@Override
	public void d(class_yu var1) {
		if (!o.D) {
			if ((c == 0) && (var1.bx == 0)) {
				var1.bx = 2;
				o.a((Entity) var1, "random.orb", 0.1F, 0.5F * (((V.nextFloat() - V.nextFloat()) * 0.7F) + 1.8F));
				var1.a(this, 1);
				var1.m(e);
				L();
			}

		}
	}

	public int i() {
		return e;
	}

	public static int a(int var0) {
		return var0 >= 2477 ? 2477 : (var0 >= 1237 ? 1237 : (var0 >= 617 ? 617 : (var0 >= 307 ? 307 : (var0 >= 149 ? 149 : (var0 >= 73 ? 73 : (var0 >= 37 ? 37 : (var0 >= 17 ? 17 : (var0 >= 7 ? 7 : (var0 >= 3 ? 3 : 1)))))))));
	}

	@Override
	public boolean aJ() {
		return false;
	}
}
