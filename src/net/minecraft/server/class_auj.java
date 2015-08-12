package net.minecraft.server;

import net.minecraft.server.BiomeBase;
import net.minecraft.server.BiomeJungle;
import net.minecraft.server.BiomeMesa;
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
            BiomeBase var10 = BiomeBase.getBiome(var9);
            int var11;
            int var12;
            int var13;
            int var14;
            if(var9 == BiomeBase.MUSHROOM_ISLAND.id) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
               if(var11 != BiomeBase.OCEAN.id && var12 != BiomeBase.OCEAN.id && var13 != BiomeBase.OCEAN.id && var14 != BiomeBase.OCEAN.id) {
                  var6[var8 + var7 * var3] = var9;
               } else {
                  var6[var8 + var7 * var3] = BiomeBase.MUSHROOM_SHORE.id;
               }
            } else if(var10 != null && var10.l() == BiomeJungle.class) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
               if(this.c(var11) && this.c(var12) && this.c(var13) && this.c(var14)) {
                  if(!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                     var6[var8 + var7 * var3] = var9;
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.BEACH.id;
                  }
               } else {
                  var6[var8 + var7 * var3] = BiomeBase.JNGLE_EDGE.id;
               }
            } else if(var9 != BiomeBase.EXTREME_HILLS.id && var9 != BiomeBase.EXTREME_HILLS_PLUS.id && var9 != BiomeBase.SMALL_MOUNTAINS.id) {
               if(var10 != null && var10.j()) {
                  this.a(var5, var6, var8, var7, var3, var9, BiomeBase.COLD_BEACH.id);
               } else if(var9 != BiomeBase.MESA.id && var9 != BiomeBase.MESA_PLATEU_F.id) {
                  if(var9 != BiomeBase.OCEAN.id && var9 != BiomeBase.DEEP_OCEAN.id && var9 != BiomeBase.RIVER.id && var9 != BiomeBase.SWAMPLAND.id) {
                     var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                     var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                     var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                     var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                     if(!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = BiomeBase.BEACH.id;
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
                        var6[var8 + var7 * var3] = BiomeBase.DESERT.id;
                     }
                  } else {
                     var6[var8 + var7 * var3] = var9;
                  }
               }
            } else {
               this.a(var5, var6, var8, var7, var3, var9, BiomeBase.STONE_BEACH.id);
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
      return BiomeBase.getBiome(var1) != null && BiomeBase.getBiome(var1).l() == BiomeJungle.class?true:var1 == BiomeBase.JNGLE_EDGE.id || var1 == BiomeBase.JUNGLE.id || var1 == BiomeBase.JUNGLE_HILLS.id || var1 == BiomeBase.FOREST.id || var1 == BiomeBase.TAIGA.id || b(var1);
   }

   private boolean d(int var1) {
      return BiomeBase.getBiome(var1) instanceof BiomeMesa;
   }
}
