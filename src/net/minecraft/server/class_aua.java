package net.minecraft.server;

import com.google.common.base.Objects;

public class class_aua {
	public int a;
	public int b;
	public int c;
	public int d;
	public int e;
	public int f;

	public class_aua() {
	}

	public class_aua(int[] var1) {
		if (var1.length == 6) {
			a = var1[0];
			b = var1[1];
			c = var1[2];
			d = var1[3];
			e = var1[4];
			f = var1[5];
		}

	}

	public static class_aua a() {
		return new class_aua(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
	}

	public static class_aua a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class_cq var9) {
		switch (class_aua.SyntheticClass_1.a[var9.ordinal()]) {
			case 1:
				return new class_aua(var0 + var3, var1 + var4, (var2 - var8) + 1 + var5, ((var0 + var6) - 1) + var3, ((var1 + var7) - 1) + var4, var2 + var5);
			case 2:
				return new class_aua(var0 + var3, var1 + var4, var2 + var5, ((var0 + var6) - 1) + var3, ((var1 + var7) - 1) + var4, ((var2 + var8) - 1) + var5);
			case 3:
				return new class_aua((var0 - var8) + 1 + var5, var1 + var4, var2 + var3, var0 + var5, ((var1 + var7) - 1) + var4, ((var2 + var6) - 1) + var3);
			case 4:
				return new class_aua(var0 + var5, var1 + var4, var2 + var3, ((var0 + var8) - 1) + var5, ((var1 + var7) - 1) + var4, ((var2 + var6) - 1) + var3);
			default:
				return new class_aua(var0 + var3, var1 + var4, var2 + var5, ((var0 + var6) - 1) + var3, ((var1 + var7) - 1) + var4, ((var2 + var8) - 1) + var5);
		}
	}

	public static class_aua a(int var0, int var1, int var2, int var3, int var4, int var5) {
		return new class_aua(Math.min(var0, var3), Math.min(var1, var4), Math.min(var2, var5), Math.max(var0, var3), Math.max(var1, var4), Math.max(var2, var5));
	}

	public class_aua(class_aua var1) {
		a = var1.a;
		b = var1.b;
		c = var1.c;
		d = var1.d;
		e = var1.e;
		f = var1.f;
	}

	public class_aua(int var1, int var2, int var3, int var4, int var5, int var6) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
		e = var5;
		f = var6;
	}

	public class_aua(class_df var1, class_df var2) {
		a = Math.min(var1.n(), var2.n());
		b = Math.min(var1.o(), var2.o());
		c = Math.min(var1.p(), var2.p());
		d = Math.max(var1.n(), var2.n());
		e = Math.max(var1.o(), var2.o());
		f = Math.max(var1.p(), var2.p());
	}

	public class_aua(int var1, int var2, int var3, int var4) {
		a = var1;
		c = var2;
		d = var3;
		f = var4;
		b = 1;
		e = 512;
	}

	public boolean a(class_aua var1) {
		return (d >= var1.a) && (a <= var1.d) && (f >= var1.c) && (c <= var1.f) && (e >= var1.b) && (b <= var1.e);
	}

	public boolean a(int var1, int var2, int var3, int var4) {
		return (d >= var1) && (a <= var3) && (f >= var2) && (c <= var4);
	}

	public void b(class_aua var1) {
		a = Math.min(a, var1.a);
		b = Math.min(b, var1.b);
		c = Math.min(c, var1.c);
		d = Math.max(d, var1.d);
		e = Math.max(e, var1.e);
		f = Math.max(f, var1.f);
	}

	public void a(int var1, int var2, int var3) {
		a += var1;
		b += var2;
		c += var3;
		d += var1;
		e += var2;
		f += var3;
	}

	public boolean b(class_df var1) {
		return (var1.n() >= a) && (var1.n() <= d) && (var1.p() >= c) && (var1.p() <= f) && (var1.o() >= b) && (var1.o() <= e);
	}

	public class_df b() {
		return new class_df(d - a, e - b, f - c);
	}

	public int c() {
		return (d - a) + 1;
	}

	public int d() {
		return (e - b) + 1;
	}

	public int e() {
		return (f - c) + 1;
	}

	public class_df f() {
		return new class_cj(a + (((d - a) + 1) / 2), b + (((e - b) + 1) / 2), c + (((f - c) + 1) / 2));
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("x0", a).add("y0", b).add("z0", c).add("x1", d).add("y1", e).add("z1", f).toString();
	}

	public class_ds g() {
		return new class_ds(new int[] { a, b, c, d, e, f });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
