package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;

public class Chunk {

	private static final Logger logger = LogManager.getLogger();

	private final ChunkSection[] sections;
	private final byte[] e;
	private final int[] f;
	private final boolean[] g;
	private boolean h;
	private final World world;
	private final int[] heightMap;
	public final int locX;
	public final int locZ;
	private boolean k;
	private final Map<BlockPosition, TileEntity> tileEntities;
	private final EntitySlice[] entitySlices;
	private boolean done;
	private boolean lit;
	private boolean p;
	private boolean q;
	private boolean r;
	private long lastSaved;
	private int t;
	private long u;
	private int v;
	private ConcurrentLinkedQueue<BlockPosition> w;

	public Chunk(World var1, int var2, int var3) {
		sections = new ChunkSection[16];
		e = new byte[256];
		f = new int[256];
		g = new boolean[256];
		tileEntities = Maps.newHashMap();
		v = 4096;
		w = Queues.newConcurrentLinkedQueue();
		entitySlices = (new EntitySlice[16]);
		world = var1;
		locX = var2;
		locZ = var3;
		heightMap = new int[256];

		for (int var4 = 0; var4 < entitySlices.length; ++var4) {
			entitySlices[var4] = new EntitySlice(Entity.class);
		}

		Arrays.fill(f, -999);
		Arrays.fill(e, (byte) -1);
	}

