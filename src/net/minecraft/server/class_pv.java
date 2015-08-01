package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.ItemStack;
import net.minecraft.server.IInventory;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_uy;
import net.minecraft.server.EntityHuman;

public final class class_pv {
   public static final Predicate a = new Predicate() {
      public boolean a(Entity var1) {
         return var1.ai();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((Entity)var1);
      }
   };
   public static final Predicate b = new Predicate() {
      public boolean a(Entity var1) {
         return var1.ai() && var1.l == null && var1.m == null;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((Entity)var1);
      }
   };
   public static final Predicate c = new Predicate() {
      public boolean a(Entity var1) {
         return var1 instanceof IInventory && var1.ai();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((Entity)var1);
      }
   };
   public static final Predicate d = new Predicate() {
      public boolean a(Entity var1) {
         return !(var1 instanceof EntityHuman) || !((EntityHuman)var1).v();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((Entity)var1);
      }
   };

   public static Predicate a(final double var0, final double var2, final double var4, double var6) {
      final double var8 = var6 * var6;
      return new Predicate() {
         public boolean a(Entity var1) {
            return var1 != null && var1.e(var0, var2, var4) <= var8;
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((Entity)var1);
         }
      };
   }

   public static class class_a_in_class_pv implements Predicate {
      private final ItemStack a;

      public class_a_in_class_pv(ItemStack var1) {
         this.a = var1;
      }

      public boolean a(Entity var1) {
         if(!var1.ai()) {
            return false;
         } else if(!(var1 instanceof EntityLiving)) {
            return false;
         } else {
            EntityLiving var2 = (EntityLiving)var1;
            return var2.a(class_qb.c(this.a)) != null?false:(var2 instanceof class_qb?((class_qb)var2).cm():(var2 instanceof class_uy?true:var2 instanceof EntityHuman));
         }
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((Entity)var1);
      }
   }
}
