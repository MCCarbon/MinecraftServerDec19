package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_amc extends class_aih {
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

	protected class_amc() {
		super(true);
		this.j(M.b().a(b, class_aih.class_b_in_class_aih.a).a(N, Boolean.valueOf(false)));
	}

	protected boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4, int var5) {
		if (var5 >= 8) {
			return false;
		} else {
			int var6 = var2.n();
			int var7 = var2.o();
			int var8 = var2.p();
			boolean var9 = true;
			class_aih.class_b_in_class_aih var10 = (class_aih.class_b_in_class_aih) var3.b(b);
			switch (class_amc.SyntheticClass_1.a[var10.ordinal()]) {
				case 1:
					if (var4) {
						++var8;
					} else {
						--var8;
					}
					break;
				case 2:
					if (var4) {
						--var6;
					} else {
						++var6;
					}
					break;
				case 3:
					if (var4) {
						--var6;
					} else {
						++var6;
						++var7;
						var9 = false;
					}

					var10 = class_aih.class_b_in_class_aih.b;
					break;
				case 4:
					if (var4) {
						--var6;
						++var7;
						var9 = false;
					} else {
						++var6;
					}

					var10 = class_aih.class_b_in_class_aih.b;
					break;
				case 5:
					if (var4) {
						++var8;
					} else {
						--var8;
						++var7;
						var9 = false;
					}

					var10 = class_aih.class_b_in_class_aih.a;
					break;
				case 6:
					if (var4) {
						++var8;
						++var7;
						var9 = false;
					} else {
						--var8;
					}

					var10 = class_aih.class_b_in_class_aih.a;
			}

			return this.a(var1, new class_cj(var6, var7, var8), var4, var5, var10) ? true : var9 && this.a(var1, new class_cj(var6, var7 - 1, var8), var4, var5, var10);
		}
	}

	protected boolean a(class_ago var1, class_cj var2, boolean var3, int var4, class_aih.class_b_in_class_aih var5) {
		class_apn var6 = var1.p(var2);
		if (var6.c() != this) {
			return false;
		} else {
			class_aih.class_b_in_class_aih var7 = (class_aih.class_b_in_class_aih) var6.b(b);
			return (var5 == class_aih.class_b_in_class_aih.b) && ((var7 == class_aih.class_b_in_class_aih.a) || (var7 == class_aih.class_b_in_class_aih.e) || (var7 == class_aih.class_b_in_class_aih.f)) ? false : ((var5 == class_aih.class_b_in_class_aih.a) && ((var7 == class_aih.class_b_in_class_aih.b) || (var7 == class_aih.class_b_in_class_aih.c) || (var7 == class_aih.class_b_in_class_aih.d)) ? false : (((Boolean) var6.b(N)).booleanValue() ? (var1.z(var2) ? true : this.a(var1, var2, var6, var3, var4 + 1))
					: false));
		}
	}

	@Override
	protected void b(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		boolean var5 = ((Boolean) var3.b(N)).booleanValue();
		boolean var6 = var1.z(var2) || this.a(var1, var2, var3, true, 0) || this.a(var1, var2, var3, false, 0);
		if (var6 != var5) {
			var1.a(var2, var3.a(N, Boolean.valueOf(var6)), 3);
			var1.d(var2.b(), this);
			if (((class_aih.class_b_in_class_aih) var3.b(b)).c()) {
				var1.d(var2.a(), this);
			}
		}

	}

	@Override
	public class_aqc n() {
		return b;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(b, class_aih.class_b_in_class_aih.a(var1 & 7)).a(N, Boolean.valueOf((var1 & 8) > 0));
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
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_amc.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					switch (class_amc.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 9:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						case 10:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
					}
				case 2:
					switch (class_amc.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
						case 1:
							return var1.a(b, class_aih.class_b_in_class_aih.b);
						case 2:
							return var1.a(b, class_aih.class_b_in_class_aih.a);
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						case 9:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 10:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
					}
				case 3:
					switch (class_amc.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
						case 1:
							return var1.a(b, class_aih.class_b_in_class_aih.b);
						case 2:
							return var1.a(b, class_aih.class_b_in_class_aih.a);
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
						case 9:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 10:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
					}
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
			class_aih.class_b_in_class_aih var3 = (class_aih.class_b_in_class_aih) var1.b(b);
			switch (class_amc.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
					switch (class_amc.SyntheticClass_1.a[var3.ordinal()]) {
						case 5:
							return var1.a(b, class_aih.class_b_in_class_aih.f);
						case 6:
							return var1.a(b, class_aih.class_b_in_class_aih.e);
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.i);
						case 9:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 10:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						default:
							return super.a(var1, var2);
					}
				case 2:
					switch (class_amc.SyntheticClass_1.a[var3.ordinal()]) {
						case 3:
							return var1.a(b, class_aih.class_b_in_class_aih.d);
						case 4:
							return var1.a(b, class_aih.class_b_in_class_aih.c);
						case 5:
						case 6:
						default:
							break;
						case 7:
							return var1.a(b, class_aih.class_b_in_class_aih.h);
						case 8:
							return var1.a(b, class_aih.class_b_in_class_aih.g);
						case 9:
							return var1.a(b, class_aih.class_b_in_class_aih.j);
						case 10:
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
		static final int[] c = new int[Block.class_a_in_class_ail.values().length];

		static {
			try {
				c[Block.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var15) {
				;
			}

			try {
				c[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var14) {
				;
			}

			b = new int[Block.class_c_in_class_ail.values().length];

			try {
				b[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var12) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var11) {
				;
			}

			a = new int[class_aih.class_b_in_class_aih.values().length];

			try {
				a[class_aih.class_b_in_class_aih.a.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.b.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.c.ordinal()] = 3;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.d.ordinal()] = 4;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.e.ordinal()] = 5;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.f.ordinal()] = 6;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.g.ordinal()] = 7;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.h.ordinal()] = 8;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.i.ordinal()] = 9;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aih.class_b_in_class_aih.j.ordinal()] = 10;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
