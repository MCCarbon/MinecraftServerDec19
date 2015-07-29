package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_atf;

public class class_asz extends class_atf {
   private int[] d;
   public double a;
   public double b;
   public double c;
   private static final double[] e = new double[]{1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, -1.0D, 0.0D};
   private static final double[] f = new double[]{1.0D, 1.0D, -1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D};
   private static final double[] g = new double[]{0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, -1.0D, -1.0D, 1.0D, 1.0D, -1.0D, -1.0D, 0.0D, 1.0D, 0.0D, -1.0D};
   private static final double[] h = new double[]{1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, -1.0D, 0.0D};
   private static final double[] i = new double[]{0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, -1.0D, -1.0D, 1.0D, 1.0D, -1.0D, -1.0D, 0.0D, 1.0D, 0.0D, -1.0D};

   public class_asz() {
      this(new Random());
   }

   public class_asz(Random var1) {
      this.d = new int[512];
      this.a = var1.nextDouble() * 256.0D;
      this.b = var1.nextDouble() * 256.0D;
      this.c = var1.nextDouble() * 256.0D;

      int var2;
      for(var2 = 0; var2 < 256; this.d[var2] = var2++) {
         ;
      }

      for(var2 = 0; var2 < 256; ++var2) {
         int var3 = var1.nextInt(256 - var2) + var2;
         int var4 = this.d[var2];
         this.d[var2] = this.d[var3];
         this.d[var3] = var4;
         this.d[var2 + 256] = this.d[var2];
      }

   }

   public final double b(double var1, double var3, double var5) {
      return var3 + var1 * (var5 - var3);
   }

   public final double a(int var1, double var2, double var4) {
      int var6 = var1 & 15;
      return h[var6] * var2 + i[var6] * var4;
   }

   public final double a(int var1, double var2, double var4, double var6) {
      int var8 = var1 & 15;
      return e[var8] * var2 + f[var8] * var4 + g[var8] * var6;
   }

   public void a(double[] var1, double var2, double var4, double var6, int var8, int var9, int var10, double var11, double var13, double var15, double var17) {
      int var10001;
      int var19;
      int var22;
      double var31;
      double var35;
      int var37;
      double var38;
      int var40;
      int var41;
      double var42;
      int var75;
      if(var9 == 1) {
         boolean var64 = false;
         boolean var65 = false;
         boolean var21 = false;
         boolean var68 = false;
         double var70 = 0.0D;
         double var73 = 0.0D;
         var75 = 0;
         double var77 = 1.0D / var17;

         for(int var30 = 0; var30 < var8; ++var30) {
            var31 = var2 + (double)var30 * var11 + this.a;
            int var78 = (int)var31;
            if(var31 < (double)var78) {
               --var78;
            }

            int var34 = var78 & 255;
            var31 -= (double)var78;
            var35 = var31 * var31 * var31 * (var31 * (var31 * 6.0D - 15.0D) + 10.0D);

            for(var37 = 0; var37 < var10; ++var37) {
               var38 = var6 + (double)var37 * var15 + this.c;
               var40 = (int)var38;
               if(var38 < (double)var40) {
                  --var40;
               }

               var41 = var40 & 255;
               var38 -= (double)var40;
               var42 = var38 * var38 * var38 * (var38 * (var38 * 6.0D - 15.0D) + 10.0D);
               var19 = this.d[var34] + 0;
               int var66 = this.d[var19] + var41;
               int var67 = this.d[var34 + 1] + 0;
               var22 = this.d[var67] + var41;
               var70 = this.b(var35, this.a(this.d[var66], var31, var38), this.a(this.d[var22], var31 - 1.0D, 0.0D, var38));
               var73 = this.b(var35, this.a(this.d[var66 + 1], var31, 0.0D, var38 - 1.0D), this.a(this.d[var22 + 1], var31 - 1.0D, 0.0D, var38 - 1.0D));
               double var79 = this.b(var42, var70, var73);
               var10001 = var75++;
               var1[var10001] += var79 * var77;
            }
         }

      } else {
         var19 = 0;
         double var20 = 1.0D / var17;
         var22 = -1;
         boolean var23 = false;
         boolean var24 = false;
         boolean var25 = false;
         boolean var26 = false;
         boolean var27 = false;
         boolean var28 = false;
         double var29 = 0.0D;
         var31 = 0.0D;
         double var33 = 0.0D;
         var35 = 0.0D;

         for(var37 = 0; var37 < var8; ++var37) {
            var38 = var2 + (double)var37 * var11 + this.a;
            var40 = (int)var38;
            if(var38 < (double)var40) {
               --var40;
            }

            var41 = var40 & 255;
            var38 -= (double)var40;
            var42 = var38 * var38 * var38 * (var38 * (var38 * 6.0D - 15.0D) + 10.0D);

            for(int var44 = 0; var44 < var10; ++var44) {
               double var45 = var6 + (double)var44 * var15 + this.c;
               int var47 = (int)var45;
               if(var45 < (double)var47) {
                  --var47;
               }

               int var48 = var47 & 255;
               var45 -= (double)var47;
               double var49 = var45 * var45 * var45 * (var45 * (var45 * 6.0D - 15.0D) + 10.0D);

               for(int var51 = 0; var51 < var9; ++var51) {
                  double var52 = var4 + (double)var51 * var13 + this.b;
                  int var54 = (int)var52;
                  if(var52 < (double)var54) {
                     --var54;
                  }

                  int var55 = var54 & 255;
                  var52 -= (double)var54;
                  double var56 = var52 * var52 * var52 * (var52 * (var52 * 6.0D - 15.0D) + 10.0D);
                  if(var51 == 0 || var55 != var22) {
                     var22 = var55;
                     int var69 = this.d[var41] + var55;
                     int var71 = this.d[var69] + var48;
                     int var72 = this.d[var69 + 1] + var48;
                     int var74 = this.d[var41 + 1] + var55;
                     var75 = this.d[var74] + var48;
                     int var76 = this.d[var74 + 1] + var48;
                     var29 = this.b(var42, this.a(this.d[var71], var38, var52, var45), this.a(this.d[var75], var38 - 1.0D, var52, var45));
                     var31 = this.b(var42, this.a(this.d[var72], var38, var52 - 1.0D, var45), this.a(this.d[var76], var38 - 1.0D, var52 - 1.0D, var45));
                     var33 = this.b(var42, this.a(this.d[var71 + 1], var38, var52, var45 - 1.0D), this.a(this.d[var75 + 1], var38 - 1.0D, var52, var45 - 1.0D));
                     var35 = this.b(var42, this.a(this.d[var72 + 1], var38, var52 - 1.0D, var45 - 1.0D), this.a(this.d[var76 + 1], var38 - 1.0D, var52 - 1.0D, var45 - 1.0D));
                  }

                  double var58 = this.b(var56, var29, var31);
                  double var60 = this.b(var56, var33, var35);
                  double var62 = this.b(var49, var58, var60);
                  var10001 = var19++;
                  var1[var10001] += var62 * var20;
               }
            }
         }

      }
   }
}
