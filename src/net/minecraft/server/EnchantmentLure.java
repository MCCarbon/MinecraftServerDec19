package net.minecraft.server;

public class EnchantmentLure extends Enchantment {
   protected EnchantmentLure(Enchantment.EnumMaxEnchant var1, class_adj var2, EnumWearable... var3) {
      super(var1, var2, var3);
      this.c("fishingSpeed");
   }

   public int a(int var1) {
      return 15 + (var1 - 1) * 9;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }
}
