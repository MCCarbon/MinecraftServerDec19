package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BlockStairs extends Block {

	public static final BlockStateDirection a;
	public static final BlockStateEnum<EnumHalf> b;
	public static final BlockStateEnum<EnumStairShape> N;
	private static final int[][] O;
	private final Block P;
	private final IBlockData Q;
	private boolean R;
	private int S;

	protected BlockStairs(IBlockData var1) {
		super(var1.getBlock().material);
		setBlockData(blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, BlockStairs.EnumHalf.BOTTOM).set(N, BlockStairs.EnumStairShape.STRAIGHT));
		P = var1.getBlock();
		Q = var1;
		setStrength(P.strength);
		setExplosionResist(P.explosionResist / 3.0F);
		setStepSound(P.stepSound);
		setLightOpacity(255);
		setCreativeTab(CreativeTab.BUILDING_BLOCKS);
	}

	@Override
	public void updateShape(IBlockAccess var1, BlockPosition var2) {
		if (R) {
			setSizes(0.5F * (S % 2), 0.5F * ((S / 4) % 2), 0.5F * ((S / 2) % 2), 0.5F + (0.5F * (S % 2)), 0.5F + (0.5F * ((S / 4) % 2)), 0.5F + (0.5F * ((S / 2) % 2)));
		} else {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	public void e(IBlockAccess var1, BlockPosition var2) {
		if (var1.getType(var2).get(b) == BlockStairs.EnumHalf.TOP) {
			setSizes(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

	}

	public static boolean c(Block var0) {
		return var0 instanceof BlockStairs;
	}

	public static boolean a(IBlockAccess var0, BlockPosition var1, IBlockData var2) {
		IBlockData var3 = var0.getType(var1);
		Block var4 = var3.getBlock();
		return c(var4) && (var3.get(b) == var2.get(b)) && (var3.get(a) == var2.get(a));
	}

	public int f(IBlockAccess var1, BlockPosition var2) {
		IBlockData var3 = var1.getType(var2);
		EnumDirection var4 = var3.get(a);
		BlockStairs.EnumHalf var5 = var3.get(b);
		boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
		IBlockData var7;
		Block var8;
		EnumDirection var9;
		if (var4 == EnumDirection.EAST) {
			var7 = var1.getType(var2.east());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.NORTH) && !a(var1, var2.south(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == EnumDirection.SOUTH) && !a(var1, var2.north(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		} else if (var4 == EnumDirection.WEST) {
			var7 = var1.getType(var2.west());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.NORTH) && !a(var1, var2.south(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == EnumDirection.SOUTH) && !a(var1, var2.north(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == EnumDirection.SOUTH) {
			var7 = var1.getType(var2.south());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.WEST) && !a(var1, var2.east(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == EnumDirection.EAST) && !a(var1, var2.west(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == EnumDirection.NORTH) {
			var7 = var1.getType(var2.north());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.WEST) && !a(var1, var2.east(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == EnumDirection.EAST) && !a(var1, var2.west(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		}

		return 0;
	}

	public int g(IBlockAccess var1, BlockPosition var2) {
		IBlockData var3 = var1.getType(var2);
		EnumDirection var4 = var3.get(a);
		BlockStairs.EnumHalf var5 = var3.get(b);
		boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
		IBlockData var7;
		Block var8;
		EnumDirection var9;
		if (var4 == EnumDirection.EAST) {
			var7 = var1.getType(var2.west());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.NORTH) && !a(var1, var2.north(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == EnumDirection.SOUTH) && !a(var1, var2.south(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		} else if (var4 == EnumDirection.WEST) {
			var7 = var1.getType(var2.east());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.NORTH) && !a(var1, var2.north(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == EnumDirection.SOUTH) && !a(var1, var2.south(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == EnumDirection.SOUTH) {
			var7 = var1.getType(var2.north());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.WEST) && !a(var1, var2.west(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == EnumDirection.EAST) && !a(var1, var2.east(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == EnumDirection.NORTH) {
			var7 = var1.getType(var2.south());
			var8 = var7.getBlock();
			if (c(var8) && (var5 == var7.get(b))) {
				var9 = var7.get(a);
				if ((var9 == EnumDirection.WEST) && !a(var1, var2.west(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == EnumDirection.EAST) && !a(var1, var2.east(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		}

		return 0;
	}

	public boolean h(IBlockAccess var1, BlockPosition var2) {
		IBlockData var3 = var1.getType(var2);
		EnumDirection var4 = var3.get(a);
		BlockStairs.EnumHalf var5 = var3.get(b);
		boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
		float var7 = 0.5F;
		float var8 = 1.0F;
		if (var6) {
			var7 = 0.0F;
			var8 = 0.5F;
		}

		float var9 = 0.0F;
		float var10 = 1.0F;
		float var11 = 0.0F;
		float var12 = 0.5F;
		boolean var13 = true;
		IBlockData var14;
		Block var15;
		EnumDirection var16;
		if (var4 == EnumDirection.EAST) {
			var9 = 0.5F;
			var12 = 1.0F;
			var14 = var1.getType(var2.east());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var16 = var14.get(a);
				if ((var16 == EnumDirection.NORTH) && !a(var1, var2.south(), var3)) {
					var12 = 0.5F;
					var13 = false;
				} else if ((var16 == EnumDirection.SOUTH) && !a(var1, var2.north(), var3)) {
					var11 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == EnumDirection.WEST) {
			var10 = 0.5F;
			var12 = 1.0F;
			var14 = var1.getType(var2.west());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var16 = var14.get(a);
				if ((var16 == EnumDirection.NORTH) && !a(var1, var2.south(), var3)) {
					var12 = 0.5F;
					var13 = false;
				} else if ((var16 == EnumDirection.SOUTH) && !a(var1, var2.north(), var3)) {
					var11 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == EnumDirection.SOUTH) {
			var11 = 0.5F;
			var12 = 1.0F;
			var14 = var1.getType(var2.south());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var16 = var14.get(a);
				if ((var16 == EnumDirection.WEST) && !a(var1, var2.east(), var3)) {
					var10 = 0.5F;
					var13 = false;
				} else if ((var16 == EnumDirection.EAST) && !a(var1, var2.west(), var3)) {
					var9 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == EnumDirection.NORTH) {
			var14 = var1.getType(var2.north());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var16 = var14.get(a);
				if ((var16 == EnumDirection.WEST) && !a(var1, var2.east(), var3)) {
					var10 = 0.5F;
					var13 = false;
				} else if ((var16 == EnumDirection.EAST) && !a(var1, var2.west(), var3)) {
					var9 = 0.5F;
					var13 = false;
				}
			}
		}

		setSizes(var9, var7, var11, var10, var8, var12);
		return var13;
	}

	public boolean i(IBlockAccess var1, BlockPosition var2) {
		IBlockData var3 = var1.getType(var2);
		EnumDirection var4 = var3.get(a);
		BlockStairs.EnumHalf var5 = var3.get(b);
		boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
		float var7 = 0.5F;
		float var8 = 1.0F;
		if (var6) {
			var7 = 0.0F;
			var8 = 0.5F;
		}

		float var9 = 0.0F;
		float var10 = 0.5F;
		float var11 = 0.5F;
		float var12 = 1.0F;
		boolean var13 = false;
		IBlockData var14;
		Block var15;
		EnumDirection var16;
		if (var4 == EnumDirection.EAST) {
			var14 = var1.getType(var2.west());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var16 = var14.get(a);
				if ((var16 == EnumDirection.NORTH) && !a(var1, var2.north(), var3)) {
					var11 = 0.0F;
					var12 = 0.5F;
					var13 = true;
				} else if ((var16 == EnumDirection.SOUTH) && !a(var1, var2.south(), var3)) {
					var11 = 0.5F;
					var12 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == EnumDirection.WEST) {
			var14 = var1.getType(var2.east());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var9 = 0.5F;
				var10 = 1.0F;
				var16 = var14.get(a);
				if ((var16 == EnumDirection.NORTH) && !a(var1, var2.north(), var3)) {
					var11 = 0.0F;
					var12 = 0.5F;
					var13 = true;
				} else if ((var16 == EnumDirection.SOUTH) && !a(var1, var2.south(), var3)) {
					var11 = 0.5F;
					var12 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == EnumDirection.SOUTH) {
			var14 = var1.getType(var2.north());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var11 = 0.0F;
				var12 = 0.5F;
				var16 = var14.get(a);
				if ((var16 == EnumDirection.WEST) && !a(var1, var2.west(), var3)) {
					var13 = true;
				} else if ((var16 == EnumDirection.EAST) && !a(var1, var2.east(), var3)) {
					var9 = 0.5F;
					var10 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == EnumDirection.NORTH) {
			var14 = var1.getType(var2.south());
			var15 = var14.getBlock();
			if (c(var15) && (var5 == var14.get(b))) {
				var16 = var14.get(a);
				if ((var16 == EnumDirection.WEST) && !a(var1, var2.west(), var3)) {
					var13 = true;
				} else if ((var16 == EnumDirection.EAST) && !a(var1, var2.east(), var3)) {
					var9 = 0.5F;
					var10 = 1.0F;
					var13 = true;
				}
			}
		}

		if (var13) {
			setSizes(var9, var7, var11, var10, var8, var12);
		}

		return var13;
	}

	@Override
	public void addBBIfInsideInputBB(World var1, BlockPosition var2, IBlockData var3, AxisAlignedBB var4, List<AxisAlignedBB> var5, Entity var6) {
		e(var1, var2);
		super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
		boolean var7 = h(var1, var2);
		super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
		if (var7 && i(var1, var2)) {
			super.addBBIfInsideInputBB(var1, var2, var3, var4, var5, var6);
		}

		setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void attack(World var1, BlockPosition var2, EntityHuman var3) {
		P.attack(var1, var2, var3);
	}

	@Override
	public void postBreak(World var1, BlockPosition var2, IBlockData var3) {
		P.postBreak(var1, var2, var3);
	}

	@Override
	public float getResistance(Entity var1) {
		return P.getResistance(var1);
	}

	@Override
	public int tickInterval(World var1) {
		return P.tickInterval(var1);
	}

	@Override
	public Vec3D modifyVelocity(World var1, BlockPosition var2, Entity var3, Vec3D var4) {
		return P.modifyVelocity(var1, var2, var3, var4);
	}

	@Override
	public boolean isCollidable() {
		return P.isCollidable();
	}

	@Override
	public boolean canCollide(IBlockData var1, boolean var2) {
		return P.canCollide(var1, var2);
	}

	@Override
	public boolean canPlace(World var1, BlockPosition var2) {
		return P.canPlace(var1, var2);
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		doPhysics(var1, var2, Q, Blocks.AIR);
		P.onPlace(var1, var2, Q);
	}

	@Override
	public void remove(World var1, BlockPosition var2, IBlockData var3) {
		P.remove(var1, var2, Q);
	}

	@Override
	public void onCollide(World var1, BlockPosition var2, Entity var3) {
		P.onCollide(var1, var2, var3);
	}

	@Override
	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		P.tick(var1, var2, var3, var4);
	}

	@Override
	public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
		return P.interact(var1, var2, Q, var4, var5, var6, EnumDirection.DOWN, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void wasExploded(World var1, BlockPosition var2, Explosion var3) {
		P.wasExploded(var1, var2, var3);
	}

	@Override
	public MaterialMapColor getMapColor(IBlockData var1) {
		return P.getMapColor(Q);
	}

	@Override
	public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		IBlockData var9 = super.getPlacedState(var1, var2, var3, var4, var5, var6, var7, var8);
		var9 = var9.set(a, var8.aR()).set(N, BlockStairs.EnumStairShape.STRAIGHT);
		return (var3 != EnumDirection.DOWN) && ((var3 == EnumDirection.UP) || (var5 <= 0.5D)) ? var9.set(b, BlockStairs.EnumHalf.BOTTOM) : var9.set(b, BlockStairs.EnumHalf.TOP);
	}

	@Override
	public MovingObjectPosition rayTraceCollision(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
		MovingObjectPosition[] var5 = new MovingObjectPosition[8];
		IBlockData var6 = var1.getType(var2);
		int var7 = var6.get(a).getHorizontalId();
		boolean var8 = var6.get(b) == BlockStairs.EnumHalf.TOP;
		int[] var9 = O[var7 + (var8 ? 4 : 0)];
		R = true;

		for (int var10 = 0; var10 < 8; ++var10) {
			S = var10;
			if (Arrays.binarySearch(var9, var10) < 0) {
				var5[var10] = super.rayTraceCollision(var1, var2, var3, var4);
			}
		}

		int[] var19 = var9;
		int var11 = var9.length;

		for (int var12 = 0; var12 < var11; ++var12) {
			int var13 = var19[var12];
			var5[var13] = null;
		}

		MovingObjectPosition var20 = null;
		double var21 = 0.0D;
		MovingObjectPosition[] var22 = var5;
		int var14 = var5.length;

		for (int var15 = 0; var15 < var14; ++var15) {
			MovingObjectPosition var16 = var22[var15];
			if (var16 != null) {
				double var17 = var16.pos.distanceSquared(var4);
				if (var17 > var21) {
					var20 = var16;
					var21 = var17;
				}
			}
		}

		return var20;
	}

	@Override
	public IBlockData fromLegacyData(int var1) {
		IBlockData var2 = getBlockData().set(b, (var1 & 4) > 0 ? BlockStairs.EnumHalf.TOP : BlockStairs.EnumHalf.BOTTOM);
		var2 = var2.set(a, EnumDirection.getById(5 - (var1 & 3)));
		return var2;
	}

	@Override
	public int toLegacyData(IBlockData var1) {
		int var2 = 0;
		if (var1.get(b) == BlockStairs.EnumHalf.TOP) {
			var2 |= 4;
		}

		var2 |= 5 - var1.get(a).getId();
		return var2;
	}

	@Override
	public IBlockData updateState(IBlockData var1, IBlockAccess var2, BlockPosition var3) {
		if (h(var2, var3)) {
			switch (this.g(var2, var3)) {
				case 0:
					var1 = var1.set(N, BlockStairs.EnumStairShape.STRAIGHT);
					break;
				case 1:
					var1 = var1.set(N, BlockStairs.EnumStairShape.INNER_RIGHT);
					break;
				case 2:
					var1 = var1.set(N, BlockStairs.EnumStairShape.INNER_LEFT);
			}
		} else {
			switch (f(var2, var3)) {
				case 0:
					var1 = var1.set(N, BlockStairs.EnumStairShape.STRAIGHT);
					break;
				case 1:
					var1 = var1.set(N, BlockStairs.EnumStairShape.OUTER_RIGHT);
					break;
				case 2:
					var1 = var1.set(N, BlockStairs.EnumStairShape.OUTER_LEFT);
			}
		}

		return var1;
	}

	@Override
	public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
		return var1.getBlock() != this ? var1 : var1.set(a, var2.a(var1.get(a)));
	}

	@Override
	public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
		if (var1.getBlock() != this) {
			return var1;
		} else {
			EnumDirection var3 = var1.get(a);
			BlockStairs.EnumStairShape var4 = var1.get(N);
			switch (BlockStairs.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					if (var3.getAxis() == EnumDirection.EnumAxis.Z) {
						switch (BlockStairs.SyntheticClass_1.a[var4.ordinal()]) {
							case 1:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.INNER_RIGHT);
							case 2:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.INNER_LEFT);
							case 3:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.OUTER_RIGHT);
							case 4:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.OUTER_LEFT);
							default:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180);
						}
					}
					break;
				case 2:
					if (var3.getAxis() == EnumDirection.EnumAxis.X) {
						switch (BlockStairs.SyntheticClass_1.a[var4.ordinal()]) {
							case 1:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.INNER_LEFT);
							case 2:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.INNER_RIGHT);
							case 3:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.OUTER_RIGHT);
							case 4:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180).set(N, BlockStairs.EnumStairShape.OUTER_LEFT);
							case 5:
								return this.a(var1, Block.EnumRotation.CLOCKWISE_180);
						}
					}
			}

			return super.a(var1, var2);
		}
	}

	@Override
	protected BlockStateList getStateList() {
		return new BlockStateList(this, new IBlockState[] { a, b, N });
	}

	static {
		a = BlockDirectional.FACING;
		b = BlockStateEnum.of("half", BlockStairs.EnumHalf.class);
		N = BlockStateEnum.of("shape", BlockStairs.EnumStairShape.class);
		O = new int[][] { { 4, 5 }, { 5, 7 }, { 6, 7 }, { 4, 6 }, { 0, 1 }, { 1, 3 }, { 2, 3 }, { 0, 2 } };
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
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
			} catch (NoSuchFieldError var6) {
				;
			}

			a = new int[BlockStairs.EnumStairShape.values().length];

			try {
				a[BlockStairs.EnumStairShape.INNER_LEFT.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[BlockStairs.EnumStairShape.INNER_RIGHT.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[BlockStairs.EnumStairShape.OUTER_LEFT.ordinal()] = 3;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[BlockStairs.EnumStairShape.OUTER_RIGHT.ordinal()] = 4;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[BlockStairs.EnumStairShape.STRAIGHT.ordinal()] = 5;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum EnumStairShape implements INamable {
		STRAIGHT("straight"),
		INNER_LEFT("inner_left"),
		INNER_RIGHT("inner_right"),
		OUTER_LEFT("outer_left"),
		OUTER_RIGHT("outer_right");

		private final String name;

		private EnumStairShape(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public String getName() {
			return name;
		}
	}

	public static enum EnumHalf implements INamable {
		TOP("top"), BOTTOM("bottom");

		private final String name;

		private EnumHalf(String var3) {
			name = var3;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public String getName() {
			return name;
		}
	}

}
