package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public abstract class BlockFluids extends Block {

	public static final BlockStateInteger LEVEL = BlockStateInteger.of("level", 0, 15);

	protected BlockFluids(Material var1) {
		super(var1);
		setBlockData(blockStateList.getFirst().set(LEVEL, Integer.valueOf(0)));
		setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		setTicking(true);
	}

	@Override
	public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
		return material != Material.LAVA;
	}

	public static float b(int var0) {
		if (var0 >= 8) {
			var0 = 0;
		}

		return (var0 + 1) / 9.0F;
	}

	protected int e(IBlockAccess var1, BlockPosition var2) {
		return var1.getType(var2).getBlock().getMaterial() == material ? var1.getType(var2).get(LEVEL).intValue() : -1;
	}

	protected int f(IBlockAccess var1, BlockPosition var2) {
		int var3 = this.e(var1, var2);
		return var3 >= 8 ? 0 : var3;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean canCollide(IBlockData var1, boolean var2) {
		return var2 && (var1.get(LEVEL).intValue() == 0);
	}

	@Override
	public boolean isBuildable(IBlockAccess var1, BlockPosition var2, EnumDirection var3) {
		Material var4 = var1.getType(var2).getBlock().getMaterial();
		return var4 == material ? false : (var3 == EnumDirection.UP ? true : (var4 == Material.ICE ? false : super.isBuildable(var1, var2, var3)));
	}

	@Override
	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
		return null;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return null;
	}

	@Override
	public int getDropCount(Random var1) {
		return 0;
	}

	protected Vec3D h(IBlockAccess var1, BlockPosition var2) {
		Vec3D var3 = new Vec3D(0.0D, 0.0D, 0.0D);
		int var4 = f(var1, var2);
		Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

		EnumDirection var6;
		BlockPosition var7;
		while (var5.hasNext()) {
			var6 = (EnumDirection) var5.next();
			var7 = var2.shift(var6);
			int var8 = f(var1, var7);
			int var9;
			if (var8 < 0) {
				if (!var1.getType(var7).getBlock().getMaterial().isSolid()) {
					var8 = f(var1, var7.down());
					if (var8 >= 0) {
						var9 = var8 - (var4 - 8);
						var3 = var3.add((var7.getX() - var2.getX()) * var9, (var7.getY() - var2.getY()) * var9, (var7.getZ() - var2.getZ()) * var9);
					}
				}
			} else if (var8 >= 0) {
				var9 = var8 - var4;
				var3 = var3.add((var7.getX() - var2.getX()) * var9, (var7.getY() - var2.getY()) * var9, (var7.getZ() - var2.getZ()) * var9);
			}
		}

		if (var1.getType(var2).get(LEVEL).intValue() >= 8) {
			var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

			do {
				if (!var5.hasNext()) {
					return var3.normalize();
				}

				var6 = (EnumDirection) var5.next();
				var7 = var2.shift(var6);
			} while (!isBuildable(var1, var7, var6) && !isBuildable(var1, var7.up(), var6));

			var3 = var3.normalize().add(0.0D, -6.0D, 0.0D);
		}

		return var3.normalize();
	}

	@Override
	public Vec3D modifyVelocity(World var1, BlockPosition var2, Entity var3, Vec3D var4) {
		return var4.add(h(var1, var2));
	}

	@Override
	public int tickInterval(World var1) {
		return material == Material.WATER ? 5 : (material == Material.LAVA ? (var1.worldProvider.m() ? 10 : 30) : 0);
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		this.e(var1, var2, var3);
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		this.e(var1, var2, var3);
	}

	public boolean e(World var1, BlockPosition var2, IBlockData var3) {
		if (material == Material.LAVA) {
			boolean var4 = false;
			EnumDirection[] var5 = EnumDirection.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				EnumDirection var8 = var5[var7];
				if ((var8 != EnumDirection.DOWN) && (var1.getType(var2.shift(var8)).getBlock().getMaterial() == Material.WATER)) {
					var4 = true;
					break;
				}
			}

			if (var4) {
				Integer var9 = var3.get(LEVEL);
				if (var9.intValue() == 0) {
					var1.setTypeUpdate(var2, Blocks.OBSIDIAN.getBlockData());
					this.e(var1, var2);
					return true;
				}

				if (var9.intValue() <= 4) {
					var1.setTypeUpdate(var2, Blocks.COBBLESTONE.getBlockData());
					this.e(var1, var2);
					return true;
				}
			}
		}

		return false;
	}

	protected void e(World var1, BlockPosition var2) {
		double var3 = var2.getX();
		double var5 = var2.getY();
		double var7 = var2.getZ();
		var1.a(var3 + 0.5D, var5 + 0.5D, var7 + 0.5D, "random.fizz", 0.5F, 2.6F + ((var1.random.nextFloat() - var1.random.nextFloat()) * 0.8F));

		for (int var9 = 0; var9 < 8; ++var9) {
			var1.a(class_cy.m, var3 + Math.random(), var5 + 1.2D, var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(LEVEL, Integer.valueOf(var1));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(LEVEL).intValue();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { LEVEL });
	}

	public static BlockFlowing a(Material var0) {
		if (var0 == Material.WATER) {
			return Blocks.FLOWING_WATER;
		} else if (var0 == Material.LAVA) {
			return Blocks.FLOWING_LAVA;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}

	public static BlockStationary b(Material var0) {
		if (var0 == Material.WATER) {
			return Blocks.WATER;
		} else if (var0 == Material.LAVA) {
			return Blocks.LAVA;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}

}
