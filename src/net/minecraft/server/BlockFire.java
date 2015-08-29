package net.minecraft.server;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;

public class BlockFire extends Block {
	public static final class_aqb a = class_aqb.a("age", 0, 15);
	public static final class_apy b = class_apy.a("north");
	public static final class_apy N = class_apy.a("east");
	public static final class_apy O = class_apy.a("south");
	public static final class_apy P = class_apy.a("west");
	public static final class_apy Q = class_apy.a("up");
	private final Map R = Maps.newIdentityHashMap();
	private final Map S = Maps.newIdentityHashMap();

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return !class_ago.a(var2, var3.b()) && !Blocks.FIRE.e(var2, var3.b()) ? var1.a(b, Boolean.valueOf(this.e(var2, var3.c()))).a(N, Boolean.valueOf(this.e(var2, var3.f()))).a(O, Boolean.valueOf(this.e(var2, var3.d()))).a(P, Boolean.valueOf(this.e(var2, var3.e()))).a(Q, Boolean.valueOf(this.e(var2, var3.a()))) : getBlockData();
	}

	protected BlockFire() {
		super(class_avq.o);
		this.j(M.b().a(a, Integer.valueOf(0)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)));
		this.a(true);
	}

	public static void l() {
		Blocks.FIRE.a(Blocks.PLANKS, 5, 20);
		Blocks.FIRE.a(Blocks.DOUBLE_WOODEN_SLAB, 5, 20);
		Blocks.FIRE.a(Blocks.WOODEN_SLAB, 5, 20);
		Blocks.FIRE.a(Blocks.FENCE_GATE, 5, 20);
		Blocks.FIRE.a(Blocks.SPRUCE_FENCE_GATE, 5, 20);
		Blocks.FIRE.a(Blocks.BIRCH_FENCE_GATE, 5, 20);
		Blocks.FIRE.a(Blocks.JUNGLE_FENCE_GATE, 5, 20);
		Blocks.FIRE.a(Blocks.DARK_OAK_FENCE_GATE, 5, 20);
		Blocks.FIRE.a(Blocks.ACACIA_FENCE_GATE, 5, 20);
		Blocks.FIRE.a(Blocks.FENCE, 5, 20);
		Blocks.FIRE.a(Blocks.SPRUCE_FENCE, 5, 20);
		Blocks.FIRE.a(Blocks.BIRCH_FENCE, 5, 20);
		Blocks.FIRE.a(Blocks.JUNGLE_FENCE, 5, 20);
		Blocks.FIRE.a(Blocks.DARK_OAK_FENCE, 5, 20);
		Blocks.FIRE.a(Blocks.ACACIA_FENCE, 5, 20);
		Blocks.FIRE.a(Blocks.OAK_STAIRS, 5, 20);
		Blocks.FIRE.a(Blocks.BIRCH_STAIRS, 5, 20);
		Blocks.FIRE.a(Blocks.SPRUCE_STAIRS, 5, 20);
		Blocks.FIRE.a(Blocks.JUNGLE_STAIRS, 5, 20);
		Blocks.FIRE.a(Blocks.LOG, 5, 5);
		Blocks.FIRE.a(Blocks.LOG2, 5, 5);
		Blocks.FIRE.a(Blocks.LEAVES, 30, 60);
		Blocks.FIRE.a(Blocks.LEAVES2, 30, 60);
		Blocks.FIRE.a(Blocks.BOOKSHELF, 30, 20);
		Blocks.FIRE.a(Blocks.TNT, 15, 100);
		Blocks.FIRE.a(Blocks.TALLGRASS, 60, 100);
		Blocks.FIRE.a(Blocks.DOUBLE_PLANT, 60, 100);
		Blocks.FIRE.a(Blocks.YELLOW_FLOWER, 60, 100);
		Blocks.FIRE.a(Blocks.RED_FLOWER, 60, 100);
		Blocks.FIRE.a(Blocks.DEADBUSH, 60, 100);
		Blocks.FIRE.a(Blocks.WOOL, 30, 60);
		Blocks.FIRE.a(Blocks.VINE, 15, 100);
		Blocks.FIRE.a(Blocks.COAL_BLOCK, 5, 5);
		Blocks.FIRE.a(Blocks.HAY_BLOCK, 60, 20);
		Blocks.FIRE.a(Blocks.CARPET, 60, 20);
	}

	public void a(Block var1, int var2, int var3) {
		R.put(var1, Integer.valueOf(var2));
		S.put(var1, Integer.valueOf(var3));
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public int a(class_ago var1) {
		return 30;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (var1.S().b("doFireTick")) {
			if (!this.c(var1, var2)) {
				var1.g(var2);
			}

			Block var5 = var1.p(var2.b()).c();
			boolean var6 = var5 == Blocks.NETHERRACK;
			if ((var1.t instanceof class_arh) && (var5 == Blocks.BEDROCK)) {
				var6 = true;
			}

			if (!var6 && var1.U() && this.d(var1, var2)) {
				var1.g(var2);
			} else {
				int var7 = ((Integer) var3.b(a)).intValue();
				if (var7 < 15) {
					var3 = var3.a(a, Integer.valueOf(var7 + (var4.nextInt(3) / 2)));
					var1.a(var2, var3, 4);
				}

				var1.a(var2, this, this.a(var1) + var4.nextInt(10));
				if (!var6) {
					if (!this.e(var1, var2)) {
						if (!class_ago.a(var1, var2.b()) || (var7 > 3)) {
							var1.g(var2);
						}

						return;
					}

					if (!this.e((class_ags) var1, var2.b()) && (var7 == 15) && (var4.nextInt(4) == 0)) {
						var1.g(var2);
						return;
					}
				}

				boolean var8 = var1.D(var2);
				byte var9 = 0;
				if (var8) {
					var9 = -50;
				}

				this.a(var1, var2.f(), 300 + var9, var4, var7);
				this.a(var1, var2.e(), 300 + var9, var4, var7);
				this.a(var1, var2.b(), 250 + var9, var4, var7);
				this.a(var1, var2.a(), 250 + var9, var4, var7);
				this.a(var1, var2.c(), 300 + var9, var4, var7);
				this.a(var1, var2.d(), 300 + var9, var4, var7);

				for (int var10 = -1; var10 <= 1; ++var10) {
					for (int var11 = -1; var11 <= 1; ++var11) {
						for (int var12 = -1; var12 <= 4; ++var12) {
							if ((var10 != 0) || (var12 != 0) || (var11 != 0)) {
								int var13 = 100;
								if (var12 > 1) {
									var13 += (var12 - 1) * 100;
								}

								class_cj var14 = var2.a(var10, var12, var11);
								int var15 = this.k(var1, var14);
								if (var15 > 0) {
									int var16 = (var15 + 40 + (var1.ac().a() * 7)) / (var7 + 30);
									if (var8) {
										var16 /= 2;
									}

									if ((var16 > 0) && (var4.nextInt(var13) <= var16) && (!var1.U() || !this.d(var1, var14))) {
										int var17 = var7 + (var4.nextInt(5) / 4);
										if (var17 > 15) {
											var17 = 15;
										}

										var1.a(var14, var3.a(a, Integer.valueOf(var17)), 3);
									}
								}
							}
						}
					}
				}

			}
		}
	}

	protected boolean d(class_ago var1, class_cj var2) {
		return var1.C(var2) || var1.C(var2.e()) || var1.C(var2.f()) || var1.C(var2.c()) || var1.C(var2.d());
	}

	@Override
	public boolean P() {
		return false;
	}

	private int c(Block var1) {
		Integer var2 = (Integer) S.get(var1);
		return var2 == null ? 0 : var2.intValue();
	}

	private int d(Block var1) {
		Integer var2 = (Integer) R.get(var1);
		return var2 == null ? 0 : var2.intValue();
	}

	private void a(class_ago var1, class_cj var2, int var3, Random var4, int var5) {
		int var6 = this.c(var1.p(var2).c());
		if (var4.nextInt(var3) < var6) {
			class_apn var7 = var1.p(var2);
			if ((var4.nextInt(var5 + 10) < 5) && !var1.C(var2)) {
				int var8 = var5 + (var4.nextInt(5) / 4);
				if (var8 > 15) {
					var8 = 15;
				}

				var1.a(var2, getBlockData().a(a, Integer.valueOf(var8)), 3);
			} else {
				var1.g(var2);
			}

			if (var7.c() == Blocks.TNT) {
				Blocks.TNT.e(var1, var2, var7.a(class_anq.a, Boolean.valueOf(true)));
			}
		}

	}

	private boolean e(class_ago var1, class_cj var2) {
		class_cq[] var3 = class_cq.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_cq var6 = var3[var5];
			if (this.e((class_ags) var1, var2.a(var6))) {
				return true;
			}
		}

		return false;
	}

	private int k(class_ago var1, class_cj var2) {
		if (!var1.d(var2)) {
			return 0;
		} else {
			int var3 = 0;
			class_cq[] var4 = class_cq.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				class_cq var7 = var4[var6];
				var3 = Math.max(this.d(var1.p(var2.a(var7)).c()), var3);
			}

			return var3;
		}
	}

	@Override
	public boolean C() {
		return false;
	}

	public boolean e(class_ags var1, class_cj var2) {
		return this.d(var1.p(var2).c()) > 0;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return class_ago.a(var1, var2.b()) || this.e(var1, var2);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!class_ago.a(var1, var2.b()) && !this.e(var1, var2)) {
			var1.g(var2);
		}

	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if ((var1.t.p().a() > 0) || !Blocks.PORTAL.d(var1, var2)) {
			if (!class_ago.a(var1, var2.b()) && !this.e(var1, var2)) {
				var1.g(var2);
			} else {
				var1.a(var2, this, this.a(var1) + var1.s.nextInt(10));
			}
		}
	}

	@Override
	public class_avr g(class_apn var1) {
		return class_avr.f;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N, O, P, Q });
	}
}
