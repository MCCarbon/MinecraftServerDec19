package net.minecraft.server;

import java.util.Random;

public abstract class class_alc extends class_ans {
	public static final class_apy a = class_apy.a("decayable");
	public static final class_apy b = class_apy.a("check_decay");
	int[] N;

	public class_alc() {
		super(class_avq.j, false);
		this.a(true);
		this.a(class_abp.c);
		this.c(0.2F);
		this.e(1);
		this.a(h);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		byte var4 = 1;
		int var5 = var4 + 1;
		int var6 = var2.n();
		int var7 = var2.o();
		int var8 = var2.p();
		if (var1.a(new class_cj(var6 - var5, var7 - var5, var8 - var5), new class_cj(var6 + var5, var7 + var5, var8 + var5))) {
			for (int var9 = -var4; var9 <= var4; ++var9) {
				for (int var10 = -var4; var10 <= var4; ++var10) {
					for (int var11 = -var4; var11 <= var4; ++var11) {
						class_cj var12 = var2.a(var9, var10, var11);
						class_apn var13 = var1.p(var12);
						if ((var13.c().v() == class_avq.j) && !((Boolean) var13.b(b)).booleanValue()) {
							var1.a(var12, var13.a(b, Boolean.valueOf(true)), 4);
						}
					}
				}
			}
		}

	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			if (((Boolean) var3.b(b)).booleanValue() && ((Boolean) var3.b(a)).booleanValue()) {
				byte var5 = 4;
				int var6 = var5 + 1;
				int var7 = var2.n();
				int var8 = var2.o();
				int var9 = var2.p();
				byte var10 = 32;
				int var11 = var10 * var10;
				int var12 = var10 / 2;
				if (N == null) {
					N = new int[var10 * var10 * var10];
				}

				if (var1.a(new class_cj(var7 - var6, var8 - var6, var9 - var6), new class_cj(var7 + var6, var8 + var6, var9 + var6))) {
					class_cj.class_a_in_class_cj var13 = new class_cj.class_a_in_class_cj();
					int var14 = -var5;

					label116: while (true) {
						int var15;
						int var16;
						if (var14 > var5) {
							var14 = 1;

							while (true) {
								if (var14 > 4) {
									break label116;
								}

								for (var15 = -var5; var15 <= var5; ++var15) {
									for (var16 = -var5; var16 <= var5; ++var16) {
										for (int var19 = -var5; var19 <= var5; ++var19) {
											if (N[((var15 + var12) * var11) + ((var16 + var12) * var10) + var19 + var12] == (var14 - 1)) {
												if (N[(((var15 + var12) - 1) * var11) + ((var16 + var12) * var10) + var19 + var12] == -2) {
													N[(((var15 + var12) - 1) * var11) + ((var16 + var12) * var10) + var19 + var12] = var14;
												}

												if (N[((var15 + var12 + 1) * var11) + ((var16 + var12) * var10) + var19 + var12] == -2) {
													N[((var15 + var12 + 1) * var11) + ((var16 + var12) * var10) + var19 + var12] = var14;
												}

												if (N[((var15 + var12) * var11) + (((var16 + var12) - 1) * var10) + var19 + var12] == -2) {
													N[((var15 + var12) * var11) + (((var16 + var12) - 1) * var10) + var19 + var12] = var14;
												}

												if (N[((var15 + var12) * var11) + ((var16 + var12 + 1) * var10) + var19 + var12] == -2) {
													N[((var15 + var12) * var11) + ((var16 + var12 + 1) * var10) + var19 + var12] = var14;
												}

												if (N[((var15 + var12) * var11) + ((var16 + var12) * var10) + ((var19 + var12) - 1)] == -2) {
													N[((var15 + var12) * var11) + ((var16 + var12) * var10) + ((var19 + var12) - 1)] = var14;
												}

												if (N[((var15 + var12) * var11) + ((var16 + var12) * var10) + var19 + var12 + 1] == -2) {
													N[((var15 + var12) * var11) + ((var16 + var12) * var10) + var19 + var12 + 1] = var14;
												}
											}
										}
									}
								}

								++var14;
							}
						}

						for (var15 = -var5; var15 <= var5; ++var15) {
							for (var16 = -var5; var16 <= var5; ++var16) {
								Block var17 = var1.p(var13.c(var7 + var14, var8 + var15, var9 + var16)).c();
								if ((var17 != Blocks.r) && (var17 != Blocks.s)) {
									if (var17.v() == class_avq.j) {
										N[((var14 + var12) * var11) + ((var15 + var12) * var10) + var16 + var12] = -2;
									} else {
										N[((var14 + var12) * var11) + ((var15 + var12) * var10) + var16 + var12] = -1;
									}
								} else {
									N[((var14 + var12) * var11) + ((var15 + var12) * var10) + var16 + var12] = 0;
								}
							}
						}

						++var14;
					}
				}

				int var18 = N[(var12 * var11) + (var12 * var10) + var12];
				if (var18 >= 0) {
					var1.a(var2, var3.a(b, Boolean.valueOf(false)), 4);
				} else {
					this.d(var1, var2);
				}
			}

		}
	}

	private void d(class_ago var1, class_cj var2) {
		this.b(var1, var2, var1.p(var2), 0);
		var1.g(var2);
	}

	@Override
	public int a(Random var1) {
		return var1.nextInt(20) == 0 ? 1 : 0;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.g);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = this.d(var3);
			if (var5 > 0) {
				var6 -= 2 << var5;
				if (var6 < 10) {
					var6 = 10;
				}
			}

			if (var1.s.nextInt(var6) == 0) {
				Item var7 = this.a(var3, var1.s, var5);
				a(var1, var2, new class_aco(var7, 1, this.a(var3)));
			}

			var6 = 200;
			if (var5 > 0) {
				var6 -= 10 << var5;
				if (var6 < 40) {
					var6 = 40;
				}
			}

			this.a(var1, var2, var3, var6);
		}

	}

	protected void a(class_ago var1, class_cj var2, class_apn var3, int var4) {
	}

	protected int d(class_apn var1) {
		return 20;
	}

	@Override
	public boolean c() {
		return !Q;
	}

	@Override
	public boolean y() {
		return false;
	}

	public abstract class_aly.class_a_in_class_aly b(int var1);
}
