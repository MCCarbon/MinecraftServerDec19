package net.minecraft.server;

public class ItemCoal extends Item {
   public ItemCoal() {
      this.setUsesData(true);
      this.setMaxDurability(0);
      this.setCreativeTab(CreativeTab.MATERIALS);
   }

   public String getName(ItemStack var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
