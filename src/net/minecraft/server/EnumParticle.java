package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;

public enum EnumParticle {
   EXPLODE("explode", 0, true),
   LARGE_EXPLODE("largeexplode", 1, true),
   HUGE_EXPLOSION("hugeexplosion", 2, true),
   FIREWORKS_SPARK("fireworksSpark", 3, false),
   BUBBLE("bubble", 4, false),
   SPLASH("splash", 5, false),
   WAKE("wake", 6, false),
   SUSPENDED("suspended", 7, false),
   DEPTH_SUSPEND("depthsuspend", 8, false),
   CRIT("crit", 9, false),
   MAGIC_CRIT("magicCrit", 10, false),
   SMOKE("smoke", 11, false),
   LARGE_SMOKE("largesmoke", 12, false),
   SPELL("spell", 13, false),
   INSTANT_SPELL("instantSpell", 14, false),
   MOB_SPELL("mobSpell", 15, false),
   MOB_SPELL_AMBIENT("mobSpellAmbient", 16, false),
   WITCH_MAGIC("witchMagic", 17, false),
   DRIP_WATER("dripWater", 18, false),
   DRIP_LAVA("dripLava", 19, false),
   ANGRY_VILLAGER("angryVillager", 20, false),
   HAPPY_VILLAGER("happyVillager", 21, false),
   TOWN_AURA("townaura", 22, false),
   NOTE("note", 23, false),
   PORTAL("portal", 24, false),
   ENCHANTMENT_TABLE("enchantmenttable", 25, false),
   FLAME("flame", 26, false),
   LAVA("lava", 27, false),
   FOOTSTEP("footstep", 28, false),
   CLOUD("cloud", 29, false),
   RED_DUST("reddust", 30, false),
   SNOWBALL_POOF("snowballpoof", 31, false),
   SNOWSHOVEL("snowshovel", 32, false),
   SLIME("slime", 33, false),
   HEART("heart", 34, false),
   BARRIER("barrier", 35, false),
   IRON_CRACK("iconcrack_", 36, false, 2),
   BLOCK_CRACK("blockcrack_", 37, false, 1),
   BLOCK_DUST("blockdust_", 38, false, 1),
   DROPLET("droplet", 39, false),
   TAKE("take", 40, false),
   MOB_APPEARANCE("mobappearance", 41, true),
   DRAGON_BREATH("dragonbreath", 42, false),
   END_ROD("endRod", 43, false);

   private final String name;
   private final int id;
   private final boolean noGravity;
   private final int data;
   private static final Map W;
   private static final String[] X;

   private EnumParticle(String var3, int var4, boolean var5, int var6) {
      this.name = var3;
      this.id = var4;
      this.noGravity = var5;
      this.data = var6;
   }

   private EnumParticle(String var3, int var4, boolean var5) {
      this(var3, var4, var5, 0);
   }

   public static String[] a() {
      return X;
   }

   public String b() {
      return this.name;
   }

   public int c() {
      return this.id;
   }

   public int d() {
      return this.data;
   }

   public boolean e() {
      return this.noGravity;
   }

   public boolean f() {
      return this.data > 0;
   }

   public static EnumParticle a(int var0) {
      return (EnumParticle)W.get(Integer.valueOf(var0));
   }

   static {
      W = Maps.newHashMap();
      ArrayList var0 = Lists.newArrayList();
      EnumParticle[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumParticle var4 = var1[var3];
         W.put(Integer.valueOf(var4.c()), var4);
         if(!var4.b().endsWith("_")) {
            var0.add(var4.b());
         }
      }

      X = (String[])var0.toArray(new String[var0.size()]);
   }
}
