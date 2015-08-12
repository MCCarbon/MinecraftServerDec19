package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.server.BlockPosition.MutableBlockPosition;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class TileEntityStructure extends TileEntity {

	private String name = "";
	private String author = "";
	private String metadata = "";
	private BlockPosition pos = new BlockPosition(1, 1, 1);
	private BlockPosition size = new BlockPosition(0, 0, 0);
	private Block.class_a_in_class_agj mirror;
	private Block.EnumRotation rotation;
	private TileEntityStructure.EnumMode mode;
	private boolean ignoreEntities;

	public TileEntityStructure() {
		mirror = Block.class_a_in_class_agj.NONE;
		rotation = Block.EnumRotation.NONE;
		mode = TileEntityStructure.EnumMode.DATA;
	}

	@Override
	public void write(NBTTagCompound compound) {
		super.write(compound);
		compound.put("name", name);
		compound.put("author", author);
		compound.put("metadata", metadata);
		compound.put("posX", pos.getX());
		compound.put("posY", pos.getY());
		compound.put("posZ", pos.getZ());
		compound.put("sizeX", size.getX());
		compound.put("sizeY", size.getY());
		compound.put("sizeZ", size.getZ());
		compound.put("rotation", rotation.toString());
		compound.put("mirror", mirror.toString());
		compound.put("mode", mode.toString());
		compound.put("ignoreEntities", ignoreEntities);
	}

	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		name = compound.getString("name");
		author = compound.getString("author");
		metadata = compound.getString("metadata");
		pos = new BlockPosition(compound.getInt("posX"), compound.getInt("posY"), compound.getInt("posZ"));
		size = new BlockPosition(compound.getInt("sizeX"), compound.getInt("sizeY"), compound.getInt("sizeZ"));

		try {
			rotation = Block.EnumRotation.valueOf(compound.getString("rotation"));
		} catch (IllegalArgumentException var5) {
			rotation = Block.EnumRotation.NONE;
		}

		try {
			mirror = Block.class_a_in_class_agj.valueOf(compound.getString("mirror"));
		} catch (IllegalArgumentException var4) {
			mirror = Block.class_a_in_class_agj.NONE;
		}

		try {
			mode = TileEntityStructure.EnumMode.valueOf(compound.getString("mode"));
		} catch (IllegalArgumentException var3) {
			mode = TileEntityStructure.EnumMode.DATA;
		}

		ignoreEntities = compound.getBoolean("ignoreEntities");
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound compound = new NBTTagCompound();
		write(compound);
		return new PacketPlayOutTileEntityData(position, 7, compound);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPos(BlockPosition pos) {
		this.pos = pos;
	}

	public void setSize(BlockPosition size) {
		this.size = size;
	}

	public void setMirror(Block.class_a_in_class_agj mirror) {
		this.mirror = mirror;
	}

	public void setRotation(Block.EnumRotation rotation) {
		this.rotation = rotation;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public void setMode(EnumMode mode) {
		this.mode = mode;
		IBlockData blockdata = world.getType(getPosition());
		if (blockdata.getBlock() == Blocks.STRUCTURE_BLOCK) {
			world.setTypeAndData(getPosition(), blockdata.set(BlockStructureBlock.MODE, mode), 2);
		}
	}

	public void setIgnoreEntities(boolean ignoreEntities) {
		this.ignoreEntities = ignoreEntities;
	}

	public boolean updateStructureSize() {
		if (mode != TileEntityStructure.EnumMode.SAVE) {
			return false;
		} else {
			BlockPosition lpos = getPosition();
			BlockPosition min = new BlockPosition(lpos.getX() - 128, 0, lpos.getZ() - 128);
			BlockPosition max = new BlockPosition(lpos.getX() + 128, 255, lpos.getZ() + 128);
			List<TileEntityStructure> structuresInCube = this.getStructureBlocksInCube(min, max);
			List<TileEntityStructure> filtered = this.filterSameAsThis(structuresInCube);
			if (filtered.size() < 1) {
				return false;
			} else {
				StructureBoundingBox stuctureBB = this.getStructureBoundingBox(lpos, filtered);
				if (((stuctureBB.maxX - stuctureBB.minX) > 1) && ((stuctureBB.maxY - stuctureBB.minY) > 1) && ((stuctureBB.maxZ - stuctureBB.minZ) > 1)) {
					this.pos = new BlockPosition((stuctureBB.minX - lpos.getX()) + 1, (stuctureBB.minY - lpos.getY()) + 1, (stuctureBB.minZ - lpos.getZ()) + 1);
					this.size = new BlockPosition(stuctureBB.maxX - stuctureBB.minX - 1, stuctureBB.maxY - stuctureBB.minY - 1, stuctureBB.maxZ - stuctureBB.minZ - 1);
					this.update();
					this.world.notify(lpos);
					return true;
				} else {
					return false;
				}
			}
		}
	}

	private List<TileEntityStructure> filterSameAsThis(List<TileEntityStructure> var1) {
		Iterable<TileEntityStructure> iterable = Iterables.filter(var1, (new Predicate<TileEntityStructure>() {
			@Override
			public boolean apply(TileEntityStructure structure) {
				return (structure.mode == EnumMode.CORNER) && name.equals(structure.name);
			}
		}));
		return Lists.newArrayList(iterable);
	}

	private List<TileEntityStructure> getStructureBlocksInCube(BlockPosition min, BlockPosition max) {
		ArrayList<TileEntityStructure> structureblocks = Lists.newArrayList();

		for (MutableBlockPosition position : BlockPosition.allInCubeM(min, max)) {
			IBlockData blockdata = world.getType(position);
			if (blockdata.getBlock() == Blocks.STRUCTURE_BLOCK) {
				TileEntity tileentity = world.getTileEntity(position);
				if (tileentity instanceof TileEntityStructure) {
					structureblocks.add((TileEntityStructure) tileentity);
				}
			}
		}

		return structureblocks;
	}

	private StructureBoundingBox getStructureBoundingBox(BlockPosition mainpos, List<TileEntityStructure> stuctures) {
		StructureBoundingBox structbb;
		if (stuctures.size() > 1) {
			BlockPosition realpos = stuctures.get(0).getPosition();
			structbb = new StructureBoundingBox(realpos, realpos);
		} else {
			structbb = new StructureBoundingBox(mainpos, mainpos);
		}

		for (TileEntityStructure structure : stuctures) {
			BlockPosition structurePosition = structure.getPosition();
			if (structurePosition.getX() < structbb.minX) {
				structbb.minX = structurePosition.getX();
			} else if (structurePosition.getX() > structbb.maxX) {
				structbb.maxX = structurePosition.getX();
			}

			if (structurePosition.getY() < structbb.minY) {
				structbb.minY = structurePosition.getY();
			} else if (structurePosition.getY() > structbb.maxY) {
				structbb.maxY = structurePosition.getY();
			}

			if (structurePosition.getZ() < structbb.minZ) {
				structbb.minZ = structurePosition.getZ();
			} else if (structurePosition.getZ() > structbb.maxZ) {
				structbb.maxZ = structurePosition.getZ();
			}
		}

		return structbb;
	}

	public boolean saveStructure() {
		if (mode != TileEntityStructure.EnumMode.SAVE) {
			return false;
		} else {
			BlockPosition var1 = getPosition().add(pos);
			StructureSchematicNBTLoader var2 = ((BlockStructureBlock) getBlock()).l();
			SctructureSchmeatic schematic = var2.getSchematic(new MinecraftKey(name));
			schematic.setData(world, var1, size, !ignoreEntities);
			schematic.setAuthor(author);
			var2.saveSchematic(new MinecraftKey(name));
			return true;
		}
	}

	public boolean loadStucture() {
		if (mode != TileEntityStructure.EnumMode.LOAD) {
			return false;
		} else {
			BlockPosition var1 = getPosition().add(pos);
			StructureSchematicNBTLoader var2 = ((BlockStructureBlock) getBlock()).l();
			SctructureSchmeatic var3 = var2.getSchematic(new MinecraftKey(name));
			if (!UtilColor.isStringEmpty(var3.getAuthor())) {
				author = var3.getAuthor();
			}

			if (!size.equals(var3.getSize())) {
				size = var3.getSize();
				return false;
			} else {
				BlockPosition var4 = var3.a(rotation);
				Iterator<?> var5 = world.getEntities((Entity) null, (new AxisAlignedBB(var1, var4.add(var1).add(-1, -1, -1)))).iterator();

				while (var5.hasNext()) {
					Entity var6 = (Entity) var5.next();
					world.f(var6);
				}

				class_asu var7 = (new class_asu()).a(mirror).a(rotation).a(ignoreEntities).a((ChunkCoordIntPair) null).b(false).c(false);
				var3.a(world, var1, var7);
				return true;
			}
		}
	}

	public static enum EnumMode implements INamable {
		SAVE("save", 0), LOAD("load", 1), CORNER("corner", 2), DATA("data", 3);

		private static final TileEntityStructure.EnumMode[] BY_ID = new TileEntityStructure.EnumMode[values().length];
		static {
			for (EnumMode mode : values()) {
				BY_ID[mode.getId()] = mode;
			}
		}

		private final String name;
		private final int id;

		private EnumMode(String name, int id) {
			this.name = name;
			this.id = id;
		}

		@Override
		public String getName() {
			return name;
		}

		public int getId() {
			return id;
		}

		public static TileEntityStructure.EnumMode getById(int id) {
			if ((id < 0) || (id >= BY_ID.length)) {
				id = 0;
			}

			return BY_ID[id];
		}

	}
}
