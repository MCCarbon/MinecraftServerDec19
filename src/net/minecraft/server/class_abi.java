package net.minecraft.server;


public class class_abi extends Item {
	private Block a;

	public class_abi(Block var1) {
		i = 1;
		a = var1;
		this.a(class_abp.f);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		boolean var5 = a == Blocks.AIR;
		class_ayl var6 = this.a(var2, var3, var5);
		if (var6 == null) {
			return new class_px(class_pw.b, var1);
		} else if (var6.a == class_ayl.class_a_in_class_ayl.b) {
			class_cj var7 = var6.a();
			if (!var2.a(var3, var7)) {
				return new class_px(class_pw.c, var1);
			} else if (var5) {
				if (!var3.a(var7.a(var6.b), var6.b, var1)) {
					return new class_px(class_pw.c, var1);
				} else {
					class_apn var10 = var2.p(var7);
					class_avq var9 = var10.c().v();
					if ((var9 == class_avq.h) && (((Integer) var10.b(class_alf.b)).intValue() == 0)) {
						var2.g(var7);
						var3.b(class_nh.c(Item.b(this)));
						return new class_px(class_pw.a, this.a(var1, var3, Items.az));
					} else if ((var9 == class_avq.i) && (((Integer) var10.b(class_alf.b)).intValue() == 0)) {
						var2.g(var7);
						var3.b(class_nh.c(Item.b(this)));
						return new class_px(class_pw.a, this.a(var1, var3, Items.aA));
					} else {
						return new class_px(class_pw.c, var1);
					}
				}
			} else {
				class_cj var8 = var7.a(var6.b);
				if (!var3.a(var8, var6.b, var1)) {
					return new class_px(class_pw.c, var1);
				} else if (this.a(var2, var8)) {
					var3.b(class_nh.c(Item.b(this)));
					return !var3.bI.d ? new class_px(class_pw.a, new class_aco(Items.ay)) : new class_px(class_pw.a, var1);
				} else {
					return new class_px(class_pw.c, var1);
				}
			}
		} else {
			return new class_px(class_pw.b, var1);
		}
	}

	private class_aco a(class_aco var1, class_yu var2, Item var3) {
		if (var2.bI.d) {
			return var1;
		} else if (--var1.b <= 0) {
			return new class_aco(var3);
		} else {
			if (!var2.bq.a(new class_aco(var3))) {
				var2.a(new class_aco(var3), false);
			}

			return var1;
		}
	}

	public boolean a(class_ago var1, class_cj var2) {
		if (a == Blocks.AIR) {
			return false;
		} else {
			class_avq var3 = var1.p(var2).c().v();
			boolean var4 = !var3.a();
			if (!var1.d(var2) && !var4) {
				return false;
			} else {
				if (var1.t.l() && (a == Blocks.FLOWING_WATER)) {
					int var5 = var2.n();
					int var6 = var2.o();
					int var7 = var2.p();
					var1.a(var5 + 0.5F, var6 + 0.5F, var7 + 0.5F, "random.fizz", 0.5F, 2.6F + ((var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F));

					for (int var8 = 0; var8 < 8; ++var8) {
						var1.a(class_cy.m, var5 + Math.random(), var6 + Math.random(), var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
					}
				} else {
					if (!var1.D && var4 && !var3.d()) {
						var1.b(var2, true);
					}

					var1.a(var2, a.S(), 3);
				}

				return true;
			}
		}
	}
}
