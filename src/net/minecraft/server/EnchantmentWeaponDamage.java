package net.minecraft.server;

public class EnchantmentWeaponDamage extends Enchantment {
   private static final String[] e = new String[]{"all", "undead", "arthropods"};
   private static final int[] f = new int[]{1, 5, 5};
   private static final int[] g = new int[]{11, 8, 8};
   private static final int[] h = new int[]{20, 20, 20};
   public final int a;

   public EnchantmentWeaponDamage(Enchantment.EnumMaxEnchant var1, int var2, EnumWearable... var3) {
      super(var1, class_adj.g, var3);
      this.a = var2;
   }

   public int a(int var1) {
      return f[this.a] + (var1 - 1) * g[this.a];
   }

   public int b(int var1) {
      return this.a(var1) + h[this.a];
   }

   public int b() {
      return 5;
   }

   public float a(int var1, class_qf var2) {
      return this.a == 0?(float)var1 * 1.25F:(this.a == 1 && var2 == class_qf.b?(float)var1 * 2.5F:(this.a == 2 && var2 == class_qf.c?(float)var1 * 2.5F:0.0F));
   }

   public String a() {
      return "enchantment.damage." + e[this.a];
   }

   public boolean a(Enchantment var1) {
      return !(var1 instanceof EnchantmentWeaponDamage);
   }

   public boolean a(ItemStack var1) {
      return var1.getItem() instanceof ItemAxe ?true:super.a(var1);
   }

   public void a(EntityLiving var1, Entity var2, int var3) {
      if(var2 instanceof EntityLiving) {
         EntityLiving var4 = (EntityLiving)var2;
         if(this.a == 2 && var4.bz() == class_qf.c) {
            int var5 = 20 + var1.getRandom().nextInt(10 * var3);
            var4.addEffect(new MobEffect(MobEffectList.SLOWER_MOVEMENT, var5, 3));
         }
      }

   }
}
