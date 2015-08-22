package net.minecraft.server;


public final class class_agr {
	private final long a;
	private final class_agr.class_a_in_class_agr b;
	private final boolean c;
	private final boolean d;
	private final class_agt e;
	private boolean f;
	private boolean g;
	private String h;

	public class_agr(long var1, class_agr.class_a_in_class_agr var3, boolean var4, boolean var5, class_agt var6) {
		h = "";
		a = var1;
		b = var3;
		c = var4;
		d = var5;
		e = var6;
	}

	public class_agr(class_axt var1) {
		this(var1.a(), var1.q(), var1.r(), var1.s(), var1.t());
	}

	public class_agr a() {
		g = true;
		return this;
	}

	public class_agr a(String var1) {
		h = var1;
		return this;
	}

	public boolean c() {
		return g;
	}

	public long d() {
		return a;
	}

	public class_agr.class_a_in_class_agr e() {
		return b;
	}

	public boolean f() {
		return d;
	}

	public boolean g() {
		return c;
	}

	public class_agt h() {
		return e;
	}

	public boolean i() {
		return f;
	}

	public static class_agr.class_a_in_class_agr a(int var0) {
		return class_agr.class_a_in_class_agr.a(var0);
	}

	public String j() {
		return h;
	}

	public static enum class_a_in_class_agr {
		a(-1, ""),
		b(0, "survival"),
		c(1, "creative"),
		d(2, "adventure"),
		e(3, "spectator");

		int f;
		String g;

		private class_a_in_class_agr(int var3, String var4) {
			f = var3;
			g = var4;
		}

		public int a() {
			return f;
		}

		public String b() {
			return g;
		}

		public void a(class_ys var1) {
			if (this == c) {
				var1.c = true;
				var1.d = true;
				var1.a = true;
			} else if (this == e) {
				var1.c = true;
				var1.d = false;
				var1.a = true;
				var1.b = true;
			} else {
				var1.c = false;
				var1.d = false;
				var1.a = false;
				var1.b = false;
			}

			var1.e = !c();
		}

		public boolean c() {
			return (this == d) || (this == e);
		}

		public boolean d() {
			return this == c;
		}

		public boolean e() {
			return (this == b) || (this == d);
		}

		public static class_agr.class_a_in_class_agr a(int var0) {
			class_agr.class_a_in_class_agr[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				class_agr.class_a_in_class_agr var4 = var1[var3];
				if (var4.f == var0) {
					return var4;
				}
			}

			return b;
		}
	}
}
