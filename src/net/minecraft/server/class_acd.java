package net.minecraft.server;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class class_acd {
   private static final MinecraftKey b = new MinecraftKey("water");
   public static final RegistryBlocks a;
   private static int c;
   private final String d;
   private final ImmutableList e;

   public static int a(class_acd var0) {
      return a.getId((Object)var0);
   }

   public static class_acd a(String var0) {
      return (class_acd)a.get(new MinecraftKey(var0));
   }

   public class_acd(MobEffect... var1) {
      this((String)null, var1);
   }

   public class_acd(String var1, MobEffect... var2) {
      this.d = var1 == null?null:"potion.effect." + var1;
      this.e = ImmutableList.copyOf((Object[])var2);
   }

   public String a() {
      return this.d == null?"potion.effect." + ((MinecraftKey)a.getKey(this)).getName():this.d;
   }

   public List b() {
      return this.e;
   }

   public static void c() {
      a("water", new class_acd(new MobEffect[0]));
      a("mundane", new class_acd(new MobEffect[0]));
      a("thick", new class_acd(new MobEffect[0]));
      a("awkward", new class_acd(new MobEffect[0]));
      a("night_vision", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.p, 3600)}));
      a("long_night_vision", new class_acd("night_vision", new MobEffect[]{new MobEffect(MobEffectList.p, 9600)}));
      a("invisibility", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.n, 3600)}));
      a("long_invisibility", new class_acd("invisibility", new MobEffect[]{new MobEffect(MobEffectList.n, 9600)}));
      a("leaping", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.h, 3600)}));
      a("long_leaping", new class_acd("leaping", new MobEffect[]{new MobEffect(MobEffectList.h, 9600)}));
      a("strong_leaping", new class_acd("leaping", new MobEffect[]{new MobEffect(MobEffectList.h, 1800, 1)}));
      a("fire_resistance", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.l, 3600)}));
      a("long_fire_refistance", new class_acd("fire_resistance", new MobEffect[]{new MobEffect(MobEffectList.l, 9600)}));
      a("swiftness", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.a, 3600)}));
      a("long_swiftness", new class_acd("swiftness", new MobEffect[]{new MobEffect(MobEffectList.a, 9600)}));
      a("strong_swiftness", new class_acd("swiftness", new MobEffect[]{new MobEffect(MobEffectList.a, 1800, 1)}));
      a("slowness", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.b, 1800)}));
      a("long_slowness", new class_acd("slowness", new MobEffect[]{new MobEffect(MobEffectList.b, 4800)}));
      a("water_breathing", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.m, 3600)}));
      a("long_water_breathing", new class_acd("water_breathing", new MobEffect[]{new MobEffect(MobEffectList.m, 9600)}));
      a("healing", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.f, 1)}));
      a("strong_healing", new class_acd("healing", new MobEffect[]{new MobEffect(MobEffectList.f, 1, 1)}));
      a("harming", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.g, 1)}));
      a("strong_harming", new class_acd("harming", new MobEffect[]{new MobEffect(MobEffectList.g, 1, 1)}));
      a("poison", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.s, 900)}));
      a("long_poison", new class_acd("poison", new MobEffect[]{new MobEffect(MobEffectList.s, 2400)}));
      a("strong_poison", new class_acd("poison", new MobEffect[]{new MobEffect(MobEffectList.s, 450, 1)}));
      a("regeneration", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.j, 900)}));
      a("long_regeneration", new class_acd("regeneration", new MobEffect[]{new MobEffect(MobEffectList.j, 2400)}));
      a("strong_regeneration", new class_acd("regeneration", new MobEffect[]{new MobEffect(MobEffectList.j, 450, 1)}));
      a("strength", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.e, 3600)}));
      a("long_strength", new class_acd("strength", new MobEffect[]{new MobEffect(MobEffectList.e, 9600)}));
      a("strong_strength", new class_acd("strength", new MobEffect[]{new MobEffect(MobEffectList.e, 1800, 1)}));
      a("weakness", new class_acd(new MobEffect[]{new MobEffect(MobEffectList.r, 1800)}));
      a("long_weakness", new class_acd("weakness", new MobEffect[]{new MobEffect(MobEffectList.r, 4800)}));
   }

   protected static void a(String var0, class_acd var1) {
      a.register(c++, new MinecraftKey(var0), var1);
   }

   static {
      a = new RegistryBlocks(b);
   }
}
