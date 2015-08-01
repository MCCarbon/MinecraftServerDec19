package net.minecraft.server;

import java.util.Random;

public class BlockBeetroots extends BlockCrops {

	public static final BlockStateInteger AGE = BlockStateInteger.of("age", 0, 3);

	@Override
	protected BlockStateInteger l() {
		return AGE;
	}

	@Override
	public int n() {
		return 3;
	}

	@Override
	protected Item getSeedItem() {
		return Items.cK;
	}

	@Override
	protected Item getPlantItem() {
		return Items.cL;
	}

	@Override
	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		if (var4.nextInt(3) == 0) {
			this.e(var1, var2, var3);
		} else {
			super.tick(var1, var2, var3, var4);
		}

	}

	@Override
	protected int b(World var1) {
		return super.b(var1) / 3;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { AGE });
	}

}
