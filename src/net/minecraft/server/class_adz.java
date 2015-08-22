package net.minecraft.server;


public class class_adz extends class_adw {
	public class_adz(Block var1) {
		super(var1, false);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		class_ayl var5 = this.a(var2, var3, true);
		if (var5 == null) {
			return new class_px(class_pw.b, var1);
		} else {
			if (var5.a == class_ayl.class_a_in_class_ayl.b) {
				class_cj var6 = var5.a();
				if (!var2.a(var3, var6) || !var3.a(var6.a(var5.b), var5.b, var1)) {
					return new class_px(class_pw.c, var1);
				}

				class_cj var7 = var6.a();
				class_apn var8 = var2.p(var6);
				if ((var8.c().v() == class_avq.h) && (((Integer) var8.b(class_alf.b)).intValue() == 0) && var2.d(var7)) {
					var2.a(var7, Blocks.bx.S());
					if (!var3.bI.d) {
						--var1.b;
					}

					var3.b(class_nh.c(Item.b(this)));
					return new class_px(class_pw.a, var1);
				}
			}

			return new class_px(class_pw.c, var1);
		}
	}
}
