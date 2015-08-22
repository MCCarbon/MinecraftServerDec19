package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_anw extends Block {
	public static final class_apy a = class_apy.a("up");
	public static final class_apy b = class_apy.a("north");
	public static final class_apy N = class_apy.a("east");
	public static final class_apy O = class_apy.a("south");
	public static final class_apy P = class_apy.a("west");
	public static final class_apy[] Q;

	public class_anw() {
		super(class_avq.l);
		this.j(M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)));
		this.a(true);
		this.a(class_abp.c);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return var1.a(a, Boolean.valueOf(var2.p(var3.a()).c().w()));
	}

	@Override
	public void j() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean a(class_ago var1, class_cj var2) {
		return true;
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		float var3 = 0.0625F;
		float var4 = 1.0F;
		float var5 = 1.0F;
		float var6 = 1.0F;
		float var7 = 0.0F;
		float var8 = 0.0F;
		float var9 = 0.0F;
		boolean var10 = false;
		class_apn var11 = var1.p(var2);
		if (((Boolean) var11.b(P)).booleanValue()) {
			var7 = Math.max(var7, 0.0625F);
			var4 = 0.0F;
			var5 = 0.0F;
			var8 = 1.0F;
			var6 = 0.0F;
			var9 = 1.0F;
			var10 = true;
		}

		if (((Boolean) var11.b(N)).booleanValue()) {
			var4 = Math.min(var4, 0.9375F);
			var7 = 1.0F;
			var5 = 0.0F;
			var8 = 1.0F;
			var6 = 0.0F;
			var9 = 1.0F;
			var10 = true;
		}

		if (((Boolean) var11.b(b)).booleanValue()) {
			var9 = Math.max(var9, 0.0625F);
			var6 = 0.0F;
			var4 = 0.0F;
			var7 = 1.0F;
			var5 = 0.0F;
			var8 = 1.0F;
			var10 = true;
		}

		if (((Boolean) var11.b(O)).booleanValue()) {
			var6 = Math.min(var6, 0.9375F);
			var9 = 1.0F;
			var4 = 0.0F;
			var7 = 1.0F;
			var5 = 0.0F;
			var8 = 1.0F;
			var10 = true;
		}

		if (!var10 && this.c(var1.p(var2.a()).c())) {
			var5 = Math.min(var5, 0.9375F);
			var8 = 1.0F;
			var4 = 0.0F;
			var7 = 1.0F;
			var6 = 0.0F;
			var9 = 1.0F;
		}

		this.a(var4, var5, var6, var7, var8, var9);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean b(class_ago var1, class_cj var2, class_cq var3) {
		switch (class_anw.SyntheticClass_1.a[var3.ordinal()]) {
			case 1:
				return this.c(var1.p(var2.a()).c());
			case 2:
			case 3:
			case 4:
			case 5:
				return this.c(var1.p(var2.a(var3.d())).c());
			default:
				return false;
		}
	}

	private boolean c(Block var1) {
		return var1.d() && var1.J.c();
	}

	private boolean f(class_ago var1, class_cj var2, class_apn var3) {
		class_apn var4 = var3;
		Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

		while (true) {
			class_apy var7;
			class_apn var8;
			do {
				class_cq var6;
				do {
					do {
						if (!var5.hasNext()) {
							if (d(var3) == 0) {
								return false;
							}

							if (var4 != var3) {
								var1.a(var2, var3, 2);
							}

							return true;
						}

						var6 = (class_cq) var5.next();
						var7 = a(var6);
					} while (!((Boolean) var3.b(var7)).booleanValue());
				} while (this.c(var1.p(var2.a(var6)).c()));

				var8 = var1.p(var2.a());
			} while ((var8.c() == this) && ((Boolean) var8.b(var7)).booleanValue());

			var3 = var3.a(var7, Boolean.valueOf(false));
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D && !this.f(var1, var2, var3)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			if (var1.s.nextInt(4) == 0) {
				byte var5 = 4;
				int var6 = 5;
				boolean var7 = false;

				label191: for (int var8 = -var5; var8 <= var5; ++var8) {
					for (int var9 = -var5; var9 <= var5; ++var9) {
						for (int var10 = -1; var10 <= 1; ++var10) {
							if (var1.p(var2.a(var8, var10, var9)).c() == this) {
								--var6;
								if (var6 <= 0) {
									var7 = true;
									break label191;
								}
							}
						}
					}
				}

				class_cq var18 = class_cq.a(var4);
				class_cj var19 = var2.a();
				class_cq var24;
				if ((var18 == class_cq.b) && (var2.o() < 255) && var1.d(var19)) {
					if (!var7) {
						class_apn var21 = var3;
						Iterator var23 = class_cq.class_c_in_class_cq.a.iterator();

						while (true) {
							do {
								if (!var23.hasNext()) {
									if (((Boolean) var21.b(b)).booleanValue() || ((Boolean) var21.b(N)).booleanValue() || ((Boolean) var21.b(O)).booleanValue() || ((Boolean) var21.b(P)).booleanValue()) {
										var1.a(var19, var21, 2);
									}

									return;
								}

								var24 = (class_cq) var23.next();
							} while (!var4.nextBoolean() && this.c(var1.p(var19.a(var24)).c()));

							var21 = var21.a(a(var24), Boolean.valueOf(false));
						}
					}
				} else {
					class_cj var20;
					if (var18.k().c() && !((Boolean) var3.b(a(var18))).booleanValue()) {
						if (!var7) {
							var20 = var2.a(var18);
							Block var22 = var1.p(var20).c();
							if (var22.J == class_avq.a) {
								var24 = var18.e();
								class_cq var25 = var18.f();
								boolean var26 = ((Boolean) var3.b(a(var24))).booleanValue();
								boolean var27 = ((Boolean) var3.b(a(var25))).booleanValue();
								class_cj var28 = var20.a(var24);
								class_cj var17 = var20.a(var25);
								if (var26 && this.c(var1.p(var28).c())) {
									var1.a(var20, S().a(a(var24), Boolean.valueOf(true)), 2);
								} else if (var27 && this.c(var1.p(var17).c())) {
									var1.a(var20, S().a(a(var25), Boolean.valueOf(true)), 2);
								} else if (var26 && var1.d(var28) && this.c(var1.p(var2.a(var24)).c())) {
									var1.a(var28, S().a(a(var18.d()), Boolean.valueOf(true)), 2);
								} else if (var27 && var1.d(var17) && this.c(var1.p(var2.a(var25)).c())) {
									var1.a(var17, S().a(a(var18.d()), Boolean.valueOf(true)), 2);
								} else if (this.c(var1.p(var20.a()).c())) {
									var1.a(var20, S(), 2);
								}
							} else if (var22.J.k() && var22.d()) {
								var1.a(var2, var3.a(a(var18), Boolean.valueOf(true)), 2);
							}

						}
					} else {
						if (var2.o() > 1) {
							var20 = var2.b();
							class_apn var11 = var1.p(var20);
							Block var12 = var11.c();
							class_apn var13;
							Iterator var14;
							class_cq var15;
							if (var12.J == class_avq.a) {
								var13 = var3;
								var14 = class_cq.class_c_in_class_cq.a.iterator();

								while (var14.hasNext()) {
									var15 = (class_cq) var14.next();
									if (var4.nextBoolean()) {
										var13 = var13.a(a(var15), Boolean.valueOf(false));
									}
								}

								if (((Boolean) var13.b(b)).booleanValue() || ((Boolean) var13.b(N)).booleanValue() || ((Boolean) var13.b(O)).booleanValue() || ((Boolean) var13.b(P)).booleanValue()) {
									var1.a(var20, var13, 2);
								}
							} else if (var12 == this) {
								var13 = var11;
								var14 = class_cq.class_c_in_class_cq.a.iterator();

								while (var14.hasNext()) {
									var15 = (class_cq) var14.next();
									class_apy var16 = a(var15);
									if (var4.nextBoolean() && ((Boolean) var3.b(var16)).booleanValue()) {
										var13 = var13.a(var16, Boolean.valueOf(true));
									}
								}

								if (((Boolean) var13.b(b)).booleanValue() || ((Boolean) var13.b(N)).booleanValue() || ((Boolean) var13.b(O)).booleanValue() || ((Boolean) var13.b(P)).booleanValue()) {
									var1.a(var20, var13, 2);
								}
							}
						}

					}
				}
			}
		}
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		class_apn var9 = S().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false));
		return var3.k().c() ? var9.a(a(var3.d()), Boolean.valueOf(true)) : var9;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, TileEntity var5, class_aco var6) {
		if (!var1.D && (var6 != null) && (var6.b() == Items.bg)) {
			var2.b(class_nh.a(Block.a(this)));
			a(var1, var3, (new class_aco(Blocks.bn, 1, 0)));
		} else {
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	@Override
	public class_apn a(int var1) {
		return S().a(O, Boolean.valueOf((var1 & 1) > 0)).a(P, Boolean.valueOf((var1 & 2) > 0)).a(b, Boolean.valueOf((var1 & 4) > 0)).a(N, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		int var2 = 0;
		if (((Boolean) var1.b(O)).booleanValue()) {
			var2 |= 1;
		}

		if (((Boolean) var1.b(P)).booleanValue()) {
			var2 |= 2;
		}

		if (((Boolean) var1.b(b)).booleanValue()) {
			var2 |= 4;
		}

		if (((Boolean) var1.b(N)).booleanValue()) {
			var2 |= 8;
		}

		return var2;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N, O, P });
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_anw.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					return var1.a(b, var1.b(O)).a(N, var1.b(P)).a(O, var1.b(b)).a(P, var1.b(N));
				case 2:
					return var1.a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(P)).a(P, var1.b(b));
				case 3:
					return var1.a(b, var1.b(P)).a(N, var1.b(b)).a(O, var1.b(N)).a(P, var1.b(O));
				default:
					return var1;
			}
		}
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_anw.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
					return var1.a(b, var1.b(O)).a(O, var1.b(b));
				case 2:
					return var1.a(N, var1.b(P)).a(P, var1.b(N));
				default:
					return super.a(var1, var2);
			}
		}
	}

	public static class_apy a(class_cq var0) {
		switch (class_anw.SyntheticClass_1.a[var0.ordinal()]) {
			case 1:
				return a;
			case 2:
				return b;
			case 3:
				return O;
			case 4:
				return N;
			case 5:
				return P;
			default:
				throw new IllegalArgumentException(var0 + " is an invalid choice");
		}
	}

	public static int d(class_apn var0) {
		int var1 = 0;
		class_apy[] var2 = Q;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_apy var5 = var2[var4];
			if (((Boolean) var0.b(var5)).booleanValue()) {
				++var1;
			}
		}

		return var1;
	}

	static {
		Q = new class_apy[] { a, b, O, P, N };
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[Block.class_a_in_class_ail.values().length];

		static {
			try {
				c[Block.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				c[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
				;
			}

			b = new int[Block.class_c_in_class_ail.values().length];

			try {
				b[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var6) {
				;
			}

			a = new int[class_cq.values().length];

			try {
				a[class_cq.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 3;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 4;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 5;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
