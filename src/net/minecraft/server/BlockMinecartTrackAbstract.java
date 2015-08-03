package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public abstract class BlockMinecartTrackAbstract extends Block {

	protected final boolean a;

	public static boolean e(World var0, BlockPosition var1) {
		return d(var0.getType(var1));
	}

	public static boolean d(IBlockData var0) {
		Block var1 = var0.getBlock();
		return (var1 == BlockStainedGlassPane.RAIL) || (var1 == BlockStainedGlassPane.GOLDEN_RAIL) || (var1 == BlockStainedGlassPane.DETECTOR_RAIL) || (var1 == BlockStainedGlassPane.ACTIVATOR_RAIL);
	}

	protected BlockMinecartTrackAbstract(boolean var1) {
		super(Material.ORIENTABLE);
		a = var1;
		setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		setCreativeTab(CreativeTab.TRANSPORTATION);
	}

	@Override
	public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
		return null;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public MovingObjectPosition rayTraceCollision(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
		isReplaceable(var1, var2);
		return super.rayTraceCollision(var1, var2, var3, var4);
	}

	@Override
	public void updateShape(IBlockAccess var1, BlockPosition var2) {
		IBlockData var3 = var1.getType(var2);
		BlockMinecartTrackAbstract.EnumTrackPosition var4 = var3.getBlock() == this ? (BlockMinecartTrackAbstract.EnumTrackPosition) var3.get(n()) : null;
		if ((var4 != null) && var4.isAscending()) {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
		} else {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		}

	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean canPlace(World var1, BlockPosition var2) {
		return World.a(var1, var2.down());
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		if (!var1.isClientSide) {
			var3 = this.a(var1, var2, var3, true);
			if (a) {
				doPhysics(var1, var2, var3, this);
			}
		}

	}

	@Override
	public void doPhysics(World world, BlockPosition position, IBlockData blockdata, Block var4) {
		if (!world.isClientSide) {
			BlockMinecartTrackAbstract.EnumTrackPosition var5 = blockdata.get(n());
			boolean var6 = false;
			if (!World.a(world, position.down())) {
				var6 = true;
			}

			if ((var5 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST) && !World.a(world, position.east())) {
				var6 = true;
			} else if ((var5 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST) && !World.a(world, position.west())) {
				var6 = true;
			} else if ((var5 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH) && !World.a(world, position.north())) {
				var6 = true;
			} else if ((var5 == BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH) && !World.a(world, position.south())) {
				var6 = true;
			}

			if (var6) {
				dropNaturallyForSure(world, position, blockdata, 0);
				world.setAir(position);
			} else {
				this.b(world, position, blockdata, var4);
			}

		}
	}

	protected void b(World var1, BlockPosition var2, IBlockData var3, Block var4) {
	}

	protected IBlockData a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
		return var1.isClientSide ? var3 : (new BlockMinecartTrackAbstract.MinecartTrackLogic(var1, var2, var3)).a(var1.isBlockIndirectlyPowered(var2), var4).getBlockData();
	}

	@Override
	public int getPushReaction() {
		return 0;
	}

	@Override
	public void remove(World var1, BlockPosition var2, IBlockData var3) {
		super.remove(var1, var2, var3);
		if (var3.get(n()).isAscending()) {
			var1.c(var2.up(), this);
		}

		if (a) {
			var1.c(var2, this);
			var1.c(var2.down(), this);
		}

	}

	public abstract IBlockState<EnumTrackPosition> n();

	public static enum EnumTrackPosition implements INamable {
		NORTH_SOUTH(0, "north_south"),
		EAST_WEST(1, "east_west"),
		ASCENDING_EAST(2, "ascending_east"),
		ASCENDING_WEST(3, "ascending_west"),
		ASCENDING_NORTH(4, "ascending_north"),
		ASCENDING_SOUTH(5, "ascending_south"),
		SOUTH_EAST(6, "south_east"),
		SOUTH_WEST(7, "south_west"),
		NORTH_WEST(8, "north_west"),
		NORTH_EAST(9, "north_east");

		private static final BlockMinecartTrackAbstract.EnumTrackPosition[] BY_ID = new BlockMinecartTrackAbstract.EnumTrackPosition[values().length];
		static {
			for (EnumTrackPosition trackposition : values()) {
				BY_ID[trackposition.getId()] = trackposition;
			}
		}

		public static BlockMinecartTrackAbstract.EnumTrackPosition getById(int id) {
			if ((id < 0) || (id >= BY_ID.length)) {
				id = 0;
			}
			return BY_ID[id];
		}

		private final int id;
		private final String name;

		private EnumTrackPosition(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return name;
		}

		public boolean isAscending() {
			return (this == ASCENDING_NORTH) || (this == ASCENDING_EAST) || (this == ASCENDING_SOUTH) || (this == ASCENDING_WEST);
		}

		@Override
		public String getName() {
			return name;
		}

	}

	public class MinecartTrackLogic {

		private final World world;
		private final BlockPosition position;
		private final BlockMinecartTrackAbstract block;
		private IBlockData blockdata;
		private final boolean f;
		private final List<BlockPosition> g = Lists.newArrayList();

		public MinecartTrackLogic(World var2, BlockPosition var3, IBlockData var4) {
			this.world = var2;
			position = var3;
			blockdata = var4;
			block = (BlockMinecartTrackAbstract) var4.getBlock();
			BlockMinecartTrackAbstract.EnumTrackPosition var5 = var4.get(block.n());
			f = block.a;
			this.a(var5);
		}

		private void a(BlockMinecartTrackAbstract.EnumTrackPosition var1) {
			g.clear();
			switch (var1) {
				case NORTH_SOUTH:
					g.add(position.north());
					g.add(position.south());
					break;
				case EAST_WEST:
					g.add(position.west());
					g.add(position.east());
					break;
				case ASCENDING_EAST:
					g.add(position.west());
					g.add(position.east().up());
					break;
				case ASCENDING_WEST:
					g.add(position.west().up());
					g.add(position.east());
					break;
				case ASCENDING_NORTH:
					g.add(position.north().up());
					g.add(position.south());
					break;
				case ASCENDING_SOUTH:
					g.add(position.north());
					g.add(position.south().up());
					break;
				case SOUTH_EAST:
					g.add(position.east());
					g.add(position.south());
					break;
				case SOUTH_WEST:
					g.add(position.west());
					g.add(position.south());
					break;
				case NORTH_WEST:
					g.add(position.west());
					g.add(position.north());
					break;
				case NORTH_EAST:
					g.add(position.east());
					g.add(position.north());
			}

		}

		private void c() {
			for (int i = 0; i < g.size(); ++i) {
				MinecartTrackLogic var2 = this.b(g.get(i));
				if ((var2 != null) && var2.a(this)) {
					g.set(i, var2.position);
				} else {
					g.remove(i--);
				}
			}

		}

		private boolean a(BlockPosition var1) {
			return BlockMinecartTrackAbstract.e(world, var1) || BlockMinecartTrackAbstract.e(world, var1.up()) || BlockMinecartTrackAbstract.e(world, var1.down());
		}

		private MinecartTrackLogic b(BlockPosition var1) {
			IBlockData var3 = world.getType(var1);
			if (BlockMinecartTrackAbstract.d(var3)) {
				return BlockMinecartTrackAbstract.this.new MinecartTrackLogic(world, var1, var3);
			} else {
				BlockPosition var2 = var1.up();
				var3 = world.getType(var2);
				if (BlockMinecartTrackAbstract.d(var3)) {
					return BlockMinecartTrackAbstract.this.new MinecartTrackLogic(world, var2, var3);
				} else {
					var2 = var1.down();
					var3 = world.getType(var2);
					return BlockMinecartTrackAbstract.d(var3) ? new MinecartTrackLogic(world, var2, var3) : null;
				}
			}
		}

		private boolean a(MinecartTrackLogic var1) {
			return this.c(var1.position);
		}

		private boolean c(BlockPosition var1) {
			for (int var2 = 0; var2 < g.size(); ++var2) {
				BlockPosition var3 = g.get(var2);
				if ((var3.getX() == var1.getX()) && (var3.getZ() == var1.getZ())) {
					return true;
				}
			}

			return false;
		}

		protected int a() {
			int var1 = 0;
			Iterator<?> var2 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

			while (var2.hasNext()) {
				EnumDirection var3 = (EnumDirection) var2.next();
				if (this.a(position.shift(var3))) {
					++var1;
				}
			}

			return var1;
		}

		private boolean b(MinecartTrackLogic var1) {
			return this.a(var1) || (g.size() != 2);
		}

		private void c(MinecartTrackLogic var1) {
			g.add(var1.position);
			BlockPosition var2 = position.north();
			BlockPosition var3 = position.south();
			BlockPosition var4 = position.west();
			BlockPosition var5 = position.east();
			boolean var6 = this.c(var2);
			boolean var7 = this.c(var3);
			boolean var8 = this.c(var4);
			boolean var9 = this.c(var5);
			BlockMinecartTrackAbstract.EnumTrackPosition var10 = null;
			if (var6 || var7) {
				var10 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
			}

			if (var8 || var9) {
				var10 = BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST;
			}

			if (!f) {
				if (var7 && var9 && !var6 && !var8) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST;
				}

				if (var7 && var8 && !var6 && !var9) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST;
				}

				if (var6 && var8 && !var7 && !var9) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST;
				}

				if (var6 && var9 && !var7 && !var8) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST;
				}
			}

			if (var10 == BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH) {
				if (BlockMinecartTrackAbstract.e(world, var2.up())) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH;
				}

				if (BlockMinecartTrackAbstract.e(world, var3.up())) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH;
				}
			}

			if (var10 == BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST) {
				if (BlockMinecartTrackAbstract.e(world, var5.up())) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST;
				}

				if (BlockMinecartTrackAbstract.e(world, var4.up())) {
					var10 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST;
				}
			}

			if (var10 == null) {
				var10 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
			}

			blockdata = blockdata.set(block.n(), var10);
			world.setTypeAndData(position, blockdata, 3);
		}

		private boolean d(BlockPosition var1) {
			MinecartTrackLogic var2 = this.b(var1);
			if (var2 == null) {
				return false;
			} else {
				var2.c();
				return var2.b(this);
			}
		}

		public MinecartTrackLogic a(boolean var1, boolean var2) {
			BlockPosition var3 = position.north();
			BlockPosition var4 = position.south();
			BlockPosition var5 = position.west();
			BlockPosition var6 = position.east();
			boolean var7 = this.d(var3);
			boolean var8 = this.d(var4);
			boolean var9 = this.d(var5);
			boolean var10 = this.d(var6);
			BlockMinecartTrackAbstract.EnumTrackPosition var11 = null;
			if ((var7 || var8) && !var9 && !var10) {
				var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
			}

			if ((var9 || var10) && !var7 && !var8) {
				var11 = BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST;
			}

			if (!f) {
				if (var8 && var10 && !var7 && !var9) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST;
				}

				if (var8 && var9 && !var7 && !var10) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST;
				}

				if (var7 && var9 && !var8 && !var10) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST;
				}

				if (var7 && var10 && !var8 && !var9) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST;
				}
			}

			if (var11 == null) {
				if (var7 || var8) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
				}

				if (var9 || var10) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST;
				}

				if (!f) {
					if (var1) {
						if (var8 && var10) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST;
						}

						if (var9 && var8) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST;
						}

						if (var10 && var7) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST;
						}

						if (var7 && var9) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST;
						}
					} else {
						if (var7 && var9) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_WEST;
						}

						if (var10 && var7) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_EAST;
						}

						if (var9 && var8) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_WEST;
						}

						if (var8 && var10) {
							var11 = BlockMinecartTrackAbstract.EnumTrackPosition.SOUTH_EAST;
						}
					}
				}
			}

			if (var11 == BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH) {
				if (BlockMinecartTrackAbstract.e(world, var3.up())) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH;
				}

				if (BlockMinecartTrackAbstract.e(world, var4.up())) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH;
				}
			}

			if (var11 == BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST) {
				if (BlockMinecartTrackAbstract.e(world, var6.up())) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST;
				}

				if (BlockMinecartTrackAbstract.e(world, var5.up())) {
					var11 = BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST;
				}
			}

			if (var11 == null) {
				var11 = BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
			}

			this.a(var11);
			blockdata = blockdata.set(block.n(), var11);
			if (var2 || (world.getType(position) != blockdata)) {
				world.setTypeAndData(position, blockdata, 3);

				for (int var12 = 0; var12 < g.size(); ++var12) {
					BlockMinecartTrackAbstract.MinecartTrackLogic var13 = this.b(g.get(var12));
					if (var13 != null) {
						var13.c();
						if (var13.b(this)) {
							var13.c(this);
						}
					}
				}
			}

			return this;
		}

		public IBlockData getBlockData() {
			return blockdata;
		}

	}
}
