package net.minecraft.server;

import java.util.Random;

public class class_sn extends class_sr {
	private EntityCreature a;
	private double b;
	private double c;
	private double d;
	private double e;
	private class_ago f;

	public class_sn(EntityCreature var1, double var2) {
		a = var1;
		e = var2;
		f = var1.o;
		this.a(1);
	}

	@Override
	public boolean a() {
		if (!f.z()) {
			return false;
		} else if (!a.ay()) {
			return false;
		} else if (!f.i(new class_cj(a.s, a.aX().b, a.u))) {
			return false;
		} else {
			class_aym var1 = f();
			if (var1 == null) {
				return false;
			} else {
				b = var1.a;
				c = var1.b;
				d = var1.c;
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

	private class_aym f() {
		Random var1 = a.bj();
		class_cj var2 = new class_cj(a.s, a.aX().b, a.u);

		for (int var3 = 0; var3 < 10; ++var3) {
			class_cj var4 = var2.a(var1.nextInt(20) - 10, var1.nextInt(6) - 3, var1.nextInt(20) - 10);
			if (!f.i(var4) && (a.a(var4) < 0.0F)) {
				return new class_aym(var4.n(), var4.o(), var4.p());
			}
		}

		return null;
	}
}
