package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BlockPlant;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;

public class class_aqb extends WorldGenerator {
   private BlockPlant a;

   public class_aqb(BlockPlant var1) {
      this.a = var1;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5) && (!var1.worldProvider.m() || var5.getY() < 255) && this.a.f(var1, var5, this.a.getBlockData())) {
            var1.setTypeAndData((BlockPosition)var5, (IBlockData)this.a.getBlockData(), 2);
         }
      }

      return true;
   }
}
