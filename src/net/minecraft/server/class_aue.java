package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.class_aua;
import net.minecraft.server.class_auc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_aue extends class_auc {
   private static final Logger c = LogManager.getLogger();
   private class_auc d;

   public class_aue(long var1, class_auc var3, class_auc var4) {
      super(var1);
      this.a = var3;
      this.d = var4;
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var6 = this.d.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var7 = class_aua.a(var3 * var4);

      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var3; ++var9) {
            this.a((long)(var9 + var1), (long)(var8 + var2));
            int var10 = var5[var9 + 1 + (var8 + 1) * (var3 + 2)];
            int var11 = var6[var9 + 1 + (var8 + 1) * (var3 + 2)];
            boolean var12 = (var11 - 2) % 29 == 0;
            if(var10 > 255) {
               c.debug("old! " + var10);
            }

            if(var10 != 0 && var11 >= 2 && (var11 - 2) % 29 == 1 && var10 < 128) {
               if(BiomeBase.e(var10 + 128) != null) {
                  var7[var9 + var8 * var3] = var10 + 128;
               } else {
                  var7[var9 + var8 * var3] = var10;
               }
            } else if(this.a(3) != 0 && !var12) {
               var7[var9 + var8 * var3] = var10;
            } else {
               int var13 = var10;
               int var14;
               if(var10 == BiomeBase.DESERT.az) {
                  var13 = BiomeBase.DESERT_HILLS.az;
               } else if(var10 == BiomeBase.FOREST.az) {
                  var13 = BiomeBase.FOREST_HILLS.az;
               } else if(var10 == BiomeBase.BIRCH_FOREST.az) {
                  var13 = BiomeBase.BIRCH_FOREST_HILLS.az;
               } else if(var10 == BiomeBase.ROOFED_FOREST.az) {
                  var13 = BiomeBase.PLAINS.az;
               } else if(var10 == BiomeBase.TAIGA.az) {
                  var13 = BiomeBase.TAIGA_HILLS.az;
               } else if(var10 == BiomeBase.MEGA_TAIGA.az) {
                  var13 = BiomeBase.MEGA_TAIGA_HILLS.az;
               } else if(var10 == BiomeBase.COLD_TAIGA.az) {
                  var13 = BiomeBase.COLD_TAIGA_HILLS.az;
               } else if(var10 == BiomeBase.PLAINS.az) {
                  if(this.a(3) == 0) {
                     var13 = BiomeBase.FOREST_HILLS.az;
                  } else {
                     var13 = BiomeBase.FOREST.az;
                  }
               } else if(var10 == BiomeBase.ICE_PLAINS.az) {
                  var13 = BiomeBase.ICE_MOUNTAINS.az;
               } else if(var10 == BiomeBase.JUNGLE.az) {
                  var13 = BiomeBase.JUNGLE_HILLS.az;
               } else if(var10 == BiomeBase.OCEAN.az) {
                  var13 = BiomeBase.DEEP_OCEAN.az;
               } else if(var10 == BiomeBase.EXTREME_HILLS.az) {
                  var13 = BiomeBase.EXTREME_HILLS_PLUS.az;
               } else if(var10 == BiomeBase.SAVANNA.az) {
                  var13 = BiomeBase.SAVANNA_PLATEU.az;
               } else if(a(var10, BiomeBase.MESA_PLATEU_F.az)) {
                  var13 = BiomeBase.MESA.az;
               } else if(var10 == BiomeBase.DEEP_OCEAN.az && this.a(3) == 0) {
                  var14 = this.a(2);
                  if(var14 == 0) {
                     var13 = BiomeBase.PLAINS.az;
                  } else {
                     var13 = BiomeBase.FOREST.az;
                  }
               }

               if(var12 && var13 != var10) {
                  if(BiomeBase.e(var13 + 128) != null) {
                     var13 += 128;
                  } else {
                     var13 = var10;
                  }
               }

               if(var13 == var10) {
                  var7[var9 + var8 * var3] = var10;
               } else {
                  var14 = var5[var9 + 1 + (var8 + 1 - 1) * (var3 + 2)];
                  int var15 = var5[var9 + 1 + 1 + (var8 + 1) * (var3 + 2)];
                  int var16 = var5[var9 + 1 - 1 + (var8 + 1) * (var3 + 2)];
                  int var17 = var5[var9 + 1 + (var8 + 1 + 1) * (var3 + 2)];
                  int var18 = 0;
                  if(a(var14, var10)) {
                     ++var18;
                  }

                  if(a(var15, var10)) {
                     ++var18;
                  }

                  if(a(var16, var10)) {
                     ++var18;
                  }

                  if(a(var17, var10)) {
                     ++var18;
                  }

                  if(var18 >= 3) {
                     var7[var9 + var8 * var3] = var13;
                  } else {
                     var7[var9 + var8 * var3] = var10;
                  }
               }
            }
         }
      }

      return var7;
   }
}
