package net.minecraft.server;

import java.util.Iterator;

public abstract class class_alg extends class_amr {
	public static final class_aqa a = class_aqa.a("axis", class_alg.class_a_in_class_alg.class);

	public class_alg() {
		super(class_avq.d);
		this.a(class_abp.b);
		this.c(2.0F);
		this.a(f);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		byte var4 = 4;
		int var5 = var4 + 1;
		if (var1.a(var2.a(-var5, -var5, -var5), var2.a(var5, var5, var5))) {
			Iterator var6 = class_cj.a(var2.a(-var4, -var4, -var4), var2.a(var4, var4, var4)).iterator();

			while (var6.hasNext()) {
				class_cj var7 = (class_cj) var6.next();
				class_apn var8 = var1.p(var7);
				if ((var8.c().v() == class_avq.j) && !((Boolean) var8.b(class_alc.b)).booleanValue()) {
					var1.a(var7, var8.a(class_alc.b, Boolean.valueOf(true)), 4);
				}
			}

		}
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return this.a(var7).a(a, class_alg.class_a_in_class_alg.a(var3.k()));
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_alg.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
				case 2:
					switch (class_alg.SyntheticClass_1.a[((class_alg.class_a_in_class_alg) var1.b(a)).ordinal()]) {
						case 1:
							return var1.a(a, class_alg.class_a_in_class_alg.c);
						case 2:
							return var1.a(a, class_alg.class_a_in_class_alg.a);
						default:
							return var1;
					}
				default:
					return var1;
			}
		}
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[class_cq.class_a_in_class_cq.values().length];

		static {
			try {
				c[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				c[class_cq.class_a_in_class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				c[class_cq.class_a_in_class_cq.c.ordinal()] = 3;
			} catch (NoSuchFieldError var5) {
				;
			}

			b = new int[class_ail.class_c_in_class_ail.values().length];

			try {
				b[class_ail.class_c_in_class_ail.d.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				b[class_ail.class_c_in_class_ail.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			a = new int[class_alg.class_a_in_class_alg.values().length];

			try {
				a[class_alg.class_a_in_class_alg.a.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_alg.class_a_in_class_alg.c.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_alg implements class_oe {
		a("x"),
		b("y"),
		c("z"),
		d("none");

		private final String e;

		private class_a_in_class_alg(String var3) {
			e = var3;
		}

		@Override
		public String toString() {
			return e;
		}

		public static class_alg.class_a_in_class_alg a(class_cq.class_a_in_class_cq var0) {
			switch (class_alg.SyntheticClass_1.c[var0.ordinal()]) {
				case 1:
					return a;
				case 2:
					return b;
				case 3:
					return c;
				default:
					return d;
			}
		}

		@Override
		public String l() {
			return e;
		}
	}
}
