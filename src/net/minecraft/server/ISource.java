package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.IPosition;

public interface ISource extends IPosition {
   World getWorld();
}
