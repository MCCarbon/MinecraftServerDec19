package net.minecraft.server;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class Enchantment {
   public static final RegistryMaterials<MinecraftKey, Enchantment> b = new RegistryMaterials<MinecraftKey, Enchantment>();
   private final EnumWearable[] a;
   private final Enchantment.EnumMaxEnchant e;
   public class_adj c;
   protected String d;

   public static Enchantment c(int var0) {
      return (Enchantment)b.get(var0);
   }

   public static int b(Enchantment var0) {
      return b.getId(var0);
   }

   public static Enchantment b(String var0) {
      return (Enchantment)b.get(new MinecraftKey(var0));
   }

   protected Enchantment(Enchantment.EnumMaxEnchant var1, class_adj var2, EnumWearable[] var3) {
      this.e = var1;
      this.c = var2;
      this.a = var3;
   }

   public Iterable<?> a(EntityLiving var1) {
      List<ItemStack> var2 = Lists.newArrayList();
      EnumWearable[] var3 = this.a;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumWearable var6 = var3[var5];
         ItemStack var7 = var1.a(var6);
         if(var7 != null) {
            var2.add(var7);
         }
      }

      return var2.size() > 0?var2:null;
   }

   public Enchantment.EnumMaxEnchant c() {
      return this.e;
   }

   public int d() {
      return 1;
   }

   public int b() {
      return 1;
   }

   public int a(int var1) {
      return 1 + var1 * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 5;
   }

   public int a(int var1, DamageSource var2) {
      return 0;
   }

   public float a(int var1, class_qf var2) {
      return 0.0F;
   }

   public boolean a(Enchantment var1) {
      return this != var1;
   }

   public Enchantment c(String var1) {
      this.d = var1;
      return this;
   }

   public String a() {
      return "enchantment." + this.d;
   }

   public String d(int var1) {
      String var2 = LocaleI18n.get(this.a());
      return var2 + " " + LocaleI18n.get("enchantment.level." + var1);
   }

   public boolean a(ItemStack var1) {
      return this.c.a(var1.getItem());
   }

   public void a(EntityLiving var1, Entity var2, int var3) {
   }

   public void b(EntityLiving var1, Entity var2, int var3) {
   }

   public static void e() {
      b.register(0, new MinecraftKey("protection"), new EnchantmentProtection(EnumMaxEnchant.a, EnchantmentProtection.class_a_in_class_ads.a, EnumWearable.values()));
      b.register(1, new MinecraftKey("fire_protection"), new EnchantmentProtection(EnumMaxEnchant.b, EnchantmentProtection.class_a_in_class_ads.b, EnumWearable.values()));
      b.register(2, new MinecraftKey("feather_falling"), new EnchantmentProtection(EnumMaxEnchant.b, EnchantmentProtection.class_a_in_class_ads.c, EnumWearable.values()));
      b.register(3, new MinecraftKey("blast_protection"), new EnchantmentProtection(EnumMaxEnchant.c, EnchantmentProtection.class_a_in_class_ads.d, EnumWearable.values()));
      b.register(4, new MinecraftKey("projectile_protection"), new EnchantmentProtection(EnumMaxEnchant.b, EnchantmentProtection.class_a_in_class_ads.e, EnumWearable.values()));
      b.register(5, new MinecraftKey("respiration"), new EnchantmentOxygen(EnumMaxEnchant.c, EnumWearable.values()));
      b.register(6, new MinecraftKey("aqua_affinity"), new EnchantmentWaterWprler(EnumMaxEnchant.c, EnumWearable.values()));
      b.register(7, new MinecraftKey("thorns"), new EnchantmentThorns(EnumMaxEnchant.d, EnumWearable.values()));
      b.register(8, new MinecraftKey("depth_strider"), new EnchantmentDepthStrider(EnumMaxEnchant.c, EnumWearable.values()));
      b.register(16, new MinecraftKey("sharpness"), new EnchantmentWeaponDamage(EnumMaxEnchant.a, 0, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(17, new MinecraftKey("smite"), new EnchantmentWeaponDamage(EnumMaxEnchant.b, 1, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(18, new MinecraftKey("bane_of_arthropods"), new EnchantmentWeaponDamage(EnumMaxEnchant.b, 2, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(19, new MinecraftKey("knockback"), new EnchantmentKnockback(EnumMaxEnchant.b, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(20, new MinecraftKey("fire_aspect"), new EnchantmentFire(EnumMaxEnchant.c, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(21, new MinecraftKey("looting"), new EnchantmentLootBonus(EnumMaxEnchant.c, class_adj.g, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(32, new MinecraftKey("efficiency"), new EnchantmentDigging(EnumMaxEnchant.a, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(33, new MinecraftKey("silk_touch"), new EnchantmentSilkTouch(EnumMaxEnchant.d, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(34, new MinecraftKey("unbreaking"), new EnchantmentDurability(EnumMaxEnchant.b, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(35, new MinecraftKey("fortune"), new EnchantmentLootBonus(EnumMaxEnchant.c, class_adj.h, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(48, new MinecraftKey("power"), new EnchantmentArrowDamage(EnumMaxEnchant.a, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(49, new MinecraftKey("punch"), new EnchantmentArrowKnockback(EnumMaxEnchant.c, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(50, new MinecraftKey("flame"), new EnchantmentFlameArrows(EnumMaxEnchant.c, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(51, new MinecraftKey("infinity"), new EnchantmentInfiniteArrows(EnumMaxEnchant.d, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(61, new MinecraftKey("luck_of_the_sea"), new EnchantmentLootBonus(EnumMaxEnchant.c, class_adj.i, new EnumWearable[]{EnumWearable.MAINHAND}));
      b.register(62, new MinecraftKey("lure"), new EnchantmentLure(EnumMaxEnchant.c, class_adj.i, new EnumWearable[]{EnumWearable.MAINHAND}));
   }

   public static enum EnumMaxEnchant {
      a(10),
      b(5),
      c(2),
      d(1);

      private final int e;

      private EnumMaxEnchant(int var3) {
         this.e = var3;
      }

      public int a() {
         return this.e;
      }
   }
}
