package net.minecraft.server;

import net.minecraft.server.class_acd;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.Bootstrap;

public class class_acf {
   public static class_acd a;
   public static class_acd b;
   public static class_acd c;
   public static class_acd d;
   public static class_acd e;
   public static class_acd f;
   public static class_acd g;
   public static class_acd h;
   public static class_acd i;
   public static class_acd j;
   public static class_acd k;
   public static class_acd l;
   public static class_acd m;
   public static class_acd n;
   public static class_acd o;
   public static class_acd p;
   public static class_acd q;
   public static class_acd r;
   public static class_acd s;
   public static class_acd t;
   public static class_acd u;
   public static class_acd v;
   public static class_acd w;
   public static class_acd x;
   public static class_acd y;
   public static class_acd z;
   public static class_acd A;
   public static class_acd B;
   public static class_acd C;
   public static class_acd D;
   public static class_acd E;
   public static class_acd F;
   public static class_acd G;
   public static class_acd H;
   public static class_acd I;

   private static class_acd a(String var0) {
      class_acd var1 = (class_acd)class_acd.REGISTRY.get(new MinecraftKey(var0));
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
