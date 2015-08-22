package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_aju extends class_aif {
	protected class_aju(class_avq var1) {
		super(var1);
		this.a(1.0F);
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_apd();
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		float var3 = 0.0625F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, class_qx var6) {
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_qx var4) {
		if ((var4.m == null) && (var4.l == null) && !var1.D) {
			var4.a(1, (class_cj) null);
		}

	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public class_avr g(class_apn var1) {
		return class_avr.E;
	}
}
