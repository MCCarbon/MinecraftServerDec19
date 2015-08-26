package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;

public enum class_cq implements class_oe {
	a("DOWN", 0, 0, 1, -1, "down", class_cq.class_b_in_class_cq.b, class_cq.class_a_in_class_cq.b, new class_df(0, -1, 0)),
	b("UP", 1, 1, 0, -1, "up", class_cq.class_b_in_class_cq.a, class_cq.class_a_in_class_cq.b, new class_df(0, 1, 0)),
	c("NORTH", 2, 2, 3, 2, "north", class_cq.class_b_in_class_cq.b, class_cq.class_a_in_class_cq.c, new class_df(0, 0, -1)),
	d("SOUTH", 3, 3, 2, 0, "south", class_cq.class_b_in_class_cq.a, class_cq.class_a_in_class_cq.c, new class_df(0, 0, 1)),
	e("WEST", 4, 4, 5, 1, "west", class_cq.class_b_in_class_cq.b, class_cq.class_a_in_class_cq.a, new class_df(-1, 0, 0)),
	f("EAST", 5, 5, 4, 3, "east", class_cq.class_b_in_class_cq.a, class_cq.class_a_in_class_cq.a, new class_df(1, 0, 0));

	private final int g;
	private final int h;
	private final int i;
	private final String j;
	private final class_cq.class_a_in_class_cq k;
	private final class_cq.class_b_in_class_cq l;
	private final class_df m;
	private static final class_cq[] n;
	private static final class_cq[] o;
	private static final Map p;

	private class_cq(String name, int ordinal, int var3, int var4, int var5, String var6, class_cq.class_b_in_class_cq var7, class_cq.class_a_in_class_cq var8, class_df var9) {
		this(var3, var4, var5, var6, var7, var8, var9);
	}

	private class_cq(int var3, int var4, int var5, String var6, class_cq.class_b_in_class_cq var7, class_cq.class_a_in_class_cq var8, class_df var9) {
		g = var3;
		i = var5;
		h = var4;
		j = var6;
		k = var8;
		l = var7;
		m = var9;
	}

	public int a() {
		return g;
	}

	public int b() {
		return i;
	}

	public class_cq.class_b_in_class_cq c() {
		return l;
	}

	public class_cq d() {
		return a(h);
	}

	public class_cq e() {
		switch (class_cq.SyntheticClass_1.b[ordinal()]) {
			case 1:
				return f;
			case 2:
				return d;
			case 3:
				return e;
			case 4:
				return c;
			default:
				throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
		}
	}

	public class_cq f() {
		switch (class_cq.SyntheticClass_1.b[ordinal()]) {
			case 1:
				return e;
			case 2:
				return c;
			case 3:
				return f;
			case 4:
				return d;
			default:
				throw new IllegalStateException("Unable to get CCW facing of " + this);
		}
	}

	public int g() {
		return k == class_cq.class_a_in_class_cq.a ? l.a() : 0;
	}

	public int h() {
		return k == class_cq.class_a_in_class_cq.b ? l.a() : 0;
	}

	public int i() {
		return k == class_cq.class_a_in_class_cq.c ? l.a() : 0;
	}

	public String j() {
		return j;
	}

	public class_cq.class_a_in_class_cq k() {
		return k;
	}

	public static class_cq a(int var0) {
		return n[MathHelper.a(var0 % n.length)];
	}

	public static class_cq b(int var0) {
		return o[MathHelper.a(var0 % o.length)];
	}

	public static class_cq a(double var0) {
		return b(MathHelper.c((var0 / 90.0D) + 0.5D) & 3);
	}

	public static class_cq a(Random var0) {
		return values()[var0.nextInt(values().length)];
	}

	@Override
	public String toString() {
		return j;
	}

	@Override
	public String l() {
		return j;
	}

	public static class_cq a(class_cq.class_b_in_class_cq var0, class_cq.class_a_in_class_cq var1) {
		class_cq[] var2 = values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_cq var5 = var2[var4];
			if ((var5.c() == var0) && (var5.k() == var1)) {
				return var5;
			}
		}

		throw new IllegalArgumentException("No such direction: " + var0 + " " + var1);
	}

	static {
		n = new class_cq[6];
		o = new class_cq[4];
		p = Maps.newHashMap();
		class_cq[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			class_cq var3 = var0[var2];
			n[var3.g] = var3;
			if (var3.k().c()) {
				o[var3.i] = var3;
			}

			p.put(var3.j().toLowerCase(), var3);
		}

	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[class_cq.class_c_in_class_cq.values().length];

		static {
			try {
				c[class_cq.class_c_in_class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var11) {
				;
			}

			try {
				c[class_cq.class_c_in_class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var10) {
				;
			}

			b = new int[class_cq.values().length];

			try {
				b[class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				b[class_cq.f.ordinal()] = 2;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[class_cq.d.ordinal()] = 3;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				b[class_cq.e.ordinal()] = 4;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[class_cq.b.ordinal()] = 5;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[class_cq.a.ordinal()] = 6;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[class_cq.class_a_in_class_cq.values().length];

			try {
				a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.c.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_c_in_class_cq implements Predicate, Iterable {
		a,
		b;

		public class_cq[] a() {
			switch (class_cq.SyntheticClass_1.c[ordinal()]) {
				case 1:
					return new class_cq[] { class_cq.c, class_cq.f, class_cq.d, class_cq.e };
				case 2:
					return new class_cq[] { class_cq.b, class_cq.a };
				default:
					throw new Error("Someone\'s been tampering with the universe!");
			}
		}

		public class_cq a(Random var1) {
			class_cq[] var2 = this.a();
			return var2[var1.nextInt(var2.length)];
		}

		public boolean a(class_cq var1) {
			return (var1 != null) && (var1.k().d() == this);
		}

		@Override
		public Iterator iterator() {
			return Iterators.forArray(this.a());
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_cq) var1);
		}
	}

	public static enum class_b_in_class_cq {
		a(1, "Towards positive"),
		b(-1, "Towards negative");

		private final int c;
		private final String d;

		private class_b_in_class_cq(int var3, String var4) {
			c = var3;
			d = var4;
		}

		public int a() {
			return c;
		}

		@Override
		public String toString() {
			return d;
		}
	}

	public static enum class_a_in_class_cq implements Predicate, class_oe {
		a("x", class_cq.class_c_in_class_cq.a),
		b("y", class_cq.class_c_in_class_cq.b),
		c("z", class_cq.class_c_in_class_cq.a);

		private static final Map d;
		private final String e;
		private final class_cq.class_c_in_class_cq f;

		private class_a_in_class_cq(String var3, class_cq.class_c_in_class_cq var4) {
			e = var3;
			f = var4;
		}

		public String a() {
			return e;
		}

		public boolean b() {
			return f == class_cq.class_c_in_class_cq.b;
		}

		public boolean c() {
			return f == class_cq.class_c_in_class_cq.a;
		}

		@Override
		public String toString() {
			return e;
		}

		public boolean a(class_cq var1) {
			return (var1 != null) && (var1.k() == this);
		}

		public class_cq.class_c_in_class_cq d() {
			return f;
		}

		@Override
		public String l() {
			return e;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_cq) var1);
		}

		static {
			d = Maps.newHashMap();
			class_cq.class_a_in_class_cq[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_cq.class_a_in_class_cq var3 = var0[var2];
				d.put(var3.a().toLowerCase(), var3);
			}

		}
	}
}
