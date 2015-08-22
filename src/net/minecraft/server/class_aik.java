package net.minecraft.server;

import java.util.Random;

public class class_aik extends class_ajf {
	public static final class_aqb a = class_aqb.a("age", 0, 3);

	@Override
	protected class_aqb l() {
		return a;
	}

	@Override
	public int n() {
		return 3;
	}

	@Override
	protected Item o() {
		return Items.cN;
	}

	@Override
	protected Item p() {
		return Items.cO;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (var4.nextInt(3) == 0) {
			this.f(var1, var2, var3);
		} else {
			super.b(var1, var2, var3, var4);
		}

	}

	@Override
	protected int b(class_ago var1) {
		return super.b(var1) / 3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
