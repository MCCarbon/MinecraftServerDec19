package net.minecraft.server;

import java.util.Random;

public class class_ali extends class_aif {
	protected class_ali() {
		super(class_avq.e);
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_aox();
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		int var6 = 15 + var1.s.nextInt(15) + var1.s.nextInt(15);
		this.b(var1, var2, var6);
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}
}
