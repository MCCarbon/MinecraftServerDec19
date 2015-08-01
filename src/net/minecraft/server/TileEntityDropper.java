package net.minecraft.server;


public class TileEntityDropper extends TileEntityDispenser {

	@Override
	public String getName() {
		return hasCustomName() ? a : "container.dropper";
	}

	@Override
	public String getContainerName() {
		return "minecraft:dropper";
	}

}
