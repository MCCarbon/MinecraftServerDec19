package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aam extends Item {
   public class_aam() {
      this.h = 1;
      this.e(64);
      this.a(CreativeTab.i);
   }

   public class_oq a(ItemStack var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      var4 = var4.shift(var6);
      if(!var2.a(var4, var6, var1)) {
         return class_oq.b;
      } else {
         if(var3.p(var4).getBlock().getMaterial() == Material.AIR) {
            var3.a((double)var4.getX() + 0.5D, (double)var4.getY() + 0.5D, (double)var4.getZ() + 0.5D, "fire.ignite", 1.0F, random.nextFloat() * 0.4F + 0.8F);
            var3.a(var4, Blocks.FIRE.getBlockData());
         }

         var1.a(1, (class_qa)var2);
         return class_oq.a;
      }
   }
}
