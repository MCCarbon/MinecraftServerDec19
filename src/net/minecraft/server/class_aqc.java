package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;

public class class_aqc extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 10; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5)) {
            int var6 = 1 + var2.nextInt(var2.nextInt(3) + 1);

            for(int var7 = 0; var7 < var6; ++var7) {
               if(BlockStainedGlassPane.CACTUS.e(var1, var5)) {
                  var1.setTypeAndData((BlockPosition)var5.up(var7), (IBlockData)BlockStainedGlassPane.CACTUS.getBlockData(), 2);
               }
            }
         }
      }

      return true;
   }
}
