package net.minecraft.server;


public class class_aah extends class_aas {
	private class_yu a;
	private int b;

	public class_aah(class_yu var1, class_pp var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		a = var1;
	}

	@Override
	public boolean a(class_aco var1) {
		return false;
	}

	@Override
	public class_aco a(int var1) {
		if (e()) {
			b += Math.min(var1, this.d().b);
		}

		return super.a(var1);
	}

	@Override
	public void a(class_yu var1, class_aco var2) {
		c(var2);
		super.a(var1, var2);
	}

	@Override
	protected void a(class_aco var1, int var2) {
		b += var2;
		c(var1);
	}

	@Override
	protected void c(class_aco var1) {
		var1.a(a.o, a, b);
		if (!a.o.D) {
			int var2 = b;
			float var3 = class_aen.a().b(var1);
			int var4;
			if (var3 == 0.0F) {
				var2 = 0;
			} else if (var3 < 1.0F) {
				var4 = class_oa.d(var2 * var3);
				if ((var4 < class_oa.f(var2 * var3)) && (Math.random() < (var2 * var3) - var4)) {
					++var4;
				}

				var2 = var4;
			}

			while (var2 > 0) {
				var4 = class_rd.a(var2);
				var2 -= var4;
				a.o.a((new class_rd(a.o, a.s, a.t + 0.5D, a.u + 0.5D, var4)));
			}
		}

		b = 0;
		if (var1.b() == Items.l) {
			a.b(class_my.k);
		}

		if (var1.b() == Items.aX) {
			a.b(class_my.p);
		}

	}
}
