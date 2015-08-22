package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class class_sj extends class_sr {
	private class_vc d;
	class_ago a;
	private class_vc e;
	int b;
	double c;

	public class_sj(class_vc var1, double var2) {
		d = var1;
		a = var1.o;
		c = var2;
		this.a(3);
	}

	@Override
	public boolean a() {
		if (!d.cK()) {
			return false;
		} else {
			e = f();
			return e != null;
		}
	}

	@Override
	public boolean b() {
		return e.al() && e.cK() && (b < 60);
	}

	@Override
	public void d() {
		e = null;
		b = 0;
	}

	@Override
	public void e() {
		d.q().a(e, 10.0F, d.ch());
		d.u().a(e, c);
		++b;
		if ((b >= 60) && (d.h(e) < 9.0D)) {
			g();
		}

	}

	private class_vc f() {
		float var1 = 8.0F;
		List var2 = a.a(d.getClass(), d.aX().b(var1, var1, var1));
		double var3 = Double.MAX_VALUE;
		class_vc var5 = null;
		Iterator var6 = var2.iterator();

		while (var6.hasNext()) {
			class_vc var7 = (class_vc) var6.next();
			if (d.a(var7) && (d.h(var7) < var3)) {
				var5 = var7;
				var3 = d.h(var7);
			}
		}

		return var5;
	}

	private void g() {
		class_qu var1 = d.a((class_qu) e);
		if (var1 != null) {
			class_yu var2 = d.cJ();
			if ((var2 == null) && (e.cJ() != null)) {
				var2 = e.cJ();
			}

			if (var2 != null) {
				var2.b(class_nh.B);
				if (d instanceof class_ve) {
					var2.b(class_my.H);
				}
			}

			d.b(6000);
			e.b(6000);
			d.cL();
			e.cL();
			var1.b(-24000);
			var1.b(d.s, d.t, d.u, 0.0F, 0.0F);
			a.a(var1);
			Random var3 = d.bj();

			for (int var4 = 0; var4 < 7; ++var4) {
				double var5 = var3.nextGaussian() * 0.02D;
				double var7 = var3.nextGaussian() * 0.02D;
				double var9 = var3.nextGaussian() * 0.02D;
				double var11 = (var3.nextDouble() * d.J * 2.0D) - d.J;
				double var13 = 0.5D + (var3.nextDouble() * d.K);
				double var15 = (var3.nextDouble() * d.J * 2.0D) - d.J;
				a.a(class_cy.I, d.s + var11, d.t + var13, d.u + var15, var5, var7, var9, new int[0]);
			}

			if (a.S().b("doMobLoot")) {
				a.a((new class_rd(a, d.s, d.t, d.u, var3.nextInt(7) + 1)));
			}

		}
	}
}
