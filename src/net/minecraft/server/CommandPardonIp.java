package net.minecraft.server;

import java.util.List;
import java.util.regex.Matcher;

public class CommandPardonIp extends CommandAbstract {
	@Override
	public String getCommand() {
		return "pardon-ip";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public boolean canUse(ICommandListener var1) {
		return MinecraftServer.P().ar().i().b() && super.canUse(var1);
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.unbanip.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length == 1) && (var2[0].length() > 1)) {
			Matcher var3 = CommandBanIp.a.matcher(var2[0]);
			if (var3.matches()) {
				MinecraftServer.P().ar().i().c(var2[0]);
				a(var1, this, "commands.unbanip.success", new Object[] { var2[0] });
			} else {
				throw new class_cc("commands.unbanip.invalid", new Object[0]);
			}
		} else {
			throw new class_cf("commands.unbanip.usage", new Object[0]);
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().ar().i().a()) : null;
	}
}
