package net.minecraft.server;


public class class_agi {
	public final int a;
	public final int b;

	public class_agi(int var1, int var2) {
		a = var1;
		b = var2;
	}

	public static long a(int var0, int var1) {
		return (var0 & 4294967295L) | ((var1 & 4294967295L) << 32);
	}

	@Override
	public int hashCode() {
		int var1 = (1664525 * a) + 1013904223;
		int var2 = (1664525 * (b ^ -559038737)) + 1013904223;
		return var1 ^ var2;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_agi)) {
			return false;
		} else {
			class_agi var2 = (class_agi) var1;
			return (a == var2.a) && (b == var2.b);
		}
	}

	public double a(Entity var1) {
		double var2 = (a * 16) + 8;
		double var4 = (b * 16) + 8;
		double var6 = var2 - var1.s;
		double var8 = var4 - var1.u;
		return (var6 * var6) + (var8 * var8);
	}

	public int a() {
		return (a << 4) + 8;
	}

	public int b() {
		return (b << 4) + 8;
	}

	public int c() {
		return a << 4;
	}

	public int d() {
		return b << 4;
	}

	public int e() {
		return (a << 4) + 15;
	}

	public int f() {
		return (b << 4) + 15;
	}

	public class_cj a(int var1, int var2, int var3) {
		return new class_cj((a << 4) + var1, var2, (b << 4) + var3);
	}

	public class_cj a(int var1) {
		return new class_cj(this.a(), var1, b());
	}

	@Override
	public String toString() {
		return "[" + a + ", " + b + "]";
	}
}
