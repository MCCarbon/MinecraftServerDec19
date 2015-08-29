package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_aaw extends Item {
	public class_aaw() {
		this.a(class_abp.c);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (var6 == class_cq.a) {
			return class_pw.c;
		} else {
			boolean var10 = var3.p(var4).c().a(var3, var4);
			class_cj var11 = var10 ? var4 : var4.a(var6);
			if (!var2.a(var11, var6, var1)) {
				return class_pw.c;
			} else {
				class_cj var12 = var11.a();
				boolean var13 = !var3.d(var11) && !var3.p(var11).c().a(var3, var11);
				var13 |= !var3.d(var12) && !var3.p(var12).c().a(var3, var12);
				if (var13) {
					return class_pw.c;
				} else {
					double var14 = var11.n();
					double var16 = var11.o();
					double var18 = var11.p();
					List var20 = var3.b((Entity) null, class_ayk.a(var14, var16, var18, var14 + 1.0D, var16 + 2.0D, var18 + 1.0D));
					if (!var20.isEmpty()) {
						return class_pw.c;
					} else {
						if (!var3.D) {
							var3.g(var11);
							var3.g(var12);
							EntityArmorStand var21 = new EntityArmorStand(var3, var14 + 0.5D, var16, var18 + 0.5D);
							float var22 = MathHelper.d((MathHelper.g(var2.y - 180.0F) + 22.5F) / 45.0F) * 45.0F;
							var21.b(var14 + 0.5D, var16, var18 + 0.5D, var22, 0.0F);
							this.a(var21, var3.s);
							class_ads.a(var3, var2, var1, var21);
							var3.a(var21);
						}

						--var1.b;
						return class_pw.a;
					}
				}
			}
		}
	}

	private void a(EntityArmorStand var1, Random var2) {
		class_dc var3 = var1.u();
		float var5 = var2.nextFloat() * 5.0F;
		float var6 = (var2.nextFloat() * 20.0F) - 10.0F;
		class_dc var4 = new class_dc(var3.b() + var5, var3.c() + var6, var3.d());
		var1.a(var4);
		var3 = var1.v();
		var5 = (var2.nextFloat() * 10.0F) - 5.0F;
		var4 = new class_dc(var3.b(), var3.c() + var5, var3.d());
		var1.b(var4);
	}
}
