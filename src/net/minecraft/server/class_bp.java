package net.minecraft.server;

import java.util.List;

public class class_bp extends class_i {
	@Override
	public String c() {
		return "testforblock";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(class_m var1) {
		return "commands.testforblock.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if (var2.length < 4) {
			throw new class_cf("commands.testforblock.usage", new Object[0]);
		} else {
			var1.a(class_n.class_a_in_class_n.b, 0);
			class_cj var3 = a(var1, var2, 0, false);
			class_ail var4 = class_ail.b(var2[3]);
			if (var4 == null) {
				throw new class_cb("commands.setblock.notFound", new Object[] { var2[3] });
			} else {
				int var5 = -1;
				if (var2.length >= 5) {
					var5 = a(var2[4], -1, 15);
				}

				class_ago var6 = var1.e();
				if (!var6.e(var3)) {
					throw new class_bz("commands.testforblock.outOfWorld", new Object[0]);
				} else {
					class_dn var7 = new class_dn();
					boolean var8 = false;
					if ((var2.length >= 6) && var4.B()) {
						String var9 = a(var1, var2, 5).c();

						try {
							var7 = class_ed.a(var9);
							var8 = true;
						} catch (class_ec var13) {
							throw new class_bz("commands.setblock.tagError", new Object[] { var13.getMessage() });
						}
					}

					class_apn var14 = var6.p(var3);
					class_ail var10 = var14.c();
					if (var10 != var4) {
						throw new class_bz("commands.testforblock.failed.tile", new Object[] { Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()), var10.f(), var4.f() });
					} else {
						if (var5 > -1) {
							int var11 = var14.c().c(var14);
							if (var11 != var5) {
								throw new class_bz("commands.testforblock.failed.data", new Object[] { Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()), Integer.valueOf(var11), Integer.valueOf(var5) });
							}
						}

						if (var8) {
							class_aoi var15 = var6.s(var3);
							if (var15 == null) {
								throw new class_bz("commands.testforblock.failed.tileEntity", new Object[] { Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()) });
							}

							class_dn var12 = new class_dn();
							var15.b(var12);
							if (!class_dy.a(var7, var12, true)) {
								throw new class_bz("commands.testforblock.failed.nbt", new Object[] { Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()) });
							}
						}

						var1.a(class_n.class_a_in_class_n.b, 1);
						a(var1, this, "commands.testforblock.success", new Object[] { Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()) });
					}
				}
			}
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return (var2.length > 0) && (var2.length <= 3) ? a(var2, 0, var3) : (var2.length == 4 ? a(var2, class_ail.c.c()) : null);
	}
}
