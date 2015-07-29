package net.minecraft.server;

import net.minecraft.server.class_df;
import net.minecraft.server.class_nu;

public class class_awh {
   public final double a;
   public final double b;
   public final double c;

   public class_awh(double var1, double var3, double var5) {
      if(var1 == -0.0D) {
         var1 = 0.0D;
      }

      if(var3 == -0.0D) {
         var3 = 0.0D;
      }

      if(var5 == -0.0D) {
         var5 = 0.0D;
      }

      this.a = var1;
      this.b = var3;
      this.c = var5;
   }

   public class_awh(class_df var1) {
      this((double)var1.n(), (double)var1.o(), (double)var1.p());
   }

   public class_awh a() {
      double var1 = (double)class_nu.a(this.a * this.a + this.b * this.b + this.c * this.c);
      return var1 < 1.0E-4D?new class_awh(0.0D, 0.0D, 0.0D):new class_awh(this.a / var1, this.b / var1, this.c / var1);
   }

   public double b(class_awh var1) {
      return this.a * var1.a + this.b * var1.b + this.c * var1.c;
   }

   public class_awh d(class_awh var1) {
      return this.a(var1.a, var1.b, var1.c);
   }

   public class_awh a(double var1, double var3, double var5) {
      return this.b(-var1, -var3, -var5);
   }

   public class_awh e(class_awh var1) {
      return this.b(var1.a, var1.b, var1.c);
   }

   public class_awh b(double var1, double var3, double var5) {
      return new class_awh(this.a + var1, this.b + var3, this.c + var5);
   }

   public double g(class_awh var1) {
      double var2 = var1.a - this.a;
      double var4 = var1.b - this.b;
      double var6 = var1.c - this.c;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public class_awh a(double var1) {
      return new class_awh(this.a * var1, this.b * var1, this.c * var1);
   }

   public double b() {
      return (double)class_nu.a(this.a * this.a + this.b * this.b + this.c * this.c);
   }

   public class_awh a(class_awh var1, double var2) {
      double var4 = var1.a - this.a;
      double var6 = var1.b - this.b;
      double var8 = var1.c - this.c;
      if(var4 * var4 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.a) / var4;
         return var10 >= 0.0D && var10 <= 1.0D?new class_awh(this.a + var4 * var10, this.b + var6 * var10, this.c + var8 * var10):null;
      }
   }

   public class_awh b(class_awh var1, double var2) {
      double var4 = var1.a - this.a;
      double var6 = var1.b - this.b;
      double var8 = var1.c - this.c;
      if(var6 * var6 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.b) / var6;
         return var10 >= 0.0D && var10 <= 1.0D?new class_awh(this.a + var4 * var10, this.b + var6 * var10, this.c + var8 * var10):null;
      }
   }

   public class_awh c(class_awh var1, double var2) {
      double var4 = var1.a - this.a;
      double var6 = var1.b - this.b;
      double var8 = var1.c - this.c;
      if(var8 * var8 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.c) / var8;
         return var10 >= 0.0D && var10 <= 1.0D?new class_awh(this.a + var4 * var10, this.b + var6 * var10, this.c + var8 * var10):null;
      }
   }

   public String toString() {
      return "(" + this.a + ", " + this.b + ", " + this.c + ")";
   }

   public class_awh a(float var1) {
      float var2 = class_nu.b(var1);
      float var3 = class_nu.a(var1);
      double var4 = this.a;
      double var6 = this.b * (double)var2 + this.c * (double)var3;
      double var8 = this.c * (double)var2 - this.b * (double)var3;
      return new class_awh(var4, var6, var8);
   }

   public class_awh b(float var1) {
      float var2 = class_nu.b(var1);
      float var3 = class_nu.a(var1);
      double var4 = this.a * (double)var2 + this.c * (double)var3;
      double var6 = this.b;
      double var8 = this.c * (double)var2 - this.a * (double)var3;
      return new class_awh(var4, var6, var8);
   }
}
