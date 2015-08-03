package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_aco;
import net.minecraft.server.class_acs;
import net.minecraft.server.class_act;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_mv;
import net.minecraft.server.class_mw;
import net.minecraft.server.class_my;
import net.minecraft.server.class_pt;
import net.minecraft.server.ItemBlock;

public class StatisticList {
   protected static Map a = Maps.newHashMap();
   public static List b = Lists.newArrayList();
   public static List c = Lists.newArrayList();
   public static List d = Lists.newArrayList();
   public static List e = Lists.newArrayList();
   public static class_my f = (new class_mv("stat.leaveGame", new ChatMessage("stat.leaveGame", new Object[0]))).i().h();
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
            var0.add(var2.b().getItem());
         }
      }

      var1 = class_aco.a().b().values().iterator();

      while(var1.hasNext()) {
         ItemStack var5 = (ItemStack)var1.next();
         var0.add(var5.getItem());
      }

      var1 = var0.iterator();

      while(var1.hasNext()) {
         Item var6 = (Item)var1.next();
         if(var6 != null) {
            int var3 = Item.getId(var6);
            String var4 = a(var6);
            if(var4 != null) {
               ac[var3] = (new class_mw("stat.craftItem.", var4, new ChatMessage("stat.craftItem", new Object[]{(new ItemStack(var6)).B()}), var6)).h();
            }
         }
      }

      a(ac);
   }

   private static void c() {
      Iterator var0 = Block.BLOCK_REGISTRY.iterator();

      while(var0.hasNext()) {
         Block var1 = (Block)var0.next();
         Item var2 = Item.getItemOf(var1);
         if(var2 != null) {
            int var3 = Block.getId(var1);
            String var4 = a(var2);
            if(var4 != null && var1.useBreakStat()) {
               ab[var3] = (new class_mw("stat.mineBlock.", var4, new ChatMessage("stat.mineBlock", new Object[]{(new ItemStack(var1)).B()}), var2)).h();
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
               ad[var2] = (new class_mw("stat.useItem.", var3, new ChatMessage("stat.useItem", new Object[]{(new ItemStack(var1)).B()}), var1)).h();
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
               ae[var2] = (new class_mw("stat.breakItem.", var3, new ChatMessage("stat.breakItem", new Object[]{(new ItemStack(var1)).B()}), var1)).h();
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
      a(var0, BlockStainedGlassPane.WATER, BlockStainedGlassPane.FLOWING_WATER);
      a(var0, BlockStainedGlassPane.LAVA, BlockStainedGlassPane.FLOWING_LAVA);
      a(var0, BlockStainedGlassPane.LIT_PUMPKIN, BlockStainedGlassPane.PUMPKIN);
      a(var0, BlockStainedGlassPane.LIT_FURNACE, BlockStainedGlassPane.FURNACE);
      a(var0, BlockStainedGlassPane.LIT_REDSTONE_ORE, BlockStainedGlassPane.REDSTONE_ORE);
      a(var0, BlockStainedGlassPane.POWERED_REPEATER, BlockStainedGlassPane.UNPOWERED_REPEATER);
      a(var0, BlockStainedGlassPane.POWERED_COMPARATOR, BlockStainedGlassPane.UNPOWERED_COMPARATOR);
      a(var0, BlockStainedGlassPane.REDSTONE_TORCH, BlockStainedGlassPane.UNLIT_REDSTONE_TORCH);
      a(var0, BlockStainedGlassPane.LIT_REDSTONE_LAMP, BlockStainedGlassPane.REDSTONE_LAMP);
      a(var0, BlockStainedGlassPane.DOUBLE_SANDSTONE_SLAB, BlockStainedGlassPane.STONE_SLAB);
      a(var0, BlockStainedGlassPane.DOUBLE_WOODEN_SLAB, BlockStainedGlassPane.WOODEN_SLAB);
      a(var0, BlockStainedGlassPane.DOUBLE_STONE_SLAB2, BlockStainedGlassPane.STONE_SLAB2);
      a(var0, BlockStainedGlassPane.GRASS, BlockStainedGlassPane.DIRT);
      a(var0, BlockStainedGlassPane.FARMLAND, BlockStainedGlassPane.DIRT);
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
      return var1 == null?null:(new class_my("stat.killEntity." + var1, new ChatMessage("stat.entityKill", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static class_my b(class_pt.class_a_in_class_pt var0) {
      String var1 = class_pt.b(var0.a);
      return var1 == null?null:(new class_my("stat.entityKilledBy." + var1, new ChatMessage("stat.entityKilledBy", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static class_my a(String var0) {
      return (class_my)a.get(var0);
   }

   static {
      g = (new class_mv("stat.playOneMinute", new ChatMessage("stat.playOneMinute", new Object[0]), class_my.h)).i().h();
      h = (new class_mv("stat.timeSinceDeath", new ChatMessage("stat.timeSinceDeath", new Object[0]), class_my.h)).i().h();
      i = (new class_mv("stat.walkOneCm", new ChatMessage("stat.walkOneCm", new Object[0]), class_my.i)).i().h();
      j = (new class_mv("stat.crouchOneCm", new ChatMessage("stat.crouchOneCm", new Object[0]), class_my.i)).i().h();
      k = (new class_mv("stat.sprintOneCm", new ChatMessage("stat.sprintOneCm", new Object[0]), class_my.i)).i().h();
      l = (new class_mv("stat.swimOneCm", new ChatMessage("stat.swimOneCm", new Object[0]), class_my.i)).i().h();
      m = (new class_mv("stat.fallOneCm", new ChatMessage("stat.fallOneCm", new Object[0]), class_my.i)).i().h();
      n = (new class_mv("stat.climbOneCm", new ChatMessage("stat.climbOneCm", new Object[0]), class_my.i)).i().h();
      o = (new class_mv("stat.flyOneCm", new ChatMessage("stat.flyOneCm", new Object[0]), class_my.i)).i().h();
      p = (new class_mv("stat.diveOneCm", new ChatMessage("stat.diveOneCm", new Object[0]), class_my.i)).i().h();
      q = (new class_mv("stat.minecartOneCm", new ChatMessage("stat.minecartOneCm", new Object[0]), class_my.i)).i().h();
      r = (new class_mv("stat.boatOneCm", new ChatMessage("stat.boatOneCm", new Object[0]), class_my.i)).i().h();
      s = (new class_mv("stat.pigOneCm", new ChatMessage("stat.pigOneCm", new Object[0]), class_my.i)).i().h();
      t = (new class_mv("stat.horseOneCm", new ChatMessage("stat.horseOneCm", new Object[0]), class_my.i)).i().h();
      u = (new class_mv("stat.jump", new ChatMessage("stat.jump", new Object[0]))).i().h();
      v = (new class_mv("stat.drop", new ChatMessage("stat.drop", new Object[0]))).i().h();
      w = (new class_mv("stat.damageDealt", new ChatMessage("stat.damageDealt", new Object[0]), class_my.j)).h();
      x = (new class_mv("stat.damageTaken", new ChatMessage("stat.damageTaken", new Object[0]), class_my.j)).h();
      y = (new class_mv("stat.deaths", new ChatMessage("stat.deaths", new Object[0]))).h();
      z = (new class_mv("stat.mobKills", new ChatMessage("stat.mobKills", new Object[0]))).h();
      A = (new class_mv("stat.animalsBred", new ChatMessage("stat.animalsBred", new Object[0]))).h();
      B = (new class_mv("stat.playerKills", new ChatMessage("stat.playerKills", new Object[0]))).h();
      C = (new class_mv("stat.fishCaught", new ChatMessage("stat.fishCaught", new Object[0]))).h();
      D = (new class_mv("stat.junkFished", new ChatMessage("stat.junkFished", new Object[0]))).h();
      E = (new class_mv("stat.treasureFished", new ChatMessage("stat.treasureFished", new Object[0]))).h();
      F = (new class_mv("stat.talkedToVillager", new ChatMessage("stat.talkedToVillager", new Object[0]))).h();
      G = (new class_mv("stat.tradedWithVillager", new ChatMessage("stat.tradedWithVillager", new Object[0]))).h();
      H = (new class_mv("stat.cakeSlicesEaten", new ChatMessage("stat.cakeSlicesEaten", new Object[0]))).h();
      I = (new class_mv("stat.cauldronFilled", new ChatMessage("stat.cauldronFilled", new Object[0]))).h();
      J = (new class_mv("stat.cauldronUsed", new ChatMessage("stat.cauldronUsed", new Object[0]))).h();
      K = (new class_mv("stat.armorCleaned", new ChatMessage("stat.armorCleaned", new Object[0]))).h();
      L = (new class_mv("stat.bannerCleaned", new ChatMessage("stat.bannerCleaned", new Object[0]))).h();
      M = (new class_mv("stat.brewingstandInteraction", new ChatMessage("stat.brewingstandInteraction", new Object[0]))).h();
      N = (new class_mv("stat.beaconInteraction", new ChatMessage("stat.beaconInteraction", new Object[0]))).h();
      O = (new class_mv("stat.dropperInspected", new ChatMessage("stat.dropperInspected", new Object[0]))).h();
      P = (new class_mv("stat.hopperInspected", new ChatMessage("stat.hopperInspected", new Object[0]))).h();
      Q = (new class_mv("stat.dispenserInspected", new ChatMessage("stat.dispenserInspected", new Object[0]))).h();
      R = (new class_mv("stat.noteblockPlayed", new ChatMessage("stat.noteblockPlayed", new Object[0]))).h();
      S = (new class_mv("stat.noteblockTuned", new ChatMessage("stat.noteblockTuned", new Object[0]))).h();
      T = (new class_mv("stat.flowerPotted", new ChatMessage("stat.flowerPotted", new Object[0]))).h();
      U = (new class_mv("stat.trappedChestTriggered", new ChatMessage("stat.trappedChestTriggered", new Object[0]))).h();
      V = (new class_mv("stat.enderchestOpened", new ChatMessage("stat.enderchestOpened", new Object[0]))).h();
      W = (new class_mv("stat.itemEnchanted", new ChatMessage("stat.itemEnchanted", new Object[0]))).h();
      X = (new class_mv("stat.recordPlayed", new ChatMessage("stat.recordPlayed", new Object[0]))).h();
      Y = (new class_mv("stat.furnaceInteraction", new ChatMessage("stat.furnaceInteraction", new Object[0]))).h();
      Z = (new class_mv("stat.craftingTableInteraction", new ChatMessage("stat.workbenchInteraction", new Object[0]))).h();
      aa = (new class_mv("stat.chestOpened", new ChatMessage("stat.chestOpened", new Object[0]))).h();
      ab = new class_my[4096];
      ac = new class_my[32000];
      ad = new class_my[32000];
      ae = new class_my[32000];
   }
}
