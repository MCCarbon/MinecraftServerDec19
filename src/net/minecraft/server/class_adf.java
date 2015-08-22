package net.minecraft.server;


public class class_adf extends class_acm {
	public class_adf() {
		i = 1;
		this.a(class_abp.e);
	}

	@Override
	public boolean a(class_aco var1, class_yu var2, class_rg var3, class_pu var4) {
		if (var3 instanceof class_vj) {
			class_vj var5 = (class_vj) var3;
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
	public boolean a(class_aco var1, class_rg var2, class_rg var3) {
		this.a(var1, (class_yu) null, var2, class_pu.a);
		return true;
	}
}
