package net.minecraft.server;

import java.util.Random;

public class class_ard extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5) && var1.getType(var5.down()).getBlock() == Blocks.GRASS && Blocks.PUMPKIN.canPlace(var1, var5)) {
            var1.setTypeAndData((BlockPosition)var5, (IBlockData)Blocks.PUMPKIN.getBlockData().set(BlockPumpkin.FACING, EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var2)), 2);
         }
      }

      return true;
   }
}
