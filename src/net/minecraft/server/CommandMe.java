package net.minecraft.server;

import java.util.List;

public class CommandMe extends CommandAbstract {
	@Override
	public String getCommand() {
		return "me";
	}

	@Override
	public int a() {
		return 0;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.me.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length <= 0) {
			throw new class_cf("commands.me.usage", new Object[0]);
		} else {
			IChatBaseComponent var3 = b(var1, var2, 0, !(var1 instanceof class_yu));
			MinecraftServer.P().ar().a((new class_fb("chat.type.emote", new Object[] { var1.f_(), var3 })));
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return a(var2, MinecraftServer.P().M());
	}
}
