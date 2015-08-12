package net.minecraft.server;

import java.util.Random;

public class BiomeJungle extends BiomeBase {
   private boolean aD;
   private static final IBlockData aE;
   private static final IBlockData aF;
   private static final IBlockData aG;

   public BiomeJungle(int var1, boolean var2) {
      super(var1);
      this.aD = var2;
      if(var2) {
         this.as.A = 2;
      } else {
         this.as.A = 50;
      }

      this.as.C = 25;
      this.as.B = 4;
      if(!var2) {
         this.at.add(new BiomeBase.BiomeMeta(EntityOcelot.class, 2, 1, 1));
      }

      this.au.add(new BiomeBase.BiomeMeta(EntityChicken.class, 10, 4, 4));
   }

   public class_apw a(Random var1) {
      return (class_apw)(var1.nextInt(10) == 0?this.aB:(var1.nextInt(2) == 0?new class_aqn(aE, aG):(!this.aD && var1.nextInt(3) == 0?new class_aqw(false, 10, 20, aE, aF):new WorldGenTrees(false, 4 + var1.nextInt(7), aE, aF, true))));
   }

   public WorldGenerator b(Random var1) {
      return var1.nextInt(4) == 0?new class_arm(BlockLongGrass.EnumTallGrassType.FERN):new class_arm(BlockLongGrass.EnumTallGrassType.GRASS);
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      super.a(var1, var2, var3);
      int var4 = var2.nextInt(16) + 8;
      int var5 = var2.nextInt(16) + 8;
      int var6 = var2.nextInt(var1.getHighestBlockYAt(var3.add(var4, 0, var5)).getY() * 2);
      (new class_aqz()).generate(var1, var2, var3.add(var4, var6, var5));
      class_aro var9 = new class_aro();

      for(var5 = 0; var5 < 50; ++var5) {
         var6 = var2.nextInt(16) + 8;
         boolean var7 = true;
         int var8 = var2.nextInt(16) + 8;
         var9.generate(var1, var2, var3.add(var6, 128, var8));
      }

   }

   static {
      aE = Blocks.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.JUNGLE);
      aF = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.JUNGLE).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
      aG = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.OAK).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
   }
}
