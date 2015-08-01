package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class BlockStepAbstract extends Block {

	public static final BlockStateEnum<EnumSlabHalf> HALF = BlockStateEnum.of("half", BlockStepAbstract.EnumSlabHalf.class);

	public BlockStepAbstract(Material var1) {
		super(var1);
		if (isDouble()) {
			isFullBlock = true;
		} else {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

		setLightOpacity(255);
	}

	@Override
	protected boolean canApplySilkTouch() {
		return false;
	}

	@Override
	public void updateShape(IBlockAccess var1, BlockPosition var2) {
		if (isDouble()) {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			IBlockData var3 = var1.getType(var2);
			if (var3.getBlock() == this) {
				if (var3.get(HALF) == BlockStepAbstract.EnumSlabHalf.TOP) {
					setSizes(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
				}
			}

		}
	}

	@Override
	public void j() {
		if (isDouble()) {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}
	}

	@Override
	public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List<AxisAlignedBB> var5, Entity var6) {
		isReplaceable(var1, var2);
		super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
	}

	@Override
	public boolean isOpaqueCube() {
		return isDouble();
	}

	@Override
	public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		IBlockData var9 = super.getPlacedState(var1, var2, var3, var4, var5, var6, var7, var8).set(HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
		return isDouble() ? var9 : ((var3 != EnumDirection.DOWN) && ((var3 == EnumDirection.UP) || (var5 <= 0.5D)) ? var9 : var9.set(HALF, BlockStepAbstract.EnumSlabHalf.TOP));
	}

	@Override
	public int getDropCount(Random var1) {
		return isDouble() ? 2 : 1;
	}

	@Override
	public boolean isFullCube() {
		return isDouble();
	}

	public abstract String b(int var1);

	@Override
	public int getDropData(World var1, BlockPosition var2) {
		return super.getDropData(var1, var2) & 7;
	}

	public abstract boolean isDouble();

	public abstract IBlockState<?> getVariant();

	public abstract Object a(ItemStack var1);

	public static enum EnumSlabHalf implements INamable {
		TOP("top"), BOTTOM("bottom");

		private final String c;

		private EnumSlabHalf(String var3) {
			c = var3;
		}

		@Override
		public String toString() {
			return c;
		}

		@Override
		public String getName() {
			return c;
		}
	}

}
