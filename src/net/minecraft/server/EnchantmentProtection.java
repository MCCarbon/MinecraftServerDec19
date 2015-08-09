package net.minecraft.server;

public class EnchantmentProtection extends Enchantment {
   public final EnchantmentProtection.class_a_in_class_ads a;

   public EnchantmentProtection(Enchantment.EnumMaxEnchant var1, EnchantmentProtection.class_a_in_class_ads var2, EnumWearable... var3) {
      super(var1, class_adj.b, var3);
      this.a = var2;
      if(var2 == EnchantmentProtection.class_a_in_class_ads.c) {
         this.c = class_adj.c;
      }

   }

   public int a(int var1) {
      return this.a.b() + (var1 - 1) * this.a.c();
   }

   public int b(int var1) {
      return this.a(var1) + this.a.c();
   }

   public int b() {
      return 4;
   }

   public int a(int var1, DamageSource var2) {
      if(var2.g()) {
         return 0;
      } else {
         float var3 = (float)(6 + var1 * var1) / 3.0F;
         return this.a == EnchantmentProtection.class_a_in_class_ads.a?MathHelper.floor(var3 * 0.75F):(this.a == EnchantmentProtection.class_a_in_class_ads.b && var2.o()?MathHelper.floor(var3 * 1.25F):(this.a == EnchantmentProtection.class_a_in_class_ads.c && var2 == DamageSource.i?MathHelper.floor(var3 * 2.5F):(this.a == EnchantmentProtection.class_a_in_class_ads.d && var2.c()?MathHelper.floor(var3 * 1.5F):(this.a == EnchantmentProtection.class_a_in_class_ads.e && var2.a()?MathHelper.floor(var3 * 1.5F):0))));
      }
   }

   public String a() {
      return "enchantment.protect." + this.a.a();
   }

   public boolean a(Enchantment var1) {
      if(var1 instanceof EnchantmentProtection) {
         EnchantmentProtection var2 = (EnchantmentProtection)var1;
         return this.a == var2.a?false:this.a == EnchantmentProtection.class_a_in_class_ads.c || var2.a == EnchantmentProtection.class_a_in_class_ads.c;
      } else {
         return super.a(var1);
      }
   }

   public static int a(EntityLiving var0, int var1) {
      int var2 = EnchantmentManager.a(RegistryEnchantments.b, var0);
      if(var2 > 0) {
         var1 -= MathHelper.floor((float)var1 * (float)var2 * 0.15F);
      }

      return var1;
   }

   public static double a(EntityLiving var0, double var1) {
      int var3 = EnchantmentManager.a(RegistryEnchantments.d, var0);
      if(var3 > 0) {
         var1 -= (double)MathHelper.floor(var1 * (double)((float)var3 * 0.15F));
      }

      return var1;
   }

   public static enum class_a_in_class_ads {
      a("all", 1, 11, 20),
      b("fire", 10, 8, 12),
      c("fall", 5, 6, 10),
      d("explosion", 5, 8, 12),
      e("projectile", 3, 6, 15);

      private final String f;
      private final int g;
      private final int h;
      private final int i;

      private class_a_in_class_ads(String var3, int var4, int var5, int var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
      }

      public String a() {
         return this.f;
      }

      public int b() {
         return this.g;
      }

      public int c() {
         return this.h;
      }
   }
}
