package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class CommandGamerule extends CommandAbstract {
	@Override
	public String getCommand() {
		return "gamerule";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.gamerule.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		class_agm var3 = this.d();
		String var4 = var2.length > 0 ? var2[0] : "";
		String var5 = var2.length > 1 ? a(var2, 1) : "";
		switch (var2.length) {
			case 0:
				var1.a(new class_fa(a(var3.b())));
				break;
			case 1:
				if (!var3.e(var4)) {
					throw new class_bz("commands.gamerule.norule", new Object[] { var4 });
				}

				String var6 = var3.a(var4);
				var1.a((new class_fa(var4)).a(" = ").a(var6));
				var1.a(class_n.class_a_in_class_n.e, var3.c(var4));
				break;
			default:
				if (var3.a(var4, class_agm.class_b_in_class_agm.b) && !"true".equals(var5) && !"false".equals(var5)) {
					throw new class_bz("commands.generic.boolean.invalid", new Object[] { var5 });
				}

				var3.a(var4, var5);
				a(var3, var4);
				a(var1, this, "commands.gamerule.success", new Object[0]);
		}

	}

	public static void a(class_agm var0, String var1) {
		if ("reducedDebugInfo".equals(var1)) {
			int var2 = var0.b(var1) ? 22 : 23;
			Iterator var3 = MinecraftServer.P().ar().v().iterator();

			while (var3.hasNext()) {
				class_lm var4 = (class_lm) var3.next();
				var4.a.a((new PacketPlayOutEntityStatus(var4, (byte) var2)));
			}
		}

	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		if (var2.length == 1) {
			return a(var2, this.d().b());
		} else {
			if (var2.length == 2) {
				class_agm var4 = this.d();
				if (var4.a(var2[0], class_agm.class_b_in_class_agm.b)) {
					return a(var2, (new String[] { "true", "false" }));
				}
			}

			return null;
		}
	}

	private class_agm d() {
		return MinecraftServer.P().a(0).S();
	}
}
