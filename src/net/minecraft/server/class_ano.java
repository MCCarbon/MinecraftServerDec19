package net.minecraft.server;

import java.util.Random;

public class class_ano extends class_aiq implements class_ain {
	public static final class_aqa a = class_aqa.a("type", class_ano.class_a_in_class_ano.class);

	protected class_ano() {
		super(class_avq.l);
		this.j(M.b().a(a, class_ano.class_a_in_class_ano.a));
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	@Override
	public boolean g(class_ago var1, class_cj var2, class_apn var3) {
		return this.c(var1.p(var2.b()).c());
	}

	@Override
	public boolean a(class_ago var1, class_cj var2) {
		return true;
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return var2.nextInt(8) == 0 ? class_acq.P : null;
	}

	@Override
	public int a(int var1, Random var2) {
		return 1 + var2.nextInt((var1 * 2) + 1);
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, class_aoi var5, class_aco var6) {
		if (!var1.D && (var6 != null) && (var6.b() == class_acq.bg)) {
			var2.b(class_nh.a(class_ail.a(this)));
			a(var1, var3, new class_aco(class_aim.H, 1, ((class_ano.class_a_in_class_ano) var4.b(a)).a()));
		} else {
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(this, 1, var3.c().c(var3));
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		return var3.b(a) != class_ano.class_a_in_class_ano.a;
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		return true;
	}

	@Override
	public void b(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		class_ajo.class_b_in_class_ajo var5 = class_ajo.class_b_in_class_ajo.c;
		if (var4.b(a) == class_ano.class_a_in_class_ano.c) {
			var5 = class_ajo.class_b_in_class_ajo.d;
		}

		if (class_aim.cF.c(var1, var3)) {
			class_aim.cF.a(var1, var3, var5, 2);
		}

	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_ano.class_a_in_class_ano.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_ano.class_a_in_class_ano) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	public static enum class_a_in_class_ano implements class_oe {
		a(0, "dead_bush"),
		b(1, "tall_grass"),
		c(2, "fern");

		private static final class_ano.class_a_in_class_ano[] d;
		private final int e;
		private final String f;

		private class_a_in_class_ano(int var3, String var4) {
			e = var3;
			f = var4;
		}

		public int a() {
			return e;
		}

		@Override
		public String toString() {
			return f;
		}

		public static class_ano.class_a_in_class_ano a(int var0) {
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
			d = new class_ano.class_a_in_class_ano[values().length];
			class_ano.class_a_in_class_ano[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ano.class_a_in_class_ano var3 = var0[var2];
				d[var3.a()] = var3;
			}

		}
	}
}
