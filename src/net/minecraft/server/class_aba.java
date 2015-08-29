package net.minecraft.server;


public class class_aba extends Item {
	public class_aba() {
		this.a(class_abp.c);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (var3.D) {
			return class_pw.a;
		} else if (var6 != class_cq.b) {
			return class_pw.c;
		} else {
			class_apn var10 = var3.p(var4);
			Block var11 = var10.c();
			boolean var12 = var11.a(var3, var4);
			if (!var12) {
				var4 = var4.a();
			}

			int var13 = MathHelper.c((var2.y * 4.0F) / 360.0F + 0.5D) & 3;
			class_cq var14 = class_cq.b(var13);
			class_cj var15 = var4.a(var14);
			if (var2.a(var4, var6, var1) && var2.a(var15, var6, var1)) {
				boolean var16 = var3.p(var15).c().a(var3, var15);
				boolean var17 = var12 || var3.d(var4);
				boolean var18 = var16 || var3.d(var15);
				if (var17 && var18 && class_ago.a(var3, var4.b()) && class_ago.a(var3, var15.b())) {
					class_apn var19 = Blocks.BED.getBlockData().a(class_aij.b, Boolean.valueOf(false)).a(class_akx.O, var14).a(class_aij.a, class_aij.class_a_in_class_aij.b);
					if (var3.a(var4, var19, 3)) {
						class_apn var20 = var19.a(class_aij.a, class_aij.class_a_in_class_aij.a);
						var3.a(var15, var20, 3);
					}

					--var1.b;
					return class_pw.a;
				} else {
					return class_pw.c;
				}
			} else {
				return class_pw.c;
			}
		}
	}
}
