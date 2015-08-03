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

	private final ChunkSection[] d;
	private final byte[] e;
	private final int[] f;
	private final boolean[] g;
	private boolean h;
	private final World i;
	private final int[] j;
	public final int a;
	public final int b;
	private boolean k;
	private final Map<BlockPosition, TileEntity> tileEntities;
	private final EntitySlice[] entities;
	private boolean n;
	private boolean o;
	private boolean p;
	private boolean q;
	private boolean r;
	private long s;
	private int t;
	private long u;
	private int v;
	private ConcurrentLinkedQueue<BlockPosition> w;

	public Chunk(World var1, int var2, int var3) {
		d = new ChunkSection[16];
		e = new byte[256];
		f = new int[256];
		g = new boolean[256];
		tileEntities = Maps.newHashMap();
		v = 4096;
		w = Queues.newConcurrentLinkedQueue();
		entities = (new EntitySlice[16]);
		i = var1;
		a = var2;
		b = var3;
		j = new int[256];

		for (int var4 = 0; var4 < entities.length; ++var4) {
			entities[var4] = new EntitySlice(Entity.class);
		}

		Arrays.fill(f, -999);
		Arrays.fill(e, (byte) -1);
	}

	public Chunk(World var1, class_aph var2, int var3, int var4) {
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
				if (d[var12] == null) {
					d[var12] = new ChunkSection(var12 << 4, var6);
				}

				d[var12].a(var7, var9 & 15, var8, var11);
					}
				}
			}
		}

	}

	public boolean a(int var1, int var2) {
		return (var1 == a) && (var2 == b);
	}

	public int f(BlockPosition var1) {
		return this.b(var1.getX() & 15, var1.getZ() & 15);
	}

	public int b(int var1, int var2) {
		return j[(var2 << 4) | var1];
	}

	public int g() {
		for (int var1 = d.length - 1; var1 >= 0; --var1) {
			if (d[var1] != null) {
				return d[var1].d();
			}
		}

		return 0;
	}

	public ChunkSection[] h() {
		return d;
	}

	public void b() {
		int var1 = this.g();
		t = Integer.MAX_VALUE;

		for (int var2 = 0; var2 < 16; ++var2) {
			for (int var3 = 0; var3 < 16; ++var3) {
				f[var2 + (var3 << 4)] = -999;

				int var4;
				for (var4 = var1 + 16; var4 > 0; --var4) {
					if (this.e(var2, var4 - 1, var3) != 0) {
						j[(var3 << 4) | var2] = var4;
						if (var4 < t) {
							t = var4;
						}
						break;
					}
				}

				if (!i.worldProvider.m()) {
					var4 = 15;
					int var5 = (var1 + 16) - 1;

					do {
						int var6 = this.e(var2, var5, var3);
						if ((var6 == 0) && (var4 != 15)) {
							var6 = 1;
						}

						var4 -= var6;
						if (var4 > 0) {
							ChunkSection var7 = d[var5 >> 4];
							if (var7 != null) {
								var7.a(var2, var5 & 15, var3, var4);
								i.n(new BlockPosition((a << 4) + var2, var5, (b << 4) + var3));
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
		i.B.a("recheckGaps");
		if (i.a((new BlockPosition((a * 16) + 8, 0, (b * 16) + 8)), 16)) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					if (g[var2 + (var3 * 16)]) {
						g[var2 + (var3 * 16)] = false;
						int var4 = this.b(var2, var3);
						int var5 = (a * 16) + var2;
						int var6 = (b * 16) + var3;
						int var7 = Integer.MAX_VALUE;

						Iterator<?> var8;
						EnumDirection var9;
						for (var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator(); var8.hasNext(); var7 = Math.min(var7, i.b(var5 + var9.getAdjacentX(), var6 + var9.getAdjacentZ()))) {
							var9 = (EnumDirection) var8.next();
						}

						this.c(var5, var6, var7);
						var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

						while (var8.hasNext()) {
							var9 = (EnumDirection) var8.next();
							this.c(var5 + var9.getAdjacentX(), var6 + var9.getAdjacentZ(), var4);
						}

						if (var1) {
							i.B.b();
							return;
						}
					}
				}
			}

			k = false;
		}

		i.B.b();
	}

	private void c(int var1, int var2, int var3) {
		int var4 = i.m(new BlockPosition(var1, 0, var2)).getY();
		if (var4 > var3) {
			this.a(var1, var2, var3, var4 + 1);
		} else if (var4 < var3) {
			this.a(var1, var2, var4, var3 + 1);
		}

	}

	private void a(int var1, int var2, int var3, int var4) {
		if ((var4 > var3) && i.a((new BlockPosition(var1, 0, var2)), 16)) {
			for (int var5 = var3; var5 < var4; ++var5) {
				i.c(class_aet.a, new BlockPosition(var1, var5, var2));
			}

			q = true;
		}

	}

	private void d(int var1, int var2, int var3) {
		int var4 = j[(var3 << 4) | var1] & 255;
		int var5 = var4;
		if (var2 > var4) {
			var5 = var2;
		}

		while ((var5 > 0) && (this.e(var1, var5 - 1, var3) == 0)) {
			--var5;
		}

		if (var5 != var4) {
			i.a(var1 + (a * 16), var3 + (b * 16), var5, var4);
			j[(var3 << 4) | var1] = var5;
			int var6 = (a * 16) + var1;
			int var7 = (b * 16) + var3;
			int var8;
			int var13;
			if (!i.worldProvider.m()) {
				ChunkSection var9;
				if (var5 < var4) {
					for (var8 = var5; var8 < var4; ++var8) {
						var9 = d[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 15);
							i.n(new BlockPosition((a << 4) + var1, var8, (b << 4) + var3));
						}
					}
				} else {
					for (var8 = var4; var8 < var5; ++var8) {
						var9 = d[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 0);
							i.n(new BlockPosition((a << 4) + var1, var8, (b << 4) + var3));
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

					ChunkSection var10 = d[var5 >> 4];
					if (var10 != null) {
						var10.a(var1, var5 & 15, var3, var8);
					}
				}
			}

			var8 = j[(var3 << 4) | var1];
			var13 = var4;
			int var14 = var8;
			if (var8 < var4) {
				var13 = var8;
				var14 = var4;
			}

			if (var8 < t) {
				t = var8;
			}

			if (!i.worldProvider.m()) {
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
		return this.a(var1).getLightOpacity();
	}

	private int e(int var1, int var2, int var3) {
		return this.f(var1, var2, var3).getLightOpacity();
	}

	private Block f(int var1, int var2, int var3) {
		Block var4 = Blocks.AIR;
		if ((var2 >= 0) && ((var2 >> 4) < d.length)) {
			ChunkSection var5 = d[var2 >> 4];
			if (var5 != null) {
				try {
					var4 = var5.b(var1, var2 & 15, var3);
				} catch (Throwable var8) {
					class_b var7 = class_b.a(var8, "Getting block");
					throw new class_e(var7);
				}
			}
		}

		return var4;
	}

	public Block a(final int var1, final int var2, final int var3) {
		try {
			return this.f(var1 & 15, var2, var3 & 15);
		} catch (class_e var6) {
			class_c var5 = var6.a().a("Block being got");
			var5.a("Location", new Callable<Object>() {
				public String a() throws Exception {
					return class_c.a(new BlockPosition((a * 16) + var1, var2, (b * 16) + var3));
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
			throw var6;
		}
	}

	public Block a(final BlockPosition var1) {
		try {
			return this.f(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
		} catch (class_e var4) {
			class_c var3 = var4.a().a("Block being got");
			var3.a("Location", new Callable<Object>() {
				public String a() throws Exception {
					return class_c.a(var1);
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
			throw var4;
		}
	}

	public IBlockData g(final BlockPosition var1) {
		if (i.H() == class_aes.g) {
			IBlockData var7 = null;
			if (var1.getY() == 60) {
				var7 = Blocks.BARRIER.getBlockData();
			}

			if (var1.getY() == 70) {
				var7 = class_apj.b(var1.getX(), var1.getZ());
			}

			return var7 == null ? Blocks.AIR.getBlockData() : var7;
		} else {
			try {
				if ((var1.getY() >= 0) && ((var1.getY() >> 4) < d.length)) {
					ChunkSection var2 = d[var1.getY() >> 4];
					if (var2 != null) {
						int var8 = var1.getX() & 15;
						int var9 = var1.getY() & 15;
						int var5 = var1.getZ() & 15;
						return var2.a(var8, var9, var5);
					}
				}

				return Blocks.AIR.getBlockData();
			} catch (Throwable var6) {
				class_b var3 = class_b.a(var6, "Getting block state");
				class_c var4 = var3.a("Block being got");
				var4.a("Location", new Callable<Object>() {
					public String a() throws Exception {
						return class_c.a(var1);
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				throw new class_e(var3);
			}
		}
	}

	private int g(int var1, int var2, int var3) {
		if ((var2 >> 4) >= d.length) {
			return 0;
		} else {
			ChunkSection var4 = d[var2 >> 4];
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

		int var7 = j[var6];
		IBlockData var8 = this.g(var1);
		if (var8 == var2) {
			return null;
		} else {
			Block var9 = var2.getBlock();
			Block var10 = var8.getBlock();
			ChunkSection var11 = d[var4 >> 4];
			boolean var12 = false;
			if (var11 == null) {
				if (var9 == Blocks.AIR) {
					return null;
				}

				var11 = d[var4 >> 4] = new ChunkSection((var4 >> 4) << 4, !i.worldProvider.m());
				var12 = var4 >= var7;
			}

			var11.a(var3, var4 & 15, var5, var2);
			if (var10 != var9) {
				if (!i.isClientSide) {
					var10.remove(i, var1, var8);
				} else if (var10 instanceof IContainer) {
					i.t(var1);
				}
			}

			if (var11.b(var3, var4 & 15, var5) != var9) {
				return null;
			} else {
				if (var12) {
					this.b();
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

				if (!i.isClientSide && (var10 != var9)) {
					var9.onPlace(i, var1, var2);
				}

				if (var9 instanceof IContainer) {
					var15 = this.a(var1, Chunk.class_a_in_class_aok.c);
					if (var15 == null) {
						var15 = ((IContainer) var9).createTileEntity(i, var9.toLegacyData(var2));
						i.a(var1, var15);
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
		ChunkSection var6 = d[var4 >> 4];
		return var6 == null ? (this.d(var2) ? var1.c : 0) : (var1 == class_aet.a ? (i.worldProvider.m() ? 0 : var6.d(var3, var4 & 15, var5)) : (var1 == class_aet.b ? var6.e(var3, var4 & 15, var5) : var1.c));
	}

	public void a(class_aet var1, BlockPosition var2, int var3) {
		int var4 = var2.getX() & 15;
		int var5 = var2.getY();
		int var6 = var2.getZ() & 15;
		ChunkSection var7 = d[var5 >> 4];
		if (var7 == null) {
			var7 = d[var5 >> 4] = new ChunkSection((var5 >> 4) << 4, !i.worldProvider.m());
			this.b();
		}

		q = true;
		if (var1 == class_aet.a) {
			if (!i.worldProvider.m()) {
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
		ChunkSection var6 = d[var4 >> 4];
		if (var6 == null) {
			return !i.worldProvider.m() && (var2 < class_aet.a.c) ? class_aet.a.c - var2 : 0;
		} else {
			int var7 = i.worldProvider.m() ? 0 : var6.d(var3, var4 & 15, var5);
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
		int var2 = MathHelper.floor(var1.s / 16.0D);
		int var3 = MathHelper.floor(var1.u / 16.0D);
		if ((var2 != a) || (var3 != b)) {
			logger.warn("Wrong location! (" + var2 + ", " + var3 + ") should COOKIE (" + a + ", " + b + "), " + var1, new Object[] { var1 });
			var1.J();
		}

		int var4 = MathHelper.floor(var1.t / 16.0D);
		if (var4 < 0) {
			var4 = 0;
		}

		if (var4 >= entities.length) {
			var4 = entities.length - 1;
		}

		var1.ad = true;
		var1.ae = a;
		var1.af = var4;
		var1.ag = b;
		entities[var4].add(var1);
	}

	public void b(Entity var1) {
		this.a(var1, var1.af);
	}

	public void a(Entity var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		if (var2 >= entities.length) {
			var2 = entities.length - 1;
		}

		entities[var2].remove(var1);
	}

	public boolean d(BlockPosition var1) {
		int var2 = var1.getX() & 15;
		int var3 = var1.getY();
		int var4 = var1.getZ() & 15;
		return var3 >= j[(var4 << 4) | var2];
	}

	private TileEntity i(BlockPosition var1) {
		Block var2 = this.a(var1);
		return !var2.isTileEntity() ? null : ((IContainer) var2).createTileEntity(i, this.c(var1));
	}

	public TileEntity a(BlockPosition var1, Chunk.class_a_in_class_aok var2) {
		TileEntity var3 = tileEntities.get(var1);
		if (var3 == null) {
			if (var2 == Chunk.class_a_in_class_aok.a) {
				var3 = this.i(var1);
				i.a(var1, var3);
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
			i.a(var1);
		}

	}

	public void a(BlockPosition var1, TileEntity var2) {
		var2.setWorld(i);
		var2.setPosition(var1);
		if (this.a(var1) instanceof IContainer) {
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
		i.b(tileEntities.values());

		for (int var1 = 0; var1 < entities.length; ++var1) {
			Iterator<?> var2 = entities[var1].iterator();

			while (var2.hasNext()) {
				Entity var3 = (Entity) var2.next();
				var3.ah();
			}

			i.a(entities[var1]);
		}

	}

	public void d() {
		h = false;
		Iterator<TileEntity> var1 = tileEntities.values().iterator();

		while (var1.hasNext()) {
			TileEntity var2 = var1.next();
			i.b(var2);
		}

		for (int var3 = 0; var3 < entities.length; ++var3) {
			i.c(entities[var3]);
		}

	}

	public void e() {
		q = true;
	}

	public void a(Entity var1, AxisAlignedBB var2, List<Entity> var3, Predicate<? super Entity> var4) {
		int var5 = MathHelper.floor((var2.yMin - 2.0D) / 16.0D);
		int var6 = MathHelper.floor((var2.yMax + 2.0D) / 16.0D);
		var5 = MathHelper.clamp(var5, 0, entities.length - 1);
		var6 = MathHelper.clamp(var6, 0, entities.length - 1);

		label68: for (int var7 = var5; var7 <= var6; ++var7) {
			if (!entities[var7].isEmpty()) {
				Iterator<?> var8 = entities[var7].iterator();

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
							} while (!var9.aT().isInside(var2));
						} while (var9 == var1);

						if ((var4 == null) || var4.apply(var9)) {
							var3.add(var9);
						}

						var10 = var9.aD();
					} while (var10 == null);

					for (int var11 = 0; var11 < var10.length; ++var11) {
						var9 = var10[var11];
						if ((var9 != var1) && var9.aT().isInside(var2) && ((var4 == null) || var4.apply(var9))) {
							var3.add(var9);
						}
					}
				}
			}
		}

	}

	public void a(Class<?> var1, AxisAlignedBB var2, List<Entity> var3, Predicate<Entity> var4) {
		int var5 = MathHelper.floor((var2.yMin - 2.0D) / 16.0D);
		int var6 = MathHelper.floor((var2.yMax + 2.0D) / 16.0D);
		var5 = MathHelper.clamp(var5, 0, entities.length - 1);
		var6 = MathHelper.clamp(var6, 0, entities.length - 1);

		label33: for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator<?> var8 = entities[var7].c(var1).iterator();

			while (true) {
				Entity var9;
				do {
					do {
						if (!var8.hasNext()) {
							continue label33;
						}

						var9 = (Entity) var8.next();
					} while (!var9.aT().isInside(var2));
				} while ((var4 != null) && !var4.apply(var9));

				var3.add(var9);
			}
		}

	}

	public boolean a(boolean var1) {
		if (var1) {
			if ((r && (i.L() != s)) || q) {
				return true;
			}
		} else if (r && (i.L() >= (s + 600L))) {
			return true;
		}

		return q;
	}

	public Random a(long var1) {
		return new Random((i.K() + a * a * 4987142 + a * 5947611 + (b * b * 4392871L) + b * 389711) ^ var1);
	}

	public boolean f() {
		return false;
	}

	public void a(class_aoh var1, class_aoh var2, int var3, int var4) {
		boolean var5 = var1.a(var3, var4 - 1);
		boolean var6 = var1.a(var3 + 1, var4);
		boolean var7 = var1.a(var3, var4 + 1);
		boolean var8 = var1.a(var3 - 1, var4);
		boolean var9 = var1.a(var3 - 1, var4 - 1);
		boolean var10 = var1.a(var3 + 1, var4 + 1);
		boolean var11 = var1.a(var3 - 1, var4 + 1);
		boolean var12 = var1.a(var3 + 1, var4 - 1);
		if (var6 && var7 && var10) {
			if (!n) {
				var1.a(var2, var3, var4);
			} else {
				var1.a(var2, this, var3, var4);
			}
		}

		Chunk var13;
		if (var8 && var7 && var11) {
			var13 = var1.d(var3 - 1, var4);
			if (!var13.n) {
				var1.a(var2, var3 - 1, var4);
			} else {
				var1.a(var2, var13, var3 - 1, var4);
			}
		}

		if (var5 && var6 && var12) {
			var13 = var1.d(var3, var4 - 1);
			if (!var13.n) {
				var1.a(var2, var3, var4 - 1);
			} else {
				var1.a(var2, var13, var3, var4 - 1);
			}
		}

		if (var9 && var5 && var8) {
			var13 = var1.d(var3 - 1, var4 - 1);
			if (!var13.n) {
				var1.a(var2, var3 - 1, var4 - 1);
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
			int var6 = this.g() + 15;
			var5 = new BlockPosition(var1.getX(), var6, var1.getZ());
			int var7 = -1;

			while (true) {
				while ((var5.getY() > 0) && (var7 == -1)) {
					Block var8 = this.a(var5);
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
		if (k && !i.worldProvider.m() && !var1) {
			this.h(i.isClientSide);
		}

		p = true;
		if (!o && n) {
			n();
		}

		while (!w.isEmpty()) {
			BlockPosition var2 = w.poll();
			if ((this.a(var2, Chunk.class_a_in_class_aok.c) == null) && this.a(var2).isTileEntity()) {
				TileEntity var3 = this.i(var2);
				i.a(var2, var3);
				i.b(var2, var2);
			}
		}

	}

	public boolean i() {
		return p && n && o;
	}

	public class_aeh j() {
		return new class_aeh(a, b);
	}

	public boolean c(int var1, int var2) {
		if (var1 < 0) {
			var1 = 0;
		}

		if (var2 >= 256) {
			var2 = 255;
		}

		for (int var3 = var1; var3 <= var2; var3 += 16) {
			ChunkSection var4 = d[var3 >> 4];
			if ((var4 != null) && !var4.a()) {
				return false;
			}
		}

		return true;
	}

	public void a(ChunkSection[] var1) {
		if (d.length != var1.length) {
			logger.warn("Could not set level chunk sections, array length is " + var1.length + " instead of " + d.length);
		} else {
			for (int var2 = 0; var2 < d.length; ++var2) {
				d[var2] = var1[var2];
			}

		}
	}

	public BiomeBase a(BlockPosition var1, class_afd var2) {
		int var3 = var1.getX() & 15;
		int var4 = var1.getZ() & 15;
		int var5 = e[(var4 << 4) | var3] & 255;
		BiomeBase var6;
		if (var5 == 255) {
			var6 = var2.a(var1, BiomeBase.q);
			var5 = var6.az;
			e[(var4 << 4) | var3] = (byte) (var5 & 255);
		}

		var6 = BiomeBase.e(var5);
		return var6 == null ? BiomeBase.q : var6;
	}

	public byte[] k() {
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
		BlockPosition var1 = new BlockPosition(a << 4, 0, b << 4);

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
				if (((d[var3] == null) && var8) || ((d[var3] != null) && (d[var3].b(var4, var6, var5).getMaterial() == Material.AIR))) {
					EnumDirection[] var9 = EnumDirection.values();
					int var10 = var9.length;

					for (int var11 = 0; var11 < var10; ++var11) {
						EnumDirection var12 = var9[var11];
						BlockPosition var13 = var7.shift(var12);
						if (i.getType(var13).getBlock().getLightLevel() > 0) {
							i.x(var13);
						}
					}

					i.x(var7);
				}
			}
		}

	}

	public void n() {
		n = true;
		o = true;
		BlockPosition var1 = new BlockPosition(a << 4, 0, b << 4);
		if (!i.worldProvider.m()) {
			if (i.areChunksLoadedBetween(var1.add(-1, 0, -1), var1.add(16, i.G(), 16))) {
				label44: for (int var2 = 0; var2 < 16; ++var2) {
					for (int var3 = 0; var3 < 16; ++var3) {
						if (!this.e(var2, var3)) {
							o = false;
							break label44;
						}
					}
				}

			if (o) {
				Iterator<?> var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

				while (var5.hasNext()) {
					EnumDirection var6 = (EnumDirection) var5.next();
					int var4 = var6.getAxisDirection() == EnumDirection.EnumAxisDirection.POSITIVE ? 16 : 1;
					i.f(var1.shift(var6, var4)).a(var6.opposite());
				}

				y();
			}
			} else {
				o = false;
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
		if (n) {
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
		int var3 = this.g();
		boolean var4 = false;
		boolean var5 = false;
		BlockPosition.MutableBlockPosition var6 = new BlockPosition.MutableBlockPosition((a << 4) + var1, 0, (b << 4) + var2);

		int var7;
		for (var7 = (var3 + 16) - 1; (var7 > i.G()) || ((var7 > 0) && !var5); --var7) {
			var6.setPosition(var6.getX(), var7, var6.getZ());
			int var8 = this.b(var6);
			if ((var8 == 255) && (var6.getY() < i.G())) {
				var5 = true;
			}

			if (!var4 && (var8 > 0)) {
				var4 = true;
			} else if (var4 && (var8 == 0) && !i.x(var6)) {
				return false;
			}
		}

		for (var7 = var6.getY(); var7 > 0; --var7) {
			var6.setPosition(var6.getX(), var7, var6.getZ());
			if (this.a(var6).getLightLevel() > 0) {
				i.x(var6);
			}
		}

		return true;
	}

	public boolean o() {
		return h;
	}

	public World p() {
		return i;
	}

	public int[] q() {
		return j;
	}

	public void a(int[] var1) {
		if (j.length != var1.length) {
			logger.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + j.length);
		} else {
			for (int var2 = 0; var2 < j.length; ++var2) {
				j[var2] = var1[var2];
			}

		}
	}

	public Map<BlockPosition, TileEntity> r() {
		return tileEntities;
	}

	public EntitySlice[] s() {
		return entities;
	}

	public boolean t() {
		return n;
	}

	public void d(boolean var1) {
		n = var1;
	}

	public boolean u() {
		return o;
	}

	public void e(boolean var1) {
		o = var1;
	}

	public void f(boolean var1) {
		q = var1;
	}

	public void g(boolean var1) {
		r = var1;
	}

	public void b(long var1) {
		s = var1;
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
