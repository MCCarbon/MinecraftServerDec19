package net.minecraft.server;

import java.util.Random;

public class class_afv extends BiomeBase {
   private static final class_arc aD = new class_arc();
   private static final class_ark aE = new class_ark(false);
   private static final class_aqx aF = new class_aqx(false, false);
   private static final class_aqx aG = new class_aqx(false, true);
   private static final class_apz aH;
   private int aI;

   public class_afv(int var1, int var2) {
      super(var1);
      this.aI = var2;
      this.au.add(new BiomeBase.class_c_in_class_aez(class_ul.class, 8, 4, 4));
      this.as.A = 10;
      if(var2 != 1 && var2 != 2) {
         this.as.C = 1;
         this.as.E = 1;
      } else {
         this.as.C = 7;
         this.as.D = 1;
         this.as.E = 3;
      }

   }

   public class_apw a(Random var1) {
      return (class_apw)((this.aI == 1 || this.aI == 2) && var1.nextInt(3) == 0?(this.aI != 2 && var1.nextInt(13) != 0?aF:aG):(var1.nextInt(3) == 0?aD:aE));
   }

   public class_aql b(Random var1) {
      return var1.nextInt(5) > 0?new class_arm(BlockLongGrass.EnumTallGrassType.FERN):new class_arm(BlockLongGrass.EnumTallGrassType.GRASS);
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      int var4;
      int var5;
      int var6;
      int var7;
      if(this.aI == 1 || this.aI == 2) {
         var4 = var2.nextInt(3);

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var2.nextInt(16) + 8;
            var7 = var2.nextInt(16) + 8;
            BlockPosition var8 = var1.m(var3.add(var6, 0, var7));
            aH.b(var1, var2, var8);
         }
      }

      ag.a(BlockTallPlant.class_b_in_class_ahm.d);

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16) + 8;
         var6 = var2.nextInt(16) + 8;
         var7 = var2.nextInt(var1.m(var3.add(var5, 0, var6)).getY() + 32);
         ag.b(var1, var2, var3.add(var5, var7, var6));
      }

      super.a(var1, var2, var3);
   }

   public void a(World var1, Random var2, class_aph var3, int var4, int var5, double var6) {
      if(this.aI == 1 || this.aI == 2) {
         this.ak = Blocks.GRASS.getBlockData();
         this.al = Blocks.DIRT.getBlockData();
         if(var6 > 1.75D) {
            this.ak = Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.COARSE_DIRT);
         } else if(var6 > -0.95D) {
            this.ak = Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.PODZOL);
         }
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   protected BiomeBase d(int var1) {
      return this.az == BiomeBase.V.az?(new class_afv(var1, 2)).a(5858897, true).a("Mega Spruce Taiga").a(5159473).a(0.25F, 0.8F).a(new BiomeBase.class_a_in_class_aez(this.an, this.ao)):super.d(var1);
   }

   static {
      aH = new class_apz(Blocks.MOSSY_COBBLESTONE, 0);
   }
}
