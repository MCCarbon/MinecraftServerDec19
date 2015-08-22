package net.minecraft.server;


public class class_aas {
	private final int a;
	public final class_pp d;
	public int e;
	public int f;
	public int g;

	public class_aas(class_pp var1, int var2, int var3, int var4) {
		d = var1;
		a = var2;
		f = var3;
		g = var4;
	}

	public void a(class_aco var1, class_aco var2) {
		if ((var1 != null) && (var2 != null)) {
			if (var1.b() == var2.b()) {
				int var3 = var2.b - var1.b;
				if (var3 > 0) {
					this.a(var1, var3);
				}

			}
		}
	}

	protected void a(class_aco var1, int var2) {
	}

	protected void c(class_aco var1) {
	}

	public void a(class_yu var1, class_aco var2) {
		f();
	}

	public boolean a(class_aco var1) {
		return true;
	}

	public class_aco d() {
		return d.a(a);
	}

	public boolean e() {
		return this.d() != null;
	}

	public void d(class_aco var1) {
		d.a(a, var1);
		f();
	}

	public void f() {
		d.o_();
	}

	public int a() {
		return d.p_();
	}

	public int b(class_aco var1) {
		return this.a();
	}

	public class_aco a(int var1) {
		return d.a(a, var1);
	}

	public boolean a(class_pp var1, int var2) {
		return (var1 == d) && (var2 == a);
	}

	public boolean a(class_yu var1) {
		return true;
	}
}
