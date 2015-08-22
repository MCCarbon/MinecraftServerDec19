package net.minecraft.server;


public class class_adh extends class_acm {
	private class_ail a;
	private class_ail b;

	public class_adh(class_ail var1, class_ail var2) {
		a = var1;
		b = var2;
		this.a(class_abp.l);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if ((var6 == class_cq.b) && var2.a(var4.a(var6), var6, var1) && (var3.p(var4).c() == b) && var3.d(var4.a())) {
			var3.a(var4.a(), a.S());
			--var1.b;
			return class_pw.a;
		} else {
			return class_pw.c;
		}
	}
}
