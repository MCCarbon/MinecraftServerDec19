package net.minecraft.server;


public class class_td extends class_sr {
	private EntityCreature a;
	private double b;
	private double c;
	private double d;
	private double e;

	public class_td(EntityCreature var1, double var2) {
		a = var1;
		e = var2;
		this.a(1);
	}

	@Override
	public boolean a() {
		if (a.cz()) {
			return false;
		} else {
			class_cj var1 = a.cA();
			class_aym var2 = class_us.a(a, 16, 7, new class_aym(var1.n(), var1.o(), var1.p()));
			if (var2 == null) {
				return false;
			} else {
				b = var2.a;
				c = var2.b;
				d = var2.c;
				return true;
			}
		}
	}

	@Override
	public boolean b() {
		return !a.u().m();
	}

	@Override
	public void c() {
		a.u().a(b, c, d, e);
	}
}
