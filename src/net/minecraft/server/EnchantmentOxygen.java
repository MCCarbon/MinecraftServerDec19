package net.minecraft.server;

public class EnchantmentOxygen extends Enchantment {
   public EnchantmentOxygen(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.f, var2);
      this.c("oxygen");
   }

   public int a(int var1) {
      return 10 * var1;
   }

   public int b(int var1) {
      return this.a(var1) + 30;
   }

   public int b() {
      return 3;
   }
}
