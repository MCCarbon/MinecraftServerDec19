package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityChest;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_od;
import net.minecraft.server.IInventory;

public class class_aqa extends class_aql {
   private final List a;
   private final int b;

   public class_aqa(List var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      Block var4;
      while(((var4 = var1.getType(var3).getBlock()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.getY() > 1) {
         var3 = var3.down();
      }

      if(var3.getY() < 1) {
         return false;
      } else {
         var3 = var3.up();

         for(int var5 = 0; var5 < 4; ++var5) {
            BlockPosition var6 = var3.add(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
            if(var1.isEmpty(var6) && World.a((IBlockAccess)var1, (BlockPosition)var6.down())) {
               var1.setTypeAndData((BlockPosition)var6, (IBlockData)Blocks.CHEST.getBlockData(), 2);
               TileEntity var7 = var1.getTileEntity(var6);
               if(var7 instanceof TileEntityChest) {
                  class_od.a(var2, this.a, (IInventory)((TileEntityChest)var7), this.b);
               }

               BlockPosition var8 = var6.east();
               BlockPosition var9 = var6.west();
               BlockPosition var10 = var6.north();
               BlockPosition var11 = var6.south();
               if(var1.isEmpty(var9) && World.a((IBlockAccess)var1, (BlockPosition)var9.down())) {
                  var1.setTypeAndData((BlockPosition)var9, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.isEmpty(var8) && World.a((IBlockAccess)var1, (BlockPosition)var8.down())) {
                  var1.setTypeAndData((BlockPosition)var8, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.isEmpty(var10) && World.a((IBlockAccess)var1, (BlockPosition)var10.down())) {
                  var1.setTypeAndData((BlockPosition)var10, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.isEmpty(var11) && World.a((IBlockAccess)var1, (BlockPosition)var11.down())) {
                  var1.setTypeAndData((BlockPosition)var11, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
