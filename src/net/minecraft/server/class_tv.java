package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_tv extends class_sr {
	private EntityVillager a;
	private EntityVillagerGolem b;
	private int c;
	private boolean d;

	public class_tv(EntityVillager var1) {
		a = var1;
		this.a(3);
	}

	@Override
	public boolean a() {
		if (a.k() >= 0) {
			return false;
		} else if (!a.o.z()) {
			return false;
		} else {
			List var1 = a.o.a(EntityVillagerGolem.class, a.aX().b(6.0D, 2.0D, 6.0D));
			if (var1.isEmpty()) {
				return false;
			} else {
				Iterator var2 = var1.iterator();

				while (var2.hasNext()) {
					EntityVillagerGolem var3 = (EntityVillagerGolem) var2.next();
					if (var3.cF() > 0) {
						b = var3;
						break;
					}
				}

				return b != null;
			}
		}
	}

	@Override
	public boolean b() {
		return b.cF() > 0;
	}

	@Override
	public void c() {
		c = a.bj().nextInt(320);
		d = false;
		b.u().n();
	}

	@Override
	public void d() {
		b = null;
		a.u().n();
	}

	@Override
	public void e() {
		a.q().a(b, 30.0F, 30.0F);
		if (b.cF() == c) {
			a.u().a(b, 0.5D);
			d = true;
		}

		if (d && (a.h(b) < 4.0D)) {
			b.a(false);
			a.u().n();
		}

	}
}
