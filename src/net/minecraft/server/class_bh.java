package net.minecraft.server;

import java.util.List;

public class class_bh extends class_i {
	@Override
	public String c() {
		return "spawnpoint";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.spawnpoint.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length > 1) && (var2.length < 4)) {
			throw new class_cf("commands.spawnpoint.usage", new Object[0]);
		} else {
			class_lm var3 = var2.length > 0 ? a(var1, var2[0]) : b(var1);
			class_cj var4 = var2.length > 3 ? a(var1, var2, 1, true) : var3.c();
			if (var3.o != null) {
				var3.a(var4, true);
				a(var1, this, "commands.spawnpoint.success", new Object[] { var3.e_(), Integer.valueOf(var4.n()), Integer.valueOf(var4.o()), Integer.valueOf(var4.p()) });
			}

		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().M()) : ((var2.length > 1) && (var2.length <= 4) ? a(var2, 1, var3) : null);
	}

	@Override
	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
