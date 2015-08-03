package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.CreativeTab;

public class class_zr extends Item {
   public class_zr() {
      this.a(true);
      this.e(0);
      this.a(CreativeTab.MATERIALS);
   }

   public String e_(ItemStack var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
