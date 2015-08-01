package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.INamableTileEntity;
import net.minecraft.server.EntityHuman;

public interface IInventory extends INamableTileEntity {

	int getSize();

	ItemStack getItem(int slot);

	ItemStack splitStack(int slot, int count);

	ItemStack splitWithoutUpdate(int slot);

	void setItem(int slot, ItemStack itemstack);

	int getMaxStackSize();

	void update();

	boolean isReachable(EntityHuman player);

	void startOpen(EntityHuman player);

	void closeContainer(EntityHuman player);

	boolean canPlaceItem(int slot, ItemStack itemstack);

	int getProperty(int id);

	void setProperty(int id, int value);

	int getPropertyCount();

	void remove();

}
