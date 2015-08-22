package net.minecraft.server;


public class class_zh extends class_zj {
	public class_zh(class_ago var1) {
		super(var1);
	}

	public class_zh(class_ago var1, class_rg var2) {
		super(var1, var2);
	}

	public class_zh(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	protected void a(class_ayl var1) {
		if (var1.d != null) {
			byte var2 = 0;
			if (var1.d instanceof class_xs) {
				var2 = 3;
			}

			var1.d.a(class_qi.a((Entity) this, (Entity) this.j()), var2);
		}

		for (int var3 = 0; var3 < 8; ++var3) {
			o.a(class_cy.F, s, t, u, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		if (!o.D) {
			L();
		}

	}
}
