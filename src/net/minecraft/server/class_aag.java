package net.minecraft.server;


public class class_aag extends class_zu {
	private final class_pp a;
	private int f;
	private int g;
	private int h;
	private int i;

	public class_aag(class_yt var1, class_pp var2) {
		a = var2;
		this.a((new class_aas(var2, 0, 56, 17)));
		this.a((new class_aaf(var2, 1, 56, 53)));
		this.a((new class_aah(var1.e, var2, 2, 116, 35)));

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
			if (f != a.c(2)) {
				var2.a(this, 2, a.c(2));
			}

			if (h != a.c(0)) {
				var2.a(this, 0, a.c(0));
			}

			if (i != a.c(1)) {
				var2.a(this, 1, a.c(1));
			}

			if (g != a.c(3)) {
				var2.a(this, 3, a.c(3));
			}
		}

		f = a.c(2);
		h = a.c(0);
		i = a.c(1);
		g = a.c(3);
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
			if (var2 == 2) {
				if (!this.a(var5, 3, 39, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if ((var2 != 1) && (var2 != 0)) {
				if (class_aen.a().a(var5) != null) {
					if (!this.a(var5, 0, 1, false)) {
						return null;
					}
				} else if (class_aot.c(var5)) {
					if (!this.a(var5, 1, 2, false)) {
						return null;
					}
				} else if ((var2 >= 3) && (var2 < 30)) {
					if (!this.a(var5, 30, 39, false)) {
						return null;
					}
				} else if ((var2 >= 30) && (var2 < 39) && !this.a(var5, 3, 30, false)) {
					return null;
				}
			} else if (!this.a(var5, 3, 39, false)) {
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
}
