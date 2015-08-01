package net.minecraft.server;

public class SourceBlock implements ISourceBlock {

	private final World world;
	private final BlockPosition position;

	public SourceBlock(World world, BlockPosition position) {
		this.world = world;
		this.position = position;
	}

	@Override
	public World getWorld() {
		return world;
	}

	@Override
	public double getX() {
		return position.getX() + 0.5D;
	}

	@Override
	public double getY() {
		return position.getY() + 0.5D;
	}

	@Override
	public double getZ() {
		return position.getZ() + 0.5D;
	}

	@Override
	public BlockPosition getPosition() {
		return position;
	}

	@Override
	public int getData() {
		IBlockData blockdata = world.getType(position);
		return blockdata.getBlock().toLegacyData(blockdata);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends TileEntity> T getTileEntity() {
		return (T) world.getTileEntity(position);
	}

}
