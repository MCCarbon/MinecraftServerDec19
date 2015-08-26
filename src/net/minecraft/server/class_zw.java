package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_zw extends class_zu {
	private static final Logger f = LogManager.getLogger();
	private class_pp g = new class_aaq();
	private class_pp h = new class_qc("Repair", true, 2) {
		@Override
		public void o_() {
			super.o_();
			class_zw.this.a(this);
		}
	};
	private class_ago i;
	private class_cj j;
	public int a;
	private int k;
	private String l;
	private final class_yu m;

	public class_zw(class_yt var1, final class_ago var2, final class_cj var3, class_yu var4) {
		j = var3;
		i = var2;
		m = var4;
		this.a((new class_aas(h, 0, 27, 47)));
		this.a((new class_aas(h, 1, 76, 47)));
		this.a((new class_aas(g, 2, 134, 47) {
			@Override
			public boolean a(class_aco var1) {
				return false;
			}

			@Override
			public boolean a(class_yu var1) {
				return (var1.bI.d || (var1.bJ >= a)) && (a > 0) && e();
			}

			@Override
			public void a(class_yu var1, class_aco var2x) {
				if (!var1.bI.d) {
					var1.a(-a);
				}

				h.a(0, (class_aco) null);
				if (k > 0) {
					class_aco var3x = h.a(1);
					if ((var3x != null) && (var3x.b > k)) {
						var3x.b -= k;
						h.a(1, var3x);
					} else {
						h.a(1, (class_aco) null);
					}
				} else {
					h.a(1, (class_aco) null);
				}

				a = 0;
				class_apn var5 = var2.p(var3);
				if (!var1.bI.d && !var2.D && (var5.c() == Blocks.ANVIL) && (var1.bj().nextFloat() < 0.12F)) {
					int var4 = ((Integer) var5.b(class_aic.b)).intValue();
					++var4;
					if (var4 > 2) {
						var2.g(var3);
						var2.b(1020, var3, 0);
					} else {
						var2.a(var3, var5.a(class_aic.b, Integer.valueOf(var4)), 2);
						var2.b(1021, var3, 0);
					}
				} else if (!var2.D) {
					var2.b(1021, var3, 0);
				}

			}
		}));

		int var5;
		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.a((new class_aas(var1, var6 + (var5 * 9) + 9, 8 + (var6 * 18), 84 + (var5 * 18))));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a((new class_aas(var1, var5, 8 + (var5 * 18), 142)));
		}

	}

	@Override
	public void a(class_pp var1) {
		super.a(var1);
		if (var1 == h) {
			e();
		}

	}

	public void e() {
		class_aco var1 = h.a(0);
		a = 1;
		int var2 = 0;
		byte var3 = 0;
		byte var4 = 0;
		if (var1 == null) {
			g.a(0, (class_aco) null);
			a = 0;
		} else {
			class_aco var5 = var1.k();
			class_aco var6 = h.a(1);
			Map var7 = class_afl.a(var5);
			int var17 = var3 + var1.A() + (var6 == null ? 0 : var6.A());
			k = 0;
			if (var6 != null) {
				boolean var8 = (var6.b() == Items.ci) && !Items.ci.h(var6).c_();
				int var9;
				int var10;
				int var11;
				if (var5.e() && var5.b().a(var1, var6)) {
					var9 = Math.min(var5.h(), var5.j() / 4);
					if (var9 <= 0) {
						g.a(0, (class_aco) null);
						a = 0;
						return;
					}

					for (var10 = 0; (var9 > 0) && (var10 < var6.b); ++var10) {
						var11 = var5.h() - var9;
						var5.b(var11);
						++var2;
						var9 = Math.min(var5.h(), var5.j() / 4);
					}

					k = var10;
				} else {
					if (!var8 && ((var5.b() != var6.b()) || !var5.e())) {
						g.a(0, (class_aco) null);
						a = 0;
						return;
					}

					int var12;
					int var13;
					if (var5.e() && !var8) {
						var9 = var1.j() - var1.h();
						var10 = var6.j() - var6.h();
						var11 = var10 + ((var5.j() * 12) / 100);
						var12 = var9 + var11;
						var13 = var5.j() - var12;
						if (var13 < 0) {
							var13 = 0;
						}

						if (var13 < var5.i()) {
							var5.b(var13);
							var2 += 2;
						}
					}

					Map var19 = class_afl.a(var6);
					Iterator var20 = var19.keySet().iterator();

					label144: while (true) {
						class_afj var21;
						do {
							if (!var20.hasNext()) {
								break label144;
							}

							var21 = (class_afj) var20.next();
						} while (var21 == null);

						var12 = var7.containsKey(var21) ? ((Integer) var7.get(var21)).intValue() : 0;
						var13 = ((Integer) var19.get(var21)).intValue();
						var13 = var12 == var13 ? var13 + 1 : Math.max(var13, var12);
						boolean var14 = var21.a(var1);
						if (m.bI.d || (var1.b() == Items.ci)) {
							var14 = true;
						}

						Iterator var15 = var7.keySet().iterator();

						while (var15.hasNext()) {
							class_afj var16 = (class_afj) var15.next();
							if ((var16 != var21) && !var21.a(var16)) {
								var14 = false;
								++var2;
							}
						}

						if (var14) {
							if (var13 > var21.b()) {
								var13 = var21.b();
							}

							var7.put(var21, Integer.valueOf(var13));
							int var22 = 0;
							switch (class_zw.SyntheticClass_1.a[var21.c().ordinal()]) {
								case 1:
									var22 = 1;
									break;
								case 2:
									var22 = 2;
									break;
								case 3:
									var22 = 4;
									break;
								case 4:
									var22 = 8;
							}

							if (var8) {
								var22 = Math.max(1, var22 / 2);
							}

							var2 += var22 * var13;
						}
					}
				}
			}

			if (StringUtils.isBlank(l)) {
				if (var1.s()) {
					var4 = 1;
					var2 += var4;
					var5.r();
				}
			} else if (!l.equals(var1.q())) {
				var4 = 1;
				var2 += var4;
				var5.c(l);
			}

			a = var17 + var2;
			if (var2 <= 0) {
				var5 = null;
			}

			if ((var4 == var2) && (var4 > 0) && (a >= 40)) {
				a = 39;
			}

			if ((a >= 40) && !m.bI.d) {
				var5 = null;
			}

			if (var5 != null) {
				int var18 = var5.A();
				if ((var6 != null) && (var18 < var6.A())) {
					var18 = var6.A();
				}

				var18 = (var18 * 2) + 1;
				var5.c(var18);
				class_afl.a(var7, var5);
			}

			g.a(0, var5);
			this.b();
		}
	}

	@Override
	public void a(class_zz var1) {
		super.a(var1);
		var1.a(this, 0, a);
	}

	@Override
	public void b(class_yu var1) {
		super.b(var1);
		if (!i.D) {
			for (int var2 = 0; var2 < h.n_(); ++var2) {
				class_aco var3 = h.b(var2);
				if (var3 != null) {
					var1.a(var3, false);
				}
			}

		}
	}

	@Override
	public boolean a(class_yu var1) {
		return i.p(j).c() != Blocks.ANVIL ? false : var1.e(j.n() + 0.5D, j.o() + 0.5D, j.p() + 0.5D) <= 64.0D;
	}

	@Override
	public class_aco b(class_yu var1, int var2) {
		class_aco var3 = null;
		class_aas var4 = (class_aas) c.get(var2);
		if ((var4 != null) && var4.e()) {
			class_aco var5 = var4.d();
			var3 = var5.k();
			if (var2 == 2) {
				if (!this.a(var5, 3, 39, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if ((var2 != 0) && (var2 != 1)) {
				if ((var2 >= 3) && (var2 < 39) && !this.a(var5, 0, 2, false)) {
					return null;
				}
			} else if (!this.a(var5, 3, 39, false)) {
				return null;
			}

			if (var5.b == 0) {
				var4.d((class_aco) null);
			} else {
				var4.f();
			}

			if (var5.b == var3.b) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}

	public void a(String var1) {
		l = var1;
		if (this.a(2).e()) {
			class_aco var2 = this.a(2).d();
			if (StringUtils.isBlank(var1)) {
				var2.r();
			} else {
				var2.c(l);
			}
		}

		e();
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_afj.class_a_in_class_afj.values().length];

		static {
			try {
				a[class_afj.class_a_in_class_afj.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_afj.class_a_in_class_afj.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_afj.class_a_in_class_afj.c.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_afj.class_a_in_class_afj.d.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
