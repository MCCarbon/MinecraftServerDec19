package net.minecraft.server;


public class class_dc {
	protected final float a;
	protected final float b;
	protected final float c;

	public class_dc(float var1, float var2, float var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	public class_dc(class_du var1) {
		a = var1.f(0);
		b = var1.f(1);
		c = var1.f(2);
	}

	public class_du a() {
		class_du var1 = new class_du();
		var1.a((new class_dr(a)));
		var1.a((new class_dr(b)));
		var1.a((new class_dr(c)));
		return var1;
	}

	@Override
	public boolean equals(Object var1) {
		if (!(var1 instanceof class_dc)) {
			return false;
		} else {
			class_dc var2 = (class_dc) var1;
			return (a == var2.a) && (b == var2.b) && (c == var2.c);
		}
	}

	public float b() {
		return a;
	}

	public float c() {
		return b;
	}

	public float d() {
		return c;
	}
}
