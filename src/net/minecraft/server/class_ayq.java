package net.minecraft.server;

import java.util.Comparator;

public class class_ayq {
	public static final Comparator a = new Comparator() {
		public int a(class_ayq var1, class_ayq var2) {
			return var1.c() > var2.c() ? 1 : (var1.c() < var2.c() ? -1 : var2.e().compareToIgnoreCase(var1.e()));
		}

		// $FF: synthetic method
		@Override
		public int compare(Object var1, Object var2) {
			return this.a((class_ayq) var1, (class_ayq) var2);
		}
	};
	private final class_ays b;
	private final class_ayo c;
	private final String d;
	private int e;
	private boolean f;
	private boolean g;

	public class_ayq(class_ays var1, class_ayo var2, String var3) {
		b = var1;
		c = var2;
		d = var3;
		g = true;
	}

	public void a(int var1) {
		if (c.c().b()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.c(this.c() + var1);
		}
	}

	public void b(int var1) {
		if (c.c().b()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.c(this.c() - var1);
		}
	}

	public void a() {
		if (c.c().b()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.a(1);
		}
	}

	public int c() {
		return e;
	}

	public void c(int var1) {
		int var2 = e;
		e = var1;
		if ((var2 != var1) || g) {
			g = false;
			f().a(this);
		}

	}

	public class_ayo d() {
		return c;
	}

	public String e() {
		return d;
	}

	public class_ays f() {
		return b;
	}

	public boolean g() {
		return f;
	}

	public void a(boolean var1) {
		f = var1;
	}
}
