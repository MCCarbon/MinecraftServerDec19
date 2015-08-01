package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_aky;
import net.minecraft.server.IBlockData;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemBlock;

public class class_abr extends ItemBlock {
   public class_abr(Block var1) {
      super(var1);
      this.e(0);
      this.a(true);
   }

   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var1.count == 0) {
         return class_oq.b;
      } else if(!var2.a(var4, var6, var1)) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         BlockPosition var12 = var4;
         if((var6 != EnumDirection.UP || var11 != this.block) && !var11.isReplaceable(var3, var4)) {
            var12 = var4.shift(var6);
            var10 = var3.getType(var12);
            var11 = var10.getBlock();
         }

         if(var11 == this.block) {
            int var13 = ((Integer)var10.get(class_aky.a)).intValue();
            if(var13 <= 7) {
               IBlockData var14 = var10.set(class_aky.a, Integer.valueOf(var13 + 1));
               AxisAlignedBB var15 = this.block.getBoundingBox(var3, var12, var14);
               if(var15 != null && var3.b(var15) && var3.setTypeAndData((BlockPosition)var12, (IBlockData)var14, 2)) {
                  var3.a((double)((float)var12.getX() + 0.5F), (double)((float)var12.getY() + 0.5F), (double)((float)var12.getZ() + 0.5F), this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getPitch() * 0.8F);
                  --var1.count;
                  return class_oq.a;
               }
            }
         }

         return super.a(var1, var2, var3, var12, var5, var6, var7, var8, var9);
      }
   }

   public int a(int var1) {
      return var1;
   }
}
