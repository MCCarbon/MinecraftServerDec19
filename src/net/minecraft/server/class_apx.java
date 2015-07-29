package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_aje;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;

public class class_apx extends class_apw {
   private Random k;
   private class_aen l;
   private class_cj m;
   int a;
   int b;
   double c;
   double d;
   double e;
   double f;
   int g;
   int h;
   int i;
   List j;

   public class_apx(boolean var1) {
      super(var1);
      this.m = class_cj.a;
      this.c = 0.618D;
      this.d = 0.381D;
      this.e = 1.0D;
      this.f = 1.0D;
      this.g = 1;
      this.h = 12;
      this.i = 4;
   }

   void a() {
      this.b = (int)((double)this.a * this.c);
      if(this.b >= this.a) {
         this.b = this.a - 1;
      }

      int var1 = (int)(1.382D + Math.pow(this.f * (double)this.a / 13.0D, 2.0D));
      if(var1 < 1) {
         var1 = 1;
      }

      int var2 = this.m.o() + this.b;
      int var3 = this.a - this.i;
      this.j = Lists.newArrayList();
      this.j.add(new class_apx.class_a_in_class_apx(this.m.b(var3), var2));

      for(; var3 >= 0; --var3) {
         float var4 = this.a(var3);
         if(var4 >= 0.0F) {
            for(int var5 = 0; var5 < var1; ++var5) {
               double var6 = this.e * (double)var4 * ((double)this.k.nextFloat() + 0.328D);
               double var8 = (double)(this.k.nextFloat() * 2.0F) * 3.141592653589793D;
               double var10 = var6 * Math.sin(var8) + 0.5D;
               double var12 = var6 * Math.cos(var8) + 0.5D;
               class_cj var14 = this.m.a(var10, (double)(var3 - 1), var12);
               class_cj var15 = var14.b(this.i);
               if(this.a(var14, var15) == -1) {
                  int var16 = this.m.n() - var14.n();
                  int var17 = this.m.p() - var14.p();
                  double var18 = (double)var14.o() - Math.sqrt((double)(var16 * var16 + var17 * var17)) * this.d;
                  int var20 = var18 > (double)var2?var2:(int)var18;
                  class_cj var21 = new class_cj(this.m.n(), var20, this.m.p());
                  if(this.a(var21, var14) == -1) {
                     this.j.add(new class_apx.class_a_in_class_apx(var14, var21.o()));
                  }
               }
            }
         }
      }

   }

   void a(class_cj var1, float var2, IBlockData var3) {
      int var4 = (int)((double)var2 + 0.618D);

      for(int var5 = -var4; var5 <= var4; ++var5) {
         for(int var6 = -var4; var6 <= var4; ++var6) {
            if(Math.pow((double)Math.abs(var5) + 0.5D, 2.0D) + Math.pow((double)Math.abs(var6) + 0.5D, 2.0D) <= (double)(var2 * var2)) {
               class_cj var7 = var1.a(var5, 0, var6);
               class_atk var8 = this.l.p(var7).getBlock().v();
               if(var8 == class_atk.a || var8 == class_atk.j) {
                  this.a(this.l, var7, var3);
               }
            }
         }
      }

   }

   float a(int var1) {
      if((float)var1 < (float)this.a * 0.3F) {
         return -1.0F;
      } else {
         float var2 = (float)this.a / 2.0F;
         float var3 = var2 - (float)var1;
         float var4 = class_nu.c(var2 * var2 - var3 * var3);
         if(var3 == 0.0F) {
            var4 = var2;
         } else if(Math.abs(var3) >= var2) {
            return 0.0F;
         }

         return var4 * 0.5F;
      }
   }

   float b(int var1) {
      return var1 >= 0 && var1 < this.i?(var1 != 0 && var1 != this.i - 1?3.0F:2.0F):-1.0F;
   }

   void a(class_cj var1) {
      for(int var2 = 0; var2 < this.i; ++var2) {
         this.a(var1.b(var2), this.b(var2), class_agk.t.S().set(class_aja.b, Boolean.valueOf(false)));
      }

   }

