package net.minecraft.server;

import java.util.Random;

public class class_amz extends class_ail {
	protected class_amz() {
		super(class_avq.z);
		this.a(true);
		this.a(class_abp.b);
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.aF;
	}

	@Override
	public int a(Random var1) {
		return 4;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (var1.b(class_agu.b, var2) > 11) {
			this.b(var1, var2, var1.p(var2), 0);
			var1.g(var2);
		}

	}
}
