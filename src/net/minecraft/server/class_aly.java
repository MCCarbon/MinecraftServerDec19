package net.minecraft.server;


public class class_aly extends class_ail {
	public static final class_aqa a = class_aqa.a("variant", class_aly.class_a_in_class_aly.class);

	public class_aly() {
		super(class_avq.d);
		this.j(M.b().a(a, class_aly.class_a_in_class_aly.a));
		this.a(class_abp.b);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(a)).a();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_aly.class_a_in_class_aly.a(var1));
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(a)).c();
	}

	@Override
	public int c(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	public static enum class_a_in_class_aly implements class_oe {
		a(0, "oak", class_avr.o),
		b(1, "spruce", class_avr.J),
		c(2, "birch", class_avr.d),
		d(3, "jungle", class_avr.l),
		e(4, "acacia", class_avr.q),
		f(5, "dark_oak", "big_oak", class_avr.B);

		private static final class_aly.class_a_in_class_aly[] g;
		private final int h;
		private final String i;
		private final String j;
		private final class_avr k;

		private class_a_in_class_aly(int var3, String var4, class_avr var5) {
			this(var3, var4, var4, var5);
		}

		private class_a_in_class_aly(int var3, String var4, String var5, class_avr var6) {
			h = var3;
			i = var4;
			j = var5;
			k = var6;
		}

		public int a() {
			return h;
		}

		public class_avr c() {
			return k;
		}

		@Override
		public String toString() {
			return i;
		}

		public static class_aly.class_a_in_class_aly a(int var0) {
			if ((var0 < 0) || (var0 >= g.length)) {
				var0 = 0;
			}

			return g[var0];
		}

		@Override
		public String l() {
			return i;
		}

		public String d() {
			return j;
		}

		static {
			g = new class_aly.class_a_in_class_aly[values().length];
			class_aly.class_a_in_class_aly[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_aly.class_a_in_class_aly var3 = var0[var2];
				g[var3.a()] = var3;
			}

		}
	}
}
