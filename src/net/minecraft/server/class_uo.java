package net.minecraft.server;


public class class_uo extends class_um {
	public class_uo(EntityInsentient var1, class_ago var2) {
		super(var1, var2);
	}

	@Override
	protected class_axd a() {
		return new class_axd(new class_axe());
	}

	@Override
	protected boolean b() {
		return o();
	}

	@Override
	protected class_aym c() {
		return new class_aym(b.s, b.t + (b.K * 0.5D), b.u);
	}

	@Override
	protected void l() {
		class_aym var1 = c();
		float var2 = b.J * b.J;
		byte var3 = 6;
		if (var1.g(d.a(b, d.e())) < var2) {
			d.a();
		}

		for (int var4 = Math.min(d.e() + var3, d.d() - 1); var4 > d.e(); --var4) {
			class_aym var5 = d.a(b, var4);
			if ((var5.g(var1) <= 36.0D) && this.a(var1, var5, 0, 0, 0)) {
				d.c(var4);
				break;
			}
		}

		this.a(var1);
	}

	@Override
	protected void d() {
		super.d();
	}

	@Override
	protected boolean a(class_aym var1, class_aym var2, int var3, int var4, int var5) {
		class_ayl var6 = c.a(var1, new class_aym(var2.a, var2.b + (b.K * 0.5D), var2.c), false, true, false);
		return (var6 == null) || (var6.a == class_ayl.class_a_in_class_ayl.a);
	}
}
