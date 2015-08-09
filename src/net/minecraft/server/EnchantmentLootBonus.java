package net.minecraft.server;

public class EnchantmentLootBonus extends Enchantment {
   protected EnchantmentLootBonus(Enchantment.EnumMaxEnchant var1, class_adj var2, EnumWearable... var3) {
      super(var1, var2, var3);
      if(var2 == class_adj.h) {
         this.c("lootBonusDigger");
      } else if(var2 == class_adj.i) {
         this.c("lootBonusFishing");
      } else {
         this.c("lootBonus");
      }

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

   public boolean a(Enchantment var1) {
      return super.a(var1) && var1 != RegistryEnchantments.q;
   }
}
