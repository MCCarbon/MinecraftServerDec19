package net.minecraft.server;


public class class_aad extends class_zu {
	private class_pp a;

	public class_aad(class_pp var1, class_pp var2) {
		a = var2;

		int var3;
		int var4;
		for (var3 = 0; var3 < 3; ++var3) {
			for (var4 = 0; var4 < 3; ++var4) {
				this.a(new class_aas(var2, var4 + (var3 * 3), 62 + (var4 * 18), 17 + (var3 * 18)));
			}
		}

		for (var3 = 0; var3 < 3; ++var3) {
			for (var4 = 0; var4 < 9; ++var4) {
				this.a(new class_aas(var1, var4 + (var3 * 9) + 9, 8 + (var4 * 18), 84 + (var3 * 18)));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.a(new class_aas(var1, var3, 8 + (var3 * 18), 142));
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
			if (var2 < 9) {
				if (!this.a(var5, 9, 45, true)) {
					return null;
				}
			} else if (!this.a(var5, 0, 9, false)) {
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
