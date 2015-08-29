package net.minecraft.server;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;

public class class_acu extends class_abo {
	protected class_acu() {
		this.a(true);
	}

	public class_axl a(class_aco var1, class_ago var2) {
		String var3 = "map_" + var1.i();
		class_axl var4 = (class_axl) var2.a(class_axl.class, var3);
		if ((var4 == null) && !var2.D) {
			var1.b(var2.b("map"));
			var3 = "map_" + var1.i();
			var4 = new class_axl(var3);
			var4.f = 3;
			var4.a(var2.R().b(), var2.R().d(), var4.f);
			var4.d = (byte) var2.t.p().a();
			var4.c();
			var2.a(var3, var4);
		}

		return var4;
	}

	public void a(class_ago var1, Entity var2, class_axl var3) {
		if ((var1.t.p().a() == var3.d) && (var2 instanceof class_yu)) {
			int var4 = 1 << var3.f;
			int var5 = var3.b;
			int var6 = var3.c;
			int var7 = (MathHelper.c(var2.s - var5) / var4) + 64;
			int var8 = (MathHelper.c(var2.u - var6) / var4) + 64;
			int var9 = 128 / var4;
			if (var1.t.m()) {
				var9 /= 2;
			}

			class_axl.class_a_in_class_axl var10 = var3.a((class_yu) var2);
			++var10.b;
			boolean var11 = false;

			for (int var12 = (var7 - var9) + 1; var12 < (var7 + var9); ++var12) {
				if (((var12 & 15) == (var10.b & 15)) || var11) {
					var11 = false;
					double var13 = 0.0D;

					for (int var15 = var8 - var9 - 1; var15 < (var8 + var9); ++var15) {
						if ((var12 >= 0) && (var15 >= -1) && (var12 < 128) && (var15 < 128)) {
							int var16 = var12 - var7;
							int var17 = var15 - var8;
							boolean var18 = ((var16 * var16) + (var17 * var17)) > ((var9 - 2) * (var9 - 2));
							int var19 = (((var5 / var4) + var12) - 64) * var4;
							int var20 = (((var6 / var4) + var15) - 64) * var4;
							HashMultiset var21 = HashMultiset.create();
							class_aqn var22 = var1.f(new class_cj(var19, 0, var20));
							if (!var22.f()) {
								int var23 = var19 & 15;
								int var24 = var20 & 15;
								int var25 = 0;
								double var26 = 0.0D;
								if (var1.t.m()) {
									int var28 = var19 + (var20 * 231871);
									var28 = (var28 * var28 * 31287121) + (var28 * 11);
									if (((var28 >> 20) & 1) == 0) {
										var21.add(Blocks.DIRT.g(Blocks.DIRT.getBlockData().a(class_ajl.a, class_ajl.class_a_in_class_ajl.a)), 10);
									} else {
										var21.add(Blocks.STONE.g(Blocks.STONE.getBlockData().a(class_anj.a, class_anj.class_a_in_class_anj.a)), 100);
									}

									var26 = 100.0D;
								} else {
									class_cj.class_a_in_class_cj var35 = new class_cj.class_a_in_class_cj();

									for (int var29 = 0; var29 < var4; ++var29) {
										for (int var30 = 0; var30 < var4; ++var30) {
											int var31 = var22.b(var29 + var23, var30 + var24) + 1;
											class_apn var32 = Blocks.AIR.getBlockData();
											if (var31 > 1) {
												do {
													--var31;
													var32 = var22.g(var35.c(var29 + var23, var31, var30 + var24));
												} while ((var32.c().g(var32) == class_avr.b) && (var31 > 0));

												if ((var31 > 0) && var32.c().v().d()) {
													int var33 = var31 - 1;

													Block var34;
													do {
														var34 = var22.a(var29 + var23, var33--, var30 + var24);
														++var25;
													} while ((var33 > 0) && var34.v().d());
												}
											}

											var26 += (double) var31 / (double) (var4 * var4);
											var21.add(var32.c().g(var32));
										}
									}
								}

								var25 /= var4 * var4;
								double var36 = (((var26 - var13) * 4.0D) / (var4 + 4)) + ((((var12 + var15) & 1) - 0.5D) * 0.4D);
								byte var37 = 1;
								if (var36 > 0.6D) {
									var37 = 2;
								}

								if (var36 < -0.6D) {
									var37 = 0;
								}

								class_avr var38 = Iterables.getFirst(Multisets.copyHighestCountFirst(var21), class_avr.b);
								if (var38 == class_avr.n) {
									var36 = (var25 * 0.1D) + (((var12 + var15) & 1) * 0.2D);
									var37 = 1;
									if (var36 < 0.5D) {
										var37 = 2;
									}

									if (var36 > 0.9D) {
										var37 = 0;
									}
								}

								var13 = var26;
								if ((var15 >= 0) && (((var16 * var16) + (var17 * var17)) < (var9 * var9)) && (!var18 || (((var12 + var15) & 1) != 0))) {
									byte var39 = var3.g[var12 + (var15 * 128)];
									byte var40 = (byte) ((var38.M * 4) + var37);
									if (var39 != var40) {
										var3.g[var12 + (var15 * 128)] = var40;
										var3.a(var12, var15);
										var11 = true;
									}
								}
							}
						}
					}
				}
			}

		}
	}

	@Override
	public void a(class_aco var1, class_ago var2, Entity var3, int var4, boolean var5) {
		if (!var2.D) {
			class_axl var6 = this.a(var1, var2);
			if (var3 instanceof class_yu) {
				class_yu var7 = (class_yu) var3;
				var6.a(var7, var1);
			}

			if (var5) {
				this.a(var2, var3, var6);
			}

		}
	}

	@Override
	public Packet a(class_aco var1, class_ago var2, class_yu var3) {
		return this.a(var1, var2).a(var1, var2, var3);
	}

	@Override
	public void b(class_aco var1, class_ago var2, class_yu var3) {
		class_dn var4 = var1.o();
		if (var4 != null) {
			if (var4.b("map_scale_direction", 99)) {
				a(var1, var2, var4.h("map_scale_direction"));
				var4.q("map_scale_direction");
			} else if (var4.p("map_tracking_position")) {
				b(var1, var2);
				var4.q("map_tracking_position");
			}
		}

	}

	protected static void a(class_aco var0, class_ago var1, int var2) {
		class_axl var3 = Items.bf.a(var0, var1);
		var0.b(var1.b("map"));
		class_axl var4 = new class_axl("map_" + var0.i());
		var4.f = (byte) MathHelper.a(var3.f + var2, 0, 4);
		var4.e = var3.e;
		var4.a(var3.b, var3.c, var4.f);
		var4.d = var3.d;
		var4.c();
		var1.a("map_" + var0.i(), var4);
	}

	protected static void b(class_aco var0, class_ago var1) {
		class_axl var2 = Items.bf.a(var0, var1);
		var0.b(var1.b("map"));
		class_axl var3 = new class_axl("map_" + var0.i());
		var3.e = true;
		var3.b = var2.b;
		var3.c = var2.c;
		var3.f = var2.f;
		var3.d = var2.d;
		var3.c();
		var1.a("map_" + var0.i(), var3);
	}
}
