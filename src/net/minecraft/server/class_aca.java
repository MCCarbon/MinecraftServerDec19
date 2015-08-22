package net.minecraft.server;


public class class_aca extends class_acm {
	public class_aca() {
		i = 16;
		this.a(class_abp.f);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (!var3.bI.d) {
			--var1.b;
		}

		var2.a((class_qx) var3, "random.bow", 0.5F, 0.4F / ((h.nextFloat() * 0.4F) + 0.8F));
		var3.cB().a(this, 20);
		if (!var2.D) {
			class_zl var5 = new class_zl(var2, var3);
			var5.a(var3.z, var3.y, 0.0F, 1.5F, 1.0F);
			var2.a(var5);
		}

		var3.b(class_nh.c(class_acm.b(this)));
		return new class_px(class_pw.a, var1);
	}
}
