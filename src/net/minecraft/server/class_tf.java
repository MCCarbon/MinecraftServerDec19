package net.minecraft.server;


public class class_tf extends class_sr {
	class_ago a;
	EntityInsentient b;
	EntityLiving c;
	int d;

	public class_tf(EntityInsentient var1) {
		b = var1;
		a = var1.o;
		this.a(3);
	}

	@Override
	public boolean a() {
		EntityLiving var1 = b.w();
		if (var1 == null) {
			return false;
		} else {
			c = var1;
			return true;
		}
	}

	@Override
	public boolean b() {
		return !c.al() ? false : (b.h(c) > 225.0D ? false : !b.u().m() || this.a());
	}

	@Override
	public void d() {
		c = null;
		b.u().n();
	}

	@Override
	public void e() {
		b.q().a(c, 30.0F, 30.0F);
		double var1 = b.J * 2.0F * b.J * 2.0F;
		double var3 = b.e(c.s, c.aX().b, c.u);
		double var5 = 0.8D;
		if ((var3 > var1) && (var3 < 16.0D)) {
			var5 = 1.33D;
		} else if (var3 < 225.0D) {
			var5 = 0.6D;
		}

		b.u().a(c, var5);
		d = Math.max(d - 1, 0);
		if (var3 <= var1) {
			if (d <= 0) {
				d = 20;
				b.r(c);
			}
		}
	}
}
