package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;

public class class_aqo extends WorldGenerator {
   public boolean generate(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5) && var1.getType(var5.down()).getBlock() == Blocks.NETHERRACK) {
            var1.setTypeAndData((BlockPosition)var5, (IBlockData)Blocks.FIRE.getBlockData(), 2);
         }
      }

      return true;
   }
}
