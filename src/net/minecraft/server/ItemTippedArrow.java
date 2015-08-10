package net.minecraft.server;

public class ItemTippedArrow extends ItemArrow {

	public EntityArrow createArrowEntity(World world, ItemStack itemstack, EntityLiving entity) {
		return new EntityTippedArrow(world, entity, itemstack);
	}

	public String getLocalizedName(ItemStack var1) {
		return LocaleI18n.get("tipped_arrow.effect." + ((MinecraftKey) RegistryPotions.REGISTRY.getKey(ItemPotion.i(var1))).getName());
	}

}
