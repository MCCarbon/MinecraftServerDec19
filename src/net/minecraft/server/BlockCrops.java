package net.minecraft.server;

import java.util.Random;

public class BlockCrops extends BlockPlant implements IBlockFragilePlantElement {

	public static final BlockStateInteger AGE = BlockStateInteger.of("age", 0, 7);

	protected BlockCrops() {
		setBlockData(blockStateList.getFirst().set(l(), Integer.valueOf(0)));
		setTicking(true);
		float var1 = 0.5F;
		setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
		setCreativeTab((CreativeTab) null);
		setStrength(0.0F);
		setStepSound(STEP_SOUND_GRASS);
		disableBreakStat();
	}

	@Override
	protected boolean c(Block var1) {
		return var1 == Blocks.FARMLAND;
	}

	protected BlockStateInteger l() {
		return AGE;
	}

	public int n() {
		return 7;
	}

	protected int d(IBlockData var1) {
		return var1.get(l()).intValue();
	}

	public IBlockData b(int var1) {
		return getBlockData().set(l(), Integer.valueOf(var1));
	}

	public boolean e(IBlockData var1) {
		return var1.get(l()).intValue() >= n();
	}

	@Override
	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		super.tick(var1, var2, var3, var4);
		if (var1.l(var2.up()) >= 9) {
			int var5 = d(var3);
			if (var5 < n()) {
				float var6 = a(this, var1, var2);
				if (var4.nextInt((int) (25.0F / var6) + 1) == 0) {
					var1.setTypeAndData(var2, this.b(var5 + 1), 2);
				}
			}
		}

	}

	public void g(World var1, BlockPosition var2, IBlockData var3) {
		int var4 = d(var3) + this.b(var1);
		int var5 = n();
		if (var4 > var5) {
			var4 = var5;
		}

		var1.setTypeAndData(var2, this.b(var4), 2);
	}

	protected int b(World var1) {
		return MathHelper.getRandomIntInRange(var1.random, 2, 5);
	}

	protected static float a(Block var0, World var1, BlockPosition var2) {
		float var3 = 1.0F;
		BlockPosition var4 = var2.down();

		for (int var5 = -1; var5 <= 1; ++var5) {
			for (int var6 = -1; var6 <= 1; ++var6) {
				float var7 = 0.0F;
				IBlockData var8 = var1.getType(var4.add(var5, 0, var6));
				if (var8.getBlock() == Blocks.FARMLAND) {
					var7 = 1.0F;
					if (var8.get(class_ahy.a).intValue() > 0) {
						var7 = 3.0F;
					}
				}

				if ((var5 != 0) || (var6 != 0)) {
					var7 /= 4.0F;
				}

				var3 += var7;
			}
		}

		BlockPosition var12 = var2.north();
		BlockPosition var13 = var2.south();
		BlockPosition var15 = var2.west();
		BlockPosition var14 = var2.east();
		boolean var9 = (var0 == var1.getType(var15).getBlock()) || (var0 == var1.getType(var14).getBlock());
		boolean var10 = (var0 == var1.getType(var12).getBlock()) || (var0 == var1.getType(var13).getBlock());
		if (var9 && var10) {
			var3 /= 2.0F;
		} else {
			boolean var11 = (var0 == var1.getType(var15.north()).getBlock()) || (var0 == var1.getType(var14.north()).getBlock()) || (var0 == var1.getType(var14.south()).getBlock()) || (var0 == var1.getType(var15.south()).getBlock());
			if (var11) {
				var3 /= 2.0F;
			}
		}

		return var3;
	}

	@Override
	public boolean f(World var1, BlockPosition var2, IBlockData var3) {
		return ((var1.k(var2) >= 8) || var1.i(var2)) && c(var1.getType(var2.down()).getBlock());
	}

	protected Item getSeedItem() {
		return Items.WHEAT_SEEDS;
	}

	protected Item getPlantItem() {
		return Items.WHEAT;
	}

	@Override
	public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
		super.dropNaturally(var1, var2, var3, var4, 0);
		if (!var1.isClientSide) {
			int var6 = d(var3);
			if (var6 >= n()) {
				int var7 = 3 + var5;

				for (int var8 = 0; var8 < var7; ++var8) {
					if (var1.random.nextInt(15) <= var6) {
						dropItem(var1, var2, new ItemStack(getSeedItem()));
					}
				}
			}

		}
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return this.e(var1) ? getPlantItem() : getSeedItem();
	}

	@Override
	public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
		return !this.e(var3);
	}

	@Override
	public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		return true;
	}

	@Override
	public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		this.g(var1, var3, var4);
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return this.b(var1);
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return d(var1);
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { AGE });
	}
}
