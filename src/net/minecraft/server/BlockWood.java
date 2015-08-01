package net.minecraft.server;


public class BlockWood extends Block {

	public static final BlockStateEnum<EnumLogVariant> VARIANT = BlockStateEnum.of("variant", BlockWood.EnumLogVariant.class);

	public BlockWood() {
		super(Material.WOOD);
		setBlockData(blockStateList.getFirst().set(VARIANT, BlockWood.EnumLogVariant.OAK));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public int getDropData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getId();
	}

	@Override
	public IBlockData fromLegacyData(int data) {
		return getBlockData().set(VARIANT, BlockWood.EnumLogVariant.getById(data));
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData mapcolor) {
		return mapcolor.get(VARIANT).getMapColor();
	}

	@Override
	public int toLegacyData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getId();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { VARIANT });
	}

	public static enum EnumLogVariant implements INamable {
		OAK(0, "oak", MaterialMapColor.COLOR14),
		SPRUCE(1, "spruce", MaterialMapColor.COLOR35),
		BIRCH(2, "birch", MaterialMapColor.COLOR3),
		JUNGLE(3, "jungle", MaterialMapColor.COLOR11),
		ACACIA(4, "acacia", MaterialMapColor.COLOR16),
		DARK_OAK(5, "dark_oak", "big_oak", MaterialMapColor.COLOR27);

		private static final BlockWood.EnumLogVariant[] BY_ID;

		static {
			BY_ID = new BlockWood.EnumLogVariant[values().length];
			for (EnumLogVariant logv : values()) {
				BY_ID[logv.getId()] = logv;
			}
		}

		public static EnumLogVariant getById(int id) {
			if ((id < 0) || (id >= BY_ID.length)) {
				id = 0;
			}
			return BY_ID[id];
		}

		private final int id;
		private final String name;
		private final String j;
		private final MaterialMapColor mapcolor;

		private EnumLogVariant(int var3, String var4, MaterialMapColor var5) {
			this(var3, var4, var4, var5);
		}

		private EnumLogVariant(int var3, String var4, String var5, MaterialMapColor var6) {
			id = var3;
			name = var4;
			j = var5;
			mapcolor = var6;
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

		@Override
		public String getName() {
			return name;
		}

		public String d() {
			return j;
		}

	}

}
