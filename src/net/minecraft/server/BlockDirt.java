package net.minecraft.server;

public class BlockDirt extends Block {

	public static final BlockStateEnum<EnumDirtVariant> VARIANT = BlockStateEnum.of("variant", EnumDirtVariant.class);
	public static final BlockStateBoolean SNOWY = BlockStateBoolean.of("snowy");

	protected BlockDirt() {
		super(Material.EARTH);
		setBlockData(blockStateList.getFirst().set(VARIANT, BlockDirt.EnumDirtVariant.DIRT).set(SNOWY, Boolean.valueOf(false)));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData blockdata) {
		return blockdata.get(VARIANT).getMapColor();
	}

	@Override
	public IBlockData updateState(IBlockData blockdata, IBlockAccess access, BlockPosition position) {
		if (blockdata.get(VARIANT) == BlockDirt.EnumDirtVariant.PODZOL) {
			Block upperBlock = access.getType(position.up()).getBlock();
			blockdata = blockdata.set(SNOWY, ((upperBlock == Blocks.SNOW) || (upperBlock == Blocks.SNOW_LAYER)));
		}
		return blockdata;
	}

	@Override
	public int getDropData(World world, BlockPosition position) {
		IBlockData blockdata = world.getType(position);
		return blockdata.getBlock() != this ? 0 : blockdata.get(VARIANT).getId();
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(VARIANT, BlockDirt.EnumDirtVariant.getById(var1));
	}

	@Override
	public int toLegacyData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getId();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { VARIANT, SNOWY });
	}

	@Override
	public int getDropData(IBlockData blockdata) {
		EnumDirtVariant dirtv = blockdata.get(VARIANT);
		if (dirtv == BlockDirt.EnumDirtVariant.PODZOL) {
			dirtv = BlockDirt.EnumDirtVariant.DIRT;
		}
		return dirtv.getId();
	}

	public static enum EnumDirtVariant implements INamable {

		DIRT(0, "dirt", "default", MaterialMapColor.COLOR11),
		COARSE_DIRT(1, "coarse_dirt", "coarse", MaterialMapColor.COLOR11),
		PODZOL(2, "podzol", MaterialMapColor.COLOR35);

		private static final EnumDirtVariant[] BY_ID;

		static {
			BY_ID = new EnumDirtVariant[values().length];
			for (final EnumDirtVariant variant : values()) {
				BY_ID[variant.getId()] = variant;
			}
		}

		public static EnumDirtVariant getById(int id) {
			if ((id < 0) || (id >= BY_ID.length)) {
				id = 0;
			}
			return BY_ID[id];
		}

		private final int id;
		private final String name;
		private final String g;
		private final MaterialMapColor mapcolor;

		private EnumDirtVariant(int id, String name, MaterialMapColor mapcolor) {
			this(id, name, name, mapcolor);
		}

		private EnumDirtVariant(int id, String name, String var5, MaterialMapColor mapcolor) {
			this.id = id;
			this.name = name;
			this.g = var5;
			this.mapcolor = mapcolor;
		}

		public int getId() {
			return id;
		}

		public String c() {
			return g;
		}

		public MaterialMapColor getMapColor() {
			return mapcolor;
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
