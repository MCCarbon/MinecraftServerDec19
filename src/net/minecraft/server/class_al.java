package net.minecraft.server;

import java.util.List;

public class class_al extends class_i {
	@Override
	public String c() {
		return "kick";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public String c(class_m var1) {
		return "commands.kick.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if ((var2.length > 0) && (var2[0].length() > 1)) {
			class_lm var3 = MinecraftServer.P().ar().a(var2[0]);
			String var4 = "Kicked by an operator.";
			boolean var5 = false;
			if (var3 == null) {
				throw new class_cd();
			} else {
				if (var2.length >= 2) {
					var4 = a(var1, var2, 1).c();
					var5 = true;
				}

				var3.a.c(var4);
				if (var5) {
					a(var1, this, "commands.kick.success.reason", new Object[] { var3.e_(), var4 });
				} else {
					a(var1, this, "commands.kick.success", new Object[] { var3.e_() });
				}

			}
		} else {
			throw new class_cf("commands.kick.usage", new Object[0]);
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return var2.length >= 1 ? a(var2, MinecraftServer.P().M()) : null;
	}
}
