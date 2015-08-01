package net.minecraft.server;

import net.minecraft.server.BlockWood.EnumLogVariant;

import com.google.common.base.Predicate;

public class BlockLog1 extends BlockLogAbstract {

	public static final BlockStateEnum<EnumLogVariant> b = BlockStateEnum.of("variant", EnumLogVariant.class, new Predicate<EnumLogVariant>() {
		@Override
		public boolean apply(EnumLogVariant var1) {
			return var1.getId() < 4;
		}
	});

	public BlockLog1() {
		setBlockData(blockStateList.getFirst().set(b, BlockWood.EnumLogVariant.OAK).set(AXIS, BlockLogAbstract.EnumLogRotation.Y));
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData var1) {
		BlockWood.EnumLogVariant var2 = var1.get(b);
		switch (BlockLog1.SyntheticClass_1.b[((BlockLogAbstract.EnumLogRotation) var1.get(AXIS)).ordinal()]) {
			case 1:
			case 2:
			case 3:
			default:
				switch (BlockLog1.SyntheticClass_1.a[var2.ordinal()]) {
					case 1:
					default:
						return BlockWood.EnumLogVariant.SPRUCE.getMapColor();
					case 2:
						return BlockWood.EnumLogVariant.DARK_OAK.getMapColor();
					case 3:
						return MaterialMapColor.COLOR15;
					case 4:
						return BlockWood.EnumLogVariant.SPRUCE.getMapColor();
				}
			case 4:
				return var2.getMapColor();
		}
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		IBlockData var2 = getBlockData().set(b, BlockWood.EnumLogVariant.getById((var1 & 3) % 4));
		switch (var1 & 12) {
			case 0:
				var2 = var2.set(AXIS, BlockLogAbstract.EnumLogRotation.Y);
				break;
			case 4:
				var2 = var2.set(AXIS, BlockLogAbstract.EnumLogRotation.X);
				break;
			case 8:
				var2 = var2.set(AXIS, BlockLogAbstract.EnumLogRotation.Z);
				break;
			default:
				var2 = var2.set(AXIS, BlockLogAbstract.EnumLogRotation.NONE);
		}

		return var2;
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | var1.get(b).getId();
		switch (BlockLog1.SyntheticClass_1.b[((BlockLogAbstract.EnumLogRotation) var1.get(AXIS)).ordinal()]) {
			case 1:
				var3 |= 4;
				break;
			case 2:
				var3 |= 8;
				break;
			case 3:
				var3 |= 12;
		}

		return var3;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { b, AXIS });
	}

	@Override
	protected ItemStack createItemStack(IBlockData var1) {
		return new ItemStack(Item.getItemOf(this), 1, var1.get(b).getId());
	}

	@Override
	public int getDropData(IBlockData var1) {
		return var1.get(b).getId();
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[BlockLogAbstract.EnumLogRotation.values().length];

		static {
			try {
				b[BlockLogAbstract.EnumLogRotation.X.ordinal()] = 1;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[BlockLogAbstract.EnumLogRotation.Z.ordinal()] = 2;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				b[BlockLogAbstract.EnumLogRotation.NONE.ordinal()] = 3;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[BlockLogAbstract.EnumLogRotation.Y.ordinal()] = 4;
			} catch (NoSuchFieldError var5) {
				;
			}

			a = new int[BlockWood.EnumLogVariant.values().length];

			try {
				a[BlockWood.EnumLogVariant.OAK.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[BlockWood.EnumLogVariant.SPRUCE.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[BlockWood.EnumLogVariant.BIRCH.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[BlockWood.EnumLogVariant.JUNGLE.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
