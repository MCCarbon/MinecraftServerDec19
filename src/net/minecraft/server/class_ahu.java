package net.minecraft.server;

import java.util.Random;

public class class_ahu extends class_ahb {
	private static final class_atl aD = new class_atl(false);

	protected class_ahu(int var1) {
		super(var1);
		au.add(new class_ahb.class_c_in_class_ahb(EntityHorse.class, 1, 2, 6));
		as.A = 1;
		as.B = 4;
		as.C = 20;
	}

	@Override
	public class_asa a(Random var1) {
		return var1.nextInt(5) > 0 ? aD : aA;
	}

	@Override
	protected class_ahb d(int var1) {
		class_ahu.class_a_in_class_ahu var2 = new class_ahu.class_a_in_class_ahu(var1, this);
		var2.ap = (ap + 1.0F) * 0.5F;
		var2.an = (an * 0.5F) + 0.3F;
		var2.ao = (ao * 0.5F) + 1.2F;
		return var2;
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		ag.a(BlockTallPlant.class_b_in_class_ajo.c);

		for (int var4 = 0; var4 < 7; ++var4) {
			int var5 = var2.nextInt(16) + 8;
			int var6 = var2.nextInt(16) + 8;
			int var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
			ag.b(var1, var2, var3.a(var5, var7, var6));
		}

		super.a(var1, var2, var3);
	}

	public static class class_a_in_class_ahu extends class_ahp {
		public class_a_in_class_ahu(int var1, class_ahb var2) {
			super(var1, var2);
			as.A = 2;
			as.B = 2;
			as.C = 5;
		}

		@Override
		public void a(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
			ak = Blocks.GRASS.getBlockData();
			al = Blocks.DIRT.getBlockData();
			if (var6 > 1.75D) {
				ak = Blocks.STONE.getBlockData();
				al = Blocks.STONE.getBlockData();
			} else if (var6 > -0.5D) {
				ak = Blocks.DIRT.getBlockData().a(class_ajl.a, class_ajl.class_a_in_class_ajl.b);
			}

			this.b(var1, var2, var3, var4, var5, var6);
		}

		@Override
		public void a(class_ago var1, Random var2, class_cj var3) {
			as.a(var1, var2, this, var3);
		}
	}
}
