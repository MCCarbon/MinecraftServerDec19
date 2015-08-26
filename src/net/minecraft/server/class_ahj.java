package net.minecraft.server;

import java.util.Random;

public class class_ahj extends class_ahb {
	private int aG;
	protected static final class_asc aD = new class_asc(false, true);
	protected static final class_asc aE = new class_asc(false, false);
	protected static final class_atj aF = new class_atj(false);

	public class_ahj(int var1, int var2) {
		super(var1);
		aG = var2;
		as.A = 10;
		as.C = 2;
		if (aG == 1) {
			as.A = 6;
			as.B = 100;
			as.C = 1;
		}

		this.a(5159473);
		this.a(0.7F, 0.8F);
		if (aG == 2) {
			aj = 353825;
			ai = 3175492;
			this.a(0.6F, 0.6F);
		}

		if (aG == 0) {
			au.add(new class_ahb.class_c_in_class_ahb(class_vr.class, 5, 4, 4));
		}

		if (aG == 3) {
			as.A = -999;
		}

	}

	@Override
	protected class_ahb a(int var1, boolean var2) {
		if (aG == 2) {
			aj = 353825;
			ai = var1;
			if (var2) {
				aj = (aj & 16711422) >> 1;
			}

			return this;
		} else {
			return super.a(var1, var2);
		}
	}

	@Override
	public class_asa a(Random var1) {
		return (aG == 3) && (var1.nextInt(3) > 0) ? aF : ((aG != 2) && (var1.nextInt(5) != 0) ? aA : aE);
	}

	@Override
	public BlockFlowers.class_a_in_class_ake a(Random var1, class_cj var2) {
		if (aG == 1) {
			double var3 = class_oa.a((1.0D + af.a(var2.n() / 48.0D, var2.p() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
			BlockFlowers.class_a_in_class_ake var5 = BlockFlowers.class_a_in_class_ake.values()[(int) (var3 * BlockFlowers.class_a_in_class_ake.values().length)];
			return var5 == BlockFlowers.class_a_in_class_ake.c ? BlockFlowers.class_a_in_class_ake.b : var5;
		} else {
			return super.a(var1, var2);
		}
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		int var4;
		int var5;
		int var6;
		int var7;
		if (aG == 3) {
			for (var4 = 0; var4 < 4; ++var4) {
				for (var5 = 0; var5 < 4; ++var5) {
					var6 = (var4 * 4) + 1 + 8 + var2.nextInt(3);
					var7 = (var5 * 4) + 1 + 8 + var2.nextInt(3);
					class_cj var8 = var1.m(var3.a(var6, 0, var7));
					if (var2.nextInt(20) == 0) {
						class_asv var9 = new class_asv();
						var9.b(var1, var2, var8);
					} else {
						class_asa var12 = this.a(var2);
						var12.e();
						if (var12.b(var1, var2, var8)) {
							var12.a(var1, var2, var8);
						}
					}
				}
			}
		}

		var4 = var2.nextInt(5) - 3;
		if (aG == 1) {
			var4 += 2;
		}

		for (var5 = 0; var5 < var4; ++var5) {
			var6 = var2.nextInt(3);
			if (var6 == 0) {
				ag.a(BlockTallPlant.class_b_in_class_ajo.b);
			} else if (var6 == 1) {
				ag.a(BlockTallPlant.class_b_in_class_ajo.e);
			} else if (var6 == 2) {
				ag.a(BlockTallPlant.class_b_in_class_ajo.f);
			}

			for (var7 = 0; var7 < 5; ++var7) {
				int var11 = var2.nextInt(16) + 8;
				int var13 = var2.nextInt(16) + 8;
				int var10 = var2.nextInt(var1.m(var3.a(var11, 0, var13)).o() + 32);
				if (ag.b(var1, var2, new class_cj(var3.n() + var11, var10, var3.p() + var13))) {
					break;
				}
			}
		}

		super.a(var1, var2, var3);
	}

	@Override
	protected class_ahb d(final int var1) {
		if (az == class_ahb.t.az) {
			class_ahj var2 = new class_ahj(var1, 1);
			var2.a(new class_ahb.class_a_in_class_ahb(an, ao + 0.2F));
			var2.a("Flower Forest");
			var2.a(6976549, true);
			var2.a(8233509);
			return var2;
		} else {
			return (az != class_ahb.Q.az) && (az != class_ahb.R.az) ? new class_ahp(var1, this) {
				@Override
				public void a(class_ago var1, Random var2, class_cj var3) {
					aE.a(var1, var2, var3);
				}
			} : new class_ahp(var1, this) {
				@Override
				public class_asa a(Random var1) {
					return var1.nextBoolean() ? class_ahj.aD : class_ahj.aE;
				}
			};
		}
	}
}
