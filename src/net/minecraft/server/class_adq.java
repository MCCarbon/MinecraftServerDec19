package net.minecraft.server;


public class class_adq extends class_abb {
	public class_adq(class_ail var1) {
		super(var1);
		this.e(0);
		this.a(true);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if ((var1.b != 0) && var2.a(var4, var6, var1)) {
			class_apn var10 = var3.p(var4);
			class_ail var11 = var10.c();
			class_cj var12 = var4;
			if (((var6 != class_cq.b) || (var11 != a)) && !var11.a(var3, var4)) {
				var12 = var4.a(var6);
				var10 = var3.p(var12);
				var11 = var10.c();
			}

			if (var11 == a) {
				int var13 = ((Integer) var10.b(class_ana.a)).intValue();
				if (var13 <= 7) {
					class_apn var14 = var10.a(class_ana.a, Integer.valueOf(var13 + 1));
					class_ayk var15 = a.a(var3, var12, var14);
					if ((var15 != null) && var3.b(var15) && var3.a(var12, var14, 2)) {
						var3.a(var12.n() + 0.5F, var12.o() + 0.5F, var12.p() + 0.5F, a.H.b(), (a.H.d() + 1.0F) / 2.0F, a.H.e() * 0.8F);
						--var1.b;
						return class_pw.a;
					}
				}
			}

			return super.a(var1, var2, var3, var12, var5, var6, var7, var8, var9);
		} else {
			return class_pw.c;
		}
	}

	@Override
	public int a(int var1) {
		return var1;
	}
}
