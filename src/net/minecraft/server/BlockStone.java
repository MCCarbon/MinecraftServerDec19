package net.minecraft.server;

import java.util.Random;

public class BlockStone extends Block {

	public static final BlockStateEnum<EnumStoneVariant> VARIANT = BlockStateEnum.of("variant", EnumStoneVariant.class);

	public BlockStone() {
		super(Material.STONE);
		setBlockData(blockStateList.getFirst().set(VARIANT, BlockStone.EnumStoneVariant.STONE));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public String getName() {
		return LocaleI18n.get(getInternalName() + "." + BlockStone.EnumStoneVariant.STONE.getILocaleName() + ".name");
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData blockdata) {
		return blockdata.get(VARIANT).getMapColor();
	}

	@Override
	public Item getDropType(IBlockData blockdata, Random random, int id) {
		return blockdata.get(VARIANT) == BlockStone.EnumStoneVariant.STONE ? Item.getItemOf(Blocks.COBBLESTONE) : Item.getItemOf(Blocks.STONE);
	}

	@Override
	public int getDropData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getData();
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(VARIANT, BlockStone.EnumStoneVariant.getByData(var1));
	}

	@Override
	public int toLegacyData(IBlockData blockdata) {
		return blockdata.get(VARIANT).getData();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { VARIANT });
	}

	public static enum EnumStoneVariant implements INamable {
		STONE(0, MaterialMapColor.COLOR12, "stone"),
		GRANITE(1, MaterialMapColor.COLOR11, "granite"),
		GRANITE_SMOOTH(2, MaterialMapColor.COLOR11, "smooth_granite", "graniteSmooth"),
		DIORITE(3, MaterialMapColor.COLOR15, "diorite"),
		DIORITE_SMOOTH(4, MaterialMapColor.COLOR15, "smooth_diorite", "dioriteSmooth"),
		ANDESITE(5, MaterialMapColor.COLOR12, "andesite"),
		ANDESITE_SMOOTH(6, MaterialMapColor.COLOR12, "smooth_andesite", "andesiteSmooth");

		private static final BlockStone.EnumStoneVariant[] BY_DATA;

		static {
			BY_DATA = new EnumStoneVariant[values().length];
			for (EnumStoneVariant var3 : EnumStoneVariant.values()) {
				BY_DATA[var3.getData()] = var3;
			}
		}

		public static BlockStone.EnumStoneVariant getByData(int data) {
			if ((data < 0) || (data >= BY_DATA.length)) {
				data = 0;
			}

			return BY_DATA[data];
		}

		private final int data;
		private final String id;
		private final String name;
		private final MaterialMapColor mapcolor;

		private EnumStoneVariant(int data, MaterialMapColor mapcolor, String id) {
			this(data, mapcolor, id, id);
		}

		private EnumStoneVariant(int data, MaterialMapColor mapcolor, String id, String name) {
			this.data = data;
			this.id = id;
			this.name = name;
			this.mapcolor = mapcolor;
		}

		public int getData() {
			return data;
		}

		public MaterialMapColor getMapColor() {
			return mapcolor;
		}

		@Override
		public String toString() {
			return id;
		}

		@Override
		public String getName() {
			return id;
		}

		public String getILocaleName() {
			return name;
		}

	}

}
