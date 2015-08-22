package net.minecraft.server;


public class class_ts extends class_sr {
	private class_vf a;
	private double b;
	private double c;
	private double d;
	private double e;

	public class_ts(class_vf var1, double var2) {
		a = var1;
		b = var2;
		this.a(1);
	}

	@Override
	public boolean a() {
		if (!a.cH() && (a.l != null)) {
			class_aym var1 = class_us.a(a, 5, 4);
			if (var1 == null) {
				return false;
			} else {
				c = var1.a;
				d = var1.b;
				e = var1.c;
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public void c() {
		a.u().a(c, d, e, b);
	}

	@Override
	public boolean b() {
		return !a.u().m() && (a.l != null);
	}

	@Override
	public void e() {
		if (a.bj().nextInt(50) == 0) {
			if (a.l instanceof class_yu) {
				int var1 = a.cV();
				int var2 = a.db();
				if ((var2 > 0) && (a.bj().nextInt(var2) < var1)) {
					a.f((class_yu) a.l);
					a.o.a(a, (byte) 7);
					return;
				}

				a.n(5);
			}

			a.l.a((class_qx) null);
			a.l = null;
			a.dp();
			a.o.a(a, (byte) 6);
		}

	}
}
