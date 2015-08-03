package net.minecraft.server;

public class MobEffectList {
   public static final MobEffect a;
   public static final MobEffect b;
   public static final MobEffect c;
   public static final MobEffect d;
   public static final MobEffect e;
   public static final MobEffect f;
   public static final MobEffect g;
   public static final MobEffect h;
   public static final MobEffect i;
   public static final MobEffect j;
   public static final MobEffect k;
   public static final MobEffect l;
   public static final MobEffect m;
   public static final MobEffect n;
   public static final MobEffect o;
   public static final MobEffect p;
   public static final MobEffect q;
   public static final MobEffect r;
   public static final MobEffect s;
   public static final MobEffect t;
   public static final MobEffect u;
   public static final MobEffect v;
   public static final MobEffect w;
   public static final MobEffect x;
   public static final MobEffect y;

   private static MobEffect a(String var0) {
      MobEffect var1 = (MobEffect) MobEffect.b.get(new MinecraftKey(var0));
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
