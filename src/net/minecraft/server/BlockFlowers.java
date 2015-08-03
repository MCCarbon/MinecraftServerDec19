package net.minecraft.server;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public abstract class BlockFlowers extends BlockPlant {

	protected BlockStateEnum<EnumFlowerVarient> TYPE;

	protected BlockFlowers() {
		setBlockData(blockStateList.getFirst().set(getFlowerVarients(), getFlowerType() == BlockFlowers.EnumFlowerType.RED ? BlockFlowers.EnumFlowerVarient.POPPY : BlockFlowers.EnumFlowerVarient.DANDELION));
	}

	@Override
	public int getDropData(IBlockData var1) {
		return var1.get(getFlowerVarients()).getId();
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(getFlowerVarients(), BlockFlowers.EnumFlowerVarient.getById(getFlowerType(), var1));
	}

	public abstract BlockFlowers.EnumFlowerType getFlowerType();

	public IBlockState<EnumFlowerVarient> getFlowerVarients() {
		if (TYPE == null) {
			TYPE = BlockStateEnum.of("type", BlockFlowers.EnumFlowerVarient.class, new Predicate<EnumFlowerVarient>() {
				@Override
				public boolean apply(BlockFlowers.EnumFlowerVarient varient) {
					return varient.getType() == BlockFlowers.this.getFlowerType();
				}
			});
		}
		return TYPE;
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(getFlowerVarients()).getId();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { getFlowerVarients() });
	}

	public static enum EnumFlowerVarient implements INamable {
		DANDELION(BlockFlowers.EnumFlowerType.YELLOW, 0, "dandelion"),
		POPPY(BlockFlowers.EnumFlowerType.RED, 0, "poppy"),
		BLUE_ORCHID(BlockFlowers.EnumFlowerType.RED, 1, "blue_orchid", "blueOrchid"),
		ALLIUM(BlockFlowers.EnumFlowerType.RED, 2, "allium"),
		HOUSTONIA(BlockFlowers.EnumFlowerType.RED, 3, "houstonia"),
		RED_TULIP(BlockFlowers.EnumFlowerType.RED, 4, "red_tulip", "tulipRed"),
		ORANGE_TULIP(BlockFlowers.EnumFlowerType.RED, 5, "orange_tulip", "tulipOrange"),
		WHITE_TULIP(BlockFlowers.EnumFlowerType.RED, 6, "white_tulip", "tulipWhite"),
		PINK_TULIP(BlockFlowers.EnumFlowerType.RED, 7, "pink_tulip", "tulipPink"),
		OXEYE_DAISY(BlockFlowers.EnumFlowerType.RED, 8, "oxeye_daisy", "oxeyeDaisy");

		private static final BlockFlowers.EnumFlowerVarient[][] BY_ID;
		private final BlockFlowers.EnumFlowerType type;
		private final int id;
		private final String name;
		private final String o;

		private EnumFlowerVarient(EnumFlowerType type, int var4, String var5) {
			this(type, var4, var5, var5);
		}

		private EnumFlowerVarient(EnumFlowerType type, int var4, String var5, String var6) {
			this.type = type;
			this.id = var4;
			this.name = var5;
			this.o = var6;
		}

		public EnumFlowerType getType() {
			return type;
		}

		public int getId() {
			return id;
		}

		public static BlockFlowers.EnumFlowerVarient getById(EnumFlowerType type, int id) {
			BlockFlowers.EnumFlowerVarient[] var2 = BY_ID[type.ordinal()];
			if ((id < 0) || (id >= var2.length)) {
				id = 0;
			}

			return var2[id];
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
			return o;
		}

		static {
			BY_ID = new EnumFlowerVarient[EnumFlowerType.values().length][];
			for (final EnumFlowerType flowertype : EnumFlowerType.values()) {
				Collection<EnumFlowerVarient> varients = Collections2.filter(Lists.newArrayList(values()), new Predicate<EnumFlowerVarient>() {
					@Override
					public boolean apply(EnumFlowerVarient varient) {
						return varient.getType() == flowertype;
					}
				});
				BY_ID[flowertype.ordinal()] = varients.toArray(new EnumFlowerVarient[varients.size()]);
			}
		}

	}

	public static enum EnumFlowerType {
		YELLOW, RED;

		public BlockFlowers isYellow() {
			return this == YELLOW ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
		}
	}

}
