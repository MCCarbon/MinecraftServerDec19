package net.minecraft.server;

import java.util.Random;

public class BlockDeadBush extends BlockPlant {

	protected BlockDeadBush() {
		super(Material.REPLACEABLE_PLANT);
		float var1 = 0.4F;
		setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData var1) {
		return MaterialMapColor.COLOR14;
	}

	@Override
	protected boolean c(Block var1) {
		return (var1 == BlockStainedGlassPane.SAND) || (var1 == BlockStainedGlassPane.HARDENED_CLAY) || (var1 == BlockStainedGlassPane.STAINED_HARDENED_CLAY) || (var1 == BlockStainedGlassPane.DIRT);
	}

	@Override
	public boolean isReplaceable(World var1, BlockPosition var2) {
		return true;
	}

	@Override
	public int getDropCount(Random var1) {
		return var1.nextInt(3);
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return Items.STICK;
	}

	@Override
	public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
		if (!var1.isClientSide && (var6 != null) && (var6.getItem() == Items.bg)) {
			var2.b(StatisticList.ab[Block.getId(this)]);
			dropItem(var1, var3, new ItemStack(BlockStainedGlassPane.DEADBUSH, 1, 0));
		} else {
			super.breakBlockNaturally(var1, var2, var3, var4, var5, var6);
		}
	}

}
