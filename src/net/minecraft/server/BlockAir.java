package net.minecraft.server;


public class BlockAir extends Block {

	protected BlockAir() {
		super(Material.AIR);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public AxisAlignedBB getBoundingBox(World world, BlockPosition position, IBlockData blockdata) {
		return null;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean canCollide(IBlockData blockdata, boolean var2) {
		return false;
	}

	@Override
	public void dropNaturally(World world, BlockPosition position, IBlockData blockdata, float chance, int f) {
	}

	@Override
	public boolean isReplaceable(World world, BlockPosition position) {
		return true;
	}

}
