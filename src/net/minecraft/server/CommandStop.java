package net.minecraft.server;


public class CommandStop extends CommandAbstract {
	@Override
	public String getCommand() {
		return "stop";
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.stop.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (MinecraftServer.P().d != null) {
			a(var1, this, "commands.stop.start", new Object[0]);
		}

		MinecraftServer.P().w();
	}
}
