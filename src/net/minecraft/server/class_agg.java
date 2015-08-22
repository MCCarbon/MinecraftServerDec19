package net.minecraft.server;


public class class_agg {
	private class_cj a;
	private class_ail b;
	private int c;
	private int d;

	public class_agg(class_cj var1, class_ail var2, int var3, int var4) {
		a = var1;
		c = var3;
		d = var4;
		b = var2;
	}

	public class_cj a() {
		return a;
	}

	public int b() {
		return c;
	}

	public int c() {
		return d;
	}

	public class_ail d() {
		return b;
	}

	@Override
	public boolean equals(Object var1) {
		if (!(var1 instanceof class_agg)) {
			return false;
		} else {
			class_agg var2 = (class_agg) var1;
			return a.equals(var2.a) && (c == var2.c) && (d == var2.d) && (b == var2.b);
		}
	}

	@Override
	public String toString() {
		return "TE(" + a + ")," + c + "," + d + "," + b;
	}
}
