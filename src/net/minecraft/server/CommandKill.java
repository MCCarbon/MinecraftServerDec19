package net.minecraft.server;

import java.util.List;

public class CommandKill extends CommandAbstract {
	@Override
	public String getCommand() {
		return "kill";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.kill.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length == 0) {
			class_lm var4 = b(var1);
			var4.I();
			a(var1, this, "commands.kill.successful", new Object[] { var4.f_() });
		} else {
			Entity var3 = b(var1, var2[0]);
			var3.I();
			a(var1, this, "commands.kill.successful", new Object[] { var3.f_() });
		}
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return var2 == 0;
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().M()) : null;
	}
}
