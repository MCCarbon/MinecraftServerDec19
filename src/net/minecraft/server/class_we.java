package net.minecraft.server;


public class class_we extends class_vz {
	private class_axc b;
	private class_aym c;

	public class_we(class_vx var1) {
		super(var1);
	}

	@Override
	public class_wm i() {
		return class_wm.c;
	}

	@Override
	public void d() {
		b = null;
		c = null;
	}

	@Override
	public void c() {
		double var1 = c == null ? 0.0D : c.c(a.s, a.t, a.u);
		if ((var1 < 100.0D) || (var1 > 22500.0D) || a.D || a.E) {
			j();
		}

	}

	@Override
	public class_aym g() {
		return c;
	}

	private void j() {
		if ((b == null) || b.b()) {
			int var1 = a.n();
			class_cj var2 = a.o.r(class_aso.a);
			class_yu var3 = a.o.a(var2, 128.0D, 128.0D);
			int var4;
			if (var3 != null) {
				class_aym var5 = (new class_aym(var3.s, 0.0D, var3.u)).a();
				var4 = a.k(-var5.a * 40.0D, 105.0D, -var5.c * 40.0D);
			} else {
				var4 = a.k(40.0D, var2.o(), 0.0D);
			}

			class_axa var6 = new class_axa(var2.n(), var2.o(), var2.p());
			b = a.a(var1, var4, var6);
			if (b != null) {
				b.a();
			}
		}

		k();
		if ((b != null) && b.b()) {
			a.cy().a(class_wm.d);
		}

	}

	private void k() {
		if ((b != null) && !b.b()) {
			class_aym var1 = b.f();
			b.a();
			double var2 = var1.a;
			double var4 = var1.c;

			double var6;
			do {
				var6 = var1.b + a.bj().nextFloat() * 20.0F;
			} while (var6 < var1.b);

			c = new class_aym(var2, var6, var4);
		}

	}
}
