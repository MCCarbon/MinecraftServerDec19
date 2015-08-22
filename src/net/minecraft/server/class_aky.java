package net.minecraft.server;

import java.util.Random;

public class class_aky extends Block {
	public static final class_aqa a = class_aqa.a("variant", class_aky.class_a_in_class_aky.class);
	private final Block b;

	public class_aky(class_avq var1, class_avr var2, Block var3) {
		super(var1, var2);
		this.j(M.b().a(a, class_aky.class_a_in_class_aky.l));
		b = var3;
	}

	@Override
	public int a(Random var1) {
		return Math.max(0, var1.nextInt(10) - 7);
	}

	@Override
	public class_avr g(class_apn var1) {
		switch (class_aky.SyntheticClass_1.a[((class_aky.class_a_in_class_aky) var1.b(a)).ordinal()]) {
			case 1:
				return class_avr.e;
			case 2:
				return class_avr.d;
			case 3:
				return class_avr.d;
			default:
				return super.g(var1);
		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(b);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(b);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_aky.class_a_in_class_aky.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_aky.class_a_in_class_aky) var1.b(a)).a();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_aky.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					switch (class_aky.SyntheticClass_1.a[((class_aky.class_a_in_class_aky) var1.b(a)).ordinal()]) {
						case 3:
							break;
						case 4:
							return var1.a(a, class_aky.class_a_in_class_aky.i);
						case 5:
							return var1.a(a, class_aky.class_a_in_class_aky.h);
						case 6:
							return var1.a(a, class_aky.class_a_in_class_aky.g);
						case 7:
							return var1.a(a, class_aky.class_a_in_class_aky.f);
						case 8:
							return var1.a(a, class_aky.class_a_in_class_aky.d);
						case 9:
							return var1.a(a, class_aky.class_a_in_class_aky.c);
						case 10:
							return var1.a(a, class_aky.class_a_in_class_aky.b);
						case 11:
							return var1.a(a, class_aky.class_a_in_class_aky.a);
						default:
							return var1;
					}
				case 2:
					switch (class_aky.SyntheticClass_1.a[((class_aky.class_a_in_class_aky) var1.b(a)).ordinal()]) {
						case 3:
							break;
						case 4:
							return var1.a(a, class_aky.class_a_in_class_aky.g);
						case 5:
							return var1.a(a, class_aky.class_a_in_class_aky.d);
						case 6:
							return var1.a(a, class_aky.class_a_in_class_aky.a);
						case 7:
							return var1.a(a, class_aky.class_a_in_class_aky.h);
						case 8:
							return var1.a(a, class_aky.class_a_in_class_aky.b);
						case 9:
							return var1.a(a, class_aky.class_a_in_class_aky.i);
						case 10:
							return var1.a(a, class_aky.class_a_in_class_aky.f);
						case 11:
							return var1.a(a, class_aky.class_a_in_class_aky.c);
						default:
							return var1;
					}
				case 3:
					switch (class_aky.SyntheticClass_1.a[((class_aky.class_a_in_class_aky) var1.b(a)).ordinal()]) {
						case 3:
							break;
						case 4:
							return var1.a(a, class_aky.class_a_in_class_aky.c);
						case 5:
							return var1.a(a, class_aky.class_a_in_class_aky.f);
						case 6:
							return var1.a(a, class_aky.class_a_in_class_aky.i);
						case 7:
							return var1.a(a, class_aky.class_a_in_class_aky.b);
						case 8:
							return var1.a(a, class_aky.class_a_in_class_aky.h);
						case 9:
							return var1.a(a, class_aky.class_a_in_class_aky.a);
						case 10:
							return var1.a(a, class_aky.class_a_in_class_aky.d);
						case 11:
							return var1.a(a, class_aky.class_a_in_class_aky.g);
						default:
							return var1;
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
			class_aky.class_a_in_class_aky var3 = (class_aky.class_a_in_class_aky) var1.b(a);
			switch (class_aky.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
					switch (class_aky.SyntheticClass_1.a[var3.ordinal()]) {
						case 4:
							return var1.a(a, class_aky.class_a_in_class_aky.g);
						case 5:
							return var1.a(a, class_aky.class_a_in_class_aky.h);
						case 6:
							return var1.a(a, class_aky.class_a_in_class_aky.i);
						case 7:
						case 8:
						default:
							return super.a(var1, var2);
						case 9:
							return var1.a(a, class_aky.class_a_in_class_aky.a);
						case 10:
							return var1.a(a, class_aky.class_a_in_class_aky.b);
						case 11:
							return var1.a(a, class_aky.class_a_in_class_aky.c);
					}
				case 2:
					switch (class_aky.SyntheticClass_1.a[var3.ordinal()]) {
						case 4:
							return var1.a(a, class_aky.class_a_in_class_aky.c);
						case 5:
						case 10:
						default:
							break;
						case 6:
							return var1.a(a, class_aky.class_a_in_class_aky.a);
						case 7:
							return var1.a(a, class_aky.class_a_in_class_aky.f);
						case 8:
							return var1.a(a, class_aky.class_a_in_class_aky.d);
						case 9:
							return var1.a(a, class_aky.class_a_in_class_aky.i);
						case 11:
							return var1.a(a, class_aky.class_a_in_class_aky.g);
					}
			}

			return super.a(var1, var2);
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
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
			} catch (NoSuchFieldError var16) {
				;
			}

			try {
				c[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var15) {
				;
			}

			b = new int[Block.class_c_in_class_ail.values().length];

			try {
				b[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var14) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var12) {
				;
			}

			a = new int[class_aky.class_a_in_class_aky.values().length];

			try {
				a[class_aky.class_a_in_class_aky.m.ordinal()] = 1;
			} catch (NoSuchFieldError var11) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.k.ordinal()] = 2;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.j.ordinal()] = 3;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.a.ordinal()] = 4;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.b.ordinal()] = 5;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.c.ordinal()] = 6;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.d.ordinal()] = 7;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.f.ordinal()] = 8;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.g.ordinal()] = 9;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.h.ordinal()] = 10;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aky.class_a_in_class_aky.i.ordinal()] = 11;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_aky implements class_oe {
		a(1, "north_west"),
		b(2, "north"),
		c(3, "north_east"),
		d(4, "west"),
		e(5, "center"),
		f(6, "east"),
		g(7, "south_west"),
		h(8, "south"),
		i(9, "south_east"),
		j(10, "stem"),
		k(0, "all_inside"),
		l(14, "all_outside"),
		m(15, "all_stem");

		private static final class_aky.class_a_in_class_aky[] n;
		private final int o;
		private final String p;

		private class_a_in_class_aky(int var3, String var4) {
			o = var3;
			p = var4;
		}

		public int a() {
			return o;
		}

		@Override
		public String toString() {
			return p;
		}

		public static class_aky.class_a_in_class_aky a(int var0) {
			if ((var0 < 0) || (var0 >= n.length)) {
				var0 = 0;
			}

			class_aky.class_a_in_class_aky var1 = n[var0];
			return var1 == null ? n[0] : var1;
		}

		@Override
		public String l() {
			return p;
		}

		static {
			n = new class_aky.class_a_in_class_aky[16];
			class_aky.class_a_in_class_aky[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_aky.class_a_in_class_aky var3 = var0[var2];
				n[var3.a()] = var3;
			}

		}
	}
}
