package net.minecraft.server;


public class class_zg extends class_za {
	public class_zg(class_ago var1) {
		super(var1);
		this.a(0.3125F, 0.3125F);
	}

	public class_zg(class_ago var1, class_rg var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
		this.a(0.3125F, 0.3125F);
	}

	@Override
	protected void a(class_ayl var1) {
		if (!o.D) {
			boolean var2;
			if (var1.d != null) {
				var2 = var1.d.a(class_qi.a((class_za) this, (Entity) b), 5.0F);
				if (var2) {
					this.a(b, var1.d);
					if (!var1.d.W()) {
						var1.d.e(5);
					}
				}
			} else {
				var2 = true;
				if ((b != null) && (b instanceof class_rh)) {
					var2 = o.S().b("mobGriefing");
				}

				if (var2) {
					class_cj var3 = var1.a().a(var1.b);
					if (o.d(var3)) {
						o.a(var3, Blocks.ab.S());
					}
				}
			}

			L();
		}

	}

	@Override
	public boolean ag() {
		return false;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		return false;
	}
}
