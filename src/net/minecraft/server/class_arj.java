package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_arj extends class_aql {
   private Block a;

   public class_arj(Block var1) {
      this.a = var1;
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      if(var1.p(var3.shiftUp()).getBlock() != Blocks.STONE) {
         return false;
      } else if(var1.p(var3.shiftDown()).getBlock() != Blocks.STONE) {
         return false;
      } else if(var1.p(var3).getBlock().getMaterial() != Material.AIR && var1.p(var3).getBlock() != Blocks.STONE) {
         return false;
      } else {
         int var4 = 0;
         if(var1.p(var3.shiftWest()).getBlock() == Blocks.STONE) {
            ++var4;
         }

         if(var1.p(var3.shiftEast()).getBlock() == Blocks.STONE) {
            ++var4;
         }

         if(var1.p(var3.shiftNorth()).getBlock() == Blocks.STONE) {
            ++var4;
         }

         if(var1.p(var3.shiftSouth()).getBlock() == Blocks.STONE) {
            ++var4;
         }

         int var5 = 0;
         if(var1.d(var3.shiftWest())) {
            ++var5;
         }

         if(var1.d(var3.shiftEast())) {
            ++var5;
         }

         if(var1.d(var3.shiftNorth())) {
            ++var5;
         }

         if(var1.d(var3.shiftSouth())) {
            ++var5;
         }

         if(var4 == 3 && var5 == 1) {
            var1.a((BlockPosition)var3, (IBlockData)this.a.getBlockData(), 2);
            var1.a(this.a, var3, var2);
         }

         return true;
      }
   }
}
