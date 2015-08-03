package net.minecraft.server;


public class BlockCarrots extends BlockCrops {

	@Override
	protected Item getSeedItem() {
		return Items.bU;
	}

	@Override
	protected Item getPlantItem() {
		return Items.bU;
	}

}
