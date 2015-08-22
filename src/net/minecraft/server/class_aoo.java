package net.minecraft.server;

import java.util.Random;

public class class_aoo extends class_aow implements class_pp {
	private static final Random f = new Random();
	private class_aco[] g = new class_aco[9];
	protected String a;

	@Override
	public int n_() {
		return 9;
	}

	@Override
	public class_aco a(int var1) {
		return g[var1];
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (g[var1] != null) {
			class_aco var3;
			if (g[var1].b <= var2) {
				var3 = g[var1];
				g[var1] = null;
				o_();
				return var3;
			} else {
				var3 = g[var1].a(var2);
				if (g[var1].b == 0) {
					g[var1] = null;
				}

				o_();
				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		if (g[var1] != null) {
			class_aco var2 = g[var1];
			g[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public int m() {
		int var1 = -1;
		int var2 = 1;

		for (int var3 = 0; var3 < g.length; ++var3) {
			if ((g[var3] != null) && (f.nextInt(var2++) == 0)) {
				var1 = var3;
			}
		}

		return var1;
	}

	@Override
	public void a(int var1, class_aco var2) {
		g[var1] = var2;
		if ((var2 != null) && (var2.b > p_())) {
			var2.b = p_();
		}

		o_();
	}

	public int a(class_aco var1) {
		for (int var2 = 0; var2 < g.length; ++var2) {
			if ((g[var2] == null) || (g[var2].b() == null)) {
				this.a(var2, var1);
				return var2;
			}
		}

		return -1;
	}

	@Override
	public String e_() {
		return k_() ? a : "container.dispenser";
	}

	public void a(String var1) {
		a = var1;
	}

	@Override
	public boolean k_() {
		return a != null;
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		class_du var2 = var1.c("Items", 10);
		g = new class_aco[n_()];

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			int var5 = var4.f("Slot") & 255;
			if ((var5 >= 0) && (var5 < g.length)) {
				g[var5] = class_aco.a(var4);
			}
		}

		if (var1.b("CustomName", 8)) {
			a = var1.l("CustomName");
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
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
			var1.a("CustomName", a);
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
		return true;
	}

	@Override
	public String k() {
		return "minecraft:dispenser";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aad(var1, this);
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
		for (int var1 = 0; var1 < g.length; ++var1) {
			g[var1] = null;
		}

	}
}
