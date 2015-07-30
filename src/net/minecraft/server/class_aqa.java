package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_od;
import net.minecraft.server.class_oj;

public class class_aqa extends class_aql {
   private final List a;
   private final int b;

   public class_aqa(List var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.getY() > 1) {
         var3 = var3.shiftDown();
      }

      if(var3.getY() < 1) {
         return false;
      } else {
         var3 = var3.shiftUp();

         for(int var5 = 0; var5 < 4; ++var5) {
            BlockPosition var6 = var3.add(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
            if(var1.d(var6) && World.a((class_aer)var1, (BlockPosition)var6.shiftDown())) {
               var1.a((BlockPosition)var6, (IBlockData)Blocks.CHEST.getBlockData(), 2);
               class_amg var7 = var1.s(var6);
               if(var7 instanceof class_ami) {
                  class_od.a(var2, this.a, (class_oj)((class_ami)var7), this.b);
               }

               BlockPosition var8 = var6.shiftEast();
               BlockPosition var9 = var6.shiftWest();
               BlockPosition var10 = var6.shiftNorth();
               BlockPosition var11 = var6.shiftSouth();
               if(var1.d(var9) && World.a((class_aer)var1, (BlockPosition)var9.shiftDown())) {
                  var1.a((BlockPosition)var9, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.d(var8) && World.a((class_aer)var1, (BlockPosition)var8.shiftDown())) {
                  var1.a((BlockPosition)var8, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.d(var10) && World.a((class_aer)var1, (BlockPosition)var10.shiftDown())) {
                  var1.a((BlockPosition)var10, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.d(var11) && World.a((class_aer)var1, (BlockPosition)var11.shiftDown())) {
                  var1.a((BlockPosition)var11, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
