package net.minecraft.server;


public class class_ane extends class_anp {
	public static final class_aqa a = class_aqa.a("color", class_abt.class);

	public class_ane() {
		super(class_avq.s, false);
		this.j(M.b().a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(a, class_abt.a));
		this.a(class_abp.c);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_abt) var1.b(a)).a();
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_abt) var1.b(a)).e();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_abt.b(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_abt) var1.b(a)).a();
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_ane.SyntheticClass_1.a[var2.ordinal()]) {
				case 1:
					return var1.a(b, var1.b(O)).a(N, var1.b(P)).a(O, var1.b(b)).a(P, var1.b(N));
				case 2:
					return var1.a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(P)).a(P, var1.b(b));
				case 3:
					return var1.a(b, var1.b(P)).a(N, var1.b(b)).a(O, var1.b(N)).a(P, var1.b(O));
				default:
					return var1;
			}
		}
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_a_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_ane.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					return var1.a(b, var1.b(O)).a(O, var1.b(b));
				case 2:
					return var1.a(N, var1.b(P)).a(P, var1.b(N));
				default:
					return super.a(var1, var2);
			}
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, N, P, O, a });
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			class_aii.e(var1, var2);
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			class_aii.e(var1, var2);
		}

	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[class_ail.class_a_in_class_ail.values().length];

		static {
			try {
				b[class_ail.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[class_ail.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[class_ail.class_c_in_class_ail.values().length];

			try {
				a[class_ail.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_ail.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_ail.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
