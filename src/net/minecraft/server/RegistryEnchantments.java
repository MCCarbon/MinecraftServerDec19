package net.minecraft.server;

import net.minecraft.server.Enchantment;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.Bootstrap;

public class RegistryEnchantments {
   public static final Enchantment a = a("protection");
   public static final Enchantment b = a("fire_protection");
   public static final Enchantment c = a("feather_falling");
   public static final Enchantment d = a("blast_protection");
   public static final Enchantment e = a("projectile_protection");
   public static final Enchantment f = a("respiration");
   public static final Enchantment g = a("aqua_affinity");
   public static final Enchantment h = a("thorns");
   public static final Enchantment i = a("depth_strider");
   public static final Enchantment j = a("sharpness");
   public static final Enchantment k = a("smite");
   public static final Enchantment l = a("bane_of_arthropods");
   public static final Enchantment m = a("knockback");
   public static final Enchantment n = a("fire_aspect");
   public static final Enchantment o = a("looting");
   public static final Enchantment p = a("efficiency");
   public static final Enchantment q = a("silk_touch");
   public static final Enchantment r = a("unbreaking");
   public static final Enchantment s = a("fortune");
   public static final Enchantment t = a("power");
   public static final Enchantment u = a("punch");
   public static final Enchantment v = a("flame");
   public static final Enchantment w = a("infinity");
   public static final Enchantment x = a("luck_of_the_sea");
   public static final Enchantment y = a("lure");

   private static Enchantment a(String var0) {
      Enchantment var1 = (Enchantment)Enchantment.b.get(new MinecraftKey(var0));
      if(var1 == null) {
         throw new IllegalStateException("Invalid Enchantment requested: " + var0);
      } else {
         return var1;
      }
   }

   static {
      if(!Bootstrap.isInitDone()) {
         throw new RuntimeException("Accessed MobEffects before Bootstrap!");
      }
   }
}
