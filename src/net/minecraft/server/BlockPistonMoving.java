package net.minecraft.server;

import java.util.Random;

import net.minecraft.server.BlockPistonExtension.EnumPistonType;

public class BlockPistonMoving extends BlockContainer {

	public static final BlockStateDirection FACING = BlockPistonExtension.FACING;
	public static final BlockStateEnum<EnumPistonType> TYPE = BlockPistonExtension.TYPE;

	public BlockPistonMoving() {
		super(Material.PISTON);
		setBlockData(blockStateList.getFirst().set(FACING, EnumDirection.NORTH).set(TYPE, BlockPistonExtension.EnumPistonType.DEFAULT));
		setStrength(-1.0F);
	}

	@Override
	public TileEntity createTileEntity(World var1, int var2) {
		return null;
	}

	public static TileEntity a(IBlockData var0, EnumDirection var1, boolean var2, boolean var3) {
		return new TileEntityPiston(var0, var1, var2, var3);
	}

	@Override
	public void remove(World var1, BlockPosition var2, IBlockData var3) {
		TileEntity var4 = var1.getTileEntity(var2);
		if (var4 instanceof TileEntityPiston) {
			((TileEntityPiston) var4).h();
		} else {
			super.remove(var1, var2, var3);
		}

	}

	@Override
	public boolean canPlace(World var1, BlockPosition var2) {
		return false;
	}

	@Override
	public boolean canPlace(World var1, BlockPosition var2, EnumDirection var3) {
		return false;
	}

	@Override
	public void postBreak(World var1, BlockPosition var2, IBlockData var3) {
		BlockPosition var4 = var2.shift(var3.get(FACING).opposite());
		IBlockData var5 = var1.getType(var4);
		if ((var5.getBlock() instanceof BlockPiston) && var5.get(BlockPiston.EXTENDED).booleanValue()) {
			var1.setAir(var4);
		}

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
		if (!var1.isClientSide && (var1.getTileEntity(var2) == null)) {
			var1.setAir(var2);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return null;
	}

	@Override
	public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
		if (!var1.isClientSide) {
			TileEntityPiston var6 = this.e((IBlockAccess) var1, var2);
			if (var6 != null) {
				IBlockData var7 = var6.b();
				var7.getBlock().dropNaturallyForSure(var1, var2, var7, 0);
			}
		}
	}

	@Override
	public MovingObjectPosition rayTraceCollision(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
		return null;
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		if (!var1.isClientSide) {
			var1.getTileEntity(var2);
		}

	}

	@Override
	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
		TileEntityPiston var4 = this.e((IBlockAccess) var1, var2);
		if (var4 == null) {
			return null;
		} else {
			float var5 = var4.a(0.0F);
			if (var4.d()) {
				var5 = 1.0F - var5;
			}

			return this.a(var1, var2, var4.b(), var5, var4.e());
		}
	}

	@Override
	public void updateShape(IBlockAccess var1, BlockPosition var2) {
		TileEntityPiston var3 = this.e(var1, var2);
		if (var3 != null) {
			IBlockData var4 = var3.b();
			Block var5 = var4.getBlock();
			if ((var5 == this) || (var5.getMaterial() == Material.AIR)) {
				return;
			}

			float var6 = var3.a(0.0F);
			if (var3.d()) {
				var6 = 1.0F - var6;
			}

			var5.updateShape(var1, var2);
			if ((var5 == Blocks.PISTON) || (var5 == Blocks.STICKY_PISTON)) {
				var6 = 0.0F;
			}

			EnumDirection var7 = var3.e();
			minX = var5.getMinX() - var7.getAdjacentX() * var6;
			minY = var5.getMinY() - var7.getAdjacentY() * var6;
			minZ = var5.getMinZ() - var7.getAdjacentZ() * var6;
			maxX = var5.getMaxX() - var7.getAdjacentX() * var6;
			maxY = var5.getMaxY() - var7.getAdjacentY() * var6;
			maxZ = var5.getMaxZ() - var7.getAdjacentZ() * var6;
		}

	}

	public AxisAlignedBB a(World var1, BlockPosition var2, IBlockData var3, float var4, EnumDirection var5) {
		if ((var3.getBlock() != this) && (var3.getBlock().getMaterial() != Material.AIR)) {
			AxisAlignedBB var6 = var3.getBlock().getBoundingBox(var1, var2, var3);
			if (var6 == null) {
				return null;
			} else {
				double var7 = var6.xMin;
				double var9 = var6.yMin;
				double var11 = var6.zMin;
				double var13 = var6.xMax;
				double var15 = var6.yMax;
				double var17 = var6.zMax;
				if (var5.getAdjacentX() < 0) {
					var7 -= var5.getAdjacentX() * var4;
				} else {
					var13 -= var5.getAdjacentX() * var4;
				}

				if (var5.getAdjacentY() < 0) {
					var9 -= var5.getAdjacentY() * var4;
				} else {
					var15 -= var5.getAdjacentY() * var4;
				}

				if (var5.getAdjacentZ() < 0) {
					var11 -= var5.getAdjacentZ() * var4;
				} else {
					var17 -= var5.getAdjacentZ() * var4;
				}

				return new AxisAlignedBB(var7, var9, var11, var13, var15, var17);
			}
		} else {
			return null;
		}
	}

	private TileEntityPiston e(IBlockAccess var1, BlockPosition var2) {
		TileEntity var3 = var1.getTileEntity(var2);
		return var3 instanceof TileEntityPiston ? (TileEntityPiston) var3 : null;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(FACING, BlockPistonExtension.b(var1)).set(TYPE, (var1 & 8) > 0 ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
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
	public int toLegacyData(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | var1.get(FACING).getId();
		if (var1.get(TYPE) == BlockPistonExtension.EnumPistonType.STICKY) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { FACING, TYPE });
	}
}
