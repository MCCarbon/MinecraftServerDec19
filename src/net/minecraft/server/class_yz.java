package net.minecraft.server;


public class class_yz extends class_qx {
	private double a;
	private double b;
	private double c;
	private int d;
	private boolean e;

	public class_yz(class_ago var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	@Override
	protected void h() {
	}

	public class_yz(class_ago var1, double var2, double var4, double var6) {
		super(var1);
		d = 0;
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
	}

	public void a(class_cj var1) {
		double var2 = var1.n();
		int var4 = var1.o();
		double var5 = var1.p();
		double var7 = var2 - s;
		double var9 = var5 - u;
		float var11 = class_oa.a((var7 * var7) + (var9 * var9));
		if (var11 > 12.0F) {
			a = s + ((var7 / var11) * 12.0D);
			c = u + ((var9 / var11) * 12.0D);
			b = t + 8.0D;
		} else {
			a = var2;
			b = var4;
			c = var5;
		}

		d = 0;
		e = V.nextInt(5) > 0;
	}

	@Override
	public void r_() {
		P = s;
		Q = t;
		R = u;
		super.r_();
		s += v;
		t += w;
		u += x;
		float var1 = class_oa.a((v * v) + (x * x));
		y = (float) ((class_oa.b(v, x) * 180.0D) / 3.1415927410125732D);

		for (z = (float) ((class_oa.b(w, var1) * 180.0D) / 3.1415927410125732D); (z - B) < -180.0F; B -= 360.0F) {
			;
		}

		while ((z - B) >= 180.0F) {
			B += 360.0F;
		}

		while ((y - A) < -180.0F) {
			A -= 360.0F;
		}

		while ((y - A) >= 180.0F) {
			A += 360.0F;
		}

		z = B + ((z - B) * 0.2F);
		y = A + ((y - A) * 0.2F);
		if (!o.D) {
			double var2 = a - s;
			double var4 = c - u;
			float var6 = (float) Math.sqrt((var2 * var2) + (var4 * var4));
			float var7 = (float) class_oa.b(var4, var2);
			double var8 = var1 + ((var6 - var1) * 0.0025D);
			if (var6 < 1.0F) {
				var8 *= 0.8D;
				w *= 0.8D;
			}

			v = Math.cos(var7) * var8;
			x = Math.sin(var7) * var8;
			if (t < b) {
				w += (1.0D - w) * 0.014999999664723873D;
			} else {
				w += (-1.0D - w) * 0.014999999664723873D;
			}
		}

		float var10 = 0.25F;
		if (Y()) {
			for (int var3 = 0; var3 < 4; ++var3) {
				o.a(class_cy.e, s - (v * var10), t - (w * var10), u - (x * var10), v, w, x, new int[0]);
			}
		} else {
			o.a(class_cy.y, ((s - (v * var10)) + (V.nextDouble() * 0.6D)) - 0.3D, t - (w * var10) - 0.5D, ((u - (x * var10)) + (V.nextDouble() * 0.6D)) - 0.3D, v, w, x, new int[0]);
		}

		if (!o.D) {
			this.b(s, t, u);
			++d;
			if ((d > 80) && !o.D) {
				L();
				if (e) {
					o.a((new class_xg(o, s, t, u, new class_aco(class_acq.bM))));
				} else {
					o.b(2003, new class_cj(this), 0);
				}
			}
		}

	}

	@Override
	public void b(class_dn var1) {
	}

	@Override
	public void a(class_dn var1) {
	}

	@Override
	public float f(float var1) {
		return 1.0F;
	}

	@Override
	public boolean aJ() {
		return false;
	}
}
