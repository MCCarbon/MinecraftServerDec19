package net.minecraft.server;

import net.minecraft.server.class_aez;
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
            if(!this.a(var5, var6, var8, var7, var3, var9, class_aez.s.az, class_aez.J.az) && !this.b(var5, var6, var8, var7, var3, var9, class_aez.ab.az, class_aez.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, class_aez.ac.az, class_aez.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, class_aez.V.az, class_aez.u.az)) {
               int var10;
               int var11;
               int var12;
               int var13;
               if(var9 == class_aez.r.az) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != class_aez.B.az && var11 != class_aez.B.az && var12 != class_aez.B.az && var13 != class_aez.B.az) {
                     var6[var8 + var7 * var3] = var9;
                  } else {
                     var6[var8 + var7 * var3] = class_aez.X.az;
                  }
               } else if(var9 == class_aez.v.az) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != class_aez.r.az && var11 != class_aez.r.az && var12 != class_aez.r.az && var13 != class_aez.r.az && var10 != class_aez.T.az && var11 != class_aez.T.az && var12 != class_aez.T.az && var13 != class_aez.T.az && var10 != class_aez.B.az && var11 != class_aez.B.az && var12 != class_aez.B.az && var13 != class_aez.B.az) {
                     if(var10 != class_aez.K.az && var13 != class_aez.K.az && var11 != class_aez.K.az && var12 != class_aez.K.az) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = class_aez.M.az;
                     }
                  } else {
                     var6[var8 + var7 * var3] = class_aez.q.az;
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
         class_aez var3 = class_aez.e(var1);
         class_aez var4 = class_aez.e(var2);
         if(var3 != null && var4 != null) {
            class_aez.class_b_in_class_aez var5 = var3.m();
            class_aez.class_b_in_class_aez var6 = var4.m();
            return var5 == var6 || var5 == class_aez.class_b_in_class_aez.c || var6 == class_aez.class_b_in_class_aez.c;
         } else {
            return false;
         }
      }
   }
}
