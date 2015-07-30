package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_ot;
import net.minecraft.server.class_ou;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;

public abstract class class_vq extends class_vn implements class_ou {
   private class_aas[] a = new class_aas[36];
   private boolean b = true;

   public class_vq(World var1) {
      super(var1);
   }

   public class_vq(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void a(class_pc var1) {
      super.a(var1);
      if(this.o.R().b("doEntityDrops")) {
         class_ol.a(this.o, (class_pr)this, this);
      }

   }

   public class_aas a(int var1) {
      return this.a[var1];
   }

   public class_aas a(int var1, int var2) {
      if(this.a[var1] != null) {
         class_aas var3;
         if(this.a[var1].b <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if(this.a[var1].b == 0) {
               this.a[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public class_aas b(int var1) {
      if(this.a[var1] != null) {
         class_aas var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, class_aas var2) {
      this.a[var1] = var2;
      if(var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

   }

   public void p_() {
   }

   public boolean a(class_xa var1) {
      return this.I?false:var1.h(this) <= 64.0D;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, class_aas var2) {
      return true;
   }

   public String e_() {
      return this.l_()?this.aO():"container.minecart";
   }

   public int q_() {
      return 64;
   }

   public void c(int var1) {
      this.b = false;
      super.c(var1);
   }

   public void J() {
      if(this.b) {
         class_ol.a(this.o, (class_pr)this, this);
      }

      super.J();
   }

   protected void b(class_dn var1) {
      super.b(var1);
      class_du var2 = new class_du();

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if(this.a[var3] != null) {
            class_dn var4 = new class_dn();
            var4.a("Slot", (byte)var3);
            this.a[var3].b(var4);
            var2.a((class_eb)var4);
         }
      }

      var1.a((String)"Items", (class_eb)var2);
   }

   protected void a(class_dn var1) {
      super.a(var1);
      class_du var2 = var1.c("Items", 10);
      this.a = new class_aas[this.o_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         class_dn var4 = var2.b(var3);
         int var5 = var4.e("Slot") & 255;
         if(var5 >= 0 && var5 < this.a.length) {
            this.a[var5] = class_aas.a(var4);
         }
      }

   }

   public boolean a(class_xa var1, class_aas var2, EnumUsedHand var3) {
      if(!this.o.D) {
         var1.a((class_oj)this);
      }

      return true;
   }

   protected void o() {
      int var1 = 15 - class_xz.b((class_oj)this);
      float var2 = 0.98F + (float)var1 * 0.001F;
      this.v *= (double)var2;
      this.w *= 0.0D;
      this.x *= (double)var2;
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {
   }

   public int g() {
      return 0;
   }

   public boolean r_() {
      return false;
   }

   public void a(class_ot var1) {
   }

   public class_ot i() {
      return class_ot.a;
   }

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }
}
