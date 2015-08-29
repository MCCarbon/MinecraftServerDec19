package net.minecraft.server;


public class class_aaj extends class_zu {
	private class_pp a;
	private EntityHorse f;

	public class_aaj(class_pp var1, final class_pp var2, final EntityHorse var3, class_yu var4) {
		a = var2;
		f = var3;
		byte var5 = 3;
		var2.b(var4);
		int var6 = (var5 - 4) * 18;
		this.a(new class_aas(var2, 0, 8, 18) {
			@Override
			public boolean a(class_aco var1) {
				return super.a(var1) && (var1.b() == Items.aC) && !e();
			}
		});
		this.a(new class_aas(var2, 1, 8, 36) {
			@Override
			public boolean a(class_aco var1) {
				return super.a(var1) && var3.dh() && EntityHorse.a(var1.b());
			}
		});
		int var7;
		int var8;
		if (var3.cP()) {
			for (var7 = 0; var7 < var5; ++var7) {
				for (var8 = 0; var8 < 5; ++var8) {
					this.a(new class_aas(var2, 2 + var8 + (var7 * 5), 80 + (var8 * 18), 18 + (var7 * 18)));
				}
			}
		}

		for (var7 = 0; var7 < 3; ++var7) {
			for (var8 = 0; var8 < 9; ++var8) {
				this.a(new class_aas(var1, var8 + (var7 * 9) + 9, 8 + (var8 * 18), 102 + (var7 * 18) + var6));
			}
		}

		for (var7 = 0; var7 < 9; ++var7) {
			this.a(new class_aas(var1, var7, 8 + (var7 * 18), 160 + var6));
		}

	}

	@Override
	public boolean a(class_yu var1) {
		return a.a(var1) && f.al() && (f.g(var1) < 8.0F);
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
			} else if (this.a(1).a(var5) && !this.a(1).e()) {
				if (!this.a(var5, 1, 2, false)) {
					return null;
				}
			} else if (this.a(0).a(var5)) {
				if (!this.a(var5, 0, 1, false)) {
					return null;
				}
			} else if ((a.n_() <= 2) || !this.a(var5, 2, a.n_(), false)) {
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
