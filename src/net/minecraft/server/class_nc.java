package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aco;
import net.minecraft.server.class_acs;
import net.minecraft.server.class_act;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_fb;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_mv;
import net.minecraft.server.class_mw;
import net.minecraft.server.class_my;
import net.minecraft.server.class_pt;
import net.minecraft.server.ItemBlock;

public class class_nc {
   protected static Map a = Maps.newHashMap();
   public static List b = Lists.newArrayList();
   public static List c = Lists.newArrayList();
   public static List d = Lists.newArrayList();
   public static List e = Lists.newArrayList();
   public static class_my f = (new class_mv("stat.leaveGame", new class_fb("stat.leaveGame", new Object[0]))).i().h();
   public static class_my g;
   public static class_my h;
   public static class_my i;
   public static class_my j;
   public static class_my k;
   public static class_my l;
   public static class_my m;
   public static class_my n;
   public static class_my o;
   public static class_my p;
   public static class_my q;
   public static class_my r;
   public static class_my s;
   public static class_my t;
   public static class_my u;
   public static class_my v;
   public static class_my w;
   public static class_my x;
   public static class_my y;
   public static class_my z;
   public static class_my A;
   public static class_my B;
   public static class_my C;
   public static class_my D;
   public static class_my E;
   public static class_my F;
   public static class_my G;
   public static class_my H;
   public static class_my I;
   public static class_my J;
   public static class_my K;
   public static class_my L;
   public static class_my M;
   public static class_my N;
   public static class_my O;
   public static class_my P;
   public static class_my Q;
   public static class_my R;
   public static class_my S;
   public static class_my T;
   public static class_my U;
   public static class_my V;
   public static class_my W;
   public static class_my X;
   public static class_my Y;
   public static class_my Z;
   public static class_my aa;
   public static final class_my[] ab;
   public static final class_my[] ac;
   public static final class_my[] ad;
   public static final class_my[] ae;

   public static void a() {
      c();
      d();
      e();
      b();
      class_mt.a();
      class_pt.a();
   }

   private static void b() {
      HashSet var0 = Sets.newHashSet();
      Iterator var1 = class_act.a().b().iterator();

      while(var1.hasNext()) {
         class_acs var2 = (class_acs)var1.next();
         if(var2.b() != null) {
            var0.add(var2.b().b());
         }
      }

      var1 = class_aco.a().b().values().iterator();

      while(var1.hasNext()) {
         class_aas var5 = (class_aas)var1.next();
         var0.add(var5.b());
      }

      var1 = var0.iterator();

      while(var1.hasNext()) {
         Item var6 = (Item)var1.next();
         if(var6 != null) {
            int var3 = Item.getId(var6);
            String var4 = a(var6);
            if(var4 != null) {
               ac[var3] = (new class_mw("stat.craftItem.", var4, new class_fb("stat.craftItem", new Object[]{(new class_aas(var6)).B()}), var6)).h();
            }
         }
      }

      a(ac);
   }

   private static void c() {
      Iterator var0 = Block.BLOCK_REGISTRY.iterator();

      while(var0.hasNext()) {
         Block var1 = (Block)var0.next();
         Item var2 = Item.getByBlock(var1);
         if(var2 != null) {
            int var3 = Block.getId(var1);
            String var4 = a(var2);
            if(var4 != null && var1.useBreakStat()) {
               ab[var3] = (new class_mw("stat.mineBlock.", var4, new class_fb("stat.mineBlock", new Object[]{(new class_aas(var1)).B()}), var2)).h();
               e.add((class_mw)ab[var3]);
            }
         }
      }

      a(ab);
   }

   private static void d() {
      Iterator var0 = Item.ITEM_REGISTRY.iterator();

      while(var0.hasNext()) {
         Item var1 = (Item)var0.next();
         if(var1 != null) {
            int var2 = Item.getId(var1);
            String var3 = a(var1);
            if(var3 != null) {
               ad[var2] = (new class_mw("stat.useItem.", var3, new class_fb("stat.useItem", new Object[]{(new class_aas(var1)).B()}), var1)).h();
               if(!(var1 instanceof ItemBlock)) {
                  d.add((class_mw)ad[var2]);
               }
            }
         }
      }

      a(ad);
   }

