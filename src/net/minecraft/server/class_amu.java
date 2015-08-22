package net.minecraft.server;

import java.util.Random;

public class class_amu extends class_aiq implements class_ain {
	public static final class_aqa a = class_aqa.a("type", class_aly.class_a_in_class_aly.class);
	public static final class_aqb b = class_aqb.a("stage", 0, 1);

	protected class_amu() {
		this.j(M.b().a(a, class_aly.class_a_in_class_aly.a).a(b, Integer.valueOf(0)));
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
		this.a(class_abp.c);
	}

	@Override
	public String f() {
		return class_di.a(this.a() + "." + class_aly.class_a_in_class_aly.a.d() + ".name");
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			super.b(var1, var2, var3, var4);
			if ((var1.l(var2.a()) >= 9) && (var4.nextInt(7) == 0)) {
				this.d(var1, var2, var3, var4);
			}

		}
	}

	public void d(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (((Integer) var3.b(b)).intValue() == 0) {
			var1.a(var2, var3.a(b), 4);
		} else {
			this.e(var1, var2, var3, var4);
		}

	}

	public void e(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		Object var5 = var4.nextInt(10) == 0 ? new class_asb(true) : new class_atr(true);
		int var6 = 0;
		int var7 = 0;
		boolean var8 = false;
		class_apn var9;
		switch (class_amu.SyntheticClass_1.a[((class_aly.class_a_in_class_aly) var3.b(a)).ordinal()]) {
			case 1:
				label68: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2, var6, var7, class_aly.class_a_in_class_aly.b)) {
							var5 = new class_atb(false, var4.nextBoolean());
							var8 = true;
							break label68;
						}
					}
				}

			if (!var8) {
				var7 = 0;
				var6 = 0;
				var5 = new class_ato(true);
			}
			break;
			case 2:
				var5 = new class_asc(true, false);
				break;
			case 3:
				var9 = Blocks.r.S().a(class_alv.b, class_aly.class_a_in_class_aly.d);
				class_apn var10 = Blocks.t.S().a(class_alu.P, class_aly.class_a_in_class_aly.d).a(class_alc.b, Boolean.valueOf(false));

				label82: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2, var6, var7, class_aly.class_a_in_class_aly.d)) {
							var5 = new class_ata(true, 10, 20, var9, var10);
							var8 = true;
							break label82;
						}
					}
				}

				if (!var8) {
					var7 = 0;
					var6 = 0;
					var5 = new class_atr(true, 4 + var4.nextInt(7), var9, var10, false);
				}
				break;
			case 4:
				var5 = new class_atl(true);
				break;
			case 5:
				label96: for (var6 = 0; var6 >= -1; --var6) {
					for (var7 = 0; var7 >= -1; --var7) {
						if (this.a(var1, var2, var6, var7, class_aly.class_a_in_class_aly.f)) {
							var5 = new class_atj(true);
							var8 = true;
							break label96;
						}
					}
				}

			if (!var8) {
				return;
			}
			case 6:
		}

		var9 = Blocks.a.S();
		if (var8) {
			var1.a(var2.a(var6, 0, var7), var9, 4);
			var1.a(var2.a(var6 + 1, 0, var7), var9, 4);
			var1.a(var2.a(var6, 0, var7 + 1), var9, 4);
			var1.a(var2.a(var6 + 1, 0, var7 + 1), var9, 4);
		} else {
			var1.a(var2, var9, 4);
		}

		if (!((class_asp) var5).b(var1, var4, var2.a(var6, 0, var7))) {
			if (var8) {
				var1.a(var2.a(var6, 0, var7), var3, 4);
				var1.a(var2.a(var6 + 1, 0, var7), var3, 4);
				var1.a(var2.a(var6, 0, var7 + 1), var3, 4);
				var1.a(var2.a(var6 + 1, 0, var7 + 1), var3, 4);
			} else {
				var1.a(var2, var3, 4);
			}
		}

	}

	private boolean a(class_ago var1, class_cj var2, int var3, int var4, class_aly.class_a_in_class_aly var5) {
		return this.a(var1, var2.a(var3, 0, var4), var5) && this.a(var1, var2.a(var3 + 1, 0, var4), var5) && this.a(var1, var2.a(var3, 0, var4 + 1), var5) && this.a(var1, var2.a(var3 + 1, 0, var4 + 1), var5);
	}

	public boolean a(class_ago var1, class_cj var2, class_aly.class_a_in_class_aly var3) {
		class_apn var4 = var1.p(var2);
		return (var4.c() == this) && (var4.b(a) == var3);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(a)).a();
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		return true;
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		return var1.s.nextFloat() < 0.45D;
	}

	@Override
	public void b(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		this.d(var1, var3, var4, var2);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_aly.class_a_in_class_aly.a(var1 & 7)).a(b, Integer.valueOf((var1 & 8) >> 3));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_aly.class_a_in_class_aly) var1.b(a)).a();
		var3 |= ((Integer) var1.b(b)).intValue() << 3;
		return var3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_aly.class_a_in_class_aly.values().length];

		static {
			try {
				a[class_aly.class_a_in_class_aly.b.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.c.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.d.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.e.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.f.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.a.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
