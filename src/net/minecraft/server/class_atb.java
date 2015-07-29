package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_ate;
import net.minecraft.server.class_atf;

public class class_atb extends class_atf {
   private class_ate[] a;
   private int b;

   public class_atb(Random var1, int var2) {
      this.b = var2;
      this.a = new class_ate[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.a[var3] = new class_ate(var1);
      }

   }

   public double a(double var1, double var3) {
      double var5 = 0.0D;
      double var7 = 1.0D;

      for(int var9 = 0; var9 < this.b; ++var9) {
         var5 += this.a[var9].a(var1 * var7, var3 * var7) / var7;
         var7 /= 2.0D;
      }

      return var5;
   }

   public double[] a(double[] var1, double var2, double var4, int var6, int var7, double var8, double var10, double var12) {
      return this.a(var1, var2, var4, var6, var7, var8, var10, var12, 0.5D);
   }

   public double[] a(double[] var1, double var2, double var4, int var6, int var7, double var8, double var10, double var12, double var14) {
      if(var1 != null && var1.length >= var6 * var7) {
         for(int var16 = 0; var16 < var1.length; ++var16) {
            var1[var16] = 0.0D;
         }
      } else {
         var1 = new double[var6 * var7];
      }

      double var21 = 1.0D;
      double var18 = 1.0D;

      for(int var20 = 0; var20 < this.b; ++var20) {
         this.a[var20].a(var1, var2, var4, var6, var7, var8 * var18 * var21, var10 * var18 * var21, 0.55D / var21);
         var18 *= var12;
         var21 *= var14;
      }

      return var1;
   }
}
