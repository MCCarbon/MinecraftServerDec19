package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_aij extends class_akx {
	public static final class_aqa a = class_aqa.a("part", class_aij.class_a_in_class_aij.class);
	public static final class_apy b = class_apy.a("occupied");

	public class_aij() {
		super(class_avq.n);
		this.j(M.b().a(a, class_aij.class_a_in_class_aij.b).a(b, Boolean.valueOf(false)));
		l();
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			if (var3.b(a) != class_aij.class_a_in_class_aij.a) {
				var2 = var2.a((class_cq) var3.b(O));
				var3 = var1.p(var2);
				if (var3.c() != this) {
					return true;
				}
			}

			if (var1.t.e() && (var1.b(var2) != class_ahb.x)) {
				if (((Boolean) var3.b(b)).booleanValue()) {
					class_yu var12 = this.e(var1, var2);
					if (var12 != null) {
						var4.b((new class_fb("tile.bed.occupied", new Object[0])));
						return true;
					}

					var3 = var3.a(b, Boolean.valueOf(false));
					var1.a(var2, var3, 4);
				}

				class_yu.class_a_in_class_yu var13 = var4.a(var2);
				if (var13 == class_yu.class_a_in_class_yu.a) {
					var3 = var3.a(b, Boolean.valueOf(true));
					var1.a(var2, var3, 4);
					return true;
				} else {
					if (var13 == class_yu.class_a_in_class_yu.c) {
						var4.b((new class_fb("tile.bed.noSleep", new Object[0])));
					} else if (var13 == class_yu.class_a_in_class_yu.f) {
						var4.b((new class_fb("tile.bed.notSafe", new Object[0])));
					}

					return true;
				}
			} else {
				var1.g(var2);
				class_cj var11 = var2.a(((class_cq) var3.b(O)).d());
				if (var1.p(var11).c() == this) {
					var1.g(var11);
				}

				var1.a((Entity) null, var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, 5.0F, true, true);
				return true;
			}
		}
	}

	private class_yu e(class_ago var1, class_cj var2) {
		Iterator var3 = var1.j.iterator();

		class_yu var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (class_yu) var3.next();
		} while (!var4.bQ() || !var4.bF.equals(var2));

		return var4;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		l();
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		class_cq var5 = (class_cq) var3.b(O);
		if (var3.b(a) == class_aij.class_a_in_class_aij.a) {
			if (var1.p(var2.a(var5.d())).c() != this) {
				var1.g(var2);
			}
		} else if (var1.p(var2.a(var5)).c() != this) {
			var1.g(var2);
			if (!var1.D) {
				this.b(var1, var2, var3, 0);
			}
		}

	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return var1.b(a) == class_aij.class_a_in_class_aij.a ? null : Items.bc;
	}

	private void l() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	}

	public static class_cj a(class_ago var0, class_cj var1, int var2) {
		class_cq var3 = (class_cq) var0.p(var1).b(O);
		int var4 = var1.n();
		int var5 = var1.o();
		int var6 = var1.p();

		for (int var7 = 0; var7 <= 1; ++var7) {
			int var8 = var4 - (var3.g() * var7) - 1;
			int var9 = var6 - (var3.i() * var7) - 1;
			int var10 = var8 + 2;
			int var11 = var9 + 2;

			for (int var12 = var8; var12 <= var10; ++var12) {
				for (int var13 = var9; var13 <= var11; ++var13) {
					class_cj var14 = new class_cj(var12, var5, var13);
					if (d(var0, var14)) {
						if (var2 <= 0) {
							return var14;
						}

						--var2;
					}
				}
			}
		}

		return null;
	}

	protected static boolean d(class_ago var0, class_cj var1) {
		return class_ago.a(var0, var1.b()) && !var0.p(var1).c().v().a() && !var0.p(var1.a()).c().v().a();
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		if (var3.b(a) == class_aij.class_a_in_class_aij.b) {
			super.a(var1, var2, var3, var4, 0);
		}

	}

	@Override
	public int k() {
		return 1;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.bc);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		if (var4.bI.d && (var3.b(a) == class_aij.class_a_in_class_aij.a)) {
			class_cj var5 = var2.a(((class_cq) var3.b(O)).d());
			if (var1.p(var5).c() == this) {
				var1.g(var5);
			}
		}

	}

	@Override
	public class_apn a(int var1) {
		class_cq var2 = class_cq.b(var1);
		return (var1 & 8) > 0 ? S().a(a, class_aij.class_a_in_class_aij.a).a(O, var2).a(b, Boolean.valueOf((var1 & 4) > 0)) : S().a(a, class_aij.class_a_in_class_aij.b).a(O, var2);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		if (var1.b(a) == class_aij.class_a_in_class_aij.b) {
			class_apn var4 = var2.p(var3.a((class_cq) var1.b(O)));
			if (var4.c() == this) {
				var1 = var1.a(b, var4.b(b));
			}
		}

		return var1;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(O, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(O)).b();
		if (var1.b(a) == class_aij.class_a_in_class_aij.a) {
			var3 |= 8;
			if (((Boolean) var1.b(b)).booleanValue()) {
				var3 |= 4;
			}
		}

		return var3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { O, a, b });
	}

	public static enum class_a_in_class_aij implements class_oe {
		a("head"),
		b("foot");

		private final String c;

		private class_a_in_class_aij(String var3) {
			c = var3;
		}

		@Override
		public String toString() {
			return c;
		}

		@Override
		public String l() {
			return c;
		}
	}
}
