package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class PotionBrewer {
   private static final List a = Lists.newArrayList();
   private static final List b = Lists.newArrayList();
   private static final List c = Lists.newArrayList();
   private static final Predicate d = new Predicate() {
      public boolean a(ItemStack var1) {
         Iterator var2 = PotionBrewer.c.iterator();

         PotionBrewer.class_a_in_class_ace var3;
         do {
            if(!var2.hasNext()) {
               return false;
            }

            var3 = (PotionBrewer.class_a_in_class_ace)var2.next();
         } while(!var3.a(var1));

         return true;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((ItemStack)var1);
      }
   };

   public static boolean a(ItemStack var0) {
      return b(var0) || c(var0);
   }

   protected static boolean b(ItemStack var0) {
      int var1 = 0;

      for(int var2 = b.size(); var1 < var2; ++var1) {
         if(((PotionBrewer.class_b_in_class_ace)b.get(var1)).b.apply(var0)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean c(ItemStack var0) {
      int var1 = 0;

      for(int var2 = a.size(); var1 < var2; ++var1) {
         if(((PotionBrewer.class_b_in_class_ace)a.get(var1)).b.apply(var0)) {
            return true;
         }
      }

      return false;
   }

   public static boolean a(ItemStack var0, ItemStack var1) {
      return !d.apply(var0)?false:b(var0, var1) || c(var0, var1);
   }

   protected static boolean b(ItemStack var0, ItemStack var1) {
      Item var2 = var0.getItem();
      int var3 = 0;

      for(int var4 = b.size(); var3 < var4; ++var3) {
         PotionBrewer.class_b_in_class_ace var5 = (PotionBrewer.class_b_in_class_ace)b.get(var3);
         if(var5.a == var2 && var5.b.apply(var1)) {
            return true;
         }
      }

      return false;
   }

   protected static boolean c(ItemStack var0, ItemStack var1) {
      RegistryPotions var2 = ItemPotion.i(var0);
      int var3 = 0;

      for(int var4 = a.size(); var3 < var4; ++var3) {
         PotionBrewer.class_b_in_class_ace var5 = (PotionBrewer.class_b_in_class_ace)a.get(var3);
         if(var5.a == var2 && var5.b.apply(var1)) {
            return true;
         }
      }

      return false;
   }

   public static ItemStack d(ItemStack var0, ItemStack var1) {
      if(var1 != null) {
         RegistryPotions var2 = ItemPotion.i(var1);
         Item var3 = var1.getItem();
         int var4 = 0;

         int var5;
         PotionBrewer.class_b_in_class_ace var6;
         for(var5 = b.size(); var4 < var5; ++var4) {
            var6 = (PotionBrewer.class_b_in_class_ace)b.get(var4);
            if(var6.a == var3 && var6.b.apply(var0)) {
               return ItemPotion.a(new ItemStack((Item) var6.c), var2);
            }
         }

         var4 = 0;

         for(var5 = a.size(); var4 < var5; ++var4) {
            var6 = (PotionBrewer.class_b_in_class_ace)a.get(var4);
            if(var6.a == var2 && var6.b.apply(var0)) {
               return ItemPotion.a(new ItemStack(var3), (RegistryPotions) var6.c);
            }
         }
      }

      return var1;
   }

   public static void a() {
      PotionBrewer.class_a_in_class_ace var0 = new PotionBrewer.class_a_in_class_ace(Items.NETHER_WART);
      PotionBrewer.class_a_in_class_ace var1 = new PotionBrewer.class_a_in_class_ace(Items.GOLDEN_CARROT);
      PotionBrewer.class_a_in_class_ace var2 = new PotionBrewer.class_a_in_class_ace(Items.REDSTONE);
      PotionBrewer.class_a_in_class_ace var3 = new PotionBrewer.class_a_in_class_ace(Items.FERMENTED_SPIDER_EYE);
      PotionBrewer.class_a_in_class_ace var4 = new PotionBrewer.class_a_in_class_ace(Items.RABBIT_FOOT);
      PotionBrewer.class_a_in_class_ace var5 = new PotionBrewer.class_a_in_class_ace(Items.GLOWSTONE_DUST);
      PotionBrewer.class_a_in_class_ace var6 = new PotionBrewer.class_a_in_class_ace(Items.MAGMA_CREAM);
      PotionBrewer.class_a_in_class_ace var7 = new PotionBrewer.class_a_in_class_ace(Items.SUGAR);
      PotionBrewer.class_a_in_class_ace var8 = new PotionBrewer.class_a_in_class_ace(Items.FISH, ItemFish.class_a_in_class_aak.d.a());
      PotionBrewer.class_a_in_class_ace var9 = new PotionBrewer.class_a_in_class_ace(Items.SPECKLED_MELON);
      PotionBrewer.class_a_in_class_ace var10 = new PotionBrewer.class_a_in_class_ace(Items.SPIDER_EYE);
      PotionBrewer.class_a_in_class_ace var11 = new PotionBrewer.class_a_in_class_ace(Items.GHAST_TEAR);
      PotionBrewer.class_a_in_class_ace var12 = new PotionBrewer.class_a_in_class_ace(Items.BLAZE_POWDER);
      a(new PotionBrewer.class_a_in_class_ace(Items.POTION));
      a(new PotionBrewer.class_a_in_class_ace(Items.SPLASH_POTION));
      a(Items.POTION, new PotionBrewer.class_a_in_class_ace(Items.GUNPOWDER), Items.SPLASH_POTION);
      a((RegistryPotions)class_acf.a, (Predicate)var9, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var11, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var4, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var12, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var10, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var7, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var6, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var5, (RegistryPotions)class_acf.c);
      a((RegistryPotions)class_acf.a, (Predicate)var2, (RegistryPotions)class_acf.b);
      a((RegistryPotions)class_acf.a, (Predicate)var0, (RegistryPotions)class_acf.d);
      a((RegistryPotions)class_acf.d, (Predicate)var1, (RegistryPotions)class_acf.e);
      a((RegistryPotions)class_acf.e, (Predicate)var2, (RegistryPotions)class_acf.f);
      a((RegistryPotions)class_acf.e, (Predicate)var3, (RegistryPotions)class_acf.g);
      a((RegistryPotions)class_acf.f, (Predicate)var3, (RegistryPotions)class_acf.h);
      a((RegistryPotions)class_acf.g, (Predicate)var2, (RegistryPotions)class_acf.h);
      a((RegistryPotions)class_acf.d, (Predicate)var6, (RegistryPotions)class_acf.l);
      a((RegistryPotions)class_acf.l, (Predicate)var2, (RegistryPotions)class_acf.m);
      a((RegistryPotions)class_acf.d, (Predicate)var4, (RegistryPotions)class_acf.i);
      a((RegistryPotions)class_acf.i, (Predicate)var2, (RegistryPotions)class_acf.j);
      a((RegistryPotions)class_acf.i, (Predicate)var5, (RegistryPotions)class_acf.k);
      a((RegistryPotions)class_acf.i, (Predicate)var3, (RegistryPotions)class_acf.q);
      a((RegistryPotions)class_acf.j, (Predicate)var3, (RegistryPotions)class_acf.r);
      a((RegistryPotions)class_acf.q, (Predicate)var2, (RegistryPotions)class_acf.r);
      a((RegistryPotions)class_acf.n, (Predicate)var3, (RegistryPotions)class_acf.q);
      a((RegistryPotions)class_acf.o, (Predicate)var3, (RegistryPotions)class_acf.r);
      a((RegistryPotions)class_acf.d, (Predicate)var7, (RegistryPotions)class_acf.n);
      a((RegistryPotions)class_acf.n, (Predicate)var2, (RegistryPotions)class_acf.o);
      a((RegistryPotions)class_acf.n, (Predicate)var5, (RegistryPotions)class_acf.p);
      a((RegistryPotions)class_acf.d, (Predicate)var8, (RegistryPotions)class_acf.s);
      a((RegistryPotions)class_acf.s, (Predicate)var2, (RegistryPotions)class_acf.t);
      a((RegistryPotions)class_acf.d, (Predicate)var9, (RegistryPotions)class_acf.u);
      a((RegistryPotions)class_acf.u, (Predicate)var5, (RegistryPotions)class_acf.v);
      a((RegistryPotions)class_acf.u, (Predicate)var3, (RegistryPotions)class_acf.w);
      a((RegistryPotions)class_acf.v, (Predicate)var3, (RegistryPotions)class_acf.x);
      a((RegistryPotions)class_acf.w, (Predicate)var5, (RegistryPotions)class_acf.x);
      a((RegistryPotions)class_acf.y, (Predicate)var3, (RegistryPotions)class_acf.w);
      a((RegistryPotions)class_acf.z, (Predicate)var3, (RegistryPotions)class_acf.w);
      a((RegistryPotions)class_acf.A, (Predicate)var3, (RegistryPotions)class_acf.x);
      a((RegistryPotions)class_acf.d, (Predicate)var10, (RegistryPotions)class_acf.y);
      a((RegistryPotions)class_acf.y, (Predicate)var2, (RegistryPotions)class_acf.z);
      a((RegistryPotions)class_acf.y, (Predicate)var5, (RegistryPotions)class_acf.A);
      a((RegistryPotions)class_acf.d, (Predicate)var11, (RegistryPotions)class_acf.B);
      a((RegistryPotions)class_acf.B, (Predicate)var2, (RegistryPotions)class_acf.C);
      a((RegistryPotions)class_acf.B, (Predicate)var5, (RegistryPotions)class_acf.D);
      a((RegistryPotions)class_acf.d, (Predicate)var12, (RegistryPotions)class_acf.E);
      a((RegistryPotions)class_acf.E, (Predicate)var2, (RegistryPotions)class_acf.F);
      a((RegistryPotions)class_acf.E, (Predicate)var5, (RegistryPotions)class_acf.G);
      a((RegistryPotions)class_acf.a, (Predicate)var3, (RegistryPotions)class_acf.H);
      a((RegistryPotions)class_acf.H, (Predicate)var2, (RegistryPotions)class_acf.I);
   }

   private static void a(ItemPotion var0, PotionBrewer.class_a_in_class_ace var1, ItemPotion var2) {
      b.add(new PotionBrewer.class_b_in_class_ace(var0, var1, var2));
   }

   private static void a(PotionBrewer.class_a_in_class_ace var0) {
      c.add(var0);
   }

   private static void a(RegistryPotions var0, Predicate var1, RegistryPotions var2) {
      a.add(new PotionBrewer.class_b_in_class_ace(var0, var1, var2));
   }

   static class class_a_in_class_ace implements Predicate {
      private final Item a;
      private final int b;

      public class_a_in_class_ace(Item var1) {
         this(var1, -1);
      }

      public class_a_in_class_ace(Item var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public boolean a(ItemStack var1) {
         return var1 != null && var1.getItem() == this.a && (this.b == -1 || this.b == var1.i());
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((ItemStack)var1);
      }
   }

   static class class_b_in_class_ace {
      final Object a;
      final Predicate b;
      final Object c;

      public class_b_in_class_ace(Object var1, Predicate var2, Object var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
