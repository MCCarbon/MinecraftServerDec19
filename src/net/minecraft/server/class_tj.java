package net.minecraft.server;


public class class_tj extends class_sr {
	private class_rn b;
	protected double a;
	private double c;
	private double d;
	private double e;

	public class_tj(class_rn var1, double var2) {
		b = var1;
		a = var2;
		this.a(1);
	}

	@Override
	public boolean a() {
		if ((b.bk() == null) && !b.ay()) {
			return false;
		} else {
			class_aym var1 = class_us.a(b, 5, 4);
			if (var1 == null) {
				return false;
			} else {
				c = var1.a;
				d = var1.b;
				e = var1.c;
				return true;
			}
		}
	}

	@Override
	public void c() {
		b.u().a(c, d, e, a);
	}

	@Override
	public boolean b() {
		return !b.u().m();
	}
}
