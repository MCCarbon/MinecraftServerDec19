package net.minecraft.server;


public class class_abz extends Item {
	public class_abz() {
		this.a(class_abp.f);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		class_apn var10 = var3.p(var4);
		if (var2.a(var4.a(var6), var6, var1) && (var10.c() == Blocks.END_PORTAL_FRAME) && !((Boolean) var10.b(class_ajv.b)).booleanValue()) {
			if (var3.D) {
				return class_pw.a;
			} else {
				var3.a(var4, var10.a(class_ajv.b, Boolean.valueOf(true)), 2);
				var3.f(var4, Blocks.END_PORTAL_FRAME);
				--var1.b;

				for (int var11 = 0; var11 < 16; ++var11) {
					double var12 = var4.n() + ((5.0F + (h.nextFloat() * 6.0F)) / 16.0F);
					double var14 = var4.o() + 0.8125F;
					double var16 = var4.p() + ((5.0F + (h.nextFloat() * 6.0F)) / 16.0F);
					double var18 = 0.0D;
					double var20 = 0.0D;
					double var22 = 0.0D;
					var3.a(class_cy.l, var12, var14, var16, 0.0D, 0.0D, 0.0D, new int[0]);
				}

				class_cq var24 = (class_cq) var10.b(class_ajv.a);
				int var25 = 0;
				int var13 = 0;
				boolean var26 = false;
				boolean var15 = true;
				class_cq var27 = var24.e();

				for (int var17 = -2; var17 <= 2; ++var17) {
					class_cj var29 = var4.a(var27, var17);
					class_apn var19 = var3.p(var29);
					if (var19.c() == Blocks.END_PORTAL_FRAME) {
						if (!((Boolean) var19.b(class_ajv.b)).booleanValue()) {
							var15 = false;
							break;
						}

						var13 = var17;
						if (!var26) {
							var25 = var17;
							var26 = true;
						}
					}
				}

				if (var15 && (var13 == (var25 + 2))) {
					class_cj var28 = var4.a(var24, 4);

					int var30;
					for (var30 = var25; var30 <= var13; ++var30) {
						class_cj var31 = var28.a(var27, var30);
						class_apn var33 = var3.p(var31);
						if ((var33.c() != Blocks.END_PORTAL_FRAME) || !((Boolean) var33.b(class_ajv.b)).booleanValue()) {
							var15 = false;
							break;
						}
					}

					int var32;
					class_cj var34;
					for (var30 = var25 - 1; var30 <= (var13 + 1); var30 += 4) {
						var28 = var4.a(var27, var30);

						for (var32 = 1; var32 <= 3; ++var32) {
							var34 = var28.a(var24, var32);
							class_apn var21 = var3.p(var34);
							if ((var21.c() != Blocks.END_PORTAL_FRAME) || !((Boolean) var21.b(class_ajv.b)).booleanValue()) {
								var15 = false;
								break;
							}
						}
					}

					if (var15) {
						for (var30 = var25; var30 <= var13; ++var30) {
							var28 = var4.a(var27, var30);

							for (var32 = 1; var32 <= 3; ++var32) {
								var34 = var28.a(var24, var32);
								var3.a(var34, Blocks.END_PORTAL.getBlockData(), 2);
							}
						}
					}
				}

				return class_pw.a;
			}
		} else {
			return class_pw.c;
		}
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		class_ayl var5 = this.a(var2, var3, false);
		if ((var5 != null) && (var5.a == class_ayl.class_a_in_class_ayl.b) && (var2.p(var5.a()).c() == Blocks.END_PORTAL_FRAME)) {
			return new class_px(class_pw.b, var1);
		} else {
			if (!var2.D) {
				class_cj var6 = var2.a("Stronghold", new class_cj(var3));
				if (var6 != null) {
					EntityEnderSignal var7 = new EntityEnderSignal(var2, var3.s, var3.t, var3.u);
					var7.a(var6);
					var2.a(var7);
					var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / ((h.nextFloat() * 0.4F) + 0.8F));
					var2.a((class_yu) null, 1002, new class_cj(var3), 0);
					if (!var3.bI.d) {
						--var1.b;
					}

					var3.b(StatisticList.c(Item.b(this)));
					return new class_px(class_pw.a, var1);
				}
			}

			return new class_px(class_pw.c, var1);
		}
	}
}
