package net.minecraft.server;

public class ItemTippedArrow extends ItemArrow {
   public EntityArrow a(World var1, ItemStack var2, EntityLiving var3) {
      return new EntityTippedArrow(var1, var3, var2);
   }

   public String getLocalizedName(ItemStack var1) {
      return LocaleI18n.get("tipped_arrow.effect." + ((MinecraftKey) class_acd.a.getKey(ItemPotion.i(var1))).getName());
   }
}
