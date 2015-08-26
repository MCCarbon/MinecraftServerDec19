package net.minecraft.server;

import java.util.UUID;

public class CommandEntityData extends CommandAbstract {
	@Override
	public String getCommand() {
		return "entitydata";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.entitydata.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 2) {
			throw new class_cf("commands.entitydata.usage", new Object[0]);
		} else {
			Entity var3 = b(var1, var2[0]);
			if (var3 instanceof class_yu) {
				throw new class_bz("commands.entitydata.noPlayers", new Object[] { var3.f_() });
			} else {
				class_dn var4 = a(var3);
				class_dn var5 = (class_dn) var4.b();

				class_dn var6;
				try {
					var6 = class_ed.a(a(var1, var2, 1).c());
				} catch (class_ec var8) {
					throw new class_bz("commands.entitydata.tagError", new Object[] { var8.getMessage() });
				}

				UUID var7 = var3.aQ();
				var4.a(var6);
				var3.a(var7);
				if (var4.equals(var5)) {
					throw new class_bz("commands.entitydata.failed", new Object[] { var4.toString() });
				} else {
					var3.f(var4);
					a(var1, this, "commands.entitydata.success", new Object[] { var4.toString() });
				}
			}
		}
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return var2 == 0;
	}
}
