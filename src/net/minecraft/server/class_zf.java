package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.BlockBed;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.UseResult;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_zf extends Item {
   public class_zf() {
      this.a(CreativeTab.DECORATIONS);
   }

   public UseResult a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var3.isClientSide) {
         return UseResult.SUCCESS;
      } else if(var6 != EnumDirection.UP) {
         return UseResult.CANT_USE;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         boolean var12 = var11.isReplaceable(var3, var4);
         if(!var12) {
            var4 = var4.up();
         }

         int var13 = MathHelper.floor((double)(var2.y * 4.0F / 360.0F) + 0.5D) & 3;
         EnumDirection var14 = EnumDirection.getByHorizontalId(var13);
         BlockPosition var15 = var4.shift(var14);
         if(var2.a(var4, var6, var1) && var2.a(var15, var6, var1)) {
            boolean var16 = var3.getType(var15).getBlock().isReplaceable(var3, var15);
            boolean var17 = var12 || var3.isEmpty(var4);
            boolean var18 = var16 || var3.isEmpty(var15);
            if(var17 && var18 && World.a((IBlockAccess)var3, (BlockPosition)var4.down()) && World.a((IBlockAccess)var3, (BlockPosition)var15.down())) {
               IBlockData var19 = Blocks.BED.getBlockData().set(BlockBed.OCCUPIED, Boolean.valueOf(false)).set(BlockBed.FACING, var14).set(BlockBed.PART, BlockBed.EnumBedPart.FOOT);
               if(var3.setTypeAndData((BlockPosition)var4, (IBlockData)var19, 3)) {
                  IBlockData var20 = var19.set(BlockBed.PART, BlockBed.EnumBedPart.HEAD);
                  var3.setTypeAndData((BlockPosition)var15, (IBlockData)var20, 3);
               }

               --var1.count;
               return UseResult.SUCCESS;
            } else {
               return UseResult.CANT_USE;
            }
         } else {
            return UseResult.CANT_USE;
         }
      }
   }
}
