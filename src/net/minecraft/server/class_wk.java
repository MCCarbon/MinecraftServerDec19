package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_wk extends class_vz {
	private static final Logger b = LogManager.getLogger();
	private int c;
	private class_axc d;
	private class_aym e;
	private class_rg f;
	private boolean g;

	public class_wk(class_vx var1) {
		super(var1);
	}

	@Override
	public void c() {
		if (f == null) {
			b.warn("Skipping player strafe phase because no player was found");
			a.cy().a(class_wm.a);
		} else {
			double var1;
			double var3;
			double var9;
			if ((d != null) && d.b()) {
				var1 = f.s;
				var3 = f.u;
				double var5 = var1 - a.s;
				double var7 = var3 - a.u;
				var9 = MathHelper.a((var5 * var5) + (var7 * var7));
				double var11 = Math.min((0.4000000059604645D + (var9 / 80.0D)) - 1.0D, 10.0D);
				e = new class_aym(var1, f.t + var11, var3);
			}

			var1 = e == null ? 0.0D : e.c(a.s, a.t, a.u);
			if ((var1 < 100.0D) || (var1 > 22500.0D)) {
				j();
			}

			var3 = 64.0D;
			if (f.h(a) < (var3 * var3)) {
				if (a.t(f)) {
					++c;
					class_aym var25 = (new class_aym(f.s - a.s, 0.0D, f.u - a.u)).a();
					class_aym var6 = (new class_aym(MathHelper.a((a.y * 3.1415927F) / 180.0F), 0.0D, (-MathHelper.b((a.y * 3.1415927F) / 180.0F)))).a();
					float var26 = (float) var6.b(var25);
					float var8 = (float) ((Math.acos(var26) * 180.0D) / 3.1415927410125732D);
					var8 += 0.5F;
					if ((c >= 5) && (var8 >= 0.0F) && (var8 < 10.0F)) {
						var9 = 1.0D;
						class_aym var27 = a.g(1.0F);
						double var12 = a.bs.s - (var27.a * var9);
						double var14 = a.bs.t + a.bs.K / 2.0F + 0.5D;
						double var16 = a.bs.u - (var27.c * var9);
						double var18 = f.s - var12;
						double var20 = (f.t + f.K / 2.0F) - (var14 + a.bs.K / 2.0F);
						double var22 = f.u - var16;
						a.o.a((class_yu) null, 1008, new class_cj(a), 0);
						class_yy var24 = new class_yy(a.o, a, var18, var20, var22);
						var24.s = var12;
						var24.t = var14;
						var24.u = var16;
						a.o.a(var24);
						c = 0;
						if (d != null) {
							while (!d.b()) {
								d.a();
							}
						}

						a.cy().a(class_wm.a);
					}
				} else if (c > 0) {
					--c;
				}
			} else if (c > 0) {
				--c;
			}

		}
	}

	private void j() {
		if ((d == null) || d.b()) {
			int var1 = a.n();
			int var2 = var1;
			if (a.bj().nextInt(8) == 0) {
				g = !g;
				var2 = var1 + 6;
			}

			if (g) {
				++var2;
			} else {
				--var2;
			}

			if ((a.cz() != null) && (a.cz().c() >= 0)) {
				var2 %= 12;
				if (var2 < 0) {
					var2 += 12;
				}
			} else {
				var2 -= 12;
				var2 &= 7;
				var2 += 12;
			}

			d = a.a(var1, var2, (class_axa) null);
			if (d != null) {
				d.a();
			}
		}

		k();
	}

	private void k() {
		if ((d != null) && !d.b()) {
			class_aym var1 = d.f();
			d.a();
			double var2 = var1.a;
			double var6 = var1.c;

			double var4;
			do {
				var4 = var1.b + a.bj().nextFloat() * 20.0F;
			} while (var4 < var1.b);

			e = new class_aym(var2, var4, var6);
		}

	}

	@Override
	public void d() {
		c = 0;
		e = null;
		d = null;
		f = null;
	}

	public void a(class_rg var1) {
		f = var1;
		int var2 = a.n();
		int var3 = a.k(f.s, f.t, f.u);
		int var4 = MathHelper.c(f.s);
		int var5 = MathHelper.c(f.u);
		double var6 = var4 - a.s;
		double var8 = var5 - a.u;
		double var10 = MathHelper.a((var6 * var6) + (var8 * var8));
		double var12 = Math.min((0.4000000059604645D + (var10 / 80.0D)) - 1.0D, 10.0D);
		int var14 = MathHelper.c(f.t + var12);
		class_axa var15 = new class_axa(var4, var14, var5);
		d = a.a(var2, var3, var15);
		if (d != null) {
			d.a();
			k();
		}

	}

	@Override
	public class_aym g() {
		return e;
	}

	@Override
	public class_wm i() {
		return class_wm.b;
	}
}
