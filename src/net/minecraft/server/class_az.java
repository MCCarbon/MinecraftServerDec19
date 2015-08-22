package net.minecraft.server;


public class class_az extends class_i {
	@Override
	public String c() {
		return "save-off";
	}

	@Override
	public String c(class_m var1) {
		return "commands.save-off.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		MinecraftServer var3 = MinecraftServer.P();
		boolean var4 = false;

		for (int var5 = 0; var5 < var3.d.length; ++var5) {
			if (var3.d[var5] != null) {
				class_ll var6 = var3.d[var5];
				if (!var6.c) {
					var6.c = true;
					var4 = true;
				}
			}
		}

		if (var4) {
			a(var1, this, "commands.save.disabled", new Object[0]);
		} else {
			throw new class_bz("commands.save-off.alreadyOff", new Object[0]);
		}
	}
}
