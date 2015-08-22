package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_apq {
	private final class_ago a;
	private final class_cj b;
	private final boolean c;
	private class_apn d;
	private class_aoi e;
	private boolean f;

	public class_apq(class_ago var1, class_cj var2, boolean var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	public class_apn a() {
		if ((d == null) && (c || a.e(b))) {
			d = a.p(b);
		}

		return d;
	}

	public class_aoi b() {
		if ((e == null) && !f) {
			e = a.s(b);
			f = true;
		}

		return e;
	}

	public class_cj d() {
		return b;
	}

	public static Predicate a(final Predicate var0) {
		return new Predicate() {
			public boolean a(class_apq var1) {
				return (var1 != null) && var0.apply(var1.a());
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_apq) var1);
			}
		};
	}
}
