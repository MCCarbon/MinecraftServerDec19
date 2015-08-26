package net.minecraft.server;

import java.util.Random;

public class class_asv extends class_asp {
	private Block a;

	public class_asv(Block var1) {
		super(true);
		a = var1;
	}

	public class_asv() {
		super(false);
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		if (a == null) {
			a = var2.nextBoolean() ? Blocks.bg : Blocks.bh;
		}

		int var4 = var2.nextInt(3) + 4;
		boolean var5 = true;
		if ((var3.o() >= 1) && ((var3.o() + var4 + 1) < 256)) {
			int var9;
			int var10;
			for (int var6 = var3.o(); var6 <= (var3.o() + 1 + var4); ++var6) {
				byte var7 = 3;
				if (var6 <= (var3.o() + 3)) {
					var7 = 0;
				}

				class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

				for (var9 = var3.n() - var7; (var9 <= (var3.n() + var7)) && var5; ++var9) {
					for (var10 = var3.p() - var7; (var10 <= (var3.p() + var7)) && var5; ++var10) {
						if ((var6 >= 0) && (var6 < 256)) {
							Block var11 = var1.p(var8.c(var9, var6, var10)).c();
							if ((var11.v() != class_avq.a) && (var11.v() != class_avq.j)) {
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
				Block var19 = var1.p(var3.b()).c();
				if ((var19 != Blocks.DIRT) && (var19 != Blocks.GRASS) && (var19 != Blocks.bw)) {
					return false;
				} else {
					int var20 = var3.o() + var4;
					if (a == Blocks.bh) {
						var20 = (var3.o() + var4) - 3;
					}

					int var21;
					for (var21 = var20; var21 <= (var3.o() + var4); ++var21) {
						var9 = 1;
						if (var21 < (var3.o() + var4)) {
							++var9;
						}

						if (a == Blocks.bg) {
							var9 = 3;
						}

						var10 = var3.n() - var9;
						int var23 = var3.n() + var9;
						int var12 = var3.p() - var9;
						int var13 = var3.p() + var9;

						for (int var14 = var10; var14 <= var23; ++var14) {
							for (int var15 = var12; var15 <= var13; ++var15) {
								int var16 = 5;
								if (var14 == var10) {
									--var16;
								} else if (var14 == var23) {
									++var16;
								}

								if (var15 == var12) {
									var16 -= 3;
								} else if (var15 == var13) {
									var16 += 3;
								}

								class_aky.class_a_in_class_aky var17 = class_aky.class_a_in_class_aky.a(var16);
								if ((a == Blocks.bg) || (var21 < (var3.o() + var4))) {
									if (((var14 == var10) || (var14 == var23)) && ((var15 == var12) || (var15 == var13))) {
										continue;
									}

									if ((var14 == (var3.n() - (var9 - 1))) && (var15 == var12)) {
										var17 = class_aky.class_a_in_class_aky.a;
									}

									if ((var14 == var10) && (var15 == (var3.p() - (var9 - 1)))) {
										var17 = class_aky.class_a_in_class_aky.a;
									}

									if ((var14 == (var3.n() + (var9 - 1))) && (var15 == var12)) {
										var17 = class_aky.class_a_in_class_aky.c;
									}

									if ((var14 == var23) && (var15 == (var3.p() - (var9 - 1)))) {
										var17 = class_aky.class_a_in_class_aky.c;
									}

									if ((var14 == (var3.n() - (var9 - 1))) && (var15 == var13)) {
										var17 = class_aky.class_a_in_class_aky.g;
									}

									if ((var14 == var10) && (var15 == (var3.p() + (var9 - 1)))) {
										var17 = class_aky.class_a_in_class_aky.g;
									}

									if ((var14 == (var3.n() + (var9 - 1))) && (var15 == var13)) {
										var17 = class_aky.class_a_in_class_aky.i;
									}

									if ((var14 == var23) && (var15 == (var3.p() + (var9 - 1)))) {
										var17 = class_aky.class_a_in_class_aky.i;
									}
								}

								if ((var17 == class_aky.class_a_in_class_aky.e) && (var21 < (var3.o() + var4))) {
									var17 = class_aky.class_a_in_class_aky.k;
								}

								if ((var3.o() >= ((var3.o() + var4) - 1)) || (var17 != class_aky.class_a_in_class_aky.k)) {
									class_cj var18 = new class_cj(var14, var21, var15);
									if (!var1.p(var18).c().q()) {
										a(var1, var18, a.S().a(class_aky.a, var17));
									}
								}
							}
						}
					}

					for (var21 = 0; var21 < var4; ++var21) {
						Block var22 = var1.p(var3.b(var21)).c();
						if (!var22.q()) {
							a(var1, var3.b(var21), a.S().a(class_aky.a, class_aky.class_a_in_class_aky.j));
						}
					}

					return true;
				}
			}
		} else {
			return false;
		}
	}
}
