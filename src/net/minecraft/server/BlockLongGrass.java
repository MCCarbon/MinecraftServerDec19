package net.minecraft.server;

import java.util.Random;

public class BlockLongGrass extends BlockPlant implements IBlockFragilePlantElement {

	public static final BlockStateEnum<EnumTallGrassType> TYPE = BlockStateEnum.of("type", BlockLongGrass.EnumTallGrassType.class);

	protected BlockLongGrass() {
		super(Material.REPLACEABLE_PLANT);
		setBlockData(blockStateList.getFirst().set(TYPE, BlockLongGrass.EnumTallGrassType.DEAD_BUSH));
		float var1 = 0.4F;
		setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	@Override
	public boolean f(World var1, BlockPosition var2, IBlockData var3) {
		return c(var1.getType(var2.down()).getBlock());
	}

	@Override
	public boolean isReplaceable(World var1, BlockPosition var2) {
		return true;
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return var2.nextInt(8) == 0 ? Items.WHEAT_SEEDS : null;
	}

	@Override
	public int getDropCount(int var1, Random var2) {
		return 1 + var2.nextInt((var1 * 2) + 1);
	}

	@Override
	public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
		if (!var1.isClientSide && (var6 != null) && (var6.getItem() == Items.SHEARS)) {
			var2.b(StatisticList.ab[Block.getId(this)]);
			dropItem(var1, var3, new ItemStack(Blocks.TALLGRASS, 1, var4.get(TYPE).getId()));
		} else {
			super.breakBlockNaturally(var1, var2, var3, var4, var5, var6);
		}

	}

	@Override
	public int getDropData(World var1, BlockPosition var2) {
		IBlockData var3 = var1.getType(var2);
		return var3.getBlock().toLegacyData(var3);
	}

	@Override
	public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
		return var3.get(TYPE) != BlockLongGrass.EnumTallGrassType.DEAD_BUSH;
	}

	@Override
	public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		return true;
	}

	@Override
	public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
		class_ahm.class_b_in_class_ahm var5 = class_ahm.class_b_in_class_ahm.c;
		if (var4.get(TYPE) == BlockLongGrass.EnumTallGrassType.FERN) {
			var5 = class_ahm.class_b_in_class_ahm.d;
		}

		if (Blocks.DOUBLE_PLANT.canPlace(var1, var3)) {
			Blocks.DOUBLE_PLANT.a(var1, var3, var5, 2);
		}

	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(TYPE, BlockLongGrass.EnumTallGrassType.getById(var1));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(TYPE).getId();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { TYPE });
	}

	public static enum EnumTallGrassType implements INamable {
		DEAD_BUSH(0, "dead_bush"), GRASS(1, "tall_grass"), FERN(2, "fern");

		private static final BlockLongGrass.EnumTallGrassType[] BY_ID;
		private final int id;
		private final String name;

		private EnumTallGrassType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return name;
		}

		public static BlockLongGrass.EnumTallGrassType getById(int id) {
			if ((id < 0) || (id >= BY_ID.length)) {
				id = 0;
			}

			return BY_ID[id];
		}

		@Override
		public String getName() {
			return name;
		}

		static {
			BY_ID = new BlockLongGrass.EnumTallGrassType[values().length];
			BlockLongGrass.EnumTallGrassType[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				BlockLongGrass.EnumTallGrassType var3 = var0[var2];
				BY_ID[var3.getId()] = var3;
			}

		}
	}
}
