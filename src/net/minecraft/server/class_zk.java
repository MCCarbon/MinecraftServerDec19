package net.minecraft.server;


public class class_zk extends class_zj {
	public class_zk(class_ago var1) {
		super(var1);
	}

	public class_zk(class_ago var1, class_rg var2) {
		super(var1, var2);
	}

	public class_zk(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	protected void a(class_ayl var1) {
		if (var1.d != null) {
			var1.d.a(class_qi.a((Entity) this, (Entity) this.j()), 0.0F);
		}

		if (!o.D && (V.nextInt(8) == 0)) {
			byte var2 = 1;
			if (V.nextInt(32) == 0) {
				var2 = 4;
			}

			for (int var3 = 0; var3 < var2; ++var3) {
				class_vd var4 = new class_vd(o);
				var4.b(-24000);
				var4.b(s, t, u, y, 0.0F);
				o.a(var4);
			}
		}

		double var5 = 0.08D;

		for (int var6 = 0; var6 < 8; ++var6) {
			o.a(class_cy.K, s, t, u, (V.nextFloat() - 0.5D) * 0.08D, (V.nextFloat() - 0.5D) * 0.08D, (V.nextFloat() - 0.5D) * 0.08D, new int[] { Item.b(Items.aR) });
		}

		if (!o.D) {
			L();
		}

	}
}
