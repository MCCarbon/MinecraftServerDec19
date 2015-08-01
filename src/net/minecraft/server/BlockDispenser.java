package net.minecraft.server;

import java.util.Random;

public class BlockDispenser extends BlockContainer {

	public static final BlockStateDirection FACING = class_ahi.FACING;
	public static final BlockStateBoolean TRIGGERED = BlockStateBoolean.of("triggered");
	public static final RegistryDefault<Item, IDispenseBehavior> REGISTRY = new RegistryDefault<Item, IDispenseBehavior>(new DispenseBehaviorItem());

	protected Random O = new Random();

	protected BlockDispenser() {
		super(Material.STONE);
		setBlockData(blockStateList.getFirst().set(FACING, EnumDirection.NORTH).set(TRIGGERED, Boolean.valueOf(false)));
		setCreativeTab(CreativeTab.REDSTONE);
	}

	@Override
	public int tickInterval(World var1) {
		return 4;
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		super.onPlace(var1, var2, var3);
		this.e(var1, var2, var3);
	}

	private void e(World var1, BlockPosition var2, IBlockData var3) {
		if (!var1.isClientSide) {
			EnumDirection var4 = var3.get(FACING);
			boolean var5 = var1.getType(var2.north()).getBlock().isFullBlock();
			boolean var6 = var1.getType(var2.south()).getBlock().isFullBlock();
			if ((var4 == EnumDirection.NORTH) && var5 && !var6) {
				var4 = EnumDirection.SOUTH;
			} else if ((var4 == EnumDirection.SOUTH) && var6 && !var5) {
				var4 = EnumDirection.NORTH;
			} else {
				boolean var7 = var1.getType(var2.west()).getBlock().isFullBlock();
				boolean var8 = var1.getType(var2.east()).getBlock().isFullBlock();
				if ((var4 == EnumDirection.WEST) && var7 && !var8) {
					var4 = EnumDirection.EAST;
				} else if ((var4 == EnumDirection.EAST) && var8 && !var7) {
					var4 = EnumDirection.WEST;
				}
			}

			var1.setTypeAndData(var2, var3.set(FACING, var4).set(TRIGGERED, Boolean.valueOf(false)), 2);
		}
	}

	@Override
	public boolean interact(World world, BlockPosition position, IBlockData blockdata, EntityHuman player, EnumUsedHand hand, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
		if (world.isClientSide) {
			return true;
		} else {
			TileEntity tileentity = world.getTileEntity(position);
			if (tileentity instanceof TileEntityDispenser) {
				player.openContainer((IInventory) ((TileEntityDispenser) tileentity));
				if (tileentity instanceof TileEntityDropper) {
					player.b(StatisticList.O);
				} else {
					player.b(StatisticList.Q);
				}
			}

			return true;
		}
	}

	protected void dispense(World world, BlockPosition position) {
		SourceBlock sourceblock = new SourceBlock(world, position);
		TileEntityDispenser tileentity = (TileEntityDispenser) sourceblock.getTileEntity();
		if (tileentity != null) {
			int slot = tileentity.m();
			if (slot < 0) {
				world.b(1001, position, 0);
			} else {
				ItemStack var6 = tileentity.getItem(slot);
				IDispenseBehavior behaviour = this.a(var6);
				if (behaviour != IDispenseBehavior.NONE) {
					ItemStack itemstack = behaviour.a(sourceblock, var6);
					tileentity.setItem(slot, itemstack.count <= 0 ? null : itemstack);
				}
			}
		}
	}

	protected IDispenseBehavior a(ItemStack var1) {
		return REGISTRY.get(var1 == null ? null : var1.getItem());
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		boolean var5 = var1.isBlockIndirectlyPowered(var2) || var1.isBlockIndirectlyPowered(var2.up());
		boolean var6 = var3.get(TRIGGERED).booleanValue();
		if (var5 && !var6) {
			var1.a(var2, this, tickInterval(var1));
			var1.setTypeAndData(var2, var3.set(TRIGGERED, Boolean.valueOf(true)), 4);
		} else if (!var5 && var6) {
			var1.setTypeAndData(var2, var3.set(TRIGGERED, Boolean.valueOf(false)), 4);
		}

	}

	@Override
	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		if (!var1.isClientSide) {
			dispense(var1, var2);
		}
	}

	@Override
	public TileEntity createTileEntity(World var1, int var2) {
		return new TileEntityDispenser();
	}

	@Override
	public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return getBlockData().set(FACING, BlockPiston.a(var1, var2, var8)).set(TRIGGERED, Boolean.valueOf(false));
	}

	@Override
	public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack itemstack) {
		var1.setTypeAndData(var2, var3.set(FACING, BlockPiston.a(var1, var2, var4)), 2);
		if (itemstack.hasDisplayName()) {
			TileEntity tileentity = var1.getTileEntity(var2);
			if (tileentity instanceof TileEntityDispenser) {
				((TileEntityDispenser) tileentity).a(itemstack.getDisplayName());
			}
		}
	}

	@Override
	public void remove(World var1, BlockPosition var2, IBlockData var3) {
		TileEntity var4 = var1.getTileEntity(var2);
		if (var4 instanceof TileEntityDispenser) {
			class_ol.a(var1, var2, (TileEntityDispenser) var4);
			var1.e(var2, this);
		}

		super.remove(var1, var2, var3);
	}

	public static class_cz a(ISourceBlock var0) {
		EnumDirection var1 = b(var0.getData());
		double var2 = var0.getX() + (0.7D * var1.getAdjacentX());
		double var4 = var0.getY() + (0.7D * var1.getAdjacentY());
		double var6 = var0.getZ() + (0.7D * var1.getAdjacentZ());
		return new class_da(var2, var4, var6);
	}

	public static EnumDirection b(int var0) {
		return EnumDirection.getById(var0 & 7);
	}

	@Override
	public boolean isComplexRedstone() {
		return true;
	}

	@Override
	public int getRedstonePower(World var1, BlockPosition var2) {
		return Container.a(var1.getTileEntity(var2));
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(FACING, b(var1)).set(TRIGGERED, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | var1.get(FACING).getId();
		if (var1.get(TRIGGERED).booleanValue()) {
			var3 |= 8;
		}
		return var3;
	}

	@Override
	public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
		return var1.getBlock() != this ? var1 : var1.set(FACING, var2.a(var1.get(FACING)));
	}

	@Override
	public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
		return var1.getBlock() != this ? var1 : this.a(var1, var2.a(var1.get(FACING)));
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { FACING, TRIGGERED });
	}

}
