package net.minecraft.server;

import java.util.Iterator;

public class CommandGamemodeDefault extends CommandGamemode {
	@Override
	public String getCommand() {
		return "defaultgamemode";
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.defaultgamemode.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length <= 0) {
			throw new class_cf("commands.defaultgamemode.usage", new Object[0]);
		} else {
			class_agr.class_a_in_class_agr var3 = h(var1, var2[0]);
			this.a(var3);
			a(var1, this, "commands.defaultgamemode.success", new Object[] { new class_fb("gameMode." + var3.b(), new Object[0]) });
		}
	}

	protected void a(class_agr.class_a_in_class_agr var1) {
		MinecraftServer var2 = MinecraftServer.P();
		var2.a(var1);
		class_lm var4;
		if (var2.az()) {
			for (Iterator var3 = MinecraftServer.P().ar().v().iterator(); var3.hasNext(); var4.O = 0.0F) {
				var4 = (class_lm) var3.next();
				var4.a(var1);
			}
		}

	}
}
