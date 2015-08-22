package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_aiv extends class_ail {
	public static final class_aqb a = class_aqb.a("level", 0, 3);

	public class_aiv() {
		super(class_avq.f, class_avr.m);
		this.j(M.b().a(a, Integer.valueOf(0)));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, class_qx var6) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		float var7 = 0.125F;
		this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.j();
	}

	@Override
	public void j() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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
	public void a(class_ago var1, class_cj var2, class_apn var3, class_qx var4) {
		int var5 = ((Integer) var3.b(a)).intValue();
		float var6 = var2.o() + ((6.0F + 3 * var5) / 16.0F);
		if (!var1.D && var4.ay() && (var5 > 0) && (var4.aX().b <= var6)) {
			var4.P();
			this.a(var1, var2, var3, var5 - 1);
		}

	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else if (var6 == null) {
			return true;
		} else {
			int var11 = ((Integer) var3.b(a)).intValue();
			class_acm var12 = var6.b();
			if (var12 == class_acq.az) {
				if (var11 < 3) {
					if (!var4.bI.d) {
						var4.a(var5, (new class_aco(class_acq.ay)));
					}

					var4.b(class_nh.J);
					this.a(var1, var2, var3, 3);
				}

				return true;
			} else {
				class_aco var14;
				if (var12 == class_acq.bE) {
					if (var11 > 0) {
						if (!var4.bI.d) {
							var14 = class_adb.a(new class_aco(class_acq.bB), class_aee.a);
							var4.b(class_nh.K);
							if (--var6.b == 0) {
								var4.a(var5, var14);
							} else if (!var4.bq.a(var14)) {
								var4.a(var14, false);
							} else if (var4 instanceof class_lm) {
								((class_lm) var4).a(var4.br);
							}
						}

						this.a(var1, var2, var3, var11 - 1);
					}

					return true;
				} else {
					if ((var11 > 0) && (var12 instanceof class_aav)) {
						class_aav var13 = (class_aav) var12;
						if ((var13.d() == class_aav.class_a_in_class_aav.a) && var13.d_(var6)) {
							var13.c(var6);
							this.a(var1, var2, var3, var11 - 1);
							var4.b(class_nh.L);
							return true;
						}
					}

					if ((var11 > 0) && (var12 instanceof class_aaz) && (class_aog.c(var6) > 0)) {
						var14 = var6.k();
						var14.b = 1;
						class_aog.e(var14);
						var4.b(class_nh.M);
						if (!var4.bI.d) {
							--var6.b;
						}

						if (var6.b == 0) {
							var4.a(var5, var14);
						} else if (!var4.bq.a(var14)) {
							var4.a(var14, false);
						} else if (var4 instanceof class_lm) {
							((class_lm) var4).a(var4.br);
						}

						if (!var4.bI.d) {
							this.a(var1, var2, var3, var11 - 1);
						}

						return true;
					} else {
						return false;
					}
				}
			}
		}
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, int var4) {
		var1.a(var2, var3.a(a, Integer.valueOf(class_oa.a(var4, 0, 3))), 2);
		var1.f(var2, this);
	}

	@Override
	public void i(class_ago var1, class_cj var2) {
		if (var1.s.nextInt(20) == 1) {
			class_apn var3 = var1.p(var2);
			if (((Integer) var3.b(a)).intValue() < 3) {
				var1.a(var2, var3.a(a), 2);
			}

		}
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.bL;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_acq.bL);
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		return ((Integer) var1.p(var2).b(a)).intValue();
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
}
