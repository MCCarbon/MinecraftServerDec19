package net.minecraft.server;

import java.util.Random;

public class class_alj extends class_ail {
	public static final class_aqa a = class_aqa.a("variant", class_alj.class_a_in_class_alj.class);

	public class_alj() {
		super(class_avq.B);
		this.j(M.b().a(a, class_alj.class_a_in_class_alj.a));
		this.c(0.0F);
		this.a(class_abp.c);
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	public static boolean d(class_apn var0) {
		class_ail var1 = var0.c();
		return (var0 == class_aim.b.S().a(class_anj.a, class_anj.class_a_in_class_anj.a)) || (var1 == class_aim.e) || (var1 == class_aim.bf);
	}

	@Override
	protected class_aco i(class_apn var1) {
		switch (class_alj.SyntheticClass_1.a[((class_alj.class_a_in_class_alj) var1.b(a)).ordinal()]) {
			case 1:
				return new class_aco(class_aim.e);
			case 2:
				return new class_aco(class_aim.bf);
			case 3:
				return new class_aco(class_aim.bf, 1, class_ank.class_a_in_class_ank.b.a());
			case 4:
				return new class_aco(class_aim.bf, 1, class_ank.class_a_in_class_ank.c.a());
			case 5:
				return new class_aco(class_aim.bf, 1, class_ank.class_a_in_class_ank.d.a());
			default:
				return new class_aco(class_aim.b);
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		if (!var1.D && var1.S().b("doTileDrops")) {
			class_yg var6 = new class_yg(var1);
			var6.b(var2.n() + 0.5D, var2.o(), var2.p() + 0.5D, 0.0F, 0.0F);
			var1.a(var6);
			var6.A();
		}

	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(this, 1, var3.c().c(var3));
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_alj.class_a_in_class_alj.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_alj.class_a_in_class_alj) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_alj.class_a_in_class_alj.values().length];

		static {
			try {
				a[class_alj.class_a_in_class_alj.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_alj.class_a_in_class_alj.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_alj.class_a_in_class_alj.d.ordinal()] = 3;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_alj.class_a_in_class_alj.e.ordinal()] = 4;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_alj.class_a_in_class_alj.f.ordinal()] = 5;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_alj implements class_oe {
		a(0, "stone") {
			@Override
			public class_apn d() {
				return class_aim.b.S().a(class_anj.a, class_anj.class_a_in_class_anj.a);
			}
		},
		b(1, "cobblestone", "cobble") {
			@Override
			public class_apn d() {
				return class_aim.e.S();
			}
		},
		c(2, "stone_brick", "brick") {
			@Override
			public class_apn d() {
				return class_aim.bf.S().a(class_ank.a, class_ank.class_a_in_class_ank.a);
			}
		},
		d(3, "mossy_brick", "mossybrick") {
			@Override
			public class_apn d() {
				return class_aim.bf.S().a(class_ank.a, class_ank.class_a_in_class_ank.b);
			}
		},
		e(4, "cracked_brick", "crackedbrick") {
			@Override
			public class_apn d() {
				return class_aim.bf.S().a(class_ank.a, class_ank.class_a_in_class_ank.c);
			}
		},
		f(5, "chiseled_brick", "chiseledbrick") {
			@Override
			public class_apn d() {
				return class_aim.bf.S().a(class_ank.a, class_ank.class_a_in_class_ank.d);
			}
		};

		private static final class_alj.class_a_in_class_alj[] g;
		private final int h;
		private final String i;
		private final String j;

		private class_a_in_class_alj(int var3, String var4) {
			this(var3, var4, var4);
		}

		private class_a_in_class_alj(int var3, String var4, String var5) {
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

		public static class_alj.class_a_in_class_alj a(int var0) {
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

		public abstract class_apn d();

		public static class_alj.class_a_in_class_alj a(class_apn var0) {
			class_alj.class_a_in_class_alj[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				class_alj.class_a_in_class_alj var4 = var1[var3];
				if (var0 == var4.d()) {
					return var4;
				}
			}

			return a;
		}

		// $FF: synthetic method
		class_a_in_class_alj(int var3, String var4, class_alj.SyntheticClass_1 var5) {
			this(var3, var4);
		}

		// $FF: synthetic method
		class_a_in_class_alj(int var3, String var4, String var5, class_alj.SyntheticClass_1 var6) {
			this(var3, var4, var5);
		}

		static {
			g = new class_alj.class_a_in_class_alj[values().length];
			class_alj.class_a_in_class_alj[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_alj.class_a_in_class_alj var3 = var0[var2];
				g[var3.a()] = var3;
			}

		}
	}
}
