package net.minecraft.server;


public class class_abw extends Item {
	public class_abw() {
		i = 16;
		this.a(class_abp.l);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (!var3.bI.d) {
			--var1.b;
		}

		var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / ((h.nextFloat() * 0.4F) + 0.8F));
		if (!var2.D) {
			class_zk var5 = new class_zk(var2, var3);
			var5.a(var3.z, var3.y, 0.0F, 1.5F, 1.0F);
			var2.a(var5);
		}

		var3.b(class_nh.c(Item.b(this)));
		return new class_px(class_pw.a, var1);
	}
}
