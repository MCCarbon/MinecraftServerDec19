package net.minecraft.server;


public class class_wi extends class_wa {
	private int b;
	private int c;
	private class_qv d;

	public class_wi(class_vx var1) {
		super(var1);
	}

	@Override
	public void b() {
		++b;
		if (((b % 2) == 0) && (b < 10)) {
			class_aym var1 = a.a(1.0F).a();
			var1.b(-0.7853982F);
			double var2 = a.bs.s;
			double var4 = a.bs.t + a.bs.K / 2.0F;
			double var6 = a.bs.u;

			for (int var8 = 0; var8 < 8; ++var8) {
				double var9 = var2 + (a.bj().nextGaussian() / 2.0D);
				double var11 = var4 + (a.bj().nextGaussian() / 2.0D);
				double var13 = var6 + (a.bj().nextGaussian() / 2.0D);

				for (int var15 = 0; var15 < 6; ++var15) {
					a.o.a(class_cy.Q, var9, var11, var13, -var1.a * 0.07999999821186066D * var15, -var1.b * 0.6000000238418579D, -var1.c * 0.07999999821186066D * var15, new int[0]);
				}

				var1.b(0.19634955F);
			}
		}

	}

	@Override
	public void c() {
		++b;
		if (b >= 200) {
			if (c >= 4) {
				a.cy().a(class_wm.e);
			} else {
				a.cy().a(class_wm.g);
			}
		} else if (b == 10) {
			class_aym var1 = (new class_aym(a.bs.s - a.s, 0.0D, a.bs.u - a.u)).a();
			float var2 = 5.0F;
			double var3 = a.bs.s + ((var1.a * var2) / 2.0D);
			double var5 = a.bs.u + ((var1.c * var2) / 2.0D);
			double var7 = a.bs.t + a.bs.K / 2.0F;
			class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj(MathHelper.c(var3), MathHelper.c(var7), MathHelper.c(var5));

			while (a.o.d(var9)) {
				--var7;
				var9.c(MathHelper.c(var3), MathHelper.c(var7), MathHelper.c(var5));
			}

			var7 = MathHelper.c(var7) + 1;
			d = new class_qv(a.o, var3, var7, var5);
			d.a(a);
			d.a(var2);
			d.b(200);
			d.a(class_cy.Q);
			d.a(new class_qr(class_qs.g));
			a.o.a(d);
		}

	}

	@Override
	public void d() {
		b = 0;
		++c;
	}

	@Override
	public void e() {
		if (d != null) {
			d.L();
			d = null;
		}

	}

	@Override
	public class_wm i() {
		return class_wm.f;
	}

	public void j() {
		c = 0;
	}
}
