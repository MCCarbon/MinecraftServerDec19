package net.minecraft.server;

public class MobEffectList {
   public static final MobEffectType a;
   public static final MobEffectType b;
   public static final MobEffectType c;
   public static final MobEffectType d;
   public static final MobEffectType e;
   public static final MobEffectType f;
   public static final MobEffectType g;
   public static final MobEffectType h;
   public static final MobEffectType i;
   public static final MobEffectType j;
   public static final MobEffectType k;
   public static final MobEffectType l;
   public static final MobEffectType m;
   public static final MobEffectType n;
   public static final MobEffectType o;
   public static final MobEffectType p;
   public static final MobEffectType q;
   public static final MobEffectType r;
   public static final MobEffectType s;
   public static final MobEffectType t;
   public static final MobEffectType u;
   public static final MobEffectType v;
   public static final MobEffectType w;
   public static final MobEffectType x;
   public static final MobEffectType y;

   private static MobEffectType a(String var0) {
      MobEffectType var1 = (MobEffectType) MobEffectType.b.get(new MinecraftKey(var0));
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
