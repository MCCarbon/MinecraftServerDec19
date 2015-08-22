package net.minecraft.server;

import java.util.Random;

public class class_ahw extends class_ahb {
	protected class_ahw(int var1) {
		super(var1);
		as.A = 2;
		as.B = 1;
		as.D = 1;
		as.E = 8;
		as.F = 10;
		as.J = 1;
		as.z = 4;
		as.I = 0;
		as.H = 0;
		as.C = 5;
		ar = 14745518;
		at.add(new class_ahb.class_c_in_class_ahb(class_yi.class, 1, 1, 1));
	}

	@Override
	public class_asa a(Random var1) {
		return aC;
	}

	@Override
	public class_ake.class_a_in_class_ake a(Random var1, class_cj var2) {
		return class_ake.class_a_in_class_ake.c;
	}

	@Override
	public void a(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
		double var8 = af.a(var4 * 0.25D, var5 * 0.25D);
		if (var8 > 0.0D) {
			int var10 = var4 & 15;
			int var11 = var5 & 15;

			for (int var12 = 255; var12 >= 0; --var12) {
				if (var3.a(var11, var12, var10).c().v() != class_avq.a) {
					if ((var12 == 62) && (var3.a(var11, var12, var10).c() != class_aim.j)) {
						var3.a(var11, var12, var10, class_aim.j.S());
						if (var8 < 0.12D) {
							var3.a(var11, var12 + 1, var10, class_aim.bx.S());
						}
					}
					break;
				}
			}
		}

		this.b(var1, var2, var3, var4, var5, var6);
	}
}
