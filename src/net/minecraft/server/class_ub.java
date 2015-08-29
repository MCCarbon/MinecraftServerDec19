package net.minecraft.server;


public class class_ub extends class_uj {
	EntityVillagerGolem a;
	EntityLiving b;

	public class_ub(EntityVillagerGolem var1) {
		super(var1, false, true);
		a = var1;
		this.a(1);
	}

	@Override
	public boolean a() {
		class_uv var1 = a.n();
		if (var1 == null) {
			return false;
		} else {
			b = var1.b(a);
			if (b instanceof EntityCreeper) {
				return false;
			} else if (!this.a(b, false)) {
				if (e.bj().nextInt(20) == 0) {
					b = var1.c(a);
					return this.a(b, false);
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}

	@Override
	public void c() {
		a.c(b);
		super.c();
	}
}
