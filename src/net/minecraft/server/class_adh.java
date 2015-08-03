package net.minecraft.server;

public class class_adh extends class_adi {
   protected class_adh(class_adi.class_a_in_class_adi var1, class_pw... var2) {
      super(var1, class_adj.h, var2);
      this.c("digging");
   }

   public int a(int var1) {
      return 1 + 10 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 5;
   }

   public boolean a(ItemStack var1) {
      return var1.getItem() == Items.SHEARS ?true:super.a(var1);
   }
}
