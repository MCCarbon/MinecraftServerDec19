package net.minecraft.server;


public class class_wc extends class_vz {
	private class_aym b;
	private int c;

	public class_wc(class_vx var1) {
		super(var1);
	}

	@Override
	public void b() {
		if ((c++ % 10) == 0) {
			float var1 = (a.bj().nextFloat() - 0.5F) * 8.0F;
			float var2 = (a.bj().nextFloat() - 0.5F) * 4.0F;
			float var3 = (a.bj().nextFloat() - 0.5F) * 8.0F;
			a.o.a(class_cy.c, a.s + var1, a.t + 2.0D + var2, a.u + var3, 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	@Override
	public void c() {
		++c;
		if (b == null) {
			class_cj var1 = a.o.m(class_aso.a);
			b = new class_aym(var1.n(), var1.o(), var1.p());
		}

		double var3 = b.c(a.s, a.t, a.u);
		if ((var3 >= 100.0D) && (var3 <= 22500.0D) && !a.D && !a.E) {
			a.c(1.0F);
		} else {
			a.c(0.0F);
		}

	}

	@Override
	public void d() {
		b = null;
		c = 0;
	}

	@Override
	public float f() {
		return 3.0F;
	}

	@Override
	public class_aym g() {
		return b;
	}

	@Override
	public class_wm i() {
		return class_wm.j;
	}
}
