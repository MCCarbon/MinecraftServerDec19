package net.minecraft.server;

import java.util.Random;

public class class_amw extends class_aif {
	protected class_amw() {
		super(class_avq.d);
		float var1 = 0.25F;
		float var2 = 1.0F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean b(class_ags var1, class_cj var2) {
		return true;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean g() {
		return true;
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_aoz();
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.ar;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_acq.ar);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			class_aoi var11 = var1.s(var2);
			return var11 instanceof class_aoz ? ((class_aoz) var11).b(var4) : false;
		}
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return !this.d(var1, var2) && super.c(var1, var2);
	}
}
