package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ale;
import net.minecraft.server.class_alw;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amx;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.ItemBlock;
import net.minecraft.server.CreativeTab;

public class class_abn extends Item {
   public class_abn() {
      this.h = 16;
      this.a(CreativeTab.c);
   }

   public class_oq a(ItemStack var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return class_oq.b;
      } else if(!var3.p(var4).getBlock().getMaterial().isBuildable()) {
         return class_oq.b;
      } else {
         var4 = var4.shift(var6);
         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!Blocks.STANDING_SIGN.d(var3, var4)) {
            return class_oq.b;
         } else if(var3.D) {
            return class_oq.a;
         } else {
            if(var6 == EnumDirection.UP) {
               int var10 = MathHelper.floor((double)((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.a((BlockPosition)var4, (IBlockData)Blocks.STANDING_SIGN.getBlockData().set(class_ale.a, Integer.valueOf(var10)), 3);
            } else {
               var3.a((BlockPosition)var4, (IBlockData)Blocks.WALL_SIGN.getBlockData().set(class_alw.a, var6), 3);
            }

            --var1.count;
            class_amg var11 = var3.s(var4);
            if(var11 instanceof class_amx && !ItemBlock.a(var3, var2, var4, var1)) {
               var2.a((class_amx)var11);
            }

            return class_oq.a;
         }
      }
   }
}
