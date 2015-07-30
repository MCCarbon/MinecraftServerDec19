package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agh;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_zf extends Item {
   public class_zf() {
      this.a(CreativeTab.c);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var3.D) {
         return class_oq.a;
      } else if(var6 != EnumDirection.UP) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.p(var4);
         Block var11 = var10.getBlock();
         boolean var12 = var11.isReplaceable(var3, var4);
         if(!var12) {
            var4 = var4.shiftUp();
         }

         int var13 = MathHelper.floor((double)(var2.y * 4.0F / 360.0F) + 0.5D) & 3;
         EnumDirection var14 = EnumDirection.getByHorizontalId(var13);
         BlockPosition var15 = var4.shift(var14);
         if(var2.a(var4, var6, var1) && var2.a(var15, var6, var1)) {
            boolean var16 = var3.p(var15).getBlock().isReplaceable(var3, var15);
            boolean var17 = var12 || var3.d(var4);
            boolean var18 = var16 || var3.d(var15);
            if(var17 && var18 && World.a((class_aer)var3, (BlockPosition)var4.shiftDown()) && World.a((class_aer)var3, (BlockPosition)var15.shiftDown())) {
               IBlockData var19 = Blocks.BED.getBlockData().set(class_agh.b, Boolean.valueOf(false)).set(class_agh.O, var14).set(class_agh.a, class_agh.class_a_in_class_agh.b);
               if(var3.a((BlockPosition)var4, (IBlockData)var19, 3)) {
                  IBlockData var20 = var19.set(class_agh.a, class_agh.class_a_in_class_agh.a);
                  var3.a((BlockPosition)var15, (IBlockData)var20, 3);
               }

               --var1.b;
               return class_oq.a;
            } else {
               return class_oq.b;
            }
         } else {
            return class_oq.b;
         }
      }
   }
}
