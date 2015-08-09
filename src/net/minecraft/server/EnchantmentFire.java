package net.minecraft.server;

public class EnchantmentFire extends Enchantment {
   protected EnchantmentFire(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.g, var2);
      this.c("fire");
   }

   public int a(int var1) {
      return 10 + 20 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 2;
   }
}
