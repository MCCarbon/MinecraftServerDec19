package net.minecraft.server;


public class class_axa {
	public final int a;
	public final int b;
	public final int c;
	private final int j;
	public int d = -1;
	public float e;
	public float f;
	public float g;
	public class_axa h;
	public boolean i;

	public class_axa(int var1, int var2, int var3) {
		a = var1;
		b = var2;
		c = var3;
		j = a(var1, var2, var3);
	}

	public static int a(int var0, int var1, int var2) {
		return (var1 & 255) | ((var0 & 32767) << 8) | ((var2 & 32767) << 24) | (var0 < 0 ? Integer.MIN_VALUE : 0) | (var2 < 0 ? '耀' : 0);
	}

	public float a(class_axa var1) {
		float var2 = var1.a - a;
		float var3 = var1.b - b;
		float var4 = var1.c - c;
		return MathHelper.c((var2 * var2) + (var3 * var3) + (var4 * var4));
	}

	public float b(class_axa var1) {
		float var2 = var1.a - a;
		float var3 = var1.b - b;
		float var4 = var1.c - c;
		return (var2 * var2) + (var3 * var3) + (var4 * var4);
	}

	@Override
	public boolean equals(Object var1) {
		if (!(var1 instanceof class_axa)) {
			return false;
		} else {
			class_axa var2 = (class_axa) var1;
			return (j == var2.j) && (a == var2.a) && (b == var2.b) && (c == var2.c);
		}
	}

	@Override
	public int hashCode() {
		return j;
	}

	public boolean a() {
		return d >= 0;
	}

	@Override
	public String toString() {
		return a + ", " + b + ", " + c;
	}
}
