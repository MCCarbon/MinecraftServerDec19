package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;

public class class_aqj extends WorldGenerator {
   public boolean generate(World var1, Random var2, BlockPosition var3) {
      int var4 = var2.nextInt(3) + 4;
      float var5 = (float)var4;

      for(int var6 = 0; var5 > 0.5F; --var6) {
         for(int var7 = MathHelper.floor(-var5); var7 <= MathHelper.ceil(var5); ++var7) {
            for(int var8 = MathHelper.floor(-var5); var8 <= MathHelper.ceil(var5); ++var8) {
               if((float)(var7 * var7 + var8 * var8) <= (var5 + 1.0F) * (var5 + 1.0F)) {
                  this.setTypeAndData(var1, var3.add(var7, var6, var8), Blocks.END_STONE.getBlockData());
               }
            }
         }

         var5 = (float)((double)var5 - ((double)var2.nextInt(2) + 0.5D));
      }

      return true;
   }
}
