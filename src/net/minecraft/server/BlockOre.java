package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

	public BlockOre() {
		this(Material.STONE.getMapColor());
	}

	public BlockOre(MaterialMapColor mapcolor) {
		super(Material.STONE, mapcolor);
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public Item getDropType(IBlockData blockdata, Random rnd, int fortune) {
		return this == Blocks.COAL_ORE ? Items.j : (this == Blocks.DIAMOND_ORE ? Items.k : (this == Blocks.LAPIS_ORE ? Items.aY : (this == Blocks.EMERALD_ORE ? Items.bR : (this == Blocks.QUARTZ_ORE ? Items.cj : Item.getItemOf(this)))));
	}

	@Override
	public int getDropCount(Random rnd) {
		return this == Blocks.LAPIS_ORE ? 4 + rnd.nextInt(5) : 1;
	}

	@Override
	public int getDropCount(int fortune, Random rnd) {
		if ((fortune > 0) && (Item.getItemOf(this) != getDropType((IBlockData) getBlockStateList().a().iterator().next(), rnd, fortune))) {
			int rndI = rnd.nextInt(fortune + 2) - 1;
			if (rndI < 0) {
				rndI = 0;
			}

			return this.getDropCount(rnd) * (rndI + 1);
		} else {
			return this.getDropCount(rnd);
		}
	}

	@Override
	public void dropNaturally(World world, BlockPosition position, IBlockData blockdata, float chance, int fortune) {
		super.dropNaturally(world, position, blockdata, chance, fortune);
		if (getDropType(blockdata, world.random, fortune) != Item.getItemOf(this)) {
			int exp = 0;
			if (this == Blocks.COAL_ORE) {
				exp = MathHelper.getRandomIntInRange(world.random, 0, 2);
			} else if (this == Blocks.DIAMOND_ORE) {
				exp = MathHelper.getRandomIntInRange(world.random, 3, 7);
			} else if (this == Blocks.EMERALD_ORE) {
				exp = MathHelper.getRandomIntInRange(world.random, 3, 7);
			} else if (this == Blocks.LAPIS_ORE) {
				exp = MathHelper.getRandomIntInRange(world.random, 2, 5);
			} else if (this == Blocks.QUARTZ_ORE) {
				exp = MathHelper.getRandomIntInRange(world.random, 2, 5);
			}

			dropExperience(world, position, exp);
		}

	}

	@Override
	public int getDropData(World world, BlockPosition position) {
		return 0;
	}

	@Override
	public int getDropData(IBlockData blockdata) {
		return this == Blocks.LAPIS_ORE ? EnumColor.l.b() : 0;
	}

}
