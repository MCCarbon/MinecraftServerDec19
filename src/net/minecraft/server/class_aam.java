package net.minecraft.server;


public class class_aam implements class_pp {
	private final class_aga a;
	private class_aco[] b = new class_aco[3];
	private final class_yu c;
	private class_agb d;
	private int e;

	public class_aam(class_yu var1, class_aga var2) {
		c = var1;
		a = var2;
	}

	@Override
	public int n_() {
		return b.length;
	}

	@Override
	public class_aco a(int var1) {
		return b[var1];
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (b[var1] != null) {
			class_aco var3;
			if (var1 == 2) {
				var3 = b[var1];
				b[var1] = null;
				return var3;
			} else if (b[var1].b <= var2) {
				var3 = b[var1];
				b[var1] = null;
				if (e(var1)) {
					h();
				}

				return var3;
			} else {
				var3 = b[var1].a(var2);
				if (b[var1].b == 0) {
					b[var1] = null;
				}

				if (e(var1)) {
					h();
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	private boolean e(int var1) {
		return (var1 == 0) || (var1 == 1);
	}

	@Override
	public class_aco b(int var1) {
		if (b[var1] != null) {
			class_aco var2 = b[var1];
			b[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		b[var1] = var2;
		if ((var2 != null) && (var2.b > p_())) {
			var2.b = p_();
		}

		if (e(var1)) {
			h();
		}

	}

	@Override
	public String e_() {
		return "mob.villager";
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
	public int p_() {
		return 64;
	}

	@Override
	public boolean a(class_yu var1) {
		return a.t_() == var1;
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
	public void o_() {
		h();
	}

	public void h() {
		d = null;
		class_aco var1 = b[0];
		class_aco var2 = b[1];
		if (var1 == null) {
			var1 = var2;
			var2 = null;
		}

		if (var1 == null) {
			this.a(2, (class_aco) null);
		} else {
			class_agc var3 = a.a_(c);
			if (var3 != null) {
				class_agb var4 = var3.a(var1, var2, e);
				if ((var4 != null) && !var4.h()) {
					d = var4;
					this.a(2, var4.d().k());
				} else if (var2 != null) {
					var4 = var3.a(var2, var1, e);
					if ((var4 != null) && !var4.h()) {
						d = var4;
						this.a(2, var4.d().k());
					} else {
						this.a(2, (class_aco) null);
					}
				} else {
					this.a(2, (class_aco) null);
				}
			}
		}

		a.a_(this.a(2));
	}

	public class_agb i() {
		return d;
	}

	public void d(int var1) {
		e = var1;
		h();
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
		for (int var1 = 0; var1 < b.length; ++var1) {
			b[var1] = null;
		}

	}
}
