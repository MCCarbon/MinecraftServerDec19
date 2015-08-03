package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_abh extends Item {
   public class_abh() {
      this.a(CreativeTab.REDSTONE);
   }

   public class_oq a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      boolean var10 = var3.getType(var4).getBlock().isReplaceable(var3, var4);
      BlockPosition var11 = var10?var4:var4.shift(var6);
      if(!var2.a(var11, var6, var1)) {
         return class_oq.b;
      } else {
         Block var12 = var3.getType(var11).getBlock();
         if(!var3.a(var12, var11, false, var6, (Entity)null, var1)) {
            return class_oq.b;
         } else if(BlockStainedGlassPane.REDSTONE_WIRE.canPlace(var3, var11)) {
            --var1.count;
            var3.setTypeUpdate(var11, BlockStainedGlassPane.REDSTONE_WIRE.getBlockData());
            return class_oq.a;
         } else {
            return class_oq.b;
         }
      }
   }
}
