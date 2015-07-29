package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_arp extends class_aql {
   public boolean b(World var1, Random var2, class_cj var3) {
      for(int var4 = 0; var4 < 10; ++var4) {
         int var5 = var3.n() + var2.nextInt(8) - var2.nextInt(8);
         int var6 = var3.o() + var2.nextInt(4) - var2.nextInt(4);
         int var7 = var3.p() + var2.nextInt(8) - var2.nextInt(8);
         if(var1.d(new class_cj(var5, var6, var7)) && Blocks.WATERLILY.d(var1, new class_cj(var5, var6, var7))) {
            var1.a((class_cj)(new class_cj(var5, var6, var7)), (IBlockData)Blocks.WATERLILY.getBlockData(), 2);
         }
      }

      return true;
   }
}
