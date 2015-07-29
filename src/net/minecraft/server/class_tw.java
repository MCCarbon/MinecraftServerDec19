package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pp;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public abstract class class_tw extends class_po implements class_pp {
   protected class_agj bv;
   private int bs;
   private class_xa bt;

   public class_tw(class_aen var1) {
      super(var1);
      this.bv = class_agk.c;
   }

   protected void cc() {
      if(this.l() != 0) {
         this.bs = 0;
      }

      super.cc();
   }

   public void m() {
      super.m();
      if(this.l() != 0) {
         this.bs = 0;
      }

      if(this.bs > 0) {
         --this.bs;
         if(this.bs % 10 == 0) {
            double var1 = this.V.nextGaussian() * 0.02D;
            double var3 = this.V.nextGaussian() * 0.02D;
            double var5 = this.V.nextGaussian() * 0.02D;
            this.o.a(class_cy.I, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var1, var3, var5, new int[0]);
         }
      }

   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else {
         this.bs = 0;
         return super.a(var1, var2);
      }
   }

   public float a(class_cj var1) {
      return this.o.p(var1.b()).c() == class_agk.c?10.0F:this.o.o(var1) - 0.5F;
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("InLove", this.bs);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.bs = var1.g("InLove");
   }

   public boolean cf() {
      int var1 = class_nu.c(this.s);
      int var2 = class_nu.c(this.aT().b);
      int var3 = class_nu.c(this.u);
      class_cj var4 = new class_cj(var1, var2, var3);
      return this.o.p(var4.b()).c() == this.bv && this.o.k(var4) > 8 && super.cf();
   }

   public int y() {
      return 120;
   }

   protected boolean E() {
      return false;
   }

   protected int b(class_xa var1) {
      return 1 + this.o.s.nextInt(3);
   }

   public boolean d(class_aas var1) {
      return var1 == null?false:var1.b() == class_aau.Q;
   }

   public boolean a(class_xa var1, class_oo var2, class_aas var3) {
      if(var3 != null) {
         if(this.d(var3) && this.l() == 0 && this.bs <= 0) {
            this.a(var1, var3);
            this.a(var1);
            return true;
         }

         if(this.j_() && this.d(var3)) {
            this.a(var1, var3);
            this.a((int)((float)(-this.l() / 20) * 0.1F), true);
            return true;
         }
      }

      return super.a(var1, var2, var3);
   }

   protected void a(class_xa var1, class_aas var2) {
      if(!var1.bH.d) {
         --var2.b;
      }

   }

   public void a(class_xa var1) {
      this.bs = 600;
      this.bt = var1;
      this.o.a((class_pr)this, (byte)18);
   }

   public class_xa cF() {
      return this.bt;
   }

   public boolean cG() {
      return this.bs > 0;
   }

   public void cH() {
      this.bs = 0;
   }

   public boolean a(class_tw var1) {
      return var1 == this?false:(var1.getClass() != this.getClass()?false:this.cG() && var1.cG());
   }
}
