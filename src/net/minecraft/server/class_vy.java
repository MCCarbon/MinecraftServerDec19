package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_ry;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xl;

public class class_vy extends class_wi {
   private float a = 0.5F;
   private int b;
   private static final int c = class_qi.a(class_vy.class);

   public class_vy(class_aen var1) {
      super(var1);
      this.ab = true;
      this.b_ = 10;
      this.i.a(4, new class_vy.class_a_in_class_vy(this));
      this.i.a(5, new class_ry(this, 1.0D));
      this.i.a(7, new class_si(this, 1.0D));
      this.i.a(8, new class_rr(this, class_xa.class, 8.0F));
      this.i.a(8, new class_sh(this));
      this.bn.a(1, new class_sw(this, true, new Class[0]));
      this.bn.a(2, new class_sz(this, class_xa.class, true));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.e).a(6.0D);
      this.a(class_wl.d).a(0.23000000417232513D);
      this.a(class_wl.b).a(48.0D);
   }

   protected void h() {
      super.h();
      this.ac.a(c, new Byte((byte)0));
   }

   protected String C() {
      return "mob.blaze.breathe";
   }

   protected String bp() {
      return "mob.blaze.hit";
   }

   protected String bq() {
      return "mob.blaze.death";
   }

   public float c(float var1) {
      return 1.0F;
   }

   public void m() {
      if(!this.C && this.w < 0.0D) {
         this.w *= 0.6D;
      }

      if(this.o.D) {
         if(this.V.nextInt(24) == 0 && !this.R()) {
            this.o.a(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D, "fire.fire", 1.0F + this.V.nextFloat(), this.V.nextFloat() * 0.7F + 0.3F, false);
         }

         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(class_cy.m, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

      super.m();
   }

   protected void cc() {
      if(this.U()) {
         this.a(class_pc.f, 1.0F);
      }

      --this.b;
      if(this.b <= 0) {
         this.b = 100;
         this.a = 0.5F + (float)this.V.nextGaussian() * 3.0F;
      }

      class_qa var1 = this.w();
      if(var1 != null && var1.t + (double)var1.aU() > this.t + (double)this.aU() + (double)this.a) {
         this.w += (0.30000001192092896D - this.w) * 0.30000001192092896D;
         this.ai = true;
      }

      super.cc();
   }

   public void e(float var1, float var2) {
   }

   protected class_aar D() {
      return class_aau.bx;
   }

   public boolean av() {
      return this.n();
   }

   protected void b(boolean var1, int var2) {
      if(var1) {
         int var3 = this.V.nextInt(2 + var2);

         for(int var4 = 0; var4 < var3; ++var4) {
            this.a(class_aau.bx, 1);
         }
      }

   }

   public boolean n() {
      return (this.ac.a(c) & 1) != 0;
   }

   public void a(boolean var1) {
      byte var2 = this.ac.a(c);
      if(var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.ac.b(c, Byte.valueOf(var2));
   }

   protected boolean n_() {
      return true;
   }

   static class class_a_in_class_vy extends class_rm {
      private class_vy a;
      private int b;
      private int c;

      public class_a_in_class_vy(class_vy var1) {
         this.a = var1;
         this.a(3);
      }

      public boolean a() {
         class_qa var1 = this.a.w();
         return var1 != null && var1.ai();
      }

      public void c() {
         this.b = 0;
      }

      public void d() {
         this.a.a(false);
      }

      public void e() {
         --this.c;
         class_qa var1 = this.a.w();
         double var2 = this.a.h(var1);
         if(var2 < 4.0D) {
            if(this.c <= 0) {
               this.c = 20;
               this.a.r(var1);
            }

            this.a.r().a(var1.s, var1.t, var1.u, 1.0D);
         } else if(var2 < 256.0D) {
            double var4 = var1.s - this.a.s;
            double var6 = var1.aT().b + (double)(var1.K / 2.0F) - (this.a.t + (double)(this.a.K / 2.0F));
            double var8 = var1.u - this.a.u;
            if(this.c <= 0) {
               ++this.b;
               if(this.b == 1) {
                  this.c = 60;
                  this.a.a(true);
               } else if(this.b <= 4) {
                  this.c = 6;
               } else {
                  this.c = 100;
                  this.b = 0;
                  this.a.a(false);
               }

               if(this.b > 1) {
                  float var10 = class_nu.c(class_nu.a(var2)) * 0.5F;
                  this.a.o.a((class_xa)null, 1009, new class_cj((int)this.a.s, (int)this.a.t, (int)this.a.u), 0);

                  for(int var11 = 0; var11 < 1; ++var11) {
                     class_xl var12 = new class_xl(this.a.o, this.a, var4 + this.a.bd().nextGaussian() * (double)var10, var6, var8 + this.a.bd().nextGaussian() * (double)var10);
                     var12.t = this.a.t + (double)(this.a.K / 2.0F) + 0.5D;
                     this.a.o.a((class_pr)var12);
                  }
               }
            }

            this.a.q().a(var1, 10.0F, 10.0F);
         } else {
            this.a.u().n();
            this.a.r().a(var1.s, var1.t, var1.u, 1.0D);
         }

         super.e();
      }
   }
}
