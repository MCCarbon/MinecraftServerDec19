package net.minecraft.server;

import java.util.UUID;

public class class_ads extends Item {
	public class_ads() {
		this.a(class_abp.f);
	}

	@Override
	public String a(class_aco var1) {
		String var2 = ("" + class_di.a(this.a() + ".name")).trim();
		String var3 = h(var1);
		if (var3 != null) {
			var2 = var2 + " " + class_di.a("entity." + var3 + ".name");
		}

		return var2;
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (var3.D) {
			return class_pw.a;
		} else if (!var2.a(var4.a(var6), var6, var1)) {
			return class_pw.c;
		} else {
			class_apn var10 = var3.p(var4);
			if (var10.c() == Blocks.ac) {
				TileEntity var11 = var3.s(var4);
				if (var11 instanceof class_aox) {
					class_agf var12 = ((class_aox) var11).b();
					var12.a(h(var1));
					var11.o_();
					var3.h(var4);
					if (!var2.bI.d) {
						--var1.b;
					}

					return class_pw.a;
				}
			}

			var4 = var4.a(var6);
			double var14 = 0.0D;
			if ((var6 == class_cq.b) && (var10 instanceof class_akb)) {
				var14 = 0.5D;
			}

			Entity var13 = a(var3, h(var1), var4.n() + 0.5D, var4.o() + var14, var4.p() + 0.5D);
			if (var13 != null) {
				if ((var13 instanceof class_rg) && var1.s()) {
					var13.c(var1.q());
				}

				a(var3, var2, var1, var13);
				if (!var2.bI.d) {
					--var1.b;
				}
			}

			return class_pw.a;
		}
	}

	public static void a(class_ago var0, class_yu var1, class_aco var2, Entity var3) {
		MinecraftServer var4 = MinecraftServer.P();
		if ((var4 != null) && (var3 != null)) {
			class_dn var5 = var2.o();
			if ((var5 != null) && var5.b("EntityTag", 10)) {
				if (!var0.D && var3.bc() && ((var1 == null) || !var4.ar().h(var1.cl()))) {
					return;
				}

				class_dn var6 = new class_dn();
				var3.e(var6);
				UUID var7 = var3.aQ();
				var6.a(var5.o("EntityTag"));
				var3.a(var7);
				var3.f(var6);
			}

		}
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (var2.D) {
			return new class_px(class_pw.b, var1);
		} else {
			class_ayl var5 = this.a(var2, var3, true);
			if ((var5 != null) && (var5.a == class_ayl.class_a_in_class_ayl.b)) {
				class_cj var6 = var5.a();
				if (!(var2.p(var6).c() instanceof class_alf)) {
					return new class_px(class_pw.b, var1);
				} else if (var2.a(var3, var6) && var3.a(var6, var5.b, var1)) {
					Entity var7 = a(var2, h(var1), var6.n() + 0.5D, var6.o() + 0.5D, var6.p() + 0.5D);
					if (var7 == null) {
						return new class_px(class_pw.b, var1);
					} else {
						if ((var7 instanceof class_rg) && var1.s()) {
							var7.c(var1.q());
						}

						a(var2, var3, var1, var7);
						if (!var3.bI.d) {
							--var1.b;
						}

						var3.b(class_nh.c(Item.b(this)));
						return new class_px(class_pw.a, var1);
					}
				} else {
					return new class_px(class_pw.c, var1);
				}
			} else {
				return new class_px(class_pw.b, var1);
			}
		}
	}

	public static Entity a(class_ago var0, String var1, double var2, double var4, double var6) {
		if ((var1 != null) && EntityTypes.a.containsKey(var1)) {
			Entity var8 = null;

			for (int var9 = 0; var9 < 1; ++var9) {
				var8 = EntityTypes.b(var1, var0);
				if (var8 instanceof class_rg) {
					class_rh var10 = (class_rh) var8;
					var8.b(var2, var4, var6, class_oa.g(var0.s.nextFloat() * 360.0F), 0.0F);
					var10.aO = var10.y;
					var10.aM = var10.y;
					var10.a(var0.E(new class_cj(var10)), (class_rj) null);
					var0.a(var8);
					var10.z();
				}
			}

			return var8;
		} else {
			return null;
		}
	}

	public static String h(class_aco var0) {
		class_dn var1 = var0.o();
		if (var1 == null) {
			return null;
		} else if (!var1.b("EntityTag", 10)) {
			return null;
		} else {
			class_dn var2 = var1.o("EntityTag");
			return !var2.b("id", 8) ? null : var2.l("id");
		}
	}
}
