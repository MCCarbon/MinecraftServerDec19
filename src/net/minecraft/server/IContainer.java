package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.TileEntity;

public interface IContainer {

	TileEntity createTileEntity(World var1, int var2);

}
