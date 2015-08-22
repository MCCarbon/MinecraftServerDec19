package net.minecraft.server;

import java.util.Random;

public class class_ajo extends class_aiq implements class_ain {
	public static final class_aqa a = class_aqa.a("variant", class_ajo.class_b_in_class_ajo.class);
	public static final class_aqa b = class_aqa.a("half", class_ajo.class_a_in_class_ajo.class);
	public static final class_aqa N;

	public class_ajo() {
		super(class_avq.l);
		this.j(M.b().a(a, class_ajo.class_b_in_class_ajo.a).a(b, class_ajo.class_a_in_class_ajo.b).a(N, class_cq.c));
		this.c(0.0F);
		this.a(h);
		this.c("doublePlant");
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private class_ajo.class_b_in_class_ajo a(class_ags var1, class_cj var2, class_apn var3) {
		if (var3.c() == this) {
			var3 = this.a(var3, var1, var2);
			return (class_ajo.class_b_in_class_ajo) var3.b(a);
		} else {
			return class_ajo.class_b_in_class_ajo.d;
		}
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) && var1.d(var2.a());
	}

	@Override
	public boolean a(class_ago var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		if (var3.c() != this) {
			return true;
		} else {
			class_ajo.class_b_in_class_ajo var4 = (class_ajo.class_b_in_class_ajo) this.a(var3, var1, var2).b(a);
			return (var4 == class_ajo.class_b_in_class_ajo.d) || (var4 == class_ajo.class_b_in_class_ajo.c);
		}
	}

