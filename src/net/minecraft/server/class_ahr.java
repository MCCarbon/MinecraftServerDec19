package net.minecraft.server;

import java.util.Random;

public class class_ahr extends class_ahb {
	protected boolean aD;

	protected class_ahr(int var1) {
		super(var1);
		this.a(0.8F, 0.4F);
		this.a(e);
		au.add(new class_ahb.class_c_in_class_ahb(class_vf.class, 5, 2, 6));
		as.A = -999;
		as.B = 4;
		as.C = 10;
	}

	@Override
	public BlockFlowers.class_a_in_class_ake a(Random var1, class_cj var2) {
		double var3 = af.a(var2.n() / 200.0D, var2.p() / 200.0D);
		int var5;
		if (var3 < -0.8D) {
			var5 = var1.nextInt(4);
			switch (var5) {
				case 0:
					return BlockFlowers.class_a_in_class_ake.g;
				case 1:
					return BlockFlowers.class_a_in_class_ake.f;
				case 2:
					return BlockFlowers.class_a_in_class_ake.i;
				case 3:
				default:
					return BlockFlowers.class_a_in_class_ake.h;
			}
		} else if (var1.nextInt(3) > 0) {
			var5 = var1.nextInt(3);
			return var5 == 0 ? BlockFlowers.class_a_in_class_ake.b : (var5 == 1 ? BlockFlowers.class_a_in_class_ake.e : BlockFlowers.class_a_in_class_ake.j);
		} else {
			return BlockFlowers.class_a_in_class_ake.a;
		}
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		double var4 = af.a((var3.n() + 8) / 200.0D, (var3.p() + 8) / 200.0D);
		int var6;
		int var7;
		int var8;
		int var9;
		if (var4 < -0.8D) {
			as.B = 15;
			as.C = 5;
		} else {
			as.B = 4;
			as.C = 10;
			ag.a(BlockTallPlant.class_b_in_class_ajo.c);

			for (var6 = 0; var6 < 7; ++var6) {
				var7 = var2.nextInt(16) + 8;
				var8 = var2.nextInt(16) + 8;
				var9 = var2.nextInt(var1.m(var3.a(var7, 0, var8)).o() + 32);
				ag.b(var1, var2, var3.a(var7, var9, var8));
			}
		}

		if (aD) {
			ag.a(BlockTallPlant.class_b_in_class_ajo.a);

			for (var6 = 0; var6 < 10; ++var6) {
				var7 = var2.nextInt(16) + 8;
				var8 = var2.nextInt(16) + 8;
				var9 = var2.nextInt(var1.m(var3.a(var7, 0, var8)).o() + 32);
				ag.b(var1, var2, var3.a(var7, var9, var8));
			}
		}

		super.a(var1, var2, var3);
	}

	@Override
	protected class_ahb d(int var1) {
		class_ahr var2 = new class_ahr(var1);
		var2.a("Sunflower Plains");
		var2.aD = true;
		var2.b(9286496);
		var2.aj = 14273354;
		return var2;
	}
}
