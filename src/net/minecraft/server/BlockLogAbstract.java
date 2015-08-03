package net.minecraft.server;

import java.util.Iterator;

public abstract class BlockLogAbstract extends BlockRotatable {

	public static final BlockStateEnum<EnumLogRotation> AXIS = BlockStateEnum.of("axis", BlockLogAbstract.EnumLogRotation.class);

	public BlockLogAbstract() {
		super(Material.WOOD);
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
		setStrength(2.0F);
		setStepSound(STEP_SOUND_WOOD);
	}

	@Override
	public void remove(World var1, BlockPosition var2, IBlockData var3) {
		byte var4 = 4;
		int var5 = var4 + 1;
		if (var1.areChunksLoadedBetween(var2.add(-var5, -var5, -var5), var2.add(var5, var5, var5))) {
			Iterator<BlockPosition> var6 = BlockPosition.allInCube(var2.add(-var4, -var4, -var4), var2.add(var4, var4, var4)).iterator();

			while (var6.hasNext()) {
				BlockPosition var7 = var6.next();
				IBlockData var8 = var1.getType(var7);
				if ((var8.getBlock().getMaterial() == Material.LEAVES) && !var8.get(BlockLeaves.CHECK_DECAY).booleanValue()) {
					var1.setTypeAndData(var7, var8.set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(true)), 4);
				}
			}

		}
	}

	@Override
	public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return fromLegacyData(var7).set(AXIS, BlockLogAbstract.EnumLogRotation.a(var3.getAxis()));
	}

	@Override
	public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
		if (var1.getBlock() != this) {
			return var1;
		} else {
			switch (BlockLogAbstract.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
				case 2:
					switch (BlockLogAbstract.SyntheticClass_1.a[var1.get(AXIS).ordinal()]) {
						case 1:
							return var1.set(AXIS, BlockLogAbstract.EnumLogRotation.Z);
						case 2:
							return var1.set(AXIS, BlockLogAbstract.EnumLogRotation.X);
						default:
							return var1;
					}
				default:
					return var1;
			}
		}
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[EnumDirection.EnumAxis.values().length];

		static {
			try {
				c[EnumDirection.EnumAxis.X.ordinal()] = 1;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				c[EnumDirection.EnumAxis.Y.ordinal()] = 2;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				c[EnumDirection.EnumAxis.Z.ordinal()] = 3;
			} catch (NoSuchFieldError var5) {
				;
			}

			b = new int[Block.EnumRotation.values().length];

			try {
				b[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				b[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			a = new int[BlockLogAbstract.EnumLogRotation.values().length];

			try {
				a[BlockLogAbstract.EnumLogRotation.X.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[BlockLogAbstract.EnumLogRotation.Z.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum EnumLogRotation implements INamable {
		X("x"), Y("y"), Z("z"), NONE("none");

		private final String e;

		private EnumLogRotation(String var3) {
			e = var3;
		}

		@Override
		public String toString() {
			return e;
		}

		public static BlockLogAbstract.EnumLogRotation a(EnumDirection.EnumAxis var0) {
			switch (BlockLogAbstract.SyntheticClass_1.c[var0.ordinal()]) {
				case 1:
					return X;
				case 2:
					return Y;
				case 3:
					return Z;
				default:
					return NONE;
			}
		}

		@Override
		public String getName() {
			return e;
		}
	}
}
