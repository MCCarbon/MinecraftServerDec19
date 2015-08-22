package net.minecraft.server;


public class class_sd {
	private class_rh a;
	private float b;
	private float c;
	private boolean d;
	private double e;
	private double f;
	private double g;

	public class_sd(class_rh var1) {
		a = var1;
	}

	public void a(class_qx var1, float var2, float var3) {
		e = var1.s;
		if (var1 instanceof class_rg) {
			f = var1.t + var1.aY();
		} else {
			f = (var1.aX().b + var1.aX().e) / 2.0D;
		}

		g = var1.u;
		b = var2;
		c = var3;
		d = true;
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		e = var1;
		f = var3;
		g = var5;
		b = var7;
		c = var8;
		d = true;
	}

	public void a() {
		a.z = 0.0F;
		if (d) {
			d = false;
			double var1 = e - a.s;
			double var3 = f - (a.t + a.aY());
			double var5 = g - a.u;
			double var7 = class_oa.a((var1 * var1) + (var5 * var5));
			float var9 = (float) ((class_oa.b(var5, var1) * 180.0D) / 3.1415927410125732D) - 90.0F;
			float var10 = (float) (-((class_oa.b(var3, var7) * 180.0D) / 3.1415927410125732D));
			a.z = this.a(a.z, var10, c);
			a.aO = this.a(a.aO, var9, b);
		} else {
			a.aO = this.a(a.aO, a.aM, 10.0F);
		}

		float var11 = class_oa.g(a.aO - a.aM);
		if (!a.u().m()) {
			if (var11 < -75.0F) {
				a.aO = a.aM - 75.0F;
			}

			if (var11 > 75.0F) {
				a.aO = a.aM + 75.0F;
			}
		}

	}

	private float a(float var1, float var2, float var3) {
		float var4 = class_oa.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	public boolean b() {
		return d;
	}

	public double e() {
		return e;
	}

	public double f() {
		return f;
	}

	public double g() {
		return g;
	}
}