   private static void e() {
      Iterator var0 = Item.ITEM_REGISTRY.iterator();

      while(var0.hasNext()) {
         Item var1 = (Item)var0.next();
         if(var1 != null) {
            int var2 = Item.getId(var1);
            String var3 = a(var1);
            if(var3 != null && var1.m()) {
               ae[var2] = (new class_mw("stat.breakItem.", var3, new class_fb("stat.breakItem", new Object[]{(new class_aas(var1)).B()}), var1)).h();
            }
         }
      }

      a(ae);
   }

   private static String a(Item var0) {
      MinecraftKey var1 = (MinecraftKey)Item.ITEM_REGISTRY.getKey(var0);
      return var1 != null?var1.toString().replace(':', '.'):null;
   }

   private static void a(class_my[] var0) {
      a(var0, Blocks.WATER, Blocks.FLOWING_WATER);
      a(var0, Blocks.LAVA, Blocks.FLOWING_LAVA);
      a(var0, Blocks.LIT_PUMPKIN, Blocks.PUMPKIN);
      a(var0, Blocks.LIT_FURNACE, Blocks.FURNACE);
      a(var0, Blocks.LIT_REDSTONE_ORE, Blocks.REDSTONE_ORE);
      a(var0, Blocks.POWERED_REPEATER, Blocks.UNPOWERED_REPEATER);
      a(var0, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_COMPARATOR);
      a(var0, Blocks.REDSTONE_TORCH, Blocks.UNLIT_REDSTONE_TORCH);
      a(var0, Blocks.LIT_REDSTONE_LAMP, Blocks.REDSTONE_LAMP);
      a(var0, Blocks.DOUBLE_SANDSTONE_SLAB, Blocks.STONE_SLAB);
      a(var0, Blocks.DOUBLE_WOODEN_SLAB, Blocks.WOODEN_SLAB);
      a(var0, Blocks.DOUBLE_STONE_SLAB2, Blocks.STONE_SLAB2);
      a(var0, Blocks.GRASS, Blocks.DIRT);
      a(var0, Blocks.FARMLAND, Blocks.DIRT);
   }

   private static void a(class_my[] var0, Block var1, Block var2) {
      int var3 = Block.getId(var1);
      int var4 = Block.getId(var2);
      if(var0[var3] != null && var0[var4] == null) {
         var0[var4] = var0[var3];
      } else {
         b.remove(var0[var3]);
         e.remove(var0[var3]);
         c.remove(var0[var3]);
         var0[var3] = var0[var4];
      }
   }

