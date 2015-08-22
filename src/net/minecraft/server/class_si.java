package net.minecraft.server;


public class class_si extends class_sl {
	private int g;
	private int h = -1;

	public class_si(class_rh var1) {
		super(var1);
	}

	@Override
	public boolean a() {
		if (!super.a()) {
			return false;
		} else if (!a.o.S().b("mobGriefing")) {
			return false;
		} else {
			return !class_ajn.f((class_ags) a.o, b);
		}
	}

	@Override
	public void c() {
		super.c();
		g = 0;
	}

	@Override
	public boolean b() {
		double var1 = a.b(b);
		boolean var3;
		if (g <= 240) {
			if (!class_ajn.f((class_ags) a.o, b) && (var1 < 4.0D)) {
				var3 = true;
				return var3;
			}
		}

		var3 = false;
		return var3;
	}

	@Override
	public void d() {
		super.d();
		a.o.c(a.G(), b, -1);
	}

	@Override
	public void e() {
		super.e();
		if (a.bj().nextInt(20) == 0) {
			a.o.b(1010, b, 0);
		}

		++g;
		int var1 = (int) ((g / 240.0F) * 10.0F);
		if (var1 != h) {
			a.o.c(a.G(), b, var1);
			h = var1;
		}

		if ((g == 240) && (a.o.ac() == class_ps.d)) {
			a.o.g(b);
			a.o.b(1012, b, 0);
			a.o.b(2001, b, class_ail.a(c));
		}

	}
}
