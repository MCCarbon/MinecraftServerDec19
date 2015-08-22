package net.minecraft.server;


public class class_axc {
	private final class_axa[] a;
	private int b;
	private int c;

	public class_axc(class_axa[] var1) {
		a = var1;
		c = var1.length;
	}

	public void a() {
		++b;
	}

	public boolean b() {
		return b >= c;
	}

	public class_axa c() {
		return c > 0 ? a[c - 1] : null;
	}

	public class_axa a(int var1) {
		return a[var1];
	}

	public int d() {
		return c;
	}

	public void b(int var1) {
		c = var1;
	}

	public int e() {
		return b;
	}

	public void c(int var1) {
		b = var1;
	}

	public class_aym a(Entity var1, int var2) {
		double var3 = a[var2].a + (((int) (var1.J + 1.0F)) * 0.5D);
		double var5 = a[var2].b;
		double var7 = a[var2].c + (((int) (var1.J + 1.0F)) * 0.5D);
		return new class_aym(var3, var5, var7);
	}

	public class_aym a(Entity var1) {
		return this.a(var1, b);
	}

	public class_aym f() {
		class_axa var1 = a[b];
		return new class_aym(var1.a, var1.b, var1.c);
	}

	public boolean a(class_axc var1) {
		if (var1 == null) {
			return false;
		} else if (var1.a.length != a.length) {
			return false;
		} else {
			for (int var2 = 0; var2 < a.length; ++var2) {
				if ((a[var2].a != var1.a[var2].a) || (a[var2].b != var1.a[var2].b) || (a[var2].c != var1.a[var2].c)) {
					return false;
				}
			}

			return true;
		}
	}

	public boolean b(class_aym var1) {
		class_axa var2 = this.c();
		return var2 == null ? false : (var2.a == (int) var1.a) && (var2.c == (int) var1.c);
	}
}
