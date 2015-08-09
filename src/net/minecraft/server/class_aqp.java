package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_aqp extends WorldGenerator {
   public boolean generate(World var1, Random var2, BlockPosition var3) {
      if(!var1.isEmpty(var3)) {
         return false;
      } else if(var1.getType(var3.up()).getBlock() != Blocks.NETHERRACK) {
         return false;
      } else {
         var1.setTypeAndData((BlockPosition)var3, (IBlockData)Blocks.GLOWSTONE.getBlockData(), 2);

         for(int var4 = 0; var4 < 1500; ++var4) {
            BlockPosition var5 = var3.add(var2.nextInt(8) - var2.nextInt(8), -var2.nextInt(12), var2.nextInt(8) - var2.nextInt(8));
            if(var1.getType(var5).getBlock().getMaterial() == Material.AIR) {
               int var6 = 0;
               EnumDirection[] var7 = EnumDirection.values();
               int var8 = var7.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  EnumDirection var10 = var7[var9];
                  if(var1.getType(var5.shift(var10)).getBlock() == Blocks.GLOWSTONE) {
                     ++var6;
                  }

                  if(var6 > 1) {
                     break;
                  }
               }

               if(var6 == 1) {
                  var1.setTypeAndData((BlockPosition)var5, (IBlockData)Blocks.GLOWSTONE.getBlockData(), 2);
               }
            }
         }

         return true;
      }
   }
}
