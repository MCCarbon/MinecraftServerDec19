package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.CreativeTab;

public class ItemCoal extends Item {
   public ItemCoal() {
      this.a(true);
      this.e(0);
      this.a(CreativeTab.MATERIALS);
   }

   public String e_(ItemStack var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
