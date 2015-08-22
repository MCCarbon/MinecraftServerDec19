package net.minecraft.server;

import java.util.Arrays;

public class class_aoj extends class_aow implements class_ks, class_qf {
	private static final int[] a = new int[] { 3 };
	private static final int[] f = new int[] { 0, 1, 2 };
	private class_aco[] g = new class_aco[4];
	private int h;
	private boolean[] i;
	private class_acm j;
	private String k;

	@Override
	public String e_() {
		return k_() ? k : "container.brewing";
	}

	@Override
	public boolean k_() {
		return (k != null) && !k.isEmpty();
	}

	public void a(String var1) {
		k = var1;
	}

	@Override
	public int n_() {
		return g.length;
	}

	@Override
	public void c() {
		boolean var1 = n();
		boolean var2 = h > 0;
		if (var2) {
			--h;
			boolean var3 = h == 0;
			if (var3 && var1) {
				o();
				o_();
			} else if (!var1) {
				h = 0;
				o_();
			} else if (j != g[3].b()) {
				h = 0;
				o_();
			}
		} else if (var1) {
			h = 400;
			j = g[3].b();
		}

		if (!b.D) {
			boolean[] var6 = m();
			if (!Arrays.equals(var6, i)) {
				i = var6;
				class_apn var4 = b.p(v());
				if (!(var4.c() instanceof class_aip)) {
					return;
				}

				for (int var5 = 0; var5 < class_aip.a.length; ++var5) {
					var4 = var4.a(class_aip.a[var5], Boolean.valueOf(var6[var5]));
				}

				b.a(c, var4, 2);
			}
		}

	}

	public boolean[] m() {
		boolean[] var1 = new boolean[3];

		for (int var2 = 0; var2 < 3; ++var2) {
			if (g[var2] != null) {
				var1[var2] = true;
			}
		}

		return var1;
	}

	private boolean n() {
		if ((g[3] != null) && (g[3].b > 0)) {
			class_aco var1 = g[3];
			if (!class_aed.a(var1)) {
				return false;
			} else {
				for (int var2 = 0; var2 < 3; ++var2) {
					class_aco var3 = g[var2];
					if ((var3 != null) && class_aed.a(var3, var1)) {
						return true;
					}
				}

				return false;
			}
		} else {
			return false;
		}
	}

	private void o() {
		class_aco var1 = g[3];

		for (int var2 = 0; var2 < 3; ++var2) {
			g[var2] = class_aed.d(var1, g[var2]);
		}

		--var1.b;
		if (var1.b().r()) {
			class_aco var3 = new class_aco(var1.b().q());
			if (var1.b <= 0) {
				var1 = var3;
			} else {
				class_pr.a(b, v().n(), v().o(), v().p(), var3);
			}
		}

		if (var1.b <= 0) {
			var1 = null;
		}

		g[3] = var1;
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		class_du var2 = var1.c("Items", 10);
		g = new class_aco[n_()];

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			byte var5 = var4.f("Slot");
			if ((var5 >= 0) && (var5 < g.length)) {
				g[var5] = class_aco.a(var4);
			}
		}

		h = var1.g("BrewTime");
		if (var1.b("CustomName", 8)) {
			k = var1.l("CustomName");
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("BrewTime", (short) h);
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < g.length; ++var3) {
			if (g[var3] != null) {
				class_dn var4 = new class_dn();
				var4.a("Slot", (byte) var3);
				g[var3].b(var4);
				var2.a(var4);
			}
		}

		var1.a("Items", var2);
		if (k_()) {
			var1.a("CustomName", k);
		}

	}

	@Override
	public class_aco a(int var1) {
		return (var1 >= 0) && (var1 < g.length) ? g[var1] : null;
	}

	@Override
	public class_aco a(int var1, int var2) {
		if ((var1 >= 0) && (var1 < g.length)) {
			class_aco var3 = g[var1];
			g[var1] = null;
			return var3;
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		if ((var1 >= 0) && (var1 < g.length)) {
			class_aco var2 = g[var1];
			g[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		if ((var1 >= 0) && (var1 < g.length)) {
			g[var1] = var2;
		}

	}

	@Override
	public int p_() {
		return 64;
	}

	@Override
	public boolean a(class_yu var1) {
		return b.s(c) != this ? false : var1.e(c.n() + 0.5D, c.o() + 0.5D, c.p() + 0.5D) <= 64.0D;
	}

	@Override
	public void b(class_yu var1) {
	}

	@Override
	public void c(class_yu var1) {
	}

	@Override
	public boolean b(int var1, class_aco var2) {
		if (var1 == 3) {
			return class_aed.a(var2);
		} else {
			class_acm var3 = var2.b();
			return (var3 == class_acq.bB) || (var3 == class_acq.bE);
		}
	}

	@Override
	public int[] a(class_cq var1) {
		return var1 == class_cq.b ? a : f;
	}

	@Override
	public boolean a(int var1, class_aco var2, class_cq var3) {
		return this.b(var1, var2);
	}

	@Override
	public boolean b(int var1, class_aco var2, class_cq var3) {
		return true;
	}

	@Override
	public String k() {
		return "minecraft:brewing_stand";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_zy(var1, this);
	}

	@Override
	public int c(int var1) {
		switch (var1) {
			case 0:
				return h;
			default:
				return 0;
		}
	}

	@Override
	public void b(int var1, int var2) {
		switch (var1) {
			case 0:
				h = var2;
			default:
		}
	}

	@Override
	public int g() {
		return 1;
	}

	@Override
	public void l() {
		Arrays.fill(g, (Object) null);
	}
}
