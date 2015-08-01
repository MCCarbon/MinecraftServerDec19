package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockPistonExtension extends class_ahi {

	public static final BlockStateEnum<EnumPistonType> TYPE = BlockStateEnum.of("type", BlockPistonExtension.EnumPistonType.class);
	public static final BlockStateBoolean SHORT = BlockStateBoolean.of("short");

	public BlockPistonExtension() {
		super(Material.PISTON);
		setBlockData(blockStateList.getFirst().set(FACING, EnumDirection.NORTH).set(TYPE, BlockPistonExtension.EnumPistonType.DEFAULT).set(SHORT, Boolean.valueOf(false)));
		setStepSound(STEP_SOUND_STONE2);
		setStrength(0.5F);
	}

	@Override
	public void a(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
		if (var4.bH.instabuild) {
			EnumDirection var5 = var3.get(FACING);
			if (var5 != null) {
				BlockPosition var6 = var2.shift(var5.getOpposite());
				Block var7 = var1.getType(var6).getBlock();
				if ((var7 == Blocks.PISTON) || (var7 == Blocks.STICKY_PISTON)) {
					var1.setAir(var6);
				}
			}
		}

		super.a(var1, var2, var3, var4);
	}

	@Override
	public void remove(World var1, BlockPosition var2, IBlockData var3) {
		super.remove(var1, var2, var3);
		EnumDirection var4 = var3.get(FACING).getOpposite();
		var2 = var2.shift(var4);
		IBlockData var5 = var1.getType(var2);
		if (((var5.getBlock() == Blocks.PISTON) || (var5.getBlock() == Blocks.STICKY_PISTON)) && var5.get(BlockPiston.EXTENDED).booleanValue()) {
			var5.getBlock().dropNaturallyForSure(var1, var2, var5, 0);
			var1.setAir(var2);
		}

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean canPlace(World var1, BlockPosition var2) {
		return false;
	}

	@Override
	public boolean canPlace(World var1, BlockPosition var2, EnumDirection var3) {
		return false;
	}

	@Override
	public int getDropCount(Random var1) {
		return 0;
	}

	@Override
	public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List<AxisAlignedBB> var5, Entity var6) {
		d(var3);
		super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
		e(var3);
		super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
		setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void e(IBlockData var1) {
		switch (BlockPistonExtension.SyntheticClass_1.a[var1.get(FACING).ordinal()]) {
			case 1:
				setSizes(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
				break;
			case 2:
				setSizes(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
				break;
			case 3:
				setSizes(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
				break;
			case 4:
				setSizes(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
				break;
			case 5:
				setSizes(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
				break;
			case 6:
				setSizes(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
		}

	}

	@Override
	public void updateShape(IBlockAccess var1, BlockPosition var2) {
		d(var1.getType(var2));
	}

	public void d(IBlockData var1) {
		float var2 = 0.25F;
		EnumDirection var3 = var1.get(FACING);
		if (var3 != null) {
			switch (BlockPistonExtension.SyntheticClass_1.a[var3.ordinal()]) {
				case 1:
					setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
					break;
				case 2:
					setSizes(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
					break;
				case 3:
					setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
					break;
				case 4:
					setSizes(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
					break;
				case 5:
					setSizes(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
					break;
				case 6:
					setSizes(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}

		}
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		EnumDirection var5 = var3.get(FACING);
		BlockPosition var6 = var2.shift(var5.getOpposite());
		IBlockData var7 = var1.getType(var6);
		if ((var7.getBlock() != Blocks.PISTON) && (var7.getBlock() != Blocks.STICKY_PISTON)) {
			var1.setAir(var2);
		} else {
			var7.getBlock().doPhysics(var1, var6, var7, var4);
		}

	}

	public static EnumDirection b(int var0) {
		int var1 = var0 & 7;
		return var1 > 5 ? null : EnumDirection.getById(var1);
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(FACING, b(var1)).set(TYPE, (var1 & 8) > 0 ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | var1.get(FACING).getId();
		if (var1.get(TYPE) == BlockPistonExtension.EnumPistonType.STICKY) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
		return var1.getBlock() != this ? var1 : var1.set(FACING, var2.a(var1.get(FACING)));
	}

	@Override
	public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
		return var1.getBlock() != this ? var1 : this.a(var1, var2.a(var1.get(FACING)));
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { FACING, TYPE, SHORT });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[EnumDirection.values().length];

		static {
			try {
				a[EnumDirection.DOWN.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[EnumDirection.UP.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[EnumDirection.NORTH.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[EnumDirection.SOUTH.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[EnumDirection.WEST.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[EnumDirection.EAST.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum EnumPistonType implements INamable {
		DEFAULT("normal"), STICKY("sticky");

		private final String name;

		private EnumPistonType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public String getName() {
			return name;
		}

	}

}
