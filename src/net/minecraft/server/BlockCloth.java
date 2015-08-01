package net.minecraft.server;


public class BlockCloth extends Block {

	public static final BlockStateEnum<EnumColor> COLOR = BlockStateEnum.of("color", EnumColor.class);

	public BlockCloth(Material var1) {
		super(var1);
		setBlockData(blockStateList.getFirst().set(COLOR, EnumColor.a));
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public int getDropData(IBlockData var1) {
		return var1.get(COLOR).a();
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData var1) {
		return var1.get(COLOR).e();
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(COLOR, EnumColor.b(var1));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(COLOR).a();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { COLOR });
	}

}
