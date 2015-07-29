package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.Block;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_ald;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_auz;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_xa;

public class class_rf extends class_rm {
   private final class_qb a;
   private final float b;
   private float c;
   private boolean d;
   private int e;
   private int f;

   public class_rf(class_qb var1, float var2) {
      this.a = var1;
      this.b = var2;
      this.a(7);
   }

   public void c() {
      this.c = 0.0F;
   }

   public void d() {
      this.d = false;
      this.c = 0.0F;
   }

   public boolean a() {
      return this.a.ai() && this.a.l != null && this.a.l instanceof class_xa && (this.d || this.a.ck());
   }

   public void e() {
      class_xa var1 = (class_xa)this.a.l;
      class_qh var2 = (class_qh)this.a;
      float var3 = class_nu.g(var1.y - this.a.y) * 0.5F;
      if(var3 > 5.0F) {
         var3 = 5.0F;
      }

      if(var3 < -5.0F) {
         var3 = -5.0F;
      }

      this.a.y = class_nu.g(this.a.y + var3);
      if(this.c < this.b) {
         this.c += (this.b - this.c) * 0.01F;
      }

      if(this.c > this.b) {
         this.c = this.b;
      }

      int var4 = class_nu.c(this.a.s);
      int var5 = class_nu.c(this.a.t);
      int var6 = class_nu.c(this.a.u);
      float var7 = this.c;
      if(this.d) {
         if(this.e++ > this.f) {
            this.d = false;
         }

         var7 += var7 * 1.15F * class_nu.a((float)this.e / (float)this.f * 3.1415927F);
      }

      float var8 = 0.91F;
      if(this.a.C) {
         var8 = this.a.o.p(new class_cj(class_nu.d((float)var4), class_nu.d((float)var5) - 1, class_nu.d((float)var6))).getBlock().L * 0.91F;
      }

      float var9 = 0.16277136F / (var8 * var8 * var8);
      float var10 = class_nu.a(var2.y * 3.1415927F / 180.0F);
      float var11 = class_nu.b(var2.y * 3.1415927F / 180.0F);
      float var12 = var2.bJ() * var9;
      float var13 = Math.max(var7, 1.0F);
      var13 = var12 / var13;
      float var14 = var7 * var13;
      float var15 = -(var14 * var10);
      float var16 = var14 * var11;
      if(class_nu.e(var15) > class_nu.e(var16)) {
         if(var15 < 0.0F) {
            var15 -= this.a.J / 2.0F;
         }

         if(var15 > 0.0F) {
            var15 += this.a.J / 2.0F;
         }

         var16 = 0.0F;
      } else {
         var15 = 0.0F;
         if(var16 < 0.0F) {
            var16 -= this.a.J / 2.0F;
         }

         if(var16 > 0.0F) {
            var16 += this.a.J / 2.0F;
         }
      }

      int var17 = class_nu.c(this.a.s + (double)var15);
      int var18 = class_nu.c(this.a.u + (double)var16);
      int var19 = class_nu.d(this.a.J + 1.0F);
      int var20 = class_nu.d(this.a.K + var1.K + 1.0F);
      int var21 = class_nu.d(this.a.J + 1.0F);
      if(var4 != var17 || var6 != var18) {
         Block var22 = this.a.o.p(new class_cj(var4, var5, var6)).getBlock();
         boolean var23 = !this.a(var22) && (var22.v() != class_atk.a || !this.a(this.a.o.p(new class_cj(var4, var5 - 1, var6)).getBlock()));
         if(var23 && 0 == class_auz.a(this.a.o, this.a, var17, var5, var18, var19, var20, var21, false, false, true) && 1 == class_auz.a(this.a.o, this.a, var4, var5 + 1, var6, var19, var20, var21, false, false, true) && 1 == class_auz.a(this.a.o, this.a, var17, var5 + 1, var18, var19, var20, var21, false, false, true)) {
            var2.t().a();
         }
      }

      if(!var1.bH.d && this.c >= this.b * 0.5F && this.a.bd().nextFloat() < 0.006F && !this.d) {
         class_oo var25 = this.a(var1);
         if(var25 != null) {
            class_aas var26 = var1.b((class_oo)var25);
            if(var26 != null && var26.b() == class_aau.cb) {
               var26.a(1, (class_qa)var1);
               if(var26.b == 0) {
                  class_aas var24 = new class_aas(class_aau.aT);
                  var24.d(var26.o());
                  var1.a((class_oo)var25, (class_aas)var24);
               }
            }
         }
      }

      this.a.g(0.0F, var7);
   }

   protected class_oo a(class_xa var1) {
      class_oo[] var2 = class_oo.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_oo var5 = var2[var4];
         class_aas var6 = var1.b((class_oo)var5);
         if(var6 != null && var6.b() == class_aau.cb) {
            return var5;
         }
      }

      return null;
   }

   private boolean a(Block var1) {
      return var1 instanceof class_ald || var1 instanceof class_aio;
   }

   public boolean f() {
      return this.d;
   }

   public void g() {
      this.d = true;
      this.e = 0;
      this.f = this.a.bd().nextInt(841) + 140;
   }

   public boolean h() {
      return !this.f() && this.c > this.b * 0.3F;
   }
}
