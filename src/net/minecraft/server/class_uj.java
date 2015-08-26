package net.minecraft.server;


public abstract class class_uj extends class_sr {
	protected final class_rn e;
	protected boolean f;
	private boolean a;
	private int b;
	private int c;
	private int d;

	public class_uj(class_rn var1, boolean var2) {
		this(var1, var2, false);
	}

	public class_uj(class_rn var1, boolean var2, boolean var3) {
		e = var1;
		f = var2;
		a = var3;
	}

	@Override
	public boolean b() {
		class_rg var1 = e.w();
		if (var1 == null) {
			return false;
		} else if (!var1.al()) {
			return false;
		} else {
			class_ayu var2 = e.aE();
			class_ayu var3 = var1.aE();
			if ((var2 != null) && (var3 == var2)) {
				return false;
			} else {
				double var4 = f();
				if (e.h(var1) > (var4 * var4)) {
					return false;
				} else {
					if (f) {
						if (e.v().a(var1)) {
							d = 0;
						} else if (++d > 60) {
							return false;
						}
					}

					return !(var1 instanceof class_yu) || !((class_yu) var1).bI.a;
				}
			}
		}
	}

	protected double f() {
		class_rq var1 = e.a(class_yf.b);
		return var1 == null ? 16.0D : var1.e();
	}

	@Override
	public void c() {
		b = 0;
		c = 0;
		d = 0;
	}

	@Override
	public void d() {
		e.c((class_rg) null);
	}

	public static boolean a(class_rh var0, class_rg var1, boolean var2, boolean var3) {
		if (var1 == null) {
			return false;
		} else if (var1 == var0) {
			return false;
		} else if (!var1.al()) {
			return false;
		} else if (!var0.a(var1.getClass())) {
			return false;
		} else if (var0.k(var1)) {
			return false;
		} else {
			if ((var0 instanceof class_rm) && (((class_rm) var0).b() != null)) {
				if ((var1 instanceof class_rm) && ((class_rm) var0).b().equals(var1.aQ())) {
					return false;
				}

				if (var1 == ((class_rm) var0).l_()) {
					return false;
				}
			} else if ((var1 instanceof class_yu) && !var2 && ((class_yu) var1).bI.a) {
				return false;
			}

			return !var3 || var0.v().a(var1);
		}
	}

	protected boolean a(class_rg var1, boolean var2) {
		if (!a(e, var1, var2, f)) {
			return false;
		} else if (!e.e(new class_cj(var1))) {
			return false;
		} else {
			if (a) {
				if (--c <= 0) {
					b = 0;
				}

				if (b == 0) {
					b = this.a(var1) ? 1 : 2;
				}

				if (b == 2) {
					return false;
				}
			}

			return true;
		}
	}

	private boolean a(class_rg var1) {
		c = 10 + e.bj().nextInt(5);
		class_axc var2 = e.u().a(var1);
		if (var2 == null) {
			return false;
		} else {
			class_axa var3 = var2.c();
			if (var3 == null) {
				return false;
			} else {
				int var4 = var3.a - MathHelper.c(var1.s);
				int var5 = var3.c - MathHelper.c(var1.u);
				return (var4 * var4) + (var5 * var5) <= 2.25D;
			}
		}
	}
}
