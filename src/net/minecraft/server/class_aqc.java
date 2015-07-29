package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_aqc extends class_aql {
   public boolean b(World var1, Random var2, class_cj var3) {
      for(int var4 = 0; var4 < 10; ++var4) {
         class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5)) {
            int var6 = 1 + var2.nextInt(var2.nextInt(3) + 1);

            for(int var7 = 0; var7 < var6; ++var7) {
               if(Blocks.CACTUS.e(var1, var5)) {
                  var1.a((class_cj)var5.b(var7), (IBlockData)Blocks.CACTUS.getBlockData(), 2);
               }
            }
         }
      }

      return true;
   }
}
