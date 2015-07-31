package net.minecraft.server;

import net.minecraft.server.Items;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_wn;
import net.minecraft.server.class_zl;

public class class_sk extends class_rm {
   private final class_wn a;
   private class_qa b;
   private int c = -1;
   private double d;
   private int e;
   private int f;
   private int g;
   private float h;
   private float i;

   public class_sk(class_wn var1, double var2, int var4, int var5, float var6) {
      this.a = var1;
      this.d = var2;
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var6 * var6;
      this.a(3);
   }

   public boolean a() {
      class_qa var1 = this.a.w();
      if(var1 == null) {
         return false;
      } else {
         this.b = var1;
         return this.f();
      }
   }

   protected boolean f() {
      return this.a.bA() != null && this.a.bA().getItem() == Items.f;
   }

   public boolean b() {
      return (this.a() || !this.a.u().m()) && this.f();
   }

   public void c() {
      super.c();
      this.a.a(true);
   }

   public void d() {
      super.c();
      this.a.a(false);
      this.b = null;
      this.e = 0;
      this.c = -1;
      this.a.bZ();
   }

   public void e() {
      double var1 = this.a.e(this.b.s, this.b.aT().b, this.b.u);
      boolean var3 = this.a.v().a(this.b);
      boolean var4 = this.e > 0;
      if(var3 != var4) {
         this.e = 0;
      }

      if(var3) {
         ++this.e;
      } else {
         --this.e;
      }

      if(var1 <= (double)this.i && this.e >= 20) {
         this.a.u().n();
      } else {
         this.a.u().a((class_pr)this.b, this.d);
      }

      this.a.q().a(this.b, 30.0F, 30.0F);
      if(this.a.bS()) {
         if(!var3 && this.e < -60) {
            this.a.bZ();
         } else if(var3) {
            int var5 = this.a.bX();
            if(var5 >= 20) {
               this.a.bZ();
               this.a.a(this.b, class_zl.b(var5));
               this.c = this.f;
            }
         }
      } else if(--this.c <= 0 && this.e >= -60) {
         this.a.c(EnumUsedHand.MAIN_HAND);
      }

   }
}
