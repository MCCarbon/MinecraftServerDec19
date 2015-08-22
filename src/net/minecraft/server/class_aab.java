package net.minecraft.server;


public class class_aab implements class_pp {
	private final class_aco[] a;
	private final int b;
	private final int c;
	private final class_zu d;

	public class_aab(class_zu var1, int var2, int var3) {
		int var4 = var2 * var3;
		a = new class_aco[var4];
		d = var1;
		b = var2;
		c = var3;
	}

	@Override
	public int n_() {
		return a.length;
	}

	@Override
	public class_aco a(int var1) {
		return var1 >= n_() ? null : a[var1];
	}

	public class_aco c(int var1, int var2) {
		return (var1 >= 0) && (var1 < b) && (var2 >= 0) && (var2 <= c) ? this.a(var1 + (var2 * b)) : null;
	}

	@Override
	public String e_() {
		return "container.crafting";
	}

	@Override
	public boolean k_() {
		return false;
	}

	@Override
	public class_eu f_() {
		return k_() ? new class_fa(e_()) : new class_fb(e_(), new Object[0]);
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
	public class_aco a(int var1, int var2) {
		if (a[var1] != null) {
			class_aco var3;
			if (a[var1].b <= var2) {
				var3 = a[var1];
				a[var1] = null;
				d.a(this);
				return var3;
			} else {
				var3 = a[var1].a(var2);
				if (a[var1].b == 0) {
					a[var1] = null;
				}

				d.a(this);
				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		a[var1] = var2;
		d.a(this);
	}

	@Override
	public int p_() {
		return 64;
	}

	@Override
	public void o_() {
	}

	@Override
	public boolean a(class_yu var1) {
		return true;
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
	public void l() {
		for (int var1 = 0; var1 < a.length; ++var1) {
			a[var1] = null;
		}

	}

	public int h() {
		return c;
	}

	public int i() {
		return b;
	}
}
