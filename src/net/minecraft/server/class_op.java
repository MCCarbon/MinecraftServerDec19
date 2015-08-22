package net.minecraft.server;


public class class_op {
	private static void a(class_oo var0) {
		var0.a(class_om.e, (new class_or()));
		var0.a(class_om.d, (new class_pb()));
		var0.a(class_om.f, (new class_ox()));
		var0.a(class_om.f, (new class_pa()));
		var0.a(class_om.f, (new class_pc()));
		var0.a(class_om.e, (new class_oy()));
		var0.a(class_om.d, (new class_oz()));
		var0.a(class_om.e, (new class_ow()));
		var0.a(class_om.e, (new class_os()));
		var0.a(class_om.e, (new class_ot()));
		var0.a(class_om.e, (new class_ou()));
		var0.a(class_om.e, (new class_ov()));
	}

	public static class_oo a() {
		class_oo var0 = new class_oo(117);
		var0.a(class_om.a, new class_oq() {
			@Override
			public class_dn a(class_on var1, class_dn var2, int var3) {
				if (var2.b("Player", 10)) {
					var2.a("Player", var1.a(class_om.b, var2.o("Player"), var3));
				}

				return var2;
			}
		});
		var0.a(class_om.b, new class_oq() {
			@Override
			public class_dn a(class_on var1, class_dn var2, int var3) {
				class_op.b(var1, var2, var3, "Inventory");
				class_op.b(var1, var2, var3, "EnderItems");
				return var2;
			}
		});
		var0.a(class_om.c, new class_oq() {
			@Override
			public class_dn a(class_on var1, class_dn var2, int var3) {
				if (var2.b("Level", 10)) {
					class_dn var4 = var2.o("Level");
					class_du var5;
					int var6;
					if (var4.b("Entities", 9)) {
						var5 = var4.c("Entities", 10);

						for (var6 = 0; var6 < var5.c(); ++var6) {
							var5.a(var6, var1.a(class_om.e, (class_dn) var5.h(var6), var3));
						}
					}

					if (var4.b("TileEntities", 9)) {
						var5 = var4.c("TileEntities", 10);

						for (var6 = 0; var6 < var5.c(); ++var6) {
							var5.a(var6, var1.a(class_om.d, (class_dn) var5.h(var6), var3));
						}
					}
				}

				return var2;
			}
		});
		var0.a(class_om.e, (new class_pf("Item", new String[] { "Item" })));
		var0.a(class_om.e, (new class_pf("ThrownPotion", new String[] { "Potion" })));
		var0.a(class_om.e, (new class_pf("ItemFrame", new String[] { "Item" })));
		var0.a(class_om.e, (new class_pf("FireworksRocketEntity", new String[] { "FireworksItem" })));
		var0.a(class_om.e, (new class_pf("TippedArrow", new String[] { "Item" })));
		var0.a(class_om.e, (new class_pi("MinecartChest", new String[] { "Items" })));
		var0.a(class_om.e, (new class_pi("MinecartHopper", new String[] { "Items" })));
		var0.a(class_om.e, (new class_pi("Enderman", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("ArmorStand", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Bat", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Blaze", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("CaveSpider", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Chicken", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Cow", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Creeper", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("EnderDragon", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Endermite", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Ghast", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Giant", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Guardian", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("LavaSlime", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Mob", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Monster", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("MushroomCow", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Ozelot", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Pig", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("PigZombie", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Rabbit", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Sheep", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Shulker", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Silverfish", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Skeleton", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Slime", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("SnowMan", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Spider", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Squid", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("VillagerGolem", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Witch", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("WitherBoss", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Wolf", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("Zombie", new String[] { "ArmorItems", "HandItems" })));
		var0.a(class_om.e, (new class_pi("EntityHorse", new String[] { "ArmorItems", "HandItems", "Items" })));
		var0.a(class_om.e, (new class_pf("EntityHorse", new String[] { "ArmorItem", "SaddleItem" })));
		var0.a(class_om.e, (new class_pi("Villager", new String[] { "ArmorItems", "HandItems", "Inventory" })));
		var0.a(class_om.e, new class_oq() {
			@Override
			public class_dn a(class_on var1, class_dn var2, int var3) {
				if ("Villager".equals(var2.l("id")) && var2.b("Offers", 10)) {
					class_dn var4 = var2.o("Offers");
					if (var4.b("Recipes", 9)) {
						class_du var5 = var4.c("Recipes", 10);

						for (int var6 = 0; var6 < var5.c(); ++var6) {
							class_dn var7 = var5.b(var6);
							class_op.a(var1, var7, var3, "buy");
							class_op.a(var1, var7, var3, "buyB");
							class_op.a(var1, var7, var3, "sell");
							var5.a(var6, var7);
						}
					}
				}

				return var2;
			}
		});
		var0.a(class_om.e, new class_oq() {
			@Override
			public class_dn a(class_on var1, class_dn var2, int var3) {
				if ("MinecartSpawner".equals(var2.l("id"))) {
					var2.a("id", "MobSpawner");
					var1.a(class_om.d, var2, var3);
					var2.a("id", "MinecartSpawner");
				}

				return var2;
			}
		});
		var0.a(class_om.e, new class_oq() {
			@Override
			public class_dn a(class_on var1, class_dn var2, int var3) {
				if ("MinecartCommandBlock".equals(var2.l("id"))) {
					var2.a("id", "Control");
					var1.a(class_om.d, var2, var3);
					var2.a("id", "MinecartCommandBlock");
				}

				return var2;
			}
		});
		var0.a(class_om.d, (new class_pi("Furnace", new String[] { "Items" })));
		var0.a(class_om.d, (new class_pi("Chest", new String[] { "Items" })));
		var0.a(class_om.d, (new class_pi("Trap", new String[] { "Items" })));
		var0.a(class_om.d, (new class_pi("Dropper", new String[] { "Items" })));
		var0.a(class_om.d, (new class_pi("Cauldron", new String[] { "Items" })));
		var0.a(class_om.d, (new class_pi("Hopper", new String[] { "Items" })));
		var0.a(class_om.d, (new class_pf("RecordPlayer", new String[] { "RecordItem" })));
		var0.a(class_om.d, new class_oq() {
			@Override
			public class_dn a(class_on var1, class_dn var2, int var3) {
				if ("MobSpawner".equals(var2.l("id"))) {
					if (var2.b("SpawnPotentials", 9)) {
						class_du var4 = var2.c("SpawnPotentials", 10);

						for (int var5 = 0; var5 < var4.c(); ++var5) {
							class_dn var6 = var4.b(var5);
							var6.a("Entity", var1.a(class_om.e, var6.o("Entity"), var3));
						}
					}

					var2.a("SpawnData", var1.a(class_om.e, var2.o("SpawnData"), var3));
				}

				return var2;
			}
		});
		var0.a(class_om.f, (new class_pg()));
		var0.a(class_om.f, (new class_ph()));
		a(var0);
		return var0;
	}

	public static class_dn a(class_on var0, class_dn var1, int var2, String var3) {
		if (var1.b(var3, 10)) {
			var1.a(var3, var0.a(class_om.f, var1.o(var3), var2));
		}

		return var1;
	}

	public static class_dn b(class_on var0, class_dn var1, int var2, String var3) {
		if (var1.b(var3, 9)) {
			class_du var4 = var1.c(var3, 10);

			for (int var5 = 0; var5 < var4.c(); ++var5) {
				var4.a(var5, var0.a(class_om.f, var4.b(var5), var2));
			}
		}

		return var1;
	}
}
