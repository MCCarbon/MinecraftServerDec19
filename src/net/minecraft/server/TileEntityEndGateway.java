package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TileEntityEndGateway extends TileEntity implements ITickAble {

	private static final Logger looger = LogManager.getLogger();
	private long life = 0L;
	private int teleporCooldown = 0;
	private BlockPosition exitPos;

	@Override
	public void write(NBTTagCompound compound) {
		super.write(compound);
		compound.put("Life", life);
		if (exitPos != null) {
			compound.put("ExitPortal", class_dy.a(exitPos));
		}
	}

	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		life = compound.getLong("Life");
		if (compound.hasOfType("ExitPortal", 10)) {
			exitPos = class_dy.c(compound.getCompound("ExitPortal"));
		}
	}

	@Override
	public void tick() {
		boolean justSpawned = this.justSpawned();
		boolean atCooddown = isAtCooldown();
		++life;
		if (atCooddown) {
			--teleporCooldown;
		} else if (!world.isClientSide) {
			List<Entity> list = world.getEntities(Entity.class, new AxisAlignedBB(getPosition()));
			if (!list.isEmpty()) {
				this.teleport(list.get(0));
			}
		}

		if ((justSpawned != this.justSpawned()) || (atCooddown != isAtCooldown())) {
			this.update();
		}
	}

	public boolean justSpawned() {
		return life < 200L;
	}

	public boolean isAtCooldown() {
		return teleporCooldown > 0;
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound data = new NBTTagCompound();
		write(data);
		return new PacketPlayOutTileEntityData(position, 8, data);
	}

	public void afterTeleport() {
		if (!world.isClientSide) {
			teleporCooldown = 20;
			world.playBlockAction(getPosition(), getBlock(), 1, 0);
			update();
		}
	}

	@Override
	public boolean handleClientInput(int id, int value) {
		if (id == 1) {
			teleporCooldown = 20;
			return true;
		} else {
			return super.handleClientInput(id, value);
		}
	}

	public void teleport(Entity entity) {
		if (!world.isClientSide && !isAtCooldown()) {
			teleporCooldown = 100;
			if ((exitPos == null) && (world.worldProvider instanceof WorldProviderTheEnd)) {
				generateExitPosition();
			}

			if (exitPos != null) {
				BlockPosition position = findExitPosition();
				entity.enderTeleportTo(position.getX() + 0.5D, position.getY() + 1.5D, position.getZ() + 0.5D);
			}

			afterTeleport();
		}
	}

	private BlockPosition findExitPosition() {
		BlockPosition position = findExitPosition(world, exitPos, 5, false);
		looger.debug("Best exit position for portal at " + exitPos + " is " + position);
		return position.up();
	}

	private void generateExitPosition() {
		Vec3D normalized = (new Vec3D(getPosition().getX(), 0.0D, getPosition().getZ())).normalize();
		Vec3D mul = normalized.multiply(1024.0D);

		for (int i = 16; (getChunkAtWorldCoords(world, mul).getHighestChunkSectionY() > 0) && (i-- > 0); mul = mul.add(normalized.multiply(-16.0D))) {
			looger.debug("Skipping backwards past nonempty chunk at " + mul);
		}

		for (int i = 16; (getChunkAtWorldCoords(world, mul).getHighestChunkSectionY() == 0) && (i-- > 0); mul = mul.add(normalized.multiply(16.0D))) {
			looger.debug("Skipping forward past empty chunk at " + mul);
		}

		looger.debug("Found chunk at " + mul);
		Chunk chunk = getChunkAtWorldCoords(world, mul);
		exitPos = findPlatformPosition(chunk);
		if (exitPos == null) {
			exitPos = new BlockPosition(mul.x + 0.5D, 75.0D, mul.z + 0.5D);
			looger.debug("Failed to find suitable block, settling on " + exitPos);
			new EndGatewayPlatformGenerator().generate(world, new Random(exitPos.asLong()), exitPos);
		} else {
			looger.debug("Found block at " + exitPos);
		}

		exitPos = findExitPosition(world, exitPos, 16, true);
		looger.debug("Creating portal at " + exitPos);
		exitPos = exitPos.up(10);
		this.generateGateway(exitPos);
		update();
	}

	private static BlockPosition findExitPosition(World world, BlockPosition startPoint, int radius, boolean anyY) {
		BlockPosition result = null;
		for (int x = -radius; x <= radius; ++x) {
			for (int z = -radius; z <= radius; ++z) {
				if ((x != 0) || (z != 0) || anyY) {
					for (int y = 255; y > (result == null ? 0 : result.getY()); --y) {
						BlockPosition search = new BlockPosition(startPoint.getX() + x, y, startPoint.getZ() + z);
						IBlockData blockdata = world.getType(search);
						if (blockdata.getBlock().isSoildFullCube() && (anyY || (blockdata.getBlock() != Blocks.BEDROCK))) {
							result = search;
							break;
						}
					}
				}
			}
		}

		return result == null ? startPoint : result;
	}

	private static Chunk getChunkAtWorldCoords(World world, Vec3D vec) {
		return world.getChunkAt(MathHelper.floor(vec.x / 16.0D), MathHelper.floor(vec.z / 16.0D));
	}

	private static BlockPosition findPlatformPosition(Chunk chunk) {
		BlockPosition chunkStart = new BlockPosition(chunk.locX * 16, 30, chunk.locZ * 16);
		int highestSectY = (chunk.getHighestChunkSectionY() + 16) - 1;
		BlockPosition searchEnd = new BlockPosition(((chunk.locX * 16) + 16) - 1, highestSectY, ((chunk.locZ * 16) + 16) - 1);

		BlockPosition platformPosition = null;
		double dist = 0.0D;
		Iterator<BlockPosition> iterator = BlockPosition.allInCube(chunkStart, searchEnd).iterator();

		while (true) {
			BlockPosition nextPosition;
			double sqDist;
			do {
				do {
					IBlockData blockdata;
					do {
						do {
							if (!iterator.hasNext()) {
								return platformPosition;
							}

							nextPosition = iterator.next();
							blockdata = chunk.getBlockData(nextPosition);
						} while (blockdata.getBlock() != Blocks.END_STONE);
					} while (chunk.getType(nextPosition.up(1)).isSoildFullCube());
				} while (chunk.getType(nextPosition.up(2)).isSoildFullCube());

				sqDist = nextPosition.distanceSquaredFromCenter(0.0D, 0.0D, 0.0D);
			} while ((platformPosition != null) && (sqDist >= dist));

			platformPosition = nextPosition;
			dist = sqDist;
		}
	}

	private void generateGateway(BlockPosition position) {
		new EndGatewayGenerator().generate(world, new Random(), position);
		TileEntity te = world.getTileEntity(position);
		if (te instanceof TileEntityEndGateway) {
			TileEntityEndGateway gateway = (TileEntityEndGateway) te;
			gateway.exitPos = new BlockPosition(getPosition());
			gateway.update();
		} else {
			looger.warn("Couldn\'t save exit portal at " + position);
		}
	}

}
