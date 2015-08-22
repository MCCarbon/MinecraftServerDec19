package net.minecraft.server;


public class class_ov implements class_ok {
	@Override
	public int a() {
		return 113;
	}

	@Override
	public class_dn a(class_dn var1) {
		class_du var2;
		if (var1.b("HandDropChances", 9)) {
			var2 = var1.c("HandDropChances", 5);
			if ((var2.c() == 2) && (var2.f(0) == 0.0F) && (var2.f(1) == 0.0F)) {
				var1.q("HandDropChances");
			}
		}

		if (var1.b("ArmorDropChances", 9)) {
			var2 = var1.c("ArmorDropChances", 5);
			if ((var2.c() == 4) && (var2.f(0) == 0.0F) && (var2.f(1) == 0.0F) && (var2.f(2) == 0.0F) && (var2.f(3) == 0.0F)) {
				var1.q("ArmorDropChances");
			}
		}

		return var1;
	}
}
