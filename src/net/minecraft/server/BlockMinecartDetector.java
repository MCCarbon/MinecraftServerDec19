package net.minecraft.server;

import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

public class BlockMinecartDetector extends BlockMinecartTrackAbstract {

	public static final BlockStateEnum<EnumTrackPosition> SHAPE = BlockStateEnum.of("shape", BlockMinecartTrackAbstract.EnumTrackPosition.class, new Predicate<EnumTrackPosition>() {
		@Override
		public boolean apply(BlockMinecartTrackAbstract.EnumTrackPosition var1) {
			return (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST) && (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST) && (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST) && (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
		}
	});
	public static final BlockStateBoolean N = BlockStateBoolean.of("powered");

	public BlockMinecartDetector() {
		super(true);
		setBlockData(blockStateList.getFirst().set(N, Boolean.valueOf(false)).set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH));
		setTicking(true);
	}

	@Override
	public int tickInterval(World var1) {
		return 20;
	}

	@Override
	public boolean isPowerSource() {
		return true;
	}

	@Override
	public void a(World var1, BlockPosition var2, IBlockData var3, Entity var4) {
		if (!var1.isClientSide) {
			if (!var3.get(N).booleanValue()) {
				this.e(var1, var2, var3);
			}
		}
	}

	@Override
	public void randomTick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
	}

	@Override
	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		if (!var1.isClientSide && var3.get(N).booleanValue()) {
			this.e(var1, var2, var3);
		}
	}

	@Override
	public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
		return var3.get(N).booleanValue() ? 15 : 0;
	}

	@Override
	public int b(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
		return !var3.get(N).booleanValue() ? 0 : (var4 == EnumDirection.UP ? 15 : 0);
	}

	private void e(World var1, BlockPosition var2, IBlockData var3) {
		boolean var4 = var3.get(N).booleanValue();
		boolean var5 = false;
		List<?> var6 = this.a(var1, var2, EntityMinecartAbstract.class, new Predicate[0]);
		if (!var6.isEmpty()) {
			var5 = true;
		}

		if (var5 && !var4) {
			var1.setTypeAndData(var2, var3.set(N, Boolean.valueOf(true)), 3);
			var1.applyPhysics(var2, this);
			var1.applyPhysics(var2.down(), this);
			var1.b(var2, var2);
		}

		if (!var5 && var4) {
			var1.setTypeAndData(var2, var3.set(N, Boolean.valueOf(false)), 3);
			var1.applyPhysics(var2, this);
			var1.applyPhysics(var2.down(), this);
			var1.b(var2, var2);
		}

		if (var5) {
			var1.a(var2, this, tickInterval(var1));
		}

		var1.updateAdjacentComparators(var2, this);
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		super.onPlace(var1, var2, var3);
		this.e(var1, var2, var3);
	}

	@Override
	public IBlockState<EnumTrackPosition> n() {
		return SHAPE;
	}

	@Override
	public boolean isComplexRedstone() {
		return true;
	}

	@Override
	public int getRedstonePower(World var1, BlockPosition var2) {
		if (var1.getType(var2).get(N).booleanValue()) {
			List<?> var3 = this.a(var1, var2, EntityMinecartCommandBlock.class, new Predicate[0]);
			if (!var3.isEmpty()) {
				return ((EntityMinecartCommandBlock) var3.get(0)).j().j();
			}

			List<?> var4 = this.a(var1, var2, EntityMinecartAbstract.class, new Predicate[] { IEntitySelector.IS_ALIVE_AND_HAS_INVENTORY });
			if (!var4.isEmpty()) {
				return Container.b((IInventory) var4.get(0));
			}
		}

		return 0;
	}

	protected List<?> a(World var1, BlockPosition var2, Class<?> var3, Predicate<?>... var4) {
		AxisAlignedBB var5 = this.a(var2);
		return var4.length != 1 ? var1.getEntities(var3, var5) : var1.a(var3, var5, var4[0]);
	}

	private AxisAlignedBB a(BlockPosition var1) {
		return new AxisAlignedBB(var1.getX() + 0.2F, var1.getY(), var1.getZ() + 0.2F, var1.getX() + 1 - 0.2F, var1.getY() + 1 - 0.2F, var1.getZ() + 1 - 0.2F);
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.getById(var1 & 7)).set(N, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | var1.get(SHAPE).getId();
		if (var1.get(N).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
		if (var1.getBlock() != this) {
			return var1;
		} else {
			switch (BlockMinecartDetector.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					switch (BlockMinecartDetector.SyntheticClass_1.a[var1.get(SHAPE).ordinal()]) {
						case 1:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 2:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 3:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 4:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 5:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
						case 6:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 7:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						case 8:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
					}
				case 2:
					switch (BlockMinecartDetector.SyntheticClass_1.a[var1.get(SHAPE).ordinal()]) {
						case 1:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 2:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 3:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 4:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 5:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 6:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						case 7:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 8:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
						case 9:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST);
						case 10:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH);
					}
				case 3:
					switch (BlockMinecartDetector.SyntheticClass_1.a[var1.get(SHAPE).ordinal()]) {
						case 1:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 2:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 3:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 4:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 5:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 6:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
						case 7:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 8:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						case 9:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST);
						case 10:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH);
					}
				default:
					return var1;
			}
		}
	}

	@Override
	public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
		if (var1.getBlock() != this) {
			return var1;
		} else {
			BlockMinecartTrackAbstract.EnumTrackPosition var3 = var1.get(SHAPE);
			switch (BlockMinecartDetector.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
					switch (BlockMinecartDetector.SyntheticClass_1.a[var3.ordinal()]) {
						case 3:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 4:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 5:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 6:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
						case 7:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 8:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						default:
							return super.a(var1, var2);
					}
				case 2:
					switch (BlockMinecartDetector.SyntheticClass_1.a[var3.ordinal()]) {
						case 1:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 2:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 3:
						case 4:
						default:
							break;
						case 5:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 6:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						case 7:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 8:
							return var1.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
					}
			}

			return super.a(var1, var2);
		}
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { SHAPE, N });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[Block.class_a_in_class_agj.values().length];

		static {
			try {
				c[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
			} catch (NoSuchFieldError var15) {
				;
			}

			try {
				c[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
			} catch (NoSuchFieldError var14) {
				;
			}

			b = new int[Block.EnumRotation.values().length];

			try {
				b[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
			} catch (NoSuchFieldError var12) {
				;
			}

			try {
				b[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
			} catch (NoSuchFieldError var11) {
				;
			}

			a = new int[BlockMinecartTrackAbstract.EnumTrackPosition.values().length];

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH.ordinal()] = 3;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH.ordinal()] = 4;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST.ordinal()] = 5;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST.ordinal()] = 6;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST.ordinal()] = 7;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST.ordinal()] = 8;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH.ordinal()] = 9;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST.ordinal()] = 10;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
