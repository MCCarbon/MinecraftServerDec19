package net.minecraft.server;

import java.util.Random;

public class class_ato extends class_asa {
	private static final class_apn a;
	private static final class_apn b;

	public class_ato(boolean var1) {
		super(var1);
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		int var4 = var2.nextInt(4) + 6;
		int var5 = 1 + var2.nextInt(2);
		int var6 = var4 - var5;
		int var7 = 2 + var2.nextInt(2);
		boolean var8 = true;
		if ((var3.o() >= 1) && ((var3.o() + var4 + 1) <= 256)) {
			int var13;
			int var21;
			for (int var9 = var3.o(); (var9 <= (var3.o() + 1 + var4)) && var8; ++var9) {
				boolean var10 = true;
				if ((var9 - var3.o()) < var5) {
					var21 = 0;
				} else {
					var21 = var7;
				}

				class_cj.class_a_in_class_cj var11 = new class_cj.class_a_in_class_cj();

				for (int var12 = var3.n() - var21; (var12 <= (var3.n() + var21)) && var8; ++var12) {
					for (var13 = var3.p() - var21; (var13 <= (var3.p() + var21)) && var8; ++var13) {
						if ((var9 >= 0) && (var9 < 256)) {
							Block var14 = var1.p(var11.c(var12, var9, var13)).c();
							if ((var14.v() != class_avq.a) && (var14.v() != class_avq.j)) {
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
				Block var20 = var1.p(var3.b()).c();
				if (((var20 == Blocks.GRASS) || (var20 == Blocks.DIRT) || (var20 == Blocks.ak)) && (var3.o() < (256 - var4 - 1))) {
					this.a(var1, var3.b());
					var21 = var2.nextInt(2);
					int var22 = 1;
					byte var23 = 0;

					int var24;
					for (var13 = 0; var13 <= var6; ++var13) {
						var24 = (var3.o() + var4) - var13;

						for (int var15 = var3.n() - var21; var15 <= (var3.n() + var21); ++var15) {
							int var16 = var15 - var3.n();

							for (int var17 = var3.p() - var21; var17 <= (var3.p() + var21); ++var17) {
								int var18 = var17 - var3.p();
								if ((Math.abs(var16) != var21) || (Math.abs(var18) != var21) || (var21 <= 0)) {
									class_cj var19 = new class_cj(var15, var24, var17);
									if (!var1.p(var19).c().q()) {
										this.a(var1, var19, b);
									}
								}
							}
						}

						if (var21 >= var22) {
							var21 = var23;
							var23 = 1;
							++var22;
							if (var22 > var7) {
								var22 = var7;
							}
						} else {
							++var21;
						}
					}

					var13 = var2.nextInt(3);

					for (var24 = 0; var24 < (var4 - var13); ++var24) {
						Block var25 = var1.p(var3.b(var24)).c();
						if ((var25.v() == class_avq.a) || (var25.v() == class_avq.j)) {
							this.a(var1, var3.b(var24), a);
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
