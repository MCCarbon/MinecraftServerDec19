package net.minecraft.server;

import net.minecraft.server.BlockWood.EnumLogVariant;

import com.google.common.base.Predicate;

public class BlockLeaves1 extends BlockLeaves {

	public static final BlockStateEnum<EnumLogVariant> VARIANT = BlockStateEnum.of("variant", EnumLogVariant.class, new Predicate<EnumLogVariant>() {
		public boolean apply(EnumLogVariant var1) {
			return var1.getId() < 4;
		}
	});

	public BlockLeaves1() {
		setBlockData(blockStateList.getFirst().set(VARIANT, BlockWood.EnumLogVariant.OAK).set(CHECK_DECAY, Boolean.valueOf(true)).set(DECAYABLE, Boolean.valueOf(true)));
	}

	@Override
	protected void a(World var1, BlockPosition var2, IBlockData var3, int var4) {
		if ((var3.get(VARIANT) == BlockWood.EnumLogVariant.OAK) && (var1.random.nextInt(var4) == 0)) {
			dropItem(var1, var2, new ItemStack(Items.APPLE));
		}

	}

	@Override
	protected int d(IBlockData var1) {
		return var1.get(VARIANT) == BlockWood.EnumLogVariant.JUNGLE ? 40 : super.d(var1);
	}

	@Override
	protected ItemStack createItemStack(IBlockData var1) {
		return new ItemStack(Item.getItemOf(this), 1, ((BlockWood.EnumLogVariant) var1.get(VARIANT)).getId());
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(VARIANT, this.b(var1)).set(DECAYABLE, Boolean.valueOf((var1 & 4) == 0)).set(CHECK_DECAY, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockWood.EnumLogVariant) var1.get(VARIANT)).getId();
		if (!var1.get(DECAYABLE).booleanValue()) {
			var3 |= 4;
		}

		if (var1.get(CHECK_DECAY).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public BlockWood.EnumLogVariant b(int var1) {
		return BlockWood.EnumLogVariant.getById((var1 & 3) % 4);
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { VARIANT, CHECK_DECAY, DECAYABLE });
	}

	@Override
	public int getDropData(IBlockData var1) {
		return ((BlockWood.EnumLogVariant) var1.get(VARIANT)).getId();
	}

	@Override
	public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
		if (!var1.isClientSide && (var6 != null) && (var6.getItem() == Items.bg)) {
			var2.b(StatisticList.ab[Block.getId(this)]);
			dropItem(var1, var3, new ItemStack(Item.getItemOf(this), 1, ((BlockWood.EnumLogVariant) var4.get(VARIANT)).getId()));
		} else {
			super.breakBlockNaturally(var1, var2, var3, var4, var5, var6);
		}
	}

}
