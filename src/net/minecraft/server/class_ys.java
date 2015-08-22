package net.minecraft.server;


public class class_ys {
	public boolean a;
	public boolean b;
	public boolean c;
	public boolean d;
	public boolean e = true;
	private float f = 0.05F;
	private float g = 0.1F;

	public void a(class_dn var1) {
		class_dn var2 = new class_dn();
		var2.a("invulnerable", a);
		var2.a("flying", b);
		var2.a("mayfly", c);
		var2.a("instabuild", d);
		var2.a("mayBuild", e);
		var2.a("flySpeed", f);
		var2.a("walkSpeed", g);
		var1.a("abilities", var2);
	}

	public void b(class_dn var1) {
		if (var1.b("abilities", 10)) {
			class_dn var2 = var1.o("abilities");
			a = var2.p("invulnerable");
			b = var2.p("flying");
			c = var2.p("mayfly");
			d = var2.p("instabuild");
			if (var2.b("flySpeed", 99)) {
				f = var2.j("flySpeed");
				g = var2.j("walkSpeed");
			}

			if (var2.b("mayBuild", 1)) {
				e = var2.p("mayBuild");
			}
		}

	}

	public float a() {
		return f;
	}

	public float b() {
		return g;
	}
}
