package net.minecraft.server;


public class class_aak extends class_zu {
	private static final class_rc[] h;
	public class_aab a = new class_aab(this, 2, 2);
	public class_pp f = new class_aaq();
	public boolean g;
	private final class_yu i;

	public class_aak(final class_yt var1, boolean var2, class_yu var3) {
		g = var2;
		i = var3;
		this.a((new class_aar(var1.e, a, f, 0, 154, 28)));

		int var4;
		int var5;
		for (var4 = 0; var4 < 2; ++var4) {
			for (var5 = 0; var5 < 2; ++var5) {
				this.a((new class_aas(a, var5 + (var4 * 2), 98 + (var5 * 18), 18 + (var4 * 18))));
			}
		}

		for (var4 = 0; var4 < 4; ++var4) {
			final class_rc var6 = h[var4];
			this.a((new class_aas(var1, 36 + (3 - var4), 8, 8 + (var4 * 18)) {
				@Override
				public int a() {
					return 1;
				}

				@Override
				public boolean a(class_aco var1) {
					return var1 == null ? false : (var1.b() instanceof class_aav ? ((class_aav) var1.b()).b == var6 : ((var1.b() != Item.a(Blocks.PUMPKIN)) && (var1.b() != Items.cc) ? false : var6 == class_rc.f));
				}
			}));
		}

		for (var4 = 0; var4 < 3; ++var4) {
			for (var5 = 0; var5 < 9; ++var5) {
				this.a((new class_aas(var1, var5 + ((var4 + 1) * 9), 8 + (var5 * 18), 84 + (var4 * 18))));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.a((new class_aas(var1, var4, 8 + (var4 * 18), 142)));
		}

		this.a((new class_aas(var1, 40, 77, 62) {
			@Override
			public boolean a(class_aco var1) {
				return super.a(var1);
			}
		}));
		this.a(a);
	}

	@Override
	public void a(class_pp var1) {
		f.a(0, class_aet.a().a(a, i.o));
	}

	@Override
	public void b(class_yu var1) {
		super.b(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			class_aco var3 = a.b(var2);
			if (var3 != null) {
				var1.a(var3, false);
			}
		}

		f.a(0, (class_aco) null);
	}

	@Override
	public boolean a(class_yu var1) {
		return true;
	}

	@Override
	public class_aco b(class_yu var1, int var2) {
		class_aco var3 = null;
		class_aas var4 = (class_aas) c.get(var2);
		if ((var4 != null) && var4.e()) {
			class_aco var5 = var4.d();
			var3 = var5.k();
			if (var2 == 0) {
				if (!this.a(var5, 9, 45, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if ((var2 >= 1) && (var2 < 5)) {
				if (!this.a(var5, 9, 45, false)) {
					return null;
				}
			} else if ((var2 >= 5) && (var2 < 9)) {
				if (!this.a(var5, 9, 45, false)) {
					return null;
				}
			} else if ((var3.b() instanceof class_aav) && !((class_aas) c.get(8 - ((class_aav) var3.b()).b.b())).e()) {
				int var6 = 8 - ((class_aav) var3.b()).b.b();
				if (!this.a(var5, var6, var6 + 1, false)) {
					return null;
				}
			} else if ((var2 >= 9) && (var2 < 36)) {
				if (!this.a(var5, 36, 45, false)) {
					return null;
				}
			} else if ((var2 >= 36) && (var2 < 45)) {
				if (!this.a(var5, 9, 36, false)) {
					return null;
				}
			} else if (!this.a(var5, 9, 45, false)) {
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

	@Override
	public boolean a(class_aco var1, class_aas var2) {
		return (var2.d != f) && super.a(var1, var2);
	}

	static {
		h = new class_rc[] { class_rc.f, class_rc.e, class_rc.d, class_rc.c };
	}
}
