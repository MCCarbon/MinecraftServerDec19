package net.minecraft.server;

import java.util.Random;

public abstract class class_anm extends class_akq {
	public static final class_apy b = class_apy.a("seamless");
	public static final class_aqa N = class_aqa.a("variant", class_anm.class_a_in_class_anm.class);

	public class_anm() {
		super(class_avq.e);
		class_apn var1 = M.b();
		if (l()) {
			var1 = var1.a(b, Boolean.valueOf(false));
		} else {
			var1 = var1.a(a, class_akq.class_a_in_class_akq.b);
		}

		this.j(var1.a(N, class_anm.class_a_in_class_anm.a));
		this.a(class_abp.b);
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acm.a(class_aim.U);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_aim.U, 1, ((class_anm.class_a_in_class_anm) var3.b(N)).a());
	}

	@Override
	public String b(int var1) {
		return super.a() + "." + class_anm.class_a_in_class_anm.a(var1).d();
	}

	@Override
	public class_aqc n() {
		return N;
	}

	@Override
	public Object a(class_aco var1) {
		return class_anm.class_a_in_class_anm.a(var1.i() & 7);
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = S().a(N, class_anm.class_a_in_class_anm.a(var1 & 7));
		if (l()) {
			var2 = var2.a(b, Boolean.valueOf((var1 & 8) != 0));
		} else {
			var2 = var2.a(a, (var1 & 8) == 0 ? class_akq.class_a_in_class_akq.b : class_akq.class_a_in_class_akq.a);
		}

		return var2;
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_anm.class_a_in_class_anm) var1.b(N)).a();
		if (l()) {
			if (((Boolean) var1.b(b)).booleanValue()) {
				var3 |= 8;
			}
		} else if (var1.b(a) == class_akq.class_a_in_class_akq.a) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	protected class_apo e() {
		return l() ? new class_apo(this, new class_aqc[] { b, N }) : new class_apo(this, new class_aqc[] { a, N });
	}

	@Override
	public int a(class_apn var1) {
		return ((class_anm.class_a_in_class_anm) var1.b(N)).a();
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_anm.class_a_in_class_anm) var1.b(N)).c();
	}

	public static enum class_a_in_class_anm implements class_oe {
		a(0, class_avr.m, "stone"),
		b(1, class_avr.d, "sandstone", "sand"),
		c(2, class_avr.o, "wood_old", "wood"),
		d(3, class_avr.m, "cobblestone", "cobble"),
		e(4, class_avr.D, "brick"),
		f(5, class_avr.m, "stone_brick", "smoothStoneBrick"),
		g(6, class_avr.K, "nether_brick", "netherBrick"),
		h(7, class_avr.p, "quartz");

		private static final class_anm.class_a_in_class_anm[] i;
		private final int j;
		private final class_avr k;
		private final String l;
		private final String m;

		private class_a_in_class_anm(int var3, class_avr var4, String var5) {
			this(var3, var4, var5, var5);
		}

		private class_a_in_class_anm(int var3, class_avr var4, String var5, String var6) {
			j = var3;
			k = var4;
			l = var5;
			m = var6;
		}

		public int a() {
			return j;
		}

		public class_avr c() {
			return k;
		}

		@Override
		public String toString() {
			return l;
		}

		public static class_anm.class_a_in_class_anm a(int var0) {
			if ((var0 < 0) || (var0 >= i.length)) {
				var0 = 0;
			}

			return i[var0];
		}

		@Override
		public String l() {
			return l;
		}

		public String d() {
			return m;
		}

		static {
			i = new class_anm.class_a_in_class_anm[values().length];
			class_anm.class_a_in_class_anm[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_anm.class_a_in_class_anm var3 = var0[var2];
				i[var3.a()] = var3;
			}

		}
	}
}
