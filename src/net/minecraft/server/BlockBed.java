package net.minecraft.server;

import java.util.Random;

public class BlockBed extends BlockDirectional {

	public static final BlockStateEnum<EnumBedPart> PART = BlockStateEnum.of("part", EnumBedPart.class);
	public static final BlockStateBoolean OCCUPIED = BlockStateBoolean.of("occupied");

	public BlockBed() {
		super(Material.CLOTH);
		setBlockData(blockStateList.getFirst().set(PART, BlockBed.EnumBedPart.FOOT).set(OCCUPIED, Boolean.valueOf(false)));
		updateShape0();
	}

	@Override
	public boolean interact(World world, BlockPosition position, IBlockData blockdata, EntityHuman player, EnumUsedHand hand, ItemStack itemstack, EnumDirection face, float var8, float var9, float var10) {
		if (world.isClientSide) {
			return true;
		} else {
			if (blockdata.get(PART) != BlockBed.EnumBedPart.HEAD) {
				position = position.shift(blockdata.get(FACING));
				blockdata = world.getType(position);
				if (blockdata.getBlock() != this) {
					return true;
				}
			}

			if (world.worldProvider.e() && (world.b(position) != BiomeBase.x)) {
				if (blockdata.get(OCCUPIED).booleanValue()) {
					EntityHuman otherplayer = findPlayerOnBed(world, position);
					if (otherplayer != null) {
						player.b(new ChatMessage("tile.bed.occupied"));
						return true;
					}

					blockdata = blockdata.set(OCCUPIED, false);
					world.setTypeAndData(position, blockdata, 4);
				}

				EntityHuman.EnumBedResult bedresult = player.trySleepOnBed(position);
				if (bedresult == EntityHuman.EnumBedResult.OK) {
					blockdata = blockdata.set(OCCUPIED, true);
					world.setTypeAndData(position, blockdata, 4);
					return true;
				} else {
					if (bedresult == EntityHuman.EnumBedResult.NOT_POSSIBLE_NOW) {
						player.b(new ChatMessage("tile.bed.noSleep"));
					} else if (bedresult == EntityHuman.EnumBedResult.NOT_SAFE) {
						player.b(new ChatMessage("tile.bed.notSafe"));
					}

					return true;
				}
			} else {
				world.setAir(position);
				BlockPosition thispart = position.shift(blockdata.get(FACING).getOpposite());
				if (world.getType(thispart).getBlock() == this) {
					world.setAir(thispart);
				}

				world.createExplosion(null, position.getX() + 0.5D, position.getY() + 0.5D, position.getZ() + 0.5D, 5.0F, true, true);
				return true;
			}
		}
	}

	private EntityHuman findPlayerOnBed(World world, BlockPosition bedposition) {
		for (EntityHuman human : world.players) {
			if (human.isSleeping() && human.bedPosition.equals(bedposition)) {
				return human;
			}
		}
		return null;
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
	public void updateShape(IBlockAccess var1, BlockPosition var2) {
		updateShape0();
	}

	@Override
	public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
		EnumDirection var5 = var3.get(FACING);
		if (var3.get(PART) == BlockBed.EnumBedPart.HEAD) {
			if (var1.getType(var2.shift(var5.getOpposite())).getBlock() != this) {
				var1.setAir(var2);
			}
		} else if (var1.getType(var2.shift(var5)).getBlock() != this) {
			var1.setAir(var2);
			if (!var1.isClientSide) {
				dropNaturallyForSure(var1, var2, var3, 0);
			}
		}

	}

	@Override
	public Item getDropType(IBlockData blockdata, Random rnd, int fortune) {
		return blockdata.get(PART) == BlockBed.EnumBedPart.HEAD ? null : Items.bc;
	}

	private void updateShape0() {
		setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	}

	public static BlockPosition a(World world, BlockPosition position, int var2) {
		EnumDirection facing = world.getType(position).get(FACING);
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();

		for (int i = 0; i <= 1; ++i) {
			int var8 = x - (facing.getAdjacentX() * i) - 1;
			int var9 = z - (facing.getAdjacentZ() * i) - 1;
			int var10 = var8 + 2;
			int var11 = var9 + 2;

			for (int var12 = var8; var12 <= var10; ++var12) {
				for (int var13 = var9; var13 <= var11; ++var13) {
					BlockPosition var14 = new BlockPosition(var12, y, var13);
					if (e(world, var14)) {
						if (var2 <= 0) {
							return var14;
						}

						--var2;
					}
				}
			}
		}

		return null;
	}

	protected static boolean e(World var0, BlockPosition var1) {
		return World.a(var0, var1.down()) && !var0.getType(var1).getBlock().getMaterial().isBuildable() && !var0.getType(var1.up()).getBlock().getMaterial().isBuildable();
	}

	@Override
	public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
		if (var3.get(PART) == BlockBed.EnumBedPart.FOOT) {
			super.dropNaturally(var1, var2, var3, var4, 0);
		}

	}

	@Override
	public int getPushReaction() {
		return 1;
	}

	@Override
	public void a(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4) {
		if (var4.bH.instabuild && (var3.get(PART) == BlockBed.EnumBedPart.HEAD)) {
			BlockPosition var5 = var2.shift(var3.get(FACING).getOpposite());
			if (var1.getType(var5).getBlock() == this) {
				var1.setAir(var5);
			}
		}

	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		EnumDirection var2 = EnumDirection.getByHorizontalId(var1);
		return (var1 & 8) > 0 ? getBlockData().set(PART, BlockBed.EnumBedPart.HEAD).set(FACING, var2).set(OCCUPIED, Boolean.valueOf((var1 & 4) > 0)) : getBlockData().set(PART, BlockBed.EnumBedPart.FOOT).set(FACING, var2);
	}

	@Override
	public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
		if (var1.get(PART) == BlockBed.EnumBedPart.FOOT) {
			IBlockData var4 = var2.getType(var3.shift(var1.get(FACING)));
			if (var4.getBlock() == this) {
				var1 = var1.set(OCCUPIED, var4.get(OCCUPIED));
			}
		}

		return var1;
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
	public int toLegacyData(IBlockData blockdata) {
		byte var2 = 0;
		int var3 = var2 | blockdata.get(FACING).getHorizontalId();
		if (blockdata.get(PART) == BlockBed.EnumBedPart.HEAD) {
			var3 |= 8;
			if (blockdata.get(OCCUPIED)) {
				var3 |= 4;
			}
		}
		return var3;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { FACING, PART, OCCUPIED });
	}

	public static enum EnumBedPart implements INamable {
		HEAD("head"), FOOT("foot");

		private final String name;

		private EnumBedPart(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public String getName() {
			return name;
		}

	}
}
