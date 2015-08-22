package net.minecraft.server;

import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

public class class_aji extends class_aih {
	public static final class_aqa b = class_aqa.a("shape", class_aih.class_b_in_class_aih.class, new Predicate() {
		public boolean a(class_aih.class_b_in_class_aih var1) {
			return (var1 != class_aih.class_b_in_class_aih.j) && (var1 != class_aih.class_b_in_class_aih.i) && (var1 != class_aih.class_b_in_class_aih.g) && (var1 != class_aih.class_b_in_class_aih.h);
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_aih.class_b_in_class_aih) var1);
		}
	});
	public static final class_apy N = class_apy.a("powered");

	public class_aji() {
		super(true);
		this.j(M.b().a(N, Boolean.valueOf(false)).a(b, class_aih.class_b_in_class_aih.a));
		this.a(true);
	}

	@Override
	public int a(class_ago var1) {
		return 20;
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_qx var4) {
		if (!var1.D) {
			if (!((Boolean) var3.b(N)).booleanValue()) {
				this.f(var1, var2, var3);
			}
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D && ((Boolean) var3.b(N)).booleanValue()) {
			this.f(var1, var2, var3);
		}
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return ((Boolean) var3.b(N)).booleanValue() ? 15 : 0;
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return !((Boolean) var3.b(N)).booleanValue() ? 0 : (var4 == class_cq.b ? 15 : 0);
	}

	private void f(class_ago var1, class_cj var2, class_apn var3) {
		boolean var4 = ((Boolean) var3.b(N)).booleanValue();
		boolean var5 = false;
		List var6 = this.a(var1, var2, class_xh.class, new Predicate[0]);
		if (!var6.isEmpty()) {
			var5 = true;
		}

		if (var5 && !var4) {
			var1.a(var2, var3.a(N, Boolean.valueOf(true)), 3);
			var1.d(var2, this);
			var1.d(var2.b(), this);
			var1.b(var2, var2);
		}

		if (!var5 && var4) {
			var1.a(var2, var3.a(N, Boolean.valueOf(false)), 3);
			var1.d(var2, this);
			var1.d(var2.b(), this);
			var1.b(var2, var2);
		}

		if (var5) {
			var1.a(var2, this, this.a(var1));
		}

		var1.f(var2, this);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		super.d(var1, var2, var3);
		this.f(var1, var2, var3);
	}

	@Override
	public class_aqc n() {
		return b;
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		if (((Boolean) var1.p(var2).b(N)).booleanValue()) {
			List var3 = this.a(var1, var2, class_xj.class, new Predicate[0]);
			if (!var3.isEmpty()) {
				return ((class_xj) var3.get(0)).i().j();
			}

			List var4 = this.a(var1, var2, class_xh.class, new Predicate[] { class_rb.c });
			if (!var4.isEmpty()) {
				return class_zu.b((class_pp) var4.get(0));
			}
		}

		return 0;
	}

	protected List a(class_ago var1, class_cj var2, Class var3, Predicate... var4) {
		class_ayk var5 = this.a(var2);
		return var4.length != 1 ? var1.a(var3, var5) : var1.a(var3, var5, var4[0]);
	}

	private class_ayk a(class_cj var1) {
		float var2 = 0.2F;
		return new class_ayk(var1.n() + 0.2F, var1.o(), var1.p() + 0.2F, var1.n() + 1 - 0.2F, var1.o() + 1 - 0.2F, var1.p() + 1 - 0.2F);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(b, class_aih.class_b_in_class_aih.a(var1 & 7)).a(N, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_aih.class_b_in_class_aih) var1.b(b)).a();
		if (((Boolean) var1.b(N)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_aji.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					switch (class_aji.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
						case 1:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 2:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
					}
				case 2:
					switch (class_aji.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
						case 1:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 2:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
						case 9:
							return var1.a(b, class_aih.class_b_in_class_aih.b);
						case 10:
							return var1.a(b, class_aih.class_b_in_class_aih.a);
					}
				case 3:
					switch (class_aji.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
						case 1:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 2:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						case 9:
							return var1.a(b, class_aih.class_b_in_class_aih.b);
						case 10:
							return var1.a(b, class_aih.class_b_in_class_aih.a);
					}
				default:
					return var1;
			}
		}
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_a_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			class_aih.class_b_in_class_aih var3 = (class_aih.class_b_in_class_aih) var1.b(b);
			switch (class_aji.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
					switch (class_aji.SyntheticClass_1.a[var3.ordinal()]) {
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						default:
							return super.a(var1, var2);
					}
				case 2:
					switch (class_aji.SyntheticClass_1.a[var3.ordinal()]) {
						case 1:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 2:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 3:
						case 4:
						default:
							break;
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
					}
			}

			return super.a(var1, var2);
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, N });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c = new int[class_ail.class_a_in_class_ail.values().length];

		static {
			try {
				c[class_ail.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var15) {
				;
			}

			try {
				c[class_ail.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var14) {
				;
			}

			b = new int[class_ail.class_c_in_class_ail.values().length];

			try {
				b[class_ail.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[class_ail.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var12) {
				;
			}

			try {
				b[class_ail.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var11) {
				;
			}

			a = new int[class_aih.class_b_in_class_aih.values().length];

			try {
				a[class_aih.class_b_in_class_aih.c.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.d.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.e.ordinal()] = 3;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.f.ordinal()] = 4;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.g.ordinal()] = 5;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.h.ordinal()] = 6;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.i.ordinal()] = 7;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.j.ordinal()] = 8;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.a.ordinal()] = 9;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.b.ordinal()] = 10;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
