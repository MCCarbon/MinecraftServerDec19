package net.minecraft.server;

public class ItemBlockStep extends ItemBlock {

	private final BlockStepAbstract b;
	private final BlockStepAbstract c;

	public ItemBlockStep(Block var1, BlockStepAbstract var2, BlockStepAbstract var3) {
		super(var1);
		this.b = var2;
		this.c = var3;
		this.e(0);
		this.registerItemKey(true);
	}

	public int registerItemKey(int var1) {
		return var1;
	}

	public String e_(ItemStack var1) {
		return this.b.b(var1.i());
	}

	public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
		if (var1.count == 0) {
			return UseResult.CANT_USE;
		} else if (!var2.a(var4.shift(var6), var6, var1)) {
			return UseResult.CANT_USE;
		} else {
			Object var10 = this.b.a(var1);
			IBlockData var11 = var3.getType(var4);
			if (var11.getBlock() == this.b) {
				IBlockState var12 = this.b.getVariant();
				Comparable var13 = var11.get(var12);
				BlockStepAbstract.EnumSlabHalf var14 = (BlockStepAbstract.EnumSlabHalf) var11.get(BlockStepAbstract.HALF);
				if ((var6 == EnumDirection.UP && var14 == BlockStepAbstract.EnumSlabHalf.BOTTOM || var6 == EnumDirection.DOWN && var14 == BlockStepAbstract.EnumSlabHalf.TOP) && var13 == var10) {
					IBlockData var15 = this.c.getBlockData().set(var12, var13);
					if (var3.b(this.c.getBoundingBox(var3, var4, var15)) && var3.setTypeAndData((BlockPosition) var4, (IBlockData) var15, 3)) {
						var3.a((double) ((float) var4.getX() + 0.5F), (double) ((float) var4.getY() + 0.5F), (double) ((float) var4.getZ() + 0.5F), this.c.stepSound.getPlaceSound(), (this.c.stepSound.getVolume() + 1.0F) / 2.0F, this.c.stepSound.getPitch() * 0.8F);
						--var1.count;
					}

					return UseResult.SUCCESS;
				}
			}

			return this.a(var1, var3, var4.shift(var6), var10) ? UseResult.SUCCESS : super.registerItemKey(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}
	}

	private boolean a(ItemStack var1, World var2, BlockPosition var3, Object var4) {
		IBlockData var5 = var2.getType(var3);
		if (var5.getBlock() == this.b) {
			Comparable<?> var6 = var5.get(this.b.getVariant());
			if (var6 == var4) {
				IBlockData var7 = this.c.getBlockData().set((BlockState) this.b.getVariant(), var6);
				if (var2.b(this.c.getBoundingBox(var2, var3, var7)) && var2.setTypeAndData((BlockPosition) var3, (IBlockData) var7, 3)) {
					var2.a((double) ((float) var3.getX() + 0.5F), (double) ((float) var3.getY() + 0.5F), (double) ((float) var3.getZ() + 0.5F), this.c.stepSound.getPlaceSound(), (this.c.stepSound.getVolume() + 1.0F) / 2.0F, this.c.stepSound.getPitch() * 0.8F);
					--var1.count;
				}

				return true;
			}
		}

		return false;
	}
}
