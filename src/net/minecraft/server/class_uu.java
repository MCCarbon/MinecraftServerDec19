package net.minecraft.server;


public class class_uu {
	private final class_cj a;
	private final class_cj b;
	private final class_cq c;
	private int d;
	private boolean e;
	private int f;

	public class_uu(class_cj var1, int var2, int var3, int var4) {
		this(var1, a(var2, var3), var4);
	}

	private static class_cq a(int var0, int var1) {
		return var0 < 0 ? class_cq.e : (var0 > 0 ? class_cq.f : (var1 < 0 ? class_cq.c : class_cq.d));
	}

	public class_uu(class_cj var1, class_cq var2, int var3) {
		a = var1;
		c = var2;
		b = var1.a(var2, 2);
		d = var3;
	}

	public int b(int var1, int var2, int var3) {
		return (int) a.c(var1, var2, var3);
	}

	public int a(class_cj var1) {
		return (int) var1.i(d());
	}

	public int b(class_cj var1) {
		return (int) b.i(var1);
	}

	public boolean c(class_cj var1) {
		int var2 = var1.n() - a.n();
		int var3 = var1.p() - a.o();
		return ((var2 * c.g()) + (var3 * c.i())) >= 0;
	}

	public void a() {
		f = 0;
	}

	public void b() {
		++f;
	}

	public int c() {
		return f;
	}

	public class_cj d() {
		return a;
	}

	public class_cj e() {
		return b;
	}

	public int f() {
		return c.g() * 2;
	}

	public int g() {
		return c.i() * 2;
	}

	public int h() {
		return d;
	}

	public void a(int var1) {
		d = var1;
	}

	public boolean i() {
		return e;
	}

	public void a(boolean var1) {
		e = var1;
	}
}
