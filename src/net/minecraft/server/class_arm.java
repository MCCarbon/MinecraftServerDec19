package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alm;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_arm extends class_aql {
   private final IBlockData a;

   public class_arm(class_alm.class_a_in_class_alm var1) {
      this.a = Blocks.TALLGRASS.getBlockData().set(class_alm.a, var1);
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.getY() > 0) {
         var3 = var3.shiftDown();
      }

      for(int var5 = 0; var5 < 128; ++var5) {
         BlockPosition var6 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var6) && Blocks.TALLGRASS.f(var1, var6, this.a)) {
            var1.a((BlockPosition)var6, (IBlockData)this.a, 2);
         }
      }

      return true;
   }
}
