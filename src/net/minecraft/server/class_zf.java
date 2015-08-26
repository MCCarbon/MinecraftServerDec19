package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;

public class class_zf extends Entity {
	private class_rg a;
	private Entity b;
	private class_cq c;
	private int d;
	private double e;
	private double f;
	private double g;
	private UUID h;
	private class_cj i;
	private UUID as;
	private class_cj at;

	public class_zf(class_ago var1) {
		super(var1);
		this.a(0.3125F, 0.3125F);
		T = true;
	}

	public class_zf(class_ago var1, class_rg var2, Entity var3, class_cq.class_a_in_class_cq var4) {
		this(var1);
		a = var2;
		class_cj var5 = new class_cj(var2);
		double var6 = var5.n() + 0.5D;
		double var8 = var5.o() + 0.5D;
		double var10 = var5.p() + 0.5D;
		this.b(var6, var8, var10, y, z);
		b = var3;
		c = class_cq.b;
		this.a(var4);
	}

	@Override
	protected void b(class_dn var1) {
		class_cj var2;
		class_dn var3;
		if (a != null) {
			var2 = new class_cj(a);
			var3 = class_dy.a(a.aQ());
			var3.a("X", var2.n());
			var3.a("Y", var2.o());
			var3.a("Z", var2.p());
			var1.a("Owner", var3);
		}

		if (b != null) {
			var2 = new class_cj(b);
			var3 = class_dy.a(b.aQ());
			var3.a("X", var2.n());
			var3.a("Y", var2.o());
			var3.a("Z", var2.p());
			var1.a("Target", var3);
		}

		if (c != null) {
			var1.a("Dir", c.a());
		}

		var1.a("Steps", d);
		var1.a("TXD", e);
		var1.a("TYD", f);
		var1.a("TZD", g);
	}

	@Override
	protected void a(class_dn var1) {
		d = var1.h("Steps");
		e = var1.k("TXD");
		f = var1.k("TYD");
		g = var1.k("TZD");
		if (var1.b("Dir", 99)) {
			c = class_cq.a(var1.h("Dir"));
		}

		class_dn var2;
		if (var1.b("Owner", 10)) {
			var2 = var1.o("Owner");
			h = class_dy.b(var2);
			i = new class_cj(var2.h("X"), var2.h("Y"), var2.h("Z"));
		}

		if (var1.b("Target", 10)) {
			var2 = var1.o("Target");
			as = class_dy.b(var2);
			at = new class_cj(var2.h("X"), var2.h("Y"), var2.h("Z"));
		}

	}

	@Override
	protected void h() {
	}

	private void a(class_cq var1) {
		c = var1;
	}

	private void a(class_cq.class_a_in_class_cq var1) {
		double var3 = 0.5D;
		class_cj var2;
		if (b == null) {
			var2 = (new class_cj(this)).b();
		} else {
			var3 = b.K * 0.5D;
			var2 = new class_cj(b.s, b.t + var3, b.u);
		}

		double var5 = var2.n() + 0.5D;
		double var7 = var2.o() + var3;
		double var9 = var2.p() + 0.5D;
		class_cq var11 = null;
		if (var2.d(s, t, u) >= 4.0D) {
			class_cj var12 = new class_cj(this);
			ArrayList var13 = Lists.newArrayList();
			if (var1 != class_cq.class_a_in_class_cq.a) {
				if ((var12.n() < var2.n()) && o.d(var12.f())) {
					var13.add(class_cq.f);
				} else if ((var12.n() > var2.n()) && o.d(var12.e())) {
					var13.add(class_cq.e);
				}
			}

			if (var1 != class_cq.class_a_in_class_cq.b) {
				if ((var12.o() < var2.o()) && o.d(var12.a())) {
					var13.add(class_cq.b);
				} else if ((var12.o() > var2.o()) && o.d(var12.b())) {
					var13.add(class_cq.a);
				}
			}

			if (var1 != class_cq.class_a_in_class_cq.c) {
				if ((var12.p() < var2.p()) && o.d(var12.d())) {
					var13.add(class_cq.d);
				} else if ((var12.p() > var2.p()) && o.d(var12.c())) {
					var13.add(class_cq.c);
				}
			}

			var11 = class_cq.a(V);
			if (var13.isEmpty()) {
				for (int var14 = 5; !o.d(var12.a(var11)) && (var14 > 0); --var14) {
					var11 = class_cq.a(V);
				}
			} else {
				var11 = (class_cq) var13.get(V.nextInt(var13.size()));
			}

			var5 = s + var11.g();
			var7 = t + var11.h();
			var9 = u + var11.i();
		}

		this.a(var11);
		double var20 = var5 - s;
		double var21 = var7 - t;
		double var16 = var9 - u;
		double var18 = MathHelper.a((var20 * var20) + (var21 * var21) + (var16 * var16));
		if (var18 == 0.0D) {
			e = 0.0D;
			f = 0.0D;
			g = 0.0D;
		} else {
			e = (var20 / var18) * 0.15D;
			f = (var21 / var18) * 0.15D;
			g = (var16 / var18) * 0.15D;
		}

		ai = true;
		d = 10 + (V.nextInt(5) * 10);
	}

