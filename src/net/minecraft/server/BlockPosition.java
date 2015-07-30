package net.minecraft.server;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import net.minecraft.server.Vec3D;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pr;

public class BlockPosition extends BaseBlockPosition {

	public static final BlockPosition ZERO = new BlockPosition(0, 0, 0);

	private static final int c = 1 + MathHelper.calculateLogBaseTwo(MathHelper.roundUpToPowerOfTwo(30000000));
	private static final int d = c;
	private static final int e = 64 - c - d;
	private static final int Y_SHIFT = 0 + d;
	private static final int X_SHIFT = Y_SHIFT + e;
	private static final long X_MASK = (1L << c) - 1L;
	private static final long Y_MASK = (1L << e) - 1L;
	private static final long Z_MASK = (1L << d) - 1L;

	public static BlockPosition fromLong(long l) {
		int x = (int) (l << 64 - X_SHIFT - c >> 64 - c);
		int y = (int) (l << 64 - Y_SHIFT - e >> 64 - e);
		int z = (int) (l << 64 - d >> 64 - d);
		return new BlockPosition(x, y, z);
	}

	public BlockPosition(int x, int y, int z) {
		super(x, y, z);
	}

	public BlockPosition(double x, double y, double z) {
		super(x, y, z);
	}

	public BlockPosition(class_pr var1) {
		this(var1.s, var1.t, var1.u);
	}

	public BlockPosition(Vec3D vec) {
		this(vec.x, vec.y, vec.z);
	}

	public BlockPosition(BaseBlockPosition var1) {
		this(var1.getX(), var1.getY(), var1.getZ());
	}

	public BlockPosition add(double x, double y, double z) {
		return x == 0.0D && y == 0.0D && z == 0.0D ? this : new BlockPosition((double) this.getX() + x, (double) this.getY() + y, (double) this.getZ() + z);
	}

	public BlockPosition add(int x, int y, int z) {
		return x == 0 && y == 0 && z == 0 ? this : new BlockPosition(this.getX() + x, this.getY() + y, this.getZ() + z);
	}

	public BlockPosition add(BaseBlockPosition var1) {
		return var1.getX() == 0 && var1.getY() == 0 && var1.getZ() == 0 ? this : new BlockPosition(this.getX() + var1.getX(), this.getY() + var1.getY(), this.getZ() + var1.getZ());
	}

	public BlockPosition substract(BaseBlockPosition var1) {
		return var1.getX() == 0 && var1.getY() == 0 && var1.getZ() == 0 ? this : new BlockPosition(this.getX() - var1.getX(), this.getY() - var1.getY(), this.getZ() - var1.getZ());
	}

	public BlockPosition shiftUp() {
		return this.shiftUp(1);
	}

	public BlockPosition shiftUp(int dist) {
		return this.shift(EnumDirection.UP, dist);
	}

	public BlockPosition shiftDown() {
		return this.shiftDown(1);
	}

	public BlockPosition shiftDown(int dist) {
		return this.shift(EnumDirection.DOWN, dist);
	}

	public BlockPosition shiftNorth() {
		return this.shiftNorth(1);
	}

	public BlockPosition shiftNorth(int dist) {
		return this.shift(EnumDirection.NORTH, dist);
	}

	public BlockPosition shiftSouth() {
		return this.shiftSouth(1);
	}

	public BlockPosition shiftSouth(int dist) {
		return this.shift(EnumDirection.SOUTH, dist);
	}

	public BlockPosition shiftWest() {
		return this.shiftWest(1);
	}

	public BlockPosition shiftWest(int dist) {
		return this.shift(EnumDirection.WEST, dist);
	}

	public BlockPosition shiftEast() {
		return this.shiftEast(1);
	}

	public BlockPosition shiftEast(int dist) {
		return this.shift(EnumDirection.EAST, dist);
	}

	public BlockPosition shift(EnumDirection direction) {
		return this.shift(direction, 1);
	}

