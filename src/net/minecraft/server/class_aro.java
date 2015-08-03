package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_alu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_aro extends class_aql {
   public boolean b(World var1, Random var2, BlockPosition var3) {
      for(; var3.getY() < 128; var3 = var3.up()) {
         if(var1.isEmpty(var3)) {
            EnumDirection[] var4 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getDirections();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               EnumDirection var7 = var4[var6];
               if(BlockStainedGlassPane.VINE.canPlace(var1, var3, var7)) {
                  IBlockData var8 = BlockStainedGlassPane.VINE.getBlockData().set(class_alu.b, Boolean.valueOf(var7 == EnumDirection.NORTH)).set(class_alu.N, Boolean.valueOf(var7 == EnumDirection.EAST)).set(class_alu.O, Boolean.valueOf(var7 == EnumDirection.SOUTH)).set(class_alu.P, Boolean.valueOf(var7 == EnumDirection.WEST));
                  var1.setTypeAndData((BlockPosition)var3, (IBlockData)var8, 2);
                  break;
               }
            }
         } else {
            var3 = var3.add(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         }
      }

      return true;
   }
}
