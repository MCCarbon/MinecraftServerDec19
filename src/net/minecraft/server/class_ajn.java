package net.minecraft.server;

import java.util.Random;

public class class_ajn extends Block {
	public static final class_apz a;
	public static final class_apy b;
	public static final class_aqa N;
	public static final class_apy O;
	public static final class_aqa P;

	protected class_ajn(class_avq var1) {
		super(var1);
		this.j(M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)).a(N, class_ajn.class_b_in_class_ajn.a).a(O, Boolean.valueOf(false)).a(P, class_ajn.class_a_in_class_ajn.b));
	}

	@Override
	public String f() {
		return class_di.a((this.a() + ".name").replaceAll("tile", "item"));
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean b(class_ags var1, class_cj var2) {
		return g(e(var1, var2));
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		this.a((class_ags) var1, var2);
		return super.a(var1, var2, var3);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.k(e(var1, var2));
	}

	private void k(int var1) {
		float var2 = 0.1875F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		class_cq var3 = f(var1);
		boolean var4 = g(var1);
		boolean var5 = j(var1);
		if (var4) {
			if (var3 == class_cq.f) {
				if (!var5) {
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
				} else {
					this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
				}
			} else if (var3 == class_cq.d) {
				if (!var5) {
					this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
				}
			} else if (var3 == class_cq.e) {
				if (!var5) {
					this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
				} else {
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
				}
			} else if (var3 == class_cq.c) {
				if (!var5) {
					this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
				} else {
					this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			}
		} else if (var3 == class_cq.f) {
			this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
		} else if (var3 == class_cq.d) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
		} else if (var3 == class_cq.e) {
			this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else if (var3 == class_cq.c) {
			this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
		}

	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (J == class_avq.f) {
			return true;
		} else {
			class_cj var11 = var3.b(P) == class_ajn.class_a_in_class_ajn.b ? var2 : var2.b();
			class_apn var12 = var2.equals(var11) ? var3 : var1.p(var11);
			if (var12.c() != this) {
				return false;
			} else {
				var3 = var12.a(b);
				var1.a(var11, var3, 2);
				var1.b(var11, var2);
				var1.a(var4, ((Boolean) var3.b(b)).booleanValue() ? 1003 : 1006, var2, 0);
				return true;
			}
		}
	}

	public void a(class_ago var1, class_cj var2, boolean var3) {
		class_apn var4 = var1.p(var2);
		if (var4.c() == this) {
			class_cj var5 = var4.b(P) == class_ajn.class_a_in_class_ajn.b ? var2 : var2.b();
			class_apn var6 = var2 == var5 ? var4 : var1.p(var5);
			if ((var6.c() == this) && (((Boolean) var6.b(b)).booleanValue() != var3)) {
				var1.a(var5, var6.a(b, Boolean.valueOf(var3)), 2);
				var1.b(var5, var2);
				var1.a((class_yu) null, var3 ? 1003 : 1006, var2, 0);
			}

		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (var3.b(P) == class_ajn.class_a_in_class_ajn.a) {
			class_cj var5 = var2.b();
			class_apn var6 = var1.p(var5);
			if (var6.c() != this) {
				var1.g(var2);
			} else if (var4 != this) {
				this.a(var1, var5, var6, var4);
			}
		} else {
			boolean var9 = false;
			class_cj var10 = var2.a();
			class_apn var7 = var1.p(var10);
			if (var7.c() != this) {
				var1.g(var2);
				var9 = true;
			}

			if (!class_ago.a(var1, var2.b())) {
				var1.g(var2);
				var9 = true;
				if (var7.c() == this) {
					var1.g(var10);
				}
			}

			if (var9) {
				if (!var1.D) {
					this.b(var1, var2, var3, 0);
				}
			} else {
				boolean var8 = var1.z(var2) || var1.z(var10);
				if ((var8 || var4.i()) && (var4 != this) && (var8 != ((Boolean) var7.b(O)).booleanValue())) {
					var1.a(var10, var7.a(O, Boolean.valueOf(var8)), 2);
					if (var8 != ((Boolean) var3.b(b)).booleanValue()) {
						var1.a(var2, var3.a(b, Boolean.valueOf(var8)), 2);
						var1.b(var2, var2);
						var1.a((class_yu) null, var8 ? 1003 : 1006, var2, 0);
					}
				}
			}
		}

	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return var1.b(P) == class_ajn.class_a_in_class_ajn.a ? null : l();
	}

	@Override
	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		this.a((class_ags) var1, var2);
		return super.a(var1, var2, var3, var4);
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return var2.o() >= 255 ? false : class_ago.a(var1, var2.b()) && super.c(var1, var2) && super.c(var1, var2.a());
	}

	@Override
	public int k() {
		return 1;
	}

	public static int e(class_ags var0, class_cj var1) {
		class_apn var2 = var0.p(var1);
		int var3 = var2.c().c(var2);
		boolean var4 = i(var3);
		class_apn var5 = var0.p(var1.b());
		int var6 = var5.c().c(var5);
		int var7 = var4 ? var6 : var3;
		class_apn var8 = var0.p(var1.a());
		int var9 = var8.c().c(var8);
		int var10 = var4 ? var3 : var9;
		boolean var11 = (var10 & 1) != 0;
		boolean var12 = (var10 & 2) != 0;
		return b(var7) | (var4 ? 8 : 0) | (var11 ? 16 : 0) | (var12 ? 32 : 0);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(l());
	}

	private Item l() {
		return this == Blocks.IRON_DOOR ? Items.aD : (this == Blocks.SPRUCE_DOOR ? Items.at : (this == Blocks.BIRCH_DOOR ? Items.au : (this == Blocks.JUNGLE_DOOR ? Items.av : (this == Blocks.ACACIA_DOOR ? Items.aw : (this == Blocks.DARK_OAK_DOOR ? Items.ax : Items.as)))));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		class_cj var5 = var2.b();
		if (var4.bI.d && (var3.b(P) == class_ajn.class_a_in_class_ajn.a) && (var1.p(var5).c() == this)) {
			var1.g(var5);
		}

	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		class_apn var4;
		if (var1.b(P) == class_ajn.class_a_in_class_ajn.b) {
			var4 = var2.p(var3.a());
			if (var4.c() == this) {
				var1 = var1.a(N, var4.b(N)).a(O, var4.b(O));
			}
		} else {
			var4 = var2.p(var3.b());
			if (var4.c() == this) {
				var1 = var1.a(a, var4.b(a)).a(b, var4.b(b));
			}
		}

		return var1;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return (var1.c() == this) && (var1.b(P) == class_ajn.class_a_in_class_ajn.b) ? var1.a(a, var2.a((class_cq) var1.b(a))) : var1;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return (var1.c() == this) && (var1.b(P) == class_ajn.class_a_in_class_ajn.b) ? this.a(var1, var2.a((class_cq) var1.b(a))) : var1;
	}

	@Override
	public class_apn a(int var1) {
		return (var1 & 8) > 0 ? S().a(P, class_ajn.class_a_in_class_ajn.a).a(N, (var1 & 1) > 0 ? class_ajn.class_b_in_class_ajn.b : class_ajn.class_b_in_class_ajn.a).a(O, Boolean.valueOf((var1 & 2) > 0)) : S().a(P, class_ajn.class_a_in_class_ajn.b).a(a, class_cq.b(var1 & 3).f()).a(b, Boolean.valueOf((var1 & 4) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3;
		if (var1.b(P) == class_ajn.class_a_in_class_ajn.a) {
			var3 = var2 | 8;
			if (var1.b(N) == class_ajn.class_b_in_class_ajn.b) {
				var3 |= 1;
			}

			if (((Boolean) var1.b(O)).booleanValue()) {
				var3 |= 2;
			}
		} else {
			var3 = var2 | ((class_cq) var1.b(a)).e().b();
			if (((Boolean) var1.b(b)).booleanValue()) {
				var3 |= 4;
			}
		}

		return var3;
	}

	protected static int b(int var0) {
		return var0 & 7;
	}

	public static boolean f(class_ags var0, class_cj var1) {
		return g(e(var0, var1));
	}

	public static class_cq h(class_ags var0, class_cj var1) {
		return f(e(var0, var1));
	}

	public static class_cq f(int var0) {
		return class_cq.b(var0 & 3).f();
	}

	protected static boolean g(int var0) {
		return (var0 & 4) != 0;
	}

	protected static boolean i(int var0) {
		return (var0 & 8) != 0;
	}

	protected static boolean j(int var0) {
		return (var0 & 16) != 0;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { P, a, b, N, O });
	}

	static {
		a = class_akx.O;
		b = class_apy.a("open");
		N = class_aqa.a("hinge", class_ajn.class_b_in_class_ajn.class);
		O = class_apy.a("powered");
		P = class_aqa.a("half", class_ajn.class_a_in_class_ajn.class);
	}

	public static enum class_b_in_class_ajn implements class_oe {
		a,
		b;

		@Override
		public String toString() {
			return l();
		}

		@Override
		public String l() {
			return this == a ? "left" : "right";
		}
	}

	public static enum class_a_in_class_ajn implements class_oe {
		a,
		b;

		@Override
		public String toString() {
			return l();
		}

		@Override
		public String l() {
			return this == a ? "upper" : "lower";
		}
	}
}
