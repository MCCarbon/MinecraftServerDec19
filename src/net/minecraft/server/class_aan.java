package net.minecraft.server;


public class class_aan extends class_zu {
	private class_aga a;
	private class_aam f;
	private final class_ago g;

	public class_aan(class_yt var1, class_aga var2, class_ago var3) {
		a = var2;
		g = var3;
		f = new class_aam(var1.e, var2);
		this.a((new class_aas(f, 0, 36, 53)));
		this.a((new class_aas(f, 1, 62, 53)));
		this.a((new class_aao(var1.e, var2, f, 2, 120, 53)));

		int var4;
		for (var4 = 0; var4 < 3; ++var4) {
			for (int var5 = 0; var5 < 9; ++var5) {
				this.a((new class_aas(var1, var5 + (var4 * 9) + 9, 8 + (var5 * 18), 84 + (var4 * 18))));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.a((new class_aas(var1, var4, 8 + (var4 * 18), 142)));
		}

	}

	public class_aam e() {
		return f;
	}

	@Override
	public void a(class_zz var1) {
		super.a(var1);
	}

	@Override
	public void b() {
		super.b();
	}

	@Override
	public void a(class_pp var1) {
		f.h();
		super.a(var1);
	}

	public void d(int var1) {
		f.d(var1);
	}

	@Override
	public boolean a(class_yu var1) {
		return a.t_() == var1;
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
			} else if ((var2 != 0) && (var2 != 1)) {
				if ((var2 >= 3) && (var2 < 30)) {
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

	@Override
	public void b(class_yu var1) {
		super.b(var1);
		a.a((class_yu) null);
		super.b(var1);
		if (!g.D) {
			class_aco var2 = f.b(0);
			if (var2 != null) {
				var1.a(var2, false);
			}

			var2 = f.b(1);
			if (var2 != null) {
				var1.a(var2, false);
			}

		}
	}
}
