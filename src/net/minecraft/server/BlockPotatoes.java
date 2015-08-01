package net.minecraft.server;


public class BlockPotatoes extends BlockCrops {

	@Override
	protected Item getSeedItem() {
		return Items.bV;
	}

	@Override
	protected Item getPlantItem() {
		return Items.bV;
	}

	@Override
	public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
		super.dropNaturally(var1, var2, var3, var4, var5);
		if (!var1.isClientSide) {
			if (this.e(var3) && (var1.random.nextInt(50) == 0)) {
				dropItem(var1, var2, new ItemStack(Items.bX));
			}

		}
	}

}
