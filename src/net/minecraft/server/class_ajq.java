package net.minecraft.server;


public class class_ajq extends class_ajm {
	private final class_cr P = new class_cn();

	@Override
	protected class_cr a(class_aco var1) {
		return P;
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_aop();
	}

	@Override
	protected void e(class_ago var1, class_cj var2) {
		class_cl var3 = new class_cl(var1, var2);
		class_aoo var4 = (class_aoo) var3.h();
		if (var4 != null) {
			int var5 = var4.m();
			if (var5 < 0) {
				var1.b(1001, var2, 0);
			} else {
				class_aco var6 = var4.a(var5);
				if (var6 != null) {
					class_cq var7 = (class_cq) var1.p(var2).b(a);
					class_cj var8 = var2.a(var7);
					class_pp var9 = class_aov.b(var1, var8.n(), var8.o(), var8.p());
					class_aco var10;
					if (var9 == null) {
						var10 = P.a(var3, var6);
						if ((var10 != null) && (var10.b <= 0)) {
							var10 = null;
						}
					} else {
						var10 = class_aov.a(var9, var6.k().a(1), var7.d());
						if (var10 == null) {
							var10 = var6.k();
							if (--var10.b <= 0) {
								var10 = null;
							}
						} else {
							var10 = var6.k();
						}
					}

					var4.a(var5, var10);
				}
			}
		}
	}
}
