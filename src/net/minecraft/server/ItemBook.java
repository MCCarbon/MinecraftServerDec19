package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;

public class ItemBook extends Item {
   public boolean f_(ItemStack var1) {
      return var1.count == 1;
   }

   public int c() {
      return 1;
   }
}
