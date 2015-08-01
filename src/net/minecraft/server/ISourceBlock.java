package net.minecraft.server;

import net.minecraft.server.TileEntity;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.ILocationSource;

public interface ISourceBlock extends ILocationSource {

	double getX();

	double getY();

	double getZ();

	BlockPosition getPosition();

	int getData();

	<T extends TileEntity> T getTileEntity();

}
