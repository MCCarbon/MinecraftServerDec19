package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class class_air extends class_ajk {
	public static final class_apy a = class_apy.a("powered");
	private final boolean N;

	protected class_air(boolean var1) {
		super(class_avq.q);
		this.j(M.b().a(b, class_cq.c).a(a, Boolean.valueOf(false)));
		this.a(true);
		this.a(class_abp.d);
		N = var1;
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public int a(class_ago var1) {
		return N ? 30 : 20;
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
		return a(var1, var2, var3.d());
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		class_cq[] var3 = class_cq.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_cq var6 = var3[var5];
			if (a(var1, var2, var6)) {
				return true;
			}
		}

		return false;
	}

	protected static boolean a(class_ago var0, class_cj var1, class_cq var2) {
		class_cj var3 = var1.a(var2);
		return var2 == class_cq.a ? class_ago.a(var0, var3) : var0.p(var3).c().x();
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return a(var1, var2, var3.d()) ? S().a(b, var3).a(a, Boolean.valueOf(false)) : S().a(b, class_cq.a).a(a, Boolean.valueOf(false));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		if (this.f(var1, var2, var3) && !a(var1, var2, ((class_cq) var3.b(b)).d())) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	private boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (this.c(var1, var2)) {
			return true;
		} else {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		}
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	private void d(class_apn var1) {
		class_cq var2 = (class_cq) var1.b(b);
		boolean var3 = ((Boolean) var1.b(a)).booleanValue();
		float var4 = 0.25F;
		float var5 = 0.375F;
		float var6 = (var3 ? 1 : 2) / 16.0F;
		float var7 = 0.125F;
		float var8 = 0.1875F;
		switch (class_air.SyntheticClass_1.a[var2.ordinal()]) {
			case 1:
				this.a(0.0F, 0.375F, 0.3125F, var6, 0.625F, 0.6875F);
				break;
			case 2:
				this.a(1.0F - var6, 0.375F, 0.3125F, 1.0F, 0.625F, 0.6875F);
				break;
			case 3:
				this.a(0.3125F, 0.375F, 0.0F, 0.6875F, 0.625F, var6);
				break;
			case 4:
				this.a(0.3125F, 0.375F, 1.0F - var6, 0.6875F, 0.625F, 1.0F);
				break;
			case 5:
				this.a(0.3125F, 0.0F, 0.375F, 0.6875F, 0.0F + var6, 0.625F);
				break;
			case 6:
				this.a(0.3125F, 1.0F - var6, 0.375F, 0.6875F, 1.0F, 0.625F);
		}

	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			return true;
		} else {
			var1.a(var2, var3.a(a, Boolean.valueOf(true)), 3);
			var1.b(var2, var2);
			var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
			this.c(var1, var2, (class_cq) var3.b(b));
			var1.a(var2, this, this.a(var1));
			return true;
		}
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			this.c(var1, var2, (class_cq) var3.b(b));
		}

		super.c(var1, var2, var3);
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return ((Boolean) var3.b(a)).booleanValue() ? 15 : 0;
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return !((Boolean) var3.b(a)).booleanValue() ? 0 : (var3.b(b) == var4 ? 15 : 0);
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			if (((Boolean) var3.b(a)).booleanValue()) {
				if (N) {
					this.g(var1, var2, var3);
				} else {
					var1.a(var2, var3.a(a, Boolean.valueOf(false)));
					this.c(var1, var2, (class_cq) var3.b(b));
					var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
					var1.b(var2, var2);
				}

			}
		}
	}

	@Override
	public void j() {
		float var1 = 0.1875F;
		float var2 = 0.125F;
		float var3 = 0.125F;
		this.a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_qx var4) {
		if (!var1.D) {
			if (N) {
				if (!((Boolean) var3.b(a)).booleanValue()) {
					this.g(var1, var2, var3);
				}
			}
		}
	}

	private void g(class_ago var1, class_cj var2, class_apn var3) {
		this.d(var3);
		List var4 = var1.a(class_yx.class, new class_ayk(var2.n() + B, var2.o() + C, var2.p() + D, var2.n() + E, var2.o() + F, var2.p() + G));
		boolean var5 = !var4.isEmpty();
		boolean var6 = ((Boolean) var3.b(a)).booleanValue();
		if (var5 && !var6) {
			var1.a(var2, var3.a(a, Boolean.valueOf(true)));
			this.c(var1, var2, (class_cq) var3.b(b));
			var1.b(var2, var2);
			var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
		}

		if (!var5 && var6) {
			var1.a(var2, var3.a(a, Boolean.valueOf(false)));
			this.c(var1, var2, (class_cq) var3.b(b));
			var1.b(var2, var2);
			var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
		}

		if (var5) {
			var1.a(var2, this, this.a(var1));
		}

	}

	private void c(class_ago var1, class_cj var2, class_cq var3) {
		var1.d(var2, this);
		var1.d(var2.a(var3.d()), this);
	}

	@Override
	public class_apn a(int var1) {
		class_cq var2;
		switch (var1 & 7) {
			case 0:
				var2 = class_cq.a;
				break;
			case 1:
				var2 = class_cq.f;
				break;
			case 2:
				var2 = class_cq.e;
				break;
			case 3:
				var2 = class_cq.d;
				break;
			case 4:
				var2 = class_cq.c;
				break;
			case 5:
			default:
				var2 = class_cq.b;
		}

		return S().a(b, var2).a(a, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		int var2;
		switch (class_air.SyntheticClass_1.a[((class_cq) var1.b(b)).ordinal()]) {
			case 1:
				var2 = 1;
				break;
			case 2:
				var2 = 2;
				break;
			case 3:
				var2 = 3;
				break;
			case 4:
				var2 = 4;
				break;
			case 5:
			default:
				var2 = 5;
				break;
			case 6:
				var2 = 0;
		}

		if (((Boolean) var1.b(a)).booleanValue()) {
			var2 |= 8;
		}

		return var2;
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(b, var2.a((class_cq) var1.b(b)));
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(b)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, a });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.f.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.b.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.a.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
