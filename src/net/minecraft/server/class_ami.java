package net.minecraft.server;


public class class_ami extends class_aih {
	public static final class_aqa b = class_aqa.a("shape", class_aih.class_b_in_class_aih.class);

	protected class_ami() {
		super(false);
		this.j(M.b().a(b, class_aih.class_b_in_class_aih.a));
	}

	@Override
	protected void b(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (var4.i() && ((new class_aih.class_a_in_class_aih(var1, var2, var3)).a() == 3)) {
			this.a(var1, var2, var3, false);
		}

	}

	@Override
	public class_aqc n() {
		return b;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(b, class_aih.class_b_in_class_aih.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_aih.class_b_in_class_aih) var1.b(b)).a();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_ami.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					switch (class_ami.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
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
					switch (class_ami.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
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
					switch (class_ami.SyntheticClass_1.a[((class_aih.class_b_in_class_aih) var1.b(b)).ordinal()]) {
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
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			class_aih.class_b_in_class_aih var3 = (class_aih.class_b_in_class_aih) var1.b(b);
			switch (class_ami.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
					switch (class_ami.SyntheticClass_1.a[var3.ordinal()]) {
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
					switch (class_ami.SyntheticClass_1.a[var3.ordinal()]) {
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
		return new class_apo(this, new class_aqc[] { b });
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
