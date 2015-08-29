package net.minecraft.server;


public class class_tn extends class_sr {
	private EntityCreature a;
	private double b;
	private double c;
	private double d;
	private double e;
	private int f;
	private boolean g;

	public class_tn(EntityCreature var1, double var2) {
		this(var1, var2, 120);
	}

	public class_tn(EntityCreature var1, double var2, int var4) {
		a = var1;
		e = var2;
		f = var4;
		this.a(1);
	}

	@Override
	public boolean a() {
		if (!g) {
			if (a.bo() >= 100) {
				return false;
			}

			if (a.bj().nextInt(f) != 0) {
				return false;
			}
		}

		class_aym var1 = class_us.a(a, 10, 7);
		if (var1 == null) {
			return false;
		} else {
			b = var1.a;
			c = var1.b;
			d = var1.c;
			g = false;
			return true;
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

	public void f() {
		g = true;
	}

	public void b(int var1) {
		f = var1;
	}
}
