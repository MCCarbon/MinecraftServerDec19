package net.minecraft.server;


public abstract class class_xk extends class_xh implements class_qa {
	private class_aco[] a = new class_aco[36];
	private boolean b = true;

	public class_xk(class_ago var1) {
		super(var1);
	}

	public class_xk(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if (o.S().b("doEntityDrops")) {
			class_pr.a(o, this, this);
		}

	}

	@Override
	public class_aco a(int var1) {
		return a[var1];
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (a[var1] != null) {
			class_aco var3;
			if (a[var1].b <= var2) {
				var3 = a[var1];
				a[var1] = null;
				return var3;
			} else {
				var3 = a[var1].a(var2);
				if (a[var1].b == 0) {
					a[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		if (a[var1] != null) {
			class_aco var2 = a[var1];
			a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		a[var1] = var2;
		if ((var2 != null) && (var2.b > p_())) {
			var2.b = p_();
		}

	}

	@Override
	public void o_() {
	}

	@Override
	public boolean a(class_yu var1) {
		return I ? false : var1.h(this) <= 64.0D;
	}

	@Override
	public void b(class_yu var1) {
	}

	@Override
	public void c(class_yu var1) {
	}

	@Override
	public boolean b(int var1, class_aco var2) {
		return true;
	}

	@Override
	public String e_() {
		return k_() ? aS() : "container.minecart";
	}

	@Override
	public int p_() {
		return 64;
	}

	@Override
	public Entity a(int var1, class_cj var2) {
		b = false;
		return super.a(var1, var2);
	}

	@Override
	public void L() {
		if (b) {
			class_pr.a(o, this, this);
		}

		super.L();
	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < a.length; ++var3) {
			if (a[var3] != null) {
				class_dn var4 = new class_dn();
				var4.a("Slot", (byte) var3);
				a[var3].b(var4);
				var2.a(var4);
			}
		}

		var1.a("Items", var2);
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		class_du var2 = var1.c("Items", 10);
		a = new class_aco[n_()];

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			int var5 = var4.f("Slot") & 255;
			if ((var5 >= 0) && (var5 < a.length)) {
				a[var5] = class_aco.a(var4);
			}
		}

	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if (!o.D) {
			var1.a((class_pp) this);
		}

		return true;
	}

	@Override
	protected void o() {
		int var1 = 15 - class_zu.b(this);
		float var2 = 0.98F + (var1 * 0.001F);
		v *= var2;
		w *= 0.0D;
		x *= var2;
	}

	@Override
	public int c(int var1) {
		return 0;
	}

	@Override
	public void b(int var1, int var2) {
	}

	@Override
	public int g() {
		return 0;
	}

	@Override
	public boolean q_() {
		return false;
	}

	@Override
	public void a(class_pz var1) {
	}

	@Override
	public class_pz i() {
		return class_pz.a;
	}

	@Override
	public void l() {
		for (int var1 = 0; var1 < a.length; ++var1) {
			a[var1] = null;
		}

	}
}
