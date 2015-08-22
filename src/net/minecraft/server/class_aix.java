package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_aix extends class_ail {
	public static final class_aqb a = class_aqb.a("age", 0, 5);

	protected class_aix() {
		super(class_avq.k);
		this.j(M.b().a(a, Integer.valueOf(0)));
		this.a(class_abp.c);
		this.a(true);
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!this.d(var1, var2)) {
			var1.b(var2, true);
		} else if (var1.d(var2.a())) {
			int var5 = ((Integer) var3.b(a)).intValue();
			if ((var5 < 5) && (var4.nextInt(1) == 0)) {
				boolean var6 = false;
				boolean var7 = false;
				class_ail var8 = var1.p(var2.b()).c();
				int var9;
				if (var8 == class_aim.bH) {
					var6 = true;
				} else if (var8 == class_aim.cR) {
					var9 = 1;

					int var10;
					for (var10 = 0; var10 < 4; ++var10) {
						class_ail var11 = var1.p(var2.c(var9 + 1)).c();
						if (var11 != class_aim.cR) {
							if (var11 == class_aim.bH) {
								var7 = true;
							}
							break;
						}

						++var9;
					}

					var10 = 4;
					if (var7) {
						++var10;
					}

					if ((var9 < 2) || (var4.nextInt(var10) >= var9)) {
						var6 = true;
					}
				} else if (var8 == class_aim.a) {
					var6 = true;
				}

				if (var6 && a(var1, var2.a(), (class_cq) null) && var1.d(var2.b(2))) {
					var1.a(var2, class_aim.cR.S(), 2);
					var1.a(var2.a(), S().a(a, Integer.valueOf(var5)), 2);
				} else if (var5 < 4) {
					var9 = var4.nextInt(4);
					boolean var15 = false;
					if (var7) {
						++var9;
					}

					for (int var14 = 0; var14 < var9; ++var14) {
						class_cq var12 = class_cq.class_c_in_class_cq.a.a(var4);
						class_cj var13 = var2.a(var12);
						if (var1.d(var13) && var1.d(var13.b()) && a(var1, var13, var12.d())) {
							var1.a(var13, S().a(a, Integer.valueOf(var5 + 1)), 2);
							var15 = true;
						}
					}

					if (var15) {
						var1.a(var2, class_aim.cR.S(), 2);
					} else {
						var1.a(var2, var3.a(a, Integer.valueOf(5)), 2);
					}
				} else if (var5 == 4) {
					var1.a(var2, var3.a(a, Integer.valueOf(5)), 2);
				}

			}
		}
	}

	private static boolean a(class_ago var0, class_cj var1, class_cq var2) {
		Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

		class_cq var4;
		do {
			if (!var3.hasNext()) {
				return true;
			}

			var4 = (class_cq) var3.next();
		} while ((var4 == var2) || var0.d(var1.a(var4)));

		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) && this.d(var1, var2);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		if (!this.d(var1, var2)) {
			var1.a(var2, this, 1);
		}

	}

	public boolean d(class_ago var1, class_cj var2) {
		class_ail var3 = var1.p(var2.b()).c();
		if ((var3 != class_aim.cR) && (var3 != class_aim.bH)) {
			if (var3 == class_aim.a) {
				int var4 = 0;
				Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

				while (var5.hasNext()) {
					class_cq var6 = (class_cq) var5.next();
					class_ail var7 = var1.p(var2.a(var6)).c();
					if (var7 == class_aim.cR) {
						++var4;
					} else if (var7 != class_aim.a) {
						return false;
					}
				}

				return var4 == 1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, class_aoi var5, class_aco var6) {
		super.a(var1, var2, var3, var4, var5, var6);
		a(var1, var3, new class_aco(class_acm.a(this)));
	}

	@Override
	protected class_aco i(class_apn var1) {
		return null;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		super.d(var1, var2, var3);
	}

	public static void a(class_ago var0, class_cj var1, Random var2, int var3) {
		var0.a(var1, class_aim.cR.S(), 2);
		a(var0, var1, var2, var1, var3, 0);
	}

	private static void a(class_ago var0, class_cj var1, Random var2, class_cj var3, int var4, int var5) {
		int var6 = var2.nextInt(4) + 1;
		if (var5 == 0) {
			++var6;
		}

		for (int var7 = 0; var7 < var6; ++var7) {
			class_cj var8 = var1.b(var7 + 1);
			if (!a(var0, var8, (class_cq) null)) {
				return;
			}

			var0.a(var8, class_aim.cR.S(), 2);
		}

		boolean var12 = false;
		if (var5 < 4) {
			int var13 = var2.nextInt(4);
			if (var5 == 0) {
				++var13;
			}

			for (int var9 = 0; var9 < var13; ++var9) {
				class_cq var10 = class_cq.class_c_in_class_cq.a.a(var2);
				class_cj var11 = var1.b(var6).a(var10);
				if ((Math.abs(var11.n() - var3.n()) < var4) && (Math.abs(var11.p() - var3.p()) < var4) && var0.d(var11) && var0.d(var11.b()) && a(var0, var11, var10.d())) {
					var12 = true;
					var0.a(var11, class_aim.cR.S(), 2);
					a(var0, var11, var2, var3, var4, var5 + 1);
				}
			}
		}

		if (!var12) {
			var0.a(var1.b(var6), class_aim.cS.S().a(a, Integer.valueOf(5)), 2);
		}

	}
}
