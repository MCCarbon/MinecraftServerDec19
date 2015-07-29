package net.minecraft.server;

import net.minecraft.server.class_adi;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_kc;

public class class_adm {
   public static final class_adi a = a("protection");
   public static final class_adi b = a("fire_protection");
   public static final class_adi c = a("feather_falling");
   public static final class_adi d = a("blast_protection");
   public static final class_adi e = a("projectile_protection");
   public static final class_adi f = a("respiration");
   public static final class_adi g = a("aqua_affinity");
   public static final class_adi h = a("thorns");
   public static final class_adi i = a("depth_strider");
   public static final class_adi j = a("sharpness");
   public static final class_adi k = a("smite");
   public static final class_adi l = a("bane_of_arthropods");
   public static final class_adi m = a("knockback");
   public static final class_adi n = a("fire_aspect");
   public static final class_adi o = a("looting");
   public static final class_adi p = a("efficiency");
   public static final class_adi q = a("silk_touch");
   public static final class_adi r = a("unbreaking");
   public static final class_adi s = a("fortune");
   public static final class_adi t = a("power");
   public static final class_adi u = a("punch");
   public static final class_adi v = a("flame");
   public static final class_adi w = a("infinity");
   public static final class_adi x = a("luck_of_the_sea");
   public static final class_adi y = a("lure");

   private static class_adi a(String var0) {
      class_adi var1 = (class_adi)class_adi.b.get(new MinecraftKey(var0));
      if(var1 == null) {
         throw new IllegalStateException("Invalid Enchantment requested: " + var0);
      } else {
         return var1;
      }
   }

   static {
      if(!class_kc.a()) {
         throw new RuntimeException("Accessed MobEffects before Bootstrap!");
      }
   }
}
