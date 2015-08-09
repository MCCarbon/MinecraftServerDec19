package net.minecraft.server;

import net.minecraft.server.RegistryPotions;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.Bootstrap;

public class class_acf {
   public static RegistryPotions a;
   public static RegistryPotions b;
   public static RegistryPotions c;
   public static RegistryPotions d;
   public static RegistryPotions e;
   public static RegistryPotions f;
   public static RegistryPotions g;
   public static RegistryPotions h;
   public static RegistryPotions i;
   public static RegistryPotions j;
   public static RegistryPotions k;
   public static RegistryPotions l;
   public static RegistryPotions m;
   public static RegistryPotions n;
   public static RegistryPotions o;
   public static RegistryPotions p;
   public static RegistryPotions q;
   public static RegistryPotions r;
   public static RegistryPotions s;
   public static RegistryPotions t;
   public static RegistryPotions u;
   public static RegistryPotions v;
   public static RegistryPotions w;
   public static RegistryPotions x;
   public static RegistryPotions y;
   public static RegistryPotions z;
   public static RegistryPotions A;
   public static RegistryPotions B;
   public static RegistryPotions C;
   public static RegistryPotions D;
   public static RegistryPotions E;
   public static RegistryPotions F;
   public static RegistryPotions G;
   public static RegistryPotions H;
   public static RegistryPotions I;

   private static RegistryPotions a(String var0) {
      RegistryPotions var1 = (RegistryPotions)RegistryPotions.REGISTRY.get(new MinecraftKey(var0));
      if(var1 == null) {
         throw new IllegalStateException("Invalid Potion requested: " + var0);
      } else {
         return var1;
      }
   }

   static {
      if(!Bootstrap.isInitDone()) {
         throw new RuntimeException("Accessed Potions before Bootstrap!");
      } else {
         a = a("water");
         b = a("mundane");
         c = a("thick");
         d = a("awkward");
         e = a("night_vision");
         f = a("long_night_vision");
         g = a("invisibility");
         h = a("long_invisibility");
         i = a("leaping");
         j = a("long_leaping");
         k = a("strong_leaping");
         l = a("fire_resistance");
         m = a("long_fire_resistance");
         n = a("swiftness");
         o = a("long_swiftness");
         p = a("strong_swiftness");
         q = a("slowness");
         r = a("long_slowness");
         s = a("breathing_water");
         t = a("long_water_breathing");
         u = a("healing");
         v = a("strong_healing");
         w = a("harming");
         x = a("strong_harming");
         y = a("poison");
         z = a("long_poison");
         A = a("strong_poison");
         B = a("regeneration");
         C = a("long_regeneration");
         D = a("strong_regeneration");
         E = a("strength");
         F = a("long_strength");
         G = a("strong_strength");
         H = a("weakness");
         I = a("long_weakness");
      }
   }
}
