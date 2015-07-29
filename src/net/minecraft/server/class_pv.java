package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_uy;
import net.minecraft.server.class_xa;

public final class class_pv {
   public static final Predicate a = new Predicate() {
      public boolean a(class_pr var1) {
         return var1.ai();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_pr)var1);
      }
   };
   public static final Predicate b = new Predicate() {
      public boolean a(class_pr var1) {
         return var1.ai() && var1.l == null && var1.m == null;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_pr)var1);
      }
   };
   public static final Predicate c = new Predicate() {
      public boolean a(class_pr var1) {
         return var1 instanceof class_oj && var1.ai();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_pr)var1);
      }
   };
   public static final Predicate d = new Predicate() {
      public boolean a(class_pr var1) {
         return !(var1 instanceof class_xa) || !((class_xa)var1).v();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_pr)var1);
      }
   };

   public static Predicate a(final double var0, final double var2, final double var4, double var6) {
      final double var8 = var6 * var6;
      return new Predicate() {
         public boolean a(class_pr var1) {
            return var1 != null && var1.e(var0, var2, var4) <= var8;
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_pr)var1);
         }
      };
   }

   public static class class_a_in_class_pv implements Predicate {
      private final class_aas a;

      public class_a_in_class_pv(class_aas var1) {
         this.a = var1;
      }

      public boolean a(class_pr var1) {
         if(!var1.ai()) {
            return false;
         } else if(!(var1 instanceof class_qa)) {
            return false;
         } else {
            class_qa var2 = (class_qa)var1;
            return var2.a(class_qb.c(this.a)) != null?false:(var2 instanceof class_qb?((class_qb)var2).cm():(var2 instanceof class_uy?true:var2 instanceof class_xa));
         }
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_pr)var1);
      }
   }
}
