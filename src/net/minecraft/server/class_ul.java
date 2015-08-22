package net.minecraft.server;

import java.util.Iterator;

public class class_ul extends class_um {
	protected class_axf a;
	private boolean f;

	public class_ul(class_rh var1, class_ago var2) {
		super(var1, var2);
	}

	@Override
	protected class_axd a() {
		a = new class_axf();
		a.a(true);
		return new class_axd(a);
	}

	@Override
	protected boolean b() {
		return b.C || (h() && o()) || (b.az() && (b instanceof class_yl) && (b.m instanceof class_vd));
	}

	@Override
	protected class_aym c() {
		return new class_aym(b.s, p(), b.u);
	}

	private int p() {
		if (b.Y() && h()) {
			int var1 = (int) b.aX().b;
			Block var2 = c.p(new class_cj(class_oa.c(b.s), var1, class_oa.c(b.u))).c();
			int var3 = 0;

			do {
				if ((var2 != Blocks.i) && (var2 != Blocks.j)) {
					return var1;
				}

				++var1;
				var2 = c.p(new class_cj(class_oa.c(b.s), var1, class_oa.c(b.u))).c();
				++var3;
			} while (var3 <= 16);

			return (int) b.aX().b;
		} else {
			return (int) (b.aX().b + 0.5D);
		}
	}

	@Override
	protected void d() {
		super.d();
		if (f) {
			if (c.i(new class_cj(class_oa.c(b.s), (int) (b.aX().b + 0.5D), class_oa.c(b.u)))) {
				return;
			}

			for (int var1 = 0; var1 < d.d(); ++var1) {
				class_axa var2 = d.a(var1);
				if (c.i(new class_cj(var2.a, var2.b, var2.c))) {
					d.b(var1 - 1);
					return;
				}
			}
		}

	}

	@Override
	protected boolean a(class_aym var1, class_aym var2, int var3, int var4, int var5) {
		int var6 = class_oa.c(var1.a);
		int var7 = class_oa.c(var1.c);
		double var8 = var2.a - var1.a;
		double var10 = var2.c - var1.c;
		double var12 = (var8 * var8) + (var10 * var10);
		if (var12 < 1.0E-8D) {
			return false;
		} else {
			double var14 = 1.0D / Math.sqrt(var12);
			var8 *= var14;
			var10 *= var14;
			var3 += 2;
			var5 += 2;
			if (!this.a(var6, (int) var1.b, var7, var3, var4, var5, var1, var8, var10)) {
				return false;
			} else {
				var3 -= 2;
				var5 -= 2;
				double var16 = 1.0D / Math.abs(var8);
				double var18 = 1.0D / Math.abs(var10);
				double var20 = var6 * 1 - var1.a;
				double var22 = var7 * 1 - var1.c;
				if (var8 >= 0.0D) {
					++var20;
				}

				if (var10 >= 0.0D) {
					++var22;
				}

				var20 /= var8;
				var22 /= var10;
				int var24 = var8 < 0.0D ? -1 : 1;
				int var25 = var10 < 0.0D ? -1 : 1;
				int var26 = class_oa.c(var2.a);
				int var27 = class_oa.c(var2.c);
				int var28 = var26 - var6;
				int var29 = var27 - var7;

				do {
					if (((var28 * var24) <= 0) && ((var29 * var25) <= 0)) {
						return true;
					}

					if (var20 < var22) {
						var20 += var16;
						var6 += var24;
						var28 = var26 - var6;
					} else {
						var22 += var18;
						var7 += var25;
						var29 = var27 - var7;
					}
				} while (this.a(var6, (int) var1.b, var7, var3, var4, var5, var1, var8, var10));

				return false;
			}
		}
	}

	private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, class_aym var7, double var8, double var10) {
		int var12 = var1 - (var4 / 2);
		int var13 = var3 - (var6 / 2);
		if (!this.b(var12, var2, var13, var4, var5, var6, var7, var8, var10)) {
			return false;
		} else {
			for (int var14 = var12; var14 < (var12 + var4); ++var14) {
				for (int var15 = var13; var15 < (var13 + var6); ++var15) {
					double var16 = (var14 + 0.5D) - var7.a;
					double var18 = (var15 + 0.5D) - var7.c;
					if (((var16 * var8) + (var18 * var10)) >= 0.0D) {
						Block var20 = c.p(new class_cj(var14, var2 - 1, var15)).c();
						class_avq var21 = var20.v();
						if (var21 == class_avq.a) {
							return false;
						}

						if ((var21 == class_avq.h) && !b.Y()) {
							return false;
						}

						if (var21 == class_avq.i) {
							return false;
						}
					}
				}
			}

			return true;
		}
	}

	private boolean b(int var1, int var2, int var3, int var4, int var5, int var6, class_aym var7, double var8, double var10) {
		Iterator var12 = class_cj.a(new class_cj(var1, var2, var3), new class_cj((var1 + var4) - 1, (var2 + var5) - 1, (var3 + var6) - 1)).iterator();

		while (var12.hasNext()) {
			class_cj var13 = (class_cj) var12.next();
			double var14 = (var13.n() + 0.5D) - var7.a;
			double var16 = (var13.p() + 0.5D) - var7.c;
			if (((var14 * var8) + (var16 * var10)) >= 0.0D) {
				Block var18 = c.p(var13).c();
				if (!var18.b(c, var13)) {
					return false;
				}
			}
		}

		return true;
	}

	public void a(boolean var1) {
		a.c(var1);
	}

	public boolean e() {
		return a.f();
	}

	public void b(boolean var1) {
		a.b(var1);
	}

	public void c(boolean var1) {
		a.a(var1);
	}

	public boolean g() {
		return a.c();
	}

	public void d(boolean var1) {
		a.d(var1);
	}

	public boolean h() {
		return a.e();
	}

	public void e(boolean var1) {
		f = var1;
	}
}