	@Override
	public void r_() {
		super.r_();
		if (!o.D) {
			List var1;
			Iterator var2;
			class_rg var3;
			if ((b == null) && (as != null)) {
				var1 = o.a(class_rg.class, new class_ayk(at.a(-2, -2, -2), at.a(2, 2, 2)));
				var2 = var1.iterator();

				while (var2.hasNext()) {
					var3 = (class_rg) var2.next();
					if (var3.aQ().equals(as)) {
						b = var3;
						break;
					}
				}

				as = null;
			}

			if ((a == null) && (h != null)) {
				var1 = o.a(class_rg.class, new class_ayk(i.a(-2, -2, -2), i.a(2, 2, 2)));
				var2 = var1.iterator();

				while (var2.hasNext()) {
					var3 = (class_rg) var2.next();
					if (var3.aQ().equals(h)) {
						a = var3;
						break;
					}
				}

				h = null;
			}

			if ((b == null) || !b.al() || ((b instanceof class_yu) && ((class_yu) b).w())) {
				w -= 0.04D;
			} else {
				e = MathHelper.a(e * 1.025D, -1.0D, 1.0D);
				f = MathHelper.a(f * 1.025D, -1.0D, 1.0D);
				g = MathHelper.a(g * 1.025D, -1.0D, 1.0D);
				v += (e - v) * 0.2D;
				w += (f - w) * 0.2D;
				x += (g - x) * 0.2D;
			}

			class_ayl var4 = class_ze.a(this, true, false, a);
			if (var4 != null) {
				this.a(var4);
			}
		}

		this.b(s + v, t + w, u + x);
		class_ze.a(this, 0.5F);
		if (o.D) {
			o.a(class_cy.R, s - v, (t - w) + 0.15D, u - x, 0.0D, 0.0D, 0.0D, new int[0]);
		} else if ((b != null) && !b.I) {
			if (d > 0) {
				--d;
				if (d == 0) {
					this.a(c == null ? null : c.k());
				}
			}

			if (c != null) {
				class_cj var5 = new class_cj(this);
				class_cq.class_a_in_class_cq var6 = c.k();
				if (o.d(var5.a(c), false)) {
					this.a(var6);
				} else {
					class_cj var7 = new class_cj(b);
					if (((var6 == class_cq.class_a_in_class_cq.a) && (var5.n() == var7.n())) || ((var6 == class_cq.class_a_in_class_cq.c) && (var5.p() == var7.p())) || ((var6 == class_cq.class_a_in_class_cq.b) && (var5.o() == var7.o()))) {
						this.a(var6);
					}
				}
			}
		}

	}

	@Override
	public boolean ay() {
		return false;
	}

	@Override
	public float f(float var1) {
		return 1.0F;
	}

	protected void a(class_ayl var1) {
		if (var1.d == null) {
			((class_ll) o).a(class_cy.b, s, t, u, 2, 0.2D, 0.2D, 0.2D, 0.0D, new int[0]);
			this.a("mob.irongolem.hit", 1.0F, 1.0F);
		} else {
			boolean var2 = var1.d.a(class_qi.a(this, a), 4.0F);
			if (var2) {
				this.a(a, var1.d);
				if (var1.d instanceof class_rg) {
					((class_rg) var1.d).c(new class_qr(class_qs.y, 200));
				}
			}
		}

		L();
	}

	@Override
	public boolean ag() {
		return true;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (!o.D) {
			this.a("mob.irongolem.hit", 1.0F, 1.0F);
			((class_ll) o).a(class_cy.j, s, t, u, 15, 0.2D, 0.2D, 0.2D, 0.0D, new int[0]);
			L();
		}

		return true;
	}
}
