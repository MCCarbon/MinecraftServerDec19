package net.minecraft.server;


public class class_ln {
	public class_ago a;
	public class_lm b;
	private class_agr.class_a_in_class_agr c;
	private boolean d;
	private int e;
	private class_cj f;
	private int g;
	private boolean h;
	private class_cj i;
	private int j;
	private int k;

	public class_ln(class_ago var1) {
		c = class_agr.class_a_in_class_agr.a;
		f = class_cj.a;
		i = class_cj.a;
		k = -1;
		a = var1;
	}

	public void a(class_agr.class_a_in_class_agr var1) {
		c = var1;
		var1.a(b.bI);
		b.u();
		b.b.ar().a((new class_ha(class_ha.class_a_in_class_ha.b, new class_lm[] { b })));
	}

	public class_agr.class_a_in_class_agr b() {
		return c;
	}

	public boolean c() {
		return c.e();
	}

	public boolean d() {
		return c.d();
	}

	public void b(class_agr.class_a_in_class_agr var1) {
		if (c == class_agr.class_a_in_class_agr.a) {
			c = var1;
		}

		this.a(c);
	}

	public void a() {
		++g;
		float var3;
		int var4;
		if (h) {
			int var1 = g - j;
			class_ail var2 = a.p(i).c();
			if (var2.v() == class_avq.a) {
				h = false;
			} else {
				var3 = var2.a(b, b.o, i) * (var1 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != k) {
					a.c(b.G(), i, var4);
					k = var4;
				}

				if (var3 >= 1.0F) {
					h = false;
					this.b(i);
				}
			}
		} else if (d) {
			class_ail var5 = a.p(f).c();
			if (var5.v() == class_avq.a) {
				a.c(b.G(), f, -1);
				k = -1;
				d = false;
			} else {
				int var6 = g - e;
				var3 = var5.a(b, b.o, i) * (var6 + 1);
				var4 = (int) (var3 * 10.0F);
				if (var4 != k) {
					a.c(b.G(), f, var4);
					k = var4;
				}
			}
		}

	}

	public void a(class_cj var1, class_cq var2) {
		if (d()) {
			if (!a.a((class_yu) null, var1, var2)) {
				this.b(var1);
			}

		} else {
			class_ail var3 = a.p(var1).c();
			if (c.c()) {
				if (c == class_agr.class_a_in_class_agr.e) {
					return;
				}

				if (!b.cv()) {
					class_aco var4 = b.bG();
					if (var4 == null) {
						return;
					}

					if (!var4.c(var3)) {
						return;
					}
				}
			}

			a.a((class_yu) null, var1, var2);
			e = g;
			float var6 = 1.0F;
			if (var3.v() != class_avq.a) {
				var3.a(a, var1, b);
				var6 = var3.a(b, b.o, var1);
			}

			if ((var3.v() != class_avq.a) && (var6 >= 1.0F)) {
				this.b(var1);
			} else {
				d = true;
				f = var1;
				int var5 = (int) (var6 * 10.0F);
				a.c(b.G(), var1, var5);
				k = var5;
			}

		}
	}

	public void a(class_cj var1) {
		if (var1.equals(f)) {
			int var2 = g - e;
			class_ail var3 = a.p(var1).c();
			if (var3.v() != class_avq.a) {
				float var4 = var3.a(b, b.o, var1) * (var2 + 1);
				if (var4 >= 0.7F) {
					d = false;
					a.c(b.G(), var1, -1);
					this.b(var1);
				} else if (!h) {
					d = false;
					h = true;
					i = var1;
					j = e;
				}
			}
		}

	}

	public void e() {
		d = false;
		a.c(b.G(), f, -1);
	}

	private boolean c(class_cj var1) {
		class_apn var2 = a.p(var1);
		var2.c().a(a, var1, var2, b);
		boolean var3 = a.g(var1);
		if (var3) {
			var2.c().e(a, var1, var2);
		}

		return var3;
	}

	public boolean b(class_cj var1) {
		if (c.d() && (b.bG() != null) && (b.bG().b() instanceof class_adv)) {
			return false;
		} else {
			class_apn var2 = a.p(var1);
			class_aoi var3 = a.s(var1);
			if (c.c()) {
				if (c == class_agr.class_a_in_class_agr.e) {
					return false;
				}

				if (!b.cv()) {
					class_aco var4 = b.bG();
					if (var4 == null) {
						return false;
					}

					if (!var4.c(var2.c())) {
						return false;
					}
				}
			}

			a.a(b, 2001, var1, class_ail.f(var2));
			boolean var8 = this.c(var1);
			if (d()) {
				b.a.a((new class_fv(a, var1)));
			} else {
				class_aco var5 = b.bG();
				class_aco var6 = var5 == null ? null : var5.k();
				boolean var7 = b.b(var2.c());
				if (var5 != null) {
					var5.a(a, var2.c(), var1, b);
					if (var5.b == 0) {
						b.a(class_pu.a, (class_aco) null);
					}
				}

				if (var8 && var7) {
					var2.c().a(a, b, var1, var2, var3, var6);
				}
			}

			return var8;
		}
	}

	public class_pw a(class_yu var1, class_ago var2, class_aco var3, class_pu var4) {
		if (c == class_agr.class_a_in_class_agr.e) {
			return class_pw.b;
		} else if (var1.cB().a(var3.b())) {
			return class_pw.b;
		} else {
			int var5 = var3.b;
			int var6 = var3.i();
			class_px var7 = var3.a(var2, var1, var4);
			class_aco var8 = (class_aco) var7.b();
			if ((var8 == var3) && (var8.b == var5) && (var8.l() <= 0) && (var8.i() == var6)) {
				return var7.a();
			} else {
				var1.a(var4, var8);
				if (d()) {
					var8.b = var5;
					if (var8.e()) {
						var8.b(var6);
					}
				}

				if (var8.b == 0) {
					var1.a(var4, (class_aco) null);
				}

				if (!var1.bX()) {
					((class_lm) var1).a(var1.br);
				}

				return var7.a();
			}
		}
	}

	public class_pw a(class_yu var1, class_ago var2, class_aco var3, class_pu var4, class_cj var5, class_cq var6, float var7, float var8, float var9) {
		if (c == class_agr.class_a_in_class_agr.e) {
			class_aoi var14 = var2.s(var5);
			if (var14 instanceof class_qa) {
				class_ail var15 = var2.p(var5).c();
				class_qa var16 = (class_qa) var14;
				if ((var16 instanceof class_aok) && (var15 instanceof class_aiw)) {
					var16 = ((class_aiw) var15).e(var2, var5);
				}

				if (var16 != null) {
					var1.a((class_pp) var16);
					return class_pw.a;
				}
			} else if (var14 instanceof class_pp) {
				var1.a((class_pp) var14);
				return class_pw.a;
			}

			return class_pw.b;
		} else {
			if (!var1.aA() || (var1.bG() == null)) {
				class_apn var10 = var2.p(var5);
				if (var10.c().a(var2, var5, var10, var1, var4, var3, var6, var7, var8, var9)) {
					return class_pw.a;
				}
			}

			if (var3 == null) {
				return class_pw.b;
			} else if (var1.cB().a(var3.b())) {
				return class_pw.b;
			} else if (d()) {
				int var13 = var3.i();
				int var11 = var3.b;
				class_pw var12 = var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
				var3.b(var13);
				var3.b = var11;
				return var12;
			} else {
				return var3.a(var1, var2, var5, var4, var6, var7, var8, var9);
			}
		}
	}

	public void a(class_ll var1) {
		a = var1;
	}
}
