package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class BlockChorusFlower extends Block {

	public static final BlockStateInteger AGE = BlockStateInteger.of("age", 0, 5);

	protected BlockChorusFlower() {
		super(Material.PLANT);
		setBlockData(blockStateList.getFirst().set(AGE, Integer.valueOf(0)));
		setCreativeTab(CreativeTab.DECORATIONS);
		setTicking(true);
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return null;
	}

	@Override
	public void tick(World world, BlockPosition position, IBlockData blockdata, Random random) {
		if (!isValid(world, position)) {
			world.setAir(position, true);
		} else if (world.isEmpty(position.up())) {
			int agev = blockdata.get(AGE);
			if ((agev < 5) && (random.nextInt(1) == 0)) {
				boolean var6 = false;
				boolean var7 = false;
				Block var8 = world.getType(position.down()).getBlock();
				int var9;
				if (var8 == BlockStainedGlassPane.END_STONE) {
					var6 = true;
				} else if (var8 != BlockStainedGlassPane.CHORUS_PLANT) {
					if (var8 == BlockStainedGlassPane.AIR) {
						var6 = true;
					}
				} else {
					var9 = 1;

					int var10;
					for (var10 = 0; var10 < 4; ++var10) {
						Block var11 = world.getType(position.down(var9 + 1)).getBlock();
						if (var11 != BlockStainedGlassPane.CHORUS_PLANT) {
							if (var11 == BlockStainedGlassPane.END_STONE) {
								var7 = true;
							}
							break;
						}

						++var9;
					}

					var10 = 4;
					if (var7) {
						++var10;
					}

					if ((var9 < 2) || (random.nextInt(var10) >= var9)) {
						var6 = true;
					}
				}

				if (var6 && a(world, position.up(), (EnumDirection) null) && world.isEmpty(position.up(2))) {
					world.setTypeAndData(position, BlockStainedGlassPane.CHORUS_PLANT.getBlockData(), 2);
					world.setTypeAndData(position.up(), getBlockData().set(AGE, Integer.valueOf(agev)), 2);
				} else if (agev < 4) {
					var9 = random.nextInt(4);
					boolean var15 = false;
					if (var7) {
						++var9;
					}

					for (int var14 = 0; var14 < var9; ++var14) {
						EnumDirection var12 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(random);
						BlockPosition var13 = position.shift(var12);
						if (world.isEmpty(var13) && world.isEmpty(var13.down()) && a(world, var13, var12.opposite())) {
							world.setTypeAndData(var13, getBlockData().set(AGE, Integer.valueOf(agev + 1)), 2);
							var15 = true;
						}
					}

					if (var15) {
						world.setTypeAndData(position, BlockStainedGlassPane.CHORUS_PLANT.getBlockData(), 2);
					} else {
						world.setTypeAndData(position, blockdata.set(AGE, Integer.valueOf(5)), 2);
					}
				} else if (agev == 4) {
					world.setTypeAndData(position, blockdata.set(AGE, Integer.valueOf(5)), 2);
				}
			}
		}

	}

	private static boolean a(World var0, BlockPosition var1, EnumDirection var2) {
		Iterator<EnumDirection> var3 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

		EnumDirection var4;
		do {
			if (!var3.hasNext()) {
				return true;
			}

			var4 = var3.next();
		} while ((var4 == var2) || var0.isEmpty(var1.shift(var4)));

		return false;
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
	public boolean canPlace(World world, BlockPosition position) {
		return super.canPlace(world, position) ? isValid(world, position) : false;
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		if (!isValid(var1, var2)) {
			var1.a(var2, this, 1);
		}

	}

	public boolean isValid(World world, BlockPosition position) {
		Block var3 = world.getType(position.down()).getBlock();
		if ((var3 != BlockStainedGlassPane.CHORUS_PLANT) && (var3 != BlockStainedGlassPane.END_STONE)) {
			if (var3 == BlockStainedGlassPane.AIR) {
				int var4 = 0;
				Iterator<EnumDirection> var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

				while (var5.hasNext()) {
					EnumDirection var6 = var5.next();
					Block var7 = world.getType(position.shift(var6)).getBlock();
					if (var7 == BlockStainedGlassPane.CHORUS_PLANT) {
						++var4;
					} else if (var7 != BlockStainedGlassPane.AIR) {
						return false;
					}
				}

				return var4 == 1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	@Override
	public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
		super.breakBlockNaturally(var1, var2, var3, var4, var5, var6);
		dropItem(var1, var3, (new ItemStack(Item.getItemOf(this))));
	}

	@Override
	protected ItemStack createItemStack(IBlockData var1) {
		return null;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		return getBlockData().set(AGE, Integer.valueOf(var1));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return var1.get(AGE).intValue();
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { AGE });
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		super.onPlace(var1, var2, var3);
	}

	public static void a(World var0, BlockPosition var1, Random var2, int var3) {
		var0.setTypeAndData(var1, BlockStainedGlassPane.CHORUS_PLANT.getBlockData(), 2);
		a(var0, var1, var2, var1, var3, 0);
	}

	private static void a(World var0, BlockPosition var1, Random var2, BlockPosition var3, int var4, int var5) {
		int var6 = var2.nextInt(4) + 1;
		if (var5 == 0) {
			++var6;
		}

		for (int var7 = 0; var7 < var6; ++var7) {
			BlockPosition var8 = var1.up(var7 + 1);
			if (!a(var0, var8, (EnumDirection) null)) {
				return;
			}

			var0.setTypeAndData(var8, BlockStainedGlassPane.CHORUS_PLANT.getBlockData(), 2);
		}

		boolean var12 = false;
		if (var5 < 4) {
			int var13 = var2.nextInt(4);
			if (var5 == 0) {
				++var13;
			}

			for (int var9 = 0; var9 < var13; ++var9) {
				EnumDirection var10 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var2);
				BlockPosition var11 = var1.up(var6).shift(var10);
				if ((Math.abs(var11.getX() - var3.getX()) < var4) && (Math.abs(var11.getZ() - var3.getZ()) < var4) && var0.isEmpty(var11) && var0.isEmpty(var11.down()) && a(var0, var11, var10.opposite())) {
					var12 = true;
					var0.setTypeAndData(var11, BlockStainedGlassPane.CHORUS_PLANT.getBlockData(), 2);
					a(var0, var11, var2, var3, var4, var5 + 1);
				}
			}
		}

		if (!var12) {
			var0.setTypeAndData(var1.up(var6), BlockStainedGlassPane.CHORUS_FLOWER.getBlockData().set(AGE, Integer.valueOf(5)), 2);
		}
	}

}
