package net.minecraft.server;


public class class_adj extends class_acm {
	public class_adj() {
		this.d(1);
		this.e(238);
		this.a(class_abp.i);
	}

	@Override
	public boolean a(class_aco var1, class_ago var2, class_ail var3, class_cj var4, class_rg var5) {
		if ((var3.v() != class_avq.j) && (var3 != class_aim.G) && (var3 != class_aim.H) && (var3 != class_aim.bn) && (var3 != class_aim.bS) && (var3 != class_aim.L)) {
			return super.a(var1, var2, var3, var4, var5);
		} else {
			var1.a(1, var5);
			return true;
		}
	}

	@Override
	public boolean b(class_ail var1) {
		return (var1 == class_aim.G) || (var1 == class_aim.af) || (var1 == class_aim.bS);
	}

	@Override
	public float a(class_aco var1, class_ail var2) {
		return (var2 != class_aim.G) && (var2.v() != class_avq.j) ? (var2 == class_aim.L ? 5.0F : super.a(var1, var2)) : 15.0F;
	}
}
