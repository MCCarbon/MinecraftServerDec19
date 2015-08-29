package net.minecraft.server;


public class class_act extends class_adb {
	@Override
	public String a(class_aco var1) {
		return class_di.a("lingering_" + i(var1).a());
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (!var3.bI.d) {
			--var1.b;
		}

		var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / ((h.nextFloat() * 0.4F) + 0.8F));
		if (!var2.D) {
			EntityPotion var5 = new EntityPotion(var2, var3, var1, true);
			var5.a(var3.z, var3.y, -20.0F, 0.5F, 1.0F);
			var2.a(var5);
		}

		var3.b(StatisticList.c(Item.b(this)));
		return new class_px(class_pw.a, var1);
	}
}
