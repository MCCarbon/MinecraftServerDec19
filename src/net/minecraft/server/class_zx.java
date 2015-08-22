package net.minecraft.server;


public class class_zx extends class_zu {
	private class_pp a;
	private final class_zx.class_a_in_class_zx f;

	public class_zx(class_pp var1, class_pp var2) {
		a = var2;
		this.a(f = new class_zx.class_a_in_class_zx(var2, 0, 136, 110));
		byte var3 = 36;
		short var4 = 137;

		int var5;
		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.a((new class_aas(var1, var6 + (var5 * 9) + 9, var3 + (var6 * 18), var4 + (var5 * 18))));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a((new class_aas(var1, var5, var3 + (var5 * 18), 58 + var4)));
		}

	}

	@Override
	public void a(class_zz var1) {
		super.a(var1);
		var1.a(this, a);
	}

	public class_pp e() {
		return a;
	}

	@Override
	public void b(class_yu var1) {
		super.b(var1);
		if ((var1 != null) && !var1.o.D) {
			class_aco var2 = f.a(f.a());
			if (var2 != null) {
				var1.a(var2, false);
			}

		}
	}

	@Override
	public boolean a(class_yu var1) {
		return a.a(var1);
	}

	@Override
	public class_aco b(class_yu var1, int var2) {
		class_aco var3 = null;
		class_aas var4 = (class_aas) c.get(var2);
		if ((var4 != null) && var4.e()) {
			class_aco var5 = var4.d();
			var3 = var5.k();
			if (var2 == 0) {
				if (!this.a(var5, 1, 37, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (!f.e() && f.a(var5) && (var5.b == 1)) {
				if (!this.a(var5, 0, 1, false)) {
					return null;
				}
			} else if ((var2 >= 1) && (var2 < 28)) {
				if (!this.a(var5, 28, 37, false)) {
					return null;
				}
			} else if ((var2 >= 28) && (var2 < 37)) {
				if (!this.a(var5, 1, 28, false)) {
					return null;
				}
			} else if (!this.a(var5, 1, 37, false)) {
				return null;
			}

			if (var5.b == 0) {
				var4.d((class_aco) null);
			} else {
				var4.f();
			}

			if (var5.b == var3.b) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}

	class class_a_in_class_zx extends class_aas {
		public class_a_in_class_zx(class_pp var2, int var3, int var4, int var5) {
			super(var2, var3, var4, var5);
		}

		@Override
		public boolean a(class_aco var1) {
			return var1 == null ? false : (var1.b() == class_acq.bT) || (var1.b() == class_acq.k) || (var1.b() == class_acq.m) || (var1.b() == class_acq.l);
		}

		@Override
		public int a() {
			return 1;
		}
	}
}
