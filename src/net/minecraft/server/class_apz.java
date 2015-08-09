package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;

public class class_apz extends WorldGenerator {
   private final Block a;
   private final int b;

   public class_apz(Block var1, int var2) {
      super(false);
      this.a = var1;
      this.b = var2;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      while(true) {
         label50: {
            if(var3.getY() > 3) {
               if(var1.isEmpty(var3.down())) {
                  break label50;
               }

               Block var4 = var1.getType(var3.down()).getBlock();
               if(var4 != Blocks.GRASS && var4 != Blocks.DIRT && var4 != Blocks.STONE) {
                  break label50;
               }
            }

            if(var3.getY() <= 3) {
               return false;
            }

            int var12 = this.b;

            for(int var5 = 0; var12 >= 0 && var5 < 3; ++var5) {
               int var6 = var12 + var2.nextInt(2);
               int var7 = var12 + var2.nextInt(2);
               int var8 = var12 + var2.nextInt(2);
               float var9 = (float)(var6 + var7 + var8) * 0.333F + 0.5F;
               Iterator var10 = BlockPosition.allInCube(var3.add(-var6, -var7, -var8), var3.add(var6, var7, var8)).iterator();

               while(var10.hasNext()) {
                  BlockPosition var11 = (BlockPosition)var10.next();
                  if(var11.distanceSquared(var3) <= (double)(var9 * var9)) {
                     var1.setTypeAndData((BlockPosition)var11, (IBlockData)this.a.getBlockData(), 4);
                  }
               }

               var3 = var3.add(-(var12 + 1) + var2.nextInt(2 + var12 * 2), 0 - var2.nextInt(2), -(var12 + 1) + var2.nextInt(2 + var12 * 2));
            }

            return true;
         }

         var3 = var3.down();
      }
   }
}
