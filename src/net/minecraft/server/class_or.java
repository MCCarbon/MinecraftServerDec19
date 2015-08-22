package net.minecraft.server;


public class class_or implements class_ok {
	@Override
	public int a() {
		return 100;
	}

	@Override
	public class_dn a(class_dn var1) {
		class_du var2 = var1.c("Equipment", 10);
		class_du var3;
		if ((var2.c() > 0) && !var1.b("HandItems", 10)) {
			var3 = new class_du();
			var3.a(var2.h(0));
			var3.a((new class_dn()));
			var1.a("HandItems", var3);
		}

		if ((var2.c() > 1) && !var1.b("ArmorItem", 10)) {
			var3 = new class_du();
			var3.a(var2.b(1));
			var3.a(var2.b(2));
			var3.a(var2.b(3));
			var3.a(var2.b(4));
			var1.a("ArmorItems", var3);
		}

		var1.q("Equipment");
		if (var1.b("DropChances", 9)) {
			var3 = var1.c("DropChances", 5);
			class_du var4;
			if (!var1.b("HandDropChances", 10)) {
				var4 = new class_du();
				var4.a((new class_dr(var3.f(0))));
				var4.a((new class_dr(0.0F)));
				var1.a("HandDropChances", var4);
			}

			if (!var1.b("ArmorDropChances", 10)) {
				var4 = new class_du();
				var4.a((new class_dr(var3.f(1))));
				var4.a((new class_dr(var3.f(2))));
				var4.a((new class_dr(var3.f(3))));
				var4.a((new class_dr(var3.f(4))));
				var1.a("ArmorDropChances", var4);
			}

			var1.q("DropChances");
		}

		return var1;
	}
}
