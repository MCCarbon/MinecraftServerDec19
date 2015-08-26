package net.minecraft.server;

import java.util.List;

public class CommandSay extends CommandAbstract {
	@Override
	public String getCommand() {
		return "say";
	}

	@Override
	public int a() {
		return 1;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.say.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length > 0) && (var2[0].length() > 0)) {
			class_eu var3 = b(var1, var2, 0, true);
			MinecraftServer.P().ar().a((new class_fb("chat.type.announcement", new Object[] { var1.f_(), var3 })));
		} else {
			throw new class_cf("commands.say.usage", new Object[0]);
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length >= 1 ? a(var2, MinecraftServer.P().M()) : null;
	}
}
