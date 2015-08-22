package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_af extends class_i {
	@Override
	public String c() {
		return "fill";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(class_m var1) {
		return "commands.fill.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if (var2.length < 7) {
			throw new class_cf("commands.fill.usage", new Object[0]);
		} else {
			var1.a(class_n.class_a_in_class_n.b, 0);
			class_cj var3 = a(var1, var2, 0, false);
			class_cj var4 = a(var1, var2, 3, false);
			class_ail var5 = class_i.g(var1, var2[6]);
			int var6 = 0;
			if (var2.length >= 8) {
				var6 = a(var2[7], 0, 15);
			}

			class_cj var7 = new class_cj(Math.min(var3.n(), var4.n()), Math.min(var3.o(), var4.o()), Math.min(var3.p(), var4.p()));
			class_cj var8 = new class_cj(Math.max(var3.n(), var4.n()), Math.max(var3.o(), var4.o()), Math.max(var3.p(), var4.p()));
			int var9 = ((var8.n() - var7.n()) + 1) * ((var8.o() - var7.o()) + 1) * ((var8.p() - var7.p()) + 1);
			if (var9 > '耀') {
				throw new class_bz("commands.fill.tooManyBlocks", new Object[] { Integer.valueOf(var9), Integer.valueOf('耀') });
			} else if ((var7.o() >= 0) && (var8.o() < 256)) {
				class_ago var10 = var1.e();

				for (int var11 = var7.p(); var11 <= var8.p(); var11 += 16) {
					for (int var12 = var7.n(); var12 <= var8.n(); var12 += 16) {
						if (!var10.e(new class_cj(var12, var8.o() - var7.o(), var11))) {
							throw new class_bz("commands.fill.outOfWorld", new Object[0]);
						}
					}
				}

				class_dn var22 = new class_dn();
				boolean var23 = false;
				if ((var2.length >= 10) && var5.B()) {
					String var13 = a(var1, var2, 9).c();

					try {
						var22 = class_ed.a(var13);
						var23 = true;
					} catch (class_ec var21) {
						throw new class_bz("commands.fill.tagError", new Object[] { var21.getMessage() });
					}
				}

				ArrayList var24 = Lists.newArrayList();
				var9 = 0;

				for (int var14 = var7.p(); var14 <= var8.p(); ++var14) {
					for (int var15 = var7.o(); var15 <= var8.o(); ++var15) {
						for (int var16 = var7.n(); var16 <= var8.n(); ++var16) {
							class_cj var17 = new class_cj(var16, var15, var14);
							class_apn var19;
							if (var2.length >= 9) {
								if (!var2[8].equals("outline") && !var2[8].equals("hollow")) {
									if (var2[8].equals("destroy")) {
										var10.b(var17, true);
									} else if (var2[8].equals("keep")) {
										if (!var10.d(var17)) {
											continue;
										}
									} else if (var2[8].equals("replace") && !var5.B()) {
										if (var2.length > 9) {
											class_ail var18 = class_i.g(var1, var2[9]);
											if (var10.p(var17).c() != var18) {
												continue;
											}
										}

										if (var2.length > 10) {
											int var28 = class_i.a(var2[10]);
											var19 = var10.p(var17);
											if (var19.c().c(var19) != var28) {
												continue;
											}
										}
									}
								} else if ((var16 != var7.n()) && (var16 != var8.n()) && (var15 != var7.o()) && (var15 != var8.o()) && (var14 != var7.p()) && (var14 != var8.p())) {
									if (var2[8].equals("hollow")) {
										var10.a(var17, class_aim.a.S(), 2);
										var24.add(var17);
									}
									continue;
								}
							}

							class_aoi var29 = var10.s(var17);
							if (var29 != null) {
								if (var29 instanceof class_pp) {
									((class_pp) var29).l();
								}

								var10.a(var17, class_aim.cv.S(), var5 == class_aim.cv ? 2 : 4);
							}

							var19 = var5.a(var6);
							if (var10.a(var17, var19, 2)) {
								var24.add(var17);
								++var9;
								if (var23) {
									class_aoi var20 = var10.s(var17);
									if (var20 != null) {
										var22.a("x", var17.n());
										var22.a("y", var17.o());
										var22.a("z", var17.p());
										var20.a(var22);
									}
								}
							}
						}
					}
				}

				Iterator var25 = var24.iterator();

				while (var25.hasNext()) {
					class_cj var26 = (class_cj) var25.next();
					class_ail var27 = var10.p(var26).c();
					var10.c(var26, var27);
				}

				if (var9 <= 0) {
					throw new class_bz("commands.fill.failed", new Object[0]);
				} else {
					var1.a(class_n.class_a_in_class_n.b, var9);
					a(var1, this, "commands.fill.success", new Object[] { Integer.valueOf(var9) });
				}
			} else {
				throw new class_bz("commands.fill.outOfWorld", new Object[0]);
			}
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return (var2.length > 0) && (var2.length <= 3) ? a(var2, 0, var3) : ((var2.length > 3) && (var2.length <= 6) ? a(var2, 3, var3) : (var2.length == 7 ? a(var2, class_ail.c.c()) : (var2.length == 9 ? a(var2, new String[] { "replace", "destroy", "keep", "hollow", "outline" }) : ((var2.length == 10) && "replace".equals(var2[8]) ? a(var2, class_ail.c.c()) : null))));
	}
}
