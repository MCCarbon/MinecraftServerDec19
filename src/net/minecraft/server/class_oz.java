package net.minecraft.server;


public class class_oz implements class_ok {
	@Override
	public int a() {
		return 107;
	}

	@Override
	public class_dn a(class_dn var1) {
		if (!"MobSpawner".equals(var1.l("id"))) {
			return var1;
		} else {
			if (var1.b("EntityId", 8)) {
				String var2 = var1.l("EntityId");
				class_dn var3 = var1.o("SpawnData");
				var3.a("id", var2.isEmpty() ? "Pig" : var2);
				var1.a("SpawnData", var3);
				var1.q("EntityId");
			}

			if (var1.b("SpawnPotentials", 9)) {
				class_du var6 = var1.c("SpawnPotentials", 10);

				for (int var7 = 0; var7 < var6.c(); ++var7) {
					class_dn var4 = var6.b(var7);
					if (var4.b("Type", 8)) {
						class_dn var5 = var4.o("Properties");
						var5.a("id", var4.l("Type"));
						var4.a("Entity", var5);
						var4.q("Type");
						var4.q("Properties");
					}
				}
			}

			return var1;
		}
	}
}
