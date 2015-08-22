package net.minecraft.server;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public abstract class class_ake extends class_aiq {
	protected class_aqa a;

	protected class_ake() {
		this.j(M.b().a(n(), l() == class_ake.class_b_in_class_ake.b ? class_ake.class_a_in_class_ake.b : class_ake.class_a_in_class_ake.a));
	}

	@Override
	public int a(class_apn var1) {
		return ((class_ake.class_a_in_class_ake) var1.b(n())).b();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(n(), class_ake.class_a_in_class_ake.a(l(), var1));
	}

	public abstract class_ake.class_b_in_class_ake l();

	public class_aqc n() {
		if (a == null) {
			a = class_aqa.a("type", class_ake.class_a_in_class_ake.class, new Predicate() {
				public boolean a(class_ake.class_a_in_class_ake var1) {
					return var1.a() == class_ake.this.l();
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((class_ake.class_a_in_class_ake) var1);
				}
			});
		}

		return a;
	}

	@Override
	public int c(class_apn var1) {
		return ((class_ake.class_a_in_class_ake) var1.b(n())).b();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { n() });
	}

	public static enum class_a_in_class_ake implements class_oe {
		a(class_ake.class_b_in_class_ake.a, 0, "dandelion"),
		b(class_ake.class_b_in_class_ake.b, 0, "poppy"),
		c(class_ake.class_b_in_class_ake.b, 1, "blue_orchid", "blueOrchid"),
		d(class_ake.class_b_in_class_ake.b, 2, "allium"),
		e(class_ake.class_b_in_class_ake.b, 3, "houstonia"),
		f(class_ake.class_b_in_class_ake.b, 4, "red_tulip", "tulipRed"),
		g(class_ake.class_b_in_class_ake.b, 5, "orange_tulip", "tulipOrange"),
		h(class_ake.class_b_in_class_ake.b, 6, "white_tulip", "tulipWhite"),
		i(class_ake.class_b_in_class_ake.b, 7, "pink_tulip", "tulipPink"),
		j(class_ake.class_b_in_class_ake.b, 8, "oxeye_daisy", "oxeyeDaisy");

		private static final class_ake.class_a_in_class_ake[][] k;
		private final class_ake.class_b_in_class_ake l;
		private final int m;
		private final String n;
		private final String o;

		private class_a_in_class_ake(class_ake.class_b_in_class_ake var3, int var4, String var5) {
			this(var3, var4, var5, var5);
		}

		private class_a_in_class_ake(class_ake.class_b_in_class_ake var3, int var4, String var5, String var6) {
			l = var3;
			m = var4;
			n = var5;
			o = var6;
		}

		public class_ake.class_b_in_class_ake a() {
			return l;
		}

		public int b() {
			return m;
		}

		public static class_ake.class_a_in_class_ake a(class_ake.class_b_in_class_ake var0, int var1) {
			class_ake.class_a_in_class_ake[] var2 = k[var0.ordinal()];
			if ((var1 < 0) || (var1 >= var2.length)) {
				var1 = 0;
			}

			return var2[var1];
		}

		@Override
		public String toString() {
			return n;
		}

		@Override
		public String l() {
			return n;
		}

		public String d() {
			return o;
		}

		static {
			k = new class_ake.class_a_in_class_ake[class_ake.class_b_in_class_ake.values().length][];
			class_ake.class_b_in_class_ake[] var0 = class_ake.class_b_in_class_ake.values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				final class_ake.class_b_in_class_ake var3 = var0[var2];
				Collection var4 = Collections2.filter(Lists.newArrayList((Object[]) values()), new Predicate() {
					public boolean a(class_ake.class_a_in_class_ake var1) {
						return var1.a() == var3;
					}

					// $FF: synthetic method
					@Override
					public boolean apply(Object var1) {
						return this.a((class_ake.class_a_in_class_ake) var1);
					}
				});
				k[var3.ordinal()] = (class_ake.class_a_in_class_ake[]) var4.toArray(new class_ake.class_a_in_class_ake[var4.size()]);
			}

		}
	}

	public static enum class_b_in_class_ake {
		a,
		b;

		public class_ake a() {
			return this == a ? class_aim.N : class_aim.O;
		}
	}
}
