package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_aua;
import net.minecraft.server.class_auc;

public class class_aui extends class_auc {
   private class_auc c;
   private class_auc d;

   public class_aui(long var1, class_auc var3, class_auc var4) {
      super(var1);
      this.c = var3;
      this.d = var4;
   }

   public void a(long var1) {
      this.c.a(var1);
      this.d.a(var1);
      super.a(var1);
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.c.a(var1, var2, var3, var4);
      int[] var6 = this.d.a(var1, var2, var3, var4);
      int[] var7 = class_aua.a(var3 * var4);

      for(int var8 = 0; var8 < var3 * var4; ++var8) {
         if(var5[var8] != BiomeBase.p.az && var5[var8] != BiomeBase.N.az) {
            if(var6[var8] == BiomeBase.w.az) {
               if(var5[var8] == BiomeBase.B.az) {
                  var7[var8] = BiomeBase.A.az;
               } else if(var5[var8] != BiomeBase.D.az && var5[var8] != BiomeBase.E.az) {
                  var7[var8] = var6[var8] & 255;
               } else {
                  var7[var8] = BiomeBase.E.az;
               }
            } else {
               var7[var8] = var5[var8];
            }
         } else {
            var7[var8] = var5[var8];
         }
      }

      return var7;
   }
}
