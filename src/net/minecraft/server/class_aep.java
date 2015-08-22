package net.minecraft.server;


public class class_aep extends class_aev {
	public class_aep() {
		super(3, 3, new class_aco[] { new class_aco(class_acq.aM), new class_aco(class_acq.aM), new class_aco(class_acq.aM), new class_aco(class_acq.aM), new class_aco(class_acq.bf, 0, 32767), new class_aco(class_acq.aM), new class_aco(class_acq.aM), new class_aco(class_acq.aM), new class_aco(class_acq.aM) }, new class_aco(class_acq.ca, 0, 0));
	}

	@Override
	public boolean a(class_aab var1, class_ago var2) {
		if (!super.a(var1, var2)) {
			return false;
		} else {
			class_aco var3 = null;

			for (int var4 = 0; (var4 < var1.n_()) && (var3 == null); ++var4) {
				class_aco var5 = var1.a(var4);
				if ((var5 != null) && (var5.b() == class_acq.bf)) {
					var3 = var5;
				}
			}

			if (var3 == null) {
				return false;
			} else {
				class_axl var6 = class_acq.bf.a(var3, var2);
				return var6 == null ? false : var6.f < 4;
			}
		}
	}

	@Override
	public class_aco a(class_aab var1) {
		class_aco var2 = null;

		for (int var3 = 0; (var3 < var1.n_()) && (var2 == null); ++var3) {
			class_aco var4 = var1.a(var3);
			if ((var4 != null) && (var4.b() == class_acq.bf)) {
				var2 = var4;
			}
		}

		var2 = var2.k();
		var2.b = 1;
		if (var2.o() == null) {
			var2.d(new class_dn());
		}

		var2.o().a("map_scale_direction", 1);
		return var2;
	}
}
