package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_sx extends class_rm {
   private static final Logger a = LogManager.getLogger();
   private EntityInsentient b;
   private final Predicate c;
   private final class_sz.class_a_in_class_sz d;
   private EntityLiving e;
   private Class f;

   public class_sx(EntityInsentient var1, Class var2) {
      this.b = var1;
      this.f = var2;
      if(var1 instanceof class_qh) {
         a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
      }

      this.c = new Predicate() {
         public boolean a(EntityLiving var1) {
            double var2 = class_sx.this.f();
            if(var1.ax()) {
               var2 *= 0.800000011920929D;
            }

            return var1.aA()?false:((double)var1.g(class_sx.this.b) > var2?false:class_td.a(class_sx.this.b, var1, false, true));
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((EntityLiving)var1);
         }
      };
      this.d = new class_sz.class_a_in_class_sz(var1);
   }

   public boolean a() {
      double var1 = this.f();
      List var3 = this.b.o.a(this.f, this.b.aT().grow(var1, 4.0D, var1), this.c);
      Collections.sort(var3, this.d);
      if(var3.isEmpty()) {
         return false;
      } else {
         this.e = (EntityLiving)var3.get(0);
         return true;
      }
   }

   public boolean b() {
      EntityLiving var1 = this.b.w();
      if(var1 == null) {
         return false;
      } else if(!var1.isAlive()) {
         return false;
      } else {
         double var2 = this.f();
         return this.b.h(var1) > var2 * var2?false:!(var1 instanceof EntityPlayer) || !((EntityPlayer)var1).playerInteractManager.d();
      }
   }

   public void c() {
      this.b.d(this.e);
      super.c();
   }

   public void d() {
      this.b.d((EntityLiving)null);
      super.c();
   }

   protected double f() {
      class_ql var1 = this.b.a((class_qk)class_wl.b);
      return var1 == null?16.0D:var1.e();
   }
}
