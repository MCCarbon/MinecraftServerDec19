package net.minecraft.server;

import java.util.Random;

public class BiomeBigHills extends BiomeBase {
   private WorldGenerator aD;
   private class_ark aE;
   private int aF;
   private int aG;
   private int aH;
   private int aI;

   protected BiomeBigHills(int var1, boolean var2) {
      super(var1);
      this.aD = new WorldGenMinable(Blocks.MONSTER_EGG.getBlockData().set(BlockMonsterEggs.a, BlockMonsterEggs.EnumMonsterEggVariant.a), 9);
      this.aE = new class_ark(false);
      this.aF = 0;
      this.aG = 1;
      this.aH = 2;
      this.aI = this.aF;
      if(var2) {
         this.as.A = 3;
         this.aI = this.aG;
      }

   }

   public class_apw a(Random var1) {
      return (class_apw)(var1.nextInt(3) > 0?this.aE:super.a(var1));
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      super.a(var1, var2, var3);
      int var4 = 3 + var2.nextInt(6);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var2.nextInt(16);
         var7 = var2.nextInt(28) + 4;
         int var8 = var2.nextInt(16);
         BlockPosition var9 = var3.add(var6, var7, var8);
         if(var1.getType(var9).getBlock() == Blocks.STONE) {
            var1.setTypeAndData((BlockPosition)var9, (IBlockData)Blocks.EMERALD_ORE.getBlockData(), 2);
         }
      }

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16);
         var6 = var2.nextInt(64);
         var7 = var2.nextInt(16);
         this.aD.generate(var1, var2, var3.add(var5, var6, var7));
      }

   }

   public void a(World var1, Random var2, ChunkSnapshot var3, int var4, int var5, double var6) {
      this.ak = Blocks.GRASS.getBlockData();
      this.al = Blocks.DIRT.getBlockData();
      if((var6 < -1.0D || var6 > 2.0D) && this.aI == this.aH) {
         this.ak = Blocks.GRAVEL.getBlockData();
         this.al = Blocks.GRAVEL.getBlockData();
      } else if(var6 > 1.0D && this.aI != this.aG) {
         this.ak = Blocks.STONE.getBlockData();
         this.al = Blocks.STONE.getBlockData();
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   private BiomeBigHills b(BiomeBase var1) {
      this.aI = this.aH;
      this.a(var1.ai, true);
      this.a(var1.ah + " M");
      this.a(new BiomeBase.BiomeTemperature(var1.an, var1.ao));
      this.a(var1.temperature, var1.humidity);
      return this;
   }

   protected BiomeBase d(int var1) {
      return (new BiomeBigHills(var1, false)).b(this);
   }
}
