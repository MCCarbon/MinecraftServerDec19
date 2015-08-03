package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.UseResult;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_aah extends Item {
   public class_aah() {
      this.a(CreativeTab.MISC);
   }

   public UseResult a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var3.isClientSide) {
         return UseResult.SUCCESS;
      } else {
         var4 = var4.shift(var6);
         if(!var2.a(var4, var6, var1)) {
            return UseResult.CANT_USE;
         } else {
            if(var3.getType(var4).getBlock().getMaterial() == Material.AIR) {
               var3.a((double)var4.getX() + 0.5D, (double)var4.getY() + 0.5D, (double)var4.getZ() + 0.5D, "item.fireCharge.use", 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
               var3.setTypeUpdate(var4, Blocks.FIRE.getBlockData());
            }

            if(!var2.abilities.instabuild) {
               --var1.count;
            }

            return UseResult.SUCCESS;
         }
      }
   }
}
