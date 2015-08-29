package net.minecraft.server;


public class class_ame extends Block {
	public static final class_aqa a = class_aqa.a("variant", class_ame.class_a_in_class_ame.class);
	public static final int b;
	public static final int N;
	public static final int O;

	public class_ame() {
		super(class_avq.e);
		this.j(M.b().a(a, class_ame.class_a_in_class_ame.a));
		this.a(class_abp.b);
	}

	@Override
	public String f() {
		return class_di.a(this.a() + "." + class_ame.class_a_in_class_ame.a.c() + ".name");
	}

	@Override
	public class_avr g(class_apn var1) {
		return var1.b(a) == class_ame.class_a_in_class_ame.a ? class_avr.y : class_avr.G;
	}

	@Override
	public int a(class_apn var1) {
		return ((class_ame.class_a_in_class_ame) var1.b(a)).a();
	}

	@Override
	public int c(class_apn var1) {
		return ((class_ame.class_a_in_class_ame) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, class_ame.class_a_in_class_ame.a(var1));
	}

	static {
		b = class_ame.class_a_in_class_ame.a.a();
		N = class_ame.class_a_in_class_ame.b.a();
		O = class_ame.class_a_in_class_ame.c.a();
	}

	public static enum class_a_in_class_ame implements class_oe {
		a(0, "prismarine", "rough"),
		b(1, "prismarine_bricks", "bricks"),
		c(2, "dark_prismarine", "dark");

		private static final class_ame.class_a_in_class_ame[] d;
		private final int e;
		private final String f;
		private final String g;

		private class_a_in_class_ame(int var3, String var4, String var5) {
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

		public static class_ame.class_a_in_class_ame a(int var0) {
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
			d = new class_ame.class_a_in_class_ame[values().length];
			class_ame.class_a_in_class_ame[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ame.class_a_in_class_ame var3 = var0[var2];
				d[var3.a()] = var3;
			}

		}
	}
}
