package net.minecraft.server;

import java.util.Iterator;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class class_apr {
	private final Predicate[][][] a;
	private final int b;
	private final int c;
	private final int d;

	public class_apr(Predicate[][][] var1) {
		a = var1;
		b = var1.length;
		if (b > 0) {
			c = var1[0].length;
			if (c > 0) {
				d = var1[0][0].length;
			} else {
				d = 0;
			}
		} else {
			c = 0;
			d = 0;
		}

	}

	public int a() {
		return b;
	}

	public int b() {
		return c;
	}

	public int c() {
		return d;
	}

	private class_apr.class_b_in_class_apr a(class_cj var1, class_cq var2, class_cq var3, LoadingCache var4) {
		for (int var5 = 0; var5 < d; ++var5) {
			for (int var6 = 0; var6 < c; ++var6) {
				for (int var7 = 0; var7 < b; ++var7) {
					if (!a[var7][var6][var5].apply(var4.getUnchecked(a(var1, var2, var3, var5, var6, var7)))) {
						return null;
					}
				}
			}
		}

		return new class_apr.class_b_in_class_apr(var1, var2, var3, var4, d, c, b);
	}

	public class_apr.class_b_in_class_apr a(class_ago var1, class_cj var2) {
		LoadingCache var3 = a(var1, false);
		int var4 = Math.max(Math.max(d, c), b);
		Iterator var5 = class_cj.a(var2, var2.a(var4 - 1, var4 - 1, var4 - 1)).iterator();

		while (var5.hasNext()) {
			class_cj var6 = (class_cj) var5.next();
			class_cq[] var7 = class_cq.values();
			int var8 = var7.length;

			for (int var9 = 0; var9 < var8; ++var9) {
				class_cq var10 = var7[var9];
				class_cq[] var11 = class_cq.values();
				int var12 = var11.length;

				for (int var13 = 0; var13 < var12; ++var13) {
					class_cq var14 = var11[var13];
					if ((var14 != var10) && (var14 != var10.d())) {
						class_apr.class_b_in_class_apr var15 = this.a(var6, var10, var14, var3);
						if (var15 != null) {
							return var15;
						}
					}
				}
			}
		}

		return null;
	}

	public static LoadingCache a(class_ago var0, boolean var1) {
		return CacheBuilder.newBuilder().build(new class_apr.class_a_in_class_apr(var0, var1));
	}

	protected static class_cj a(class_cj var0, class_cq var1, class_cq var2, int var3, int var4, int var5) {
		if ((var1 != var2) && (var1 != var2.d())) {
			class_df var6 = new class_df(var1.g(), var1.h(), var1.i());
			class_df var7 = new class_df(var2.g(), var2.h(), var2.i());
			class_df var8 = var6.d(var7);
			return var0.a((var7.n() * -var4) + (var8.n() * var3) + (var6.n() * var5), (var7.o() * -var4) + (var8.o() * var3) + (var6.o() * var5), (var7.p() * -var4) + (var8.p() * var3) + (var6.p() * var5));
		} else {
			throw new IllegalArgumentException("Invalid forwards & up combination");
		}
	}

	public static class class_b_in_class_apr {
		private final class_cj a;
		private final class_cq b;
		private final class_cq c;
		private final LoadingCache d;
		private final int e;
		private final int f;
		private final int g;

		public class_b_in_class_apr(class_cj var1, class_cq var2, class_cq var3, LoadingCache var4, int var5, int var6, int var7) {
			a = var1;
			b = var2;
			c = var3;
			d = var4;
			e = var5;
			f = var6;
			g = var7;
		}

		public class_cj a() {
			return a;
		}

		public class_cq b() {
			return b;
		}

		public class_cq c() {
			return c;
		}

		public int d() {
			return e;
		}

		public int e() {
			return f;
		}

		public class_apq a(int var1, int var2, int var3) {
			return (class_apq) d.getUnchecked(class_apr.a(a, b(), c(), var1, var2, var3));
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("up", c).add("forwards", b).add("frontTopLeft", a).toString();
		}
	}

	static class class_a_in_class_apr extends CacheLoader {
		private final class_ago a;
		private final boolean b;

		public class_a_in_class_apr(class_ago var1, boolean var2) {
			a = var1;
			b = var2;
		}

		public class_apq a(class_cj var1) throws Exception {
			return new class_apq(a, var1, b);
		}

		// $FF: synthetic method
		@Override
		public Object load(Object var1) throws Exception {
			return this.a((class_cj) var1);
		}
	}
}
