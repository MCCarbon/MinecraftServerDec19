package net.minecraft.server;

import org.apache.commons.lang3.Validate;

public class class_nl {
	private final long[] a;
	private final int b;
	private final long c;
	private final int d;

	public class_nl(int var1, int var2) {
		Validate.inclusiveBetween(1L, 32L, var1);
		d = var2;
		b = var1;
		c = (1L << var1) - 1L;
		a = new long[MathHelper.c(var2 * var1, 64) / 64];
	}

	public void a(int var1, int var2) {
		Validate.inclusiveBetween(0L, d - 1, var1);
		Validate.inclusiveBetween(0L, c, var2);
		int var3 = var1 * b;
		int var4 = var3 / 64;
		int var5 = (((var1 + 1) * b) - 1) / 64;
		int var6 = var3 % 64;
		a[var4] = (a[var4] & ~(c << var6)) | ((var2 & c) << var6);
		if (var4 != var5) {
			int var7 = 64 - var6;
			a[var5] = ((a[var5] >>> var7) << var7) | ((var2 & c) >> var7);
		}

	}

	public int a(int var1) {
		Validate.inclusiveBetween(0L, d - 1, var1);
		int var2 = var1 * b;
		int var3 = var2 / 64;
		int var4 = (((var1 + 1) * b) - 1) / 64;
		int var5 = var2 % 64;
		if (var3 == var4) {
			return (int) ((a[var3] >>> var5) & c);
		} else {
			int var6 = 64 - var5;
			return (int) (((a[var3] >>> var5) | (a[var4] << var6)) & c);
		}
	}

	public long[] a() {
		return a;
	}

	public int c() {
		return b;
	}
}
