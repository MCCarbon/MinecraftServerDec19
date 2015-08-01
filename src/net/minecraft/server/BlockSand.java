package net.minecraft.server;


public class BlockSand extends BlockFalling {

	public static final BlockStateEnum<EnumSandVariant> VARIANT = BlockStateEnum.of("variant", EnumSandVariant.class);

	public BlockSand() {
		setBlockData(blockStateList.getFirst().set(VARIANT, BlockSand.EnumSandVariant.SAND));
	}

	@Override
	public int getDropData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getId();
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData blockdata) {
		return blockdata.get(VARIANT).getMapColor();
	}

	@Override
	public IBlockData fromLegacyData(int data) {
		return getBlockData().set(VARIANT, BlockSand.EnumSandVariant.getById(data));
	}

	@Override
	public int toLegacyData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getId();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { VARIANT });
	}

	public static enum EnumSandVariant implements INamable {
		SAND(0, "sand", "default", MaterialMapColor.COLOR3),
		RED_SAND(1, "red_sand", "red", MaterialMapColor.COLOR16);

		private static final BlockSand.EnumSandVariant[] BY_ID;
		private final int id;
		private final String name;
		private final MaterialMapColor mapcolor;
		private final String g;

		private EnumSandVariant(int var3, String var4, String var5, MaterialMapColor var6) {
			id = var3;
			name = var4;
			mapcolor = var6;
			g = var5;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return name;
		}

		public MaterialMapColor getMapColor() {
			return mapcolor;
		}

		public static BlockSand.EnumSandVariant getById(int id) {
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
			return g;
		}

		static {
			BY_ID = new BlockSand.EnumSandVariant[values().length];
			for (EnumSandVariant sandv : values()) {
				BY_ID[sandv.getId()] = sandv;
			}
		}

	}
}
