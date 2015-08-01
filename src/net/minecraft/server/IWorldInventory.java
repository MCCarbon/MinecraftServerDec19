package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.IInventory;

public interface IWorldInventory extends IInventory {

	int[] getSlotsForFace(EnumDirection var1);

	boolean canPlaceItemThroughFace(int var1, ItemStack var2, EnumDirection var3);

	boolean canTakeItemThroughFace(int var1, ItemStack var2, EnumDirection var3);

}
