package net.minecraft.server;

import java.util.List;

public class CommandTestFor extends CommandAbstract {
	@Override
	public String getCommand() {
		return "testfor";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.testfor.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 1) {
			throw new class_cf("commands.testfor.usage", new Object[0]);
		} else {
			Entity var3 = b(var1, var2[0]);
			class_dn var4 = null;
			if (var2.length >= 2) {
				try {
					var4 = class_ed.a(a(var2, 1));
				} catch (class_ec var6) {
					throw new class_bz("commands.testfor.tagError", new Object[] { var6.getMessage() });
				}
			}

			if (var4 != null) {
				class_dn var5 = a(var3);
				if (!class_dy.a(var4, var5, true)) {
					throw new class_bz("commands.testfor.failure", new Object[] { var3.e_() });
				}
			}

			a(var1, this, "commands.testfor.success", new Object[] { var3.e_() });
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
