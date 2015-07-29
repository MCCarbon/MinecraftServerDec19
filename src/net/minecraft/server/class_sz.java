package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_td;
import net.minecraft.server.class_xa;

public class class_sz extends class_td {
   protected final Class a;
   private final int g;
   protected final class_sz.class_a_in_class_sz b;
   protected Predicate c;
   protected class_qa d;

   public class_sz(class_qh var1, Class var2, boolean var3) {
      this(var1, var2, var3, false);
   }

   public class_sz(class_qh var1, Class var2, boolean var3, boolean var4) {
      this(var1, var2, 10, var3, var4, (Predicate)null);
   }

   public class_sz(class_qh var1, Class var2, int var3, boolean var4, boolean var5, final Predicate var6) {
      super(var1, var4, var5);
      this.a = var2;
      this.g = var3;
      this.b = new class_sz.class_a_in_class_sz(var1);
      this.a(1);
      this.c = new Predicate() {
         public boolean a(class_qa var1) {
            if(var6 != null && !var6.apply(var1)) {
               return false;
            } else {
               if(var1 instanceof class_xa) {
                  double var2 = class_sz.this.f();
                  if(var1.ax()) {
                     var2 *= 0.800000011920929D;
                  }

                  if(var1.aA()) {
                     float var4 = ((class_xa)var1).cc();
                     if(var4 < 0.1F) {
                        var4 = 0.1F;
                     }

                     var2 *= (double)(0.7F * var4);
                  }

                  if((double)var1.g(class_sz.this.e) > var2) {
                     return false;
                  }
               }

               return class_sz.this.a(var1, false);
            }
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_qa)var1);
         }
      };
   }

   public boolean a() {
      if(this.g > 0 && this.e.bd().nextInt(this.g) != 0) {
         return false;
      } else {
         double var1 = this.f();
         List var3 = this.e.o.a(this.a, this.a(var1), Predicates.and(this.c, class_pv.d));
         Collections.sort(var3, this.b);
         if(var3.isEmpty()) {
            return false;
         } else {
            this.d = (class_qa)var3.get(0);
            return true;
         }
      }
   }

   protected class_awf a(double var1) {
      return this.e.aT().b(var1, 4.0D, var1);
   }

   public void c() {
      this.e.d(this.d);
      super.c();
   }

   public static class class_a_in_class_sz implements Comparator {
      private final class_pr a;

      public class_a_in_class_sz(class_pr var1) {
         this.a = var1;
      }

      public int a(class_pr var1, class_pr var2) {
         double var3 = this.a.h(var1);
         double var5 = this.a.h(var2);
         return var3 < var5?-1:(var3 > var5?1:0);
      }

      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.a((class_pr)var1, (class_pr)var2);
      }
   }
}
