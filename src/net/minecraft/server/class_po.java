package net.minecraft.server;


public class class_po implements class_qa {
	private String a;
	private class_qa b;
	private class_qa c;

	public class_po(String var1, class_qa var2, class_qa var3) {
		a = var1;
		if (var2 == null) {
			var2 = var3;
		}

		if (var3 == null) {
			var3 = var2;
		}

		b = var2;
		c = var3;
		if (var2.q_()) {
			var3.a(var2.i());
		} else if (var3.q_()) {
			var2.a(var3.i());
		}

	}

	@Override
	public int n_() {
		return b.n_() + c.n_();
	}

	public boolean a(class_pp var1) {
		return (b == var1) || (c == var1);
	}

	@Override
	public String e_() {
		return b.k_() ? b.e_() : (c.k_() ? c.e_() : a);
	}

	@Override
	public boolean k_() {
		return b.k_() || c.k_();
	}

	@Override
	public IChatBaseComponent f_() {
		return k_() ? new class_fa(e_()) : new class_fb(e_(), new Object[0]);
	}

	@Override
	public class_aco a(int var1) {
		return var1 >= b.n_() ? c.a(var1 - b.n_()) : b.a(var1);
	}

	@Override
	public class_aco a(int var1, int var2) {
		return var1 >= b.n_() ? c.a(var1 - b.n_(), var2) : b.a(var1, var2);
	}

	@Override
	public class_aco b(int var1) {
		return var1 >= b.n_() ? c.b(var1 - b.n_()) : b.b(var1);
	}

	@Override
	public void a(int var1, class_aco var2) {
		if (var1 >= b.n_()) {
			c.a(var1 - b.n_(), var2);
		} else {
			b.a(var1, var2);
		}

	}

	@Override
	public int p_() {
		return b.p_();
	}

	@Override
	public void o_() {
		b.o_();
		c.o_();
	}

	@Override
	public boolean a(class_yu var1) {
		return b.a(var1) && c.a(var1);
	}

	@Override
	public void b(class_yu var1) {
		b.b(var1);
		c.b(var1);
	}

	@Override
	public void c(class_yu var1) {
		b.c(var1);
		c.c(var1);
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
	public boolean q_() {
		return b.q_() || c.q_();
	}

	@Override
	public void a(class_pz var1) {
		b.a(var1);
		c.a(var1);
	}

	@Override
	public class_pz i() {
		return b.i();
	}

	@Override
	public String k() {
		return b.k();
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aaa(var1, this, var2);
	}

	@Override
	public void l() {
		b.l();
		c.l();
	}
}
