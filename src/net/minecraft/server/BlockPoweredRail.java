package net.minecraft.server;

import com.google.common.base.Predicate;

public class BlockPoweredRail extends BlockMinecartTrackAbstract {

	public static final BlockStateEnum<EnumTrackPosition> SHAPE = BlockStateEnum.of("shape", BlockMinecartTrackAbstract.EnumTrackPosition.class, new Predicate<EnumTrackPosition>() {
		@Override
		public boolean apply(BlockMinecartTrackAbstract.EnumTrackPosition var1) {
			return (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST) && (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST) && (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST) && (var1 != BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
		}
	});
	public static final BlockStateBoolean POWERED = BlockStateBoolean.of("powered");

	protected BlockPoweredRail() {
		super(true);
		setBlockData(blockStateList.getFirst().set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH).set(POWERED, Boolean.valueOf(false)));
	}

	protected boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4, int var5) {
		if (var5 >= 8) {
			return false;
		} else {
			int var6 = var2.getX();
			int var7 = var2.getY();
			int var8 = var2.getZ();
			boolean var9 = true;
			BlockMinecartTrackAbstract.EnumTrackPosition var10 = var3.get(SHAPE);
			switch (BlockPoweredRail.SwitchHelper.TRACK_POSITION_SWITCH[var10.ordinal()]) {
				case 1:
					if (var4) {
						++var8;
					} else {
						--var8;
					}
					break;
				case 2:
					if (var4) {
						--var6;
					} else {
						++var6;
					}
					break;
				case 3:
					if (var4) {
						--var6;
					} else {
						++var6;
						++var7;
						var9 = false;
					}

					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST;
					break;
				case 4:
					if (var4) {
						--var6;
						++var7;
						var9 = false;
					} else {
						++var6;
					}

					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST;
					break;
				case 5:
					if (var4) {
						++var8;
					} else {
						--var8;
						++var7;
						var9 = false;
					}

					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
					break;
				case 6:
					if (var4) {
						++var8;
						++var7;
						var9 = false;
					} else {
						--var8;
					}

					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
			}

			return this.a(var1, new BlockPosition(var6, var7, var8), var4, var5, var10) ? true : var9 && this.a(var1, new BlockPosition(var6, var7 - 1, var8), var4, var5, var10);
		}
	}

	protected boolean a(World var1, BlockPosition var2, boolean var3, int var4, BlockMinecartTrackAbstract.EnumTrackPosition var5) {
		IBlockData var6 = var1.getType(var2);
		if (var6.getBlock() != this) {
			return false;
		} else {
			BlockMinecartTrackAbstract.EnumTrackPosition var7 = var6.get(SHAPE);
			return (var5 == BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST) && ((var7 == BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH) || (var7 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH) || (var7 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH)) ? false : ((var5 == BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH) && ((var7 == BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST) || (var7 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST) || (var7 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST)) ? false : (var6.get(POWERED).booleanValue() ? (var1.isBlockIndirectlyPowered(var2) ? true : this.a(var1, var2, var6, var3, var4 + 1)) : false));
		}
	}

	@Override
	protected void b(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		boolean var5 = var3.get(POWERED).booleanValue();
		boolean var6 = var1.isBlockIndirectlyPowered(var2) || this.a(var1, var2, var3, true, 0) || this.a(var1, var2, var3, false, 0);
		if (var6 != var5) {
			var1.setTypeAndData(var2, var3.set(POWERED, Boolean.valueOf(var6)), 3);
			var1.c(var2.down(), this);
			if (var3.get(SHAPE).isAscending()) {
				var1.c(var2.up(), this);
			}
		}

	}

	@Override
	public IBlockState<EnumTrackPosition> n() {
		return SHAPE;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.getById(var1 & 7)).set(POWERED, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | var1.get(SHAPE).getId();
		if (var1.get(POWERED).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public IBlockData a(IBlockData blockdata, Block.EnumRotation var2) {
		if (blockdata.getBlock() != this) {
			return blockdata;
		} else {
			switch (var2) {
				case CLOCKWISE_180:
					switch (BlockPoweredRail.SwitchHelper.TRACK_POSITION_SWITCH[blockdata.get(SHAPE).ordinal()]) {
						case 3:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 4:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 5:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 6:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 7:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
						case 8:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 9:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						case 10:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
					}
				case COUNTERCLOCKWISE_90:
					switch (BlockPoweredRail.SwitchHelper.TRACK_POSITION_SWITCH[blockdata.get(SHAPE).ordinal()]) {
						case 1:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST);
						case 2:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH);
						case 3:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 4:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 5:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 6:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 7:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 8:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						case 9:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 10:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
					}
				case CLOCKWISE_90:
					switch (BlockPoweredRail.SwitchHelper.TRACK_POSITION_SWITCH[blockdata.get(SHAPE).ordinal()]) {
						case 1:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST);
						case 2:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH);
						case 3:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 4:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 5:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 6:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 7:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 8:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
						case 9:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 10:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
					}
				default:
					return blockdata;
			}
		}
	}

	@Override
	public IBlockData a(IBlockData blockdata, Block.class_a_in_class_agj var2) {
		if (blockdata.getBlock() != this) {
			return blockdata;
		} else {
			BlockMinecartTrackAbstract.EnumTrackPosition trackposition = blockdata.get(SHAPE);
			switch (var2) {
				case LEFT_RIGHT:
					switch (BlockPoweredRail.SwitchHelper.TRACK_POSITION_SWITCH[trackposition.ordinal()]) {
						case 5:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH);
						case 6:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH);
						case 7:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 8:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
						case 9:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 10:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						default:
							return super.a(blockdata, var2);
					}
				case FRONT_BACK:
					switch (BlockPoweredRail.SwitchHelper.TRACK_POSITION_SWITCH[trackposition.ordinal()]) {
						case 3:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST);
						case 4:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST);
						case 5:
						case 6:
						default:
							break;
						case 7:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST);
						case 8:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST);
						case 9:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST);
						case 10:
							return blockdata.set(SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST);
					}
				default:
					break;
			}

			return super.a(blockdata, var2);
		}
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { SHAPE, POWERED });
	}

	static class SwitchHelper {
		static final int[] TRACK_POSITION_SWITCH;

		static {

			TRACK_POSITION_SWITCH = new int[BlockMinecartTrackAbstract.EnumTrackPosition.values().length];

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST.ordinal()] = 3;
			} catch (NoSuchFieldError var8) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST.ordinal()] = 4;
			} catch (NoSuchFieldError var7) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH.ordinal()] = 5;
			} catch (NoSuchFieldError var6) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH.ordinal()] = 6;
			} catch (NoSuchFieldError var5) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST.ordinal()] = 7;
			} catch (NoSuchFieldError var4) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST.ordinal()] = 8;
			} catch (NoSuchFieldError var3) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST.ordinal()] = 9;
			} catch (NoSuchFieldError var2) {
			}

			try {
				TRACK_POSITION_SWITCH[BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST.ordinal()] = 10;
			} catch (NoSuchFieldError var1) {
			}

		}
	}

}
