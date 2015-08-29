package net.minecraft.server;

import java.util.Random;

public class class_asc extends class_asa {
	private static final class_apn a;
	private static final class_apn b;
	private boolean c;

	public class_asc(boolean var1, boolean var2) {
		super(var1);
		c = var2;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		int var4 = var2.nextInt(3) + 5;
		if (c) {
			var4 += var2.nextInt(7);
		}

		boolean var5 = true;
		if ((var3.o() >= 1) && ((var3.o() + var4 + 1) <= 256)) {
			int var9;
			int var10;
			for (int var6 = var3.o(); var6 <= (var3.o() + 1 + var4); ++var6) {
				byte var7 = 1;
				if (var6 == var3.o()) {
					var7 = 0;
				}

				if (var6 >= ((var3.o() + 1 + var4) - 2)) {
					var7 = 2;
				}

				class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

				for (var9 = var3.n() - var7; (var9 <= (var3.n() + var7)) && var5; ++var9) {
					for (var10 = var3.p() - var7; (var10 <= (var3.p() + var7)) && var5; ++var10) {
						if ((var6 >= 0) && (var6 < 256)) {
							if (!this.a(var1.p(var8.c(var9, var6, var10)).c())) {
								var5 = false;
							}
						} else {
							var5 = false;
						}
					}
				}
			}

			if (!var5) {
				return false;
			} else {
				Block var16 = var1.p(var3.b()).c();
				if (((var16 == Blocks.GRASS) || (var16 == Blocks.DIRT) || (var16 == Blocks.FARMLAND)) && (var3.o() < (256 - var4 - 1))) {
					this.a(var1, var3.b());

					int var17;
					for (var17 = (var3.o() - 3) + var4; var17 <= (var3.o() + var4); ++var17) {
						int var18 = var17 - (var3.o() + var4);
						var9 = 1 - (var18 / 2);

						for (var10 = var3.n() - var9; var10 <= (var3.n() + var9); ++var10) {
							int var11 = var10 - var3.n();

							for (int var12 = var3.p() - var9; var12 <= (var3.p() + var9); ++var12) {
								int var13 = var12 - var3.p();
								if ((Math.abs(var11) != var9) || (Math.abs(var13) != var9) || ((var2.nextInt(2) != 0) && (var18 != 0))) {
									class_cj var14 = new class_cj(var10, var17, var12);
									Block var15 = var1.p(var14).c();
									if ((var15.v() == class_avq.a) || (var15.v() == class_avq.j)) {
										this.a(var1, var14, b);
									}
								}
							}
						}
					}

					for (var17 = 0; var17 < var4; ++var17) {
						Block var19 = var1.p(var3.b(var17)).c();
						if ((var19.v() == class_avq.a) || (var19.v() == class_avq.j)) {
							this.a(var1, var3.b(var17), a);
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
		a = Blocks.LOG.getBlockData().a(class_alv.b, class_aly.class_a_in_class_aly.c);
		b = Blocks.LEAVES.getBlockData().a(class_alu.P, class_aly.class_a_in_class_aly.c).a(class_alc.b, Boolean.valueOf(false));
	}
}
