package net.minecraft.server;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BlockFlowing extends BlockFluids {

	int a;

	protected BlockFlowing(Material var1) {
		super(var1);
	}

	private void f(World var1, BlockPosition var2, IBlockData var3) {
		var1.setTypeAndData(var2, b(material).getBlockData().set(LEVEL, var3.get(LEVEL)), 2);
	}

	@Override
	public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
		int var5 = var3.get(LEVEL).intValue();
		byte var6 = 1;
		if ((material == Material.LAVA) && !var1.worldProvider.l()) {
			var6 = 2;
		}

		int var7 = tickInterval(var1);
		int var15;
		if (var5 > 0) {
			int var8 = -100;
			a = 0;

			EnumDirection var10;
			for (Iterator<EnumDirection> var9 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator(); var9.hasNext(); var8 = this.a(var1, var2.shift(var10), var8)) {
				var10 = var9.next();
			}

			int var14 = var8 + var6;
			if ((var14 >= 8) || (var8 < 0)) {
				var14 = -1;
			}

			if (this.e((IBlockAccess) var1, var2.up()) >= 0) {
				var15 = this.e((IBlockAccess) var1, var2.up());
				if (var15 >= 8) {
					var14 = var15;
				} else {
					var14 = var15 + 8;
				}
			}

			if ((a >= 2) && (material == Material.WATER)) {
				IBlockData var16 = var1.getType(var2.down());
				if (var16.getBlock().getMaterial().isBuildable()) {
					var14 = 0;
				} else if ((var16.getBlock().getMaterial() == material) && (var16.get(LEVEL).intValue() == 0)) {
					var14 = 0;
				}
			}

			if ((material == Material.LAVA) && (var5 < 8) && (var14 < 8) && (var14 > var5) && (var4.nextInt(4) != 0)) {
				var7 *= 4;
			}

			if (var14 == var5) {
				this.f(var1, var2, var3);
			} else {
				var5 = var14;
				if (var14 < 0) {
					var1.setAir(var2);
				} else {
					var3 = var3.set(LEVEL, Integer.valueOf(var14));
					var1.setTypeAndData(var2, var3, 2);
					var1.a(var2, this, var7);
					var1.c(var2, this);
				}
			}
		} else {
			this.f(var1, var2, var3);
		}

		IBlockData var13 = var1.getType(var2.down());
		if (this.h(var1, var2.down(), var13)) {
			if ((material == Material.LAVA) && (var1.getType(var2.down()).getBlock().getMaterial() == Material.WATER)) {
				var1.setTypeUpdate(var2.down(), Blocks.STONE.getBlockData());
				this.e(var1, var2.down());
				return;
			}

			if (var5 >= 8) {
				this.a(var1, var2.down(), var13, var5);
			} else {
				this.a(var1, var2.down(), var13, var5 + 8);
			}
		} else if ((var5 >= 0) && ((var5 == 0) || this.g(var1, var2.down(), var13))) {
			Set<EnumDirection> var17 = this.f(var1, var2);
			var15 = var5 + var6;
			if (var5 >= 8) {
				var15 = 1;
			}

			if (var15 >= 8) {
				return;
			}

			Iterator<EnumDirection> var11 = var17.iterator();

			while (var11.hasNext()) {
				EnumDirection var12 = (EnumDirection) var11.next();
				this.a(var1, var2.shift(var12), var1.getType(var2.shift(var12)), var15);
			}
		}

	}

	private void a(World var1, BlockPosition var2, IBlockData var3, int var4) {
		if (this.h(var1, var2, var3)) {
			if (var3.getBlock() != Blocks.AIR) {
				if (material == Material.LAVA) {
					this.e(var1, var2);
				} else {
					var3.getBlock().dropNaturallyForSure(var1, var2, var3, 0);
				}
			}

			var1.setTypeAndData(var2, getBlockData().set(LEVEL, Integer.valueOf(var4)), 3);
		}

	}

	private int a(World var1, BlockPosition var2, int var3, EnumDirection var4) {
		int var5 = 1000;
		Iterator<?> var6 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

		while (true) {
			EnumDirection var7;
			BlockPosition var8;
			IBlockData var9;
			do {
				do {
					do {
						if (!var6.hasNext()) {
							return var5;
						}

						var7 = (EnumDirection) var6.next();
					} while (var7 == var4);

					var8 = var2.shift(var7);
					var9 = var1.getType(var8);
				} while (this.g(var1, var8, var9));
			} while ((var9.getBlock().getMaterial() == material) && (var9.get(LEVEL).intValue() <= 0));

			if (!this.g(var1, var8.down(), var9)) {
				return var3;
			}

			if (var3 < 4) {
				int var10 = this.a(var1, var8, var3 + 1, var7.getOpposite());
				if (var10 < var5) {
					var5 = var10;
				}
			}
		}
	}

	private Set<EnumDirection> f(World var1, BlockPosition var2) {
		int var3 = 1000;
		EnumSet<EnumDirection> var4 = EnumSet.noneOf(EnumDirection.class);
		Iterator<EnumDirection> var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

		while (true) {
			EnumDirection var6;
			BlockPosition var7;
			IBlockData var8;
			do {
				do {
					if (!var5.hasNext()) {
						return var4;
					}

					var6 = (EnumDirection) var5.next();
					var7 = var2.shift(var6);
					var8 = var1.getType(var7);
				} while (this.g(var1, var7, var8));
			} while ((var8.getBlock().getMaterial() == material) && (var8.get(LEVEL).intValue() <= 0));

			int var9;
			if (this.g(var1, var7.down(), var1.getType(var7.down()))) {
				var9 = this.a(var1, var7, 1, var6.getOpposite());
			} else {
				var9 = 0;
			}

			if (var9 < var3) {
				var4.clear();
			}

			if (var9 <= var3) {
				var4.add(var6);
				var3 = var9;
			}
		}
	}

	private boolean g(World var1, BlockPosition var2, IBlockData var3) {
		Block var4 = var1.getType(var2).getBlock();
		return !(var4 instanceof class_ahl) && (var4 != Blocks.STANDING_SIGN) && (var4 != Blocks.LADDER) && (var4 != Blocks.REEDS) ? (var4.material == Material.PORTAL ? true : var4.material.isSolid()) : true;
	}

	protected int a(World var1, BlockPosition var2, int var3) {
		int var4 = this.e((IBlockAccess) var1, var2);
		if (var4 < 0) {
			return var3;
		} else {
			if (var4 == 0) {
				++a;
			}

			if (var4 >= 8) {
				var4 = 0;
			}

			return (var3 >= 0) && (var4 >= var3) ? var3 : var4;
		}
	}

	private boolean h(World var1, BlockPosition var2, IBlockData var3) {
		Material var4 = var3.getBlock().getMaterial();
		return (var4 != material) && (var4 != Material.LAVA) && !this.g(var1, var2, var3);
	}

	@Override
	public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
		if (!this.e(var1, var2, var3)) {
			var1.a(var2, this, tickInterval(var1));
		}
	}

}
