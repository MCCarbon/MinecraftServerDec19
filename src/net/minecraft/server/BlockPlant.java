package net.minecraft.server;

import java.util.Random;

public class BlockPlant extends Block {

	protected BlockPlant() {
		this(Material.PLANT);
	}

	protected BlockPlant(Material var1) {
		this(var1, var1.getMapColor());
	}

	protected BlockPlant(Material var1, MaterialMapColor var2) {
		super(var1, var2);
		setTicking(true);
		float var3 = 0.2F;
		setSizes(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
		setCreativeTab(CreativeTab.DECORATIONS);
	}

	@Override
	public boolean canPlace(World var1, BlockPosition var2) {
		return super.canPlace(var1, var2) && c(var1.getType(var2.down()).getBlock());
	}

	protected boolean c(Block var1) {
		return (var1 == Blocks.GRASS) || (var1 == Blocks.DIRT) || (var1 == Blocks.FARMLAND);
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		super.doPhysics(var1, var2, var3, var4);
		e(var1, var2, var3);
	}

	@Override
	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		e(var1, var2, var3);
	}

	protected void e(World var1, BlockPosition var2, IBlockData var3) {
		if (!f(var1, var2, var3)) {
			dropNaturallyForSure(var1, var2, var3, 0);
			var1.setTypeAndData(var2, Blocks.AIR.getBlockData(), 3);
		}

	}

	public boolean f(World var1, BlockPosition var2, IBlockData var3) {
		return c(var1.getType(var2.down()).getBlock());
	}

	@Override
	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
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

}
