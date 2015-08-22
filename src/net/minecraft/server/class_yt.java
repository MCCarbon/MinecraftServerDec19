package net.minecraft.server;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class class_yt implements class_pp {
	public final class_aco[] a = new class_aco[36];
	public final class_aco[] b = new class_aco[4];
	public final class_aco[] c = new class_aco[1];
	private final class_aco[][] g;
	public int d;
	public class_yu e;
	private class_aco h;
	public boolean f;

	public class_yt(class_yu var1) {
		g = new class_aco[][] { a, b, c };
		e = var1;
	}

	public class_aco h() {
		return this.f(d) ? a[d] : null;
	}

	public static int i() {
		return 9;
	}

	private boolean a(class_aco var1, class_aco var2) {
		return (var1 != null) && this.b(var1, var2) && var1.d() && (var1.b < var1.c()) && (var1.b < p_());
	}

	private boolean b(class_aco var1, class_aco var2) {
		return (var1.b() == var2.b()) && (!var1.f() || (var1.i() == var2.i())) && class_aco.a(var1, var2);
	}

	public int j() {
		for (int var1 = 0; var1 < a.length; ++var1) {
			if (a[var1] == null) {
				return var1;
			}
		}

		return -1;
	}

	private boolean f(int var1) {
		return (var1 >= 0) && (var1 < 9);
	}

	public int a(Item var1, int var2, int var3, class_dn var4) {
		int var5 = 0;

		int var6;
		for (var6 = 0; var6 < n_(); ++var6) {
			class_aco var7 = this.a(var6);
			if ((var7 != null) && ((var1 == null) || (var7.b() == var1)) && ((var2 <= -1) || (var7.i() == var2)) && ((var4 == null) || class_dy.a(var4, var7.o(), true))) {
				int var8 = var3 <= 0 ? var7.b : Math.min(var3 - var5, var7.b);
				var5 += var8;
				if (var3 != 0) {
					var7.b -= var8;
					if (var7.b == 0) {
						this.a(var6, (class_aco) null);
					}

					if ((var3 > 0) && (var5 >= var3)) {
						return var5;
					}
				}
			}
		}

		if (h != null) {
			if ((var1 != null) && (h.b() != var1)) {
				return var5;
			}

			if ((var2 > -1) && (h.i() != var2)) {
				return var5;
			}

			if ((var4 != null) && !class_dy.a(var4, h.o(), true)) {
				return var5;
			}

			var6 = var3 <= 0 ? h.b : Math.min(var3 - var5, h.b);
			var5 += var6;
			if (var3 != 0) {
				h.b -= var6;
				if (h.b == 0) {
					h = null;
				}

				if ((var3 > 0) && (var5 >= var3)) {
					return var5;
				}
			}
		}

		return var5;
	}

	private int e(class_aco var1) {
		Item var2 = var1.b();
		int var3 = var1.b;
		int var4 = this.f(var1);
		if (var4 == -1) {
			var4 = j();
		}

		if (var4 == -1) {
			return var3;
		} else {
			class_aco var5 = this.a(var4);
			if (var5 == null) {
				var5 = new class_aco(var2, 0, var1.i());
				if (var1.n()) {
					var5.d((class_dn) var1.o().b());
				}

				this.a(var4, var5);
			}

			int var6 = var3;
			if (var3 > (var5.c() - var5.b)) {
				var6 = var5.c() - var5.b;
			}

			if (var6 > (p_() - var5.b)) {
				var6 = p_() - var5.b;
			}

			if (var6 == 0) {
				return var3;
			} else {
				var3 -= var6;
				var5.b += var6;
				var5.c = 5;
				return var3;
			}
		}
	}

	private int f(class_aco var1) {
		if (this.a(this.a(d), var1)) {
			return d;
		} else if (this.a(this.a(40), var1)) {
			return 40;
		} else {
			for (int var2 = 0; var2 < a.length; ++var2) {
				if (this.a(a[var2], var1)) {
					return var2;
				}
			}

			return -1;
		}
	}

	public void k() {
		for (int var1 = 0; var1 < g.length; ++var1) {
			class_aco[] var2 = g[var1];

			for (int var3 = 0; var3 < var2.length; ++var3) {
				if (var2[var3] != null) {
					var2[var3].a(e.o, e, var3, d == var3);
				}
			}
		}

	}

	public boolean a(final class_aco var1) {
		if ((var1 != null) && (var1.b != 0) && (var1.b() != null)) {
			try {
				int var2;
				if (var1.g()) {
					var2 = j();
					if (var2 >= 0) {
						a[var2] = class_aco.b(var1);
						a[var2].c = 5;
						var1.b = 0;
						return true;
					} else if (e.bI.d) {
						var1.b = 0;
						return true;
					} else {
						return false;
					}
				} else {
					do {
						var2 = var1.b;
						var1.b = e(var1);
					} while ((var1.b > 0) && (var1.b < var2));

					if ((var1.b == var2) && e.bI.d) {
						var1.b = 0;
						return true;
					} else {
						return var1.b < var2;
					}
				}
			} catch (Throwable var5) {
				class_b var3 = class_b.a(var5, "Adding item to inventory");
				class_c var4 = var3.a("Item being added");
				var4.a("Item ID", Integer.valueOf(Item.b(var1.b())));
				var4.a("Item data", Integer.valueOf(var1.i()));
				var4.a("Item name", new Callable() {
					public String a() throws Exception {
						return var1.q();
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				throw new class_e(var3);
			}
		} else {
			return false;
		}
	}

	@Override
	public class_aco a(int var1, int var2) {
		class_aco[] var3 = null;
		class_aco[][] var4 = g;
		int var5 = var4.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			class_aco[] var7 = var4[var6];
			if (var1 < var7.length) {
				var3 = var7;
				break;
			}

			var1 -= var7.length;
		}

		if ((var3 != null) && (var3[var1] != null)) {
			class_aco var8;
			if (var3[var1].b <= var2) {
				var8 = var3[var1];
				var3[var1] = null;
				return var8;
			} else {
				var8 = var3[var1].a(var2);
				if (var3[var1].b == 0) {
					var3[var1] = null;
				}

				return var8;
			}
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		class_aco[] var2 = null;
		class_aco[][] var3 = g;
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_aco[] var6 = var3[var5];
			if (var1 < var6.length) {
				var2 = var6;
				break;
			}

			var1 -= var6.length;
		}

		if ((var2 != null) && (var2[var1] != null)) {
			Object var7 = var2[var1];
			var2[var1] = null;
			return (class_aco) var7;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		class_aco[] var3 = null;
		class_aco[][] var4 = g;
		int var5 = var4.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			class_aco[] var7 = var4[var6];
			if (var1 < var7.length) {
				var3 = var7;
				break;
			}

			var1 -= var7.length;
		}

		if (var3 != null) {
			var3[var1] = var2;
		}

	}

	public float a(Block var1) {
		float var2 = 1.0F;
		if (a[d] != null) {
			var2 *= a[d].a(var1);
		}

		return var2;
	}

	public class_du a(class_du var1) {
		int var2;
		class_dn var3;
		for (var2 = 0; var2 < a.length; ++var2) {
			if (a[var2] != null) {
				var3 = new class_dn();
				var3.a("Slot", (byte) var2);
				a[var2].b(var3);
				var1.a(var3);
			}
		}

		for (var2 = 0; var2 < b.length; ++var2) {
			if (b[var2] != null) {
				var3 = new class_dn();
				var3.a("Slot", (byte) (var2 + 100));
				b[var2].b(var3);
				var1.a(var3);
			}
		}

		for (var2 = 0; var2 < c.length; ++var2) {
			if (c[var2] != null) {
				var3 = new class_dn();
				var3.a("Slot", (byte) (var2 + 150));
				c[var2].b(var3);
				var1.a(var3);
			}
		}

		return var1;
	}

	public void b(class_du var1) {
		Arrays.fill(a, (Object) null);
		Arrays.fill(b, (Object) null);
		Arrays.fill(c, (Object) null);

		for (int var2 = 0; var2 < var1.c(); ++var2) {
			class_dn var3 = var1.b(var2);
			int var4 = var3.f("Slot") & 255;
			class_aco var5 = class_aco.a(var3);
			if (var5 != null) {
				if ((var4 >= 0) && (var4 < a.length)) {
					a[var4] = var5;
				} else if ((var4 >= 100) && (var4 < (b.length + 100))) {
					b[var4 - 100] = var5;
				} else if ((var4 >= 150) && (var4 < (c.length + 150))) {
					c[var4 - 150] = var5;
				}
			}
		}

	}

	@Override
	public int n_() {
		return a.length + b.length + c.length;
	}

	@Override
	public class_aco a(int var1) {
		class_aco[] var2 = null;
		class_aco[][] var3 = g;
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_aco[] var6 = var3[var5];
			if (var1 < var6.length) {
				var2 = var6;
				break;
			}

			var1 -= var6.length;
		}

		return var2 == null ? null : var2[var1];
	}

	@Override
	public String e_() {
		return "container.inventory";
	}

	@Override
	public boolean k_() {
		return false;
	}

	@Override
	public class_eu f_() {
		return k_() ? new class_fa(e_()) : new class_fb(e_(), new Object[0]);
	}

	@Override
	public int p_() {
		return 64;
	}

	public boolean b(Block var1) {
		if (var1.v().l()) {
			return true;
		} else {
			class_aco var2 = this.a(d);
			return var2 != null ? var2.b(var1) : false;
		}
	}

	public void a(float var1) {
		var1 /= 4.0F;
		if (var1 < 1.0F) {
			var1 = 1.0F;
		}

		for (int var2 = 0; var2 < b.length; ++var2) {
			if ((b[var2] != null) && (b[var2].b() instanceof class_aav)) {
				b[var2].a((int) var1, e);
				if (b[var2].b == 0) {
					b[var2] = null;
				}
			}
		}

	}

	public void m() {
		class_aco[][] var1 = g;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_aco[] var4 = var1[var3];

			for (int var5 = 0; var5 < var4.length; ++var5) {
				if (var4[var5] != null) {
					e.a(var4[var5], true, false);
					var4[var5] = null;
				}
			}
		}

	}

	@Override
	public void o_() {
		f = true;
	}

	public void b(class_aco var1) {
		h = var1;
	}

	public class_aco n() {
		return h;
	}

	@Override
	public boolean a(class_yu var1) {
		return e.I ? false : var1.h(e) <= 64.0D;
	}

	public boolean c(class_aco var1) {
		class_aco[][] var2 = g;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_aco[] var5 = var2[var4];

			for (int var6 = 0; var6 < var5.length; ++var6) {
				if ((var5[var6] != null) && var5[var6].a(var1)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void b(class_yu var1) {
	}

	@Override
	public void c(class_yu var1) {
	}

	@Override
	public boolean b(int var1, class_aco var2) {
		return true;
	}

	public void a(class_yt var1) {
		for (int var2 = 0; var2 < n_(); ++var2) {
			this.a(var2, var1.a(var2));
		}

		d = var1.d;
	}

	@Override
	public int c(int var1) {
		return 0;
	}

	@Override
	public void b(int var1, int var2) {
	}

	@Override
	public int g() {
		return 0;
	}

	@Override
	public void l() {
		class_aco[][] var1 = g;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_aco[] var4 = var1[var3];

			for (int var5 = 0; var5 < var4.length; ++var5) {
				var4[var5] = null;
			}
		}

	}
}