	public Chunk(World var1, ChunkSnapshot var2, int var3, int var4) {
		this(var1, var3, var4);
		short var5 = 256;
		boolean var6 = !var1.worldProvider.m();

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				for (int var9 = 0; var9 < var5; ++var9) {
					int var10 = (var7 * var5 * 16) | (var8 * var5) | var9;
					IBlockData var11 = var2.a(var10);
					if (var11.getBlock().getMaterial() != Material.AIR) {
						int var12 = var9 >> 4;
				if (sections[var12] == null) {
					sections[var12] = new ChunkSection(var12 << 4, var6);
				}

				sections[var12].a(var7, var9 & 15, var8, var11);
					}
				}
			}
		}

	}

	public boolean a(int var1, int var2) {
		return (var1 == locX) && (var2 == locZ);
	}

	public int f(BlockPosition var1) {
		return this.b(var1.getX() & 15, var1.getZ() & 15);
	}

	public int b(int var1, int var2) {
		return heightMap[(var2 << 4) | var1];
	}

	public int getHighestChunkSectionY() {
		for (int i = sections.length - 1; i >= 0; --i) {
			if (sections[i] != null) {
				return sections[i].getYPosition();
			}
		}

		return 0;
	}

	public ChunkSection[] getSections() {
		return sections;
	}

	public void initLighting() {
		int var1 = this.getHighestChunkSectionY();
		t = Integer.MAX_VALUE;

		for (int var2 = 0; var2 < 16; ++var2) {
			for (int var3 = 0; var3 < 16; ++var3) {
				f[var2 + (var3 << 4)] = -999;

				int var4;
				for (var4 = var1 + 16; var4 > 0; --var4) {
					if (this.e(var2, var4 - 1, var3) != 0) {
						heightMap[(var3 << 4) | var2] = var4;
						if (var4 < t) {
							t = var4;
						}
						break;
					}
				}

				if (!world.worldProvider.m()) {
					var4 = 15;
					int var5 = (var1 + 16) - 1;

					do {
						int var6 = this.e(var2, var5, var3);
						if ((var6 == 0) && (var4 != 15)) {
							var6 = 1;
						}

						var4 -= var6;
						if (var4 > 0) {
							ChunkSection var7 = sections[var5 >> 4];
							if (var7 != null) {
								var7.a(var2, var5 & 15, var3, var4);
								world.n(new BlockPosition((locX << 4) + var2, var5, (locZ << 4) + var3));
							}
						}

						--var5;
					} while ((var5 > 0) && (var4 > 0));
				}
			}
		}

		q = true;
	}

	private void d(int var1, int var2) {
		g[var1 + (var2 * 16)] = true;
		k = true;
	}

	private void h(boolean var1) {
		world.B.a("recheckGaps");
		if (world.a((new BlockPosition((locX * 16) + 8, 0, (locZ * 16) + 8)), 16)) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					if (g[var2 + (var3 * 16)]) {
						g[var2 + (var3 * 16)] = false;
						int var4 = this.b(var2, var3);
						int var5 = (locX * 16) + var2;
						int var6 = (locZ * 16) + var3;
						int var7 = Integer.MAX_VALUE;

						Iterator<?> var8;
						EnumDirection var9;
						for (var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator(); var8.hasNext(); var7 = Math.min(var7, world.b(var5 + var9.getAdjacentX(), var6 + var9.getAdjacentZ()))) {
							var9 = (EnumDirection) var8.next();
						}

						this.c(var5, var6, var7);
						var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

						while (var8.hasNext()) {
							var9 = (EnumDirection) var8.next();
							this.c(var5 + var9.getAdjacentX(), var6 + var9.getAdjacentZ(), var4);
						}

						if (var1) {
							world.B.b();
							return;
						}
					}
				}
			}

			k = false;
		}

		world.B.b();
	}

	private void c(int var1, int var2, int var3) {
		int var4 = world.m(new BlockPosition(var1, 0, var2)).getY();
		if (var4 > var3) {
			this.a(var1, var2, var3, var4 + 1);
		} else if (var4 < var3) {
			this.a(var1, var2, var4, var3 + 1);
		}

	}

	private void a(int var1, int var2, int var3, int var4) {
		if ((var4 > var3) && world.a((new BlockPosition(var1, 0, var2)), 16)) {
			for (int var5 = var3; var5 < var4; ++var5) {
				world.c(class_aet.a, new BlockPosition(var1, var5, var2));
			}

			q = true;
		}

	}

	private void d(int var1, int var2, int var3) {
		int var4 = heightMap[(var3 << 4) | var1] & 255;
		int var5 = var4;
		if (var2 > var4) {
			var5 = var2;
		}

		while ((var5 > 0) && (this.e(var1, var5 - 1, var3) == 0)) {
			--var5;
		}

		if (var5 != var4) {
			world.a(var1 + (locX * 16), var3 + (locZ * 16), var5, var4);
			heightMap[(var3 << 4) | var1] = var5;
			int var6 = (locX * 16) + var1;
			int var7 = (locZ * 16) + var3;
			int var8;
			int var13;
			if (!world.worldProvider.m()) {
				ChunkSection var9;
				if (var5 < var4) {
					for (var8 = var5; var8 < var4; ++var8) {
						var9 = sections[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 15);
							world.n(new BlockPosition((locX << 4) + var1, var8, (locZ << 4) + var3));
						}
					}
				} else {
					for (var8 = var4; var8 < var5; ++var8) {
						var9 = sections[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 0);
							world.n(new BlockPosition((locX << 4) + var1, var8, (locZ << 4) + var3));
						}
					}
				}

				var8 = 15;

				while ((var5 > 0) && (var8 > 0)) {
					--var5;
					var13 = this.e(var1, var5, var3);
					if (var13 == 0) {
						var13 = 1;
					}

					var8 -= var13;
					if (var8 < 0) {
						var8 = 0;
					}

					ChunkSection var10 = sections[var5 >> 4];
					if (var10 != null) {
						var10.a(var1, var5 & 15, var3, var8);
					}
				}
			}

			var8 = heightMap[(var3 << 4) | var1];
			var13 = var4;
			int var14 = var8;
			if (var8 < var4) {
				var13 = var8;
				var14 = var4;
			}

			if (var8 < t) {
				t = var8;
			}

			if (!world.worldProvider.m()) {
				Iterator<?> var11 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

				while (var11.hasNext()) {
					EnumDirection var12 = (EnumDirection) var11.next();
					this.a(var6 + var12.getAdjacentX(), var7 + var12.getAdjacentZ(), var13, var14);
				}

				this.a(var6, var7, var13, var14);
			}

			q = true;
		}
	}

	public int b(BlockPosition var1) {
		return this.getType(var1).getLightOpacity();
	}

	private int e(int var1, int var2, int var3) {
		return this.getType(var1, var2, var3).getLightOpacity();
	}

	private Block getType(int x, int y, int z) {
		Block block = Blocks.AIR;
		if ((y >= 0) && ((y >> 4) < sections.length)) {
			ChunkSection section = sections[y >> 4];
			if (section != null) {
				try {
					block = section.b(x, y & 15, z);
				} catch (Throwable var8) {
					class_b var7 = class_b.a(var8, "Getting block");
					throw new class_e(var7);
				}
			}
		}

		return block;
	}

	public Block getTypeAbs(final int x, final int y, final int z) {
		try {
			return this.getType(x & 15, y, z & 15);
		} catch (class_e var6) {
			class_c var5 = var6.a().a("Block being got");
			var5.a("Location", new Callable<String>() {
				public String call() throws Exception {
					return class_c.a(new BlockPosition((locX * 16) + x, y, (locZ * 16) + z));
				}
			});
			throw var6;
		}
	}

	public Block getType(final BlockPosition position) {
		try {
			return this.getType(position.getX() & 15, position.getY(), position.getZ() & 15);
		} catch (class_e var4) {
			class_c var3 = var4.a().a("Block being got");
			var3.a("Location", new Callable<String>() {
				public String call() throws Exception {
					return class_c.a(position);
				}
			});
			throw var4;
		}
	}

	public IBlockData getBlockData(final BlockPosition position) {
		if (world.H() == WorldType.DEBUG) {
			IBlockData blockdata = null;
			if (position.getY() == 60) {
				blockdata = Blocks.BARRIER.getBlockData();
			}

			if (position.getY() == 70) {
				blockdata = ChunkProviderDebug.b(position.getX(), position.getZ());
			}

			return blockdata == null ? Blocks.AIR.getBlockData() : blockdata;
		} else {
			try {
				if ((position.getY() >= 0) && ((position.getY() >> 4) < sections.length)) {
					ChunkSection section = sections[position.getY() >> 4];
					if (section != null) {
						int x = position.getX() & 15;
						int y = position.getY() & 15;
						int z = position.getZ() & 15;
						return section.a(x, y, z);
					}
				}

				return Blocks.AIR.getBlockData();
			} catch (Throwable var6) {
				class_b var3 = class_b.a(var6, "Getting block state");
				class_c var4 = var3.a("Block being got");
				var4.a("Location", new Callable<String>() {
					public String call() throws Exception {
						return class_c.a(position);
					}
				});
				throw new class_e(var3);
			}
		}
	}

	private int g(int var1, int var2, int var3) {
		if ((var2 >> 4) >= sections.length) {
			return 0;
		} else {
			ChunkSection var4 = sections[var2 >> 4];
			return var4 != null ? var4.c(var1, var2 & 15, var3) : 0;
		}
	}

	public int c(BlockPosition var1) {
		return this.g(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
	}

	public IBlockData a(BlockPosition var1, IBlockData var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getY();
		int var5 = var1.getZ() & 15;
		int var6 = (var5 << 4) | var3;
		if (var4 >= (f[var6] - 1)) {
			f[var6] = -999;
		}

		int var7 = heightMap[var6];
		IBlockData var8 = this.getBlockData(var1);
		if (var8 == var2) {
			return null;
		} else {
			Block var9 = var2.getBlock();
			Block var10 = var8.getBlock();
			ChunkSection var11 = sections[var4 >> 4];
			boolean var12 = false;
			if (var11 == null) {
				if (var9 == Blocks.AIR) {
					return null;
				}

				var11 = sections[var4 >> 4] = new ChunkSection((var4 >> 4) << 4, !world.worldProvider.m());
				var12 = var4 >= var7;
			}

			var11.a(var3, var4 & 15, var5, var2);
			if (var10 != var9) {
				if (!world.isClientSide) {
					var10.remove(world, var1, var8);
				} else if (var10 instanceof IContainer) {
					world.t(var1);
				}
			}

			if (var11.b(var3, var4 & 15, var5) != var9) {
				return null;
			} else {
				if (var12) {
					this.initLighting();
				} else {
					int var13 = var9.getLightOpacity();
					int var14 = var10.getLightOpacity();
					if (var13 > 0) {
						if (var4 >= var7) {
							this.d(var3, var4 + 1, var5);
						}
					} else if (var4 == (var7 - 1)) {
						this.d(var3, var4, var5);
					}

					if ((var13 != var14) && ((var13 < var14) || (this.a(class_aet.a, var1) > 0) || (this.a(class_aet.b, var1) > 0))) {
						this.d(var3, var5);
					}
				}

				TileEntity var15;
				if (var10 instanceof IContainer) {
					var15 = this.a(var1, Chunk.class_a_in_class_aok.c);
					if (var15 != null) {
						var15.resetBlockCache();
					}
				}

				if (!world.isClientSide && (var10 != var9)) {
					var9.onPlace(world, var1, var2);
				}

				if (var9 instanceof IContainer) {
					var15 = this.a(var1, Chunk.class_a_in_class_aok.c);
					if (var15 == null) {
						var15 = ((IContainer) var9).createTileEntity(world, var9.toLegacyData(var2));
						world.a(var1, var15);
					}

					if (var15 != null) {
						var15.resetBlockCache();
					}
				}

				q = true;
				return var8;
			}
		}
	}

	public int a(class_aet var1, BlockPosition var2) {
		int var3 = var2.getX() & 15;
		int var4 = var2.getY();
		int var5 = var2.getZ() & 15;
		ChunkSection var6 = sections[var4 >> 4];
		return var6 == null ? (this.d(var2) ? var1.c : 0) : (var1 == class_aet.a ? (world.worldProvider.m() ? 0 : var6.d(var3, var4 & 15, var5)) : (var1 == class_aet.b ? var6.e(var3, var4 & 15, var5) : var1.c));
	}

	public void a(class_aet var1, BlockPosition var2, int var3) {
		int var4 = var2.getX() & 15;
		int var5 = var2.getY();
		int var6 = var2.getZ() & 15;
		ChunkSection var7 = sections[var5 >> 4];
		if (var7 == null) {
			var7 = sections[var5 >> 4] = new ChunkSection((var5 >> 4) << 4, !world.worldProvider.m());
			this.initLighting();
		}

		q = true;
		if (var1 == class_aet.a) {
			if (!world.worldProvider.m()) {
				var7.a(var4, var5 & 15, var6, var3);
			}
		} else if (var1 == class_aet.b) {
			var7.b(var4, var5 & 15, var6, var3);
		}

	}

	public int a(BlockPosition var1, int var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getY();
		int var5 = var1.getZ() & 15;
		ChunkSection var6 = sections[var4 >> 4];
		if (var6 == null) {
			return !world.worldProvider.m() && (var2 < class_aet.a.c) ? class_aet.a.c - var2 : 0;
		} else {
			int var7 = world.worldProvider.m() ? 0 : var6.d(var3, var4 & 15, var5);
			var7 -= var2;
			int var8 = var6.e(var3, var4 & 15, var5);
			if (var8 > var7) {
				var7 = var8;
			}

			return var7;
		}
	}

	public void a(Entity var1) {
		r = true;
		int var2 = MathHelper.floor(var1.locX / 16.0D);
		int var3 = MathHelper.floor(var1.locZ / 16.0D);
		if ((var2 != locX) || (var3 != locZ)) {
			logger.warn("Wrong location! (" + var2 + ", " + var3 + ") should be (" + locX + ", " + locZ + "), " + var1, new Object[] { var1 });
			var1.die();
		}

		int var4 = MathHelper.floor(var1.locY / 16.0D);
		if (var4 < 0) {
			var4 = 0;
		}

		if (var4 >= entitySlices.length) {
			var4 = entitySlices.length - 1;
		}

		var1.ad = true;
		var1.ae = locX;
		var1.af = var4;
		var1.ag = locZ;
		entitySlices[var4].add(var1);
	}

	public void b(Entity var1) {
		this.a(var1, var1.af);
	}

	public void a(Entity var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		if (var2 >= entitySlices.length) {
			var2 = entitySlices.length - 1;
		}

		entitySlices[var2].remove(var1);
	}

	public boolean d(BlockPosition var1) {
		int var2 = var1.getX() & 15;
		int var3 = var1.getY();
		int var4 = var1.getZ() & 15;
		return var3 >= heightMap[(var4 << 4) | var2];
	}

	private TileEntity i(BlockPosition var1) {
		Block var2 = this.getType(var1);
		return !var2.isTileEntity() ? null : ((IContainer) var2).createTileEntity(world, this.c(var1));
	}

	public TileEntity a(BlockPosition var1, Chunk.class_a_in_class_aok var2) {
		TileEntity var3 = tileEntities.get(var1);
		if (var3 == null) {
			if (var2 == Chunk.class_a_in_class_aok.a) {
				var3 = this.i(var1);
				world.a(var1, var3);
			} else if (var2 == Chunk.class_a_in_class_aok.b) {
				w.add(var1);
			}
		} else if (var3.isInvalid()) {
			tileEntities.remove(var1);
			return null;
		}

		return var3;
	}

	public void a(TileEntity var1) {
		this.a(var1.getPosition(), var1);
		if (h) {
			world.a(var1);
		}

	}

	public void a(BlockPosition var1, TileEntity var2) {
		var2.setWorld(world);
		var2.setPosition(var1);
		if (this.getType(var1) instanceof IContainer) {
			if (tileEntities.containsKey(var1)) {
				tileEntities.get(var1).setInvalid();
			}

			var2.setValid();
			tileEntities.put(var1, var2);
		}
	}

	public void e(BlockPosition var1) {
		if (h) {
			TileEntity var2 = tileEntities.remove(var1);
			if (var2 != null) {
				var2.setInvalid();
			}
		}

	}

	public void c() {
		h = true;
		world.b(tileEntities.values());

		for (int var1 = 0; var1 < entitySlices.length; ++var1) {
			Iterator<?> var2 = entitySlices[var1].iterator();

			while (var2.hasNext()) {
				Entity var3 = (Entity) var2.next();
				var3.ah();
			}

			world.a(entitySlices[var1]);
		}

	}

	public void d() {
		h = false;
		Iterator<TileEntity> var1 = tileEntities.values().iterator();

		while (var1.hasNext()) {
			TileEntity var2 = var1.next();
			world.b(var2);
		}

		for (int var3 = 0; var3 < entitySlices.length; ++var3) {
			world.c(entitySlices[var3]);
		}

	}

	public void e() {
		q = true;
	}

	public void a(Entity var1, AxisAlignedBB var2, List<Entity> var3, Predicate<? super Entity> var4) {
		int var5 = MathHelper.floor((var2.yMin - 2.0D) / 16.0D);
		int var6 = MathHelper.floor((var2.yMax + 2.0D) / 16.0D);
		var5 = MathHelper.clamp(var5, 0, entitySlices.length - 1);
		var6 = MathHelper.clamp(var6, 0, entitySlices.length - 1);

		label68: for (int var7 = var5; var7 <= var6; ++var7) {
			if (!entitySlices[var7].isEmpty()) {
				Iterator<?> var8 = entitySlices[var7].iterator();

				while (true) {
					Entity var9;
					Entity[] var10;
					do {
						do {
							do {
								if (!var8.hasNext()) {
									continue label68;
								}

								var9 = (Entity) var8.next();
							} while (!var9.getBoundingBox().isInside(var2));
						} while (var9 == var1);

						if ((var4 == null) || var4.apply(var9)) {
							var3.add(var9);
						}

						var10 = var9.aD();
					} while (var10 == null);

					for (int var11 = 0; var11 < var10.length; ++var11) {
						var9 = var10[var11];
						if ((var9 != var1) && var9.getBoundingBox().isInside(var2) && ((var4 == null) || var4.apply(var9))) {
							var3.add(var9);
						}
					}
				}
			}
		}

	}

	public void a(Class<? extends Entity> var1, AxisAlignedBB var2, List<Entity> var3, Predicate<? super Entity> var4) {
		int var5 = MathHelper.floor((var2.yMin - 2.0D) / 16.0D);
		int var6 = MathHelper.floor((var2.yMax + 2.0D) / 16.0D);
		var5 = MathHelper.clamp(var5, 0, entitySlices.length - 1);
		var6 = MathHelper.clamp(var6, 0, entitySlices.length - 1);

		label33: for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator<?> var8 = entitySlices[var7].c(var1).iterator();

			while (true) {
				Entity var9;
				do {
					do {
						if (!var8.hasNext()) {
							continue label33;
						}

						var9 = (Entity) var8.next();
					} while (!var9.getBoundingBox().isInside(var2));
				} while ((var4 != null) && !var4.apply(var9));

				var3.add(var9);
			}
		}

	}

	public boolean a(boolean var1) {
		if (var1) {
			if ((r && (world.L() != lastSaved)) || q) {
				return true;
			}
		} else if (r && (world.L() >= (lastSaved + 600L))) {
			return true;
		}

		return q;
	}

	public Random a(long var1) {
		return new Random((world.K() + locX * locX * 4987142 + locX * 5947611 + (locZ * locZ * 4392871L) + locZ * 389711) ^ var1);
	}

	public boolean f() {
		return false;
	}

	public void a(IChunkProvider var1, IChunkProvider var2, int var3, int var4) {
		boolean var5 = var1.isChunkLoaded(var3, var4 - 1);
		boolean var6 = var1.isChunkLoaded(var3 + 1, var4);
		boolean var7 = var1.isChunkLoaded(var3, var4 + 1);
		boolean var8 = var1.isChunkLoaded(var3 - 1, var4);
		boolean var9 = var1.isChunkLoaded(var3 - 1, var4 - 1);
		boolean var10 = var1.isChunkLoaded(var3 + 1, var4 + 1);
		boolean var11 = var1.isChunkLoaded(var3 - 1, var4 + 1);
		boolean var12 = var1.isChunkLoaded(var3 + 1, var4 - 1);
		if (var6 && var7 && var10) {
			if (!done) {
				var1.getChunkAt(var2, var3, var4);
			} else {
				var1.a(var2, this, var3, var4);
			}
		}

		Chunk var13;
		if (var8 && var7 && var11) {
			var13 = var1.getOrCreateChunk(var3 - 1, var4);
			if (!var13.done) {
				var1.getChunkAt(var2, var3 - 1, var4);
			} else {
				var1.a(var2, var13, var3 - 1, var4);
			}
		}

		if (var5 && var6 && var12) {
			var13 = var1.getOrCreateChunk(var3, var4 - 1);
			if (!var13.done) {
				var1.getChunkAt(var2, var3, var4 - 1);
			} else {
				var1.a(var2, var13, var3, var4 - 1);
			}
		}

		if (var9 && var5 && var8) {
			var13 = var1.getOrCreateChunk(var3 - 1, var4 - 1);
			if (!var13.done) {
				var1.getChunkAt(var2, var3 - 1, var4 - 1);
			} else {
				var1.a(var2, var13, var3 - 1, var4 - 1);
			}
		}

	}

	public BlockPosition h(BlockPosition var1) {
		int var2 = var1.getX() & 15;
		int var3 = var1.getZ() & 15;
		int var4 = var2 | (var3 << 4);
		BlockPosition var5 = new BlockPosition(var1.getX(), f[var4], var1.getZ());
		if (var5.getY() == -999) {
			int var6 = this.getHighestChunkSectionY() + 15;
			var5 = new BlockPosition(var1.getX(), var6, var1.getZ());
			int var7 = -1;

			while (true) {
				while ((var5.getY() > 0) && (var7 == -1)) {
					Block var8 = this.getType(var5);
					Material var9 = var8.getMaterial();
					if (!var9.isSolid() && !var9.isLiquid()) {
						var5 = var5.down();
					} else {
						var7 = var5.getY() + 1;
					}
				}

				f[var4] = var7;
				break;
			}
		}

		return new BlockPosition(var1.getX(), f[var4], var1.getZ());
	}

	public void b(boolean var1) {
		if (k && !world.worldProvider.m() && !var1) {
			this.h(world.isClientSide);
		}

		p = true;
		if (!lit && done) {
			n();
		}

		while (!w.isEmpty()) {
			BlockPosition var2 = w.poll();
			if ((this.a(var2, Chunk.class_a_in_class_aok.c) == null) && this.getType(var2).isTileEntity()) {
				TileEntity var3 = this.i(var2);
				world.a(var2, var3);
				world.b(var2, var2);
			}
		}

	}

	public boolean i() {
		return p && done && lit;
	}

	public ChunkCoordIntPair j() {
		return new ChunkCoordIntPair(locX, locZ);
	}

	public boolean c(int var1, int var2) {
		if (var1 < 0) {
			var1 = 0;
		}

		if (var2 >= 256) {
			var2 = 255;
		}

		for (int var3 = var1; var3 <= var2; var3 += 16) {
			ChunkSection var4 = sections[var3 >> 4];
			if ((var4 != null) && !var4.a()) {
				return false;
			}
		}

		return true;
	}

	public void a(ChunkSection[] var1) {
		if (sections.length != var1.length) {
			logger.warn("Could not set level chunk sections, array length is " + var1.length + " instead of " + sections.length);
		} else {
			for (int var2 = 0; var2 < sections.length; ++var2) {
				sections[var2] = var1[var2];
			}

		}
	}

	public BiomeBase a(BlockPosition var1, WorldChunkManager var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getZ() & 15;
		int var5 = e[(var4 << 4) | var3] & 255;
		BiomeBase var6;
		if (var5 == 255) {
			var6 = var2.a(var1, BiomeBase.PLAINS);
			var5 = var6.id;
			e[(var4 << 4) | var3] = (byte) (var5 & 255);
		}

		var6 = BiomeBase.getBiome(var5);
		return var6 == null ? BiomeBase.PLAINS : var6;
	}

	public byte[] getBiomeIndex() {
		return e;
	}

	public void a(byte[] var1) {
		if (e.length != var1.length) {
			logger.warn("Could not set level chunk biomes, array length is " + var1.length + " instead of " + e.length);
		} else {
			for (int var2 = 0; var2 < e.length; ++var2) {
				e[var2] = var1[var2];
			}

		}
	}

	public void l() {
		v = 0;
	}

	public void m() {
		BlockPosition var1 = new BlockPosition(locX << 4, 0, locZ << 4);

		for (int var2 = 0; var2 < 8; ++var2) {
			if (v >= 4096) {
				return;
			}

			int var3 = v % 16;
			int var4 = (v / 16) % 16;
			int var5 = v / 256;
			++v;

			for (int var6 = 0; var6 < 16; ++var6) {
				BlockPosition var7 = var1.add(var4, (var3 << 4) + var6, var5);
				boolean var8 = (var6 == 0) || (var6 == 15) || (var4 == 0) || (var4 == 15) || (var5 == 0) || (var5 == 15);
				if (((sections[var3] == null) && var8) || ((sections[var3] != null) && (sections[var3].b(var4, var6, var5).getMaterial() == Material.AIR))) {
					EnumDirection[] var9 = EnumDirection.values();
					int var10 = var9.length;

					for (int var11 = 0; var11 < var10; ++var11) {
						EnumDirection var12 = var9[var11];
						BlockPosition var13 = var7.shift(var12);
						if (world.getType(var13).getBlock().getLightLevel() > 0) {
							world.x(var13);
						}
					}

					world.x(var7);
				}
			}
		}

	}

	public void n() {
		done = true;
		lit = true;
		BlockPosition var1 = new BlockPosition(locX << 4, 0, locZ << 4);
		if (!world.worldProvider.m()) {
			if (world.areChunksLoadedBetween(var1.add(-1, 0, -1), var1.add(16, world.G(), 16))) {
				label44: for (int var2 = 0; var2 < 16; ++var2) {
					for (int var3 = 0; var3 < 16; ++var3) {
						if (!this.e(var2, var3)) {
							lit = false;
							break label44;
						}
					}
				}

			if (lit) {
				Iterator<?> var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

				while (var5.hasNext()) {
					EnumDirection var6 = (EnumDirection) var5.next();
					int var4 = var6.getAxisDirection() == EnumDirection.EnumAxisDirection.POSITIVE ? 16 : 1;
					world.f(var1.shift(var6, var4)).a(var6.opposite());
				}

				y();
			}
			} else {
				lit = false;
			}
		}

	}

	private void y() {
		for (int var1 = 0; var1 < g.length; ++var1) {
			g[var1] = true;
		}

		this.h(false);
	}

	private void a(EnumDirection var1) {
		if (done) {
			int var2;
			if (var1 == EnumDirection.EAST) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(15, var2);
				}
			} else if (var1 == EnumDirection.WEST) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(0, var2);
				}
			} else if (var1 == EnumDirection.SOUTH) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 15);
				}
			} else if (var1 == EnumDirection.NORTH) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 0);
				}
			}

		}
	}

	private boolean e(int var1, int var2) {
		int var3 = this.getHighestChunkSectionY();
		boolean var4 = false;
		boolean var5 = false;
		BlockPosition.MutableBlockPosition var6 = new BlockPosition.MutableBlockPosition((locX << 4) + var1, 0, (locZ << 4) + var2);

		int var7;
		for (var7 = (var3 + 16) - 1; (var7 > world.G()) || ((var7 > 0) && !var5); --var7) {
			var6.setPosition(var6.getX(), var7, var6.getZ());
			int var8 = this.b(var6);
			if ((var8 == 255) && (var6.getY() < world.G())) {
				var5 = true;
			}

			if (!var4 && (var8 > 0)) {
				var4 = true;
			} else if (var4 && (var8 == 0) && !world.x(var6)) {
				return false;
			}
		}

		for (var7 = var6.getY(); var7 > 0; --var7) {
			var6.setPosition(var6.getX(), var7, var6.getZ());
			if (this.getType(var6).getLightLevel() > 0) {
				world.x(var6);
			}
		}

		return true;
	}

	public boolean o() {
		return h;
	}

	public World p() {
		return world;
	}

	public int[] q() {
		return heightMap;
	}

	public void a(int[] var1) {
		if (heightMap.length != var1.length) {
			logger.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + heightMap.length);
		} else {
			for (int var2 = 0; var2 < heightMap.length; ++var2) {
				heightMap[var2] = var1[var2];
			}

		}
	}

	public Map<BlockPosition, TileEntity> r() {
		return tileEntities;
	}

	public EntitySlice[] s() {
		return entitySlices;
	}

	public boolean t() {
		return done;
	}

	public void d(boolean var1) {
		done = var1;
	}

	public boolean u() {
		return lit;
	}

	public void e(boolean var1) {
		lit = var1;
	}

	public void f(boolean var1) {
		q = var1;
	}

	public void g(boolean var1) {
		r = var1;
	}

	public void b(long var1) {
		lastSaved = var1;
	}

	public int v() {
		return t;
	}

	public long w() {
		return u;
	}

	public void c(long var1) {
		u = var1;
	}

	public static enum class_a_in_class_aok {
		a, b, c;
	}
}
