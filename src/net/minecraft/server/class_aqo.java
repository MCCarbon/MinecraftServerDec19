package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_aqo extends class_aql {
   public boolean b(World var1, Random var2, class_cj var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5) && var1.p(var5.b()).getBlock() == Blocks.NETHERRACK) {
            var1.a((class_cj)var5, (IBlockData)Blocks.FIRE.getBlockData(), 2);
         }
      }

      return true;
   }
}
