package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockLeaves;
import net.minecraft.server.BlockLeaves1;
import net.minecraft.server.BlockLog1;
import net.minecraft.server.BlockWood;
import net.minecraft.server.BlockLongGrass;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_aqn;
import net.minecraft.server.class_aqw;
import net.minecraft.server.class_aqz;
import net.minecraft.server.class_arm;
import net.minecraft.server.class_arn;
import net.minecraft.server.class_aro;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_tx;
import net.minecraft.server.class_uc;

public class class_afk extends BiomeBase {
   private boolean aD;
   private static final IBlockData aE;
   private static final IBlockData aF;
   private static final IBlockData aG;

   public class_afk(int var1, boolean var2) {
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
         this.at.add(new BiomeBase.class_c_in_class_aez(class_uc.class, 2, 1, 1));
      }

      this.au.add(new BiomeBase.class_c_in_class_aez(class_tx.class, 10, 4, 4));
   }

   public class_apw a(Random var1) {
      return (class_apw)(var1.nextInt(10) == 0?this.aB:(var1.nextInt(2) == 0?new class_aqn(aE, aG):(!this.aD && var1.nextInt(3) == 0?new class_aqw(false, 10, 20, aE, aF):new class_arn(false, 4 + var1.nextInt(7), aE, aF, true))));
   }

   public class_aql b(Random var1) {
      return var1.nextInt(4) == 0?new class_arm(BlockLongGrass.EnumTallGrassType.FERN):new class_arm(BlockLongGrass.EnumTallGrassType.GRASS);
   }

   public void a(World var1, Random var2, BlockPosition var3) {
      super.a(var1, var2, var3);
      int var4 = var2.nextInt(16) + 8;
      int var5 = var2.nextInt(16) + 8;
      int var6 = var2.nextInt(var1.m(var3.add(var4, 0, var5)).getY() * 2);
      (new class_aqz()).b(var1, var2, var3.add(var4, var6, var5));
      class_aro var9 = new class_aro();

      for(var5 = 0; var5 < 50; ++var5) {
         var6 = var2.nextInt(16) + 8;
         boolean var7 = true;
         int var8 = var2.nextInt(16) + 8;
         var9.b(var1, var2, var3.add(var6, 128, var8));
      }

   }

   static {
      aE = BlockStainedGlassPane.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.JUNGLE);
      aF = BlockStainedGlassPane.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.JUNGLE).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
      aG = BlockStainedGlassPane.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.OAK).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
   }
}
