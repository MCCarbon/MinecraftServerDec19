package net.minecraft.server;


public class class_aaa extends class_zu {
	private class_pp a;
	private int f;

	public class_aaa(class_pp var1, class_pp var2, class_yu var3) {
		a = var2;
		f = var2.n_() / 9;
		var2.b(var3);
		int var4 = (f - 4) * 18;

		int var5;
		int var6;
		for (var5 = 0; var5 < f; ++var5) {
			for (var6 = 0; var6 < 9; ++var6) {
				this.a(new class_aas(var2, var6 + (var5 * 9), 8 + (var6 * 18), 18 + (var5 * 18)));
			}
		}

		for (var5 = 0; var5 < 3; ++var5) {
			for (var6 = 0; var6 < 9; ++var6) {
				this.a(new class_aas(var1, var6 + (var5 * 9) + 9, 8 + (var6 * 18), 103 + (var5 * 18) + var4));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a(new class_aas(var1, var5, 8 + (var5 * 18), 161 + var4));
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
			if (var2 < (f * 9)) {
				if (!this.a(var5, f * 9, c.size(), true)) {
					return null;
				}
			} else if (!this.a(var5, 0, f * 9, false)) {
				return null;
			}

			if (var5.b == 0) {
				var4.d((class_aco) null);
			} else {
				var4.f();
			}
		}

		return var3;
	}

	@Override
	public void b(class_yu var1) {
		super.b(var1);
		a.c(var1);
	}

	public class_pp e() {
		return a;
	}
}
