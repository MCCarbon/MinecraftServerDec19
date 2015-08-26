package net.minecraft.server;


public class class_wd extends class_vz {
	private class_axc b;
	private class_aym c;
	private boolean d;

	public class_wd(class_vx var1) {
		super(var1);
	}

	@Override
	public class_wm i() {
		return class_wm.a;
	}

	@Override
	public void c() {
		double var1 = c == null ? 0.0D : c.c(a.s, a.t, a.u);
		if ((var1 < 100.0D) || (var1 > 22500.0D) || a.D || a.E) {
			j();
		}

	}

	@Override
	public void d() {
		b = null;
		c = null;
	}

	@Override
	public class_aym g() {
		return c;
	}

	private void j() {
		int var2;
		if ((b != null) && b.b()) {
			class_cj var1 = a.o.r(new class_cj(class_aso.a));
			var2 = a.cz() == null ? 0 : a.cz().c();
			if (a.bj().nextInt(var2 + 3) == 0) {
				a.cy().a(class_wm.c);
				return;
			}

			double var3 = 64.0D;
			class_yu var5 = a.o.a(var1, var3, var3);
			if (var5 != null) {
				var3 = var5.c(var1) / 512.0D;
			}

			if ((var5 != null) && ((a.bj().nextInt(MathHelper.a((int) var3) + 2) == 0) || (a.bj().nextInt(var2 + 2) == 0))) {
				this.a(var5);
				return;
			}
		}

		if ((b == null) || b.b()) {
			int var6 = a.n();
			var2 = var6;
			if (a.bj().nextInt(8) == 0) {
				d = !d;
				var2 = var6 + 6;
			}

			if (d) {
				++var2;
			} else {
				--var2;
			}

			if ((a.cz() != null) && (a.cz().c() >= 0)) {
				var2 %= 12;
				if (var2 < 0) {
					var2 += 12;
				}
			} else {
				var2 -= 12;
				var2 &= 7;
				var2 += 12;
			}

			b = a.a(var6, var2, (class_axa) null);
			if (b != null) {
				b.a();
			}
		}

		k();
	}

	private void a(class_yu var1) {
		a.cy().a(class_wm.b);
		((class_wk) a.cy().b(class_wm.b)).a(var1);
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

	@Override
	public void a(class_vw var1, class_cj var2, class_qi var3, class_yu var4) {
		if (var4 != null) {
			this.a(var4);
		}

	}
}
