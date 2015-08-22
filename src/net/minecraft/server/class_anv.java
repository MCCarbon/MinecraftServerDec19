package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

import com.google.common.base.Objects;

public class class_anv extends Block {
	public static final class_apz a;
	public static final class_apy b;
	public static final class_apy N;
	public static final class_apy O;

	public class_anv() {
		super(class_avq.q);
		this.j(M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)));
		this.a(class_abp.d);
		this.a(true);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return var1.a(O, Boolean.valueOf(!class_ago.a(var2, var3.b())));
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
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
	public boolean b(class_ago var1, class_cj var2, class_cq var3) {
		return var3.k().c() && var1.p(var2.a(var3.d())).c().x();
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

		class_cq var4;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			var4 = (class_cq) var3.next();
		} while (!var1.p(var2.a(var4)).c().x());

		return true;
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		class_apn var9 = S().a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false));
		if (var3.k().c()) {
			var9 = var9.a(a, var3);
		}

		return var9;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		this.a(var1, var2, var3, false, false, -1, (class_apn) null);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (var4 != this) {
			if (this.f(var1, var2, var3)) {
				class_cq var5 = (class_cq) var3.b(a);
				if (!var1.p(var2.a(var5.d())).c().x()) {
					this.b(var1, var2, var3, 0);
					var1.g(var2);
				}
			}

		}
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, boolean var4, boolean var5, int var6, class_apn var7) {
		class_cq var8 = (class_cq) var3.b(a);
		boolean var9 = ((Boolean) var3.b(N)).booleanValue();
		boolean var10 = ((Boolean) var3.b(b)).booleanValue();
		boolean var11 = !class_ago.a(var1, var2.b());
		boolean var12 = !var4;
		boolean var13 = false;
		int var14 = 0;
		class_apn[] var15 = new class_apn[42];

		class_cj var17;
		for (int var16 = 1; var16 < 42; ++var16) {
			var17 = var2.a(var8, var16);
			class_apn var18 = var1.p(var17);
			if (var18.c() == Blocks.bR) {
				if (var18.b(a) == var8.d()) {
					var14 = var16;
				}
				break;
			}

			if ((var18.c() != Blocks.bS) && (var16 != var6)) {
				var15[var16] = null;
				var12 = false;
			} else {
				if (var16 == var6) {
					var18 = Objects.firstNonNull(var7, var18);
				}

				boolean var19 = !((Boolean) var18.b(class_anu.O)).booleanValue();
				boolean var20 = ((Boolean) var18.b(class_anu.a)).booleanValue();
				boolean var21 = ((Boolean) var18.b(class_anu.b)).booleanValue();
				var12 &= var21 == var11;
				var13 |= var19 && var20;
				var15[var16] = var18;
				if (var16 == var6) {
					var1.a(var2, this, this.a(var1));
					var12 &= var19;
				}
			}
		}

		var12 &= var14 > 1;
		var13 &= var12;
		class_apn var22 = S().a(N, Boolean.valueOf(var12)).a(b, Boolean.valueOf(var13));
		if (var14 > 0) {
			var17 = var2.a(var8, var14);
			class_cq var24 = var8.d();
			var1.a(var17, var22.a(a, var24), 3);
			this.a(var1, var17, var24);
			this.a(var1, var17, var12, var13, var9, var10);
		}

		this.a(var1, var2, var12, var13, var9, var10);
		if (!var4) {
			var1.a(var2, var22.a(a, var8), 3);
			if (var5) {
				this.a(var1, var2, var8);
			}
		}

		if (var9 != var12) {
			for (int var23 = 1; var23 < var14; ++var23) {
				class_cj var25 = var2.a(var8, var23);
				class_apn var26 = var15[var23];
				if ((var26 != null) && (var1.p(var25).c() != Blocks.a)) {
					var1.a(var25, var26.a(N, Boolean.valueOf(var12)), 3);
				}
			}
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		this.a(var1, var2, var3, false, true, -1, (class_apn) null);
	}

	private void a(class_ago var1, class_cj var2, boolean var3, boolean var4, boolean var5, boolean var6) {
		if (var4 && !var6) {
			var1.a(var2.n() + 0.5D, var2.o() + 0.1D, var2.p() + 0.5D, "random.click", 0.4F, 0.6F);
		} else if (!var4 && var6) {
			var1.a(var2.n() + 0.5D, var2.o() + 0.1D, var2.p() + 0.5D, "random.click", 0.4F, 0.5F);
		} else if (var3 && !var5) {
			var1.a(var2.n() + 0.5D, var2.o() + 0.1D, var2.p() + 0.5D, "random.click", 0.4F, 0.7F);
		} else if (!var3 && var5) {
			var1.a(var2.n() + 0.5D, var2.o() + 0.1D, var2.p() + 0.5D, "random.bowhit", 0.4F, 1.2F / ((var1.s.nextFloat() * 0.2F) + 0.9F));
		}

	}

	private void a(class_ago var1, class_cj var2, class_cq var3) {
		var1.d(var2, this);
		var1.d(var2.a(var3.d()), this);
	}

	private boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.c(var1, var2)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		float var3 = 0.1875F;
		switch (class_anv.SyntheticClass_1.a[((class_cq) var1.p(var2).b(a)).ordinal()]) {
			case 1:
				this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
				break;
			case 2:
				this.a(1.0F - (var3 * 2.0F), 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
				break;
			case 3:
				this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
				break;
			case 4:
				this.a(0.5F - var3, 0.2F, 1.0F - (var3 * 2.0F), 0.5F + var3, 0.8F, 1.0F);
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		boolean var4 = ((Boolean) var3.b(N)).booleanValue();
		boolean var5 = ((Boolean) var3.b(b)).booleanValue();
		if (var4 || var5) {
			this.a(var1, var2, var3, true, false, -1, (class_apn) null);
		}

		if (var5) {
			var1.d(var2, this);
			var1.d(var2.a(((class_cq) var3.b(a)).d()), this);
		}

		super.c(var1, var2, var3);
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return ((Boolean) var3.b(b)).booleanValue() ? 15 : 0;
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return !((Boolean) var3.b(b)).booleanValue() ? 0 : (var3.b(a) == var4 ? 15 : 0);
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_cq.b(var1 & 3)).a(b, Boolean.valueOf((var1 & 8) > 0)).a(N, Boolean.valueOf((var1 & 4) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(a)).b();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		if (((Boolean) var1.b(N)).booleanValue()) {
			var3 |= 4;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N, O });
	}

	static {
		a = class_akx.O;
		b = class_apy.a("powered");
		N = class_apy.a("attached");
		O = class_apy.a("suspended");
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.f.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
