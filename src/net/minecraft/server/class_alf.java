package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public abstract class class_alf extends class_ail {
	public static final class_aqb b = class_aqb.a("level", 0, 15);

	protected class_alf(class_avq var1) {
		super(var1);
		this.j(M.b().a(b, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.a(true);
	}

	@Override
	public boolean b(class_ags var1, class_cj var2) {
		return J != class_avq.i;
	}

	public static float b(int var0) {
		if (var0 >= 8) {
			var0 = 0;
		}

		return (var0 + 1) / 9.0F;
	}

	protected int e(class_ags var1, class_cj var2) {
		return var1.p(var2).c().v() == J ? ((Integer) var1.p(var2).b(b)).intValue() : -1;
	}

	protected int f(class_ags var1, class_cj var2) {
		int var3 = this.e(var1, var2);
		return var3 >= 8 ? 0 : var3;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean a(class_apn var1, boolean var2) {
		return var2 && (((Integer) var1.b(b)).intValue() == 0);
	}

	@Override
	public boolean b(class_ags var1, class_cj var2, class_cq var3) {
		class_avq var4 = var1.p(var2).c().v();
		return var4 == J ? false : (var3 == class_cq.b ? true : (var4 == class_avq.w ? false : super.b(var1, var2, var3)));
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public int b() {
		return 1;
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	protected class_aym h(class_ags var1, class_cj var2) {
		class_aym var3 = new class_aym(0.0D, 0.0D, 0.0D);
		int var4 = this.f(var1, var2);
		Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

		class_cq var6;
		class_cj var7;
		while (var5.hasNext()) {
			var6 = (class_cq) var5.next();
			var7 = var2.a(var6);
			int var8 = this.f(var1, var7);
			int var9;
			if (var8 < 0) {
				if (!var1.p(var7).c().v().c()) {
					var8 = this.f(var1, var7.b());
					if (var8 >= 0) {
						var9 = var8 - (var4 - 8);
						var3 = var3.b((var7.n() - var2.n()) * var9, (var7.o() - var2.o()) * var9, (var7.p() - var2.p()) * var9);
					}
				}
			} else if (var8 >= 0) {
				var9 = var8 - var4;
				var3 = var3.b((var7.n() - var2.n()) * var9, (var7.o() - var2.o()) * var9, (var7.p() - var2.p()) * var9);
			}
		}

		if (((Integer) var1.p(var2).b(b)).intValue() >= 8) {
			var5 = class_cq.class_c_in_class_cq.a.iterator();

			do {
				if (!var5.hasNext()) {
					return var3.a();
				}

				var6 = (class_cq) var5.next();
				var7 = var2.a(var6);
			} while (!this.b(var1, var7, var6) && !this.b(var1, var7.a(), var6));

			var3 = var3.a().b(0.0D, -6.0D, 0.0D);
		}

		return var3.a();
	}

	@Override
	public class_aym a(class_ago var1, class_cj var2, class_qx var3, class_aym var4) {
		return var4.e(h(var1, var2));
	}

	@Override
	public int a(class_ago var1) {
		return J == class_avq.h ? 5 : (J == class_avq.i ? (var1.t.m() ? 10 : 30) : 0);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.f(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		this.f(var1, var2, var3);
	}

	public boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (J == class_avq.i) {
			boolean var4 = false;
			class_cq[] var5 = class_cq.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				class_cq var8 = var5[var7];
				if ((var8 != class_cq.a) && (var1.p(var2.a(var8)).c().v() == class_avq.h)) {
					var4 = true;
					break;
				}
			}

			if (var4) {
				Integer var9 = (Integer) var3.b(b);
				if (var9.intValue() == 0) {
					var1.a(var2, class_aim.Z.S());
					this.d(var1, var2);
					return true;
				}

				if (var9.intValue() <= 4) {
					var1.a(var2, class_aim.e.S());
					this.d(var1, var2);
					return true;
				}
			}
		}

		return false;
	}

	protected void d(class_ago var1, class_cj var2) {
		double var3 = var2.n();
		double var5 = var2.o();
		double var7 = var2.p();
		var1.a(var3 + 0.5D, var5 + 0.5D, var7 + 0.5D, "random.fizz", 0.5F, 2.6F + ((var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F));

		for (int var9 = 0; var9 < 8; ++var9) {
			var1.a(class_cy.m, var3 + Math.random(), var5 + 1.2D, var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	@Override
	public class_apn a(int var1) {
		return S().a(b, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(b)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b });
	}

	public static class_ajr a(class_avq var0) {
		if (var0 == class_avq.h) {
			return class_aim.i;
		} else if (var0 == class_avq.i) {
			return class_aim.k;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}

	public static class_anh b(class_avq var0) {
		if (var0 == class_avq.h) {
			return class_aim.j;
		} else if (var0 == class_avq.i) {
			return class_aim.l;
		} else {
			throw new IllegalArgumentException("Invalid material");
		}
	}
}
