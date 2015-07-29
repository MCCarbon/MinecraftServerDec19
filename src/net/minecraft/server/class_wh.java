package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wo;

public class class_wh extends class_wo {
   public class_wh(class_aen var1) {
      super(var1);
      this.ab = true;
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.d).a(0.20000000298023224D);
   }

   public boolean cf() {
      return this.o.ab() != class_om.a;
   }

   public boolean cg() {
      return this.o.a((class_awf)this.aT(), (class_pr)this) && this.o.a((class_pr)this, (class_awf)this.aT()).isEmpty() && !this.o.d(this.aT());
   }

   public int bs() {
      return this.cB() * 3;
   }

   public float c(float var1) {
      return 1.0F;
   }

   protected class_cy n() {
      return class_cy.A;
   }

   protected class_wo cu() {
      return new class_wh(this.o);
   }

   protected class_aar D() {
      return class_aau.bH;
   }

   protected void b(boolean var1, int var2) {
      class_aar var3 = this.D();
      if(var3 != null && this.cB() > 1) {
         int var4 = this.V.nextInt(4) - 2;
         if(var2 > 0) {
            var4 += this.V.nextInt(var2 + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

   }

   public boolean av() {
      return false;
   }

   protected int cv() {
      return super.cv() * 4;
   }

   protected void cw() {
      this.a *= 0.9F;
   }

   protected void bG() {
      this.w = (double)(0.42F + (float)this.cB() * 0.1F);
      this.ai = true;
   }

   protected void bI() {
      this.w = (double)(0.22F + (float)this.cB() * 0.05F);
      this.ai = true;
   }

   public void e(float var1, float var2) {
   }

   protected boolean cx() {
      return true;
   }

   protected int cy() {
      return super.cy() + 2;
   }

   protected String cz() {
      return this.cB() > 1?"mob.magmacube.big":"mob.magmacube.small";
   }

   protected boolean cA() {
      return true;
   }
}
