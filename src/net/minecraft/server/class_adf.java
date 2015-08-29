package net.minecraft.server;


public class class_adf extends Item {
	public class_adf() {
		i = 1;
		this.a(class_abp.e);
	}

	@Override
	public boolean a(class_aco var1, class_yu var2, EntityLiving var3, class_pu var4) {
		if (var3 instanceof EntityPig) {
			EntityPig var5 = (EntityPig) var3;
			if (!var5.cE() && !var5.i_()) {
				var5.m(true);
				var5.o.a(var5, "mob.horse.leather", 0.5F, 1.0F);
				--var1.b;
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean a(class_aco var1, EntityLiving var2, EntityLiving var3) {
		this.a(var1, (class_yu) null, var2, class_pu.a);
		return true;
	}
}
