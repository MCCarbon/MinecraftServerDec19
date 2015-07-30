package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;

public class class_aqz extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(Blocks.MELON_BLOCK.d(var1, var5) && var1.p(var5.shiftDown()).getBlock() == Blocks.GRASS) {
            var1.a((BlockPosition)var5, (IBlockData)Blocks.MELON_BLOCK.getBlockData(), 2);
         }
      }

      return true;
   }
}
