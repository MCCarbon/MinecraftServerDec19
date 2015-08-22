package net.minecraft.server;


public class class_ta extends class_sr {
	private class_rn a;
	private class_uu b;
	private int c = -1;
	private int d = -1;

	public class_ta(class_rn var1) {
		a = var1;
		this.a(1);
	}

	@Override
	public boolean a() {
		class_cj var1 = new class_cj(a);
		if ((!a.o.z() || (a.o.U() && !a.o.b(var1).e())) && !a.o.t.m()) {
			if (a.bj().nextInt(50) != 0) {
				return false;
			} else if ((c != -1) && (a.e(c, a.t, d) < 4.0D)) {
				return false;
			} else {
				class_uv var2 = a.o.ag().a(var1, 14);
				if (var2 == null) {
					return false;
				} else {
					b = var2.c(var1);
					return b != null;
				}
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean b() {
		return !a.u().m();
	}

	@Override
	public void c() {
		c = -1;
		class_cj var1 = b.e();
		int var2 = var1.n();
		int var3 = var1.o();
		int var4 = var1.p();
		if (a.b(var1) > 256.0D) {
			class_aym var5 = class_us.a(a, 14, 3, new class_aym(var2 + 0.5D, var3, var4 + 0.5D));
			if (var5 != null) {
				a.u().a(var5.a, var5.b, var5.c, 1.0D);
			}
		} else {
			a.u().a(var2 + 0.5D, var3, var4 + 0.5D, 1.0D);
		}

	}

	@Override
	public void d() {
		c = b.e().n();
		d = b.e().p();
		b = null;
	}
}
