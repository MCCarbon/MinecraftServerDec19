package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public abstract class class_aih extends class_ail {
	protected final boolean a;

	public static boolean d(class_ago var0, class_cj var1) {
		return d(var0.p(var1));
	}

	public static boolean d(class_apn var0) {
		class_ail var1 = var0.c();
		return (var1 == class_aim.av) || (var1 == class_aim.D) || (var1 == class_aim.E) || (var1 == class_aim.cs);
	}

	protected class_aih(boolean var1) {
		super(class_avq.q);
		a = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.a(class_abp.e);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		this.a(var1, var2);
		return super.a(var1, var2, var3, var4);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		class_aih.class_b_in_class_aih var4 = var3.c() == this ? (class_aih.class_b_in_class_aih) var3.b(n()) : null;
		if ((var4 != null) && var4.c()) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		}

	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return class_ago.a(var1, var2.b());
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			var3 = this.a(var1, var2, var3, true);
			if (a) {
				this.a(var1, var2, var3, this);
			}
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		if (!var1.D) {
			class_aih.class_b_in_class_aih var5 = (class_aih.class_b_in_class_aih) var3.b(n());
			boolean var6 = false;
			if (!class_ago.a(var1, var2.b())) {
				var6 = true;
			}

			if ((var5 == class_aih.class_b_in_class_aih.c) && !class_ago.a(var1, var2.f())) {
				var6 = true;
			} else if ((var5 == class_aih.class_b_in_class_aih.d) && !class_ago.a(var1, var2.e())) {
				var6 = true;
			} else if ((var5 == class_aih.class_b_in_class_aih.e) && !class_ago.a(var1, var2.c())) {
				var6 = true;
			} else if ((var5 == class_aih.class_b_in_class_aih.f) && !class_ago.a(var1, var2.d())) {
				var6 = true;
			}

			if (var6 && !var1.d(var2)) {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
			} else {
				this.b(var1, var2, var3, var4);
			}

		}
	}

	protected void b(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
	}

	protected class_apn a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		return var1.D ? var3 : (new class_aih.class_a_in_class_aih(var1, var2, var3)).a(var1.z(var2), var4).b();
	}

	@Override
	public int k() {
		return 0;
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		super.c(var1, var2, var3);
		if (((class_aih.class_b_in_class_aih) var3.b(n())).c()) {
			var1.d(var2.a(), this);
		}

		if (a) {
			var1.d(var2, this);
			var1.d(var2.b(), this);
		}

	}

	public abstract class_aqc n();

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_aih.class_b_in_class_aih.values().length];

		static {
			try {
				a[class_aih.class_b_in_class_aih.a.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.b.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.c.ordinal()] = 3;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.d.ordinal()] = 4;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.e.ordinal()] = 5;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.f.ordinal()] = 6;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.g.ordinal()] = 7;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.h.ordinal()] = 8;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.i.ordinal()] = 9;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.j.ordinal()] = 10;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_b_in_class_aih implements class_oe {
		a(0, "north_south"),
		b(1, "east_west"),
		c(2, "ascending_east"),
		d(3, "ascending_west"),
		e(4, "ascending_north"),
		f(5, "ascending_south"),
		g(6, "south_east"),
		h(7, "south_west"),
		i(8, "north_west"),
		j(9, "north_east");

		private static final class_aih.class_b_in_class_aih[] k;
		private final int l;
		private final String m;

		private class_b_in_class_aih(int var3, String var4) {
			l = var3;
			m = var4;
		}

		public int a() {
			return l;
		}

		@Override
		public String toString() {
			return m;
		}

		public boolean c() {
			return (this == e) || (this == c) || (this == f) || (this == d);
		}

		public static class_aih.class_b_in_class_aih a(int var0) {
			if ((var0 < 0) || (var0 >= k.length)) {
				var0 = 0;
			}

			return k[var0];
		}

		@Override
		public String l() {
			return m;
		}

		static {
			k = new class_aih.class_b_in_class_aih[values().length];
			class_aih.class_b_in_class_aih[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_aih.class_b_in_class_aih var3 = var0[var2];
				k[var3.a()] = var3;
			}

		}
	}

	public class class_a_in_class_aih {
		private final class_ago b;
		private final class_cj c;
		private final class_aih d;
		private class_apn e;
		private final boolean f;
		private final List g = Lists.newArrayList();

		public class_a_in_class_aih(class_ago var2, class_cj var3, class_apn var4) {
			b = var2;
			c = var3;
			e = var4;
			d = (class_aih) var4.c();
			class_aih.class_b_in_class_aih var5 = (class_aih.class_b_in_class_aih) var4.b(d.n());
			f = d.a;
			this.a(var5);
		}

		private void a(class_aih.class_b_in_class_aih var1) {
			g.clear();
			switch (class_aih.SyntheticClass_1.a[var1.ordinal()]) {
				case 1:
					g.add(c.c());
					g.add(c.d());
					break;
				case 2:
					g.add(c.e());
					g.add(c.f());
					break;
				case 3:
					g.add(c.e());
					g.add(c.f().a());
					break;
				case 4:
					g.add(c.e().a());
					g.add(c.f());
					break;
				case 5:
					g.add(c.c().a());
					g.add(c.d());
					break;
				case 6:
					g.add(c.c());
					g.add(c.d().a());
					break;
				case 7:
					g.add(c.f());
					g.add(c.d());
					break;
				case 8:
					g.add(c.e());
					g.add(c.d());
					break;
				case 9:
					g.add(c.e());
					g.add(c.c());
					break;
				case 10:
					g.add(c.f());
					g.add(c.c());
			}

		}

		private void c() {
			for (int var1 = 0; var1 < g.size(); ++var1) {
				class_aih.class_a_in_class_aih var2 = this.b((class_cj) g.get(var1));
				if ((var2 != null) && var2.a(this)) {
					g.set(var1, var2.c);
				} else {
					g.remove(var1--);
				}
			}

		}

		private boolean a(class_cj var1) {
			return class_aih.d(b, var1) || class_aih.d(b, var1.a()) || class_aih.d(b, var1.b());
		}

		private class_aih.class_a_in_class_aih b(class_cj var1) {
			class_apn var3 = b.p(var1);
			if (class_aih.d(var3)) {
				return class_aih.this.new class_a_in_class_aih(b, var1, var3);
			} else {
				class_cj var2 = var1.a();
				var3 = b.p(var2);
				if (class_aih.d(var3)) {
					return class_aih.this.new class_a_in_class_aih(b, var2, var3);
				} else {
					var2 = var1.b();
					var3 = b.p(var2);
					return class_aih.d(var3) ? class_aih.this.new class_a_in_class_aih(b, var2, var3) : null;
				}
			}
		}

		private boolean a(class_aih.class_a_in_class_aih var1) {
			return this.c(var1.c);
		}

		private boolean c(class_cj var1) {
			for (int var2 = 0; var2 < g.size(); ++var2) {
				class_cj var3 = (class_cj) g.get(var2);
				if ((var3.n() == var1.n()) && (var3.p() == var1.p())) {
					return true;
				}
			}

			return false;
		}

		protected int a() {
			int var1 = 0;
			Iterator var2 = class_cq.class_c_in_class_cq.a.iterator();

			while (var2.hasNext()) {
				class_cq var3 = (class_cq) var2.next();
				if (this.a(c.a(var3))) {
					++var1;
				}
			}

			return var1;
		}

		private boolean b(class_aih.class_a_in_class_aih var1) {
			return this.a(var1) || (g.size() != 2);
		}

		private void c(class_aih.class_a_in_class_aih var1) {
			g.add(var1.c);
			class_cj var2 = c.c();
			class_cj var3 = c.d();
			class_cj var4 = c.e();
			class_cj var5 = c.f();
			boolean var6 = this.c(var2);
			boolean var7 = this.c(var3);
			boolean var8 = this.c(var4);
			boolean var9 = this.c(var5);
			class_aih.class_b_in_class_aih var10 = null;
			if (var6 || var7) {
				var10 = class_aih.class_b_in_class_aih.a;
			}

			if (var8 || var9) {
				var10 = class_aih.class_b_in_class_aih.b;
			}

			if (!f) {
				if (var7 && var9 && !var6 && !var8) {
					var10 = class_aih.class_b_in_class_aih.g;
				}

				if (var7 && var8 && !var6 && !var9) {
					var10 = class_aih.class_b_in_class_aih.h;
				}

				if (var6 && var8 && !var7 && !var9) {
					var10 = class_aih.class_b_in_class_aih.i;
				}

				if (var6 && var9 && !var7 && !var8) {
					var10 = class_aih.class_b_in_class_aih.j;
				}
			}

			if (var10 == class_aih.class_b_in_class_aih.a) {
				if (class_aih.d(b, var2.a())) {
					var10 = class_aih.class_b_in_class_aih.e;
				}

				if (class_aih.d(b, var3.a())) {
					var10 = class_aih.class_b_in_class_aih.f;
				}
			}

			if (var10 == class_aih.class_b_in_class_aih.b) {
				if (class_aih.d(b, var5.a())) {
					var10 = class_aih.class_b_in_class_aih.c;
				}

				if (class_aih.d(b, var4.a())) {
					var10 = class_aih.class_b_in_class_aih.d;
				}
			}

			if (var10 == null) {
				var10 = class_aih.class_b_in_class_aih.a;
			}

			e = e.a(d.n(), var10);
			b.a(c, e, 3);
		}

		private boolean d(class_cj var1) {
			class_aih.class_a_in_class_aih var2 = this.b(var1);
			if (var2 == null) {
				return false;
			} else {
				var2.c();
				return var2.b(this);
			}
		}

		public class_aih.class_a_in_class_aih a(boolean var1, boolean var2) {
			class_cj var3 = c.c();
			class_cj var4 = c.d();
			class_cj var5 = c.e();
			class_cj var6 = c.f();
			boolean var7 = this.d(var3);
			boolean var8 = this.d(var4);
			boolean var9 = this.d(var5);
			boolean var10 = this.d(var6);
			class_aih.class_b_in_class_aih var11 = null;
			if ((var7 || var8) && !var9 && !var10) {
				var11 = class_aih.class_b_in_class_aih.a;
			}

			if ((var9 || var10) && !var7 && !var8) {
				var11 = class_aih.class_b_in_class_aih.b;
			}

			if (!f) {
				if (var8 && var10 && !var7 && !var9) {
					var11 = class_aih.class_b_in_class_aih.g;
				}

				if (var8 && var9 && !var7 && !var10) {
					var11 = class_aih.class_b_in_class_aih.h;
				}

				if (var7 && var9 && !var8 && !var10) {
					var11 = class_aih.class_b_in_class_aih.i;
				}

				if (var7 && var10 && !var8 && !var9) {
					var11 = class_aih.class_b_in_class_aih.j;
				}
			}

			if (var11 == null) {
				if (var7 || var8) {
					var11 = class_aih.class_b_in_class_aih.a;
				}

				if (var9 || var10) {
					var11 = class_aih.class_b_in_class_aih.b;
				}

				if (!f) {
					if (var1) {
						if (var8 && var10) {
							var11 = class_aih.class_b_in_class_aih.g;
						}

						if (var9 && var8) {
							var11 = class_aih.class_b_in_class_aih.h;
						}

						if (var10 && var7) {
							var11 = class_aih.class_b_in_class_aih.j;
						}

						if (var7 && var9) {
							var11 = class_aih.class_b_in_class_aih.i;
						}
					} else {
						if (var7 && var9) {
							var11 = class_aih.class_b_in_class_aih.i;
						}

						if (var10 && var7) {
							var11 = class_aih.class_b_in_class_aih.j;
						}

						if (var9 && var8) {
							var11 = class_aih.class_b_in_class_aih.h;
						}

						if (var8 && var10) {
							var11 = class_aih.class_b_in_class_aih.g;
						}
					}
				}
			}

			if (var11 == class_aih.class_b_in_class_aih.a) {
				if (class_aih.d(b, var3.a())) {
					var11 = class_aih.class_b_in_class_aih.e;
				}

				if (class_aih.d(b, var4.a())) {
					var11 = class_aih.class_b_in_class_aih.f;
				}
			}

			if (var11 == class_aih.class_b_in_class_aih.b) {
				if (class_aih.d(b, var6.a())) {
					var11 = class_aih.class_b_in_class_aih.c;
				}

				if (class_aih.d(b, var5.a())) {
					var11 = class_aih.class_b_in_class_aih.d;
				}
			}

			if (var11 == null) {
				var11 = class_aih.class_b_in_class_aih.a;
			}

			this.a(var11);
			e = e.a(d.n(), var11);
			if (var2 || (b.p(c) != e)) {
				b.a(c, e, 3);

				for (int var12 = 0; var12 < g.size(); ++var12) {
					class_aih.class_a_in_class_aih var13 = this.b((class_cj) g.get(var12));
					if (var13 != null) {
						var13.c();
						if (var13.b(this)) {
							var13.c(this);
						}
					}
				}
			}

			return this;
		}

		public class_apn b() {
			return e;
		}
	}
}
