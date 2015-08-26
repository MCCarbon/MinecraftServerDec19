package net.minecraft.server;

import java.util.List;

public class class_be extends class_i {
	@Override
	public String c() {
		return "setblock";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.setblock.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 4) {
			throw new class_cf("commands.setblock.usage", new Object[0]);
		} else {
			var1.a(class_n.class_a_in_class_n.b, 0);
			class_cj var3 = a(var1, var2, 0, false);
			Block var4 = class_i.g(var1, var2[3]);
			int var5 = 0;
			if (var2.length >= 5) {
				var5 = a(var2[4], 0, 15);
			}

			class_ago var6 = var1.e();
			if (!var6.e(var3)) {
				throw new class_bz("commands.setblock.outOfWorld", new Object[0]);
			} else {
				class_dn var7 = new class_dn();
				boolean var8 = false;
				if ((var2.length >= 7) && var4.B()) {
					String var9 = a(var1, var2, 6).c();

					try {
						var7 = class_ed.a(var9);
						var8 = true;
					} catch (class_ec var12) {
						throw new class_bz("commands.setblock.tagError", new Object[] { var12.getMessage() });
					}
				}

				if (var2.length >= 6) {
					if (var2[5].equals("destroy")) {
						var6.b(var3, true);
						if (var4 == Blocks.AIR) {
							a(var1, this, "commands.setblock.success", new Object[0]);
							return;
						}
					} else if (var2[5].equals("keep") && !var6.d(var3)) {
						throw new class_bz("commands.setblock.noChange", new Object[0]);
					}
				}

				TileEntity var13 = var6.s(var3);
				if (var13 != null) {
					if (var13 instanceof class_pp) {
						((class_pp) var13).l();
					}

					var6.a(var3, Blocks.AIR.S(), var4 == Blocks.AIR ? 2 : 4);
				}

				class_apn var10 = var4.a(var5);
				if (!var6.a(var3, var10, 2)) {
					throw new class_bz("commands.setblock.noChange", new Object[0]);
				} else {
					if (var8) {
						TileEntity var11 = var6.s(var3);
						if (var11 != null) {
							var7.a("x", var3.n());
							var7.a("y", var3.o());
							var7.a("z", var3.p());
							var11.a(var7);
						}
					}

					var6.c(var3, var10.c());
					var1.a(class_n.class_a_in_class_n.b, 1);
					a(var1, this, "commands.setblock.success", new Object[0]);
				}
			}
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return (var2.length > 0) && (var2.length <= 3) ? a(var2, 0, var3) : (var2.length == 4 ? a(var2, Block.c.c()) : (var2.length == 6 ? a(var2, new String[] { "replace", "destroy", "keep" }) : null));
	}
}
