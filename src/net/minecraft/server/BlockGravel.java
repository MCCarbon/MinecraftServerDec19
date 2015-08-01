package net.minecraft.server;

import java.util.Random;

public class BlockGravel extends BlockFalling {

	@Override
	public Item getDropType(IBlockData blockd, Random rnd, int fortune) {
		if (fortune > 3) {
			fortune = 3;
		}
		return rnd.nextInt(10 - (fortune * 3)) == 0 ? Items.am : Item.getByBlock(this);
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData var1) {
		return MaterialMapColor.COLOR12;
	}

}
