package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_os implements class_ok {
	private static final Set a = Sets.newHashSet((Object[]) (new String[] { "ArmorStand", "Bat", "Blaze", "CaveSpider", "Chicken", "Cow", "Creeper", "EnderDragon", "Enderman", "Endermite", "EntityHorse", "Ghast", "Giant", "Guardian", "LavaSlime", "MushroomCow", "Ozelot", "Pig", "PigZombie", "Rabbit", "Sheep", "Shulker", "Silverfish", "Skeleton", "Slime", "SnowMan", "Spider", "Squid", "Villager", "VillagerGolem", "Witch", "WitherBoss", "Wolf", "Zombie" }));

	@Override
	public int a() {
		return 109;
	}

	@Override
	public class_dn a(class_dn var1) {
		if (a.contains(var1.l("id"))) {
			float var2;
			if (var1.b("HealF", 99)) {
				var2 = var1.j("HealF");
				var1.q("HealF");
			} else {
				if (!var1.b("Health", 99)) {
					return var1;
				}

				var2 = var1.j("Heath");
			}

			var1.a("Health", var2);
		}

		return var1;
	}
}
