package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;

public class class_aqo extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5) && var1.getType(var5.down()).getBlock() == BlockStainedGlassPane.NETHERRACK) {
            var1.setTypeAndData((BlockPosition)var5, (IBlockData)BlockStainedGlassPane.FIRE.getBlockData(), 2);
         }
      }

      return true;
   }
}
