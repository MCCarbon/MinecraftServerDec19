package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_atr extends class_asa {
	private static final class_apn a;
	private static final class_apn b;
	private final int c;
	private final boolean d;
	private final class_apn e;
	private final class_apn f;

	public class_atr(boolean var1) {
		this(var1, 4, a, b, false);
	}

	public class_atr(boolean var1, int var2, class_apn var3, class_apn var4, boolean var5) {
		super(var1);
		c = var2;
		e = var3;
		f = var4;
		d = var5;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		int var4 = var2.nextInt(3) + c;
		boolean var5 = true;
		if ((var3.o() >= 1) && ((var3.o() + var4 + 1) <= 256)) {
			byte var7;
			int var9;
			int var10;
			for (int var6 = var3.o(); var6 <= (var3.o() + 1 + var4); ++var6) {
				var7 = 1;
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
				Block var19 = var1.p(var3.b()).c();
				if (((var19 == Blocks.GRASS) || (var19 == Blocks.DIRT) || (var19 == Blocks.ak)) && (var3.o() < (256 - var4 - 1))) {
					this.a(var1, var3.b());
					var7 = 3;
					byte var20 = 0;

					int var11;
					int var13;
					int var14;
					class_cj var16;
					for (var9 = (var3.o() - var7) + var4; var9 <= (var3.o() + var4); ++var9) {
						var10 = var9 - (var3.o() + var4);
						var11 = (var20 + 1) - (var10 / 2);

						for (int var12 = var3.n() - var11; var12 <= (var3.n() + var11); ++var12) {
							var13 = var12 - var3.n();

							for (var14 = var3.p() - var11; var14 <= (var3.p() + var11); ++var14) {
								int var15 = var14 - var3.p();
								if ((Math.abs(var13) != var11) || (Math.abs(var15) != var11) || ((var2.nextInt(2) != 0) && (var10 != 0))) {
									var16 = new class_cj(var12, var9, var14);
									Block var17 = var1.p(var16).c();
									if ((var17.v() == class_avq.a) || (var17.v() == class_avq.j) || (var17.v() == class_avq.l)) {
										this.a(var1, var16, f);
									}
								}
							}
						}
					}

					for (var9 = 0; var9 < var4; ++var9) {
						Block var21 = var1.p(var3.b(var9)).c();
						if ((var21.v() == class_avq.a) || (var21.v() == class_avq.j) || (var21.v() == class_avq.l)) {
							this.a(var1, var3.b(var9), e);
							if (d && (var9 > 0)) {
								if ((var2.nextInt(3) > 0) && var1.d(var3.a(-1, var9, 0))) {
									this.a(var1, var3.a(-1, var9, 0), class_anw.N);
								}

								if ((var2.nextInt(3) > 0) && var1.d(var3.a(1, var9, 0))) {
									this.a(var1, var3.a(1, var9, 0), class_anw.P);
								}

								if ((var2.nextInt(3) > 0) && var1.d(var3.a(0, var9, -1))) {
									this.a(var1, var3.a(0, var9, -1), class_anw.O);
								}

								if ((var2.nextInt(3) > 0) && var1.d(var3.a(0, var9, 1))) {
									this.a(var1, var3.a(0, var9, 1), class_anw.b);
								}
							}
						}
					}

					if (d) {
						for (var9 = (var3.o() - 3) + var4; var9 <= (var3.o() + var4); ++var9) {
							var10 = var9 - (var3.o() + var4);
							var11 = 2 - (var10 / 2);
							class_cj.class_a_in_class_cj var24 = new class_cj.class_a_in_class_cj();

							for (var13 = var3.n() - var11; var13 <= (var3.n() + var11); ++var13) {
								for (var14 = var3.p() - var11; var14 <= (var3.p() + var11); ++var14) {
									var24.c(var13, var9, var14);
									if (var1.p(var24).c().v() == class_avq.j) {
										class_cj var26 = var24.e();
										var16 = var24.f();
										class_cj var27 = var24.c();
										class_cj var18 = var24.d();
										if ((var2.nextInt(4) == 0) && (var1.p(var26).c().v() == class_avq.a)) {
											this.b(var1, var26, class_anw.N);
										}

										if ((var2.nextInt(4) == 0) && (var1.p(var16).c().v() == class_avq.a)) {
											this.b(var1, var16, class_anw.P);
										}

										if ((var2.nextInt(4) == 0) && (var1.p(var27).c().v() == class_avq.a)) {
											this.b(var1, var27, class_anw.O);
										}

										if ((var2.nextInt(4) == 0) && (var1.p(var18).c().v() == class_avq.a)) {
											this.b(var1, var18, class_anw.b);
										}
									}
								}
							}
						}

						if ((var2.nextInt(5) == 0) && (var4 > 5)) {
							for (var9 = 0; var9 < 2; ++var9) {
								Iterator var22 = class_cq.class_c_in_class_cq.a.iterator();

								while (var22.hasNext()) {
									class_cq var23 = (class_cq) var22.next();
									if (var2.nextInt(4 - var9) == 0) {
										class_cq var25 = var23.d();
										this.a(var1, var2.nextInt(3), var3.a(var25.g(), (var4 - 5) + var9, var25.i()), var23);
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

	private void a(class_ago var1, int var2, class_cj var3, class_cq var4) {
		this.a(var1, var3, Blocks.bN.S().a(class_aja.a, Integer.valueOf(var2)).a(class_akx.O, var4));
	}

	private void a(class_ago var1, class_cj var2, class_apy var3) {
		this.a(var1, var2, Blocks.bn.S().a(var3, Boolean.valueOf(true)));
	}

	private void b(class_ago var1, class_cj var2, class_apy var3) {
		this.a(var1, var2, var3);
		int var4 = 4;

		for (var2 = var2.b(); (var1.p(var2).c().v() == class_avq.a) && (var4 > 0); --var4) {
			this.a(var1, var2, var3);
			var2 = var2.b();
		}

	}

	static {
		a = Blocks.LOG.S().a(class_alv.b, class_aly.class_a_in_class_aly.a);
		b = Blocks.LEAVES.S().a(class_alu.P, class_aly.class_a_in_class_aly.a).a(class_alc.b, Boolean.valueOf(false));
	}
}
