package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_aqe extends WorldGenerator {
   private Block a;
   private int b;

   public class_aqe(int var1) {
      this.a = Blocks.CLAY;
      this.b = var1;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      if(var1.getType(var3).getBlock().getMaterial() != Material.WATER) {
         return false;
      } else {
         int var4 = var2.nextInt(this.b - 2) + 2;
         byte var5 = 1;

         for(int var6 = var3.getX() - var4; var6 <= var3.getX() + var4; ++var6) {
            for(int var7 = var3.getZ() - var4; var7 <= var3.getZ() + var4; ++var7) {
               int var8 = var6 - var3.getX();
               int var9 = var7 - var3.getZ();
               if(var8 * var8 + var9 * var9 <= var4 * var4) {
                  for(int var10 = var3.getY() - var5; var10 <= var3.getY() + var5; ++var10) {
                     BlockPosition var11 = new BlockPosition(var6, var10, var7);
                     Block var12 = var1.getType(var11).getBlock();
                     if(var12 == Blocks.DIRT || var12 == Blocks.CLAY) {
                        var1.setTypeAndData((BlockPosition)var11, (IBlockData)this.a.getBlockData(), 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
