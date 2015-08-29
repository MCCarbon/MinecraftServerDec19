package net.minecraft.server;


public class class_amt extends Block {
	public static final class_aqa a = class_aqa.a("type", class_amt.class_a_in_class_amt.class);

	public class_amt() {
		super(class_avq.e);
		this.j(M.b().a(a, class_amt.class_a_in_class_amt.a));
		this.a(class_abp.b);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_amt.class_a_in_class_amt) var1.b(a)).a();
	}

	@Override
	public class_avr g(class_apn var1) {
		return class_avr.d;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, class_amt.class_a_in_class_amt.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_amt.class_a_in_class_amt) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	public static enum class_a_in_class_amt implements class_oe {
		a(0, "sandstone", "default"),
		b(1, "chiseled_sandstone", "chiseled"),
		c(2, "smooth_sandstone", "smooth");

		private static final class_amt.class_a_in_class_amt[] d;
		private final int e;
		private final String f;
		private final String g;

		private class_a_in_class_amt(int var3, String var4, String var5) {
			e = var3;
			f = var4;
			g = var5;
		}

		public int a() {
			return e;
		}

		@Override
		public String toString() {
			return f;
		}

		public static class_amt.class_a_in_class_amt a(int var0) {
			if ((var0 < 0) || (var0 >= d.length)) {
				var0 = 0;
			}

			return d[var0];
		}

		@Override
		public String l() {
			return f;
		}

		public String c() {
			return g;
		}

		static {
			d = new class_amt.class_a_in_class_amt[values().length];
			class_amt.class_a_in_class_amt[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_amt.class_a_in_class_amt var3 = var0[var2];
				d[var3.a()] = var3;
			}

		}
	}
}
