package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class class_anf extends Block {
	public static final class_apz a;
	public static final class_aqa b;
	public static final class_aqa N;
	private static final int[][] O;
	private final Block P;
	private final class_apn Q;
	private boolean R;
	private int S;

	protected class_anf(class_apn var1) {
		super(var1.c().J);
		this.j(M.b().a(a, class_cq.c).a(b, class_anf.class_a_in_class_anf.b).a(N, class_anf.class_b_in_class_anf.a));
		P = var1.c();
		Q = var1;
		this.c(P.w);
		this.b(P.x / 3.0F);
		this.a(P.H);
		this.e(255);
		this.a(class_abp.b);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		if (R) {
			this.a(0.5F * (S % 2), 0.5F * ((S / 4) % 2), 0.5F * ((S / 2) % 2), 0.5F + (0.5F * (S % 2)), 0.5F + (0.5F * ((S / 4) % 2)), 0.5F + (0.5F * ((S / 2) % 2)));
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	public void e(class_ags var1, class_cj var2) {
		if (var1.p(var2).b(b) == class_anf.class_a_in_class_anf.a) {
			this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

	}

	public static boolean c(Block var0) {
		return var0 instanceof class_anf;
	}

	public static boolean a(class_ags var0, class_cj var1, class_apn var2) {
		class_apn var3 = var0.p(var1);
		Block var4 = var3.c();
		return c(var4) && (var3.b(b) == var2.b(b)) && (var3.b(a) == var2.b(a));
	}

	public int f(class_ags var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		class_cq var4 = (class_cq) var3.b(a);
		class_anf.class_a_in_class_anf var5 = (class_anf.class_a_in_class_anf) var3.b(b);
		boolean var6 = var5 == class_anf.class_a_in_class_anf.a;
		class_apn var7;
		Block var8;
		class_cq var9;
		if (var4 == class_cq.f) {
			var7 = var1.p(var2.f());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.c) && !a(var1, var2.d(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == class_cq.d) && !a(var1, var2.c(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		} else if (var4 == class_cq.e) {
			var7 = var1.p(var2.e());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.c) && !a(var1, var2.d(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == class_cq.d) && !a(var1, var2.c(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == class_cq.d) {
			var7 = var1.p(var2.d());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.e) && !a(var1, var2.f(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == class_cq.f) && !a(var1, var2.e(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == class_cq.c) {
			var7 = var1.p(var2.c());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.e) && !a(var1, var2.f(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == class_cq.f) && !a(var1, var2.e(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		}

		return 0;
	}

	public int g(class_ags var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		class_cq var4 = (class_cq) var3.b(a);
		class_anf.class_a_in_class_anf var5 = (class_anf.class_a_in_class_anf) var3.b(b);
		boolean var6 = var5 == class_anf.class_a_in_class_anf.a;
		class_apn var7;
		Block var8;
		class_cq var9;
		if (var4 == class_cq.f) {
			var7 = var1.p(var2.e());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.c) && !a(var1, var2.c(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == class_cq.d) && !a(var1, var2.d(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		} else if (var4 == class_cq.e) {
			var7 = var1.p(var2.f());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.c) && !a(var1, var2.c(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == class_cq.d) && !a(var1, var2.d(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == class_cq.d) {
			var7 = var1.p(var2.c());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.e) && !a(var1, var2.e(), var3)) {
					return var6 ? 2 : 1;
				}

				if ((var9 == class_cq.f) && !a(var1, var2.f(), var3)) {
					return var6 ? 1 : 2;
				}
			}
		} else if (var4 == class_cq.c) {
			var7 = var1.p(var2.d());
			var8 = var7.c();
			if (c(var8) && (var5 == var7.b(b))) {
				var9 = (class_cq) var7.b(a);
				if ((var9 == class_cq.e) && !a(var1, var2.e(), var3)) {
					return var6 ? 1 : 2;
				}

				if ((var9 == class_cq.f) && !a(var1, var2.f(), var3)) {
					return var6 ? 2 : 1;
				}
			}
		}

		return 0;
	}

	public boolean h(class_ags var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		class_cq var4 = (class_cq) var3.b(a);
		class_anf.class_a_in_class_anf var5 = (class_anf.class_a_in_class_anf) var3.b(b);
		boolean var6 = var5 == class_anf.class_a_in_class_anf.a;
		float var7 = 0.5F;
		float var8 = 1.0F;
		if (var6) {
			var7 = 0.0F;
			var8 = 0.5F;
		}

		float var9 = 0.0F;
		float var10 = 1.0F;
		float var11 = 0.0F;
		float var12 = 0.5F;
		boolean var13 = true;
		class_apn var14;
		Block var15;
		class_cq var16;
		if (var4 == class_cq.f) {
			var9 = 0.5F;
			var12 = 1.0F;
			var14 = var1.p(var2.f());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.c) && !a(var1, var2.d(), var3)) {
					var12 = 0.5F;
					var13 = false;
				} else if ((var16 == class_cq.d) && !a(var1, var2.c(), var3)) {
					var11 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == class_cq.e) {
			var10 = 0.5F;
			var12 = 1.0F;
			var14 = var1.p(var2.e());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.c) && !a(var1, var2.d(), var3)) {
					var12 = 0.5F;
					var13 = false;
				} else if ((var16 == class_cq.d) && !a(var1, var2.c(), var3)) {
					var11 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == class_cq.d) {
			var11 = 0.5F;
			var12 = 1.0F;
			var14 = var1.p(var2.d());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.e) && !a(var1, var2.f(), var3)) {
					var10 = 0.5F;
					var13 = false;
				} else if ((var16 == class_cq.f) && !a(var1, var2.e(), var3)) {
					var9 = 0.5F;
					var13 = false;
				}
			}
		} else if (var4 == class_cq.c) {
			var14 = var1.p(var2.c());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.e) && !a(var1, var2.f(), var3)) {
					var10 = 0.5F;
					var13 = false;
				} else if ((var16 == class_cq.f) && !a(var1, var2.e(), var3)) {
					var9 = 0.5F;
					var13 = false;
				}
			}
		}

		this.a(var9, var7, var11, var10, var8, var12);
		return var13;
	}

	public boolean i(class_ags var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		class_cq var4 = (class_cq) var3.b(a);
		class_anf.class_a_in_class_anf var5 = (class_anf.class_a_in_class_anf) var3.b(b);
		boolean var6 = var5 == class_anf.class_a_in_class_anf.a;
		float var7 = 0.5F;
		float var8 = 1.0F;
		if (var6) {
			var7 = 0.0F;
			var8 = 0.5F;
		}

		float var9 = 0.0F;
		float var10 = 0.5F;
		float var11 = 0.5F;
		float var12 = 1.0F;
		boolean var13 = false;
		class_apn var14;
		Block var15;
		class_cq var16;
		if (var4 == class_cq.f) {
			var14 = var1.p(var2.e());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.c) && !a(var1, var2.c(), var3)) {
					var11 = 0.0F;
					var12 = 0.5F;
					var13 = true;
				} else if ((var16 == class_cq.d) && !a(var1, var2.d(), var3)) {
					var11 = 0.5F;
					var12 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == class_cq.e) {
			var14 = var1.p(var2.f());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var9 = 0.5F;
				var10 = 1.0F;
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.c) && !a(var1, var2.c(), var3)) {
					var11 = 0.0F;
					var12 = 0.5F;
					var13 = true;
				} else if ((var16 == class_cq.d) && !a(var1, var2.d(), var3)) {
					var11 = 0.5F;
					var12 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == class_cq.d) {
			var14 = var1.p(var2.c());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var11 = 0.0F;
				var12 = 0.5F;
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.e) && !a(var1, var2.e(), var3)) {
					var13 = true;
				} else if ((var16 == class_cq.f) && !a(var1, var2.f(), var3)) {
					var9 = 0.5F;
					var10 = 1.0F;
					var13 = true;
				}
			}
		} else if (var4 == class_cq.c) {
			var14 = var1.p(var2.d());
			var15 = var14.c();
			if (c(var15) && (var5 == var14.b(b))) {
				var16 = (class_cq) var14.b(a);
				if ((var16 == class_cq.e) && !a(var1, var2.e(), var3)) {
					var13 = true;
				} else if ((var16 == class_cq.f) && !a(var1, var2.f(), var3)) {
					var9 = 0.5F;
					var10 = 1.0F;
					var13 = true;
				}
			}
		}

		if (var13) {
			this.a(var9, var7, var11, var10, var8, var12);
		}

		return var13;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, Entity var6) {
		this.e(var1, var2);
		super.a(var1, var2, var3, var4, var5, var6);
		boolean var7 = h(var1, var2);
		super.a(var1, var2, var3, var4, var5, var6);
		if (var7 && this.i((class_ags) var1, var2)) {
			super.a(var1, var2, var3, var4, var5, var6);
		}

		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_yu var3) {
		P.a(var1, var2, var3);
	}

	@Override
	public void e(class_ago var1, class_cj var2, class_apn var3) {
		P.e(var1, var2, var3);
	}

	@Override
	public float a(Entity var1) {
		return P.a(var1);
	}

	@Override
	public int a(class_ago var1) {
		return P.a(var1);
	}

	@Override
	public class_aym a(class_ago var1, class_cj var2, Entity var3, class_aym var4) {
		return P.a(var1, var2, var3, var4);
	}

	@Override
	public boolean C() {
		return P.C();
	}

	@Override
	public boolean a(class_apn var1, boolean var2) {
		return P.a(var1, var2);
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return P.c(var1, var2);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.a(var1, var2, Q, Blocks.AIR);
		P.d(var1, var2, Q);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		P.c(var1, var2, Q);
	}

	@Override
	public void a(class_ago var1, class_cj var2, Entity var3) {
		P.a(var1, var2, var3);
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		P.b(var1, var2, var3, var4);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		return P.a(var1, var2, Q, var4, var5, var6, class_cq.a, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_agk var3) {
		P.a(var1, var2, var3);
	}

	@Override
	public class_avr g(class_apn var1) {
		return P.g(Q);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		class_apn var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8);
		var9 = var9.a(a, var8.aV()).a(N, class_anf.class_b_in_class_anf.a);
		return (var3 != class_cq.a) && ((var3 == class_cq.b) || (var5 <= 0.5D)) ? var9.a(b, class_anf.class_a_in_class_anf.b) : var9.a(b, class_anf.class_a_in_class_anf.a);
	}

	@Override
	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		class_ayl[] var5 = new class_ayl[8];
		class_apn var6 = var1.p(var2);
		int var7 = ((class_cq) var6.b(a)).b();
		boolean var8 = var6.b(b) == class_anf.class_a_in_class_anf.a;
		int[] var9 = O[var7 + (var8 ? 4 : 0)];
		R = true;

		for (int var10 = 0; var10 < 8; ++var10) {
			S = var10;
			if (Arrays.binarySearch(var9, var10) < 0) {
				var5[var10] = super.a(var1, var2, var3, var4);
			}
		}

		int[] var19 = var9;
		int var11 = var9.length;

		for (int var12 = 0; var12 < var11; ++var12) {
			int var13 = var19[var12];
			var5[var13] = null;
		}

		class_ayl var20 = null;
		double var21 = 0.0D;
		class_ayl[] var22 = var5;
		int var14 = var5.length;

		for (int var15 = 0; var15 < var14; ++var15) {
			class_ayl var16 = var22[var15];
			if (var16 != null) {
				double var17 = var16.c.g(var4);
				if (var17 > var21) {
					var20 = var16;
					var21 = var17;
				}
			}
		}

		return var20;
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = S().a(b, (var1 & 4) > 0 ? class_anf.class_a_in_class_anf.a : class_anf.class_a_in_class_anf.b);
		var2 = var2.a(a, class_cq.a(5 - (var1 & 3)));
		return var2;
	}

	@Override
	public int c(class_apn var1) {
		int var2 = 0;
		if (var1.b(b) == class_anf.class_a_in_class_anf.a) {
			var2 |= 4;
		}

		var2 |= 5 - ((class_cq) var1.b(a)).a();
		return var2;
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		if (h(var2, var3)) {
			switch (this.g(var2, var3)) {
				case 0:
					var1 = var1.a(N, class_anf.class_b_in_class_anf.a);
					break;
				case 1:
					var1 = var1.a(N, class_anf.class_b_in_class_anf.c);
					break;
				case 2:
					var1 = var1.a(N, class_anf.class_b_in_class_anf.b);
			}
		} else {
			switch (this.f(var2, var3)) {
				case 0:
					var1 = var1.a(N, class_anf.class_b_in_class_anf.a);
					break;
				case 1:
					var1 = var1.a(N, class_anf.class_b_in_class_anf.e);
					break;
				case 2:
					var1 = var1.a(N, class_anf.class_b_in_class_anf.d);
			}
		}

		return var1;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			class_cq var3 = (class_cq) var1.b(a);
			class_anf.class_b_in_class_anf var4 = (class_anf.class_b_in_class_anf) var1.b(N);
			switch (class_anf.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					if (var3.k() == class_cq.class_a_in_class_cq.c) {
						switch (class_anf.SyntheticClass_1.a[var4.ordinal()]) {
							case 1:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.c);
							case 2:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.b);
							case 3:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.e);
							case 4:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.d);
							default:
								return this.a(var1, Block.class_c_in_class_ail.c);
						}
					}
					break;
				case 2:
					if (var3.k() == class_cq.class_a_in_class_cq.a) {
						switch (class_anf.SyntheticClass_1.a[var4.ordinal()]) {
							case 1:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.b);
							case 2:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.c);
							case 3:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.e);
							case 4:
								return this.a(var1, Block.class_c_in_class_ail.c).a(N, class_anf.class_b_in_class_anf.d);
							case 5:
								return this.a(var1, Block.class_c_in_class_ail.c);
						}
					}
			}

			return super.a(var1, var2);
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N });
	}

	static {
		a = class_akx.O;
		b = class_aqa.a("half", class_anf.class_a_in_class_anf.class);
		N = class_aqa.a("shape", class_anf.class_b_in_class_anf.class);
		O = new int[][] { { 4, 5 }, { 5, 7 }, { 6, 7 }, { 4, 6 }, { 0, 1 }, { 1, 3 }, { 2, 3 }, { 0, 2 } };
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_a_in_class_ail.values().length];

		static {
			try {
				b[Block.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				b[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var6) {
				;
			}

			a = new int[class_anf.class_b_in_class_anf.values().length];

			try {
				a[class_anf.class_b_in_class_anf.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_anf.class_b_in_class_anf.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_anf.class_b_in_class_anf.d.ordinal()] = 3;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_anf.class_b_in_class_anf.e.ordinal()] = 4;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_anf.class_b_in_class_anf.a.ordinal()] = 5;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_b_in_class_anf implements class_oe {
		a("straight"),
		b("inner_left"),
		c("inner_right"),
		d("outer_left"),
		e("outer_right");

		private final String f;

		private class_b_in_class_anf(String var3) {
			f = var3;
		}

		@Override
		public String toString() {
			return f;
		}

		@Override
		public String l() {
			return f;
		}
	}

	public static enum class_a_in_class_anf implements class_oe {
		a("top"),
		b("bottom");

		private final String c;

		private class_a_in_class_anf(String var3) {
			c = var3;
		}

		@Override
		public String toString() {
			return c;
		}

		@Override
		public String l() {
			return c;
		}
	}
}
