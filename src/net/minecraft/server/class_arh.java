package net.minecraft.server;


public class class_arh extends class_arc {
	private class_arg g = null;

	@Override
	public void b() {
		c = new class_ahi(class_ahb.y, 0.0F);
		e = true;
		class_dn var1 = b.R().a(class_ard.c);
		g = b instanceof class_ll ? new class_arg((class_ll) b, var1.o("DragonFight")) : null;
	}

	@Override
	public class_aqk c() {
		return new class_aru(b, b.L());
	}

	@Override
	public float a(long var1, float var3) {
		return 0.0F;
	}

	@Override
	public boolean e() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean a(int var1, int var2) {
		return b.c(new class_cj(var1, 0, var2)).v().c();
	}

	@Override
	public class_cj h() {
		return new class_cj(100, 50, 0);
	}

	@Override
	public int i() {
		return 50;
	}

	@Override
	public class_ard p() {
		return class_ard.c;
	}

	@Override
	public void q() {
		class_dn var1 = new class_dn();
		if (g != null) {
			var1.a("DragonFight", g.a());
		}

		b.R().a(class_ard.c, var1);
	}

	@Override
	public void r() {
		if (g != null) {
			g.b();
		}

	}

	public class_arg s() {
		return g;
	}
}
