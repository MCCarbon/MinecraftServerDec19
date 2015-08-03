package net.minecraft.server;

public class ItemArrow extends Item {
   public ItemArrow() {
      this.registerItemKey(CreativeTab.COMBAT);
   }

   public class_xd a(World var1, ItemStack var2, EntityLiving var3) {
      return new class_xd(var1, var3);
   }
}
