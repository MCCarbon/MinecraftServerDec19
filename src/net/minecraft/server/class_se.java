package net.minecraft.server;


public class class_se {
	protected class_rh a;
	protected double b;
	protected double c;
	protected double d;
	protected double e;
	protected boolean f;

	public class_se(class_rh var1) {
		a = var1;
		b = var1.s;
		c = var1.t;
		d = var1.u;
	}

	public boolean a() {
		return f;
	}

	public double b() {
		return e;
	}

	public void a(double var1, double var3, double var5, double var7) {
		b = var1;
		c = var3;
		d = var5;
		e = var7;
		f = true;
	}

	public void c() {
		a.o(0.0F);
		if (f) {
			f = false;
			int var1 = MathHelper.c(a.aX().b + 0.5D);
			double var2 = b - a.s;
			double var4 = d - a.u;
			double var6 = c - var1;
			double var8 = (var2 * var2) + (var6 * var6) + (var4 * var4);
			if (var8 >= 2.500000277905201E-7D) {
				float var10 = (float) ((MathHelper.b(var4, var2) * 180.0D) / 3.1415927410125732D) - 90.0F;
				a.y = this.a(a.y, var10, 30.0F);
				a.l((float) (e * a.a(class_yf.d).e()));
				if ((var6 > 0.0D) && (((var2 * var2) + (var4 * var4)) < 1.0D)) {
					a.s().a();
				}

			}
		}
	}

	protected float a(float var1, float var2, float var3) {
		float var4 = MathHelper.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		float var5 = var1 + var4;
		if (var5 < 0.0F) {
			var5 += 360.0F;
		} else if (var5 > 360.0F) {
			var5 -= 360.0F;
		}

		return var5;
	}

	public double d() {
		return b;
	}

	public double e() {
		return c;
	}

	public double f() {
		return d;
	}
}
