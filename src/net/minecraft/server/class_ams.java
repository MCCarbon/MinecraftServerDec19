package net.minecraft.server;


public class class_ams extends class_ajz {
	public static final class_aqa a = class_aqa.a("variant", class_ams.class_a_in_class_ams.class);

	public class_ams() {
		this.j(M.b().a(a, class_ams.class_a_in_class_ams.a));
	}

	@Override
	public int a(class_apn var1) {
		return ((class_ams.class_a_in_class_ams) var1.b(a)).a();
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_ams.class_a_in_class_ams) var1.b(a)).c();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_ams.class_a_in_class_ams.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_ams.class_a_in_class_ams) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	public static enum class_a_in_class_ams implements class_oe {
		a(0, "sand", "default", class_avr.d),
		b(1, "red_sand", "red", class_avr.q);

		private static final class_ams.class_a_in_class_ams[] c;
		private final int d;
		private final String e;
		private final class_avr f;
		private final String g;

		private class_a_in_class_ams(int var3, String var4, String var5, class_avr var6) {
			d = var3;
			e = var4;
			f = var6;
			g = var5;
		}

		public int a() {
			return d;
		}

		@Override
		public String toString() {
			return e;
		}

		public class_avr c() {
			return f;
		}

		public static class_ams.class_a_in_class_ams a(int var0) {
			if ((var0 < 0) || (var0 >= c.length)) {
				var0 = 0;
			}

			return c[var0];
		}

		@Override
		public String l() {
			return e;
		}

		public String d() {
			return g;
		}

		static {
			c = new class_ams.class_a_in_class_ams[values().length];
			class_ams.class_a_in_class_ams[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ams.class_a_in_class_ams var3 = var0[var2];
				c[var3.a()] = var3;
			}

		}
	}
}
