package net.minecraft.server;

import java.util.Random;

import com.google.common.cache.LoadingCache;

public class BlockPortal extends class_aks {
	public static final class_aqa a;

	public BlockPortal() {
		super(class_avq.E, false);
		this.j(M.b().a(a, class_cq.class_a_in_class_cq.a));
		this.a(true);
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		super.b(var1, var2, var3, var4);
		if (var1.t.d() && var1.S().b("doMobSpawning") && (var4.nextInt(2000) < var1.ac().a())) {
			int var5 = var2.o();

			class_cj var6;
			for (var6 = var2; !class_ago.a(var1, var6) && (var6.o() > 0); var6 = var6.b()) {
				;
			}

			if ((var5 > 0) && !var1.p(var6.a()).c().x()) {
				Entity var7 = class_ads.a(var1, EntityTypes.a(EntityPigZombie.class), var6.n() + 0.5D, var6.o() + 1.1D, var6.p() + 0.5D);
				if (var7 != null) {
					var7.aj = var7.at();
				}
			}
		}

	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_cq.class_a_in_class_cq var3 = (class_cq.class_a_in_class_cq) var1.p(var2).b(a);
		float var4 = 0.125F;
		float var5 = 0.125F;
		if (var3 == class_cq.class_a_in_class_cq.a) {
			var4 = 0.5F;
		}

		if (var3 == class_cq.class_a_in_class_cq.c) {
			var5 = 0.5F;
		}

		this.a(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
	}

	public static int a(class_cq.class_a_in_class_cq var0) {
		return var0 == class_cq.class_a_in_class_cq.a ? 1 : (var0 == class_cq.class_a_in_class_cq.c ? 2 : 0);
	}

	@Override
	public boolean d() {
		return false;
	}

	public boolean d(class_ago var1, class_cj var2) {
		BlockPortal.class_a_in_class_alz var3 = new BlockPortal.class_a_in_class_alz(var1, var2, class_cq.class_a_in_class_cq.a);
		if (var3.d() && (var3.e == 0)) {
			var3.e();
			return true;
		} else {
			BlockPortal.class_a_in_class_alz var4 = new BlockPortal.class_a_in_class_alz(var1, var2, class_cq.class_a_in_class_cq.c);
			if (var4.d() && (var4.e == 0)) {
				var4.e();
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		class_cq.class_a_in_class_cq var5 = (class_cq.class_a_in_class_cq) var3.b(a);
		BlockPortal.class_a_in_class_alz var6;
		if (var5 == class_cq.class_a_in_class_cq.a) {
			var6 = new BlockPortal.class_a_in_class_alz(var1, var2, class_cq.class_a_in_class_cq.a);
			if (!var6.d() || (var6.e < (var6.h * var6.g))) {
				var1.a(var2, Blocks.AIR.getBlockData());
			}
		} else if (var5 == class_cq.class_a_in_class_cq.c) {
			var6 = new BlockPortal.class_a_in_class_alz(var1, var2, class_cq.class_a_in_class_cq.c);
			if (!var6.d() || (var6.e < (var6.h * var6.g))) {
				var1.a(var2, Blocks.AIR.getBlockData());
			}
		}

	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Entity var4) {
		if ((var4.m == null) && (var4.l == null)) {
			var4.d(var2);
		}

	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, (var1 & 3) == 2 ? class_cq.class_a_in_class_cq.c : class_cq.class_a_in_class_cq.a);
	}

	@Override
	public int c(class_apn var1) {
		return a((class_cq.class_a_in_class_cq) var1.b(a));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (BlockPortal.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
				case 2:
					switch (BlockPortal.SyntheticClass_1.a[((class_cq.class_a_in_class_cq) var1.b(a)).ordinal()]) {
						case 1:
							return var1.a(a, class_cq.class_a_in_class_cq.c);
						case 2:
							return var1.a(a, class_cq.class_a_in_class_cq.a);
						default:
							return var1;
					}
				default:
					return var1;
			}
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	public class_apr.class_b_in_class_apr e(class_ago var1, class_cj var2) {
		class_cq.class_a_in_class_cq var3 = class_cq.class_a_in_class_cq.c;
		BlockPortal.class_a_in_class_alz var4 = new BlockPortal.class_a_in_class_alz(var1, var2, class_cq.class_a_in_class_cq.a);
		LoadingCache var5 = class_apr.a(var1, true);
		if (!var4.d()) {
			var3 = class_cq.class_a_in_class_cq.a;
			var4 = new BlockPortal.class_a_in_class_alz(var1, var2, class_cq.class_a_in_class_cq.c);
		}

		if (!var4.d()) {
			return new class_apr.class_b_in_class_apr(var2, class_cq.c, class_cq.b, var5, 1, 1, 1);
		} else {
			int[] var6 = new int[class_cq.class_b_in_class_cq.values().length];
			class_cq var7 = var4.c.f();
			class_cj var8 = var4.f.b(var4.a() - 1);
			class_cq.class_b_in_class_cq[] var9 = class_cq.class_b_in_class_cq.values();
			int var10 = var9.length;

			int var11;
			for (var11 = 0; var11 < var10; ++var11) {
				class_cq.class_b_in_class_cq var12 = var9[var11];
				class_apr.class_b_in_class_apr var13 = new class_apr.class_b_in_class_apr(var7.c() == var12 ? var8 : var8.a(var4.c, var4.b() - 1), class_cq.a(var12, var3), class_cq.b, var5, var4.b(), var4.a(), 1);

				for (int var14 = 0; var14 < var4.b(); ++var14) {
					for (int var15 = 0; var15 < var4.a(); ++var15) {
						class_apq var16 = var13.a(var14, var15, 1);
						if ((var16.a() != null) && (var16.a().c().v() != class_avq.a)) {
							++var6[var12.ordinal()];
						}
					}
				}
			}

			class_cq.class_b_in_class_cq var17 = class_cq.class_b_in_class_cq.a;
			class_cq.class_b_in_class_cq[] var18 = class_cq.class_b_in_class_cq.values();
			var11 = var18.length;

			for (int var19 = 0; var19 < var11; ++var19) {
				class_cq.class_b_in_class_cq var20 = var18[var19];
				if (var6[var20.ordinal()] < var6[var17.ordinal()]) {
					var17 = var20;
				}
			}

			return new class_apr.class_b_in_class_apr(var7.c() == var17 ? var8 : var8.a(var4.c, var4.b() - 1), class_cq.a(var17, var3), class_cq.b, var5, var4.b(), var4.a(), 1);
		}
	}

	static {
		a = class_aqa.a("axis", class_cq.class_a_in_class_cq.class, (new class_cq.class_a_in_class_cq[] { class_cq.class_a_in_class_cq.a, class_cq.class_a_in_class_cq.c }));
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_c_in_class_ail.values().length];

		static {
			try {
				b[Block.class_c_in_class_ail.d.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			a = new int[class_cq.class_a_in_class_cq.values().length];

			try {
				a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.c.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static class class_a_in_class_alz {
		private final class_ago a;
		private final class_cq.class_a_in_class_cq b;
		private final class_cq c;
		private final class_cq d;
		private int e = 0;
		private class_cj f;
		private int g;
		private int h;

		public class_a_in_class_alz(class_ago var1, class_cj var2, class_cq.class_a_in_class_cq var3) {
			a = var1;
			b = var3;
			if (var3 == class_cq.class_a_in_class_cq.a) {
				d = class_cq.f;
				c = class_cq.e;
			} else {
				d = class_cq.c;
				c = class_cq.d;
			}

			for (class_cj var4 = var2; (var2.o() > (var4.o() - 21)) && (var2.o() > 0) && this.a(var1.p(var2.b()).c()); var2 = var2.b()) {
				;
			}

			int var5 = this.a(var2, d) - 1;
			if (var5 >= 0) {
				f = var2.a(d, var5);
				h = this.a(f, c);
				if ((h < 2) || (h > 21)) {
					f = null;
					h = 0;
				}
			}

			if (f != null) {
				g = this.c();
			}

		}

		protected int a(class_cj var1, class_cq var2) {
			int var3;
			for (var3 = 0; var3 < 22; ++var3) {
				class_cj var4 = var1.a(var2, var3);
				if (!this.a(a.p(var4).c()) || (a.p(var4.b()).c() != Blocks.OBSIDIAN)) {
					break;
				}
			}

			Block var5 = a.p(var1.a(var2, var3)).c();
			return var5 == Blocks.OBSIDIAN ? var3 : 0;
		}

		public int a() {
			return g;
		}

		public int b() {
			return h;
		}

		protected int c() {
			int var1;
			label56: for (g = 0; g < 21; ++g) {
				for (var1 = 0; var1 < h; ++var1) {
					class_cj var2 = f.a(c, var1).b(g);
					Block var3 = a.p(var2).c();
					if (!this.a(var3)) {
						break label56;
					}

					if (var3 == Blocks.PORTAL) {
						++e;
					}

					if (var1 == 0) {
						var3 = a.p(var2.a(d)).c();
						if (var3 != Blocks.OBSIDIAN) {
							break label56;
						}
					} else if (var1 == (h - 1)) {
						var3 = a.p(var2.a(c)).c();
						if (var3 != Blocks.OBSIDIAN) {
							break label56;
						}
					}
				}
			}

			for (var1 = 0; var1 < h; ++var1) {
				if (a.p(f.a(c, var1).b(g)).c() != Blocks.OBSIDIAN) {
					g = 0;
					break;
				}
			}

			if ((g <= 21) && (g >= 3)) {
				return g;
			} else {
				f = null;
				h = 0;
				g = 0;
				return 0;
			}
		}

		protected boolean a(Block var1) {
			return (var1.J == class_avq.a) || (var1 == Blocks.FIRE) || (var1 == Blocks.PORTAL);
		}

		public boolean d() {
			return (f != null) && (h >= 2) && (h <= 21) && (g >= 3) && (g <= 21);
		}

		public void e() {
			for (int var1 = 0; var1 < h; ++var1) {
				class_cj var2 = f.a(c, var1);

				for (int var3 = 0; var3 < g; ++var3) {
					a.a(var2.b(var3), Blocks.PORTAL.getBlockData().a(BlockPortal.a, b), 2);
				}
			}

		}
	}
}
