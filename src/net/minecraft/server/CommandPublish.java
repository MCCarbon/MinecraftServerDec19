package net.minecraft.server;


public class CommandPublish extends CommandAbstract {
	@Override
	public String getCommand() {
		return "publish";
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.publish.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		String var3 = MinecraftServer.P().a(class_agr.class_a_in_class_agr.b, false);
		if (var3 != null) {
			a(var1, this, "commands.publish.started", new Object[] { var3 });
		} else {
			a(var1, this, "commands.publish.failed", new Object[0]);
		}

	}
}
