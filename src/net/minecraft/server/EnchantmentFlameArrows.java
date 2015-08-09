package net.minecraft.server;

public class EnchantmentFlameArrows extends Enchantment {
   public EnchantmentFlameArrows(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.k, var2);
      this.c("arrowFire");
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
