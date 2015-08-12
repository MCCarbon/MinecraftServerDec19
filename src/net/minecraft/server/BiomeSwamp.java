package net.minecraft.server;

import java.util.Random;

public class BiomeSwamp extends BiomeBase {
   protected BiomeSwamp(int var1) {
      super(var1);
      this.as.A = 2;
      this.as.B = 1;
      this.as.D = 1;
      this.as.E = 8;
      this.as.F = 10;
      this.as.J = 1;
      this.as.z = 4;
      this.as.I = 0;
      this.as.H = 0;
      this.as.C = 5;
      this.ar = 14745518;
      this.at.add(new BiomeBase.BiomeMeta(EntitySlime.class, 1, 1, 1));
   }

   public class_apw a(Random var1) {
      return this.aC;
   }

   public BlockFlowers.EnumFlowerVarient a(Random var1, BlockPosition var2) {
      return BlockFlowers.EnumFlowerVarient.BLUE_ORCHID;
   }

   public void a(World var1, Random var2, ChunkSnapshot var3, int var4, int var5, double var6) {
      double var8 = af.a((double)var4 * 0.25D, (double)var5 * 0.25D);
      if(var8 > 0.0D) {
         int var10 = var4 & 15;
         int var11 = var5 & 15;

         for(int var12 = 255; var12 >= 0; --var12) {
            if(var3.a(var11, var12, var10).getBlock().getMaterial() != Material.AIR) {
               if(var12 == 62 && var3.a(var11, var12, var10).getBlock() != Blocks.WATER) {
                  var3.a(var11, var12, var10, Blocks.WATER.getBlockData());
                  if(var8 < 0.12D) {
                     var3.a(var11, var12 + 1, var10, Blocks.WATERLILY.getBlockData());
                  }
               }
               break;
            }
         }
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }
}
