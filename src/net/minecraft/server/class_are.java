package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_are extends WorldGenerator {
   public boolean generate(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 20; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         if(var1.isEmpty(var5)) {
            BlockPosition var6 = var5.down();
            if(var1.getType(var6.west()).getBlock().getMaterial() == Material.WATER || var1.getType(var6.east()).getBlock().getMaterial() == Material.WATER || var1.getType(var6.north()).getBlock().getMaterial() == Material.WATER || var1.getType(var6.south()).getBlock().getMaterial() == Material.WATER) {
               int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

               for(int var8 = 0; var8 < var7; ++var8) {
                  if(Blocks.REEDS.e(var1, var5)) {
                     var1.setTypeAndData((BlockPosition)var5.up(var8), (IBlockData)Blocks.REEDS.getBlockData(), 2);
                  }
               }
            }
         }
      }

      return true;
   }
}
