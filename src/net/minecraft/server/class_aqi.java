package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;

public class class_aqi extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      Iterator var4 = BlockPosition.allInCubeM(var3.add(-1, -2, -1), var3.add(1, 2, 1)).iterator();

      while(true) {
         while(var4.hasNext()) {
            BlockPosition.MutableBlockPosition var5 = (BlockPosition.MutableBlockPosition)var4.next();
            boolean var6 = var5.getX() == var3.getX();
            boolean var7 = var5.getY() == var3.getY();
            boolean var8 = var5.getZ() == var3.getZ();
            boolean var9 = Math.abs(var5.getY() - var3.getY()) == 2;
            if(var6 && var7 && var8) {
               this.a(var1, new BlockPosition(var5), Blocks.END_GATEWAY.getBlockData());
            } else if(var7) {
               this.a(var1, var5, Blocks.AIR.getBlockData());
            } else if(var9 && var6 && var8) {
               this.a(var1, var5, Blocks.BEDROCK.getBlockData());
            } else if((var6 || var8) && !var9) {
               this.a(var1, var5, Blocks.BEDROCK.getBlockData());
            } else {
               this.a(var1, var5, Blocks.AIR.getBlockData());
            }
         }

         return true;
      }
   }
}
