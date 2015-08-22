package net.minecraft.server;

import java.util.List;

public class class_akb extends Block {
	public static final class_apy a = class_apy.a("north");
	public static final class_apy b = class_apy.a("east");
	public static final class_apy N = class_apy.a("south");
	public static final class_apy O = class_apy.a("west");

	public class_akb(class_avq var1) {
		this(var1, var1.r());
	}

	public class_akb(class_avq var1, class_avr var2) {
		super(var1, var2);
		this.j(M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)));
		this.a(class_abp.c);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, Entity var6) {
		boolean var7 = this.e(var1, var2.c());
		boolean var8 = this.e(var1, var2.d());
		boolean var9 = this.e(var1, var2.e());
		boolean var10 = this.e(var1, var2.f());
		float var11 = 0.375F;
		float var12 = 0.625F;
		float var13 = 0.375F;
		float var14 = 0.625F;
		if (var7) {
			var13 = 0.0F;
		}

		if (var8) {
			var14 = 1.0F;
		}

		if (var7 || var8) {
			this.a(var11, 0.0F, var13, var12, 1.5F, var14);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		var13 = 0.375F;
		var14 = 0.625F;
		if (var9) {
			var11 = 0.0F;
		}

		if (var10) {
			var12 = 1.0F;
		}

		if (var9 || var10 || (!var7 && !var8)) {
			this.a(var11, 0.0F, var13, var12, 1.5F, var14);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (var7) {
			var13 = 0.0F;
		}

		if (var8) {
			var14 = 1.0F;
		}

		this.a(var11, 0.0F, var13, var12, 1.0F, var14);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		boolean var3 = this.e(var1, var2.c());
		boolean var4 = this.e(var1, var2.d());
		boolean var5 = this.e(var1, var2.e());
		boolean var6 = this.e(var1, var2.f());
		float var7 = 0.375F;
		float var8 = 0.625F;
		float var9 = 0.375F;
		float var10 = 0.625F;
		if (var3) {
			var9 = 0.0F;
		}

		if (var4) {
			var10 = 1.0F;
		}

		if (var5) {
			var7 = 0.0F;
		}

		if (var6) {
			var8 = 1.0F;
		}

		this.a(var7, 0.0F, var9, var8, 1.0F, var10);
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
	public boolean b(class_ags var1, class_cj var2) {
		return false;
	}

	public boolean e(class_ags var1, class_cj var2) {
		Block var3 = var1.p(var2).c();
		return var3 == Blocks.cv ? false : ((!(var3 instanceof class_akb) || (var3.J != J)) && !(var3 instanceof class_akc) ? (var3.J.k() && var3.d() ? var3.J != class_avq.C : false) : true);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		return var1.D ? true : class_acr.a(var4, var1, var2);
	}

	@Override
	public int c(class_apn var1) {
		return 0;
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return var1.a(a, Boolean.valueOf(this.e(var2, var3.c()))).a(b, Boolean.valueOf(this.e(var2, var3.f()))).a(N, Boolean.valueOf(this.e(var2, var3.d()))).a(O, Boolean.valueOf(this.e(var2, var3.e())));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_akb.SyntheticClass_1.a[var2.ordinal()]) {
				case 1:
					return var1.a(a, var1.b(N)).a(b, var1.b(O)).a(N, var1.b(a)).a(O, var1.b(b));
				case 2:
					return var1.a(a, var1.b(b)).a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(a));
				case 3:
					return var1.a(a, var1.b(O)).a(b, var1.b(a)).a(N, var1.b(b)).a(O, var1.b(N));
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
			switch (class_akb.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					return var1.a(a, var1.b(N)).a(N, var1.b(a));
				case 2:
					return var1.a(b, var1.b(O)).a(O, var1.b(b));
				default:
					return super.a(var1, var2);
			}
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, O, N });
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
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[Block.class_c_in_class_ail.values().length];

			try {
				a[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
