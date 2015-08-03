package net.minecraft.server;

public class ItemSoup extends ItemFood {
   public ItemSoup(int var1) {
      super(var1, false);
      this.d(1);
   }

   public ItemStack registerItemKey(ItemStack var1, World var2, EntityLiving var3) {
      super.registerItemKey(var1, var2, var3);
      return new ItemStack(Items.BOWL);
   }
}
