package net.minecraft.server;


public class class_zc extends class_za {
	public int a = 1;

	public class_zc(class_ago var1) {
		super(var1);
	}

	public class_zc(class_ago var1, class_rg var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
	}

	@Override
	protected void a(class_ayl var1) {
		if (!o.D) {
			if (var1.d != null) {
				var1.d.a(class_qi.a((class_za) this, (class_qx) b), 6.0F);
				this.a(b, var1.d);
			}

			boolean var2 = o.S().b("mobGriefing");
			o.a((class_qx) null, s, t, u, a, var2, var2);
			L();
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("ExplosionPower", a);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("ExplosionPower", 99)) {
			a = var1.h("ExplosionPower");
		}

	}
}
