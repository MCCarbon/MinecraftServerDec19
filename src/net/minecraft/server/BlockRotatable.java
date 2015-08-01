package net.minecraft.server;

import net.minecraft.server.EnumDirection.EnumAxis;

public class BlockRotatable extends Block {

	public static final BlockStateEnum<EnumAxis> AXIS = BlockStateEnum.of("axis", EnumDirection.EnumAxis.class);

	protected BlockRotatable(Material material) {
		super(material, material.getMapColor());
	}

	protected BlockRotatable(Material material, MaterialMapColor mapcolor) {
		super(material, mapcolor);
	}

	@Override
	public IBlockData a(IBlockData blockdata, Block.EnumRotation rotation) {
		if (blockdata.getBlock() != this) {
			return blockdata;
		} else {
			switch (rotation) {
				case COUNTERCLOCKWISE_90:
				case CLOCKWISE_90:
					switch (blockdata.get(AXIS)) {
						case X:
							return blockdata.set(AXIS, EnumDirection.EnumAxis.Z);
						case Z:
							return blockdata.set(AXIS, EnumDirection.EnumAxis.X);
						default:
							return blockdata;
					}
				default:
					return blockdata;
			}
		}
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		EnumDirection.EnumAxis var2 = EnumDirection.EnumAxis.Y;
		int var3 = var1 & 12;
		if (var3 == 4) {
			var2 = EnumDirection.EnumAxis.X;
		} else if (var3 == 8) {
			var2 = EnumDirection.EnumAxis.Z;
		}

		return getBlockData().set(AXIS, var2);
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		int var2 = 0;
		EnumDirection.EnumAxis var3 = var1.get(AXIS);
		if (var3 == EnumDirection.EnumAxis.X) {
			var2 |= 4;
		} else if (var3 == EnumDirection.EnumAxis.Z) {
			var2 |= 8;
		}

		return var2;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { AXIS });
	}

	@Override
	protected ItemStack createItemStack(IBlockData var1) {
		return new ItemStack(Item.getByBlock(this));
	}

	@Override
	public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return super.getPlacedState(var1, var2, var3, var4, var5, var6, var7, var8).set(AXIS, var3.getAxis());
	}

}
