package net.minecraft.server;


public class class_zm extends class_zj {
	public class_zm(class_ago var1) {
		super(var1);
	}

	public class_zm(class_ago var1, class_rg var2) {
		super(var1, var2);
	}

	public class_zm(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	protected float i() {
		return 0.07F;
	}

	@Override
	protected void a(class_ayl var1) {
		if (!o.D) {
			o.b(2002, new class_cj(this), 0);
			int var2 = 3 + o.s.nextInt(5) + o.s.nextInt(5);

			while (var2 > 0) {
				int var3 = class_rd.a(var2);
				var2 -= var3;
				o.a((new class_rd(o, s, t, u, var3)));
			}

			L();
		}

	}
}
