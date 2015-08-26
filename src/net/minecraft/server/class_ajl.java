package net.minecraft.server;


public class class_ajl extends Block {
	public static final class_aqa a = class_aqa.a("variant", class_ajl.class_a_in_class_ajl.class);
	public static final class_apy b = class_apy.a("snowy");

	protected class_ajl() {
		super(class_avq.c);
		this.j(M.b().a(a, class_ajl.class_a_in_class_ajl.a).a(b, Boolean.valueOf(false)));
		this.a(class_abp.b);
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_ajl.class_a_in_class_ajl) var1.b(a)).d();
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		if (var1.b(a) == class_ajl.class_a_in_class_ajl.c) {
			Block var4 = var2.p(var3.a()).c();
			var1 = var1.a(b, Boolean.valueOf((var4 == Blocks.SNOW) || (var4 == Blocks.SNOW_LAYER)));
		}

		return var1;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(this, 1, ((class_ajl.class_a_in_class_ajl) var3.b(a)).a());
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_ajl.class_a_in_class_ajl.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_ajl.class_a_in_class_ajl) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}

	@Override
	public int a(class_apn var1) {
		class_ajl.class_a_in_class_ajl var2 = (class_ajl.class_a_in_class_ajl) var1.b(a);
		if (var2 == class_ajl.class_a_in_class_ajl.c) {
			var2 = class_ajl.class_a_in_class_ajl.a;
		}

		return var2.a();
	}

	public static enum class_a_in_class_ajl implements class_oe {
		a(0, "dirt", "default", class_avr.l),
		b(1, "coarse_dirt", "coarse", class_avr.l),
		c(2, "podzol", class_avr.J);

		private static final class_ajl.class_a_in_class_ajl[] d;
		private final int e;
		private final String f;
		private final String g;
		private final class_avr h;

		private class_a_in_class_ajl(int var3, String var4, class_avr var5) {
			this(var3, var4, var4, var5);
		}

		private class_a_in_class_ajl(int var3, String var4, String var5, class_avr var6) {
			e = var3;
			f = var4;
			g = var5;
			h = var6;
		}

		public int a() {
			return e;
		}

		public String c() {
			return g;
		}

		public class_avr d() {
			return h;
		}

		@Override
		public String toString() {
			return f;
		}

		public static class_ajl.class_a_in_class_ajl a(int var0) {
			if ((var0 < 0) || (var0 >= d.length)) {
				var0 = 0;
			}

			return d[var0];
		}

		@Override
		public String l() {
			return f;
		}

		static {
			d = new class_ajl.class_a_in_class_ajl[values().length];
			class_ajl.class_a_in_class_ajl[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ajl.class_a_in_class_ajl var3 = var0[var2];
				d[var3.a()] = var3;
			}

		}
	}
}
