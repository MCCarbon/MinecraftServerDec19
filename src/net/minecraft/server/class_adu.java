package net.minecraft.server;

public class class_adu extends class_adi {
   protected class_adu(class_adi.class_a_in_class_adi var1, EnumWearable... var2) {
      super(var1, class_adj.h, var2);
      this.c("untouching");
   }

   public int a(int var1) {
      return 15;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 1;
   }

   public boolean a(class_adi var1) {
      return super.a(var1) && var1 != Enchantment.s;
   }

   public boolean a(ItemStack var1) {
      return var1.getItem() == Items.SHEARS ?true:super.a(var1);
   }
}
