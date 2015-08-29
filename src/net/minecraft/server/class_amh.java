package net.minecraft.server;


public class class_amh extends Block {
	public static final class_aqa a = class_aqa.a("variant", class_amh.class_a_in_class_amh.class);

	public class_amh() {
		super(class_avq.e);
		this.j(M.b().a(a, class_amh.class_a_in_class_amh.a));
		this.a(class_abp.b);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		if (var7 == class_amh.class_a_in_class_amh.c.a()) {
			switch (class_amh.SyntheticClass_1.a[var3.k().ordinal()]) {
				case 1:
					return getBlockData().a(a, class_amh.class_a_in_class_amh.e);
				case 2:
					return getBlockData().a(a, class_amh.class_a_in_class_amh.d);
				case 3:
				default:
					return getBlockData().a(a, class_amh.class_a_in_class_amh.c);
			}
		} else {
			return var7 == class_amh.class_a_in_class_amh.b.a() ? getBlockData().a(a, class_amh.class_a_in_class_amh.b) : getBlockData().a(a, class_amh.class_a_in_class_amh.a);
		}
	}

	@Override
	public int a(class_apn var1) {
		class_amh.class_a_in_class_amh var2 = (class_amh.class_a_in_class_amh) var1.b(a);
		return (var2 != class_amh.class_a_in_class_amh.d) && (var2 != class_amh.class_a_in_class_amh.e) ? var2.a() : class_amh.class_a_in_class_amh.c.a();
	}

	@Override
	protected class_aco i(class_apn var1) {
		class_amh.class_a_in_class_amh var2 = (class_amh.class_a_in_class_amh) var1.b(a);
		return (var2 != class_amh.class_a_in_class_amh.d) && (var2 != class_amh.class_a_in_class_amh.e) ? super.i(var1) : new class_aco(Item.a(this), 1, class_amh.class_a_in_class_amh.c.a());
	}

	@Override
	public class_avr g(class_apn var1) {
		return class_avr.p;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, class_amh.class_a_in_class_amh.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_amh.class_a_in_class_amh) var1.b(a)).a();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_amh.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
				case 2:
					switch (class_amh.SyntheticClass_1.b[((class_amh.class_a_in_class_amh) var1.b(a)).ordinal()]) {
						case 1:
							return var1.a(a, class_amh.class_a_in_class_amh.e);
						case 2:
							return var1.a(a, class_amh.class_a_in_class_amh.d);
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

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[Block.class_c_in_class_ail.values().length];

		static {
			try {
				c[Block.class_c_in_class_ail.d.ordinal()] = 1;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				c[Block.class_c_in_class_ail.b.ordinal()] = 2;
			} catch (NoSuchFieldError var6) {
				;
			}

			b = new int[class_amh.class_a_in_class_amh.values().length];

			try {
				b[class_amh.class_a_in_class_amh.d.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[class_amh.class_a_in_class_amh.e.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[class_cq.class_a_in_class_cq.values().length];

			try {
				a[class_cq.class_a_in_class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.a.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.b.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_amh implements class_oe {
		a(0, "default", "default"),
		b(1, "chiseled", "chiseled"),
		c(2, "lines_y", "lines"),
		d(3, "lines_x", "lines"),
		e(4, "lines_z", "lines");

		private static final class_amh.class_a_in_class_amh[] f;
		private final int g;
		private final String h;
		private final String i;

		private class_a_in_class_amh(int var3, String var4, String var5) {
			g = var3;
			h = var4;
			i = var5;
		}

		public int a() {
			return g;
		}

		@Override
		public String toString() {
			return i;
		}

		public static class_amh.class_a_in_class_amh a(int var0) {
			if ((var0 < 0) || (var0 >= f.length)) {
				var0 = 0;
			}

			return f[var0];
		}

		@Override
		public String l() {
			return h;
		}

		static {
			f = new class_amh.class_a_in_class_amh[values().length];
			class_amh.class_a_in_class_amh[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_amh.class_a_in_class_amh var3 = var0[var2];
				f[var3.a()] = var3;
			}

		}
	}
}
