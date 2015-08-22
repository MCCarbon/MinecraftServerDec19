package net.minecraft.server;

import java.util.Random;

public class class_ajm extends class_aif {
	public static final class_apz a;
	public static final class_apy b;
	public static final class_cp N;
	protected Random O = new Random();

	protected class_ajm() {
		super(class_avq.e);
		this.j(M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)));
		this.a(class_abp.d);
	}

	@Override
	public int a(class_ago var1) {
		return 4;
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		super.d(var1, var2, var3);
		this.f(var1, var2, var3);
	}

	private void f(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			class_cq var4 = (class_cq) var3.b(a);
			boolean var5 = var1.p(var2.c()).c().q();
			boolean var6 = var1.p(var2.d()).c().q();
			if ((var4 == class_cq.c) && var5 && !var6) {
				var4 = class_cq.d;
			} else if ((var4 == class_cq.d) && var6 && !var5) {
				var4 = class_cq.c;
			} else {
				boolean var7 = var1.p(var2.e()).c().q();
				boolean var8 = var1.p(var2.f()).c().q();
				if ((var4 == class_cq.e) && var7 && !var8) {
					var4 = class_cq.f;
				} else if ((var4 == class_cq.f) && var8 && !var7) {
					var4 = class_cq.e;
				}
			}

			var1.a(var2, var3.a(a, var4).a(b, Boolean.valueOf(false)), 2);
		}
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			TileEntity var11 = var1.s(var2);
			if (var11 instanceof class_aoo) {
				var4.a((class_pp) ((class_aoo) var11));
				if (var11 instanceof class_aop) {
					var4.b(class_nh.P);
				} else {
					var4.b(class_nh.R);
				}
			}

			return true;
		}
	}

	protected void e(class_ago var1, class_cj var2) {
		class_cl var3 = new class_cl(var1, var2);
		class_aoo var4 = (class_aoo) var3.h();
		if (var4 != null) {
			int var5 = var4.m();
			if (var5 < 0) {
				var1.b(1001, var2, 0);
			} else {
				class_aco var6 = var4.a(var5);
				class_cr var7 = this.a(var6);
				if (var7 != class_cr.a) {
					class_aco var8 = var7.a(var3, var6);
					var4.a(var5, var8.b <= 0 ? null : var8);
				}

			}
		}
	}

	protected class_cr a(class_aco var1) {
		return (class_cr) N.c(var1 == null ? null : var1.b());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		boolean var5 = var1.z(var2) || var1.z(var2.a());
		boolean var6 = ((Boolean) var3.b(b)).booleanValue();
		if (var5 && !var6) {
			var1.a(var2, this, this.a(var1));
			var1.a(var2, var3.a(b, Boolean.valueOf(true)), 4);
		} else if (!var5 && var6) {
			var1.a(var2, var3.a(b, Boolean.valueOf(false)), 4);
		}

	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			this.e(var1, var2);
		}

	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aoo();
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, class_apg.a(var1, var2, var8)).a(b, Boolean.valueOf(false));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		var1.a(var2, var3.a(a, class_apg.a(var1, var2, var4)), 2);
		if (var5.s()) {
			TileEntity var6 = var1.s(var2);
			if (var6 instanceof class_aoo) {
				((class_aoo) var6).a(var5.q());
			}
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		TileEntity var4 = var1.s(var2);
		if (var4 instanceof class_aoo) {
			class_pr.a(var1, var2, (class_aoo) var4);
			var1.f(var2, this);
		}

		super.c(var1, var2, var3);
	}

	public static class_cz a(class_ck var0) {
		class_cq var1 = b(var0.f());
		double var2 = var0.a() + (0.7D * var1.g());
		double var4 = var0.b() + (0.7D * var1.h());
		double var6 = var0.c() + (0.7D * var1.i());
		return new class_da(var2, var4, var6);
	}

	public static class_cq b(int var0) {
		return class_cq.a(var0 & 7);
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		return class_zu.a(var1.s(var2));
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(a)).a();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
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
		return new class_apo(this, new class_aqc[] { a, b });
	}

	static {
		a = class_ajk.b;
		b = class_apy.a("triggered");
		N = new class_cp(new class_cn());
	}
}
