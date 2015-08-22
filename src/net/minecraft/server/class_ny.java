package net.minecraft.server;

public class class_ny {
	private transient class_ny.class_a_in_class_ny[] a = new class_ny.class_a_in_class_ny[4096];
	private transient int b;
	private int c;
	private int d = 3072;
	private final float e = 0.75F;
	private transient volatile int f;

	public class_ny() {
		c = a.length - 1;
	}

	private static int g(long var0) {
		return a((int) (var0 ^ (var0 >>> 32)));
	}

	private static int a(int var0) {
		var0 ^= (var0 >>> 20) ^ (var0 >>> 12);
		return var0 ^ (var0 >>> 7) ^ (var0 >>> 4);
	}

	private static int a(int var0, int var1) {
		return var0 & var1;
	}

	public int a() {
		return b;
	}

	public Object a(long var1) {
		int var3 = g(var1);

		for (class_ny.class_a_in_class_ny var4 = a[a(var3, c)]; var4 != null; var4 = var4.c) {
			if (var4.a == var1) {
				return var4.b;
			}
		}

		return null;
	}

	public boolean b(long var1) {
		return c(var1) != null;
	}

	final class_ny.class_a_in_class_ny c(long var1) {
		int var3 = g(var1);

		for (class_ny.class_a_in_class_ny var4 = a[a(var3, c)]; var4 != null; var4 = var4.c) {
			if (var4.a == var1) {
				return var4;
			}
		}

		return null;
	}

	public void a(long var1, Object var3) {
		int var4 = g(var1);
		int var5 = a(var4, c);

		for (class_ny.class_a_in_class_ny var6 = a[var5]; var6 != null; var6 = var6.c) {
			if (var6.a == var1) {
				var6.b = var3;
				return;
			}
		}

		++f;
		this.a(var4, var1, var3, var5);
	}

	private void b(int var1) {
		class_ny.class_a_in_class_ny[] var2 = a;
		int var3 = var2.length;
		if (var3 == 1073741824) {
			d = Integer.MAX_VALUE;
		} else {
			class_ny.class_a_in_class_ny[] var4 = new class_ny.class_a_in_class_ny[var1];
			this.a(var4);
			a = var4;
			c = a.length - 1;
			d = (int) (var1 * e);
		}
	}

	private void a(class_ny.class_a_in_class_ny[] var1) {
		class_ny.class_a_in_class_ny[] var2 = a;
		int var3 = var1.length;

		for (int var4 = 0; var4 < var2.length; ++var4) {
			class_ny.class_a_in_class_ny var5 = var2[var4];
			if (var5 != null) {
				var2[var4] = null;

				class_ny.class_a_in_class_ny var6;
				do {
					var6 = var5.c;
					int var7 = a(var5.d, var3 - 1);
					var5.c = var1[var7];
					var1[var7] = var5;
					var5 = var6;
				} while (var6 != null);
			}
		}

	}

	public Object d(long var1) {
		class_ny.class_a_in_class_ny var3 = e(var1);
		return var3 == null ? null : var3.b;
	}

	final class_ny.class_a_in_class_ny e(long var1) {
		int var3 = g(var1);
		int var4 = a(var3, c);
		class_ny.class_a_in_class_ny var5 = a[var4];

		class_ny.class_a_in_class_ny var6;
		class_ny.class_a_in_class_ny var7;
		for (var6 = var5; var6 != null; var6 = var7) {
			var7 = var6.c;
			if (var6.a == var1) {
				++f;
				--b;
				if (var5 == var6) {
					a[var4] = var7;
				} else {
					var5.c = var7;
				}

				return var6;
			}

			var5 = var6;
		}

		return var6;
	}

	private void a(int var1, long var2, Object var4, int var5) {
		class_ny.class_a_in_class_ny var6 = a[var5];
		a[var5] = new class_ny.class_a_in_class_ny(var1, var2, var4, var6);
		if (b++ >= d) {
			this.b(2 * a.length);
		}

	}

	static class class_a_in_class_ny {
		final long a;
		Object b;
		class_ny.class_a_in_class_ny c;
		final int d;

		class_a_in_class_ny(int var1, long var2, Object var4, class_ny.class_a_in_class_ny var5) {
			b = var4;
			c = var5;
			a = var2;
			d = var1;
		}

		public final long a() {
			return a;
		}

		public final Object b() {
			return b;
		}

		@Override
		public final boolean equals(Object var1) {
			if (!(var1 instanceof class_ny.class_a_in_class_ny)) {
				return false;
			} else {
				class_ny.class_a_in_class_ny var2 = (class_ny.class_a_in_class_ny) var1;
				Long var3 = Long.valueOf(this.a());
				Long var4 = Long.valueOf(var2.a());
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
			return class_ny.g(a);
		}

		@Override
		public final String toString() {
			return this.a() + "=" + this.b();
		}
	}
}
