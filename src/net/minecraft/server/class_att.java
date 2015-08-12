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
            if(!this.a(var5, var6, var8, var7, var3, var9, BiomeBase.EXTREME_HILLS.id, BiomeBase.SMALL_MOUNTAINS.id) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.MESA_PLATEU_F.id, BiomeBase.MESA.id) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.MESA_PLATEU.id, BiomeBase.MESA.id) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.MEGA_TAIGA.id, BiomeBase.TAIGA.id)) {
               int var10;
               int var11;
               int var12;
               int var13;
               if(var9 == BiomeBase.DESERT.id) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != BiomeBase.ICE_PLAINS.id && var11 != BiomeBase.ICE_PLAINS.id && var12 != BiomeBase.ICE_PLAINS.id && var13 != BiomeBase.ICE_PLAINS.id) {
                     var6[var8 + var7 * var3] = var9;
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.EXTREME_HILLS_PLUS.id;
                  }
               } else if(var9 == BiomeBase.SWAMPLAND.id) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != BiomeBase.DESERT.id && var11 != BiomeBase.DESERT.id && var12 != BiomeBase.DESERT.id && var13 != BiomeBase.DESERT.id && var10 != BiomeBase.COLD_TAIGA.id && var11 != BiomeBase.COLD_TAIGA.id && var12 != BiomeBase.COLD_TAIGA.id && var13 != BiomeBase.COLD_TAIGA.id && var10 != BiomeBase.ICE_PLAINS.id && var11 != BiomeBase.ICE_PLAINS.id && var12 != BiomeBase.ICE_PLAINS.id && var13 != BiomeBase.ICE_PLAINS.id) {
                     if(var10 != BiomeBase.JUNGLE.id && var13 != BiomeBase.JUNGLE.id && var11 != BiomeBase.JUNGLE.id && var12 != BiomeBase.JUNGLE.id) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = BiomeBase.JNGLE_EDGE.id;
                     }
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.PLAINS.id;
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
         BiomeBase var3 = BiomeBase.getBiome(var1);
         BiomeBase var4 = BiomeBase.getBiome(var2);
         if(var3 != null && var4 != null) {
            BiomeBase.EnumTemperature var5 = var3.m();
            BiomeBase.EnumTemperature var6 = var4.m();
            return var5 == var6 || var5 == BiomeBase.EnumTemperature.MEDIUM || var6 == BiomeBase.EnumTemperature.MEDIUM;
         } else {
            return false;
         }
      }
   }
}
