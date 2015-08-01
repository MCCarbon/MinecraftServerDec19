package net.minecraft.server;

import java.util.Random;

public class BlockGlass extends BlockHalfTransparent {

	public BlockGlass(Material material, boolean var2) {
		super(material, var2);
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public int getDropCount(Random var1) {
		return 0;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	protected boolean canApplySilkTouch() {
		return true;
	}

}
