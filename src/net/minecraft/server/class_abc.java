package net.minecraft.server;


public class class_abc extends class_acm {
	private class_ail a;

	public class_abc(class_ail var1) {
		a = var1;
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		class_apn var10 = var3.p(var4);
		class_ail var11 = var10.c();
		if ((var11 == class_aim.aH) && (((Integer) var10.b(class_ana.a)).intValue() < 1)) {
			var6 = class_cq.b;
		} else if (!var11.a(var3, var4)) {
			var4 = var4.a(var6);
		}

		if (var2.a(var4, var6, var1) && (var1.b != 0) && var3.a(a, var4, false, var6, (class_qx) null, var1)) {
			class_apn var12 = a.a(var3, var4, var6, var7, var8, var9, 0, var2);
			if (!var3.a(var4, var12, 3)) {
				return class_pw.c;
			} else {
				var12 = var3.p(var4);
				if (var12.c() == a) {
					class_abb.a(var3, var2, var4, var1);
					var12.c().a(var3, var4, var12, var2, var1);
				}

				var3.a(var4.n() + 0.5F, var4.o() + 0.5F, var4.p() + 0.5F, a.H.b(), (a.H.d() + 1.0F) / 2.0F, a.H.e() * 0.8F);
				--var1.b;
				return class_pw.a;
			}
		} else {
			return class_pw.c;
		}
	}
}
