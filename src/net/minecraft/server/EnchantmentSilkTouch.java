package net.minecraft.server;

public class EnchantmentSilkTouch extends Enchantment {
   protected EnchantmentSilkTouch(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
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

   public boolean a(Enchantment var1) {
      return super.a(var1) && var1 != RegistryEnchantments.s;
   }

   public boolean a(ItemStack var1) {
      return var1.getItem() == Items.SHEARS ?true:super.a(var1);
   }
}
