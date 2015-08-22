package net.minecraft.server;


public class class_ao extends class_i {
	@Override
	public String c() {
		return "list";
	}

	@Override
	public int a() {
		return 0;
	}

	@Override
	public String c(class_m var1) {
		return "commands.players.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		int var3 = MinecraftServer.P().K();
		var1.a(new class_fb("commands.players.list", new Object[] { Integer.valueOf(var3), Integer.valueOf(MinecraftServer.P().L()) }));
		var1.a(new class_fa(MinecraftServer.P().ar().b((var2.length > 0) && "uuids".equalsIgnoreCase(var2[0]))));
		var1.a(class_n.class_a_in_class_n.e, var3);
	}
}
