package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_aqq extends class_aql {
   private final Block a;
   private final boolean b;

   public class_aqq(Block var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      if(var1.getType(var3.up()).getBlock() != Blocks.NETHERRACK) {
         return false;
      } else if(var1.getType(var3).getBlock().getMaterial() != Material.AIR && var1.getType(var3).getBlock() != Blocks.NETHERRACK) {
         return false;
      } else {
         int var4 = 0;
         if(var1.getType(var3.west()).getBlock() == Blocks.NETHERRACK) {
            ++var4;
         }

         if(var1.getType(var3.east()).getBlock() == Blocks.NETHERRACK) {
            ++var4;
         }

         if(var1.getType(var3.north()).getBlock() == Blocks.NETHERRACK) {
            ++var4;
         }

         if(var1.getType(var3.south()).getBlock() == Blocks.NETHERRACK) {
            ++var4;
         }

         if(var1.getType(var3.down()).getBlock() == Blocks.NETHERRACK) {
            ++var4;
         }

         int var5 = 0;
         if(var1.isEmpty(var3.west())) {
            ++var5;
         }

         if(var1.isEmpty(var3.east())) {
            ++var5;
         }

         if(var1.isEmpty(var3.north())) {
            ++var5;
         }

         if(var1.isEmpty(var3.south())) {
            ++var5;
         }

         if(var1.isEmpty(var3.down())) {
            ++var5;
         }

         if(!this.b && var4 == 4 && var5 == 1 || var4 == 5) {
            var1.setTypeAndData((BlockPosition)var3, (IBlockData)this.a.getBlockData(), 2);
            var1.a(this.a, var3, var2);
         }

         return true;
      }
   }
}
