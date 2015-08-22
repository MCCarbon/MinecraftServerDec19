package net.minecraft.server;


public class class_tq extends class_sr {
	private class_rn a;
	private class_uu b;

	public class_tq(class_rn var1) {
		a = var1;
		if (!(var1.u() instanceof class_ul)) {
			throw new IllegalArgumentException("Unsupported mob type for RestrictOpenDoorGoal");
		}
	}

	@Override
	public boolean a() {
		if (a.o.z()) {
			return false;
		} else {
			class_cj var1 = new class_cj(a);
			class_uv var2 = a.o.ag().a(var1, 16);
			if (var2 == null) {
				return false;
			} else {
				b = var2.b(var1);
				return b == null ? false : b.b(var1) < 2.25D;
			}
		}
	}

	@Override
	public boolean b() {
		return a.o.z() ? false : !b.i() && b.c(new class_cj(a));
	}

	@Override
	public void c() {
		((class_ul) a.u()).b(false);
		((class_ul) a.u()).c(false);
	}

	@Override
	public void d() {
		((class_ul) a.u()).b(true);
		((class_ul) a.u()).c(true);
		b = null;
	}

	@Override
	public void e() {
		b.b();
	}
}
