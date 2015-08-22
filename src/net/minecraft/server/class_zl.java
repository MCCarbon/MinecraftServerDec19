package net.minecraft.server;


public class class_zl extends class_zj {
	private class_rg d;

	public class_zl(class_ago var1) {
		super(var1);
	}

	public class_zl(class_ago var1, class_rg var2) {
		super(var1, var2);
		d = var2;
	}

	@Override
	protected void a(class_ayl var1) {
		class_rg var2 = this.j();
		if (var1.d != null) {
			if (var1.d == d) {
				return;
			}

			var1.d.a(class_qi.a((class_qx) this, (class_qx) var2), 0.0F);
		}

		if (var1.a == class_ayl.class_a_in_class_ayl.b) {
			class_cj var3 = var1.a();
			class_aoi var4 = o.s(var3);
			if (var4 instanceof class_apc) {
				class_apc var5 = (class_apc) var4;
				if (var2 != null) {
					var5.a(var2);
					L();
					return;
				}

				var5.a(this);
				return;
			}
		}

		for (int var6 = 0; var6 < 32; ++var6) {
			o.a(class_cy.y, s, t + (V.nextDouble() * 2.0D), u, V.nextGaussian(), 0.0D, V.nextGaussian(), new int[0]);
		}

		if (!o.D) {
			if (var2 instanceof class_lm) {
				class_lm var7 = (class_lm) var2;
				if (var7.a.a().g() && (var7.o == o) && !var7.bQ()) {
					if ((V.nextFloat() < 0.05F) && o.S().b("doMobSpawning")) {
						class_xw var8 = new class_xw(o);
						var8.a(true);
						var8.b(var2.s, var2.t, var2.u, var2.y, var2.z);
						o.a(var8);
					}

					if (var2.az()) {
						var2.a((class_qx) null);
					}

					var2.a(s, t, u);
					var2.O = 0.0F;
					var2.a(class_qi.i, 5.0F);
				}
			} else if (var2 != null) {
				var2.a(s, t, u);
				var2.O = 0.0F;
			}

			L();
		}

	}

	@Override
	public void r_() {
		class_rg var1 = this.j();
		if ((var1 != null) && (var1 instanceof class_yu) && !var1.al()) {
			L();
		} else {
			super.r_();
		}

	}
}
