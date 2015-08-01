package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahl;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_zw extends Item {
   private Block a;

   public class_zw(Block var1) {
      this.a = var1;
      this.a(CreativeTab.REDSTONE);
   }

   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 != EnumDirection.UP) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         if(!var11.isReplaceable(var3, var4)) {
            var4 = var4.shift(var6);
         }

         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!this.a.canPlace(var3, var4)) {
            return class_oq.b;
         } else {
            a(var3, var4, EnumDirection.fromAngle((double)var2.y), this.a);
            --var1.count;
            return class_oq.a;
         }
      }
   }

   public static void a(World var0, BlockPosition var1, EnumDirection var2, Block var3) {
      BlockPosition var4 = var1.shift(var2.rotateY());
      BlockPosition var5 = var1.shift(var2.rotateYCCW());
      int var6 = (var0.getType(var5).getBlock().isOccluding()?1:0) + (var0.getType(var5.up()).getBlock().isOccluding()?1:0);
      int var7 = (var0.getType(var4).getBlock().isOccluding()?1:0) + (var0.getType(var4.up()).getBlock().isOccluding()?1:0);
      boolean var8 = var0.getType(var5).getBlock() == var3 || var0.getType(var5.up()).getBlock() == var3;
      boolean var9 = var0.getType(var4).getBlock() == var3 || var0.getType(var4.up()).getBlock() == var3;
      boolean var10 = false;
      if(var8 && !var9 || var7 > var6) {
         var10 = true;
      }

      BlockPosition var11 = var1.up();
      IBlockData var12 = var3.getBlockData().set(class_ahl.a, var2).set(class_ahl.N, var10?class_ahl.class_b_in_class_ahl.b:class_ahl.class_b_in_class_ahl.a);
      var0.setTypeAndData((BlockPosition)var1, (IBlockData)var12.set(class_ahl.P, class_ahl.class_a_in_class_ahl.b), 2);
      var0.setTypeAndData((BlockPosition)var11, (IBlockData)var12.set(class_ahl.P, class_ahl.class_a_in_class_ahl.a), 2);
      var0.c(var1, var3);
      var0.c(var11, var3);
   }
}
