package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_py;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qz;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_sy;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xh;

public class class_we extends class_py implements class_wd {
   private static final int a = class_qi.a(class_we.class);
   private int b = 1;

   public class_we(class_aen var1) {
      super(var1);
      this.a(4.0F, 4.0F);
      this.ab = true;
      this.b_ = 5;
      this.f = new class_we.class_b_in_class_we(this);
      this.i.a(5, new class_we.class_d_in_class_we(this));
      this.i.a(7, new class_we.class_a_in_class_we(this));
      this.i.a(7, new class_we.class_c_in_class_we(this));
      this.bn.a(1, new class_sy(this));
   }

   public void a(boolean var1) {
      this.ac.b(a, Byte.valueOf((byte)(var1?1:0)));
   }

   public int cu() {
      return this.b;
   }

   public void t_() {
      super.t_();
      if(!this.o.D && this.o.ab() == class_om.a) {
         this.J();
      }

   }

   public boolean a(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if("fireball".equals(var1.p()) && var1.j() instanceof class_xa) {
         super.a(var1, 1000.0F);
         ((class_xa)var1.j()).b((class_my)class_mt.z);
         return true;
      } else {
         return super.a(var1, var2);
      }
   }

   protected void h() {
      super.h();
      this.ac.a(a, Byte.valueOf((byte)0));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(10.0D);
      this.a(class_wl.b).a(100.0D);
   }

   protected String C() {
      return "mob.ghast.moan";
   }

   protected String bp() {
      return "mob.ghast.scream";
   }

   protected String bq() {
      return "mob.ghast.death";
   }

   protected class_aar D() {
      return class_aau.J;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(2) + this.V.nextInt(1 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(class_aau.by, 1);
      }

      var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(class_aau.J, 1);
      }

   }

   protected float bC() {
      return 10.0F;
   }

   public boolean cf() {
      return this.V.nextInt(20) == 0 && super.cf() && this.o.ab() != class_om.a;
   }

   public int cj() {
      return 1;
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("ExplosionPower", this.b);
   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("ExplosionPower", 99)) {
         this.b = var1.g("ExplosionPower");
      }

   }

   public float aU() {
      return 2.6F;
   }

   static class class_c_in_class_we extends class_rm {
      private class_we b;
      public int a;

      public class_c_in_class_we(class_we var1) {
         this.b = var1;
      }

      public boolean a() {
         return this.b.w() != null;
      }

      public void c() {
         this.a = 0;
      }

      public void d() {
         this.b.a(false);
      }

      public void e() {
         class_qa var1 = this.b.w();
         double var2 = 64.0D;
         if(var1.h(this.b) < var2 * var2 && this.b.t(var1)) {
            class_aen var4 = this.b.o;
            ++this.a;
            if(this.a == 10) {
               var4.a((class_xa)null, 1007, new class_cj(this.b), 0);
            }

            if(this.a == 20) {
               double var5 = 4.0D;
               class_awh var7 = this.b.d(1.0F);
               double var8 = var1.s - (this.b.s + var7.a * var5);
               double var10 = var1.aT().b + (double)(var1.K / 2.0F) - (0.5D + this.b.t + (double)(this.b.K / 2.0F));
               double var12 = var1.u - (this.b.u + var7.c * var5);
               var4.a((class_xa)null, 1008, new class_cj(this.b), 0);
               class_xh var14 = new class_xh(var4, this.b, var8, var10, var12);
               var14.e = this.b.cu();
               var14.s = this.b.s + var7.a * var5;
               var14.t = this.b.t + (double)(this.b.K / 2.0F) + 0.5D;
               var14.u = this.b.u + var7.c * var5;
               var4.a((class_pr)var14);
               this.a = -40;
            }
         } else if(this.a > 0) {
            --this.a;
         }

         this.b.a(this.a > 10);
      }
   }

   static class class_a_in_class_we extends class_rm {
      private class_we a;

      public class_a_in_class_we(class_we var1) {
         this.a = var1;
         this.a(2);
      }

      public boolean a() {
         return true;
      }

      public void e() {
         if(this.a.w() == null) {
            this.a.aL = this.a.y = -((float)class_nu.b(this.a.v, this.a.x)) * 180.0F / 3.1415927F;
         } else {
            class_qa var1 = this.a.w();
            double var2 = 64.0D;
            if(var1.h(this.a) < var2 * var2) {
               double var4 = var1.s - this.a.s;
               double var6 = var1.u - this.a.u;
               this.a.aL = this.a.y = -((float)class_nu.b(var4, var6)) * 180.0F / 3.1415927F;
            }
         }

      }
   }

   static class class_d_in_class_we extends class_rm {
      private class_we a;

      public class_d_in_class_we(class_we var1) {
         this.a = var1;
         this.a(1);
      }

      public boolean a() {
         class_qz var1 = this.a.r();
         if(!var1.a()) {
            return true;
         } else {
            double var2 = var1.d() - this.a.s;
            double var4 = var1.e() - this.a.t;
            double var6 = var1.f() - this.a.u;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            return var8 < 1.0D || var8 > 3600.0D;
         }
      }

      public boolean b() {
         return false;
      }

      public void c() {
         Random var1 = this.a.bd();
         double var2 = this.a.s + (double)((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
         double var4 = this.a.t + (double)((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
         double var6 = this.a.u + (double)((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
         this.a.r().a(var2, var4, var6, 1.0D);
      }
   }

   static class class_b_in_class_we extends class_qz {
      private class_we g;
      private int h;

      public class_b_in_class_we(class_we var1) {
         super(var1);
         this.g = var1;
      }

      public void c() {
         if(this.f) {
            double var1 = this.b - this.g.s;
            double var3 = this.c - this.g.t;
            double var5 = this.d - this.g.u;
            double var7 = var1 * var1 + var3 * var3 + var5 * var5;
            if(this.h-- <= 0) {
               this.h += this.g.bd().nextInt(5) + 2;
               var7 = (double)class_nu.a(var7);
               if(this.b(this.b, this.c, this.d, var7)) {
                  this.g.v += var1 / var7 * 0.1D;
                  this.g.w += var3 / var7 * 0.1D;
                  this.g.x += var5 / var7 * 0.1D;
               } else {
                  this.f = false;
               }
            }

         }
      }

      private boolean b(double var1, double var3, double var5, double var7) {
         double var9 = (var1 - this.g.s) / var7;
         double var11 = (var3 - this.g.t) / var7;
         double var13 = (var5 - this.g.u) / var7;
         class_awf var15 = this.g.aT();

         for(int var16 = 1; (double)var16 < var7; ++var16) {
            var15 = var15.c(var9, var11, var13);
            if(!this.g.o.a((class_pr)this.g, (class_awf)var15).isEmpty()) {
               return false;
            }
         }

         return true;
      }
   }
}
