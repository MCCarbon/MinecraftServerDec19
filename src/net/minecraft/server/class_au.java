package net.minecraft.server;

import java.util.List;

public class class_au extends class_i {
	@Override
	public String c() {
		return "particle";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(class_m var1) {
		return "commands.particle.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if (var2.length < 8) {
			throw new class_cf("commands.particle.usage", new Object[0]);
		} else {
			boolean var3 = false;
			class_cy var4 = null;
			class_cy[] var5 = class_cy.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				class_cy var8 = var5[var7];
				if (var8.f()) {
					if (var2[0].startsWith(var8.b())) {
						var3 = true;
						var4 = var8;
						break;
					}
				} else if (var2[0].equals(var8.b())) {
					var3 = true;
					var4 = var8;
					break;
				}
			}

			if (!var3) {
				throw new class_bz("commands.particle.notFound", new Object[] { var2[0] });
			} else {
				String var31 = var2[0];
				class_aym var32 = var1.d();
				double var33 = ((float) b(var32.a, var2[1], true));
				double var9 = ((float) b(var32.b, var2[2], true));
				double var11 = ((float) b(var32.c, var2[3], true));
				double var13 = ((float) c(var2[4]));
				double var15 = ((float) c(var2[5]));
				double var17 = ((float) c(var2[6]));
				double var19 = ((float) c(var2[7]));
				int var21 = 0;
				if (var2.length > 8) {
					var21 = a(var2[8], 0);
				}

				boolean var22 = false;
				if ((var2.length > 9) && "force".equals(var2[9])) {
					var22 = true;
				}

				class_lm var23;
				if (var2.length > 10) {
					var23 = a(var1, var2[10]);
				} else {
					var23 = null;
				}

				class_ago var24 = var1.e();
				if (var24 instanceof class_ll) {
					class_ll var25 = (class_ll) var24;
					int[] var26 = new int[var4.d()];
					if (var4.f()) {
						String[] var27 = var2[0].split("_", 3);

						for (int var28 = 1; var28 < var27.length; ++var28) {
							try {
								var26[var28 - 1] = Integer.parseInt(var27[var28]);
							} catch (NumberFormatException var30) {
								throw new class_bz("commands.particle.notFound", new Object[] { var2[0] });
							}
						}
					}

					if (var23 == null) {
						var25.a(var4, var22, var33, var9, var11, var21, var13, var15, var17, var19, var26);
					} else {
						var25.a(var23, var4, var22, var33, var9, var11, var21, var13, var15, var17, var19, var26);
					}

					a(var1, this, "commands.particle.success", new Object[] { var31, Integer.valueOf(Math.max(var21, 1)) });
				}

			}
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, class_cy.a()) : ((var2.length > 1) && (var2.length <= 4) ? a(var2, 1, var3) : (var2.length == 10 ? a(var2, new String[] { "normal", "force" }) : (var2.length == 11 ? a(var2, MinecraftServer.P().M()) : null)));
	}

	@Override
	public boolean b(String[] var1, int var2) {
		return var2 == 10;
	}
}
