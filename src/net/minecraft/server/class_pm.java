package net.minecraft.server;

import net.minecraft.server.MinecraftKey;
import net.minecraft.server.Bootstrap;
import net.minecraft.server.class_pk;

public class class_pm {
   public static final class_pk a;
   public static final class_pk b;
   public static final class_pk c;
   public static final class_pk d;
   public static final class_pk e;
   public static final class_pk f;
   public static final class_pk g;
   public static final class_pk h;
   public static final class_pk i;
   public static final class_pk j;
   public static final class_pk k;
   public static final class_pk l;
   public static final class_pk m;
   public static final class_pk n;
   public static final class_pk o;
   public static final class_pk p;
   public static final class_pk q;
   public static final class_pk r;
   public static final class_pk s;
   public static final class_pk t;
   public static final class_pk u;
   public static final class_pk v;
   public static final class_pk w;
   public static final class_pk x;
   public static final class_pk y;

   private static class_pk a(String var0) {
      class_pk var1 = (class_pk)class_pk.b.get(new MinecraftKey(var0));
      if(var1 == null) {
         throw new IllegalStateException("Invalid MobEffect requested: " + var0);
      } else {
         return var1;
      }
   }

   static {
      if(!Bootstrap.isInitDone()) {
         throw new RuntimeException("Accessed MobEffects before Bootstrap!");
      } else {
         a = a("speed");
         b = a("slowness");
         c = a("haste");
         d = a("mining_fatigue");
         e = a("strength");
         f = a("instant_health");
         g = a("instant_damage");
         h = a("jump_boost");
         i = a("nausea");
         j = a("regeneration");
         k = a("resistance");
         l = a("fire_resistance");
         m = a("water_breathing");
         n = a("invisibility");
         o = a("blindness");
         p = a("night_vision");
         q = a("hunger");
         r = a("weakness");
         s = a("poison");
         t = a("wither");
         u = a("health_boost");
         v = a("absorption");
         w = a("saturation");
         x = a("glowing");
         y = a("levitation");
      }
   }
}
