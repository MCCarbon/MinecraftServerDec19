package net.minecraft.server;


public class class_xl extends class_xh {
	private static final class_jz c;
	private int d;
	public double a;
	public double b;

	public class_xl(class_ago var1) {
		super(var1);
	}

	public class_xl(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public class_xh.class_a_in_class_xh s() {
		return class_xh.class_a_in_class_xh.c;
	}

	@Override
	protected void h() {
		super.h();
		ac.a(c, Boolean.valueOf(false));
	}

	@Override
	public void r_() {
		super.r_();
		if (d > 0) {
			--d;
		}

		if (d <= 0) {
			a = b = 0.0D;
		}

		this.i(d > 0);
		if (this.i() && (V.nextInt(4) == 0)) {
			o.a(class_cy.m, s, t + 0.8D, u, 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	@Override
	protected double m() {
		return 0.2D;
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if (!var1.c() && o.S().b("doEntityDrops")) {
			this.a(new class_aco(Blocks.FURNACE, 1), 0.0F);
		}

	}

	@Override
	protected void a(class_cj var1, class_apn var2) {
		super.a(var1, var2);
		double var3 = (a * a) + (b * b);
		if ((var3 > 1.0E-4D) && (((v * v) + (x * x)) > 0.001D)) {
			var3 = MathHelper.a(var3);
			a /= var3;
			b /= var3;
			if (((a * v) + (b * x)) < 0.0D) {
				a = 0.0D;
				b = 0.0D;
			} else {
				double var5 = var3 / this.m();
				a *= var5;
				b *= var5;
			}
		}

	}

	@Override
	protected void o() {
		double var1 = (a * a) + (b * b);
		if (var1 > 1.0E-4D) {
			var1 = MathHelper.a(var1);
			a /= var1;
			b /= var1;
			double var3 = 1.0D;
			v *= 0.800000011920929D;
			w *= 0.0D;
			x *= 0.800000011920929D;
			v += a * var3;
			x += b * var3;
		} else {
			v *= 0.9800000190734863D;
			w *= 0.0D;
			x *= 0.9800000190734863D;
		}

		super.o();
	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if ((var2 != null) && (var2.b() == Items.j)) {
			if (!var1.bI.d) {
				--var2.b;
			}

			d += 3600;
		}

		a = s - var1.s;
		b = u - var1.u;
		return true;
	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		var1.a("PushX", a);
		var1.a("PushZ", b);
		var1.a("Fuel", (short) d);
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		a = var1.k("PushX");
		b = var1.k("PushZ");
		d = var1.g("Fuel");
	}

	protected boolean i() {
		return ((Boolean) ac.a(c)).booleanValue();
	}

	protected void i(boolean var1) {
		ac.b(c, Boolean.valueOf(var1));
	}

	@Override
	public class_apn u() {
		return (this.i() ? Blocks.LIT_FURNACE : Blocks.FURNACE).S().a(class_akj.a, class_cq.c);
	}

	static {
		c = class_kc.a(class_xl.class, class_kb.g);
	}
}
