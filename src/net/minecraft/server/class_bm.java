package net.minecraft.server;

import java.util.List;

public class class_bm extends class_i {
	@Override
	public String c() {
		return "summon";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.summon.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 1) {
			throw new class_cf("commands.summon.usage", new Object[0]);
		} else {
			String var3 = var2[0];
			class_cj var4 = var1.c();
			class_aym var5 = var1.d();
			double var6 = var5.a;
			double var8 = var5.b;
			double var10 = var5.c;
			if (var2.length >= 4) {
				var6 = b(var6, var2[1], true);
				var8 = b(var8, var2[2], false);
				var10 = b(var10, var2[3], true);
				var4 = new class_cj(var6, var8, var10);
			}

			class_ago var12 = var1.e();
			if (!var12.e(var4)) {
				throw new class_bz("commands.summon.outOfWorld", new Object[0]);
			} else if ("LightningBolt".equals(var3)) {
				var12.d((new class_xc(var12, var6, var8, var10)));
				a(var1, this, "commands.summon.success", new Object[0]);
			} else {
				class_dn var13 = new class_dn();
				boolean var14 = false;
				if (var2.length >= 5) {
					class_eu var15 = a(var1, var2, 4);

					try {
						var13 = class_ed.a(var15.c());
						var14 = true;
					} catch (class_ec var20) {
						throw new class_bz("commands.summon.tagError", new Object[] { var20.getMessage() });
					}
				}

				var13.a("id", var3);

				Entity var21;
				try {
					var21 = EntityTypes.a(var13, var12);
				} catch (RuntimeException var19) {
					throw new class_bz("commands.summon.failed", new Object[0]);
				}

				if (var21 == null) {
					throw new class_bz("commands.summon.failed", new Object[0]);
				} else {
					var21.b(var6, var8, var10, var21.y, var21.z);
					if (!var14 && (var21 instanceof class_rh)) {
						((class_rh) var21).a(var12.E(new class_cj(var21)), (class_rj) null);
					}

					if (!var12.a(var21)) {
						throw new class_bz("commands.summon.failed", new Object[0]);
					} else {
						Entity var16 = var21;

						for (class_dn var17 = var13; (var16 != null) && var17.b("Riding", 10); var17 = var17.o("Riding")) {
							Entity var18 = EntityTypes.a(var17.o("Riding"), var12);
							if (var18 != null) {
								var18.b(var6, var8, var10, var18.y, var18.z);
								var12.a(var18);
								var16.a(var18);
							}

							var16 = var18;
						}

						a(var1, this, "commands.summon.success", new Object[0]);
					}
				}
			}
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, EntityTypes.b()) : ((var2.length > 1) && (var2.length <= 4) ? a(var2, 1, var3) : null);
	}
}
