package net.minecraft.server;

import net.minecraft.server.IChatBaseComponent;

public interface INamableTileEntity {

	String getName();

	boolean hasCustomName();

	IChatBaseComponent getScoreboardDisplayName();

}
