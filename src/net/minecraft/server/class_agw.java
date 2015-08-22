package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_agw {
	private final class_ll a;
	private final Random b;
	private final class_ny c = new class_ny();
	private final List d = Lists.newArrayList();

	public class_agw(class_ll var1) {
		a = var1;
		b = new Random(var1.L());
	}

	public void a(Entity var1, float var2) {
		if (a.t.p().a() != 1) {
			if (!b(var1, var2)) {
				this.a(var1);
				b(var1, var2);
			}
		} else {
			int var3 = class_oa.c(var1.s);
			int var4 = class_oa.c(var1.t) - 1;
			int var5 = class_oa.c(var1.u);
			byte var6 = 1;
			byte var7 = 0;

			for (int var8 = -2; var8 <= 2; ++var8) {
				for (int var9 = -2; var9 <= 2; ++var9) {
					for (int var10 = -1; var10 < 3; ++var10) {
						int var11 = var3 + (var9 * var6) + (var8 * var7);
						int var12 = var4 + var10;
						int var13 = (var5 + (var9 * var7)) - (var8 * var6);
						boolean var14 = var10 < 0;
						a.a((new class_cj(var11, var12, var13)), var14 ? Blocks.Z.S() : Blocks.a.S());
					}
				}
			}

			var1.b(var3, var4, var5, var1.y, 0.0F);
			var1.v = var1.w = var1.x = 0.0D;
		}
	}

	public boolean b(Entity var1, float var2) {
		boolean var3 = true;
		double var4 = -1.0D;
		int var6 = class_oa.c(var1.s);
		int var7 = class_oa.c(var1.u);
		boolean var8 = true;
		Object var9 = class_cj.a;
		long var10 = class_agi.a(var6, var7);
		if (c.b(var10)) {
			class_agw.class_a_in_class_agw var12 = (class_agw.class_a_in_class_agw) c.a(var10);
			var4 = 0.0D;
			var9 = var12;
			var12.c = a.M();
			var8 = false;
		} else {
			class_cj var30 = new class_cj(var1);

			for (int var13 = -128; var13 <= 128; ++var13) {
				class_cj var16;
				for (int var14 = -128; var14 <= 128; ++var14) {
					for (class_cj var15 = var30.a(var13, a.X() - 1 - var30.o(), var14); var15.o() >= 0; var15 = var16) {
						var16 = var15.b();
						if (a.p(var15).c() == Blocks.aY) {
							while (a.p(var16 = var15.b()).c() == Blocks.aY) {
								var15 = var16;
							}

							double var17 = var15.i(var30);
							if ((var4 < 0.0D) || (var17 < var4)) {
								var4 = var17;
								var9 = var15;
							}
						}
					}
				}
			}
		}

		if (var4 >= 0.0D) {
			if (var8) {
				c.a(var10, new class_agw.class_a_in_class_agw((class_cj) var9, a.M()));
				d.add(Long.valueOf(var10));
			}

			double var31 = ((class_cj) var9).n() + 0.5D;
			double var32 = ((class_cj) var9).o() + 0.5D;
			double var33 = ((class_cj) var9).p() + 0.5D;
			class_apr.class_b_in_class_apr var18 = Blocks.aY.e(a, (class_cj) var9);
			boolean var19 = var18.b().e().c() == class_cq.class_b_in_class_cq.b;
			double var20 = var18.b().k() == class_cq.class_a_in_class_cq.a ? (double) var18.a().p() : (double) var18.a().n();
			var32 = (var18.a().o() + 1) - (var1.aM().b * var18.e());
			if (var19) {
				++var20;
			}

			if (var18.b().k() == class_cq.class_a_in_class_cq.a) {
				var33 = var20 + ((1.0D - var1.aM().a) * var18.d() * var18.b().e().c().a());
			} else {
				var31 = var20 + ((1.0D - var1.aM().a) * var18.d() * var18.b().e().c().a());
			}

			float var22 = 0.0F;
			float var23 = 0.0F;
			float var24 = 0.0F;
			float var25 = 0.0F;
			if (var18.b().d() == var1.aN()) {
				var22 = 1.0F;
				var23 = 1.0F;
			} else if (var18.b().d() == var1.aN().d()) {
				var22 = -1.0F;
				var23 = -1.0F;
			} else if (var18.b().d() == var1.aN().e()) {
				var24 = 1.0F;
				var25 = -1.0F;
			} else {
				var24 = -1.0F;
				var25 = 1.0F;
			}

			double var26 = var1.v;
			double var28 = var1.x;
			var1.v = (var26 * var22) + (var28 * var25);
			var1.x = (var26 * var24) + (var28 * var23);
			var1.y = (var2 - (var1.aN().d().b() * 90)) + (var18.b().b() * 90);
			var1.b(var31, var32, var33, var1.y, var1.z);
			return true;
		} else {
			return false;
		}
	}

	public boolean a(Entity var1) {
		byte var2 = 16;
		double var3 = -1.0D;
		int var5 = class_oa.c(var1.s);
		int var6 = class_oa.c(var1.t);
		int var7 = class_oa.c(var1.u);
		int var8 = var5;
		int var9 = var6;
		int var10 = var7;
		int var11 = 0;
		int var12 = b.nextInt(4);
		class_cj.class_a_in_class_cj var13 = new class_cj.class_a_in_class_cj();

		int var14;
		double var15;
		int var17;
		double var18;
		int var20;
		int var21;
		int var22;
		int var23;
		int var24;
		int var25;
		int var26;
		int var27;
		int var28;
		double var33;
		double var34;
		for (var14 = var5 - var2; var14 <= (var5 + var2); ++var14) {
			var15 = (var14 + 0.5D) - var1.s;

			for (var17 = var7 - var2; var17 <= (var7 + var2); ++var17) {
				var18 = (var17 + 0.5D) - var1.u;

				label293: for (var20 = a.X() - 1; var20 >= 0; --var20) {
					if (a.d(var13.c(var14, var20, var17))) {
						while ((var20 > 0) && a.d(var13.c(var14, var20 - 1, var17))) {
							--var20;
						}

						for (var21 = var12; var21 < (var12 + 4); ++var21) {
							var22 = var21 % 2;
							var23 = 1 - var22;
							if ((var21 % 4) >= 2) {
								var22 = -var22;
								var23 = -var23;
							}

							for (var24 = 0; var24 < 3; ++var24) {
								for (var25 = 0; var25 < 4; ++var25) {
									for (var26 = -1; var26 < 4; ++var26) {
										var27 = var14 + ((var25 - 1) * var22) + (var24 * var23);
										var28 = var20 + var26;
										int var29 = (var17 + ((var25 - 1) * var23)) - (var24 * var22);
										var13.c(var27, var28, var29);
										if (((var26 < 0) && !a.p(var13).c().v().a()) || ((var26 >= 0) && !a.d(var13))) {
											continue label293;
										}
									}
								}
							}

							var33 = (var20 + 0.5D) - var1.t;
							var34 = (var15 * var15) + (var33 * var33) + (var18 * var18);
							if ((var3 < 0.0D) || (var34 < var3)) {
								var3 = var34;
								var8 = var14;
								var9 = var20;
								var10 = var17;
								var11 = var21 % 4;
							}
						}
					}
				}
			}
		}

		if (var3 < 0.0D) {
			for (var14 = var5 - var2; var14 <= (var5 + var2); ++var14) {
				var15 = (var14 + 0.5D) - var1.s;

				for (var17 = var7 - var2; var17 <= (var7 + var2); ++var17) {
					var18 = (var17 + 0.5D) - var1.u;

					label231: for (var20 = a.X() - 1; var20 >= 0; --var20) {
						if (a.d(var13.c(var14, var20, var17))) {
							while ((var20 > 0) && a.d(var13.c(var14, var20 - 1, var17))) {
								--var20;
							}

							for (var21 = var12; var21 < (var12 + 2); ++var21) {
								var22 = var21 % 2;
								var23 = 1 - var22;

								for (var24 = 0; var24 < 4; ++var24) {
									for (var25 = -1; var25 < 4; ++var25) {
										var26 = var14 + ((var24 - 1) * var22);
										var27 = var20 + var25;
										var28 = var17 + ((var24 - 1) * var23);
										var13.c(var26, var27, var28);
										if (((var25 < 0) && !a.p(var13).c().v().a()) || ((var25 >= 0) && !a.d(var13))) {
											continue label231;
										}
									}
								}

								var33 = (var20 + 0.5D) - var1.t;
								var34 = (var15 * var15) + (var33 * var33) + (var18 * var18);
								if ((var3 < 0.0D) || (var34 < var3)) {
									var3 = var34;
									var8 = var14;
									var9 = var20;
									var10 = var17;
									var11 = var21 % 2;
								}
							}
						}
					}
				}
			}
		}

		int var30 = var8;
		int var16 = var9;
		var17 = var10;
		int var31 = var11 % 2;
		int var19 = 1 - var31;
		if ((var11 % 4) >= 2) {
			var31 = -var31;
			var19 = -var19;
		}

		if (var3 < 0.0D) {
			var9 = class_oa.a(var9, 70, a.X() - 10);
			var16 = var9;

			for (var20 = -1; var20 <= 1; ++var20) {
				for (var21 = 1; var21 < 3; ++var21) {
					for (var22 = -1; var22 < 3; ++var22) {
						var23 = var30 + ((var21 - 1) * var31) + (var20 * var19);
						var24 = var16 + var22;
						var25 = (var17 + ((var21 - 1) * var19)) - (var20 * var31);
						boolean var35 = var22 < 0;
						a.a((new class_cj(var23, var24, var25)), var35 ? Blocks.Z.S() : Blocks.a.S());
					}
				}
			}
		}

		class_apn var32 = Blocks.aY.S().a(class_alz.a, var31 != 0 ? class_cq.class_a_in_class_cq.a : class_cq.class_a_in_class_cq.c);

		for (var21 = 0; var21 < 4; ++var21) {
			for (var22 = 0; var22 < 4; ++var22) {
				for (var23 = -1; var23 < 4; ++var23) {
					var24 = var30 + ((var22 - 1) * var31);
					var25 = var16 + var23;
					var26 = var17 + ((var22 - 1) * var19);
					boolean var36 = (var22 == 0) || (var22 == 3) || (var23 == -1) || (var23 == 3);
					a.a(new class_cj(var24, var25, var26), var36 ? Blocks.Z.S() : var32, 2);
				}
			}

			for (var22 = 0; var22 < 4; ++var22) {
				for (var23 = -1; var23 < 4; ++var23) {
					var24 = var30 + ((var22 - 1) * var31);
					var25 = var16 + var23;
					var26 = var17 + ((var22 - 1) * var19);
					class_cj var37 = new class_cj(var24, var25, var26);
					a.d(var37, a.p(var37).c());
				}
			}
		}

		return true;
	}

	public void a(long var1) {
		if ((var1 % 100L) == 0L) {
			Iterator var3 = d.iterator();
			long var4 = var1 - 300L;

			while (true) {
				Long var6;
				class_agw.class_a_in_class_agw var7;
				do {
					if (!var3.hasNext()) {
						return;
					}

					var6 = (Long) var3.next();
					var7 = (class_agw.class_a_in_class_agw) c.a(var6.longValue());
				} while ((var7 != null) && (var7.c >= var4));

				var3.remove();
				c.d(var6.longValue());
			}
		}
	}

	public class class_a_in_class_agw extends class_cj {
		public long c;

		public class_a_in_class_agw(class_cj var2, long var3) {
			super(var2.n(), var2.o(), var2.p());
			c = var3;
		}
	}
}
