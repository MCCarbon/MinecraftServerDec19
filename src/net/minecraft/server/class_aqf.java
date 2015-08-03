package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_aqf extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      Block var4;
      while(((var4 = var1.getType(var3).getBlock()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.getY() > 0) {
         var3 = var3.down();
      }

      for(int var5 = 0; var5 < 4; ++var5) {
         BlockPosition var6 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var6) && BlockStainedGlassPane.DEADBUSH.f(var1, var6, BlockStainedGlassPane.DEADBUSH.getBlockData())) {
            var1.setTypeAndData((BlockPosition)var6, (IBlockData)BlockStainedGlassPane.DEADBUSH.getBlockData(), 2);
         }
      }

      return true;
   }
}
