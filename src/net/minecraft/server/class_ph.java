package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ph implements class_oq {
	private static final Logger a = LogManager.getLogger();
	private static final String[] b = new String[256];

	@Override
	public class_dn a(class_on var1, class_dn var2, int var3) {
		class_dn var4 = var2.o("tag");
		if (var4.b("EntityTag", 10)) {
			class_dn var5 = var4.o("EntityTag");
			String var6 = var2.l("id");
			String var7;
			if ("minecraft:armor_stand".equals(var6)) {
				var7 = "ArmorStand";
			} else {
				if (!"minecraft:spawn_egg".equals(var6)) {
					return var2;
				}

				var7 = var5.l("id");
			}

			boolean var8;
			if (var7 == null) {
				a.warn("Unable to resolve Entity for ItemInstance: {}", new Object[] { var6 });
				var8 = false;
			} else {
				var8 = !var5.b("id", 8);
				var5.a("id", var7);
			}

			var1.a(class_om.e, var5, var3);
			if (var8) {
				var5.q("id");
			}
		}

		return var2;
	}

	static {
		String[] var0 = b;
		var0[1] = "Item";
		var0[2] = "XPOrb";
		var0[7] = "ThrownEgg";
		var0[8] = "LeashKnot";
		var0[9] = "Painting";
		var0[10] = "Arrow";
		var0[11] = "Snowball";
		var0[12] = "Fireball";
		var0[13] = "SmallFireball";
		var0[14] = "ThrownEnderpearl";
		var0[15] = "EyeOfEnderSignal";
		var0[16] = "ThrownPotion";
		var0[17] = "ThrownExpBottle";
		var0[18] = "ItemFrame";
		var0[19] = "WitherSkull";
		var0[20] = "PrimedTnt";
		var0[21] = "FallingSand";
		var0[22] = "FireworksRocketEntity";
		var0[23] = "TippedArrow";
		var0[24] = "SpectralArrow";
		var0[25] = "ShulkerBullet";
		var0[26] = "DragonFireball";
		var0[30] = "ArmorStand";
		var0[41] = "Boat";
		var0[42] = "MinecartRideable";
		var0[43] = "MinecartChest";
		var0[44] = "MinecartFurnace";
		var0[45] = "MinecartTNT";
		var0[46] = "MinecartHopper";
		var0[47] = "MinecartSpawner";
		var0[40] = "MinecartCommandBlock";
		var0[48] = "Mob";
		var0[49] = "Monster";
		var0[50] = "Creeper";
		var0[51] = "Skeleton";
		var0[52] = "Spider";
		var0[53] = "Giant";
		var0[54] = "Zombie";
		var0[55] = "Slime";
		var0[56] = "Ghast";
		var0[57] = "PigZombie";
		var0[58] = "Enderman";
		var0[59] = "CaveSpider";
		var0[60] = "Silverfish";
		var0[61] = "Blaze";
		var0[62] = "LavaSlime";
		var0[63] = "EnderDragon";
		var0[64] = "WitherBoss";
		var0[65] = "Bat";
		var0[66] = "Witch";
		var0[67] = "Endermite";
		var0[68] = "Guardian";
		var0[69] = "Shulker";
		var0[90] = "Pig";
		var0[91] = "Sheep";
		var0[92] = "Cow";
		var0[93] = "Chicken";
		var0[94] = "Squid";
		var0[95] = "Wolf";
		var0[96] = "MushroomCow";
		var0[97] = "SnowMan";
		var0[98] = "Ozelot";
		var0[99] = "VillagerGolem";
		var0[100] = "EntityHorse";
		var0[101] = "Rabbit";
		var0[120] = "Villager";
		var0[200] = "EnderCrystal";
	}
}
