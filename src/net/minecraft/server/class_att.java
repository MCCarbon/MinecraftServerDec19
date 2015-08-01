package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_aua;
import net.minecraft.server.class_auc;

public class class_att extends class_auc {
   public class_att(long var1, class_auc var3) {
      super(var1);
      this.a = var3;
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var6 = class_aua.a(var3 * var4);

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var3; ++var8) {
            this.a((long)(var8 + var1), (long)(var7 + var2));
            int var9 = var5[var8 + 1 + (var7 + 1) * (var3 + 2)];
            if(!this.a(var5, var6, var8, var7, var3, var9, BiomeBase.s.az, BiomeBase.J.az) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.ab.az, BiomeBase.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.ac.az, BiomeBase.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.V.az, BiomeBase.u.az)) {
               int var10;
               int var11;
               int var12;
               int var13;
               if(var9 == BiomeBase.r.az) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != BiomeBase.B.az && var11 != BiomeBase.B.az && var12 != BiomeBase.B.az && var13 != BiomeBase.B.az) {
                     var6[var8 + var7 * var3] = var9;
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.X.az;
                  }
               } else if(var9 == BiomeBase.v.az) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != BiomeBase.r.az && var11 != BiomeBase.r.az && var12 != BiomeBase.r.az && var13 != BiomeBase.r.az && var10 != BiomeBase.T.az && var11 != BiomeBase.T.az && var12 != BiomeBase.T.az && var13 != BiomeBase.T.az && var10 != BiomeBase.B.az && var11 != BiomeBase.B.az && var12 != BiomeBase.B.az && var13 != BiomeBase.B.az) {
                     if(var10 != BiomeBase.K.az && var13 != BiomeBase.K.az && var11 != BiomeBase.K.az && var12 != BiomeBase.K.az) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = BiomeBase.M.az;
                     }
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.q.az;
                  }
               } else {
                  var6[var8 + var7 * var3] = var9;
               }
            }
         }
      }

      return var6;
   }

   private boolean a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(!a(var6, var7)) {
         return false;
      } else {
         int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
         int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
         int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
         int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
         if(this.b(var9, var7) && this.b(var10, var7) && this.b(var11, var7) && this.b(var12, var7)) {
            var2[var3 + var4 * var5] = var6;
         } else {
            var2[var3 + var4 * var5] = var8;
         }

         return true;
      }
   }

   private boolean b(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var6 != var7) {
         return false;
      } else {
         int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
         int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
         int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
         int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
         if(a(var9, var7) && a(var10, var7) && a(var11, var7) && a(var12, var7)) {
            var2[var3 + var4 * var5] = var6;
         } else {
            var2[var3 + var4 * var5] = var8;
         }

         return true;
      }
   }

   private boolean b(int var1, int var2) {
      if(a(var1, var2)) {
         return true;
      } else {
         BiomeBase var3 = BiomeBase.e(var1);
         BiomeBase var4 = BiomeBase.e(var2);
         if(var3 != null && var4 != null) {
            BiomeBase.class_b_in_class_aez var5 = var3.m();
            BiomeBase.class_b_in_class_aez var6 = var4.m();
            return var5 == var6 || var5 == BiomeBase.class_b_in_class_aez.c || var6 == BiomeBase.class_b_in_class_aez.c;
         } else {
            return false;
         }
      }
   }
}
