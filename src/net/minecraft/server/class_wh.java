package net.minecraft.server;


public class class_wh extends class_wa {
	private int b;

	public class_wh(class_vx var1) {
		super(var1);
	}

	@Override
	public void b() {
		a.o.a(a.s, a.t, a.u, "mob.enderdragon.growl", 2.5F, 0.8F + (a.bj().nextFloat() * 0.3F), false);
	}

	@Override
	public void c() {
		if (b++ >= 40) {
			a.cy().a(class_wm.f);
		}

	}

	@Override
	public void d() {
		b = 0;
	}

	@Override
	public class_wm i() {
		return class_wm.h;
	}
}
