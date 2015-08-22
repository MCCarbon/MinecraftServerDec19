package net.minecraft.server;

import java.util.List;

public class class_anz extends class_aiq {
	protected class_anz() {
		float var1 = 0.5F;
		float var2 = 0.015625F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
		this.a(class_abp.c);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, Entity var6) {
		if ((var6 == null) || !(var6 instanceof class_xe)) {
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return new class_ayk(var2.n() + B, var2.o() + C, var2.p() + D, var2.n() + E, var2.o() + F, var2.p() + G);
	}

	@Override
	protected boolean c(Block var1) {
		return var1 == Blocks.j;
	}

	@Override
	public boolean g(class_ago var1, class_cj var2, class_apn var3) {
		if ((var2.o() >= 0) && (var2.o() < 256)) {
			class_apn var4 = var1.p(var2.b());
			return (var4.c().v() == class_avq.h) && (((Integer) var4.b(class_alf.b)).intValue() == 0);
		} else {
			return false;
		}
	}

	@Override
	public int c(class_apn var1) {
		return 0;
	}
}
