package net.minecraft.server;


public class class_zs {
	private int a = 20;
	private float b = 5.0F;
	private float c;
	private int d;
	private int e = 20;

	public void a(int var1, float var2) {
		a = Math.min(var1 + a, 20);
		b = Math.min(b + (var1 * var2 * 2.0F), a);
	}

	public void a(class_aci var1, class_aco var2) {
		this.a(var1.h(var2), var1.i(var2));
	}

	public void a(class_yu var1) {
		class_ps var2 = var1.o.ac();
		e = a;
		if (c > 4.0F) {
			c -= 4.0F;
			if (b > 0.0F) {
				b = Math.max(b - 1.0F, 0.0F);
			} else if (var2 != class_ps.a) {
				a = Math.max(a - 1, 0);
			}
		}

		if (var1.o.S().b("naturalRegeneration") && (a >= 18) && var1.cu()) {
			++d;
			if (d >= 80) {
				var1.b(1.0F);
				this.a(3.0F);
				d = 0;
			}
		} else if (a <= 0) {
			++d;
			if (d >= 80) {
				if ((var1.bu() > 10.0F) || (var2 == class_ps.d) || ((var1.bu() > 1.0F) && (var2 == class_ps.c))) {
					var1.a(class_qi.g, 1.0F);
				}

				d = 0;
			}
		} else {
			d = 0;
		}

	}

	public void a(class_dn var1) {
		if (var1.b("foodLevel", 99)) {
			a = var1.h("foodLevel");
			d = var1.h("foodTickTimer");
			b = var1.j("foodSaturationLevel");
			c = var1.j("foodExhaustionLevel");
		}

	}

	public void b(class_dn var1) {
		var1.a("foodLevel", a);
		var1.a("foodTickTimer", d);
		var1.a("foodSaturationLevel", b);
		var1.a("foodExhaustionLevel", c);
	}

	public int a() {
		return a;
	}

	public boolean c() {
		return a < 20;
	}

	public void a(float var1) {
		c = Math.min(c + var1, 40.0F);
	}

	public float e() {
		return b;
	}

	public void a(int var1) {
		a = var1;
	}
}
