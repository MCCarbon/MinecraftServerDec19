package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_tk extends class_sr {
	private EntityVillager a;
	private EntityLiving b;
	private double c;
	private int d;

	public class_tk(EntityVillager var1, double var2) {
		a = var1;
		c = var2;
		this.a(1);
	}

	@Override
	public boolean a() {
		if (a.k() >= 0) {
			return false;
		} else if (a.bj().nextInt(400) != 0) {
			return false;
		} else {
			List var1 = a.o.a(EntityVillager.class, a.aX().b(6.0D, 3.0D, 6.0D));
			double var2 = Double.MAX_VALUE;
			Iterator var4 = var1.iterator();

			while (var4.hasNext()) {
				EntityVillager var5 = (EntityVillager) var4.next();
				if ((var5 != a) && !var5.cG() && (var5.k() < 0)) {
					double var6 = var5.h(a);
					if (var6 <= var2) {
						var2 = var6;
						b = var5;
					}
				}
			}

			if (b == null) {
				class_aym var8 = class_us.a(a, 16, 3);
				if (var8 == null) {
					return false;
				}
			}

			return true;
		}
	}

	@Override
	public boolean b() {
		return d > 0;
	}

	@Override
	public void c() {
		if (b != null) {
			a.n(true);
		}

		d = 1000;
	}

	@Override
	public void d() {
		a.n(false);
		b = null;
	}

	@Override
	public void e() {
		--d;
		if (b != null) {
			if (a.h(b) > 4.0D) {
				a.u().a(b, c);
			}
		} else if (a.u().m()) {
			class_aym var1 = class_us.a(a, 16, 3);
			if (var1 == null) {
				return;
			}

			a.u().a(var1.a, var1.b, var1.c, c);
		}

	}
}
