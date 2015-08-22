package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_sq extends class_sr {
	class_vc a;
	class_vc b;
	double c;
	private int d;

	public class_sq(class_vc var1, double var2) {
		a = var1;
		c = var2;
	}

	@Override
	public boolean a() {
		if (a.k() >= 0) {
			return false;
		} else {
			List var1 = a.o.a(a.getClass(), a.aX().b(8.0D, 4.0D, 8.0D));
			class_vc var2 = null;
			double var3 = Double.MAX_VALUE;
			Iterator var5 = var1.iterator();

			while (var5.hasNext()) {
				class_vc var6 = (class_vc) var5.next();
				if (var6.k() >= 0) {
					double var7 = a.h(var6);
					if (var7 <= var3) {
						var3 = var7;
						var2 = var6;
					}
				}
			}

			if (var2 == null) {
				return false;
			} else if (var3 < 9.0D) {
				return false;
			} else {
				b = var2;
				return true;
			}
		}
	}

	@Override
	public boolean b() {
		if (a.k() >= 0) {
			return false;
		} else if (!b.al()) {
			return false;
		} else {
			double var1 = a.h(b);
			return (var1 >= 9.0D) && (var1 <= 256.0D);
		}
	}

	@Override
	public void c() {
		d = 0;
	}

	@Override
	public void d() {
		b = null;
	}

	@Override
	public void e() {
		if (--d <= 0) {
			d = 10;
			a.u().a(b, c);
		}
	}
}
