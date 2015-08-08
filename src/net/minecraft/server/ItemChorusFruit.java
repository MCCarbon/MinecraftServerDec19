package net.minecraft.server;

public class ItemChorusFruit extends ItemFood {

	public ItemChorusFruit(int var1, float var2) {
		super(var1, var2, false);
	}

	@Override
	public ItemStack onUseFinish(ItemStack itemstack, World world, EntityLiving player) {
		ItemStack var4 = super.onUseFinish(itemstack, world, player);

		for (int var5 = 0; var5 < 16; ++var5) {
			double var6 = player.locX + ((player.getRandom().nextDouble() - 0.5D) * 64.0D);
			double var8 = player.locY + (player.getRandom().nextInt(64) - 32);
			double var10 = player.locZ + ((player.getRandom().nextDouble() - 0.5D) * 64.0D);
			if (EntityEnderman.attemptTeleportTo(player, var6, var8, var10)) {
				break;
			}
		}

		return var4;
	}

}
