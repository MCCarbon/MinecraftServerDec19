package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityTypes {
   private static final Logger b = LogManager.getLogger();
   private static final Map c = Maps.newHashMap();
   private static final Map d = Maps.newHashMap();
   private static final Map e = Maps.newHashMap();
   private static final Map f = Maps.newHashMap();
   private static final Map g = Maps.newHashMap();
   public static final Map a = Maps.newLinkedHashMap();

   private static void registerEntity(Class var0, String var1, int var2) {
      if(c.containsKey(var1)) {
         throw new IllegalArgumentException("ID is already registered: " + var1);
      } else if(e.containsKey(Integer.valueOf(var2))) {
         throw new IllegalArgumentException("ID is already registered: " + var2);
      } else if(var2 == 0) {
         throw new IllegalArgumentException("Cannot register to reserved id: " + var2);
      } else if(var0 == null) {
         throw new IllegalArgumentException("Cannot register null clazz for id: " + var2);
      } else {
         c.put(var1, var0);
         d.put(var0, var1);
         e.put(Integer.valueOf(var2), var0);
         f.put(var0, Integer.valueOf(var2));
         g.put(var1, Integer.valueOf(var2));
      }
   }

   private static void registerEntity(Class var0, String var1, int var2, int var3, int var4) {
      registerEntity(var0, var1, var2);
      a.put(Integer.valueOf(var2), new EntityTypes.class_a_in_class_pt(var2, var3, var4));
   }

   public static Entity a(String var0, World var1) {
      Entity var2 = null;

      try {
         Class var3 = (Class)c.get(var0);
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var2;
   }

   public static Entity a(NBTTagCompound var0, World var1) {
      Entity var2 = null;
      if("Minecart".equals(var0.getString("id"))) {
         var0.put("id", EntityMinecartAbstract.EnumMinecartType.a(var0.getInt("Type")).b());
         var0.remove("Type");
      }

      try {
         Class var3 = (Class)c.get(var0.getString("id"));
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.f(var0);
      } else {
         b.warn("Skipping Entity with id " + var0.getString("id"));
      }

      return var2;
   }

   public static Entity a(int var0, World var1) {
      Entity var2 = null;

      try {
         Class var3 = a(var0);
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 == null) {
         b.warn("Skipping Entity with id " + var0);
      }

      return var2;
   }

   public static int a(Entity var0) {
      Integer var1 = (Integer)f.get(var0.getClass());
      return var1 == null?0:var1.intValue();
   }

   public static Class a(int var0) {
      return (Class)e.get(Integer.valueOf(var0));
   }

   public static String b(Entity var0) {
      return (String)d.get(var0.getClass());
   }

   public static String b(int var0) {
      return (String)d.get(a(var0));
   }

   public static void a() {
   }

   public static List b() {
      Set var0 = c.keySet();
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Class var4 = (Class)c.get(var3);
         if((var4.getModifiers() & 1024) != 1024) {
            var1.add(var3);
         }
      }

      var1.add("LightningBolt");
      return var1;
   }

   public static boolean a(Entity var0, String var1) {
      String var2 = b(var0);
      if(var2 == null && var0 instanceof EntityHuman) {
         var2 = "Player";
      } else if(var2 == null && var0 instanceof class_vi) {
         var2 = "LightningBolt";
      }

      return var1.equals(var2);
   }

   public static boolean b(String var0) {
      return "Player".equals(var0) || b().contains(var0);
   }

   static {
      registerEntity(EntityItem.class, "Item", 1);
      registerEntity(EntityExperienceOrb.class, "XPOrb", 2);
      registerEntity(EntityEgg.class, "ThrownEgg", 7);
      registerEntity(EntityLeash.class, "LeashKnot", 8);
      registerEntity(EntityPainting.class, "Painting", 9);
      registerEntity(EntityArrow.class, "Arrow", 10);
      registerEntity(EntitySnowball.class, "Snowball", 11);
      registerEntity(EntityLargeFireball.class, "Fireball", 12);
      registerEntity(EntitySmallFireball.class, "SmallFireball", 13);
      registerEntity(EntityEnderpearl.class, "ThrownEnderpearl", 14);
      registerEntity(EntityEnderSignal.class, "EyeOfEnderSignal", 15);
      registerEntity(EntityPotion.class, "ThrownPotion", 16);
      registerEntity(EntityThrownExpBottle.class, "ThrownExpBottle", 17);
      registerEntity(EntityItemFrame.class, "ItemFrame", 18);
      registerEntity(EntityWitherSkull.class, "WitherSkull", 19);
      registerEntity(EntityTNTPrimed.class, "PrimedTnt", 20);
      registerEntity(EntityFallingBlock.class, "FallingSand", 21);
      registerEntity(EntityFireworks.class, "FireworksRocketEntity", 22);
      registerEntity(EntityTippedArrow.class, "TippedArrow", 23);
      registerEntity(EntitySpectralArrow.class, "SpectralArrow", 24);
      registerEntity(EntityShulkerBullet.class, "ShulkerBullet", 25);
      registerEntity(EntityArmorStand.class, "ArmorStand", 30);
      registerEntity(EntityBoat.class, "Boat", 41);
      registerEntity(EntityMinecartRideable.class, EntityMinecartAbstract.EnumMinecartType.RIDEABLE.b(), 42);
      registerEntity(EntityMinecartChest.class, EntityMinecartAbstract.EnumMinecartType.CHEST.b(), 43);
      registerEntity(EntityMinecartFurnace.class, EntityMinecartAbstract.EnumMinecartType.FURNACE.b(), 44);
      registerEntity(EntityMinecartTNT.class, EntityMinecartAbstract.EnumMinecartType.TNT.b(), 45);
      registerEntity(EntityMinecartHopper.class, EntityMinecartAbstract.EnumMinecartType.HOPPER.b(), 46);
      registerEntity(EntityMinecartMobSpawner.class, EntityMinecartAbstract.EnumMinecartType.SPAWNER.b(), 47);
      registerEntity(EntityMinecartCommandBlock.class, EntityMinecartAbstract.EnumMinecartType.COMMAND_BLOCK.b(), 40);
      registerEntity(EntityInsentient.class, "Mob", 48);
      registerEntity(EntityMonster.class, "Monster", 49);
      registerEntity(EntityCreeper.class, "Creeper", 50, 894731, 0);
      registerEntity(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
      registerEntity(EntitySpider.class, "Spider", 52, 3419431, 11013646);
      registerEntity(EntityGiantZombie.class, "Giant", 53);
      registerEntity(EntityZombie.class, "Zombie", 54, '꾯', 7969893);
      registerEntity(EntitySlime.class, "Slime", 55, 5349438, 8306542);
      registerEntity(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
      registerEntity(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
      registerEntity(EntityEnderman.class, "Enderman", 58, 1447446, 0);
      registerEntity(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
      registerEntity(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
      registerEntity(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
      registerEntity(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
      registerEntity(EntityEnderDragon.class, "EnderDragon", 63);
      registerEntity(EntityWither.class, "WitherBoss", 64);
      registerEntity(EntityBat.class, "Bat", 65, 4996656, 986895);
      registerEntity(EntityWitch.class, "Witch", 66, 3407872, 5349438);
      registerEntity(EntityEndermite.class, "Endermite", 67, 1447446, 7237230);
      registerEntity(EntityGuardian.class, "Guardian", 68, 5931634, 15826224);
      registerEntity(EntityShulker.class, "Shulker", 69, 9725844, 5060690);
      registerEntity(EntityPig.class, "Pig", 90, 15771042, 14377823);
      registerEntity(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
      registerEntity(EntityCow.class, "Cow", 92, 4470310, 10592673);
      registerEntity(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
      registerEntity(EntitySquid.class, "Squid", 94, 2243405, 7375001);
      registerEntity(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
      registerEntity(EntityMushroomCow.class, "MushroomCow", 96, 10489616, 12040119);
      registerEntity(EntitySnowman.class, "SnowMan", 97);
      registerEntity(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
      registerEntity(EntityVillagerGolem.class, "VillagerGolem", 99);
      registerEntity(EntityHorse.class, "EntityHorse", 100, 12623485, 15656192);
      registerEntity(EntityRabbit.class, "Rabbit", 101, 10051392, 7555121);
      registerEntity(EntityVillager.class, "Villager", 120, 5651507, 12422002);
      registerEntity(EntityEnderCrystal.class, "EnderCrystal", 200);
   }

   public static class class_a_in_class_pt {
      public final int a;
      public final int b;
      public final int c;
      public final class_my d;
      public final class_my e;

      public class_a_in_class_pt(int var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = StatisticList.a(this);
         this.e = StatisticList.b(this);
      }
   }
}
