package net.minecraft.server;


public class class_th extends class_sr {
	private EntityVillagerGolem a;
	private EntityVillager b;
	private int c;

	public class_th(EntityVillagerGolem var1) {
		a = var1;
		this.a(3);
	}

	@Override
	public boolean a() {
		if (!a.o.z()) {
			return false;
		} else if (a.bj().nextInt(8000) != 0) {
			return false;
		} else {
			b = (EntityVillager) a.o.a(EntityVillager.class, a.aX().b(6.0D, 2.0D, 6.0D), a);
			return b != null;
		}
	}

	@Override
	public boolean b() {
		return c > 0;
	}

	@Override
	public void c() {
		c = 400;
		a.a(true);
	}

	@Override
	public void d() {
		a.a(false);
		b = null;
	}

	@Override
	public void e() {
		a.q().a(b, 30.0F, 30.0F);
		--c;
	}
}