   void a(class_cj var1, class_cj var2, Block var3) {
      class_cj var4 = var2.a(-var1.n(), -var1.o(), -var1.p());
      int var5 = this.b(var4);
      float var6 = (float)var4.n() / (float)var5;
      float var7 = (float)var4.o() / (float)var5;
      float var8 = (float)var4.p() / (float)var5;

      for(int var9 = 0; var9 <= var5; ++var9) {
         class_cj var10 = var1.a((double)(0.5F + (float)var9 * var6), (double)(0.5F + (float)var9 * var7), (double)(0.5F + (float)var9 * var8));
         class_aje.class_a_in_class_aje var11 = this.b(var1, var10);
         this.a(this.l, var10, var3.S().set(class_aje.a, var11));
      }

   }

   private int b(class_cj var1) {
      int var2 = class_nu.a(var1.n());
      int var3 = class_nu.a(var1.o());
      int var4 = class_nu.a(var1.p());
      return var4 > var2 && var4 > var3?var4:(var3 > var2?var3:var2);
   }

   private class_aje.class_a_in_class_aje b(class_cj var1, class_cj var2) {
      class_aje.class_a_in_class_aje var3 = class_aje.class_a_in_class_aje.b;
      int var4 = Math.abs(var2.n() - var1.n());
      int var5 = Math.abs(var2.p() - var1.p());
      int var6 = Math.max(var4, var5);
      if(var6 > 0) {
         if(var4 == var6) {
            var3 = class_aje.class_a_in_class_aje.a;
         } else if(var5 == var6) {
            var3 = class_aje.class_a_in_class_aje.c;
         }
      }

      return var3;
   }

   void b() {
      Iterator var1 = this.j.iterator();

      while(var1.hasNext()) {
         class_apx.class_a_in_class_apx var2 = (class_apx.class_a_in_class_apx)var1.next();
         this.a(var2);
      }

   }

   boolean c(int var1) {
      return (double)var1 >= (double)this.a * 0.2D;
   }

   void c() {
      class_cj var1 = this.m;
      class_cj var2 = this.m.b(this.b);
      Block var3 = class_agk.r;
      this.a(var1, var2, var3);
      if(this.g == 2) {
         this.a(var1.f(), var2.f(), var3);
         this.a(var1.f().d(), var2.f().d(), var3);
         this.a(var1.d(), var2.d(), var3);
      }

   }

   void d() {
      Iterator var1 = this.j.iterator();

      while(var1.hasNext()) {
         class_apx.class_a_in_class_apx var2 = (class_apx.class_a_in_class_apx)var1.next();
         int var3 = var2.q();
         class_cj var4 = new class_cj(this.m.n(), var3, this.m.p());
         if(!var4.equals(var2) && this.c(var3 - this.m.o())) {
            this.a(var4, var2, class_agk.r);
         }
      }

   }

   int a(class_cj var1, class_cj var2) {
      class_cj var3 = var2.a(-var1.n(), -var1.o(), -var1.p());
      int var4 = this.b(var3);
      float var5 = (float)var3.n() / (float)var4;
      float var6 = (float)var3.o() / (float)var4;
      float var7 = (float)var3.p() / (float)var4;
      if(var4 == 0) {
         return -1;
      } else {
         for(int var8 = 0; var8 <= var4; ++var8) {
            class_cj var9 = var1.a((double)(0.5F + (float)var8 * var5), (double)(0.5F + (float)var8 * var6), (double)(0.5F + (float)var8 * var7));
            if(!this.a(this.l.p(var9).getBlock())) {
               return var8;
            }
         }

         return -1;
      }
   }

   public void e() {
      this.i = 5;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      this.l = var1;
      this.m = var3;
      this.k = new Random(var2.nextLong());
      if(this.a == 0) {
         this.a = 5 + this.k.nextInt(this.h);
      }

      if(!this.f()) {
         return false;
      } else {
         this.a();
         this.b();
         this.c();
         this.d();
         return true;
      }
   }

   private boolean f() {
      Block var1 = this.l.p(this.m.b()).getBlock();
      if(var1 != class_agk.d && var1 != class_agk.c && var1 != class_agk.ak) {
         return false;
      } else {
         int var2 = this.a(this.m, this.m.b(this.a - 1));
         if(var2 == -1) {
            return true;
         } else if(var2 < 6) {
            return false;
         } else {
            this.a = var2;
            return true;
         }
      }
   }

   static class class_a_in_class_apx extends class_cj {
      private final int c;

      public class_a_in_class_apx(class_cj var1, int var2) {
         super(var1.n(), var1.o(), var1.p());
         this.c = var2;
      }

      public int q() {
         return this.c;
      }
   }
}
