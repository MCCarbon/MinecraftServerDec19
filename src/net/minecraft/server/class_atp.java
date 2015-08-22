package net.minecraft.server;

import java.util.Random;

public class class_atp extends class_asa {
	private static final class_apn a;
	private static final class_apn b;

	public class_atp() {
		super(false);
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		int var4;
		for (var4 = var2.nextInt(4) + 5; var1.p(var3.b()).c().v() == class_avq.h; var3 = var3.b()) {
			;
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
					var7 = 3;
				}

				class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

				for (var9 = var3.n() - var7; (var9 <= (var3.n() + var7)) && var5; ++var9) {
					for (var10 = var3.p() - var7; (var10 <= (var3.p() + var7)) && var5; ++var10) {
						if ((var6 >= 0) && (var6 < 256)) {
							Block var11 = var1.p(var8.c(var9, var6, var10)).c();
							if ((var11.v() != class_avq.a) && (var11.v() != class_avq.j)) {
								if ((var11 != Blocks.j) && (var11 != Blocks.i)) {
									var5 = false;
								} else if (var6 > var3.o()) {
									var5 = false;
								}
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
				Block var17 = var1.p(var3.b()).c();
				if (((var17 == Blocks.c) || (var17 == Blocks.d)) && (var3.o() < (256 - var4 - 1))) {
					this.a(var1, var3.b());

					int var12;
					class_cj var14;
					int var18;
					int var19;
					int var21;
					for (var18 = (var3.o() - 3) + var4; var18 <= (var3.o() + var4); ++var18) {
						var19 = var18 - (var3.o() + var4);
						var9 = 2 - (var19 / 2);

						for (var10 = var3.n() - var9; var10 <= (var3.n() + var9); ++var10) {
							var21 = var10 - var3.n();

							for (var12 = var3.p() - var9; var12 <= (var3.p() + var9); ++var12) {
								int var13 = var12 - var3.p();
								if ((Math.abs(var21) != var9) || (Math.abs(var13) != var9) || ((var2.nextInt(2) != 0) && (var19 != 0))) {
									var14 = new class_cj(var10, var18, var12);
									if (!var1.p(var14).c().q()) {
										this.a(var1, var14, b);
									}
								}
							}
						}
					}

					for (var18 = 0; var18 < var4; ++var18) {
						Block var20 = var1.p(var3.b(var18)).c();
						if ((var20.v() == class_avq.a) || (var20.v() == class_avq.j) || (var20 == Blocks.i) || (var20 == Blocks.j)) {
							this.a(var1, var3.b(var18), a);
						}
					}

					for (var18 = (var3.o() - 3) + var4; var18 <= (var3.o() + var4); ++var18) {
						var19 = var18 - (var3.o() + var4);
						var9 = 2 - (var19 / 2);
						class_cj.class_a_in_class_cj var22 = new class_cj.class_a_in_class_cj();

						for (var21 = var3.n() - var9; var21 <= (var3.n() + var9); ++var21) {
							for (var12 = var3.p() - var9; var12 <= (var3.p() + var9); ++var12) {
								var22.c(var21, var18, var12);
								if (var1.p(var22).c().v() == class_avq.j) {
									class_cj var23 = var22.e();
									var14 = var22.f();
									class_cj var15 = var22.c();
									class_cj var16 = var22.d();
									if ((var2.nextInt(4) == 0) && (var1.p(var23).c().v() == class_avq.a)) {
										this.a(var1, var23, class_anw.N);
									}

									if ((var2.nextInt(4) == 0) && (var1.p(var14).c().v() == class_avq.a)) {
										this.a(var1, var14, class_anw.P);
									}

									if ((var2.nextInt(4) == 0) && (var1.p(var15).c().v() == class_avq.a)) {
										this.a(var1, var15, class_anw.O);
									}

									if ((var2.nextInt(4) == 0) && (var1.p(var16).c().v() == class_avq.a)) {
										this.a(var1, var16, class_anw.b);
									}
								}
							}
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

	private void a(class_ago var1, class_cj var2, class_apy var3) {
		class_apn var4 = Blocks.bn.S().a(var3, Boolean.valueOf(true));
		this.a(var1, var2, var4);
		int var5 = 4;

		for (var2 = var2.b(); (var1.p(var2).c().v() == class_avq.a) && (var5 > 0); --var5) {
			this.a(var1, var2, var4);
			var2 = var2.b();
		}

	}

	static {
		a = Blocks.r.S().a(class_alv.b, class_aly.class_a_in_class_aly.a);
		b = Blocks.t.S().a(class_alu.P, class_aly.class_a_in_class_aly.a).a(class_alc.b, Boolean.valueOf(false));
	}
}
