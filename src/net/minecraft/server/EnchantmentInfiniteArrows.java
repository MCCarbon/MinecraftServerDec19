package net.minecraft.server;

public class EnchantmentInfiniteArrows extends Enchantment {
   public EnchantmentInfiniteArrows(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.k, var2);
      this.c("arrowInfinite");
   }

   public int a(int var1) {
      return 20;
   }

   public int b(int var1) {
      return 50;
   }

   public int b() {
      return 1;
   }
}
