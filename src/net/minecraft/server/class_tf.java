package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_aut;
import net.minecraft.server.class_auw;
import net.minecraft.server.class_auz;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_tg;
import net.minecraft.server.class_tx;
import net.minecraft.server.class_wr;

public class class_tf extends class_tg {
   protected class_auz a;
   private boolean f;

   public class_tf(class_qb var1, class_aen var2) {
      super(var1, var2);
   }

   protected class_auw a() {
      this.a = new class_auz();
      this.a.a(true);
      return new class_auw(this.a);
   }

   protected boolean b() {
      return this.b.C || this.h() && this.o() || this.b.aw() && this.b instanceof class_wr && this.b.m instanceof class_tx;
   }

   protected class_awh c() {
      return new class_awh(this.b.s, (double)this.p(), this.b.u);
   }

   private int p() {
      if(this.b.V() && this.h()) {
         int var1 = (int)this.b.aT().b;
         Block var2 = this.c.p(new class_cj(class_nu.c(this.b.s), var1, class_nu.c(this.b.u))).getBlock();
         int var3 = 0;

         do {
            if(var2 != class_agk.i && var2 != class_agk.j) {
               return var1;
            }

            ++var1;
            var2 = this.c.p(new class_cj(class_nu.c(this.b.s), var1, class_nu.c(this.b.u))).getBlock();
            ++var3;
         } while(var3 <= 16);

         return (int)this.b.aT().b;
      } else {
         return (int)(this.b.aT().b + 0.5D);
      }
   }

   protected void d() {
      super.d();
      if(this.f) {
         if(this.c.i(new class_cj(class_nu.c(this.b.s), (int)(this.b.aT().b + 0.5D), class_nu.c(this.b.u)))) {
            return;
         }

         for(int var1 = 0; var1 < this.d.d(); ++var1) {
            class_aut var2 = this.d.a(var1);
            if(this.c.i(new class_cj(var2.a, var2.b, var2.c))) {
               this.d.b(var1 - 1);
               return;
            }
         }
      }

   }

   protected boolean a(class_awh var1, class_awh var2, int var3, int var4, int var5) {
      int var6 = class_nu.c(var1.a);
      int var7 = class_nu.c(var1.c);
      double var8 = var2.a - var1.a;
      double var10 = var2.c - var1.c;
      double var12 = var8 * var8 + var10 * var10;
      if(var12 < 1.0E-8D) {
         return false;
      } else {
         double var14 = 1.0D / Math.sqrt(var12);
         var8 *= var14;
         var10 *= var14;
         var3 += 2;
         var5 += 2;
         if(!this.a(var6, (int)var1.b, var7, var3, var4, var5, var1, var8, var10)) {
            return false;
         } else {
            var3 -= 2;
            var5 -= 2;
            double var16 = 1.0D / Math.abs(var8);
            double var18 = 1.0D / Math.abs(var10);
            double var20 = (double)(var6 * 1) - var1.a;
            double var22 = (double)(var7 * 1) - var1.c;
            if(var8 >= 0.0D) {
               ++var20;
            }

            if(var10 >= 0.0D) {
               ++var22;
            }

            var20 /= var8;
            var22 /= var10;
            int var24 = var8 < 0.0D?-1:1;
            int var25 = var10 < 0.0D?-1:1;
            int var26 = class_nu.c(var2.a);
            int var27 = class_nu.c(var2.c);
            int var28 = var26 - var6;
            int var29 = var27 - var7;

            do {
               if(var28 * var24 <= 0 && var29 * var25 <= 0) {
                  return true;
               }

               if(var20 < var22) {
                  var20 += var16;
                  var6 += var24;
                  var28 = var26 - var6;
               } else {
                  var22 += var18;
                  var7 += var25;
                  var29 = var27 - var7;
               }
            } while(this.a(var6, (int)var1.b, var7, var3, var4, var5, var1, var8, var10));

            return false;
         }
      }
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, class_awh var7, double var8, double var10) {
      int var12 = var1 - var4 / 2;
      int var13 = var3 - var6 / 2;
      if(!this.b(var12, var2, var13, var4, var5, var6, var7, var8, var10)) {
         return false;
      } else {
         for(int var14 = var12; var14 < var12 + var4; ++var14) {
            for(int var15 = var13; var15 < var13 + var6; ++var15) {
               double var16 = (double)var14 + 0.5D - var7.a;
               double var18 = (double)var15 + 0.5D - var7.c;
               if(var16 * var8 + var18 * var10 >= 0.0D) {
                  Block var20 = this.c.p(new class_cj(var14, var2 - 1, var15)).getBlock();
                  class_atk var21 = var20.v();
                  if(var21 == class_atk.a) {
                     return false;
                  }

                  if(var21 == class_atk.h && !this.b.V()) {
                     return false;
                  }

                  if(var21 == class_atk.i) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private boolean b(int var1, int var2, int var3, int var4, int var5, int var6, class_awh var7, double var8, double var10) {
      Iterator var12 = class_cj.a(new class_cj(var1, var2, var3), new class_cj(var1 + var4 - 1, var2 + var5 - 1, var3 + var6 - 1)).iterator();

      while(var12.hasNext()) {
         class_cj var13 = (class_cj)var12.next();
         double var14 = (double)var13.n() + 0.5D - var7.a;
         double var16 = (double)var13.p() + 0.5D - var7.c;
         if(var14 * var8 + var16 * var10 >= 0.0D) {
            Block var18 = this.c.p(var13).getBlock();
            if(!var18.b(this.c, var13)) {
               return false;
            }
         }
      }

      return true;
   }

   public void a(boolean var1) {
      this.a.c(var1);
   }

   public boolean e() {
      return this.a.e();
   }

   public void b(boolean var1) {
      this.a.b(var1);
   }

   public void c(boolean var1) {
      this.a.a(var1);
   }

   public boolean g() {
      return this.a.b();
   }

   public void d(boolean var1) {
      this.a.d(var1);
   }

   public boolean h() {
      return this.a.d();
   }

   public void e(boolean var1) {
      this.f = var1;
   }
}
