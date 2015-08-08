package net.minecraft.server;

public class ItemSpectralArrow extends ItemArrow {

	@Override
	public EntityArrow createArrowEntity(World world, ItemStack itemstack, EntityLiving entity) {
		return new EntitySpectralArrow(world, entity);
	}

}
