package net.minecraft.server;


public class CommandSeed extends CommandAbstract {
	@Override
	public boolean canUse(ICommandListener var1) {
		return MinecraftServer.P().V() || super.canUse(var1);
	}

	@Override
	public String getCommand() {
		return "seed";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.seed.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		Object var3 = var1 instanceof class_yu ? ((class_yu) var1).o : MinecraftServer.P().a(0);
		var1.a(new class_fb("commands.seed.success", new Object[] { Long.valueOf(((class_ago) var3).L()) }));
	}
}
