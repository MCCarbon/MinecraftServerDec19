package net.minecraft.server;


public class class_agb {
	private class_aco a;
	private class_aco b;
	private class_aco c;
	private int d;
	private int e;
	private boolean f;

	public class_agb(class_dn var1) {
		this.a(var1);
	}

	public class_agb(class_aco var1, class_aco var2, class_aco var3) {
		this(var1, var2, var3, 0, 7);
	}

	public class_agb(class_aco var1, class_aco var2, class_aco var3, int var4, int var5) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
		e = var5;
		f = true;
	}

	public class_agb(class_aco var1, class_aco var2) {
		this(var1, (class_aco) null, var2);
	}

	public class_agb(class_aco var1, Item var2) {
		this(var1, new class_aco(var2));
	}

	public class_aco a() {
		return a;
	}

	public class_aco b() {
		return b;
	}

	public boolean c() {
		return b != null;
	}

	public class_aco d() {
		return c;
	}

	public int e() {
		return d;
	}

	public int f() {
		return e;
	}

	public void g() {
		++d;
	}

	public void a(int var1) {
		e += var1;
	}

	public boolean h() {
		return d >= e;
	}

	public boolean j() {
		return f;
	}

	public void a(class_dn var1) {
		class_dn var2 = var1.o("buy");
		a = class_aco.a(var2);
		class_dn var3 = var1.o("sell");
		c = class_aco.a(var3);
		if (var1.b("buyB", 10)) {
			b = class_aco.a(var1.o("buyB"));
		}

		if (var1.b("uses", 99)) {
			d = var1.h("uses");
		}

		if (var1.b("maxUses", 99)) {
			e = var1.h("maxUses");
		} else {
			e = 7;
		}

		if (var1.b("rewardExp", 1)) {
			f = var1.p("rewardExp");
		} else {
			f = true;
		}

	}

	public class_dn k() {
		class_dn var1 = new class_dn();
		var1.a("buy", a.b(new class_dn()));
		var1.a("sell", c.b(new class_dn()));
		if (b != null) {
			var1.a("buyB", b.b(new class_dn()));
		}

		var1.a("uses", d);
		var1.a("maxUses", e);
		var1.a("rewardExp", f);
		return var1;
	}
}
