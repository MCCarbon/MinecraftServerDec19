package net.minecraft.server;

import java.util.List;

public class class_an extends class_i {
	@Override
	public String c() {
		return "banlist";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public boolean a(ICommandListener var1) {
		return (MinecraftServer.P().ar().i().b() || MinecraftServer.P().ar().h().b()) && super.a(var1);
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.banlist.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length >= 1) && var2[0].equalsIgnoreCase("ips")) {
			var1.a(new class_fb("commands.banlist.ips", new Object[] { Integer.valueOf(MinecraftServer.P().ar().i().a().length) }));
			var1.a(new class_fa(a(MinecraftServer.P().ar().i().a())));
		} else {
			var1.a(new class_fb("commands.banlist.players", new Object[] { Integer.valueOf(MinecraftServer.P().ar().h().a().length) }));
			var1.a(new class_fa(a(MinecraftServer.P().ar().h().a())));
		}

	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, new String[] { "players", "ips" }) : null;
	}
}
