package net.minecraft.server;


public interface ITileEntityContainer extends INamableTileEntity {

	Container createContainer(PlayerInventory inventory, EntityHuman player);

	String getContainerName();

}
