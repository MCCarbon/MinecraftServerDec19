package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alm;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;

public class class_arm extends class_aql {
   private final IBlockData a;

   public class_arm(class_alm.class_a_in_class_alm var1) {
      this.a = Blocks.TALLGRASS.getBlockData().set(class_alm.a, var1);
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).getMaterial() == Material.a || var4.getMaterial() == Material.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      for(int var5 = 0; var5 < 128; ++var5) {
         class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var6) && Blocks.TALLGRASS.f(var1, var6, this.a)) {
            var1.a((class_cj)var6, (IBlockData)this.a, 2);
         }
      }

      return true;
   }
}
