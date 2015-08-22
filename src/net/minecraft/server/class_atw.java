package net.minecraft.server;


public class class_atw {
	private final int a;
	private class_apn b;
	private int c;
	private int d;

	public class_atw(int var1, class_ail var2) {
		this(3, var1, var2);
	}

	public class_atw(int var1, int var2, class_ail var3) {
		c = 1;
		a = var1;
		c = var2;
		b = var3.S();
	}

	public class_atw(int var1, int var2, class_ail var3, int var4) {
		this(var1, var2, var3);
		b = var3.a(var4);
	}

	public int b() {
		return c;
	}

	public class_apn c() {
		return b;
	}

	private class_ail e() {
		return b.c();
	}

	private int f() {
		return b.c().c(b);
	}

	public int d() {
		return d;
	}

	public void b(int var1) {
		d = var1;
	}

	@Override
	public String toString() {
		String var1;
		if (a >= 3) {
			class_ke var2 = (class_ke) class_ail.c.b(e());
			var1 = var2 == null ? "null" : var2.toString();
			if (c > 1) {
				var1 = c + "*" + var1;
			}
		} else {
			var1 = Integer.toString(class_ail.a(e()));
			if (c > 1) {
				var1 = c + "x" + var1;
			}
		}

		int var3 = f();
		if (var3 > 0) {
			var1 = var1 + ":" + var3;
		}

		return var1;
	}
}
