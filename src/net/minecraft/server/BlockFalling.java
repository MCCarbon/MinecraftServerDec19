package net.minecraft.server;

import java.util.Random;

public class BlockFalling extends Block {

	public static boolean instaFall;

	public BlockFalling() {
		super(Material.SAND);
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	public BlockFalling(Material material) {
		super(material);
	}

	@Override
	public void onPlace(World world, BlockPosition position, IBlockData blockdata) {
		world.a(position, this, tickInterval(world));
	}

	@Override
	public void doPhysics(World world, BlockPosition position, IBlockData blockdata, Block block) {
		world.a(position, this, tickInterval(world));
	}

	@Override
	public void tick(World world, BlockPosition position, IBlockData blockdata, Random r) {
		if (!world.isClientSide) {
			attemptFall(world, position);
		}
	}

	private void attemptFall(World world, BlockPosition position) {
		if (canFall(world, position.down()) && (position.getY() >= 0)) {
			byte add = 32;
			if (!instaFall && world.areChunksLoadedBetween(position.add(-add, -add, -add), position.add(add, add, add))) {
				if (!world.isClientSide) {
					EntityFallingBlock entity = new EntityFallingBlock(world, position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, world.getType(position));
					this.init(entity);
					world.addEntity(entity);
				}
			} else {
				world.setAir(position);

				BlockPosition sarchPos;
				for (sarchPos = position.down(); canFall(world, sarchPos) && (sarchPos.getY() > 0); sarchPos = sarchPos.down()) {
				}

				if (sarchPos.getY() > 0) {
					world.setTypeUpdate(sarchPos.up(), getBlockData());
				}
			}
		}
	}

	protected void init(EntityFallingBlock fallingblock) {
	}

	@Override
	public int tickInterval(World var1) {
		return 2;
	}

	public static boolean canFall(World world, BlockPosition position) {
		Block block = world.getType(position).getBlock();
		Material material = block.material;
		return (block == Blocks.FIRE) || (material == Material.AIR) || (material == Material.WATER) || (material == Material.LAVA);
	}

	public void a_(World var1, BlockPosition var2) {
	}

}
