package net.minecraft.server;


public class class_le extends class_ln {
	private boolean c;
	private boolean d;
	private int e;
	private int f;

	public class_le(class_ago var1) {
		super(var1);
	}

	@Override
	public void a() {
		super.a();
		++f;
		long var1 = a.M();
		long var3 = (var1 / 24000L) + 1L;
		if (!c && (f > 20)) {
			c = true;
			b.a.a((new class_gn(5, 0.0F)));
		}

		d = var1 > 120500L;
		if (d) {
			++e;
		}

		if ((var1 % 24000L) == 500L) {
			if (var3 <= 6L) {
				b.a((new class_fb("demo.day." + var3, new Object[0])));
			}
		} else if (var3 == 1L) {
			if (var1 == 100L) {
				b.a.a((new class_gn(5, 101.0F)));
			} else if (var1 == 175L) {
				b.a.a((new class_gn(5, 102.0F)));
			} else if (var1 == 250L) {
				b.a.a((new class_gn(5, 103.0F)));
			}
		} else if ((var3 == 5L) && ((var1 % 24000L) == 22000L)) {
			b.a((new class_fb("demo.day.warning", new Object[0])));
		}

	}

	private void f() {
		if (e > 100) {
			b.a((new class_fb("demo.reminder", new Object[0])));
			e = 0;
		}

	}

	@Override
	public void a(class_cj var1, class_cq var2) {
		if (d) {
			f();
		} else {
			super.a(var1, var2);
		}
	}

	@Override
	public void a(class_cj var1) {
		if (!d) {
			super.a(var1);
		}
	}

	@Override
	public boolean b(class_cj var1) {
		return d ? false : super.b(var1);
	}

	@Override
	public class_pw a(class_yu var1, class_ago var2, class_aco var3, class_pu var4) {
		if (d) {
			f();
			return class_pw.b;
		} else {
			return super.a(var1, var2, var3, var4);
		}
	}

	@Override
	public class_pw a(class_yu var1, class_ago var2, class_aco var3, class_pu var4, class_cj var5, class_cq var6, float var7, float var8, float var9) {
		if (d) {
			f();
			return class_pw.b;
		} else {
			return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}
	}
}
