package net.minecraft.server;


public class TileEntityLightDetector extends TileEntity implements ITickAble {

	@Override
	public void tick() {
		if ((world != null) && !world.isClientSide && ((world.L() % 20L) == 0L)) {
			block = getBlock();
			if (block instanceof BlockDaylightDetector) {
				((BlockDaylightDetector) block).f(world, position);
			}
		}

	}
}
