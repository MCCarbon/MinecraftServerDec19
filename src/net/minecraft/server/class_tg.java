package net.minecraft.server;


public class class_tg extends class_tc {
	private final class_vi c;

	public class_tg(class_vi var1, double var2) {
		super(var1, var2, 8);
		c = var1;
	}

	@Override
	public boolean a() {
		return c.cE() && !c.cG() && super.a();
	}

	@Override
	public boolean b() {
		return super.b();
	}

	@Override
	public void c() {
		super.c();
		c.cI().a(false);
	}

	@Override
	public void d() {
		super.d();
		c.o(false);
	}

	@Override
	public void e() {
		super.e();
		c.cI().a(false);
		if (!f()) {
			c.o(false);
		} else if (!c.cG()) {
			c.o(true);
		}

	}

	@Override
	protected boolean a(class_ago var1, class_cj var2) {
		if (!var1.d(var2.a())) {
			return false;
		} else {
			class_apn var3 = var1.p(var2);
			class_ail var4 = var3.c();
			if (var4 == class_aim.ae) {
				class_aoi var5 = var1.s(var2);
				if ((var5 instanceof class_aok) && (((class_aok) var5).l < 1)) {
					return true;
				}
			} else {
				if (var4 == class_aim.am) {
					return true;
				}

				if ((var4 == class_aim.C) && (var3.b(class_aij.a) != class_aij.class_a_in_class_aij.a)) {
					return true;
				}
			}

			return false;
		}
	}
}
