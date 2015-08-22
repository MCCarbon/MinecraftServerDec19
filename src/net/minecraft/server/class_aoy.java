package net.minecraft.server;


public class class_aoy extends class_aoi {
	public byte a;
	public boolean f;

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("note", a);
		var1.a("powered", f);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = var1.f("note");
		a = (byte) class_oa.a(a, 0, 24);
		f = var1.p("powered");
	}

	public void b() {
		a = (byte) ((a + 1) % 25);
		o_();
	}

	public void a(class_ago var1, class_cj var2) {
		if (var1.p(var2.a()).c().v() == class_avq.a) {
			class_avq var3 = var1.p(var2.b()).c().v();
			byte var4 = 0;
			if (var3 == class_avq.e) {
				var4 = 1;
			}

			if (var3 == class_avq.p) {
				var4 = 2;
			}

			if (var3 == class_avq.s) {
				var4 = 3;
			}

			if (var3 == class_avq.d) {
				var4 = 4;
			}

			var1.c(var2, class_aim.B, var4, a);
		}
	}
}
