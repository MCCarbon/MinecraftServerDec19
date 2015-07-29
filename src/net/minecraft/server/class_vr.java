package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aih;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;

public class class_vr extends class_vn {
   private static final int c = class_qi.a(class_vr.class);
   private int d;
   public double a;
   public double b;

   public class_vr(class_aen var1) {
      super(var1);
   }

   public class_vr(class_aen var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public class_vn.class_a_in_class_vn s() {
      return class_vn.class_a_in_class_vn.c;
   }

   protected void h() {
      super.h();
      this.ac.a(c, new Byte((byte)0));
   }

   public void t_() {
      super.t_();
      if(this.d > 0) {
         --this.d;
      }

      if(this.d <= 0) {
         this.a = this.b = 0.0D;
      }

      this.i(this.d > 0);
      if(this.j() && this.V.nextInt(4) == 0) {
         this.o.a(class_cy.m, this.s, this.t + 0.8D, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   protected double m() {
      return 0.2D;
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(!var1.c() && this.o.R().b("doEntityDrops")) {
         this.a(new class_aas(class_agk.al, 1), 0.0F);
      }

   }

   protected void a(class_cj var1, class_anl var2) {
      super.a(var1, var2);
      double var3 = this.a * this.a + this.b * this.b;
      if(var3 > 1.0E-4D && this.v * this.v + this.x * this.x > 0.001D) {
         var3 = (double)class_nu.a(var3);
         this.a /= var3;
         this.b /= var3;
         if(this.a * this.v + this.b * this.x < 0.0D) {
            this.a = 0.0D;
            this.b = 0.0D;
         } else {
            double var5 = var3 / this.m();
            this.a *= var5;
            this.b *= var5;
         }
      }

   }

   protected void o() {
      double var1 = this.a * this.a + this.b * this.b;
      if(var1 > 1.0E-4D) {
         var1 = (double)class_nu.a(var1);
         this.a /= var1;
         this.b /= var1;
         double var3 = 1.0D;
         this.v *= 0.800000011920929D;
         this.w *= 0.0D;
         this.x *= 0.800000011920929D;
         this.v += this.a * var3;
         this.x += this.b * var3;
      } else {
         this.v *= 0.9800000190734863D;
         this.w *= 0.0D;
         this.x *= 0.9800000190734863D;
      }

      super.o();
   }

   public boolean a(class_xa var1, class_aas var2, class_oo var3) {
      if(var2 != null && var2.b() == class_aau.j) {
         if(!var1.bH.d) {
            --var2.b;
         }

         this.d += 3600;
      }

      this.a = this.s - var1.s;
      this.b = this.u - var1.u;
      return true;
   }

   protected void b(class_dn var1) {
      super.b(var1);
      var1.a("PushX", this.a);
      var1.a("PushZ", this.b);
      var1.a("Fuel", (short)this.d);
   }

   protected void a(class_dn var1) {
      super.a(var1);
      this.a = var1.j("PushX");
      this.b = var1.j("PushZ");
      this.d = var1.f("Fuel");
   }

   protected boolean j() {
      return (this.ac.a(c) & 1) != 0;
   }

   protected void i(boolean var1) {
      if(var1) {
         this.ac.b(c, Byte.valueOf((byte)(this.ac.a(c) | 1)));
      } else {
         this.ac.b(c, Byte.valueOf((byte)(this.ac.a(c) & -2)));
      }

   }

   public class_anl u() {
      return (this.j()?class_agk.am:class_agk.al).S().a(class_aih.a, class_cq.c);
   }
}
