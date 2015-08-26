package net.minecraft.server;


public class class_aac extends class_zu {
	public class_aab a = new class_aab(this, 3, 3);
	public class_pp f = new class_aaq();
	private class_ago g;
	private class_cj h;

	public class_aac(class_yt var1, class_ago var2, class_cj var3) {
		g = var2;
		h = var3;
		this.a((new class_aar(var1.e, a, f, 0, 124, 35)));

		int var4;
		int var5;
		for (var4 = 0; var4 < 3; ++var4) {
			for (var5 = 0; var5 < 3; ++var5) {
				this.a((new class_aas(a, var5 + (var4 * 3), 30 + (var5 * 18), 17 + (var4 * 18))));
			}
		}

		for (var4 = 0; var4 < 3; ++var4) {
			for (var5 = 0; var5 < 9; ++var5) {
				this.a((new class_aas(var1, var5 + (var4 * 9) + 9, 8 + (var5 * 18), 84 + (var4 * 18))));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.a((new class_aas(var1, var4, 8 + (var4 * 18), 142)));
		}

		this.a(a);
	}

	@Override
	public void a(class_pp var1) {
		f.a(0, class_aet.a().a(a, g));
	}

	@Override
	public void b(class_yu var1) {
		super.b(var1);
		if (!g.D) {
			for (int var2 = 0; var2 < 9; ++var2) {
				class_aco var3 = a.b(var2);
				if (var3 != null) {
					var1.a(var3, false);
				}
			}

		}
	}

	@Override
	public boolean a(class_yu var1) {
		return g.p(h).c() != Blocks.CRAFTING_TABLE ? false : var1.e(h.n() + 0.5D, h.o() + 0.5D, h.p() + 0.5D) <= 64.0D;
	}

	@Override
	public class_aco b(class_yu var1, int var2) {
		class_aco var3 = null;
		class_aas var4 = (class_aas) c.get(var2);
		if ((var4 != null) && var4.e()) {
			class_aco var5 = var4.d();
			var3 = var5.k();
			if (var2 == 0) {
				if (!this.a(var5, 10, 46, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if ((var2 >= 10) && (var2 < 37)) {
				if (!this.a(var5, 37, 46, false)) {
					return null;
				}
			} else if ((var2 >= 37) && (var2 < 46)) {
				if (!this.a(var5, 10, 37, false)) {
					return null;
				}
			} else if (!this.a(var5, 10, 46, false)) {
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
}
