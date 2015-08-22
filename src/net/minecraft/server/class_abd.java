package net.minecraft.server;

import java.util.List;

public class class_abd extends class_acm {
	public class_abd() {
		i = 1;
		this.a(class_abp.e);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		float var5 = 1.0F;
		float var6 = var3.B + ((var3.z - var3.B) * var5);
		float var7 = var3.A + ((var3.y - var3.A) * var5);
		double var8 = var3.p + ((var3.s - var3.p) * var5);
		double var10 = var3.q + ((var3.t - var3.q) * var5) + var3.aY();
		double var12 = var3.r + ((var3.u - var3.r) * var5);
		class_aym var14 = new class_aym(var8, var10, var12);
		float var15 = class_oa.b((-var7 * 0.017453292F) - 3.1415927F);
		float var16 = class_oa.a((-var7 * 0.017453292F) - 3.1415927F);
		float var17 = -class_oa.b(-var6 * 0.017453292F);
		float var18 = class_oa.a(-var6 * 0.017453292F);
		float var19 = var16 * var17;
		float var21 = var15 * var17;
		double var22 = 5.0D;
		class_aym var24 = var14.b(var19 * var22, var18 * var22, var21 * var22);
		class_ayl var25 = var2.a(var14, var24, true);
		if (var25 == null) {
			return new class_px(class_pw.b, var1);
		} else {
			class_aym var26 = var3.g(var5);
			boolean var27 = false;
			float var28 = 1.0F;
			List var29 = var2.b(var3, var3.aX().a(var26.a * var22, var26.b * var22, var26.c * var22).b(var28, var28, var28));

			for (int var30 = 0; var30 < var29.size(); ++var30) {
				class_qx var31 = (class_qx) var29.get(var30);
				if (var31.ag()) {
					float var32 = var31.ar();
					class_ayk var33 = var31.aX().b(var32, var32, var32);
					if (var33.a(var14)) {
						var27 = true;
					}
				}
			}

			if (var27) {
				return new class_px(class_pw.b, var1);
			} else if (var25.a == class_ayl.class_a_in_class_ayl.b) {
				class_cj var34 = var25.a();
				if (var2.p(var34).c() == class_aim.aH) {
					var34 = var34.b();
				}

				class_xe var35 = new class_xe(var2, var34.n() + 0.5F, var34.o() + 1.0F, var34.p() + 0.5F);
				var35.y = ((class_oa.c((var3.y * 4.0F) / 360.0F + 0.5D) & 3) - 1) * 90;
				if (!var2.a(var35, var35.aX().b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
					return new class_px(class_pw.c, var1);
				} else {
					if (!var2.D) {
						var2.a(var35);
					}

					if (!var3.bI.d) {
						--var1.b;
					}

					var3.b(class_nh.c(class_acm.b(this)));
					return new class_px(class_pw.a, var1);
				}
			} else {
				return new class_px(class_pw.b, var1);
			}
		}
	}
}
