package net.minecraft.server;

import java.util.Random;

public class class_ahl extends class_ahb {
	private boolean aD;
	private class_asx aE = new class_asx();
	private class_asw aF = new class_asw(4);

	public class_ahl(int var1, boolean var2) {
		super(var1);
		aD = var2;
		if (var2) {
			ak = class_aim.aJ.S();
		}

		au.clear();
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		if (aD) {
			int var4;
			int var5;
			int var6;
			for (var4 = 0; var4 < 3; ++var4) {
				var5 = var2.nextInt(16) + 8;
				var6 = var2.nextInt(16) + 8;
				aE.b(var1, var2, var1.m(var3.a(var5, 0, var6)));
			}

			for (var4 = 0; var4 < 2; ++var4) {
				var5 = var2.nextInt(16) + 8;
				var6 = var2.nextInt(16) + 8;
				aF.b(var1, var2, var1.m(var3.a(var5, 0, var6)));
			}
		}

		super.a(var1, var2, var3);
	}

	@Override
	public class_asa a(Random var1) {
		return new class_ato(false);
	}

	@Override
	protected class_ahb d(int var1) {
		class_ahb var2 = (new class_ahl(var1, true)).a(13828095, true).a(ah + " Spikes").c().a(0.0F, 0.5F).a(new class_ahb.class_a_in_class_ahb(an + 0.1F, ao + 0.1F));
		var2.an = an + 0.3F;
		var2.ao = ao + 0.4F;
		return var2;
	}
}
