package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_px extends class_pr {
   public int a;
   public int b;
   public int c;
   private int d = 5;
   private int e;
   private class_xa f;
   private int g;

   public class_px(class_aen var1, double var2, double var4, double var6, int var8) {
      super(var1);
      this.a(0.5F, 0.5F);
      this.b(var2, var4, var6);
      this.y = (float)(Math.random() * 360.0D);
      this.v = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.w = (double)((float)(Math.random() * 0.2D) * 2.0F);
      this.x = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.e = var8;
   }

   protected boolean s_() {
      return false;
   }

   public class_px(class_aen var1) {
      super(var1);
      this.a(0.25F, 0.25F);
   }

   protected void h() {
   }

   public void t_() {
      super.t_();
      if(this.c > 0) {
         --this.c;
      }

      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.w -= 0.029999999329447746D;
      if(this.o.p(new class_cj(this)).getBlock().v() == class_atk.i) {
         this.w = 0.20000000298023224D;
         this.v = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
         this.x = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
         this.a("random.fizz", 0.4F, 2.0F + this.V.nextFloat() * 0.4F);
      }

      this.j(this.s, (this.aT().b + this.aT().e) / 2.0D, this.u);
      double var1 = 8.0D;
      if(this.g < this.a - 20 + this.F() % 100) {
         if(this.f == null || this.f.h(this) > var1 * var1) {
            this.f = this.o.a(this, var1);
         }

         this.g = this.a;
      }

      if(this.f != null && this.f.v()) {
         this.f = null;
      }

      if(this.f != null) {
         double var3 = (this.f.s - this.s) / var1;
         double var5 = (this.f.t + (double)this.f.aU() - this.t) / var1;
         double var7 = (this.f.u - this.u) / var1;
         double var9 = Math.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
         double var11 = 1.0D - var9;
         if(var11 > 0.0D) {
            var11 *= var11;
            this.v += var3 / var9 * var11 * 0.1D;
            this.w += var5 / var9 * var11 * 0.1D;
            this.x += var7 / var9 * var11 * 0.1D;
         }
      }

      this.d(this.v, this.w, this.x);
      float var13 = 0.98F;
      if(this.C) {
         var13 = this.o.p(new class_cj(class_nu.c(this.s), class_nu.c(this.aT().b) - 1, class_nu.c(this.u))).getBlock().L * 0.98F;
      }

      this.v *= (double)var13;
      this.w *= 0.9800000190734863D;
      this.x *= (double)var13;
      if(this.C) {
         this.w *= -0.8999999761581421D;
      }

      ++this.a;
      ++this.b;
      if(this.b >= 6000) {
         this.J();
      }

   }

   public boolean W() {
      return this.o.a((class_awf)this.aT(), (class_atk)class_atk.h, (class_pr)this);
   }

   protected void g(int var1) {
      this.a(class_pc.a, (float)var1);
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         this.ac();
         this.d = (int)((float)this.d - var2);
         if(this.d <= 0) {
            this.J();
         }

         return false;
      }
   }

   public void b(class_dn var1) {
      var1.a("Health", (short)((byte)this.d));
      var1.a("Age", (short)this.b);
      var1.a("Value", (short)this.e);
   }

   public void a(class_dn var1) {
      this.d = var1.f("Health") & 255;
      this.b = var1.f("Age");
      this.e = var1.f("Value");
   }

   public void d(class_xa var1) {
      if(!this.o.D) {
         if(this.c == 0 && var1.bw == 0) {
            var1.bw = 2;
            this.o.a((class_pr)var1, "random.orb", 0.1F, 0.5F * ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.8F));
            var1.a(this, 1);
            var1.o(this.e);
            this.J();
         }

      }
   }

   public int j() {
      return this.e;
   }

   public static int a(int var0) {
      return var0 >= 2477?2477:(var0 >= 1237?1237:(var0 >= 617?617:(var0 >= 307?307:(var0 >= 149?149:(var0 >= 73?73:(var0 >= 37?37:(var0 >= 17?17:(var0 >= 7?7:(var0 >= 3?3:1)))))))));
   }

   public boolean aF() {
      return false;
   }
}
