package net.minecraft.server;


public class class_amy extends class_aks {
	public class_amy() {
		super(class_avq.B, false, class_avr.c);
		this.a(class_abp.c);
		L = 0.8F;
	}

	@Override
	public void a(class_ago var1, class_cj var2, Entity var3, float var4) {
		if (var3.aA()) {
			super.a(var1, var2, var3, var4);
		} else {
			var3.e(var4, 0.0F);
		}

	}

	@Override
	public void a(class_ago var1, Entity var2) {
		if (var2.aA()) {
			super.a(var1, var2);
		} else if (var2.w < 0.0D) {
			var2.w = -var2.w;
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, Entity var3) {
		if ((Math.abs(var3.w) < 0.1D) && !var3.aA()) {
			double var4 = 0.4D + (Math.abs(var3.w) * 0.2D);
			var3.v *= var4;
			var3.x *= var4;
		}

		super.a(var1, var2, var3);
	}
}
