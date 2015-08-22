package net.minecraft.server;

public class class_nu {
	private transient class_nu.class_a_in_class_nu[] a = new class_nu.class_a_in_class_nu[16];
	private transient int b;
	private int c = 12;
	private final float d = 0.75F;

	private static int g(int var0) {
		var0 ^= (var0 >>> 20) ^ (var0 >>> 12);
		return var0 ^ (var0 >>> 7) ^ (var0 >>> 4);
	}

	private static int a(int var0, int var1) {
		return var0 & (var1 - 1);
	}

	public Object a(int var1) {
		int var2 = g(var1);

		for (class_nu.class_a_in_class_nu var3 = a[a(var2, a.length)]; var3 != null; var3 = var3.c) {
			if (var3.a == var1) {
				return var3.b;
			}
		}

		return null;
	}

	public boolean b(int var1) {
		return this.c(var1) != null;
	}

	final class_nu.class_a_in_class_nu c(int var1) {
		int var2 = g(var1);

		for (class_nu.class_a_in_class_nu var3 = a[a(var2, a.length)]; var3 != null; var3 = var3.c) {
			if (var3.a == var1) {
				return var3;
			}
		}

		return null;
	}

	public void a(int var1, Object var2) {
		int var3 = g(var1);
		int var4 = a(var3, a.length);

		for (class_nu.class_a_in_class_nu var5 = a[var4]; var5 != null; var5 = var5.c) {
			if (var5.a == var1) {
				var5.b = var2;
				return;
			}
		}

		this.a(var3, var1, var2, var4);
	}

	private void h(int var1) {
		class_nu.class_a_in_class_nu[] var2 = a;
		int var3 = var2.length;
		if (var3 == 1073741824) {
			c = Integer.MAX_VALUE;
		} else {
			class_nu.class_a_in_class_nu[] var4 = new class_nu.class_a_in_class_nu[var1];
			this.a(var4);
			a = var4;
			c = (int) (var1 * d);
		}
	}

	private void a(class_nu.class_a_in_class_nu[] var1) {
		class_nu.class_a_in_class_nu[] var2 = a;
		int var3 = var1.length;

		for (int var4 = 0; var4 < var2.length; ++var4) {
			class_nu.class_a_in_class_nu var5 = var2[var4];
			if (var5 != null) {
				var2[var4] = null;

				class_nu.class_a_in_class_nu var6;
				do {
					var6 = var5.c;
					int var7 = a(var5.d, var3);
					var5.c = var1[var7];
					var1[var7] = var5;
					var5 = var6;
				} while (var6 != null);
			}
		}

	}

	public Object d(int var1) {
		class_nu.class_a_in_class_nu var2 = e(var1);
		return var2 == null ? null : var2.b;
	}

	final class_nu.class_a_in_class_nu e(int var1) {
		int var2 = g(var1);
		int var3 = a(var2, a.length);
		class_nu.class_a_in_class_nu var4 = a[var3];

		class_nu.class_a_in_class_nu var5;
		class_nu.class_a_in_class_nu var6;
		for (var5 = var4; var5 != null; var5 = var6) {
			var6 = var5.c;
			if (var5.a == var1) {
				--b;
				if (var4 == var5) {
					a[var3] = var6;
				} else {
					var4.c = var6;
				}

				return var5;
			}

			var4 = var5;
		}

		return var5;
	}

	public void c() {
		class_nu.class_a_in_class_nu[] var1 = a;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			var1[var2] = null;
		}

		b = 0;
	}

	private void a(int var1, int var2, Object var3, int var4) {
		class_nu.class_a_in_class_nu var5 = a[var4];
		a[var4] = new class_nu.class_a_in_class_nu(var1, var2, var3, var5);
		if (b++ >= c) {
			h(2 * a.length);
		}

	}

	static class class_a_in_class_nu {
		final int a;
		Object b;
		class_nu.class_a_in_class_nu c;
		final int d;

		class_a_in_class_nu(int var1, int var2, Object var3, class_nu.class_a_in_class_nu var4) {
			b = var3;
			c = var4;
			a = var2;
			d = var1;
		}

		public final int a() {
			return a;
		}

		public final Object b() {
			return b;
		}

		@Override
		public final boolean equals(Object var1) {
			if (!(var1 instanceof class_nu.class_a_in_class_nu)) {
				return false;
			} else {
				class_nu.class_a_in_class_nu var2 = (class_nu.class_a_in_class_nu) var1;
				Integer var3 = Integer.valueOf(this.a());
				Integer var4 = Integer.valueOf(var2.a());
				if ((var3 == var4) || ((var3 != null) && var3.equals(var4))) {
					Object var5 = this.b();
					Object var6 = var2.b();
					if ((var5 == var6) || ((var5 != null) && var5.equals(var6))) {
						return true;
					}
				}

				return false;
			}
		}

		@Override
		public final int hashCode() {
			return class_nu.g(a);
		}

		@Override
		public final String toString() {
			return this.a() + "=" + this.b();
		}
	}
}
