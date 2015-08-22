package net.minecraft.server;


public class class_bl extends class_i {
	@Override
	public String c() {
		return "stop";
	}

	@Override
	public String c(class_m var1) {
		return "commands.stop.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if (MinecraftServer.P().d != null) {
			a(var1, this, "commands.stop.start", new Object[0]);
		}

		MinecraftServer.P().w();
	}
}
