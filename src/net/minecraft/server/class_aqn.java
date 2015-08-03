package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_arn;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_aqn extends class_arn {
   private final IBlockData a;
   private final IBlockData b;

   public class_aqn(IBlockData var1, IBlockData var2) {
      super(false);
      this.b = var1;
      this.a = var2;
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      Block var4;
      while(((var4 = var1.getType(var3).getBlock()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.getY() > 0) {
         var3 = var3.down();
      }

      Block var5 = var1.getType(var3).getBlock();
      if(var5 == Blocks.DIRT || var5 == Blocks.GRASS) {
         var3 = var3.up();
         this.a(var1, var3, this.b);

         for(int var6 = var3.getY(); var6 <= var3.getY() + 2; ++var6) {
            int var7 = var6 - var3.getY();
            int var8 = 2 - var7;

            for(int var9 = var3.getX() - var8; var9 <= var3.getX() + var8; ++var9) {
               int var10 = var9 - var3.getX();

               for(int var11 = var3.getZ() - var8; var11 <= var3.getZ() + var8; ++var11) {
                  int var12 = var11 - var3.getZ();
                  if(Math.abs(var10) != var8 || Math.abs(var12) != var8 || var2.nextInt(2) != 0) {
                     BlockPosition var13 = new BlockPosition(var9, var6, var11);
                     if(!var1.getType(var13).getBlock().isFullBlock()) {
                        this.a(var1, var13, this.a);
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
