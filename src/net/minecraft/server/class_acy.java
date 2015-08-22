package net.minecraft.server;


public class class_acy extends Item {
	public class_acy() {
		this.a(class_abp.i);
	}

	@Override
	public boolean a(class_aco var1, class_yu var2, class_rg var3, class_pu var4) {
		if (!var1.s()) {
			return false;
		} else if (var3 instanceof class_rh) {
			class_rh var5 = (class_rh) var3;
			var5.c(var1.q());
			var5.cp();
			--var1.b;
			return true;
		} else {
			return super.a(var1, var2, var3, var4);
		}
	}
}
