package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_td;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_sy extends class_rm {
   private static final Logger a = LogManager.getLogger();
   private class_qb b;
   private final Predicate c;
   private final class_sz.class_a_in_class_sz d;
   private class_qa e;

   public class_sy(class_qb var1) {
      this.b = var1;
      if(var1 instanceof class_qh) {
         a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
      }

      this.c = new Predicate() {
         public boolean a(class_pr var1) {
            if(!(var1 instanceof class_xa)) {
               return false;
            } else if(((class_xa)var1).bH.a) {
               return false;
            } else {
               double var2 = class_sy.this.f();
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

               return (double)var1.g(class_sy.this.b) > var2?false:class_td.a(class_sy.this.b, (class_qa)var1, false, true);
            }
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_pr)var1);
         }
      };
      this.d = new class_sz.class_a_in_class_sz(var1);
   }

   public boolean a() {
      double var1 = this.f();
      List var3 = this.b.o.a(class_xa.class, this.b.aT().b(var1, 4.0D, var1), this.c);
      Collections.sort(var3, this.d);
      if(var3.isEmpty()) {
         return false;
      } else {
         this.e = (class_qa)var3.get(0);
         return true;
      }
   }

   public boolean b() {
      class_qa var1 = this.b.w();
      if(var1 == null) {
         return false;
      } else if(!var1.ai()) {
         return false;
      } else if(var1 instanceof class_xa && ((class_xa)var1).bH.a) {
         return false;
      } else {
         class_awp var2 = this.b.bP();
         class_awp var3 = var1.bP();
         if(var2 != null && var3 == var2) {
            return false;
         } else {
            double var4 = this.f();
            return this.b.h(var1) > var4 * var4?false:!(var1 instanceof class_lh) || !((class_lh)var1).c.d();
         }
      }
   }

   public void c() {
      this.b.d(this.e);
      super.c();
   }

   public void d() {
      this.b.d((class_qa)null);
      super.c();
   }

   protected double f() {
      class_ql var1 = this.b.a((class_qk)class_wl.b);
      return var1 == null?16.0D:var1.e();
   }
}