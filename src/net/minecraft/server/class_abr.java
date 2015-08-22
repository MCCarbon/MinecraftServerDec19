package net.minecraft.server;


public class class_abr extends class_acm {
	private class_ail a;

	public class_abr(class_ail var1) {
		a = var1;
		this.a(class_abp.d);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (var6 != class_cq.b) {
			return class_pw.c;
		} else {
			class_apn var10 = var3.p(var4);
			class_ail var11 = var10.c();
			if (!var11.a(var3, var4)) {
				var4 = var4.a(var6);
			}

			if (var2.a(var4, var6, var1) && a.c(var3, var4)) {
				a(var3, var4, class_cq.a(var2.y), a);
				--var1.b;
				return class_pw.a;
			} else {
				return class_pw.c;
			}
		}
	}

	public static void a(class_ago var0, class_cj var1, class_cq var2, class_ail var3) {
		class_cj var4 = var1.a(var2.e());
		class_cj var5 = var1.a(var2.f());
		int var6 = (var0.p(var5).c().x() ? 1 : 0) + (var0.p(var5.a()).c().x() ? 1 : 0);
		int var7 = (var0.p(var4).c().x() ? 1 : 0) + (var0.p(var4.a()).c().x() ? 1 : 0);
		boolean var8 = (var0.p(var5).c() == var3) || (var0.p(var5.a()).c() == var3);
		boolean var9 = (var0.p(var4).c() == var3) || (var0.p(var4.a()).c() == var3);
		boolean var10 = false;
		if ((var8 && !var9) || (var7 > var6)) {
			var10 = true;
		}

		class_cj var11 = var1.a();
		class_apn var12 = var3.S().a(class_ajn.a, var2).a(class_ajn.N, var10 ? class_ajn.class_b_in_class_ajn.b : class_ajn.class_b_in_class_ajn.a);
		var0.a(var1, var12.a(class_ajn.P, class_ajn.class_a_in_class_ajn.b), 2);
		var0.a(var11, var12.a(class_ajn.P, class_ajn.class_a_in_class_ajn.a), 2);
		var0.d(var1, var3);
		var0.d(var11, var3);
	}
}
