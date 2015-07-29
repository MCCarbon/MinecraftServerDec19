package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahx;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atl;

public class class_aim extends class_ahx {
   public class_aar a(IBlockData var1, Random var2, int var3) {
      if(var3 > 3) {
         var3 = 3;
      }

      return var2.nextInt(10 - var3 * 3) == 0?class_aau.am:class_aar.a((Block)this);
   }

   public class_atl g(IBlockData var1) {
      return class_atl.m;
   }
}
