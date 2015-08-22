package net.minecraft.server;

import java.util.Random;

public class class_ajh extends class_aiq {
	protected class_ajh() {
		super(class_avq.l);
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	@Override
	public class_avr g(class_apn var1) {
		return class_avr.o;
	}

	@Override
	protected boolean c(class_ail var1) {
		return (var1 == class_aim.m) || (var1 == class_aim.cz) || (var1 == class_aim.cu) || (var1 == class_aim.d);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2) {
		return true;
	}

	@Override
	public int a(Random var1) {
		return var1.nextInt(3);
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.A;
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, class_aoi var5, class_aco var6) {
		if (!var1.D && (var6 != null) && (var6.b() == class_acq.bg)) {
			var2.b(class_nh.a(class_ail.a(this)));
			a(var1, var3, new class_aco(class_aim.I, 1, 0));
		} else {
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}
}
