package net.minecraft.server;


public class class_sh extends class_sr {
	private class_vr a;
	private class_yu b;
	private class_ago c;
	private float d;
	private int e;

	public class_sh(class_vr var1, float var2) {
		a = var1;
		c = var1.o;
		d = var2;
		this.a(2);
	}

	@Override
	public boolean a() {
		b = c.a(a, d);
		return b == null ? false : this.a(b);
	}

	@Override
	public boolean b() {
		return !b.al() ? false : (a.h(b) > d * d ? false : (e > 0) && this.a(b));
	}

	@Override
	public void c() {
		a.q(true);
		e = 40 + a.bj().nextInt(40);
	}

	@Override
	public void d() {
		a.q(false);
		b = null;
	}

	@Override
	public void e() {
		a.q().a(b.s, b.t + b.aY(), b.u, 10.0F, a.ch());
		--e;
	}

	private boolean a(class_yu var1) {
		class_pu[] var2 = class_pu.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_pu var5 = var2[var4];
			class_aco var6 = var1.b(var5);
			if (var6 != null) {
				if (a.cE() && (var6.b() == Items.aZ)) {
					return true;
				}

				if (a.d(var6)) {
					return true;
				}
			}
		}

		return false;
	}
}
