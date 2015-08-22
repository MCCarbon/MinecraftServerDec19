package net.minecraft.server;


public class class_wf extends class_vz {
	private class_aym b;

	public class_wf(class_vx var1) {
		super(var1);
	}

	@Override
	public void b() {
		class_aym var1 = a.a(1.0F).a();
		var1.b(-0.7853982F);
		double var2 = a.bs.s;
		double var4 = a.bs.t + a.bs.K / 2.0F;
		double var6 = a.bs.u;

		for (int var8 = 0; var8 < 8; ++var8) {
			double var9 = var2 + (a.bj().nextGaussian() / 2.0D);
			double var11 = var4 + (a.bj().nextGaussian() / 2.0D);
			double var13 = var6 + (a.bj().nextGaussian() / 2.0D);
			a.o.a(class_cy.Q, var9, var11, var13, (-var1.a * 0.07999999821186066D) + a.v, (-var1.b * 0.30000001192092896D) + a.w, (-var1.c * 0.07999999821186066D) + a.x, new int[0]);
			var1.b(0.19634955F);
		}

	}

	@Override
	public void c() {
		if (b == null) {
			b = new class_aym(a.o.r(class_aso.a));
		}

		if (b.c(a.s, a.t, a.u) < 1.0D) {
			((class_wi) a.cy().b(class_wm.f)).j();
			a.cy().a(class_wm.g);
		}

	}

	@Override
	public float f() {
		return 1.5F;
	}

	@Override
	public float h() {
		float var1 = (class_oa.a((a.v * a.v) + (a.x * a.x)) * 1.0F) + 1.0F;
		float var2 = Math.min(var1, 40.0F);
		return var2 / var1;
	}

	@Override
	public void d() {
		b = null;
	}

	@Override
	public class_aym g() {
		return b;
	}

	@Override
	public class_wm i() {
		return class_wm.d;
	}
}
