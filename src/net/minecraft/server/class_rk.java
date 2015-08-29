package net.minecraft.server;

import java.util.Map;

import com.google.common.collect.Maps;

public class class_rk {
	private static final Map a = Maps.newHashMap();

	public static EntityInsentient.class_a_in_class_rh a(Class var0) {
		return (EntityInsentient.class_a_in_class_rh) a.get(var0);
	}

	static {
		a.put(EntityBat.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityChicken.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityCow.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityHorse.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityMushroomCow.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityOcelot.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityPig.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityRabbit.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntitySheep.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntitySnowman.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntitySquid.class, EntityInsentient.class_a_in_class_rh.c);
		a.put(EntityVillagerGolem.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityWolf.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityVillager.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(class_vx.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityWither.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityBlaze.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityCaveSpider.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityCreeper.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityEnderman.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityEndermite.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityGhast.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityGiant.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityGuardian.class, EntityInsentient.class_a_in_class_rh.c);
		a.put(EntityMagmaCube.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityPigZombie.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntitySilverfish.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntitySkeleton.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntitySlime.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntitySpider.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityWitch.class, EntityInsentient.class_a_in_class_rh.a);
		a.put(EntityZombie.class, EntityInsentient.class_a_in_class_rh.a);
	}
}
