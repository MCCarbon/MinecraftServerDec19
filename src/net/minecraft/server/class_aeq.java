package net.minecraft.server;

import java.util.Random;

public class class_aeq implements class_aes {
	@Override
	public boolean a(class_aab var1, class_ago var2) {
		class_aco var3 = null;
		class_aco var4 = null;

		for (int var5 = 0; var5 < var1.n_(); ++var5) {
			class_aco var6 = var1.a(var5);
			if (var6 != null) {
				if ((var6.b() == class_acq.bf) && (var3 == null)) {
					var3 = var6;
				} else {
					if ((var6.b() != class_acq.bg) || (var4 != null)) {
						return false;
					}

					var4 = var6;
				}
			}
		}

		if ((var3 != null) && (var4 != null)) {
			class_axl var7 = class_acq.bf.a(var3, var2);
			if (var7 == null) {
				return false;
			} else {
				return var7.f > 0;
			}
		} else {
			return false;
		}
	}

	@Override
	public class_aco a(class_aab var1) {
		class_aco var2 = null;
		class_aco var3 = null;

		for (int var4 = 0; var4 < var1.n_(); ++var4) {
			class_aco var5 = var1.a(var4);
			if (var5 != null) {
				if ((var5.b() == class_acq.bf) && (var2 == null)) {
					var2 = var5;
				} else if ((var5.b() == class_acq.bg) && (var3 == null)) {
					var3 = var5;
				}
			}
		}

		var2 = var2.k();
		var2.b = 1;
		if (var2.o() == null) {
			var2.d(new class_dn());
		}

		var2.o().a("map_scale_direction", -1);
		return var2;
	}

	@Override
	public int a() {
		return 2;
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
			if (var4 != null) {
				if (var4.b() == class_acq.bg) {
					if (!var4.a(1, (new Random()))) {
						var2[var3] = var4;
					}
				} else if (var4.b().r()) {
					var2[var3] = new class_aco(var4.b().q());
				}
			}
		}

		return var2;
	}
}
