package net.minecraft.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.minecraft.server.BlockPosition.MutableBlockPosition;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SctructureSchmeatic {

	private final List<BlockData> blocks = Lists.newArrayList();
	private final List<EntityData> entities = Lists.newArrayList();
	private BlockPosition size = new BlockPosition(0, 0, 0);
	private String author = "?";

	public BlockPosition getSize() {
		return this.size;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setData(World world, BlockPosition min, BlockPosition size, boolean includeEntities) {
		if ((size.getX() >= 1) && (size.getY() >= 1) && (size.getZ() >= 1)) {
			BlockPosition max = min.add(size).add(-1, -1, -1);
			ArrayList<BlockData> normalBlocks = Lists.newArrayList();
			ArrayList<BlockData> blocksWithTileEntity = Lists.newArrayList();
			ArrayList<BlockData> notCubeBlocks = Lists.newArrayList();
			BlockPosition minCorner = new BlockPosition(Math.min(min.getX(), max.getX()), Math.min(min.getY(), max.getY()), Math.min(min.getZ(), max.getZ()));
			BlockPosition maxCorner = new BlockPosition(Math.max(min.getX(), max.getX()), Math.max(min.getY(), max.getY()), Math.max(min.getZ(), max.getZ()));
			this.size = size;

			for (MutableBlockPosition blockPos : BlockPosition.allInCubeM(minCorner, maxCorner)) {
				BlockPosition relativePos = blockPos.substract(minCorner);
				IBlockData blockData = world.getType(blockPos);
				TileEntity te = world.getTileEntity(blockPos);
				if (te != null) {
					NBTTagCompound tenbtdata = new NBTTagCompound();
					te.write(tenbtdata);
					tenbtdata.remove("x");
					tenbtdata.remove("y");
					tenbtdata.remove("z");
					blocksWithTileEntity.add(new SctructureSchmeatic.BlockData(relativePos, blockData, tenbtdata));
				} else if (!blockData.getBlock().isFullBlock() && !blockData.getBlock().isFullCube()) {
					notCubeBlocks.add(new SctructureSchmeatic.BlockData(relativePos, blockData, (NBTTagCompound) null));
				} else {
					normalBlocks.add(new SctructureSchmeatic.BlockData(relativePos, blockData, (NBTTagCompound) null));
				}
			}

			this.blocks.clear();
			this.blocks.addAll(normalBlocks);
			this.blocks.addAll(blocksWithTileEntity);
			this.blocks.addAll(notCubeBlocks);
			if (includeEntities) {
				this.setEntities(world, minCorner, maxCorner.add(1, 1, 1));
			} else {
				this.entities.clear();
			}

			return;
		}
	}

	private void setEntities(World world, BlockPosition minCorner, BlockPosition maxCorner) {
		List<Entity> entities = world.getEntities(Entity.class, new AxisAlignedBB(minCorner, maxCorner), new Predicate<Entity>() {
			@Override
			public boolean apply(Entity entity) {
				return !(entity instanceof EntityHuman);
			}
		});
		this.entities.clear();

		Vec3D vec;
		NBTTagCompound nbtdata;
		BlockPosition blockPos;
		for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext(); this.entities.add(new SctructureSchmeatic.EntityData(vec, blockPos, nbtdata))) {
			Entity entity = iterator.next();
			vec = new Vec3D(entity.locX - minCorner.getX(), entity.locY - minCorner.getY(), entity.locZ - minCorner.getZ());
			nbtdata = new NBTTagCompound();
			entity.d(nbtdata);
			if (entity instanceof EntityPainting) {
				blockPos = ((EntityPainting) entity).n().substract(minCorner);
			} else {
				blockPos = new BlockPosition(vec);
			}
		}

	}

	public Map<BlockPosition, String> a(BlockPosition var1, class_asu var2) {
		HashMap<BlockPosition, String> var3 = Maps.newHashMap();
		StructureBoundingBox var4 = var2.g();
		Iterator<BlockData> var5 = this.blocks.iterator();

		while (true) {
			SctructureSchmeatic.BlockData var6;
			BlockPosition var7;
			do {
				if (!var5.hasNext()) {
					return var3;
				}

				var6 = var5.next();
				var7 = this.a(var2, var6.position).add(var1);
			} while ((var4 != null) && !var4.b(var7));

			IBlockData var8 = var6.blockdata;
			if ((var8.getBlock() == Blocks.STRUCTURE_BLOCK) && (var6.tag != null)) {
				TileEntityStructure.EnumMode var9 = TileEntityStructure.EnumMode.valueOf(var6.tag.getString("mode"));
				if (var9 == TileEntityStructure.EnumMode.DATA) {
					var3.put(var7, var6.tag.getString("metadata"));
				}
			}
		}
	}

	public BlockPosition a(class_asu var1, BlockPosition var2, SctructureSchmeatic var3, class_asu var4, BlockPosition var5) {
		BlockPosition var6 = this.a(var1, var2);
		BlockPosition var7 = var3.a(var4, var5);
		return var6.substract(var7);
	}

	public BlockPosition a(class_asu var1, BlockPosition var2) {
		return this.a(var2, var1.b(), var1.c());
	}

	public void a(World var1, BlockPosition var2, class_asu var3) {
		var3.i();
		this.b(var1, var2, var3);
	}

	public void b(World var1, BlockPosition var2, class_asu var3) {
		if (!this.blocks.isEmpty() && (this.size.getX() >= 1) && (this.size.getY() >= 1) && (this.size.getZ() >= 1)) {
			StructureBoundingBox var4 = var3.g();
			Iterator<BlockData> var5 = this.blocks.iterator();

			while (true) {
				SctructureSchmeatic.BlockData var6;
				Block var7;
				BlockPosition var8;
				do {
					do {
						do {
							if (!var5.hasNext()) {
								var5 = this.blocks.iterator();

								while (true) {
									BlockPosition var12;
									do {
										do {
											if (!var5.hasNext()) {
												if (!var3.e()) {
													this.a(var1, var2, var3.b(), var3.c(), var4);
												}

												return;
											}

											var6 = var5.next();
										} while (var3.f() && (var6.blockdata.getBlock() == Blocks.AIR));

										var12 = this.a(var3, var6.position).add(var2);
									} while ((var4 != null) && !var4.b(var12));

									var1.update(var12, var6.blockdata.getBlock());
									if (var6.tag != null) {
										TileEntity var13 = var1.getTileEntity(var12);
										if (var13 != null) {
											var13.update();
										}
									}
								}
							}

							var6 = var5.next();
							var7 = var6.blockdata.getBlock();
						} while (var3.f() && (var7 == Blocks.AIR));
					} while (var3.h() && (var7 == Blocks.STRUCTURE_BLOCK));

					var8 = this.a(var3, var6.position).add(var2);
				} while ((var4 != null) && !var4.b(var8));

				IBlockData var9 = var7.a(var6.blockdata, var3.b());
				IBlockData var10 = var7.a(var9, var3.c());
				TileEntity var11;
				if (var6.tag != null) {
					var11 = var1.getTileEntity(var8);
					if (var11 != null) {
						if (var11 instanceof IInventory) {
							((IInventory) var11).remove();
						}

						var1.setTypeAndData(var8, Blocks.BARRIER.getBlockData(), 4);
					}
				}

				if (var1.setTypeAndData(var8, var10, 2) && (var6.tag != null)) {
					var11 = var1.getTileEntity(var8);
					if (var11 != null) {
						var6.tag.put("x", var8.getX());
						var6.tag.put("y", var8.getY());
						var6.tag.put("z", var8.getZ());
						var11.read(var6.tag);
					}
				}
			}
		}
	}

	private void a(World var1, BlockPosition var2, Block.class_a_in_class_agj var3, Block.EnumRotation var4, StructureBoundingBox var5) {
		Iterator<EntityData> var6 = this.entities.iterator();

		while (true) {
			SctructureSchmeatic.EntityData var7;
			BlockPosition var8;
			do {
				if (!var6.hasNext()) {
					return;
				}

				var7 = var6.next();
				var8 = this.a(var7.position, var3, var4).add(var2);
			} while ((var5 != null) && !var5.b(var8));

			NBTTagCompound var9 = var7.tag;
			Vec3D var10 = this.a(var7.vec, var3, var4);
			Vec3D var11 = var10.add(var2.getX(), var2.getY(), var2.getZ());
			NBTTagList var12 = new NBTTagList();
			var12.add((new NBTTagDouble(var11.x)));
			var12.add((new NBTTagDouble(var11.y)));
			var12.add((new NBTTagDouble(var11.z)));
			var9.put("Pos", var12);
			UUID var13 = UUID.randomUUID();
			var9.put("UUIDMost", var13.getMostSignificantBits());
			var9.put("UUIDLeast", var13.getLeastSignificantBits());

			Entity var14;
			try {
				var14 = EntityTypes.a(var9, var1);
			} catch (Exception var16) {
				var14 = null;
			}

			if (var14 != null) {
				if (var14 instanceof EntityPainting) {
					var14.a(var3);
					var14.a(var4);
					var14.setPosition(var8.getX(), var8.getY(), var8.getZ());
					var14.setPositionRotation(var11.x, var11.y, var11.z, var14.yaw, var14.pitch);
				} else {
					float var15 = var14.a(var3);
					var15 += var14.yaw - var14.a(var4);
					var14.setPositionRotation(var11.x, var11.y, var11.z, var15, var14.pitch);
				}

				var1.addEntity(var14);
			}
		}
	}

	public BlockPosition a(Block.EnumRotation var1) {
		switch (SctructureSchmeatic.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
			case 2:
				return new BlockPosition(this.size.getZ(), this.size.getY(), this.size.getX());
			default:
				return this.size;
		}
	}

	private BlockPosition a(BlockPosition var1, Block.class_a_in_class_agj var2, Block.EnumRotation var3) {
		int var4 = var1.getX();
		int var5 = var1.getY();
		int var6 = var1.getZ();
		boolean var7 = true;
		switch (SctructureSchmeatic.SyntheticClass_1.b[var2.ordinal()]) {
			case 1:
				var6 = -var6;
				break;
			case 2:
				var4 = -var4;
				break;
			default:
				var7 = false;
		}

		switch (SctructureSchmeatic.SyntheticClass_1.a[var3.ordinal()]) {
			case 1:
				return new BlockPosition(var6, var5, -var4);
			case 2:
				return new BlockPosition(-var6, var5, var4);
			case 3:
				return new BlockPosition(-var4, var5, -var6);
			default:
				return var7 ? new BlockPosition(var4, var5, var6) : var1;
		}
	}

	private Vec3D a(Vec3D var1, Block.class_a_in_class_agj var2, Block.EnumRotation var3) {
		double var4 = var1.x;
		double var6 = var1.y;
		double var8 = var1.z;
		boolean var10 = true;
		switch (SctructureSchmeatic.SyntheticClass_1.b[var2.ordinal()]) {
			case 1:
				var8 = 1.0D - var8;
				break;
			case 2:
				var4 = 1.0D - var4;
				break;
			default:
				var10 = false;
		}

		switch (SctructureSchmeatic.SyntheticClass_1.a[var3.ordinal()]) {
			case 1:
				return new Vec3D(var8, var6, 1.0D - var4);
			case 2:
				return new Vec3D(1.0D - var8, var6, var4);
			case 3:
				return new Vec3D(1.0D - var4, var6, 1.0D - var8);
			default:
				return var10 ? new Vec3D(var4, var6, var8) : var1;
		}
	}

	public void save(NBTTagCompound compound) {
		NBTTagList blocksTag = new NBTTagList();

		NBTTagCompound blockTag;
		for (Iterator<BlockData> it = this.blocks.iterator(); it.hasNext(); blocksTag.add(blockTag)) {
			SctructureSchmeatic.BlockData data = it.next();
			blockTag = new NBTTagCompound();
			blockTag.put("pos", this.a(new int[] { data.position.getX(), data.position.getY(), data.position.getZ() }));
			blockTag.put("state", Block.getCombinedId(data.blockdata));
			if (data.tag != null) {
				blockTag.put("nbt", data.tag);
			}
		}

		NBTTagList entitiesTag = new NBTTagList();

		NBTTagCompound entityTag;
		for (Iterator<EntityData> it = this.entities.iterator(); it.hasNext(); entitiesTag.add(entityTag)) {
			SctructureSchmeatic.EntityData data = it.next();
			entityTag = new NBTTagCompound();
			entityTag.put("pos", this.a(new double[] { data.vec.x, data.vec.y, data.vec.z }));
			entityTag.put("blockPos", this.a(new int[] { data.position.getX(), data.position.getY(), data.position.getZ() }));
			if (data.tag != null) {
				entityTag.put("nbt", data.tag);
			}
		}

		compound.put("blocks", blocksTag);
		compound.put("entities", entitiesTag);
		compound.put("size", this.a(new int[] { this.size.getX(), this.size.getY(), this.size.getZ() }));
		compound.put("version", 1);
		compound.put("author", this.author);
	}

	public void load(NBTTagCompound compound) {
		this.blocks.clear();
		this.entities.clear();
		NBTTagList sizeTag = compound.getList("size", 3);
		this.size = new BlockPosition(sizeTag.getInt(0), sizeTag.getInt(1), sizeTag.getInt(2));
		this.author = compound.getString("author");
		NBTTagList blocksTag = compound.getList("blocks", 10);

		for (int i = 0; i < blocksTag.getSize(); ++i) {
			NBTTagCompound blockTag = blocksTag.getCompound(i);
			NBTTagList posTag = blockTag.getList("pos", 3);
			BlockPosition pos = new BlockPosition(posTag.getInt(0), posTag.getInt(1), posTag.getInt(2));
			int stateId = blockTag.getInt("state");
			IBlockData blockData = Block.getByCombinedId(stateId);
			NBTTagCompound nbtdata;
			if (blockTag.has("nbt")) {
				nbtdata = blockTag.getCompound("nbt");
			} else {
				nbtdata = null;
			}

			this.blocks.add(new SctructureSchmeatic.BlockData(pos, blockData, nbtdata));
		}

		NBTTagList entitiesTag = compound.getList("entities", 10);

		for (int i = 0; i < entitiesTag.getSize(); ++i) {
			NBTTagCompound entityTag = entitiesTag.getCompound(i);
			NBTTagList posTag = entityTag.getList("pos", 6);
			Vec3D vec = new Vec3D(posTag.getDouble(0), posTag.getDouble(1), posTag.getDouble(2));
			NBTTagList blockPosTag = entityTag.getList("blockPos", 3);
			BlockPosition blockPos = new BlockPosition(blockPosTag.getInt(0), blockPosTag.getInt(1), blockPosTag.getInt(2));
			if (entityTag.has("nbt")) {
				NBTTagCompound nbtdata = entityTag.getCompound("nbt");
				this.entities.add(new SctructureSchmeatic.EntityData(vec, blockPos, nbtdata));
			}
		}

	}

	private NBTTagList a(int... var1) {
		NBTTagList var2 = new NBTTagList();
		int[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			int var6 = var3[var5];
			var2.add((new NBTTagInt(var6)));
		}

		return var2;
	}

	private NBTTagList a(double... var1) {
		NBTTagList var2 = new NBTTagList();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.add((new NBTTagDouble(var6)));
		}

		return var2;
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_a_in_class_agj.values().length];

		static {
			try {
				b[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[Block.EnumRotation.values().length];

			try {
				a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	static class EntityData {
		public final Vec3D vec;
		public final BlockPosition position;
		public final NBTTagCompound tag;

		protected EntityData(Vec3D vec, BlockPosition position, NBTTagCompound tag) {
			this.vec = vec;
			this.position = position;
			this.tag = tag;
		}
	}

	static class BlockData {
		public final BlockPosition position;
		public final IBlockData blockdata;
		public final NBTTagCompound tag;

		protected BlockData(BlockPosition position, IBlockData blockdata, NBTTagCompound tag) {
			this.position = position;
			this.blockdata = blockdata;
			this.tag = tag;
		}
	}

}
