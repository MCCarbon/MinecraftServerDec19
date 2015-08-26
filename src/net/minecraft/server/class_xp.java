package net.minecraft.server;


public class class_xp extends class_xh {
	private int a = -1;

	public class_xp(class_ago var1) {
		super(var1);
	}

	public class_xp(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public class_xh.class_a_in_class_xh s() {
		return class_xh.class_a_in_class_xh.d;
	}

	@Override
	public class_apn u() {
		return Blocks.TNT.S();
	}

	@Override
	public void r_() {
		super.r_();
		if (a > 0) {
			--a;
			o.a(class_cy.l, s, t + 0.5D, u, 0.0D, 0.0D, 0.0D, new int[0]);
		} else if (a == 0) {
			this.b((v * v) + (x * x));
		}

		if (D) {
			double var1 = (v * v) + (x * x);
			if (var1 >= 0.009999999776482582D) {
				this.b(var1);
			}
		}

	}

	@Override
	public boolean a(class_qi var1, float var2) {
		Entity var3 = var1.i();
		if (var3 instanceof class_yx) {
			class_yx var4 = (class_yx) var3;
			if (var4.ay()) {
				this.b((var4.v * var4.v) + (var4.w * var4.w) + (var4.x * var4.x));
			}
		}

		return super.a(var1, var2);
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		double var2 = (v * v) + (x * x);
		if (!var1.c() && o.S().b("doEntityDrops")) {
			this.a(new class_aco(Blocks.TNT, 1), 0.0F);
		}

		if (var1.o() || var1.c() || (var2 >= 0.009999999776482582D)) {
			this.b(var2);
		}

	}

	protected void b(double var1) {
		if (!o.D) {
			double var3 = Math.sqrt(var1);
			if (var3 > 5.0D) {
				var3 = 5.0D;
			}

			o.a(this, s, t, u, (float) (4.0D + (V.nextDouble() * 1.5D * var3)), true);
			L();
		}

	}

	@Override
	public void e(float var1, float var2) {
		if (var1 >= 3.0F) {
			float var3 = var1 / 10.0F;
			this.b(var3 * var3);
		}

		super.e(var1, var2);
	}

	@Override
	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4 && (a < 0)) {
			this.i();
		}

	}

	public void i() {
		a = 80;
		if (!o.D) {
			o.a(this, (byte) 10);
			if (!T()) {
				o.a(this, "game.tnt.primed", 1.0F, 1.0F);
			}
		}

	}

	public boolean k() {
		return a > -1;
	}

	@Override
	public float a(class_agk var1, class_ago var2, class_cj var3, class_apn var4) {
		return !this.k() || (!class_aih.d(var4) && !class_aih.d(var2, var3.a())) ? super.a(var1, var2, var3, var4) : 0.0F;
	}

	@Override
	public boolean a(class_agk var1, class_ago var2, class_cj var3, class_apn var4, float var5) {
		return !this.k() || (!class_aih.d(var4) && !class_aih.d(var2, var3.a())) ? super.a(var1, var2, var3, var4, var5) : false;
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		if (var1.b("TNTFuse", 99)) {
			a = var1.h("TNTFuse");
		}

	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		var1.a("TNTFuse", a);
	}
}
