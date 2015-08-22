package net.minecraft.server;

public class class_aql {
	private final byte[] a;

	public class_aql() {
		a = new byte[2048];
	}

	public class_aql(byte[] var1) {
		a = var1;
		if (var1.length != 2048) {
			throw new IllegalArgumentException("ChunkNibbleArrays should be 2048 bytes not: " + var1.length);
		}
	}

	public int a(int var1, int var2, int var3) {
		return this.a(this.b(var1, var2, var3));
	}

	public void a(int var1, int var2, int var3, int var4) {
		this.a(this.b(var1, var2, var3), var4);
	}

	private int b(int var1, int var2, int var3) {
		return (var2 << 8) | (var3 << 4) | var1;
	}

	public int a(int var1) {
		int var2 = c(var1);
		return this.b(var1) ? a[var2] & 15 : (a[var2] >> 4) & 15;
	}

	public void a(int var1, int var2) {
		int var3 = c(var1);
		if (this.b(var1)) {
			a[var3] = (byte) ((a[var3] & 240) | (var2 & 15));
		} else {
			a[var3] = (byte) ((a[var3] & 15) | ((var2 & 15) << 4));
		}

	}

	private boolean b(int var1) {
		return (var1 & 1) == 0;
	}

	private int c(int var1) {
		return var1 >> 1;
	}

	public byte[] a() {
		return a;
	}
}
