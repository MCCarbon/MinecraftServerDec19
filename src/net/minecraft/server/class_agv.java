package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

public final class class_agv {
	private static final int a = (int) Math.pow(17.0D, 2.0D);
	private final Set b = Sets.newHashSet();

	public int a(class_ll var1, boolean var2, boolean var3, boolean var4) {
		if (!var2 && !var3) {
			return 0;
		} else {
			b.clear();
			int var5 = 0;
			Iterator var6 = var1.j.iterator();

			while (true) {
				class_yu var7;
				int var9;
				int var12;
				do {
					if (!var6.hasNext()) {
						int var36 = 0;
						class_cj var37 = var1.O();
						class_ri[] var38 = class_ri.values();
						var9 = var38.length;

						label132: for (int var39 = 0; var39 < var9; ++var39) {
							class_ri var40 = var38[var39];
							if ((!var40.d() || var3) && (var40.d() || var2) && (!var40.e() || var4)) {
								var12 = var1.a(var40.a());
								int var41 = (var40.b() * var5) / a;
								if (var12 <= var41) {
									Iterator var42 = b.iterator();

									label129: while (true) {
										int var17;
										int var18;
										int var19;
										Block var20;
										do {
											if (!var42.hasNext()) {
												continue label132;
											}

											class_agi var15 = (class_agi) var42.next();
											class_cj var16 = a(var1, var15.a, var15.b);
											var17 = var16.n();
											var18 = var16.o();
											var19 = var16.p();
											var20 = var1.p(var16).c();
										} while (var20.x());

										int var21 = 0;

										for (int var22 = 0; var22 < 3; ++var22) {
											int var23 = var17;
											int var24 = var18;
											int var25 = var19;
											byte var26 = 6;
											class_ahb.class_c_in_class_ahb var27 = null;
											class_rj var28 = null;

											for (int var29 = 0; var29 < 4; ++var29) {
												var23 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
												var24 += var1.s.nextInt(1) - var1.s.nextInt(1);
												var25 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
												class_cj var30 = new class_cj(var23, var24, var25);
												float var31 = var23 + 0.5F;
												float var32 = var25 + 0.5F;
												if (!var1.b(var31, var24, var32, 24.0D) && (var37.c(var31, var24, var32) >= 576.0D)) {
													if (var27 == null) {
														var27 = var1.a(var40, var30);
														if (var27 == null) {
															break;
														}
													}

													if (var1.a(var40, var27, var30) && a(class_rk.a(var27.b), var1, var30)) {
														class_rh var33;
														try {
															var33 = (class_rh) var27.b.getConstructor(new Class[] { class_ago.class }).newInstance(new Object[] { var1 });
														} catch (Exception var35) {
															var35.printStackTrace();
															return var36;
														}

														var33.b(var31, var24, var32, var1.s.nextFloat() * 360.0F, 0.0F);
														if (var33.cj() && var33.ck()) {
															var28 = var33.a(var1.E(new class_cj(var33)), var28);
															if (var33.ck()) {
																++var21;
																var1.a(var33);
															}

															if (var21 >= var33.cn()) {
																continue label129;
															}
														}

														var36 += var21;
													}
												}
											}
										}
									}
								}
							}
						}

						return var36;
					}

					var7 = (class_yu) var6.next();
				} while (var7.w());

				int var8 = class_oa.c(var7.s / 16.0D);
				var9 = class_oa.c(var7.u / 16.0D);
				byte var10 = 8;

				for (int var11 = -var10; var11 <= var10; ++var11) {
					for (var12 = -var10; var12 <= var10; ++var12) {
						boolean var13 = (var11 == -var10) || (var11 == var10) || (var12 == -var10) || (var12 == var10);
						class_agi var14 = new class_agi(var11 + var8, var12 + var9);
						if (!b.contains(var14)) {
							++var5;
							if (!var13 && var1.ah().a(var14)) {
								b.add(var14);
							}
						}
					}
				}
			}
		}
	}

	protected static class_cj a(class_ago var0, int var1, int var2) {
		class_aqn var3 = var0.a(var1, var2);
		int var4 = (var1 * 16) + var0.s.nextInt(16);
		int var5 = (var2 * 16) + var0.s.nextInt(16);
		int var6 = class_oa.c(var3.f(new class_cj(var4, 0, var5)) + 1, 16);
		int var7 = var0.s.nextInt(var6 > 0 ? var6 : (var3.g() + 16) - 1);
		return new class_cj(var4, var7, var5);
	}

	public static boolean a(class_rh.class_a_in_class_rh var0, class_ago var1, class_cj var2) {
		if (!var1.ah().a(var2)) {
			return false;
		} else {
			Block var3 = var1.p(var2).c();
			if (var0 == class_rh.class_a_in_class_rh.c) {
				return var3.v().d() && var1.p(var2.b()).c().v().d() && !var1.p(var2.a()).c().x();
			} else {
				class_cj var4 = var2.b();
				if (!class_ago.a(var1, var4)) {
					return false;
				} else {
					Block var5 = var1.p(var4).c();
					boolean var6 = (var5 != Blocks.BEDROCK) && (var5 != Blocks.cv);
					return var6 && !var3.x() && !var3.v().d() && !var1.p(var2.a()).c().x();
				}
			}
		}
	}

	public static void a(class_ago var0, class_ahb var1, int var2, int var3, int var4, int var5, Random var6) {
		List var7 = var1.a(class_ri.b);
		if (!var7.isEmpty()) {
			while (var6.nextFloat() < var1.g()) {
				class_ahb.class_c_in_class_ahb var8 = (class_ahb.class_c_in_class_ahb) class_oi.a(var0.s, var7);
				int var9 = var8.c + var6.nextInt((1 + var8.d) - var8.c);
				class_rj var10 = null;
				int var11 = var2 + var6.nextInt(var4);
				int var12 = var3 + var6.nextInt(var5);
				int var13 = var11;
				int var14 = var12;

				for (int var15 = 0; var15 < var9; ++var15) {
					boolean var16 = false;

					for (int var17 = 0; !var16 && (var17 < 4); ++var17) {
						class_cj var18 = var0.r(new class_cj(var11, 0, var12));
						if (a(class_rh.class_a_in_class_rh.a, var0, var18)) {
							class_rh var19;
							try {
								var19 = (class_rh) var8.b.getConstructor(new Class[] { class_ago.class }).newInstance(new Object[] { var0 });
							} catch (Exception var21) {
								var21.printStackTrace();
								continue;
							}

							var19.b(var11 + 0.5F, var18.o(), var12 + 0.5F, var6.nextFloat() * 360.0F, 0.0F);
							var0.a(var19);
							var10 = var19.a(var0.E(new class_cj(var19)), var10);
							var16 = true;
						}

						var11 += var6.nextInt(5) - var6.nextInt(5);

						for (var12 += var6.nextInt(5) - var6.nextInt(5); (var11 < var2) || (var11 >= (var2 + var4)) || (var12 < var3) || (var12 >= (var3 + var4)); var12 = (var14 + var6.nextInt(5)) - var6.nextInt(5)) {
							var11 = (var13 + var6.nextInt(5)) - var6.nextInt(5);
						}
					}
				}
			}

		}
	}
}
