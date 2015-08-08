package net.minecraft.server;

import com.google.common.collect.Multimap;

public class ItemSword extends Item {
   private float a;
   private final EnumToolMaterial b;

   public ItemSword(EnumToolMaterial var1) {
      this.b = var1;
      this.maxStackSize = 1;
      this.setMaxDurability(var1.getMaxUses());
      this.setCreativeTab(CreativeTab.COMBAT);
      this.a = 4.0F + var1.getEntityDamage();
   }

   public float g() {
      return this.b.getEntityDamage();
   }

   public float getDestroySpeed(ItemStack var1, Block var2) {
      if(var2 == Blocks.WEB) {
         return 15.0F;
      } else {
         Material var3 = var2.getMaterial();
         return var3 != Material.PLANT && var3 != Material.REPLACEABLE_PLANT && var3 != Material.CORAL && var3 != Material.LEAVES && var3 != Material.PUMPKIN?1.0F:1.5F;
      }
   }

   public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      var1.a(1, (EntityLiving)var3);
      return true;
   }

   public boolean onBlockDestroyed(ItemStack var1, World var2, Block var3, BlockPosition var4, EntityLiving var5) {
      if((double)var3.getStrength(var2, var4) != 0.0D) {
         var1.a(2, (EntityLiving)var5);
      }

      return true;
   }

   public EnumAnimation getAnimation(ItemStack var1) {
      return EnumAnimation.BLOCK;
   }

   public int getUseDuration(ItemStack var1) {
      return 72000;
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      var3.c(var4);
      return new UseResultWithValue(UseResult.SUCCESS, var1);
   }

   public boolean canDestroySpecialBlock(Block var1) {
      return var1 == Blocks.WEB;
   }

   public int getItemEnchantability() {
      return this.b.getEnchantability();
   }

   public String h() {
      return this.b.toString();
   }

   public boolean canRepairWith(ItemStack var1, ItemStack var2) {
      return this.b.getRepairResource() == var2.getItem()?true:super.canRepairWith(var1, var2);
   }

   public Multimap getAttributeModifiers(EnumWearable var1) {
      Multimap var2 = super.getAttributeModifiers(var1);
      if(var1 == EnumWearable.MAINHAND) {
         var2.put(class_wl.e.a(), new class_qm(uuid, "Weapon modifier", (double)this.a, 0));
      }

      return var2;
   }
}
