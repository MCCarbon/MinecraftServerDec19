package net.minecraft.server;

import java.util.Iterator;

import com.google.common.collect.AbstractIterator;

public class class_cj extends class_df {
	public static final class_cj a = new class_cj(0, 0, 0);
	private static final int c = 1 + class_oa.d(class_oa.b(30000000));
	private static final int d;
	private static final int e;
	private static final int f;
	private static final int g;
	private static final long h;
	private static final long i;
	private static final long j;

	public class_cj(int var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	public class_cj(double var1, double var3, double var5) {
		super(var1, var3, var5);
	}

	public class_cj(class_qx var1) {
		this(var1.s, var1.t, var1.u);
	}

	public class_cj(class_aym var1) {
		this(var1.a, var1.b, var1.c);
	}

	public class_cj(class_df var1) {
		this(var1.n(), var1.o(), var1.p());
	}

	public class_cj a(double var1, double var3, double var5) {
		return (var1 == 0.0D) && (var3 == 0.0D) && (var5 == 0.0D) ? this : new class_cj(n() + var1, o() + var3, p() + var5);
	}

	public class_cj a(int var1, int var2, int var3) {
		return (var1 == 0) && (var2 == 0) && (var3 == 0) ? this : new class_cj(n() + var1, o() + var2, p() + var3);
	}

	public class_cj a(class_df var1) {
		return (var1.n() == 0) && (var1.o() == 0) && (var1.p() == 0) ? this : new class_cj(n() + var1.n(), o() + var1.o(), p() + var1.p());
	}

	public class_cj b(class_df var1) {
		return (var1.n() == 0) && (var1.o() == 0) && (var1.p() == 0) ? this : new class_cj(n() - var1.n(), o() - var1.o(), p() - var1.p());
	}

	public class_cj a() {
		return this.b(1);
	}

	public class_cj b(int var1) {
		return this.a(class_cq.b, var1);
	}

	public class_cj b() {
		return this.c(1);
	}

	public class_cj c(int var1) {
		return this.a(class_cq.a, var1);
	}

	public class_cj c() {
		return this.d(1);
	}

	public class_cj d(int var1) {
		return this.a(class_cq.c, var1);
	}

	public class_cj d() {
		return this.e(1);
	}

	public class_cj e(int var1) {
		return this.a(class_cq.d, var1);
	}

	public class_cj e() {
		return this.f(1);
	}

	public class_cj f(int var1) {
		return this.a(class_cq.e, var1);
	}

	public class_cj f() {
		return this.g(1);
	}

	public class_cj g(int var1) {
		return this.a(class_cq.f, var1);
	}

	public class_cj a(class_cq var1) {
		return this.a(var1, 1);
	}

	public class_cj a(class_cq var1, int var2) {
		return var2 == 0 ? this : new class_cj(n() + (var1.g() * var2), o() + (var1.h() * var2), p() + (var1.i() * var2));
	}

	public class_cj c(class_df var1) {
		return new class_cj((o() * var1.p()) - (p() * var1.o()), (p() * var1.n()) - (n() * var1.p()), (n() * var1.o()) - (o() * var1.n()));
	}

	public long g() {
		return ((n() & h) << g) | ((o() & i) << f) | ((p() & j) << 0);
	}

	public static class_cj a(long var0) {
		int var2 = (int) ((var0 << (64 - g - c)) >> (64 - c));
		int var3 = (int) ((var0 << (64 - f - e)) >> (64 - e));
		int var4 = (int) ((var0 << (64 - d)) >> (64 - d));
		return new class_cj(var2, var3, var4);
	}

	public static Iterable a(class_cj var0, class_cj var1) {
		final class_cj var2 = new class_cj(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
		final class_cj var3 = new class_cj(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
		return new Iterable() {
			@Override
			public Iterator iterator() {
				return new AbstractIterator() {
					private class_cj b = null;

					protected class_cj a() {
						if (b == null) {
							b = var2;
							return b;
						} else if (b.equals(var3)) {
							return (class_cj) endOfData();
						} else {
							int var1 = b.n();
							int var2x = b.o();
							int var3x = b.p();
							if (var1 < var3.n()) {
								++var1;
							} else if (var2x < var3.o()) {
								var1 = var2.n();
								++var2x;
							} else if (var3x < var3.p()) {
								var1 = var2.n();
								var2x = var2.o();
								++var3x;
							}

							b = new class_cj(var1, var2x, var3x);
							return b;
						}
					}

					// $FF: synthetic method
					@Override
					protected Object computeNext() {
						return this.a();
					}
				};
			}
		};
	}

	public static Iterable b(class_cj var0, class_cj var1) {
		final class_cj var2 = new class_cj(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
		final class_cj var3 = new class_cj(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
		return new Iterable() {
			@Override
			public Iterator iterator() {
				return new AbstractIterator() {
					private class_cj.class_a_in_class_cj b = null;

					protected class_cj.class_a_in_class_cj a() {
						if (b == null) {
							b = new class_cj.class_a_in_class_cj(var2.n(), var2.o(), var2.p());
							return b;
						} else if (b.equals(var3)) {
							return (class_cj.class_a_in_class_cj) endOfData();
						} else {
							int var1 = b.n();
							int var2x = b.o();
							int var3x = b.p();
							if (var1 < var3.n()) {
								++var1;
							} else if (var2x < var3.o()) {
								var1 = var2.n();
								++var2x;
							} else if (var3x < var3.p()) {
								var1 = var2.n();
								var2x = var2.o();
								++var3x;
							}

							b.c = var1;
							b.d = var2x;
							b.e = var3x;
							return b;
						}
					}

					// $FF: synthetic method
					@Override
					protected Object computeNext() {
						return this.a();
					}
				};
			}
		};
	}

	// $FF: synthetic method
	@Override
	public class_df d(class_df var1) {
		return this.c(var1);
	}

	static {
		d = c;
		e = 64 - c - d;
		f = 0 + d;
		g = f + e;
		h = (1L << c) - 1L;
		i = (1L << e) - 1L;
		j = (1L << d) - 1L;
	}

	public static final class class_a_in_class_cj extends class_cj {
		private int c;
		private int d;
		private int e;

		public class_a_in_class_cj() {
			this(0, 0, 0);
		}

		public class_a_in_class_cj(class_cj var1) {
			this(var1.n(), var1.o(), var1.p());
		}

		public class_a_in_class_cj(int var1, int var2, int var3) {
			super(0, 0, 0);
			c = var1;
			d = var2;
			e = var3;
		}

		@Override
		public int n() {
			return c;
		}

		@Override
		public int o() {
			return d;
		}

		@Override
		public int p() {
			return e;
		}

		public class_cj.class_a_in_class_cj c(int var1, int var2, int var3) {
			c = var1;
			d = var2;
			e = var3;
			return this;
		}

		public void c(class_cq var1) {
			c += var1.g();
			d += var1.h();
			e += var1.i();
		}

		// $FF: synthetic method
		@Override
		public class_df d(class_df var1) {
			return super.c(var1);
		}
	}
}
