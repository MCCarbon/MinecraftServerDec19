package net.minecraft.server;

import java.util.List;

public class CommandSetWorldSpawn extends CommandAbstract {
	@Override
	public String getCommand() {
		return "setworldspawn";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.setworldspawn.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		class_cj var3;
		if (var2.length == 0) {
			var3 = b(var1).c();
		} else {
			if ((var2.length != 3) || (var1.e() == null)) {
				throw new class_cf("commands.setworldspawn.usage", new Object[0]);
			}

			var3 = a(var1, var2, 0, true);
		}

		var1.e().B(var3);
		MinecraftServer.P().ar().a((new PacketPlayOutSpawnPosition(var3)));
		a(var1, this, "commands.setworldspawn.success", new Object[] { Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()) });
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return (var2.length > 0) && (var2.length <= 3) ? a(var2, 0, var3) : null;
	}
}
