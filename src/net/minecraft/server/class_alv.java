package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_alv extends class_alg {
	public static final class_aqa b = class_aqa.a("variant", class_aly.class_a_in_class_aly.class, new Predicate() {
		public boolean a(class_aly.class_a_in_class_aly var1) {
			return var1.a() < 4;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_aly.class_a_in_class_aly) var1);
		}
	});

	public class_alv() {
		this.j(M.b().a(b, class_aly.class_a_in_class_aly.a).a(a, class_alg.class_a_in_class_alg.b));
	}

	@Override
	public class_avr g(class_apn var1) {
		class_aly.class_a_in_class_aly var2 = (class_aly.class_a_in_class_aly) var1.b(b);
		switch (class_alv.SyntheticClass_1.b[((class_alg.class_a_in_class_alg) var1.b(a)).ordinal()]) {
			case 1:
			case 2:
			case 3:
			default:
				switch (class_alv.SyntheticClass_1.a[var2.ordinal()]) {
					case 1:
					default:
						return class_aly.class_a_in_class_aly.b.c();
					case 2:
						return class_aly.class_a_in_class_aly.f.c();
					case 3:
						return class_avr.p;
					case 4:
						return class_aly.class_a_in_class_aly.b.c();
				}
			case 4:
				return var2.c();
		}
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = getBlockData().a(b, class_aly.class_a_in_class_aly.a((var1 & 3) % 4));
		switch (var1 & 12) {
			case 0:
				var2 = var2.a(a, class_alg.class_a_in_class_alg.b);
				break;
			case 4:
				var2 = var2.a(a, class_alg.class_a_in_class_alg.a);
				break;
			case 8:
				var2 = var2.a(a, class_alg.class_a_in_class_alg.c);
				break;
			default:
				var2 = var2.a(a, class_alg.class_a_in_class_alg.d);
		}

		return var2;
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_aly.class_a_in_class_aly) var1.b(b)).a();
		switch (class_alv.SyntheticClass_1.b[((class_alg.class_a_in_class_alg) var1.b(a)).ordinal()]) {
			case 1:
				var3 |= 4;
				break;
			case 2:
				var3 |= 8;
				break;
			case 3:
				var3 |= 12;
		}

		return var3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, a });
	}

	@Override
	protected class_aco i(class_apn var1) {
		return new class_aco(Item.a(this), 1, ((class_aly.class_a_in_class_aly) var1.b(b)).a());
	}

	@Override
	public int a(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(b)).a();
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[class_alg.class_a_in_class_alg.values().length];

		static {
			try {
				b[class_alg.class_a_in_class_alg.a.ordinal()] = 1;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[class_alg.class_a_in_class_alg.c.ordinal()] = 2;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				b[class_alg.class_a_in_class_alg.d.ordinal()] = 3;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[class_alg.class_a_in_class_alg.b.ordinal()] = 4;
			} catch (NoSuchFieldError var5) {
				;
			}

			a = new int[class_aly.class_a_in_class_aly.values().length];

			try {
				a[class_aly.class_a_in_class_aly.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.c.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.d.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
