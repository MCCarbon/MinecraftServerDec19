package net.minecraft.server;


public interface ITileInventory extends IInventory, ITileEntityContainer {

	boolean isLocked();

	void setChestLock(ChestLock var1);

	ChestLock getChestLock();

}
