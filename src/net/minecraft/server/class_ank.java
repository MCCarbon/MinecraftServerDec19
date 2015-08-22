package net.minecraft.server;


public class class_ank extends class_ail {
	public static final class_aqa a = class_aqa.a("variant", class_ank.class_a_in_class_ank.class);
	public static final int b;
	public static final int N;
	public static final int O;
	public static final int P;

	public class_ank() {
		super(class_avq.e);
		this.j(M.b().a(a, class_ank.class_a_in_class_ank.a));
		this.a(class_abp.b);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_ank.class_a_in_class_ank) var1.b(a)).a();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_ank.class_a_in_class_ank.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_ank.class_a_in_class_ank) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	static {
		b = class_ank.class_a_in_class_ank.a.a();
		N = class_ank.class_a_in_class_ank.b.a();
		O = class_ank.class_a_in_class_ank.c.a();
		P = class_ank.class_a_in_class_ank.d.a();
	}

	public static enum class_a_in_class_ank implements class_oe {
		a(0, "stonebrick", "default"),
		b(1, "mossy_stonebrick", "mossy"),
		c(2, "cracked_stonebrick", "cracked"),
		d(3, "chiseled_stonebrick", "chiseled");

		private static final class_ank.class_a_in_class_ank[] e;
		private final int f;
		private final String g;
		private final String h;

		private class_a_in_class_ank(int var3, String var4, String var5) {
			f = var3;
			g = var4;
			h = var5;
		}

		public int a() {
			return f;
		}

		@Override
		public String toString() {
			return g;
		}

		public static class_ank.class_a_in_class_ank a(int var0) {
			if ((var0 < 0) || (var0 >= e.length)) {
				var0 = 0;
			}

			return e[var0];
		}

		@Override
		public String l() {
			return g;
		}

		public String c() {
			return h;
		}

		static {
			e = new class_ank.class_a_in_class_ank[values().length];
			class_ank.class_a_in_class_ank[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ank.class_a_in_class_ank var3 = var0[var2];
				e[var3.a()] = var3;
			}

		}
	}
}
