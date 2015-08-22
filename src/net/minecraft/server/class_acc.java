package net.minecraft.server;


public class class_acc extends class_acm {
	public class_acc() {
		this.a(class_abp.f);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (var3.D) {
			return class_pw.a;
		} else {
			var4 = var4.a(var6);
			if (!var2.a(var4, var6, var1)) {
				return class_pw.c;
			} else {
				if (var3.p(var4).c().v() == class_avq.a) {
					var3.a(var4.n() + 0.5D, var4.o() + 0.5D, var4.p() + 0.5D, "item.fireCharge.use", 1.0F, ((h.nextFloat() - h.nextFloat()) * 0.2F) + 1.0F);
					var3.a(var4, class_aim.ab.S());
				}

				if (!var2.bI.d) {
					--var1.b;
				}

				return class_pw.a;
			}
		}
	}
}
