package net.minecraft.server;

public class EnchantmentArrowDamage extends Enchantment {
   public EnchantmentArrowDamage(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.k, var2);
      this.c("arrowDamage");
   }

   public int a(int var1) {
      return 1 + (var1 - 1) * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 15;
   }

   public int b() {
      return 5;
   }
}
