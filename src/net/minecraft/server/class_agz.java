package net.minecraft.server;


public class class_agz implements Comparable {
	private static long d;
	private final class_ail e;
	public final class_cj a;
	public long b;
	public int c;
	private long f;

	public class_agz(class_cj var1, class_ail var2) {
		f = (d++);
		a = var1;
		e = var2;
	}

	@Override
	public boolean equals(Object var1) {
		if (!(var1 instanceof class_agz)) {
			return false;
		} else {
			class_agz var2 = (class_agz) var1;
			return a.equals(var2.a) && class_ail.a(e, var2.e);
		}
	}

	@Override
	public int hashCode() {
		return a.hashCode();
	}

	public class_agz a(long var1) {
		b = var1;
		return this;
	}

	public void a(int var1) {
		c = var1;
	}

	public int a(class_agz var1) {
		return b < var1.b ? -1 : (b > var1.b ? 1 : (c != var1.c ? c - var1.c : (f < var1.f ? -1 : (f > var1.f ? 1 : 0))));
	}

	@Override
	public String toString() {
		return class_ail.a(e) + ": " + a + ", " + b + ", " + c + ", " + f;
	}

	public class_ail a() {
		return e;
	}

	// $FF: synthetic method
	@Override
	public int compareTo(Object var1) {
		return this.a((class_agz) var1);
	}
}
