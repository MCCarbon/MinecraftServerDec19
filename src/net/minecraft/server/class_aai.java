package net.minecraft.server;


public class class_aai extends class_zu {
	private final class_pp a;

	public class_aai(class_yt var1, class_pp var2, class_yu var3) {
		a = var2;
		var2.b(var3);
		byte var4 = 51;

		int var5;
		for (var5 = 0; var5 < var2.n_(); ++var5) {
			this.a(new class_aas(var2, var5, 44 + (var5 * 18), 20));
		}

		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.a(new class_aas(var1, var6 + (var5 * 9) + 9, 8 + (var6 * 18), (var5 * 18) + var4));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a(new class_aas(var1, var5, 8 + (var5 * 18), 58 + var4));
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
			if (var2 < a.n_()) {
				if (!this.a(var5, a.n_(), c.size(), true)) {
					return null;
				}
			} else if (!this.a(var5, 0, a.n_(), false)) {
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
}
