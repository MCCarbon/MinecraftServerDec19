package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;

public class class_aqf extends class_aql {
   public boolean b(World var1, Random var2, class_cj var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).getMaterial() == Material.a || var4.getMaterial() == Material.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      for(int var5 = 0; var5 < 4; ++var5) {
         class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var6) && Blocks.DEADBUSH.f(var1, var6, Blocks.DEADBUSH.getBlockData())) {
            var1.a((class_cj)var6, (IBlockData)Blocks.DEADBUSH.getBlockData(), 2);
         }
      }

      return true;
   }
}
