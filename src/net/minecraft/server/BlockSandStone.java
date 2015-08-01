package net.minecraft.server;


public class BlockSandStone extends Block {

	public static final BlockStateEnum<EnumSandstoneVariant> TYPE = BlockStateEnum.of("type", BlockSandStone.EnumSandstoneVariant.class);

	public BlockSandStone() {
		super(Material.STONE);
		setBlockData(blockStateList.getFirst().set(TYPE, BlockSandStone.EnumSandstoneVariant.DEFAULT));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public int getDropData(IBlockData var1) {
		return var1.get(TYPE).getId();
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData var1) {
		return MaterialMapColor.COLOR3;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(TYPE, BlockSandStone.EnumSandstoneVariant.getById(var1));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(TYPE).getId();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { TYPE });
	}

	public static enum EnumSandstoneVariant implements INamable {
		DEFAULT(0, "sandstone", "default"),
		CHISELED(1, "chiseled_sandstone", "chiseled"),
		SMOOTH(2, "smooth_sandstone", "smooth");

		private static final BlockSandStone.EnumSandstoneVariant[] BY_ID;
		private final int id;
		private final String name;
		private final String g;

		private EnumSandstoneVariant(int var3, String var4, String var5) {
			id = var3;
			name = var4;
			g = var5;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return name;
		}

		public static BlockSandStone.EnumSandstoneVariant getById(int var0) {
			if ((var0 < 0) || (var0 >= BY_ID.length)) {
				var0 = 0;
			}

			return BY_ID[var0];
		}

		@Override
		public String getName() {
			return name;
		}

		public String c() {
			return g;
		}

		static {
			BY_ID = new BlockSandStone.EnumSandstoneVariant[values().length];
			BlockSandStone.EnumSandstoneVariant[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				BlockSandStone.EnumSandstoneVariant var3 = var0[var2];
				BY_ID[var3.getId()] = var3;
			}

		}
	}
}
