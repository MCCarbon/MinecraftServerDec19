package net.minecraft.server;

import java.util.Random;

public abstract class BlockDoubleStepAbstract extends BlockStepAbstract {

	public static final BlockStateBoolean SEAMLESS = BlockStateBoolean.of("seamless");
	public static final BlockStateEnum<EnumStoneSlabVariant> VARIANT = BlockStateEnum.of("variant", BlockDoubleStepAbstract.EnumStoneSlabVariant.class);

	public BlockDoubleStepAbstract() {
		super(Material.STONE);
		IBlockData var1 = blockStateList.getFirst();
		if (isDouble()) {
			var1 = var1.set(SEAMLESS, Boolean.valueOf(false));
		} else {
			var1 = var1.set(HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
		}

		setBlockData(var1.set(VARIANT, BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return Item.getItemOf(BlockStainedGlassPane.STONE_SLAB);
	}

	@Override
	public String b(int var1) {
		return super.getInternalName() + "." + BlockDoubleStepAbstract.EnumStoneSlabVariant.getById(var1).d();
	}

	@Override
	public IBlockState<EnumStoneSlabVariant> getVariant() {
		return VARIANT;
	}

	@Override
	public Object a(ItemStack var1) {
		return BlockDoubleStepAbstract.EnumStoneSlabVariant.getById(var1.i() & 7);
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		IBlockData var2 = getBlockData().set(VARIANT, BlockDoubleStepAbstract.EnumStoneSlabVariant.getById(var1 & 7));
		if (isDouble()) {
			var2 = var2.set(SEAMLESS, Boolean.valueOf((var1 & 8) != 0));
		} else {
			var2 = var2.set(HALF, (var1 & 8) == 0 ? BlockStepAbstract.EnumSlabHalf.BOTTOM : BlockStepAbstract.EnumSlabHalf.TOP);
		}

		return var2;
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | var1.get(VARIANT).getId();
		if (isDouble()) {
			if (var1.get(SEAMLESS).booleanValue()) {
				var3 |= 8;
			}
		} else if (var1.get(HALF) == BlockStepAbstract.EnumSlabHalf.TOP) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	protected BlockStateList getStateList() {
		return isDouble() ? new BlockStateList(this, new IBlockState[] { SEAMLESS, VARIANT }) : new BlockStateList(this, new IBlockState[] { HALF, VARIANT });
	}

	@Override
	public int getDropData(IBlockData var1) {
		return var1.get(VARIANT).getId();
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData var1) {
		return var1.get(VARIANT).getMapColor();
	}

	public static enum EnumStoneSlabVariant implements INamable {
		STONE(0, MaterialMapColor.COLOR12, "stone"),
		SAND(1, MaterialMapColor.COLOR3, "sandstone", "sand"),
		WOOD(2, MaterialMapColor.COLOR14, "wood_old", "wood"),
		COBBLESTONE(3, MaterialMapColor.COLOR12, "cobblestone", "cobble"),
		BRICK(4, MaterialMapColor.COLOR29, "brick"),
		SMOOTHBRICK(5, MaterialMapColor.COLOR12, "stone_brick", "smoothStoneBrick"),
		NETHERBRICK(6, MaterialMapColor.COLOR36, "nether_brick", "netherBrick"),
		QUARTZ(7, MaterialMapColor.COLOR15, "quartz");

		private static final BlockDoubleStepAbstract.EnumStoneSlabVariant[] BY_ID;
		private final int id;
		private final MaterialMapColor mapcolor;
		private final String name;
		private final String m;

		private EnumStoneSlabVariant(int var3, MaterialMapColor var4, String var5) {
			this(var3, var4, var5, var5);
		}

		private EnumStoneSlabVariant(int var3, MaterialMapColor var4, String var5, String var6) {
			id = var3;
			mapcolor = var4;
			name = var5;
			m = var6;
		}

		public int getId() {
			return id;
		}

		public MaterialMapColor getMapColor() {
			return mapcolor;
		}

		@Override
		public String toString() {
			return name;
		}

		public static BlockDoubleStepAbstract.EnumStoneSlabVariant getById(int id) {
			if ((id < 0) || (id >= BY_ID.length)) {
				id = 0;
			}

			return BY_ID[id];
		}

		@Override
		public String getName() {
			return name;
		}

		public String d() {
			return m;
		}

		static {
			BY_ID = new BlockDoubleStepAbstract.EnumStoneSlabVariant[values().length];
			BlockDoubleStepAbstract.EnumStoneSlabVariant[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				BlockDoubleStepAbstract.EnumStoneSlabVariant var3 = var0[var2];
				BY_ID[var3.getId()] = var3;
			}

		}

	}
}
