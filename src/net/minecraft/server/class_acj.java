package net.minecraft.server;


public class class_acj extends class_aci {
	public class_acj(int var1, float var2, boolean var3) {
		super(var1, var2, var3);
		this.a(true);
	}

	@Override
	public class_adc g(class_aco var1) {
		return var1.i() == 0 ? class_adc.c : class_adc.d;
	}

	@Override
	protected void a(class_aco var1, class_ago var2, class_yu var3) {
		if (!var2.D) {
			var3.c(new class_qr(class_qs.v, 2400, 0));
		}

		if (var1.i() > 0) {
			if (!var2.D) {
				var3.c(new class_qr(class_qs.j, 600, 4));
				var3.c(new class_qr(class_qs.k, 6000, 0));
				var3.c(new class_qr(class_qs.l, 6000, 0));
			}
		} else {
			super.a(var1, var2, var3);
		}

	}
}
