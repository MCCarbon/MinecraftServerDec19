package net.minecraft.server;


public class class_aaq implements class_pp {
	private class_aco[] a = new class_aco[1];

	@Override
	public int n_() {
		return 1;
	}

	@Override
	public class_aco a(int var1) {
		return a[0];
	}

	@Override
	public String e_() {
		return "Result";
	}

	@Override
	public boolean k_() {
		return false;
	}

	@Override
	public IChatBaseComponent f_() {
		return k_() ? new class_fa(e_()) : new class_fb(e_(), new Object[0]);
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (a[0] != null) {
			class_aco var3 = a[0];
			a[0] = null;
			return var3;
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		if (a[0] != null) {
			class_aco var2 = a[0];
			a[0] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		a[0] = var2;
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
}
