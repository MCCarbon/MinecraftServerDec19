package net.minecraft.server;

import java.util.Random;

public class EnchantmentThorns extends Enchantment {
   public EnchantmentThorns(Enchantment.EnumMaxEnchant var1, EnumWearable... var2) {
      super(var1, class_adj.e, var2);
      this.c("thorns");
   }

   public int a(int var1) {
      return 10 + 20 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(ItemStack var1) {
      return var1.getItem() instanceof ItemArmor ?true:super.a(var1);
   }

   public void b(EntityLiving var1, Entity var2, int var3) {
      Random var4 = var1.getRandom();
      ItemStack var5 = EnchantmentManager.b(RegistryEnchantments.h, var1);
      if(a(var3, var4)) {
         if(var2 != null) {
            var2.damageEntity(DamageSource.a((Entity) var1), (float)b(var3, var4));
            var2.makeSound("damage.thorns", 0.5F, 1.0F);
         }

         if(var5 != null) {
            var5.a(3, (EntityLiving)var1);
         }
      } else if(var5 != null) {
         var5.a(1, (EntityLiving)var1);
      }

   }

   public static boolean a(int var0, Random var1) {
      return var0 <= 0?false:var1.nextFloat() < 0.15F * (float)var0;
   }

   public static int b(int var0, Random var1) {
      return var0 > 10?var0 - 10:1 + var1.nextInt(4);
   }
}
