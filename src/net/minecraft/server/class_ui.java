package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_uk;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_zy;

public class class_ui extends class_uk {
   public float a;
   public float b;
   public float c;
   public float bq;
   public float br;
   public float bs;
   public float bt;
   public float bu;
   private float bv;
   private float bw;
   private float bx;
   private float by;
   private float bz;
   private float bA;

   public class_ui(class_aen var1) {
      super(var1);
      this.a(0.95F, 0.95F);
      this.V.setSeed((long)(1 + this.F()));
      this.bw = 1.0F / (this.V.nextFloat() + 1.0F) * 0.2F;
      this.i.a(0, new class_ui.class_a_in_class_ui(this));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(10.0D);
   }

   public float aU() {
      return this.K * 0.5F;
   }

   protected String C() {
      return null;
   }

   protected String bp() {
      return null;
   }

   protected String bq() {
      return null;
   }

   protected float bC() {
      return 0.4F;
   }

   protected class_aar D() {
      return null;
   }

   protected boolean s_() {
      return false;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3 + var2) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(new class_aas(class_aau.aY, 1, class_zy.p.b()), 0.0F);
      }

   }

   public boolean V() {
      return this.o.a((class_awf)this.aT().b(0.0D, -0.6000000238418579D, 0.0D), (class_atk)class_atk.h, (class_pr)this);
   }

   public void m() {
      super.m();
      this.b = this.a;
      this.bq = this.c;
      this.bs = this.br;
      this.bu = this.bt;
      this.br += this.bw;
      if((double)this.br > 6.283185307179586D) {
         if(this.o.D) {
            this.br = 6.2831855F;
         } else {
            this.br = (float)((double)this.br - 6.283185307179586D);
            if(this.V.nextInt(10) == 0) {
               this.bw = 1.0F / (this.V.nextFloat() + 1.0F) * 0.2F;
            }

            this.o.a((class_pr)this, (byte)19);
         }
      }

      if(this.Y) {
         float var1;
         if(this.br < 3.1415927F) {
            var1 = this.br / 3.1415927F;
            this.bt = class_nu.a(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
            if((double)var1 > 0.75D) {
               this.bv = 1.0F;
               this.bx = 1.0F;
            } else {
               this.bx *= 0.8F;
            }
         } else {
            this.bt = 0.0F;
            this.bv *= 0.9F;
            this.bx *= 0.99F;
         }

         if(!this.o.D) {
            this.v = (double)(this.by * this.bv);
            this.w = (double)(this.bz * this.bv);
            this.x = (double)(this.bA * this.bv);
         }

         var1 = class_nu.a(this.v * this.v + this.x * this.x);
         this.aL += (-((float)class_nu.b(this.v, this.x)) * 180.0F / 3.1415927F - this.aL) * 0.1F;
         this.y = this.aL;
         this.c = (float)((double)this.c + 3.141592653589793D * (double)this.bx * 1.5D);
         this.a += (-((float)class_nu.b((double)var1, this.w)) * 180.0F / 3.1415927F - this.a) * 0.1F;
      } else {
         this.bt = class_nu.e(class_nu.a(this.br)) * 3.1415927F * 0.25F;
         if(!this.o.D) {
            this.v = 0.0D;
            this.w -= 0.08D;
            this.w *= 0.9800000190734863D;
            this.x = 0.0D;
         }

         this.a = (float)((double)this.a + (double)(-90.0F - this.a) * 0.02D);
      }

   }

   public void g(float var1, float var2) {
      this.d(this.v, this.w, this.x);
   }

   public boolean cf() {
      return this.t > 45.0D && this.t < (double)this.o.G() && super.cf();
   }

   public void b(float var1, float var2, float var3) {
      this.by = var1;
      this.bz = var2;
      this.bA = var3;
   }

   public boolean n() {
      return this.by != 0.0F || this.bz != 0.0F || this.bA != 0.0F;
   }

   static class class_a_in_class_ui extends class_rm {
      private class_ui a;

      public class_a_in_class_ui(class_ui var1) {
         this.a = var1;
      }

      public boolean a() {
         return true;
      }

      public void e() {
         int var1 = this.a.bi();
         if(var1 > 100) {
            this.a.b(0.0F, 0.0F, 0.0F);
         } else if(this.a.bd().nextInt(50) == 0 || !this.a.Y || !this.a.n()) {
            float var2 = this.a.bd().nextFloat() * 3.1415927F * 2.0F;
            float var3 = class_nu.b(var2) * 0.2F;
            float var4 = -0.1F + this.a.bd().nextFloat() * 0.2F;
            float var5 = class_nu.a(var2) * 0.2F;
            this.a.b(var3, var4, var5);
         }

      }
   }
}
