package net.minecraft.server;

public class EnchantmentWaterWprler extends Enchantment {
   public EnchantmentWaterWprler(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.f, var2);
      this.c("waterWorker");
   }

   public int a(int var1) {
      return 1;
   }

   public int b(int var1) {
      return this.a(var1) + 40;
   }

   public int b() {
      return 1;
   }
}
