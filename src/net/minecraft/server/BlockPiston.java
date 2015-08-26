package net.minecraft.server;

import java.util.List;

public class BlockPiston extends class_ajk {
	public static final class_apy a = class_apy.a("extended");
	private final boolean N;

	public BlockPiston(boolean var1) {
		super(class_avq.H);
		this.j(M.b().a(b, class_cq.c).a(a, Boolean.valueOf(false)));
		N = var1;
		this.a(i);
		this.c(0.5F);
		this.a(class_abp.d);
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		var1.a(var2, var3.a(b, a(var1, var2, var4)), 2);
		if (!var1.D) {
			this.f(var1, var2, var3);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D) {
			this.f(var1, var2, var3);
		}

	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D && (var1.s(var2) == null)) {
			this.f(var1, var2, var3);
		}

	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(b, a(var1, var2, var8)).a(a, Boolean.valueOf(false));
	}

	private void f(class_ago var1, class_cj var2, class_apn var3) {
		class_cq var4 = (class_cq) var3.b(b);
		boolean var5 = this.a(var1, var2, var4);
		if (var5 && !((Boolean) var3.b(a)).booleanValue()) {
			if ((new class_apk(var1, var2, var4, true)).a()) {
				var1.c(var2, this, 0, var4.a());
			}
		} else if (!var5 && ((Boolean) var3.b(a)).booleanValue()) {
			var1.a(var2, var3.a(a, Boolean.valueOf(false)), 2);
			var1.c(var2, this, 1, var4.a());
		}

	}

	private boolean a(class_ago var1, class_cj var2, class_cq var3) {
		class_cq[] var4 = class_cq.values();
		int var5 = var4.length;

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			class_cq var7 = var4[var6];
			if ((var7 != var3) && var1.b(var2.a(var7), var7)) {
				return true;
			}
		}

		if (var1.b(var2, class_cq.a)) {
			return true;
		} else {
			class_cj var9 = var2.a();
			class_cq[] var10 = class_cq.values();
			var6 = var10.length;

			for (int var11 = 0; var11 < var6; ++var11) {
				class_cq var8 = var10[var11];
				if ((var8 != class_cq.a) && var1.b(var9.a(var8), var8)) {
					return true;
				}
			}

			return false;
		}
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, int var4, int var5) {
		class_cq var6 = (class_cq) var3.b(b);
		if (!var1.D) {
			boolean var7 = this.a(var1, var2, var6);
			if (var7 && (var4 == 1)) {
				var1.a(var2, var3.a(a, Boolean.valueOf(true)), 2);
				return false;
			}

			if (!var7 && (var4 == 0)) {
				return false;
			}
		}

		if (var4 == 0) {
			if (!this.a(var1, var2, var6, true)) {
				return false;
			}

			var1.a(var2, var3.a(a, Boolean.valueOf(true)), 2);
			var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "tile.piston.out", 0.5F, (var1.s.nextFloat() * 0.25F) + 0.6F);
		} else if (var4 == 1) {
			TileEntity var13 = var1.s(var2.a(var6));
			if (var13 instanceof class_api) {
				((class_api) var13).h();
			}

			var1.a(var2, Blocks.PISTON_EXTENSION.S().a(BlockPistonMoving.a, var6).a(BlockPistonMoving.b, N ? BlockPistonExtension.class_a_in_class_aph.b : BlockPistonExtension.class_a_in_class_aph.a), 3);
			var1.a(var2, BlockPistonMoving.a(this.a(var5), var6, false, true));
			if (N) {
				class_cj var8 = var2.a(var6.g() * 2, var6.h() * 2, var6.i() * 2);
				Block var9 = var1.p(var8).c();
				boolean var10 = false;
				if (var9 == Blocks.PISTON_EXTENSION) {
					TileEntity var11 = var1.s(var8);
					if (var11 instanceof class_api) {
						class_api var12 = (class_api) var11;
						if ((var12.e() == var6) && var12.d()) {
							var12.h();
							var10 = true;
						}
					}
				}

				if (!var10 && (var9.v() != class_avq.a) && a(var9, var1, var8, var6.d(), false) && ((var9.k() == 0) || (var9 == Blocks.PISTON) || (var9 == Blocks.STICKY_PISTON))) {
					this.a(var1, var2, var6, false);
				}
			} else {
				var1.g(var2.a(var6));
			}

			var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "tile.piston.in", 0.5F, (var1.s.nextFloat() * 0.15F) + 0.6F);
		}

		return true;
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	private void d(class_apn var1) {
		if (((Boolean) var1.b(a)).booleanValue()) {
			float var2 = 0.25F;
			class_cq var3 = (class_cq) var1.b(b);
			if (var3 != null) {
				switch (BlockPiston.SyntheticClass_1.a[var3.ordinal()]) {
					case 1:
						this.a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
						break;
					case 2:
						this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
						break;
					case 3:
						this.a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
						break;
					case 4:
						this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
						break;
					case 5:
						this.a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
						break;
					case 6:
						this.a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
				}
			}
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	@Override
	public void j() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, Entity var6) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		this.d(var3);
		return super.a(var1, var2, var3);
	}

	@Override
	public boolean d() {
		return false;
	}

	public static class_cq b(int var0) {
		int var1 = var0 & 7;
		return var1 > 5 ? null : class_cq.a(var1);
	}

	public static class_cq a(class_ago var0, class_cj var1, class_rg var2) {
		if ((MathHelper.e((float) var2.s - var1.n()) < 2.0F) && (MathHelper.e((float) var2.u - var1.p()) < 2.0F)) {
			double var3 = var2.t + var2.aY();
			if ((var3 - var1.o()) > 2.0D) {
				return class_cq.b;
			}

			if ((var1.o() - var3) > 0.0D) {
				return class_cq.a;
			}
		}

		return var2.aV().d();
	}

	public static boolean a(Block var0, class_ago var1, class_cj var2, class_cq var3, boolean var4) {
		if (var0 == Blocks.OBSIDIAN) {
			return false;
		} else if (!var1.ah().a(var2)) {
			return false;
		} else if ((var2.o() < 0) || ((var3 == class_cq.a) && (var2.o() == 0))) {
			return false;
		} else if ((var2.o() <= (var1.W() - 1)) && ((var3 != class_cq.b) || (var2.o() != (var1.W() - 1)))) {
			if ((var0 != Blocks.PISTON) && (var0 != Blocks.STICKY_PISTON)) {
				if (var0.f(var1, var2) == -1.0F) {
					return false;
				}

				if (var0.k() == 2) {
					return false;
				}

				if (var0.k() == 1) {
					if (!var4) {
						return false;
					}

					return true;
				}
			} else if (((Boolean) var1.p(var2).b(a)).booleanValue()) {
				return false;
			}

			return !(var0 instanceof class_ajy);
		} else {
			return false;
		}
	}

	private boolean a(class_ago var1, class_cj var2, class_cq var3, boolean var4) {
		if (!var4) {
			var1.g(var2.a(var3));
		}

		class_apk var5 = new class_apk(var1, var2, var3, var4);
		List var6 = var5.c();
		List var7 = var5.d();
		if (!var5.a()) {
			return false;
		} else {
			int var8 = var6.size() + var7.size();
			Block[] var9 = new Block[var8];
			class_cq var10 = var4 ? var3 : var3.d();

			int var11;
			class_cj var12;
			for (var11 = var7.size() - 1; var11 >= 0; --var11) {
				var12 = (class_cj) var7.get(var11);
				Block var13 = var1.p(var12).c();
				var13.b(var1, var12, var1.p(var12), 0);
				var1.g(var12);
				--var8;
				var9[var8] = var13;
			}

			class_apn var18;
			for (var11 = var6.size() - 1; var11 >= 0; --var11) {
				var12 = (class_cj) var6.get(var11);
				var18 = var1.p(var12);
				Block var14 = var18.c();
				var14.c(var18);
				var1.g(var12);
				var12 = var12.a(var10);
				var1.a(var12, Blocks.PISTON_EXTENSION.S().a(b, var3), 4);
				var1.a(var12, BlockPistonMoving.a(var18, var3, var4, false));
				--var8;
				var9[var8] = var14;
			}

			class_cj var16 = var2.a(var3);
			if (var4) {
				BlockPistonExtension.class_a_in_class_aph var17 = N ? BlockPistonExtension.class_a_in_class_aph.b : BlockPistonExtension.class_a_in_class_aph.a;
				var18 = Blocks.PISTON_HEAD.S().a(class_ajk.b, var3).a(BlockPistonExtension.a, var17);
				class_apn var20 = Blocks.PISTON_EXTENSION.S().a(BlockPistonMoving.a, var3).a(BlockPistonMoving.b, N ? BlockPistonExtension.class_a_in_class_aph.b : BlockPistonExtension.class_a_in_class_aph.a);
				var1.a(var16, var20, 4);
				var1.a(var16, BlockPistonMoving.a(var18, var3, true, false));
			}

			int var19;
			for (var19 = var7.size() - 1; var19 >= 0; --var19) {
				var1.d((class_cj) var7.get(var19), var9[var8++]);
			}

			for (var19 = var6.size() - 1; var19 >= 0; --var19) {
				var1.d((class_cj) var6.get(var19), var9[var8++]);
			}

			if (var4) {
				var1.d(var16, Blocks.PISTON_HEAD);
				var1.d(var2, this);
			}

			return true;
		}
	}

	@Override
	public class_apn a(int var1) {
		return S().a(b, b(var1)).a(a, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(b)).a();
		if (((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(b, var2.a((class_cq) var1.b(b)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(b)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, a });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
