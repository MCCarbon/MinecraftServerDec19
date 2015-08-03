package net.minecraft.server;

import com.google.common.collect.Maps;

import java.util.Map;

public class class_qe {
   private static final Map a = Maps.newHashMap();

   public static EntityInsentient.class_a_in_class_qb a(Class var0) {
      return (EntityInsentient.class_a_in_class_qb)a.get(var0);
   }

   static {
      a.put(EntityBat.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityChicken.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityCow.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityHorse.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityMushroomCow.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityOcelot.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityPig.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityRabbit.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntitySheep.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntitySnowman.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntitySquid.class, EntityInsentient.class_a_in_class_qb.c);
      a.put(EntityVillagerGolem.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityWolf.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityVillager.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityEnderDragon.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityWither.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityBlaze.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityCaveSpider.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityCreeper.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityEnderman.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityEndermite.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityGhast.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityGiantZombie.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityGuardian.class, EntityInsentient.class_a_in_class_qb.c);
      a.put(EntityMagmaCube.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityPigZombie.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntitySilverfish.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntitySkeleton.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntitySlime.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntitySpider.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityWitch.class, EntityInsentient.class_a_in_class_qb.a);
      a.put(EntityZombie.class, EntityInsentient.class_a_in_class_qb.a);
   }
}
