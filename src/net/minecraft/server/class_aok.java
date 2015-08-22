package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_aok extends class_aow implements class_ks, class_pp {
	private class_aco[] m = new class_aco[27];
	public boolean a;
	public class_aok f;
	public class_aok g;
	public class_aok h;
	public class_aok i;
	public float j;
	public float k;
	public int l;
	private int n;
	private int o = -1;
	private String p;

	@Override
	public int n_() {
		return 27;
	}

	@Override
	public class_aco a(int var1) {
		return m[var1];
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (m[var1] != null) {
			class_aco var3;
			if (m[var1].b <= var2) {
				var3 = m[var1];
				m[var1] = null;
				o_();
				return var3;
			} else {
				var3 = m[var1].a(var2);
				if (m[var1].b == 0) {
					m[var1] = null;
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
		if (m[var1] != null) {
			class_aco var2 = m[var1];
			m[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		m[var1] = var2;
		if ((var2 != null) && (var2.b > p_())) {
			var2.b = p_();
		}

		o_();
	}

	@Override
	public String e_() {
		return k_() ? p : "container.chest";
	}

	@Override
	public boolean k_() {
		return (p != null) && !p.isEmpty();
	}

	public void a(String var1) {
		p = var1;
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		class_du var2 = var1.c("Items", 10);
		m = new class_aco[n_()];
		if (var1.b("CustomName", 8)) {
			p = var1.l("CustomName");
		}

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			int var5 = var4.f("Slot") & 255;
			if ((var5 >= 0) && (var5 < m.length)) {
				m[var5] = class_aco.a(var4);
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < m.length; ++var3) {
			if (m[var3] != null) {
				class_dn var4 = new class_dn();
				var4.a("Slot", (byte) var3);
				m[var3].b(var4);
				var2.a(var4);
			}
		}

		var1.a("Items", var2);
		if (k_()) {
			var1.a("CustomName", p);
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
	public void E() {
		super.E();
		a = false;
	}

	private void a(class_aok var1, class_cq var2) {
		if (var1.x()) {
			a = false;
		} else if (a) {
			switch (class_aok.SyntheticClass_1.a[var2.ordinal()]) {
				case 1:
					if (f != var1) {
						a = false;
					}
					break;
				case 2:
					if (i != var1) {
						a = false;
					}
					break;
				case 3:
					if (g != var1) {
						a = false;
					}
					break;
				case 4:
					if (h != var1) {
						a = false;
					}
			}
		}

	}

	public void m() {
		if (!a) {
			a = true;
			h = this.a(class_cq.e);
			g = this.a(class_cq.f);
			f = this.a(class_cq.c);
			i = this.a(class_cq.d);
		}
	}

	protected class_aok a(class_cq var1) {
		class_cj var2 = c.a(var1);
		if (this.b(var2)) {
			class_aoi var3 = b.s(var2);
			if (var3 instanceof class_aok) {
				class_aok var4 = (class_aok) var3;
				var4.a(this, var1.d());
				return var4;
			}
		}

		return null;
	}

	private boolean b(class_cj var1) {
		if (b == null) {
			return false;
		} else {
			class_ail var2 = b.p(var1).c();
			return (var2 instanceof class_aiw) && (((class_aiw) var2).b == n());
		}
	}

	@Override
	public void c() {
		m();
		int var1 = c.n();
		int var2 = c.o();
		int var3 = c.p();
		++n;
		float var4;
		if (!b.D && (l != 0) && (((n + var1 + var2 + var3) % 200) == 0)) {
			l = 0;
			var4 = 5.0F;
			List var5 = b.a(class_yu.class, new class_ayk(var1 - var4, var2 - var4, var3 - var4, var1 + 1 + var4, var2 + 1 + var4, var3 + 1 + var4));
			Iterator var6 = var5.iterator();

			label93: while (true) {
				class_pp var8;
				do {
					class_yu var7;
					do {
						if (!var6.hasNext()) {
							break label93;
						}

						var7 = (class_yu) var6.next();
					} while (!(var7.bs instanceof class_aaa));

					var8 = ((class_aaa) var7.bs).e();
				} while ((var8 != this) && (!(var8 instanceof class_po) || !((class_po) var8).a(this)));

				++l;
			}
		}

		k = j;
		var4 = 0.1F;
		double var14;
		if ((l > 0) && (j == 0.0F) && (f == null) && (h == null)) {
			double var11 = var1 + 0.5D;
			var14 = var3 + 0.5D;
			if (i != null) {
				var14 += 0.5D;
			}

			if (g != null) {
				var11 += 0.5D;
			}

			b.a(var11, var2 + 0.5D, var14, "random.chestopen", 0.5F, (b.s.nextFloat() * 0.1F) + 0.9F);
		}

		if (((l == 0) && (j > 0.0F)) || ((l > 0) && (j < 1.0F))) {
			float var12 = j;
			if (l > 0) {
				j += var4;
			} else {
				j -= var4;
			}

			if (j > 1.0F) {
				j = 1.0F;
			}

			float var13 = 0.5F;
			if ((j < var13) && (var12 >= var13) && (f == null) && (h == null)) {
				var14 = var1 + 0.5D;
				double var9 = var3 + 0.5D;
				if (i != null) {
					var9 += 0.5D;
				}

				if (g != null) {
					var14 += 0.5D;
				}

				b.a(var14, var2 + 0.5D, var9, "random.chestclosed", 0.5F, (b.s.nextFloat() * 0.1F) + 0.9F);
			}

			if (j < 0.0F) {
				j = 0.0F;
			}
		}

	}

	@Override
	public boolean c(int var1, int var2) {
		if (var1 == 1) {
			l = var2;
			return true;
		} else {
			return super.c(var1, var2);
		}
	}

	@Override
	public void b(class_yu var1) {
		if (!var1.w()) {
			if (l < 0) {
				l = 0;
			}

			++l;
			b.c(c, w(), 1, l);
			b.d(c, w());
			b.d(c.b(), w());
		}

	}

	@Override
	public void c(class_yu var1) {
		if (!var1.w() && (w() instanceof class_aiw)) {
			--l;
			b.c(c, w(), 1, l);
			b.d(c, w());
			b.d(c.b(), w());
		}

	}

	@Override
	public boolean b(int var1, class_aco var2) {
		return true;
	}

	@Override
	public void y() {
		super.y();
		E();
		m();
	}

	public int n() {
		if (o == -1) {
			if ((b == null) || !(w() instanceof class_aiw)) {
				return 0;
			}

			o = ((class_aiw) w()).b;
		}

		return o;
	}

	@Override
	public String k() {
		return "minecraft:chest";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aaa(var1, this, var2);
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
		for (int var1 = 0; var1 < m.length; ++var1) {
			m[var1] = null;
		}

	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
