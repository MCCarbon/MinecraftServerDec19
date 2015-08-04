package net.minecraft.server;

public class ItemCoal extends Item {
   public ItemCoal() {
      this.registerItemKey(true);
      this.e(0);
      this.registerItemKey(CreativeTab.MATERIALS);
   }

   public String e_(ItemStack var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
