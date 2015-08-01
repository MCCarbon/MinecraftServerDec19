package net.minecraft.server;

import java.util.Random;

public class BlockEndGateway extends BlockContainer {

	protected BlockEndGateway(Material material) {
		super(material);
		setLightLevel(1.0F);
	}

	@Override
	public TileEntity createTileEntity(World world, int var2) {
		return new TileEntityEndGateway();
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
	public boolean isFullCube() {
		return false;
	}

	@Override
	public int getDropCount(Random rnd) {
		return 0;
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData blockdata) {
		return MaterialMapColor.COLOR30;
	}

}
