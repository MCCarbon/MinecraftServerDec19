package net.minecraft.server;


public class class_aej implements class_aes {
	@Override
	public boolean a(class_aab var1, class_ago var2) {
		int var3 = 0;
		class_aco var4 = null;

		for (int var5 = 0; var5 < var1.n_(); ++var5) {
			class_aco var6 = var1.a(var5);
			if (var6 != null) {
				if (var6.b() == class_acq.bS) {
					if (var4 != null) {
						return false;
					}

					var4 = var6;
				} else {
					if (var6.b() != class_acq.bR) {
						return false;
					}

					++var3;
				}
			}
		}

		return (var4 != null) && (var3 > 0);
	}

	@Override
	public class_aco a(class_aab var1) {
		int var2 = 0;
		class_aco var3 = null;

		for (int var4 = 0; var4 < var1.n_(); ++var4) {
			class_aco var5 = var1.a(var4);
			if (var5 != null) {
				if (var5.b() == class_acq.bS) {
					if (var3 != null) {
						return null;
					}

					var3 = var5;
				} else {
					if (var5.b() != class_acq.bR) {
						return null;
					}

					++var2;
				}
			}
		}

		if ((var3 != null) && (var2 >= 1) && (class_aeb.h(var3) < 2)) {
			class_aco var6 = new class_aco(class_acq.bS, var2);
			var6.d((class_dn) var3.o().b());
			var6.o().a("generation", class_aeb.h(var3) + 1);
			if (var3.s()) {
				var6.c(var3.q());
			}

			return var6;
		} else {
			return null;
		}
	}

	@Override
	public int a() {
		return 9;
	}

	@Override
	public class_aco b() {
		return null;
	}

	@Override
	public class_aco[] b(class_aab var1) {
		class_aco[] var2 = new class_aco[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class_aco var4 = var1.a(var3);
			if ((var4 != null) && (var4.b() instanceof class_aeb)) {
				var2[var3] = var4;
				break;
			}
		}

		return var2;
	}
}
