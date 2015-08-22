package net.minecraft.server;


public class class_zy extends class_zu {
	private class_pp a;
	private final class_aas f;
	private int g;

	public class_zy(class_yt var1, class_pp var2) {
		a = var2;
		this.a((new class_zy.class_b_in_class_zy(var1.e, var2, 0, 56, 46)));
		this.a((new class_zy.class_b_in_class_zy(var1.e, var2, 1, 79, 53)));
		this.a((new class_zy.class_b_in_class_zy(var1.e, var2, 2, 102, 46)));
		f = this.a((new class_zy.class_a_in_class_zy(var2, 3, 79, 17)));

		int var3;
		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.a((new class_aas(var1, var4 + (var3 * 9) + 9, 8 + (var4 * 18), 84 + (var3 * 18))));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.a((new class_aas(var1, var3, 8 + (var3 * 18), 142)));
		}

	}

	@Override
	public void a(class_zz var1) {
		super.a(var1);
		var1.a(this, a);
	}

	@Override
	public void b() {
		super.b();

		for (int var1 = 0; var1 < e.size(); ++var1) {
			class_zz var2 = (class_zz) e.get(var1);
			if (g != a.c(0)) {
				var2.a(this, 0, a.c(0));
			}
		}

		g = a.c(0);
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
			if (((var2 < 0) || (var2 > 2)) && (var2 != 3)) {
				if (!f.e() && f.a(var5)) {
					if (!this.a(var5, 3, 4, false)) {
						return null;
					}
				} else if (class_zy.class_b_in_class_zy.b_(var3)) {
					if (!this.a(var5, 0, 3, false)) {
						return null;
					}
				} else if ((var2 >= 4) && (var2 < 31)) {
					if (!this.a(var5, 31, 40, false)) {
						return null;
					}
				} else if ((var2 >= 31) && (var2 < 40)) {
					if (!this.a(var5, 4, 31, false)) {
						return null;
					}
				} else if (!this.a(var5, 4, 40, false)) {
					return null;
				}
			} else {
				if (!this.a(var5, 4, 40, true)) {
					return null;
				}

				var4.a(var5, var3);
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

	static class class_a_in_class_zy extends class_aas {
		public class_a_in_class_zy(class_pp var1, int var2, int var3, int var4) {
			super(var1, var2, var3, var4);
		}

		@Override
		public boolean a(class_aco var1) {
			return (var1 != null) && class_aed.a(var1);
		}

		@Override
		public int a() {
			return 64;
		}
	}

	static class class_b_in_class_zy extends class_aas {
		private class_yu a;

		public class_b_in_class_zy(class_yu var1, class_pp var2, int var3, int var4, int var5) {
			super(var2, var3, var4, var5);
			a = var1;
		}

		@Override
		public boolean a(class_aco var1) {
			return b_(var1);
		}

		@Override
		public int a() {
			return 1;
		}

		@Override
		public void a(class_yu var1, class_aco var2) {
			if (class_adb.i(var2) != class_aee.a) {
				a.b(class_my.B);
			}

			super.a(var1, var2);
		}

		public static boolean b_(class_aco var0) {
			if (var0 == null) {
				return false;
			} else {
				Item var1 = var0.b();
				return (var1 == Items.bB) || (var1 == Items.bE) || (var1 == Items.bC) || (var1 == Items.bD);
			}
		}
	}
}
