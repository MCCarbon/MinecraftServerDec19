package net.minecraft.server;

import java.util.Random;

public class BlockWeb extends Block {

	public BlockWeb() {
		super(Material.WEB);
		setCreativeTab(CreativeTab.DECORATIONS);
	}

	@Override
	public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
		var4.aC();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
		return null;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return Items.H;
	}

	@Override
	protected boolean canApplySilkTouch() {
		return true;
	}

}
