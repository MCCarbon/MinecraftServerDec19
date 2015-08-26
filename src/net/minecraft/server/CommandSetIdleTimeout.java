package net.minecraft.server;


public class CommandSetIdleTimeout extends CommandAbstract {
	@Override
	public String getCommand() {
		return "setidletimeout";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.setidletimeout.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length != 1) {
			throw new class_cf("commands.setidletimeout.usage", new Object[0]);
		} else {
			int var3 = a(var2[0], 0);
			MinecraftServer.P().d(var3);
			a(var1, this, "commands.setidletimeout.success", new Object[] { Integer.valueOf(var3) });
		}
	}
}
