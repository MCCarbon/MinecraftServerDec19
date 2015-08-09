package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BlockFlowers;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;

public class class_aqm extends WorldGenerator {
   private BlockFlowers a;
   private IBlockData b;

   public class_aqm(BlockFlowers var1, BlockFlowers.EnumFlowerVarient var2) {
      this.a(var1, var2);
   }

   public void a(BlockFlowers var1, BlockFlowers.EnumFlowerVarient var2) {
      this.a = var1;
      this.b = var1.getBlockData().set(var1.getFlowerVarients(), var2);
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5) && (!var1.worldProvider.m() || var5.getY() < 255) && this.a.f(var1, var5, this.b)) {
            var1.setTypeAndData((BlockPosition)var5, (IBlockData)this.b, 2);
         }
      }

      return true;
   }
}
