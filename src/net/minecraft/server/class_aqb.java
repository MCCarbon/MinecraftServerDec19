package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_ago;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;

public class class_aqb extends class_aql {
   private class_ago a;

   public class_aqb(class_ago var1) {
      this.a = var1;
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5) && (!var1.t.m() || var5.getY() < 255) && this.a.f(var1, var5, this.a.getBlockData())) {
            var1.a((BlockPosition)var5, (IBlockData)this.a.getBlockData(), 2);
         }
      }

      return true;
   }
}
