package net.minecraft.server;

import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

public abstract class TileEntity {

	private static final Logger logger = LogManager.getLogger();
	private static final Map<String, Class<? extends TileEntity>> NAME_TO_CLASS = Maps.newHashMap();
	private static final Map<Class<? extends TileEntity>, String> CLASS_TO_NAME = Maps.newHashMap();

	static {
		register(TileEntityFurnace.class, "Furnace");
		register(TileEntityChest.class, "Chest");
		register(TileEntityEnderChest.class, "EnderChest");
		register(BlockJukeBox.TileEntityRecordPlayer.class, "RecordPlayer");
		register(TileEntityDispenser.class, "Trap");
		register(TileEntityDropper.class, "Dropper");
		register(TileEntitySign.class, "Sign");
		register(TileEntityMobSpawner.class, "MobSpawner");
		register(TileEntityNote.class, "Music");
		register(TileEntityPiston.class, "Piston");
		register(TileEntityBrewingStand.class, "Cauldron");
		register(TileEntityEnchantTable.class, "EnchantTable");
		register(TileEntityEnderPortal.class, "Airportal");
		register(TileEntityCommand.class, "Control");
		register(TileEntityBeacon.class, "Beacon");
		register(TileEntitySkull.class, "Skull");
		register(TileEntityLightDetector.class, "DLDetector");
		register(TileEntityHopper.class, "Hopper");
		register(TileEntityComparator.class, "Comparator");
		register(TileEntityFlowerPot.class, "FlowerPot");
		register(TileEntityBanner.class, "Banner");
		//=====new tiles start========
		register(TileEntityStructure.class, "Structure");
		register(TileEntityEndGateway.class, "EndGateway");
		//=====new tiles end==========
	}

	private static void register(Class<? extends TileEntity> var0, String var1) {
		if (NAME_TO_CLASS.containsKey(var1)) {
			throw new IllegalArgumentException("Duplicate id: " + var1);
		} else {
			NAME_TO_CLASS.put(var1, var0);
			CLASS_TO_NAME.put(var0, var1);
		}
	}


	protected World world;
	protected BlockPosition position;
	protected boolean isInvalid;
	private int metadata;
	protected Block block;

	public TileEntity() {
		position = BlockPosition.ZERO;
		metadata = -1;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public boolean hasWorld() {
		return world != null;
	}

	public void read(NBTTagCompound compound) {
		position = new BlockPosition(compound.getInt("x"), compound.getInt("y"), compound.getInt("z"));
	}

	public void write(NBTTagCompound compound) {
		String name = CLASS_TO_NAME.get(this.getClass());
		if (name == null) {
			throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
		} else {
			compound.put("id", name);
			compound.put("x", position.getX());
			compound.put("y", position.getY());
			compound.put("z", position.getZ());
		}
	}

	public static TileEntity fromNBT(NBTTagCompound compound) {
		TileEntity var1 = null;

		try {
			Class<?> var2 = NAME_TO_CLASS.get(compound.getString("id"));
			if (var2 != null) {
				var1 = (TileEntity) var2.newInstance();
			}
		} catch (Exception var3) {
			var3.printStackTrace();
		}

		if (var1 != null) {
			var1.read(compound);
		} else {
			logger.warn("Skipping BlockEntity with id " + compound.getString("id"));
		}

		return var1;
	}

	public int getMetadata() {
		if (metadata == -1) {
			IBlockData blockdat = world.getType(position);
			metadata = blockdat.getBlock().toLegacyData(blockdat);
		}
		return metadata;
	}

	public void update() {
		if (world != null) {
			IBlockData blockdata = world.getType(position);
			metadata = blockdata.getBlock().toLegacyData(blockdata);
			world.b(position, this);
			if (getBlock() != Blocks.AIR) {
				world.e(position, getBlock());
			}
		}
	}

	public BlockPosition getPosition() {
		return position;
	}

	public Block getBlock() {
		if (block == null) {
			block = world.getType(position).getBlock();
		}

		return block;
	}

	public Packet<? extends PacketListener> getUpdatePacket() {
		return null;
	}

	public boolean isInvalid() {
		return isInvalid;
	}

	public void setInvalid() {
		isInvalid = true;
	}

	public void setValid() {
		isInvalid = false;
	}

	public boolean handleClientInput(int var1, int var2) {
		return false;
	}

	public void resetBlockCache() {
		block = null;
		metadata = -1;
	}

	public void a(class_c var1) {
		var1.a("Name", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return TileEntity.CLASS_TO_NAME.get(TileEntity.this.getClass()) + " // " + TileEntity.this.getClass().getCanonicalName();
			}
		});
		if (world != null) {
			class_c.a(var1, position, getBlock(), getMetadata());
			var1.a("Actual block type", new Callable<String>() {
				@Override
				public String call() throws Exception {
					int var1 = Block.getId(world.getType(position).getBlock());

					try {
						return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(var1), Block.getById(var1).getInternalName(), Block.getById(var1).getClass().getCanonicalName() });
					} catch (Throwable var3) {
						return "ID #" + var1;
					}
				}
			});
			var1.a("Actual block data value", new Callable<Object>() {
				@Override
				public String call() throws Exception {
					IBlockData var1 = world.getType(position);
					int var2 = var1.getBlock().toLegacyData(var1);
					if (var2 < 0) {
						return "Unknown? (Got " + var2 + ")";
					} else {
						String var3 = String.format("%4s", new Object[] { Integer.toBinaryString(var2) }).replace(" ", "0");
						return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(var2), var3 });
					}
				}
			});
		}
	}

	public void setPosition(BlockPosition position) {
		if (position instanceof BlockPosition.MutableBlockPosition) {
			logger.warn("Tried to assign a mutable BlockPos to a block entity...", (new Error()));
			position = new BlockPosition(position);
		}

		this.position = position;
	}

	public boolean F() {
		return false;
	}

}
