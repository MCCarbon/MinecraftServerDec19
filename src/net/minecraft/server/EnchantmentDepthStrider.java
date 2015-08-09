package net.minecraft.server;

public class EnchantmentDepthStrider extends Enchantment {
   public EnchantmentDepthStrider(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.c, var2);
      this.c("waterWalker");
   }

   public int a(int var1) {
      return var1 * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 15;
   }

   public int b() {
      return 3;
   }
}
