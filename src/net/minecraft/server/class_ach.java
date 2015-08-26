package net.minecraft.server;


public class class_ach extends Item {
	public class_ach() {
		i = 1;
		this.e(64);
		this.a(class_abp.i);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		var4 = var4.a(var6);
		if (!var2.a(var4, var6, var1)) {
			return class_pw.c;
		} else {
			if (var3.p(var4).c().v() == class_avq.a) {
				var3.a(var4.n() + 0.5D, var4.o() + 0.5D, var4.p() + 0.5D, "fire.ignite", 1.0F, (h.nextFloat() * 0.4F) + 0.8F);
				var3.a(var4, Blocks.FIRE.S());
			}

			var1.a(1, var2);
			return class_pw.a;
		}
	}
}