	public BlockPosition shift(EnumDirection diection, int dist) {
		return dist == 0 ? this : new BlockPosition(this.getX() + diection.getAdjacentX() * dist, this.getY() + diection.getAdjacentY() * dist, this.getZ() + diection.getAdjacentZ() * dist);
	}

	public BlockPosition crossProduct(BaseBlockPosition var1) {
		return new BlockPosition(this.getY() * var1.getZ() - this.getZ() * var1.getY(), this.getZ() * var1.getX() - this.getX() * var1.getZ(), this.getX() * var1.getY() - this.getY() * var1.getX());
	}

	public long asLong() {
		return ((long) this.getX() & X_MASK) << X_SHIFT | ((long) this.getY() & Y_MASK) << Y_SHIFT | ((long) this.getZ() & Z_MASK);
	}

	public static Iterable<BlockPosition> allInCube(BlockPosition p1, BlockPosition p2) {
		final BlockPosition min = new BlockPosition(Math.min(p1.getX(), p2.getX()), Math.min(p1.getY(), p2.getY()), Math.min(p1.getZ(), p2.getZ()));
		final BlockPosition max = new BlockPosition(Math.max(p1.getX(), p2.getX()), Math.max(p1.getY(), p2.getY()), Math.max(p1.getZ(), p2.getZ()));
		return new Iterable<BlockPosition>() {
			public Iterator<BlockPosition> iterator() {
				return new AbstractIterator<BlockPosition>() {
					private BlockPosition current = null;

					protected BlockPosition computeNext() {
						if (this.current == null) {
							this.current = min;
							return this.current;
						} else if (this.current.equals(max)) {
							return this.endOfData();
						} else {
							int x = this.current.getX();
							int y = this.current.getY();
							int z = this.current.getZ();
							if (x < max.getX()) {
								++x;
							} else if (y < max.getY()) {
								x = min.getX();
								++y;
							} else if (z < max.getZ()) {
								x = min.getX();
								y = min.getY();
								++z;
							}

							this.current = new BlockPosition(x, y, z);
							return this.current;
						}
					}
				};
			}
		};
	}

	public static Iterable<MutableBlockPosition> allInCubeM(BlockPosition var0, BlockPosition var1) {
		final BlockPosition min = new BlockPosition(Math.min(var0.getX(), var1.getX()), Math.min(var0.getY(), var1.getY()), Math.min(var0.getZ(), var1.getZ()));
		final BlockPosition max = new BlockPosition(Math.max(var0.getX(), var1.getX()), Math.max(var0.getY(), var1.getY()), Math.max(var0.getZ(), var1.getZ()));
		return new Iterable<MutableBlockPosition>() {
			public Iterator<MutableBlockPosition> iterator() {
				return new AbstractIterator<MutableBlockPosition>() {
					private MutableBlockPosition position = null;

					protected MutableBlockPosition computeNext() {
						if (this.position == null) {
							this.position = new MutableBlockPosition(min.getX(), min.getY(), min.getZ());
							return this.position;
						} else if (this.position.equals(max)) {
							return this.endOfData();
						} else {
							int x = this.position.getX();
							int y = this.position.getY();
							int z = this.position.getZ();
							if (x < max.getX()) {
								++x;
							} else if (y < max.getY()) {
								x = min.getX();
								++y;
							} else if (z < max.getZ()) {
								x = min.getX();
								y = min.getY();
								++z;
							}

							this.position.x = x;
							this.position.y = y;
							this.position.z = z;
							return this.position;
						}
					}

				};
			}
		};
	}

	public static final class MutableBlockPosition extends BlockPosition {

		private int x;
		private int y;
		private int z;

		public MutableBlockPosition() {
			this(0, 0, 0);
		}

		public MutableBlockPosition(int x, int y, int z) {
			super(0, 0, 0);
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public int getZ() {
			return this.z;
		}

		public MutableBlockPosition setPosition(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			return this;
		}

	}

}
