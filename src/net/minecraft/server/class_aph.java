package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_aph extends class_ajk {
	public static final class_aqa a = class_aqa.a("type", class_aph.class_a_in_class_aph.class);
	public static final class_apy N = class_apy.a("short");

	public class_aph() {
		super(class_avq.H);
		this.j(M.b().a(b, class_cq.c).a(a, class_aph.class_a_in_class_aph.a).a(N, Boolean.valueOf(false)));
		this.a(i);
		this.c(0.5F);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		if (var4.bI.d) {
			class_cq var5 = (class_cq) var3.b(b);
			if (var5 != null) {
				class_cj var6 = var2.a(var5.d());
				class_ail var7 = var1.p(var6).c();
				if ((var7 == class_aim.J) || (var7 == class_aim.F)) {
					var1.g(var6);
				}
			}
		}

		super.a(var1, var2, var3, var4);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		super.c(var1, var2, var3);
		class_cq var4 = ((class_cq) var3.b(b)).d();
		var2 = var2.a(var4);
		class_apn var5 = var1.p(var2);
		if (((var5.c() == class_aim.J) || (var5.c() == class_aim.F)) && ((Boolean) var5.b(class_apg.a)).booleanValue()) {
			var5.c().b(var1, var2, var5, 0);
			var1.g(var2);
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

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return false;
	}

	@Override
	public boolean b(class_ago var1, class_cj var2, class_cq var3) {
		return false;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, class_qx var6) {
		this.d(var3);
		super.a(var1, var2, var3, var4, var5, var6);
		this.e(var3);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	private void e(class_apn var1) {
		float var2 = 0.25F;
		float var3 = 0.375F;
		float var4 = 0.625F;
		float var5 = 0.25F;
		float var6 = 0.75F;
		switch (class_aph.SyntheticClass_1.a[((class_cq) var1.b(b)).ordinal()]) {
			case 1:
				this.a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
				break;
			case 2:
				this.a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
				break;
			case 3:
				this.a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
				break;
			case 4:
				this.a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
				break;
			case 5:
				this.a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
				break;
			case 6:
				this.a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
		}

	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	public void d(class_apn var1) {
		float var2 = 0.25F;
		class_cq var3 = (class_cq) var1.b(b);
		switch (class_aph.SyntheticClass_1.a[var3.ordinal()]) {
			case 1:
				this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
				break;
			case 2:
				this.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
				break;
			case 3:
				this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
				break;
			case 4:
				this.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
				break;
			case 5:
				this.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
				break;
			case 6:
				this.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		class_cq var5 = (class_cq) var3.b(b);
		class_cj var6 = var2.a(var5.d());
		class_apn var7 = var1.p(var6);
		if ((var7.c() != class_aim.J) && (var7.c() != class_aim.F)) {
			var1.g(var2);
		} else {
			var7.c().a(var1, var6, var7, var4);
		}

	}

	public static class_cq b(int var0) {
		int var1 = var0 & 7;
		return var1 > 5 ? null : class_cq.a(var1);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(var3.b(a) == class_aph.class_a_in_class_aph.b ? class_aim.F : class_aim.J);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(b, b(var1)).a(a, (var1 & 8) > 0 ? class_aph.class_a_in_class_aph.b : class_aph.class_a_in_class_aph.a);
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(b)).a();
		if (var1.b(a) == class_aph.class_a_in_class_aph.b) {
			var3 |= 8;
		}

		return var3;
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
		return new class_apo(this, new class_aqc[] { b, a, N });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_aph implements class_oe {
		a("normal"),
		b("sticky");

		private final String c;

		private class_a_in_class_aph(String var3) {
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
