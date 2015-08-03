package net.minecraft.server;

import java.util.Arrays;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockCloth;
import net.minecraft.server.BlockDirt;
import net.minecraft.server.BlockSand;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_atb;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumColor;

public class class_afl extends BiomeBase {
   private IBlockData[] aD;
   private long aE;
   private class_atb aF;
   private class_atb aG;
   private class_atb aH;
   private boolean aI;
   private boolean aJ;

   public class_afl(int var1, boolean var2, boolean var3) {
      super(var1);
      this.aI = var2;
      this.aJ = var3;
      this.b();
      this.a(2.0F, 0.0F);
      this.au.clear();
      this.ak = BlockStainedGlassPane.SAND.getBlockData().set(BlockSand.VARIANT, BlockSand.EnumSandVariant.RED_SAND);
      this.al = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData();
      this.as.A = -999;
      this.as.D = 20;
      this.as.F = 3;
      this.as.G = 5;
      this.as.B = 0;
      this.au.clear();
      if(var3) {
         this.as.A = 5;
      }

   }

   public class_apw a(Random var1) {
      return this.aA;
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      super.a(var1, var2, var3);
   }

   public void a(World var1, Random var2, class_aph var3, int var4, int var5, double var6) {
      if(this.aD == null || this.aE != var1.K()) {
         this.a(var1.K());
      }

      if(this.aF == null || this.aG == null || this.aE != var1.K()) {
         Random var8 = new Random(this.aE);
         this.aF = new class_atb(var8, 4);
         this.aG = new class_atb(var8, 1);
      }

      this.aE = var1.K();
      double var22 = 0.0D;
      int var10;
      int var11;
      if(this.aI) {
         var10 = (var4 & -16) + (var5 & 15);
         var11 = (var5 & -16) + (var4 & 15);
         double var12 = Math.min(Math.abs(var6), this.aF.a((double)var10 * 0.25D, (double)var11 * 0.25D));
         if(var12 > 0.0D) {
            double var14 = 0.001953125D;
            double var16 = Math.abs(this.aG.a((double)var10 * var14, (double)var11 * var14));
            var22 = var12 * var12 * 2.5D;
            double var18 = Math.ceil(var16 * 50.0D) + 14.0D;
            if(var22 > var18) {
               var22 = var18;
            }

            var22 += 64.0D;
         }
      }

      var10 = var4 & 15;
      var11 = var5 & 15;
      int var23 = var1.G();
      IBlockData var13 = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData();
      IBlockData var24 = this.al;
      int var15 = (int)(var6 / 3.0D + 3.0D + var2.nextDouble() * 0.25D);
      boolean var25 = Math.cos(var6 / 3.0D * 3.141592653589793D) > 0.0D;
      int var17 = -1;
      boolean var26 = false;

      for(int var19 = 255; var19 >= 0; --var19) {
         if(var3.a(var11, var19, var10).getBlock().getMaterial() == Material.AIR && var19 < (int)var22) {
            var3.a(var11, var19, var10, BlockStainedGlassPane.STONE.getBlockData());
         }

         if(var19 <= var2.nextInt(5)) {
            var3.a(var11, var19, var10, BlockStainedGlassPane.BEDROCK.getBlockData());
         } else {
            IBlockData var20 = var3.a(var11, var19, var10);
            if(var20.getBlock().getMaterial() == Material.AIR) {
               var17 = -1;
            } else if(var20.getBlock() == BlockStainedGlassPane.STONE) {
               IBlockData var21;
               if(var17 == -1) {
                  var26 = false;
                  if(var15 <= 0) {
                     var13 = null;
                     var24 = BlockStainedGlassPane.STONE.getBlockData();
                  } else if(var19 >= var23 - 4 && var19 <= var23 + 1) {
                     var13 = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData();
                     var24 = this.al;
                  }

                  if(var19 < var23 && (var13 == null || var13.getBlock().getMaterial() == Material.AIR)) {
                     var13 = BlockStainedGlassPane.WATER.getBlockData();
                  }

                  var17 = var15 + Math.max(0, var19 - var23);
                  if(var19 < var23 - 1) {
                     var3.a(var11, var19, var10, var24);
                     if(var24.getBlock() == BlockStainedGlassPane.STAINED_HARDENED_CLAY) {
                        var3.a(var11, var19, var10, var24.getBlock().getBlockData().set(BlockCloth.COLOR, EnumColor.b));
                     }
                  } else if(this.aJ && var19 > 86 + var15 * 2) {
                     if(var25) {
                        var3.a(var11, var19, var10, BlockStainedGlassPane.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.COARSE_DIRT));
                     } else {
                        var3.a(var11, var19, var10, BlockStainedGlassPane.GRASS.getBlockData());
                     }
                  } else if(var19 <= var23 + 3 + var15) {
                     var3.a(var11, var19, var10, this.ak);
                     var26 = true;
                  } else {
                     if(var19 >= 64 && var19 <= 127) {
                        if(var25) {
                           var21 = BlockStainedGlassPane.HARDENED_CLAY.getBlockData();
                        } else {
                           var21 = this.a(var4, var19, var5);
                        }
                     } else {
                        var21 = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.b);
                     }

                     var3.a(var11, var19, var10, var21);
                  }
               } else if(var17 > 0) {
                  --var17;
                  if(var26) {
                     var3.a(var11, var19, var10, BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.b));
                  } else {
                     var21 = this.a(var4, var19, var5);
                     var3.a(var11, var19, var10, var21);
                  }
               }
            }
         }
      }

   }

   private void a(long var1) {
      this.aD = new IBlockData[64];
      Arrays.fill(this.aD, BlockStainedGlassPane.HARDENED_CLAY.getBlockData());
      Random var3 = new Random(var1);
      this.aH = new class_atb(var3, 1);

      int var4;
      for(var4 = 0; var4 < 64; ++var4) {
         var4 += var3.nextInt(5) + 1;
         if(var4 < 64) {
            this.aD[var4] = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.b);
         }
      }

      var4 = var3.nextInt(4) + 2;

      int var5;
      int var6;
      int var7;
      int var8;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3.nextInt(3) + 1;
         var7 = var3.nextInt(64);

         for(var8 = 0; var7 + var8 < 64 && var8 < var6; ++var8) {
            this.aD[var7 + var8] = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.e);
         }
      }

      var5 = var3.nextInt(4) + 2;

      int var9;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var3.nextInt(3) + 2;
         var8 = var3.nextInt(64);

         for(var9 = 0; var8 + var9 < 64 && var9 < var7; ++var9) {
            this.aD[var8 + var9] = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.m);
         }
      }

      var6 = var3.nextInt(4) + 2;

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var3.nextInt(3) + 1;
         var9 = var3.nextInt(64);

         for(int var10 = 0; var9 + var10 < 64 && var10 < var8; ++var10) {
            this.aD[var9 + var10] = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.o);
         }
      }

      var7 = var3.nextInt(3) + 3;
      var8 = 0;

      for(var9 = 0; var9 < var7; ++var9) {
         byte var12 = 1;
         var8 += var3.nextInt(16) + 4;

         for(int var11 = 0; var8 + var11 < 64 && var11 < var12; ++var11) {
            this.aD[var8 + var11] = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.a);
            if(var8 + var11 > 1 && var3.nextBoolean()) {
               this.aD[var8 + var11 - 1] = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.i);
            }

            if(var8 + var11 < 63 && var3.nextBoolean()) {
               this.aD[var8 + var11 + 1] = BlockStainedGlassPane.STAINED_HARDENED_CLAY.getBlockData().set(BlockCloth.COLOR, EnumColor.i);
            }
         }
      }

   }

   private IBlockData a(int var1, int var2, int var3) {
      int var4 = (int)Math.round(this.aH.a((double)var1 * 1.0D / 512.0D, (double)var1 * 1.0D / 512.0D) * 2.0D);
      return this.aD[(var2 + var4 + 64) % 64];
   }

   protected BiomeBase d(int var1) {
      boolean var2 = this.az == BiomeBase.aa.az;
      class_afl var3 = new class_afl(var1, var2, this.aJ);
      if(!var2) {
         var3.a(g);
         var3.a(this.ah + " M");
      } else {
         var3.a(this.ah + " (Bryce)");
      }

      var3.a(this.ai, true);
      return var3;
   }
}
