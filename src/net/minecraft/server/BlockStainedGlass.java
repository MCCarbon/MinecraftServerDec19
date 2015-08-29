package net.minecraft.server;

import java.util.Random;

public class BlockStainedGlass extends class_aks {
	public static final class_aqa a = class_aqa.a("color", class_abt.class);

	public BlockStainedGlass(class_avq var1) {
		super(var1, false);
		this.j(M.b().a(a, class_abt.a));
		this.a(class_abp.b);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_abt) var1.b(a)).a();
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_abt) var1.b(a)).e();
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	protected boolean K() {
		return true;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, class_abt.b(var1));
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			BlockBeacon.e(var1, var2);
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			BlockBeacon.e(var1, var2);
		}

	}

	@Override
	public int c(class_apn var1) {
		return ((class_abt) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
