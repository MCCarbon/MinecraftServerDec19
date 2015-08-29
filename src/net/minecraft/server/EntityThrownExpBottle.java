package net.minecraft.server;


public class EntityThrownExpBottle extends class_zj {
	public EntityThrownExpBottle(class_ago var1) {
		super(var1);
	}

	public EntityThrownExpBottle(class_ago var1, EntityLiving var2) {
		super(var1, var2);
	}

	public EntityThrownExpBottle(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	protected float i() {
		return 0.07F;
	}

	@Override
	protected void a(class_ayl var1) {
		if (!o.D) {
			o.b(2002, new class_cj(this), 0);
			int var2 = 3 + o.s.nextInt(5) + o.s.nextInt(5);

			while (var2 > 0) {
				int var3 = EntityExperienceOrb.a(var2);
				var2 -= var3;
				o.a((new EntityExperienceOrb(o, s, t, u, var3)));
			}

			L();
		}

	}
}
