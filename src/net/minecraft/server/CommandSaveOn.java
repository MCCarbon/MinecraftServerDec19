package net.minecraft.server;


public class CommandSaveOn extends CommandAbstract {
	@Override
	public String getCommand() {
		return "save-on";
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.save-on.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		MinecraftServer var3 = MinecraftServer.P();
		boolean var4 = false;

		for (int var5 = 0; var5 < var3.d.length; ++var5) {
			if (var3.d[var5] != null) {
				class_ll var6 = var3.d[var5];
				if (var6.c) {
					var6.c = false;
					var4 = true;
				}
			}
		}

		if (var4) {
			a(var1, this, "commands.save.enabled", new Object[0]);
		} else {
			throw new class_bz("commands.save-on.alreadyOn", new Object[0]);
		}
	}
}
