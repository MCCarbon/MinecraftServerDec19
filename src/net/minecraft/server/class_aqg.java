package net.minecraft.server;

import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockStepAbstract;
import net.minecraft.server.BlockSand;
import net.minecraft.server.BlockDoubleStepAbstract;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_ant;
import net.minecraft.server.WorldGenerator;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;

public class class_aqg extends WorldGenerator {
   private static final class_ant a;
   private final IBlockData b;
   private final IBlockData c;
   private final IBlockData d;

   public class_aqg() {
      this.b = Blocks.STONE_SLAB.getBlockData().set(BlockDoubleStepAbstract.VARIANT, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND).set(BlockStepAbstract.HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
      this.c = Blocks.SANDSTONE.getBlockData();
      this.d = Blocks.FLOWING_WATER.getBlockData();
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      while(var1.isEmpty(var3) && var3.getY() > 2) {
         var3 = var3.down();
      }

      if(!a.a(var1.getType(var3))) {
         return false;
      } else {
         int var4;
         int var5;
         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if(var1.isEmpty(var3.add(var4, -1, var5)) && var1.isEmpty(var3.add(var4, -2, var5))) {
                  return false;
               }
            }
         }

         for(var4 = -1; var4 <= 0; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               for(int var6 = -2; var6 <= 2; ++var6) {
                  var1.setTypeAndData((BlockPosition)var3.add(var5, var4, var6), (IBlockData)this.c, 2);
               }
            }
         }

         var1.setTypeAndData((BlockPosition)var3, (IBlockData)this.d, 2);
         Iterator var7 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         while(var7.hasNext()) {
            EnumDirection var8 = (EnumDirection)var7.next();
            var1.setTypeAndData((BlockPosition)var3.shift(var8), (IBlockData)this.d, 2);
         }

         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if(var4 == -2 || var4 == 2 || var5 == -2 || var5 == 2) {
                  var1.setTypeAndData((BlockPosition)var3.add(var4, 1, var5), (IBlockData)this.c, 2);
               }
            }
         }

         var1.setTypeAndData((BlockPosition)var3.add(2, 1, 0), (IBlockData)this.b, 2);
         var1.setTypeAndData((BlockPosition)var3.add(-2, 1, 0), (IBlockData)this.b, 2);
         var1.setTypeAndData((BlockPosition)var3.add(0, 1, 2), (IBlockData)this.b, 2);
         var1.setTypeAndData((BlockPosition)var3.add(0, 1, -2), (IBlockData)this.b, 2);

         for(var4 = -1; var4 <= 1; ++var4) {
            for(var5 = -1; var5 <= 1; ++var5) {
               if(var4 == 0 && var5 == 0) {
                  var1.setTypeAndData((BlockPosition)var3.add(var4, 4, var5), (IBlockData)this.c, 2);
               } else {
                  var1.setTypeAndData((BlockPosition)var3.add(var4, 4, var5), (IBlockData)this.b, 2);
               }
            }
         }

         for(var4 = 1; var4 <= 3; ++var4) {
            var1.setTypeAndData((BlockPosition)var3.add(-1, var4, -1), (IBlockData)this.c, 2);
            var1.setTypeAndData((BlockPosition)var3.add(-1, var4, 1), (IBlockData)this.c, 2);
            var1.setTypeAndData((BlockPosition)var3.add(1, var4, -1), (IBlockData)this.c, 2);
            var1.setTypeAndData((BlockPosition)var3.add(1, var4, 1), (IBlockData)this.c, 2);
         }

         return true;
      }
   }

   static {
      a = class_ant.a((Block)Blocks.SAND).a(BlockSand.VARIANT, Predicates.equalTo(BlockSand.EnumSandVariant.SAND));
   }
}
