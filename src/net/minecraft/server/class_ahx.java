package net.minecraft.server;

import java.util.Random;

public class class_ahx extends class_ahb {
	private static final class_atg aD = new class_atg();
	private static final class_ato aE = new class_ato(false);
	private static final class_atb aF = new class_atb(false, false);
	private static final class_atb aG = new class_atb(false, true);
	private static final class_asd aH;
	private int aI;

	public class_ahx(int var1, int var2) {
		super(var1);
		aI = var2;
		au.add(new class_ahb.class_c_in_class_ahb(class_vr.class, 8, 4, 4));
		as.A = 10;
		if ((var2 != 1) && (var2 != 2)) {
			as.C = 1;
			as.E = 1;
		} else {
			as.C = 7;
			as.D = 1;
			as.E = 3;
		}

	}

	@Override
	public class_asa a(Random var1) {
		return ((aI == 1) || (aI == 2)) && (var1.nextInt(3) == 0) ? ((aI != 2) && (var1.nextInt(13) != 0) ? aF : aG) : (var1.nextInt(3) == 0 ? aD : aE);
	}

	@Override
	public class_asp b(Random var1) {
		return var1.nextInt(5) > 0 ? new class_atq(class_ano.class_a_in_class_ano.c) : new class_atq(class_ano.class_a_in_class_ano.b);
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		int var4;
		int var5;
		int var6;
		int var7;
		if ((aI == 1) || (aI == 2)) {
			var4 = var2.nextInt(3);

			for (var5 = 0; var5 < var4; ++var5) {
				var6 = var2.nextInt(16) + 8;
				var7 = var2.nextInt(16) + 8;
				class_cj var8 = var1.m(var3.a(var6, 0, var7));
				aH.b(var1, var2, var8);
			}
		}

		ag.a(class_ajo.class_b_in_class_ajo.d);

		for (var4 = 0; var4 < 7; ++var4) {
			var5 = var2.nextInt(16) + 8;
			var6 = var2.nextInt(16) + 8;
			var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
			ag.b(var1, var2, var3.a(var5, var7, var6));
		}

		super.a(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
		if ((aI == 1) || (aI == 2)) {
			ak = class_aim.c.S();
			al = class_aim.d.S();
			if (var6 > 1.75D) {
				ak = class_aim.d.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.b);
			} else if (var6 > -0.95D) {
				ak = class_aim.d.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.c);
			}
		}

		this.b(var1, var2, var3, var4, var5, var6);
	}

	@Override
	protected class_ahb d(int var1) {
		return az == class_ahb.V.az ? (new class_ahx(var1, 2)).a(5858897, true).a("Mega Spruce Taiga").a(5159473).a(0.25F, 0.8F).a(new class_ahb.class_a_in_class_ahb(an, ao)) : super.d(var1);
	}

	static {
		aH = new class_asd(class_aim.Y, 0);
	}
}
