package net.minecraft.server;

public class class_zr extends Item {
   public class_zr() {
      this.registerItemKey(true);
      this.e(0);
      this.registerItemKey(CreativeTab.MATERIALS);
   }

   public String e_(ItemStack var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
