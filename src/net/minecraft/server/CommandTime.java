package net.minecraft.server;

import java.util.List;

public class CommandTime extends CommandAbstract {
	@Override
	public String getCommand() {
		return "time";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.time.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length > 1) {
			int var3;
			if (var2[0].equals("set")) {
				if (var2[1].equals("day")) {
					var3 = 1000;
				} else if (var2[1].equals("night")) {
					var3 = 13000;
				} else {
					var3 = a(var2[1], 0);
				}

				this.a(var1, var3);
				a(var1, this, "commands.time.set", new Object[] { Integer.valueOf(var3) });
				return;
			}

			if (var2[0].equals("add")) {
				var3 = a(var2[1], 0);
				this.b(var1, var3);
				a(var1, this, "commands.time.added", new Object[] { Integer.valueOf(var3) });
				return;
			}

			if (var2[0].equals("query")) {
				if (var2[1].equals("daytime")) {
					var3 = (int) (var1.e().N() % 24000L);
					var1.a(class_n.class_a_in_class_n.e, var3);
					a(var1, this, "commands.time.query", new Object[] { Integer.valueOf(var3) });
					return;
				}

				if (var2[1].equals("gametime")) {
					var3 = (int) (var1.e().M() % 2147483647L);
					var1.a(class_n.class_a_in_class_n.e, var3);
					a(var1, this, "commands.time.query", new Object[] { Integer.valueOf(var3) });
					return;
				}
			}
		}

		throw new class_cf("commands.time.usage", new Object[0]);
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, new String[] { "set", "add", "query" }) : ((var2.length == 2) && var2[0].equals("set") ? a(var2, new String[] { "day", "night" }) : ((var2.length == 2) && var2[0].equals("query") ? a(var2, new String[] { "daytime", "gametime" }) : null));
	}

	protected void a(ICommandListener var1, int var2) {
		for (int var3 = 0; var3 < MinecraftServer.P().d.length; ++var3) {
			MinecraftServer.P().d[var3].b((long) var2);
		}

	}

	protected void b(ICommandListener var1, int var2) {
		for (int var3 = 0; var3 < MinecraftServer.P().d.length; ++var3) {
			class_ll var4 = MinecraftServer.P().d[var3];
			var4.b(var4.N() + var2);
		}

	}
}
