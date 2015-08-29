package net.minecraft.server;


public class class_acv extends Item {
	public class_acv() {
		this.d(1);
		this.a(class_abp.f);
	}

	@Override
	public class_aco a(class_aco var1, class_ago var2, EntityLiving var3) {
		if ((var3 instanceof class_yu) && !((class_yu) var3).bI.d) {
			--var1.b;
		}

		if (!var2.D) {
			var3.br();
		}

		if (var3 instanceof class_yu) {
			((class_yu) var3).b(StatisticList.c(Item.b(this)));
		}

		return var1.b <= 0 ? new class_aco(Items.ay) : var1;
	}

	@Override
	public int e(class_aco var1) {
		return 32;
	}

	@Override
	public class_ady f(class_aco var1) {
		return class_ady.c;
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		var3.c(var4);
		return new class_px(class_pw.a, var1);
	}
}
