package net.minecraft.server;


public class class_sv extends class_sr {
	EntityInsentient a;
	EntityLiving b;
	float c;

	public class_sv(EntityInsentient var1, float var2) {
		a = var1;
		c = var2;
		this.a(5);
	}

	@Override
	public boolean a() {
		b = a.w();
		if (b == null) {
			return false;
		} else {
			double var1 = a.h(b);
			return (var1 >= 4.0D) && (var1 <= 16.0D) ? (!a.C ? false : a.bj().nextInt(5) == 0) : false;
		}
	}

	@Override
	public boolean b() {
		return !a.C;
	}

	@Override
	public void c() {
		double var1 = b.s - a.s;
		double var3 = b.u - a.u;
		float var5 = MathHelper.a((var1 * var1) + (var3 * var3));
		a.v += ((var1 / var5) * 0.5D * 0.800000011920929D) + (a.v * 0.20000000298023224D);
		a.x += ((var3 / var5) * 0.5D * 0.800000011920929D) + (a.x * 0.20000000298023224D);
		a.w = c;
	}
}