	@Override
	protected void f(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.g(var1, var2, var3)) {
			boolean var4 = var3.b(b) == class_ajo.class_a_in_class_ajo.a;
			class_cj var5 = var4 ? var2 : var2.a();
			class_cj var6 = var4 ? var2.b() : var2;
			Object var7 = var4 ? this : var1.p(var5).c();
			Object var8 = var4 ? var1.p(var6).c() : this;
			if (var7 == this) {
				var1.a(var5, Blocks.a.S(), 2);
			}

			if (var8 == this) {
				var1.a(var6, Blocks.a.S(), 3);
				if (!var4) {
					this.b(var1, var6, var3, 0);
				}
			}

		}
	}

	@Override
	public boolean g(class_ago var1, class_cj var2, class_apn var3) {
		if (var3.b(b) == class_ajo.class_a_in_class_ajo.a) {
			return var1.p(var2.b()).c() == this;
		} else {
			class_apn var4 = var1.p(var2.a());
			return (var4.c() == this) && super.g(var1, var2, var4);
		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		if (var1.b(b) == class_ajo.class_a_in_class_ajo.a) {
			return null;
		} else {
			class_ajo.class_b_in_class_ajo var4 = (class_ajo.class_b_in_class_ajo) var1.b(a);
			return var4 == class_ajo.class_b_in_class_ajo.d ? null : (var4 == class_ajo.class_b_in_class_ajo.c ? (var2.nextInt(8) == 0 ? Items.P : null) : Item.a(this));
		}
	}

	@Override
	public int a(class_apn var1) {
		return (var1.b(b) != class_ajo.class_a_in_class_ajo.a) && (var1.b(a) != class_ajo.class_b_in_class_ajo.c) ? ((class_ajo.class_b_in_class_ajo) var1.b(a)).a() : 0;
	}

	public void a(class_ago var1, class_cj var2, class_ajo.class_b_in_class_ajo var3, int var4) {
		var1.a(var2, S().a(b, class_ajo.class_a_in_class_ajo.b).a(a, var3), var4);
		var1.a(var2.a(), S().a(b, class_ajo.class_a_in_class_ajo.a), var4);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		var1.a(var2.a(), S().a(b, class_ajo.class_a_in_class_ajo.a), 2);
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, TileEntity var5, class_aco var6) {
		if (var1.D || (var6 == null) || (var6.b() != Items.bg) || (var4.b(b) != class_ajo.class_a_in_class_ajo.b) || !this.b(var1, var3, var4, var2)) {
			super.a(var1, var2, var3, var4, var5, var6);
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		if (var3.b(b) == class_ajo.class_a_in_class_ajo.a) {
			if (var1.p(var2.b()).c() == this) {
				if (!var4.bI.d) {
					class_apn var5 = var1.p(var2.b());
					class_ajo.class_b_in_class_ajo var6 = (class_ajo.class_b_in_class_ajo) var5.b(a);
					if ((var6 != class_ajo.class_b_in_class_ajo.d) && (var6 != class_ajo.class_b_in_class_ajo.c)) {
						var1.b(var2.b(), true);
					} else if (!var1.D) {
						if ((var4.bG() != null) && (var4.bG().b() == Items.bg)) {
							this.b(var1, var2, var5, var4);
							var1.g(var2.b());
						} else {
							var1.b(var2.b(), true);
						}
					} else {
						var1.g(var2.b());
					}
				} else {
					var1.g(var2.b());
				}
			}
		} else if (var4.bI.d && (var1.p(var2.a()).c() == this)) {
			var1.a(var2.a(), Blocks.a.S(), 2);
		}

		super.a(var1, var2, var3, var4);
	}

	private boolean b(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		class_ajo.class_b_in_class_ajo var5 = (class_ajo.class_b_in_class_ajo) var3.b(a);
		if ((var5 != class_ajo.class_b_in_class_ajo.d) && (var5 != class_ajo.class_b_in_class_ajo.c)) {
			return false;
		} else {
			var4.b(class_nh.a(Block.a(this)));
			int var6 = (var5 == class_ajo.class_b_in_class_ajo.c ? class_ano.class_a_in_class_ano.b : class_ano.class_a_in_class_ano.c).a();
			a(var1, var2, (new class_aco(Blocks.H, 2, var6)));
			return true;
		}
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(this, 1, this.a((class_ags) var1, var2, var3).a());
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		class_ajo.class_b_in_class_ajo var5 = this.a((class_ags) var1, var2, var3);
		return (var5 != class_ajo.class_b_in_class_ajo.c) && (var5 != class_ajo.class_b_in_class_ajo.d);
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		return true;
	}

	@Override
	public void b(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		a(var1, var3, (new class_aco(this, 1, this.a((class_ags) var1, var3, var4).a())));
	}

	@Override
	public class_apn a(int var1) {
		return (var1 & 8) > 0 ? S().a(b, class_ajo.class_a_in_class_ajo.a) : S().a(b, class_ajo.class_a_in_class_ajo.b).a(a, class_ajo.class_b_in_class_ajo.a(var1 & 7));
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		if (var1.b(b) == class_ajo.class_a_in_class_ajo.a) {
			class_apn var4 = var2.p(var3.b());
			if (var4.c() == this) {
				var1 = var1.a(a, var4.b(a));
			}
		}

		return var1;
	}

	@Override
	public int c(class_apn var1) {
		return var1.b(b) == class_ajo.class_a_in_class_ajo.a ? 8 | ((class_cq) var1.b(N)).b() : ((class_ajo.class_b_in_class_ajo) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, a, N });
	}

	static {
		N = class_akx.O;
	}

	public static enum class_a_in_class_ajo implements class_oe {
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

	public static enum class_b_in_class_ajo implements class_oe {
		a(0, "sunflower"),
		b(1, "syringa"),
		c(2, "double_grass", "grass"),
		d(3, "double_fern", "fern"),
		e(4, "double_rose", "rose"),
		f(5, "paeonia");

		private static final class_ajo.class_b_in_class_ajo[] g;
		private final int h;
		private final String i;
		private final String j;

		private class_b_in_class_ajo(int var3, String var4) {
			this(var3, var4, var4);
		}

		private class_b_in_class_ajo(int var3, String var4, String var5) {
			h = var3;
			i = var4;
			j = var5;
		}

		public int a() {
			return h;
		}

		@Override
		public String toString() {
			return i;
		}

		public static class_ajo.class_b_in_class_ajo a(int var0) {
			if ((var0 < 0) || (var0 >= g.length)) {
				var0 = 0;
			}

			return g[var0];
		}

		@Override
		public String l() {
			return i;
		}

		public String c() {
			return j;
		}

		static {
			g = new class_ajo.class_b_in_class_ajo[values().length];
			class_ajo.class_b_in_class_ajo[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ajo.class_b_in_class_ajo var3 = var0[var2];
				g[var3.a()] = var3;
			}

		}
	}
}
