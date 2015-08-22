package net.minecraft.server;


public class class_abj extends Item {
	public class_abj() {
		this.a(class_abp.e);
		this.d(1);
		this.e(25);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (var3.az() && (var3.m instanceof class_vj)) {
			class_vj var5 = (class_vj) var3.m;
			if (var5.cF().h() && ((var1.j() - var1.i()) >= 7)) {
				var5.cF().g();
				var1.a(7, var3);
				if (var1.b == 0) {
					class_aco var6 = new class_aco(Items.aT);
					var6.d(var1.o());
					return new class_px(class_pw.a, var6);
				}

				return new class_px(class_pw.a, var1);
			}
		}

		var3.b(class_nh.c(Item.b(this)));
		return new class_px(class_pw.b, var1);
	}
}
