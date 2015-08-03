package net.minecraft.server;


public class BlockCarrots extends BlockCrops {

	@Override
	protected Item getSeedItem() {
		return Items.CARROT;
	}

	@Override
	protected Item getPlantItem() {
		return Items.CARROT;
	}

}
