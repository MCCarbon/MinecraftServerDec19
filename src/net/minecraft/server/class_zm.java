package net.minecraft.server;

public class class_zm extends ItemApple {
   public class_zm(int var1) {
      super(var1, false);
      this.d(1);
   }

   public ItemStack a(ItemStack var1, World var2, EntityLiving var3) {
      super.a(var1, var2, var3);
      return new ItemStack(Items.BOWL);
   }
}
