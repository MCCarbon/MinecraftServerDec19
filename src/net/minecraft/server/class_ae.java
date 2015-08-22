package net.minecraft.server;

import java.util.List;

public class class_ae extends class_i {
	@Override
	public String c() {
		return "xp";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.xp.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length <= 0) {
			throw new class_cf("commands.xp.usage", new Object[0]);
		} else {
			String var3 = var2[0];
			boolean var4 = var3.endsWith("l") || var3.endsWith("L");
			if (var4 && (var3.length() > 1)) {
				var3 = var3.substring(0, var3.length() - 1);
			}

			int var5 = a(var3);
			boolean var6 = var5 < 0;
			if (var6) {
				var5 *= -1;
			}

			class_lm var7 = var2.length > 1 ? a(var1, var2[1]) : b(var1);
			if (var4) {
				var1.a(class_n.class_a_in_class_n.e, var7.bJ);
				if (var6) {
					var7.a(-var5);
					a(var1, this, "commands.xp.success.negative.levels", new Object[] { Integer.valueOf(var5), var7.e_() });
				} else {
					var7.a(var5);
					a(var1, this, "commands.xp.success.levels", new Object[] { Integer.valueOf(var5), var7.e_() });
				}
			} else {
				var1.a(class_n.class_a_in_class_n.e, var7.bK);
				if (var6) {
					throw new class_bz("commands.xp.failure.widthdrawXp", new Object[0]);
				}

				var7.m(var5);
				a(var1, this, "commands.xp.success", new Object[] { Integer.valueOf(var5), var7.e_() });
			}

		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 2 ? a(var2, this.d()) : null;
	}

	protected String[] d() {
		return MinecraftServer.P().M();
	}

	@Override
	public boolean b(String[] var1, int var2) {
		return var2 == 1;
	}
}
