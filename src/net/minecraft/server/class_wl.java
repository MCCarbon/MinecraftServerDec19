package net.minecraft.server;


public class class_wl extends class_vz {
	private boolean b;
	private class_axc c;
	private class_aym d;

	public class_wl(class_vx var1) {
		super(var1);
	}

	@Override
	public void c() {
		if (!b) {
			class_cj var1 = a.o.r(class_aso.a);
			double var2 = a.c(var1);
			if (var2 > 100.0D) {
				a.cy().a(class_wm.a);
			}
		} else {
			b = false;
			j();
		}

	}

	@Override
	public void d() {
		b = true;
		c = null;
		d = null;
	}

	private void j() {
		int var1 = a.n();
		class_aym var2 = a.a(1.0F);
		int var3 = a.k(-var2.a * 40.0D, 105.0D, -var2.c * 40.0D);
		if ((a.cz() != null) && (a.cz().c() >= 0)) {
			var3 %= 12;
			if (var3 < 0) {
				var3 += 12;
			}
		} else {
			var3 -= 12;
			var3 &= 7;
			var3 += 12;
		}

		c = a.a(var1, var3, (class_axa) null);
		if (c != null) {
			c.a();
			k();
		}

	}

	private void k() {
		class_aym var1 = c.f();
		c.a();

		double var2;
		do {
			var2 = var1.b + a.bj().nextFloat() * 20.0F;
		} while (var2 < var1.b);

		d = new class_aym(var1.a, var2, var1.c);
	}

	@Override
	public class_aym g() {
		return d;
	}

	@Override
	public class_wm i() {
		return class_wm.e;
	}
}
