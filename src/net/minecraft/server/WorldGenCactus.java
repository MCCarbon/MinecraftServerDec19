package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;

public class WorldGenCactus extends WorldGenerator {
   public boolean generate(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 10; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5)) {
            int var6 = 1 + var2.nextInt(var2.nextInt(3) + 1);

            for(int var7 = 0; var7 < var6; ++var7) {
               if(Blocks.CACTUS.e(var1, var5)) {
                  var1.setTypeAndData((BlockPosition)var5.up(var7), (IBlockData)Blocks.CACTUS.getBlockData(), 2);
               }
            }
         }
      }

      return true;
   }
}
