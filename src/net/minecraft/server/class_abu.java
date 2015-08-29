package net.minecraft.server;


public class class_abu extends Item {
	public static final int[] a = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };

	public class_abu() {
		this.a(true);
		this.e(0);
		this.a(class_abp.l);
	}

	@Override
	public String e_(class_aco var1) {
		int var2 = var1.i();
		return super.a() + "." + class_abt.a(var2).d();
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (!var2.a(var4.a(var6), var6, var1)) {
			return class_pw.c;
		} else {
			class_abt var10 = class_abt.a(var1.i());
			if (var10 == class_abt.a) {
				if (a(var1, var3, var4)) {
					if (!var3.D) {
						var3.b(2005, var4, 0);
					}

					return class_pw.a;
				}
			} else if (var10 == class_abt.m) {
				class_apn var11 = var3.p(var4);
				Block var12 = var11.c();
				if ((var12 == Blocks.LOG) && (var11.b(class_alv.b) == class_aly.class_a_in_class_aly.d)) {
					if ((var6 != class_cq.a) && (var6 != class_cq.b)) {
						var4 = var4.a(var6);
						if (var3.d(var4)) {
							class_apn var13 = Blocks.COCOA.a(var3, var4, var6, var7, var8, var9, 0, var2);
							var3.a(var4, var13, 2);
							if (!var2.bI.d) {
								--var1.b;
							}
						}

						return class_pw.a;
					}

					return class_pw.c;
				}

				return class_pw.c;
			}

			return class_pw.b;
		}
	}

	public static boolean a(class_aco var0, class_ago var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		if (var3.c() instanceof class_ain) {
			class_ain var4 = (class_ain) var3.c();
			if (var4.a(var1, var2, var3, var1.D)) {
				if (!var1.D) {
					if (var4.a(var1, var1.s, var2, var3)) {
						var4.b(var1, var1.s, var2, var3);
					}

					--var0.b;
				}

				return true;
			}
		}

		return false;
	}

	@Override
	public boolean a(class_aco var1, class_yu var2, EntityLiving var3, class_pu var4) {
		if (var3 instanceof EntitySheep) {
			EntitySheep var5 = (EntitySheep) var3;
			class_abt var6 = class_abt.a(var1.i());
			if (!var5.cF() && (var5.cE() != var6)) {
				var5.b(var6);
				--var1.b;
			}

			return true;
		} else {
			return false;
		}
	}
}
