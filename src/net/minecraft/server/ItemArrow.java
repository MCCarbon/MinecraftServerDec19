package net.minecraft.server;

public class ItemArrow extends Item {

	public ItemArrow() {
		this.setCreativeTab(CreativeTab.COMBAT);
	}

	public EntityArrow createArrowEntity(World var1, ItemStack var2, EntityLiving var3) {
		return new EntityArrow(var1, var3);
	}

}
