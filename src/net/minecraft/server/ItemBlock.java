package net.minecraft.server;

public class ItemBlock extends Item {

	protected final Block block;

	public ItemBlock(Block block) {
		this.block = block;
	}

	public ItemBlock b(String var1) {
		super.setName(var1);
		return this;
	}

	public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
		IBlockData var10 = var3.getType(var4);
		Block var11 = var10.getBlock();
		if (!var11.isReplaceable(var3, var4)) {
			var4 = var4.shift(var6);
		}

		if (var1.count == 0) {
			return UseResult.CANT_USE;
		} else if (!var2.a(var4, var6, var1)) {
			return UseResult.CANT_USE;
		} else if (var3.a(this.block, var4, false, var6, (Entity) null, var1)) {
			int var12 = this.filterData(var1.i());
			IBlockData var13 = this.block.getPlacedState(var3, var4, var6, var7, var8, var9, var12, var2);
			if (var3.setTypeAndData((BlockPosition) var4, (IBlockData) var13, 3)) {
				var13 = var3.getType(var4);
				if (var13.getBlock() == this.block) {
					a(var3, var2, var4, var1);
					this.block.postPlace(var3, var4, var13, var2, var1);
				}

				var3.a((double) ((float) var4.getX() + 0.5F), (double) ((float) var4.getY() + 0.5F), (double) ((float) var4.getZ() + 0.5F), this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getPitch() * 0.8F);
				--var1.count;
			}

			return UseResult.SUCCESS;
		} else {
			return UseResult.CANT_USE;
		}
	}

	public static boolean a(World var0, EntityHuman var1, BlockPosition var2, ItemStack var3) {
		MinecraftServer var4 = MinecraftServer.N();
		if (var4 == null) {
			return false;
		} else {
			if (var3.hasTag() && var3.getTag().hasOfType("BlockEntityTag", 10)) {
				TileEntity var5 = var0.getTileEntity(var2);
				if (var5 != null) {
					if (!var0.isClientSide && var5.F() && !var4.getPlayerList().h(var1.cf())) {
						return false;
					}

					NBTTagCompound var6 = new NBTTagCompound();
					NBTTagCompound var7 = (NBTTagCompound) var6.clone();
					var5.write(var6);
					NBTTagCompound var8 = (NBTTagCompound) var3.getTag().getTag("BlockEntityTag");
					var6.copyFrom(var8);
					var6.put("x", var2.getX());
					var6.put("y", var2.getY());
					var6.put("z", var2.getZ());
					if (!var6.equals(var7)) {
						var5.read(var6);
						var5.update();
						return true;
					}
				}
			}

			return false;
		}
	}

	public String getName(ItemStack var1) {
		return this.block.getInternalName();
	}

	public String getName() {
		return this.block.getInternalName();
	}

	public Block getBlock() {
		return this.block;
	}

	// $FF: synthetic method
	public Item setName(String var1) {
		return this.b(var1);
	}
}
