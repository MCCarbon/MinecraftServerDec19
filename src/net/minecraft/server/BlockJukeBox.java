package net.minecraft.server;


public class BlockJukeBox extends BlockContainer {

	public static final BlockStateBoolean HAS_RECORD = BlockStateBoolean.of("has_record");

	protected BlockJukeBox() {
		super(Material.WOOD, MaterialMapColor.COLOR11);
		setBlockData(blockStateList.getFirst().set(HAS_RECORD, Boolean.valueOf(false)));
		setCreativeTab(CreativeTab.DECORATIONS);
	}

	@Override
	public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
		if (var3.get(HAS_RECORD).booleanValue()) {
			this.e(var1, var2, var3);
			var3 = var3.set(HAS_RECORD, Boolean.valueOf(false));
			var1.setTypeAndData(var2, var3, 2);
			return true;
		} else {
			return false;
		}
	}

	public void a(World var1, BlockPosition var2, IBlockData var3, ItemStack var4) {
		if (!var1.isClientSide) {
			TileEntity var5 = var1.getTileEntity(var2);
			if (var5 instanceof BlockJukeBox.TileEntityRecordPlayer) {
				((BlockJukeBox.TileEntityRecordPlayer) var5).a(new ItemStack(var4.getItem(), 1, var4.i()));
				var1.setTypeAndData(var2, var3.set(HAS_RECORD, Boolean.valueOf(true)), 2);
			}
		}
	}

	private void e(World var1, BlockPosition var2, IBlockData var3) {
		if (!var1.isClientSide) {
			TileEntity var4 = var1.getTileEntity(var2);
			if (var4 instanceof BlockJukeBox.TileEntityRecordPlayer) {
				BlockJukeBox.TileEntityRecordPlayer var5 = (BlockJukeBox.TileEntityRecordPlayer) var4;
				ItemStack var6 = var5.a();
				if (var6 != null) {
					var1.b(1005, var2, 0);
					var1.a(var2, (String) null);
					var5.a((ItemStack) null);
					float var7 = 0.7F;
					double var8 = var1.random.nextFloat() * var7 + ((1.0F - var7) * 0.5D);
					double var10 = var1.random.nextFloat() * var7 + ((1.0F - var7) * 0.2D) + 0.6D;
					double var12 = var1.random.nextFloat() * var7 + ((1.0F - var7) * 0.5D);
					ItemStack var14 = var6.clone();
					EntityItem var15 = new EntityItem(var1, var2.getX() + var8, var2.getY() + var10, var2.getZ() + var12, var14);
					var15.setPickupDelay();
					var1.addEntity(var15);
				}
			}
		}
	}

	@Override
	public void remove(World var1, BlockPosition var2, IBlockData var3) {
		this.e(var1, var2, var3);
		super.remove(var1, var2, var3);
	}

	@Override
	public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
		if (!var1.isClientSide) {
			super.dropNaturally(var1, var2, var3, var4, 0);
		}
	}

	@Override
	public TileEntity createTileEntity(World var1, int var2) {
		return new BlockJukeBox.TileEntityRecordPlayer();
	}

	@Override
	public boolean isComplexRedstone() {
		return true;
	}

	@Override
	public int getRedstonePower(World var1, BlockPosition var2) {
		TileEntity var3 = var1.getTileEntity(var2);
		if (var3 instanceof BlockJukeBox.TileEntityRecordPlayer) {
			ItemStack var4 = ((BlockJukeBox.TileEntityRecordPlayer) var3).a();
			if (var4 != null) {
				return (Item.getId(var4.getItem()) + 1) - Item.getId(Items.ct);
			}
		}

		return 0;
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(HAS_RECORD, Boolean.valueOf(var1 > 0));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(HAS_RECORD).booleanValue() ? 1 : 0;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { HAS_RECORD });
	}

	public static class TileEntityRecordPlayer extends TileEntity {
		private ItemStack a;

		@Override
		public void read(NBTTagCompound var1) {
			super.read(var1);
			if (var1.hasOfType("RecordItem", 10)) {
				this.a(ItemStack.a(var1.getCompound("RecordItem")));
			} else if (var1.getInt("Record") > 0) {
				this.a(new ItemStack(Item.getById(var1.getInt("Record"))));
			}

		}

		@Override
		public void write(NBTTagCompound var1) {
			super.write(var1);
			if (this.a() != null) {
				var1.put("RecordItem", this.a().write(new NBTTagCompound()));
			}

		}

		public ItemStack a() {
			return a;
		}

		public void a(ItemStack var1) {
			a = var1;
			update();
		}
	}

}
