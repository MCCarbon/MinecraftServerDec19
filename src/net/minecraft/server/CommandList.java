package net.minecraft.server;


public class CommandList extends CommandAbstract {
	@Override
	public String getCommand() {
		return "list";
	}

	@Override
	public int a() {
		return 0;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.players.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		int var3 = MinecraftServer.P().K();
		var1.a(new class_fb("commands.players.list", new Object[] { Integer.valueOf(var3), Integer.valueOf(MinecraftServer.P().L()) }));
		var1.a(new class_fa(MinecraftServer.P().ar().b((var2.length > 0) && "uuids".equalsIgnoreCase(var2[0]))));
		var1.a(class_n.class_a_in_class_n.e, var3);
	}
}
