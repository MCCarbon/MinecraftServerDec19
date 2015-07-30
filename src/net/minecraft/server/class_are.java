package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_are extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 20; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         if(var1.d(var5)) {
            BlockPosition var6 = var5.shiftDown();
            if(var1.p(var6.shiftWest()).getBlock().getMaterial() == Material.WATER || var1.p(var6.shiftEast()).getBlock().getMaterial() == Material.WATER || var1.p(var6.shiftNorth()).getBlock().getMaterial() == Material.WATER || var1.p(var6.shiftSouth()).getBlock().getMaterial() == Material.WATER) {
               int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

               for(int var8 = 0; var8 < var7; ++var8) {
                  if(Blocks.REEDS.e(var1, var5)) {
                     var1.a((BlockPosition)var5.shiftUp(var8), (IBlockData)Blocks.REEDS.getBlockData(), 2);
                  }
               }
            }
         }
      }

      return true;
   }
}
