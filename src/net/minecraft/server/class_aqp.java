package net.minecraft.server;

public class class_aqp {
	public final byte[] a;
	private final int b;
	private final int c;

	public class_aqp(byte[] var1, int var2) {
		a = var1;
		b = var2;
		c = var2 + 4;
	}

	public int a(int var1, int var2, int var3) {
		int var4 = (var1 << c) | (var3 << b) | var2;
		int var5 = var4 >> 1;
		int var6 = var4 & 1;
		return var6 == 0 ? a[var5] & 15 : (a[var5] >> 4) & 15;
	}
}
