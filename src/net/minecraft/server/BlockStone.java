package net.minecraft.server;

import java.util.Random;

import net.minecraft.server.Item;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public class BlockStone extends Block {

	public static final BlockStateEnum VARIANT = BlockStateEnum.of("variant", BlockStone.EnumStoneVariant.class);

	@SuppressWarnings("unchecked")
	public BlockStone() {
		super(Material.STONE);
		this.setBlockData(this.blockStateList.getFirst().set(VARIANT, BlockStone.EnumStoneVariant.STONE));
		this.a(CreativeTab.b);
	}

	public String getName() {
		return LocaleI18n.get(this.getInternalName() + "." + BlockStone.EnumStoneVariant.STONE.getILocaleName() + ".name");
	}

	@SuppressWarnings("unchecked")
	public MaterialMapColor getMapColor(IBlockData blockdata) {
		return ((BlockStone.EnumStoneVariant) blockdata.get(VARIANT)).getMapColor();
	}

	@SuppressWarnings("unchecked")
	public Item getDropType(IBlockData blockdata, Random random, int id) {
		return blockdata.get(VARIANT) == BlockStone.EnumStoneVariant.STONE ? Item.getByBlock(Blocks.COBBLESTONE) : Item.getByBlock(Blocks.STONE);
	}

	@SuppressWarnings("unchecked")
	public int getDropData(IBlockData blockdata) {
		return ((BlockStone.EnumStoneVariant) blockdata.get(VARIANT)).getData();
	}

	@SuppressWarnings("unchecked")
	public IBlockData fromLegacyData(int var1) {
		return this.getBlockData().set(VARIANT, BlockStone.EnumStoneVariant.getByData(var1));
	}

	@SuppressWarnings("unchecked")
	public int toLegacyData(IBlockData blockdata) {
		return ((BlockStone.EnumStoneVariant) blockdata.get(VARIANT)).getData();
	}

	protected BlockStateList createBlockStateList() {
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
			if (data < 0 || data >= BY_DATA.length) {
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
			return this.data;
		}

		public MaterialMapColor getMapColor() {
			return this.mapcolor;
		}

		public String toString() {
			return this.id;
		}

		public String getName() {
			return this.id;
		}

		public String getILocaleName() {
			return this.name;
		}

	}

}
