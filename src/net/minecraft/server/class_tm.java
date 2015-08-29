package net.minecraft.server;


public class class_tm extends class_sr {
	private EntityInsentient a;
	private double b;
	private double c;
	private int d;

	public class_tm(EntityInsentient var1) {
		a = var1;
		this.a(3);
	}

	@Override
	public boolean a() {
		return a.bj().nextFloat() < 0.02F;
	}

	@Override
	public boolean b() {
		return d >= 0;
	}

	@Override
	public void c() {
		double var1 = 6.283185307179586D * a.bj().nextDouble();
		b = Math.cos(var1);
		c = Math.sin(var1);
		d = 20 + a.bj().nextInt(20);
	}

	@Override
	public void e() {
		--d;
		a.q().a(a.s + b, a.t + a.aY(), a.u + c, a.ci(), a.ch());
	}
}
