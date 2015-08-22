package net.minecraft.server;

import java.util.List;

public class class_xm extends class_xk implements class_aou {
	private boolean a = true;
	private int b = -1;
	private class_cj c;

	public class_xm(class_ago var1) {
		super(var1);
		c = class_cj.a;
	}

	public class_xm(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
		c = class_cj.a;
	}

	@Override
	public class_xh.class_a_in_class_xh s() {
		return class_xh.class_a_in_class_xh.f;
	}

	@Override
	public class_apn u() {
		return class_aim.cp.S();
	}

	@Override
	public int w() {
		return 1;
	}

	@Override
	public int n_() {
		return 5;
	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if (!o.D) {
			var1.a((class_pp) this);
		}

		return true;
	}

	@Override
	public void a(int var1, int var2, int var3, boolean var4) {
		boolean var5 = !var4;
		if (var5 != y()) {
			this.i(var5);
		}

	}

	public boolean y() {
		return a;
	}

	public void i(boolean var1) {
		a = var1;
	}

	@Override
	public class_ago z() {
		return o;
	}

	@Override
	public double A() {
		return s;
	}

	@Override
	public double B() {
		return t + 0.5D;
	}

	@Override
	public double C() {
		return u;
	}

	@Override
	public void r_() {
		super.r_();
		if (!o.D && al() && y()) {
			class_cj var1 = new class_cj(this);
			if (var1.equals(c)) {
				--b;
			} else {
				this.l(0);
			}

			if (!E()) {
				this.l(0);
				if (D()) {
					this.l(4);
					o_();
				}
			}
		}

	}

	public boolean D() {
		if (class_aov.a(this)) {
			return true;
		} else {
			List var1 = o.a(class_xg.class, aX().b(0.25D, 0.0D, 0.25D), class_rb.a);
			if (!var1.isEmpty()) {
				class_aov.a(this, ((class_xg) var1.get(0)));
			}

			return false;
		}
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if (o.S().b("doEntityDrops")) {
			this.a(class_acm.a(class_aim.cp), 1, 0.0F);
		}

	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		var1.a("TransferCooldown", b);
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		b = var1.h("TransferCooldown");
	}

	public void l(int var1) {
		b = var1;
	}

	public boolean E() {
		return b > 0;
	}

	@Override
	public String k() {
		return "minecraft:hopper";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aai(var1, this, var2);
	}
}
