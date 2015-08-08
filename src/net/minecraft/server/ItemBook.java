package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;

public class ItemBook extends Item {
   public boolean isTool(ItemStack var1) {
      return var1.count == 1;
   }

   public int getItemEnchantability() {
      return 1;
   }
}
