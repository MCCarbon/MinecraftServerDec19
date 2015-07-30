package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aic;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;

public class class_aqm extends class_aql {
   private class_aic a;
   private IBlockData b;

   public class_aqm(class_aic var1, class_aic.class_a_in_class_aic var2) {
      this.a(var1, var2);
   }

   public void a(class_aic var1, class_aic.class_a_in_class_aic var2) {
      this.a = var1;
      this.b = var1.getBlockData().set(var1.n(), var2);
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5) && (!var1.t.m() || var5.getY() < 255) && this.a.f(var1, var5, this.b)) {
            var1.a((BlockPosition)var5, (IBlockData)this.b, 2);
         }
      }

      return true;
   }
}
