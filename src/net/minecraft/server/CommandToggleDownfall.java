package net.minecraft.server;


public class CommandToggleDownfall extends CommandAbstract {
	@Override
	public String getCommand() {
		return "toggledownfall";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.downfall.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		this.d();
		a(var1, this, "commands.downfall.success", new Object[0]);
	}

	protected void d() {
		class_axt var1 = MinecraftServer.P().d[0].R();
		var1.b(!var1.o());
	}
}
