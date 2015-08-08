package net.minecraft.server;

import org.apache.commons.lang3.StringUtils;

public abstract class class_td extends class_rm {
   protected final EntityCreature e;
   protected boolean f;
   private boolean a;
   private int b;
   private int c;
   private int d;

   public class_td(EntityCreature var1, boolean var2) {
      this(var1, var2, false);
   }

   public class_td(EntityCreature var1, boolean var2, boolean var3) {
      this.e = var1;
      this.f = var2;
      this.a = var3;
   }

   public boolean b() {
      EntityLiving var1 = this.e.w();
      if(var1 == null) {
         return false;
      } else if(!var1.isAlive()) {
         return false;
      } else {
         class_awp var2 = this.e.bP();
         class_awp var3 = var1.bP();
         if(var2 != null && var3 == var2) {
            return false;
         } else {
            double var4 = this.f();
            if(this.e.h(var1) > var4 * var4) {
               return false;
            } else {
               if(this.f) {
                  if(this.e.v().a(var1)) {
                     this.d = 0;
                  } else if(++this.d > 60) {
                     return false;
                  }
               }

               return !(var1 instanceof EntityHuman) || !((EntityHuman)var1).abilities.invulnerable;
            }
         }
      }
   }

   protected double f() {
      class_ql var1 = this.e.a(class_wl.b);
      return var1 == null?16.0D:var1.e();
   }

   public void c() {
      this.b = 0;
      this.c = 0;
      this.d = 0;
   }

   public void d() {
      this.e.d((EntityLiving)null);
   }

   public static boolean a(EntityInsentient var0, EntityLiving var1, boolean var2, boolean var3) {
      if(var1 == null) {
         return false;
      } else if(var1 == var0) {
         return false;
      } else if(!var1.isAlive()) {
         return false;
      } else if(!var0.a(var1.getClass())) {
         return false;
      } else if(var0.c(var1)) {
         return false;
      } else {
         if(var0 instanceof class_qg && StringUtils.isNotEmpty(((class_qg)var0).b())) {
            if(var1 instanceof class_qg && ((class_qg)var0).b().equals(((class_qg)var1).b())) {
               return false;
            }

            if(var1 == ((class_qg)var0).m_()) {
               return false;
            }
         } else if(var1 instanceof EntityHuman && !var2 && ((EntityHuman)var1).abilities.invulnerable) {
            return false;
         }

         return !var3 || var0.v().a(var1);
      }
   }

   protected boolean a(EntityLiving var1, boolean var2) {
      if(!a(this.e, var1, var2, this.f)) {
         return false;
      } else if(!this.e.e(new BlockPosition(var1))) {
         return false;
      } else {
         if(this.a) {
            if(--this.c <= 0) {
               this.b = 0;
            }

            if(this.b == 0) {
               this.b = this.a(var1)?1:2;
            }

            if(this.b == 2) {
               return false;
            }
         }

         return true;
      }
   }

   private boolean a(EntityLiving var1) {
      this.c = 10 + this.e.bd().nextInt(5);
      class_auv var2 = this.e.u().a((Entity)var1);
      if(var2 == null) {
         return false;
      } else {
         class_aut var3 = var2.c();
         if(var3 == null) {
            return false;
         } else {
            int var4 = var3.a - MathHelper.floor(var1.locX);
            int var5 = var3.c - MathHelper.floor(var1.locZ);
            return (double)(var4 * var4 + var5 * var5) <= 2.25D;
         }
      }
   }
}
