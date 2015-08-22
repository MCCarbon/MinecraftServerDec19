package net.minecraft.server;

import java.util.List;

import com.google.common.collect.Lists;

public class class_qc implements class_pp {
	private String a;
	private int b;
	private class_aco[] c;
	private List d;
	private boolean e;

	public class_qc(String var1, boolean var2, int var3) {
		a = var1;
		e = var2;
		b = var3;
		c = new class_aco[var3];
	}

	public void a(class_pq var1) {
		if (d == null) {
			d = Lists.newArrayList();
		}

		d.add(var1);
	}

	public void b(class_pq var1) {
		d.remove(var1);
	}

	@Override
	public class_aco a(int var1) {
		return (var1 >= 0) && (var1 < c.length) ? c[var1] : null;
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (c[var1] != null) {
			class_aco var3;
			if (c[var1].b <= var2) {
				var3 = c[var1];
				c[var1] = null;
				o_();
				return var3;
			} else {
				var3 = c[var1].a(var2);
				if (c[var1].b == 0) {
					c[var1] = null;
				}

				o_();
				return var3;
			}
		} else {
			return null;
		}
	}

	public class_aco a(class_aco var1) {
		class_aco var2 = var1.k();

		for (int var3 = 0; var3 < b; ++var3) {
			class_aco var4 = this.a(var3);
			if (var4 == null) {
				this.a(var3, var2);
				o_();
				return null;
			}

			if (class_aco.c(var4, var2)) {
				int var5 = Math.min(p_(), var4.c());
				int var6 = Math.min(var2.b, var5 - var4.b);
				if (var6 > 0) {
					var4.b += var6;
					var2.b -= var6;
					if (var2.b <= 0) {
						o_();
						return null;
					}
				}
			}
		}

		if (var2.b != var1.b) {
			o_();
		}

		return var2;
	}

	@Override
	public class_aco b(int var1) {
		if (c[var1] != null) {
			class_aco var2 = c[var1];
			c[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		c[var1] = var2;
		if ((var2 != null) && (var2.b > p_())) {
			var2.b = p_();
		}

		o_();
	}

	@Override
	public int n_() {
		return b;
	}

	@Override
	public String e_() {
		return a;
	}

	@Override
	public boolean k_() {
		return e;
	}

	public void a(String var1) {
		e = true;
		a = var1;
	}

	@Override
	public class_eu f_() {
		return k_() ? new class_fa(e_()) : new class_fb(e_(), new Object[0]);
	}

	@Override
	public int p_() {
		return 64;
	}

	@Override
	public void o_() {
		if (d != null) {
			for (int var1 = 0; var1 < d.size(); ++var1) {
				((class_pq) d.get(var1)).a(this);
			}
		}

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
		for (int var1 = 0; var1 < c.length; ++var1) {
			c[var1] = null;
		}

	}
}
