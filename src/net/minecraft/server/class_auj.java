package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_afk;
import net.minecraft.server.class_afl;
import net.minecraft.server.class_aua;
import net.minecraft.server.class_auc;

public class class_auj extends class_auc {
   public class_auj(long var1, class_auc var3) {
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
            BiomeBase var10 = BiomeBase.e(var9);
            int var11;
            int var12;
            int var13;
            int var14;
            if(var9 == BiomeBase.D.az) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
               if(var11 != BiomeBase.p.az && var12 != BiomeBase.p.az && var13 != BiomeBase.p.az && var14 != BiomeBase.p.az) {
                  var6[var8 + var7 * var3] = var9;
               } else {
                  var6[var8 + var7 * var3] = BiomeBase.E.az;
               }
            } else if(var10 != null && var10.l() == class_afk.class) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
               if(this.c(var11) && this.c(var12) && this.c(var13) && this.c(var14)) {
                  if(!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                     var6[var8 + var7 * var3] = var9;
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.F.az;
                  }
               } else {
                  var6[var8 + var7 * var3] = BiomeBase.M.az;
               }
            } else if(var9 != BiomeBase.s.az && var9 != BiomeBase.X.az && var9 != BiomeBase.J.az) {
               if(var10 != null && var10.j()) {
                  this.a(var5, var6, var8, var7, var3, var9, BiomeBase.P.az);
               } else if(var9 != BiomeBase.aa.az && var9 != BiomeBase.ab.az) {
                  if(var9 != BiomeBase.p.az && var9 != BiomeBase.N.az && var9 != BiomeBase.w.az && var9 != BiomeBase.v.az) {
                     var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                     var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                     var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                     var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                     if(!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = BiomeBase.F.az;
                     }
                  } else {
                     var6[var8 + var7 * var3] = var9;
                  }
               } else {
                  var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                     if(this.d(var11) && this.d(var12) && this.d(var13) && this.d(var14)) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = BiomeBase.r.az;
                     }
                  } else {
                     var6[var8 + var7 * var3] = var9;
                  }
               }
            } else {
               this.a(var5, var6, var8, var7, var3, var9, BiomeBase.O.az);
            }
         }
      }

      return var6;
   }

   private void a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      if(b(var6)) {
         var2[var3 + var4 * var5] = var6;
      } else {
         int var8 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
         int var9 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
         int var10 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
         int var11 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
         if(!b(var8) && !b(var9) && !b(var10) && !b(var11)) {
            var2[var3 + var4 * var5] = var6;
         } else {
            var2[var3 + var4 * var5] = var7;
         }

      }
   }

   private boolean c(int var1) {
      return BiomeBase.e(var1) != null && BiomeBase.e(var1).l() == class_afk.class?true:var1 == BiomeBase.M.az || var1 == BiomeBase.K.az || var1 == BiomeBase.L.az || var1 == BiomeBase.t.az || var1 == BiomeBase.u.az || b(var1);
   }

   private boolean d(int var1) {
      return BiomeBase.e(var1) instanceof class_afl;
   }
}
