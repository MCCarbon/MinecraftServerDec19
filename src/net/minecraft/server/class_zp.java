package net.minecraft.server;


public class class_zp extends class_za {
	private static final class_jz a;

	public class_zp(class_ago var1) {
		super(var1);
		this.a(0.3125F, 0.3125F);
	}

	public class_zp(class_ago var1, class_rg var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
		this.a(0.3125F, 0.3125F);
	}

	@Override
	protected float k() {
		return this.m() ? 0.73F : super.k();
	}

	@Override
	public boolean ay() {
		return false;
	}

	@Override
	public float a(class_agk var1, class_ago var2, class_cj var3, class_apn var4) {
		float var5 = super.a(var1, var2, var3, var4);
		Block var6 = var4.c();
		if (this.m() && class_wq.a(var6)) {
			var5 = Math.min(0.8F, var5);
		}

		return var5;
	}

	@Override
	protected void a(class_ayl var1) {
		if (!o.D) {
			if (var1.d != null) {
				if (b != null) {
					if (var1.d.a(class_qi.a(b), 8.0F)) {
						if (!var1.d.al()) {
							b.b(5.0F);
						} else {
							this.a(b, var1.d);
						}
					}
				} else {
					var1.d.a(class_qi.l, 5.0F);
				}

				if (var1.d instanceof class_rg) {
					byte var2 = 0;
					if (o.ac() == class_ps.c) {
						var2 = 10;
					} else if (o.ac() == class_ps.d) {
						var2 = 40;
					}

					if (var2 > 0) {
						((class_rg) var1.d).c(new class_qr(class_qs.t, 20 * var2, 1));
					}
				}
			}

			o.a(this, s, t, u, 1.0F, false, o.S().b("mobGriefing"));
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

	@Override
	protected void h() {
		ac.a(a, Boolean.valueOf(false));
	}

	public boolean m() {
		return ((Boolean) ac.a(a)).booleanValue();
	}

	public void a(boolean var1) {
		ac.b(a, Boolean.valueOf(var1));
	}

	@Override
	protected boolean j() {
		return false;
	}

	static {
		a = class_kc.a(class_zp.class, class_kb.g);
	}
}
