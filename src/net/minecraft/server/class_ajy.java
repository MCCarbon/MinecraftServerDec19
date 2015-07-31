package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_ahd;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;

public class class_ajy extends class_ahd {
   protected Item o() {
      return Items.bV;
   }

   protected Item p() {
      return Items.bV;
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      super.dropNaturally(var1, var2, var3, var4, var5);
      if(!var1.D) {
         if(this.e(var3) && var1.s.nextInt(50) == 0) {
            a(var1, var2, new ItemStack(Items.bX));
         }

      }
   }
}
