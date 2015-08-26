package net.minecraft.server;

import java.util.Random;

public class class_atg extends class_asa {
	private static final class_apn a;
	private static final class_apn b;

	public class_atg() {
		super(false);
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		int var4 = var2.nextInt(5) + 7;
		int var5 = var4 - var2.nextInt(2) - 3;
		int var6 = var4 - var5;
		int var7 = 1 + var2.nextInt(var6 + 1);
		boolean var8 = true;
		if ((var3.o() >= 1) && ((var3.o() + var4 + 1) <= 256)) {
			int var12;
			int var13;
			int var18;
			for (int var9 = var3.o(); (var9 <= (var3.o() + 1 + var4)) && var8; ++var9) {
				boolean var10 = true;
				if ((var9 - var3.o()) < var5) {
					var18 = 0;
				} else {
					var18 = var7;
				}

				class_cj.class_a_in_class_cj var11 = new class_cj.class_a_in_class_cj();

				for (var12 = var3.n() - var18; (var12 <= (var3.n() + var18)) && var8; ++var12) {
					for (var13 = var3.p() - var18; (var13 <= (var3.p() + var18)) && var8; ++var13) {
						if ((var9 >= 0) && (var9 < 256)) {
							if (!this.a(var1.p(var11.c(var12, var9, var13)).c())) {
								var8 = false;
							}
						} else {
							var8 = false;
						}
					}
				}
			}

			if (!var8) {
				return false;
			} else {
				Block var17 = var1.p(var3.b()).c();
				if (((var17 == Blocks.GRASS) || (var17 == Blocks.DIRT)) && (var3.o() < (256 - var4 - 1))) {
					this.a(var1, var3.b());
					var18 = 0;

					int var19;
					for (var19 = var3.o() + var4; var19 >= (var3.o() + var5); --var19) {
						for (var12 = var3.n() - var18; var12 <= (var3.n() + var18); ++var12) {
							var13 = var12 - var3.n();

							for (int var14 = var3.p() - var18; var14 <= (var3.p() + var18); ++var14) {
								int var15 = var14 - var3.p();
								if ((Math.abs(var13) != var18) || (Math.abs(var15) != var18) || (var18 <= 0)) {
									class_cj var16 = new class_cj(var12, var19, var14);
									if (!var1.p(var16).c().q()) {
										this.a(var1, var16, b);
									}
								}
							}
						}

						if ((var18 >= 1) && (var19 == (var3.o() + var5 + 1))) {
							--var18;
						} else if (var18 < var7) {
							++var18;
						}
					}

					for (var19 = 0; var19 < (var4 - 1); ++var19) {
						Block var20 = var1.p(var3.b(var19)).c();
						if ((var20.v() == class_avq.a) || (var20.v() == class_avq.j)) {
							this.a(var1, var3.b(var19), a);
						}
					}

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	static {
		a = Blocks.LOG.S().a(class_alv.b, class_aly.class_a_in_class_aly.b);
		b = Blocks.LEAVES.S().a(class_alu.P, class_aly.class_a_in_class_aly.b).a(class_alc.b, Boolean.valueOf(false));
	}
}