   public static class_my a(class_pt.class_a_in_class_pt var0) {
      String var1 = class_pt.b(var0.a);
      return var1 == null?null:(new class_my("stat.killEntity." + var1, new class_fb("stat.entityKill", new Object[]{new class_fb("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static class_my b(class_pt.class_a_in_class_pt var0) {
      String var1 = class_pt.b(var0.a);
      return var1 == null?null:(new class_my("stat.entityKilledBy." + var1, new class_fb("stat.entityKilledBy", new Object[]{new class_fb("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static class_my a(String var0) {
      return (class_my)a.get(var0);
   }

   static {
      g = (new class_mv("stat.playOneMinute", new class_fb("stat.playOneMinute", new Object[0]), class_my.h)).i().h();
      h = (new class_mv("stat.timeSinceDeath", new class_fb("stat.timeSinceDeath", new Object[0]), class_my.h)).i().h();
      i = (new class_mv("stat.walkOneCm", new class_fb("stat.walkOneCm", new Object[0]), class_my.i)).i().h();
      j = (new class_mv("stat.crouchOneCm", new class_fb("stat.crouchOneCm", new Object[0]), class_my.i)).i().h();
      k = (new class_mv("stat.sprintOneCm", new class_fb("stat.sprintOneCm", new Object[0]), class_my.i)).i().h();
      l = (new class_mv("stat.swimOneCm", new class_fb("stat.swimOneCm", new Object[0]), class_my.i)).i().h();
      m = (new class_mv("stat.fallOneCm", new class_fb("stat.fallOneCm", new Object[0]), class_my.i)).i().h();
      n = (new class_mv("stat.climbOneCm", new class_fb("stat.climbOneCm", new Object[0]), class_my.i)).i().h();
      o = (new class_mv("stat.flyOneCm", new class_fb("stat.flyOneCm", new Object[0]), class_my.i)).i().h();
      p = (new class_mv("stat.diveOneCm", new class_fb("stat.diveOneCm", new Object[0]), class_my.i)).i().h();
      q = (new class_mv("stat.minecartOneCm", new class_fb("stat.minecartOneCm", new Object[0]), class_my.i)).i().h();
      r = (new class_mv("stat.boatOneCm", new class_fb("stat.boatOneCm", new Object[0]), class_my.i)).i().h();
      s = (new class_mv("stat.pigOneCm", new class_fb("stat.pigOneCm", new Object[0]), class_my.i)).i().h();
      t = (new class_mv("stat.horseOneCm", new class_fb("stat.horseOneCm", new Object[0]), class_my.i)).i().h();
      u = (new class_mv("stat.jump", new class_fb("stat.jump", new Object[0]))).i().h();
      v = (new class_mv("stat.drop", new class_fb("stat.drop", new Object[0]))).i().h();
      w = (new class_mv("stat.damageDealt", new class_fb("stat.damageDealt", new Object[0]), class_my.j)).h();
      x = (new class_mv("stat.damageTaken", new class_fb("stat.damageTaken", new Object[0]), class_my.j)).h();
      y = (new class_mv("stat.deaths", new class_fb("stat.deaths", new Object[0]))).h();
      z = (new class_mv("stat.mobKills", new class_fb("stat.mobKills", new Object[0]))).h();
      A = (new class_mv("stat.animalsBred", new class_fb("stat.animalsBred", new Object[0]))).h();
      B = (new class_mv("stat.playerKills", new class_fb("stat.playerKills", new Object[0]))).h();
      C = (new class_mv("stat.fishCaught", new class_fb("stat.fishCaught", new Object[0]))).h();
      D = (new class_mv("stat.junkFished", new class_fb("stat.junkFished", new Object[0]))).h();
      E = (new class_mv("stat.treasureFished", new class_fb("stat.treasureFished", new Object[0]))).h();
      F = (new class_mv("stat.talkedToVillager", new class_fb("stat.talkedToVillager", new Object[0]))).h();
      G = (new class_mv("stat.tradedWithVillager", new class_fb("stat.tradedWithVillager", new Object[0]))).h();
      H = (new class_mv("stat.cakeSlicesEaten", new class_fb("stat.cakeSlicesEaten", new Object[0]))).h();
      I = (new class_mv("stat.cauldronFilled", new class_fb("stat.cauldronFilled", new Object[0]))).h();
      J = (new class_mv("stat.cauldronUsed", new class_fb("stat.cauldronUsed", new Object[0]))).h();
      K = (new class_mv("stat.armorCleaned", new class_fb("stat.armorCleaned", new Object[0]))).h();
      L = (new class_mv("stat.bannerCleaned", new class_fb("stat.bannerCleaned", new Object[0]))).h();
      M = (new class_mv("stat.brewingstandInteraction", new class_fb("stat.brewingstandInteraction", new Object[0]))).h();
      N = (new class_mv("stat.beaconInteraction", new class_fb("stat.beaconInteraction", new Object[0]))).h();
      O = (new class_mv("stat.dropperInspected", new class_fb("stat.dropperInspected", new Object[0]))).h();
      P = (new class_mv("stat.hopperInspected", new class_fb("stat.hopperInspected", new Object[0]))).h();
      Q = (new class_mv("stat.dispenserInspected", new class_fb("stat.dispenserInspected", new Object[0]))).h();
      R = (new class_mv("stat.noteblockPlayed", new class_fb("stat.noteblockPlayed", new Object[0]))).h();
      S = (new class_mv("stat.noteblockTuned", new class_fb("stat.noteblockTuned", new Object[0]))).h();
      T = (new class_mv("stat.flowerPotted", new class_fb("stat.flowerPotted", new Object[0]))).h();
      U = (new class_mv("stat.trappedChestTriggered", new class_fb("stat.trappedChestTriggered", new Object[0]))).h();
      V = (new class_mv("stat.enderchestOpened", new class_fb("stat.enderchestOpened", new Object[0]))).h();
      W = (new class_mv("stat.itemEnchanted", new class_fb("stat.itemEnchanted", new Object[0]))).h();
      X = (new class_mv("stat.recordPlayed", new class_fb("stat.recordPlayed", new Object[0]))).h();
      Y = (new class_mv("stat.furnaceInteraction", new class_fb("stat.furnaceInteraction", new Object[0]))).h();
      Z = (new class_mv("stat.craftingTableInteraction", new class_fb("stat.workbenchInteraction", new Object[0]))).h();
      aa = (new class_mv("stat.chestOpened", new class_fb("stat.chestOpened", new Object[0]))).h();
      ab = new class_my[4096];
      ac = new class_my[32000];
      ad = new class_my[32000];
      ae = new class_my[32000];
   }
}
