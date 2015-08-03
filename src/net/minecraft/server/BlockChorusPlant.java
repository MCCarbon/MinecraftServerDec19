package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class BlockChorusPlant extends Block {

	public static final BlockStateBoolean NORTH = BlockStateBoolean.of("north");
	public static final BlockStateBoolean EAST = BlockStateBoolean.of("east");
	public static final BlockStateBoolean SOUTH = BlockStateBoolean.of("south");
	public static final BlockStateBoolean WEST = BlockStateBoolean.of("west");
	public static final BlockStateBoolean UP = BlockStateBoolean.of("up");
	public static final BlockStateBoolean DOWN = BlockStateBoolean.of("down");

	protected BlockChorusPlant() {
		super(Material.PLANT);
		setCreativeTab(CreativeTab.DECORATIONS);
		setBlockData(blockStateList.getFirst().set(NORTH, Boolean.valueOf(false)).set(EAST, Boolean.valueOf(false)).set(SOUTH, Boolean.valueOf(false)).set(WEST, Boolean.valueOf(false)).set(UP, Boolean.valueOf(false)).set(DOWN, Boolean.valueOf(false)));
	}

	@Override
	public IBlockData updateState(IBlockData blockdata, IBlockAccess access, BlockPosition position) {
		Block downB = access.getType(position.down()).getBlock();
		Block up = access.getType(position.up()).getBlock();
		Block north = access.getType(position.north()).getBlock();
		Block east = access.getType(position.east()).getBlock();
		Block south = access.getType(position.south()).getBlock();
		Block west = access.getType(position.west()).getBlock();
		return blockdata.set(DOWN, Boolean.valueOf((downB == this) || (downB == Blocks.CHORUS_FLOWER) || (downB == Blocks.END_STONE))).set(UP, Boolean.valueOf((up == this) || (up == Blocks.CHORUS_FLOWER))).set(NORTH, Boolean.valueOf((north == this) || (north == Blocks.CHORUS_FLOWER))).set(EAST, Boolean.valueOf((east == this) || (east == Blocks.CHORUS_FLOWER))).set(SOUTH, Boolean.valueOf((south == this) || (south == Blocks.CHORUS_FLOWER))).set(WEST, Boolean.valueOf((west == this) || (west == Blocks.CHORUS_FLOWER)));
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		return 0;
	}

	@Override
	public void tick(World world, BlockPosition position, IBlockData blockdata, Random rnd) {
		if (!isValid(world, position)) {
			world.setAir(position, true);
		}
	}

	@Override
	public Item getDropType(IBlockData var1, Random var2, int var3) {
		return Items.CHORUS_FRUIT;
	}

	@Override
	public int getDropCount(Random rnd) {
		return rnd.nextInt(2);
	}

	@Override
	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
		return super.getBoundingBox(var1, var2, var3);
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
		boolean upEmpty = world.isEmpty(position.up());
		boolean downEmpty = world.isEmpty(position.down());
		Iterator<EnumDirection> directionIt = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

		Block block;
		do {
			BlockPosition searchposition;
			Block searchblock;
			do {
				if (!directionIt.hasNext()) {
					Block var10 = world.getType(position.down()).getBlock();
					if ((var10 != this) && (var10 != Blocks.END_STONE)) {
						return false;
					}

					return true;
				}

				EnumDirection direction = directionIt.next();
				searchposition = position.shift(direction);
				searchblock = world.getType(searchposition).getBlock();
			} while (searchblock != this);

			if (!upEmpty && !downEmpty) {
				return false;
			}

			block = world.getType(searchposition.down()).getBlock();
		} while ((block != this) && (block != Blocks.END_STONE));

		return true;
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { NORTH, EAST, SOUTH, WEST, UP, DOWN });
	}

}
