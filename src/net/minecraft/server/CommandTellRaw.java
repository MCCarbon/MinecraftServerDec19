package net.minecraft.server;

import java.util.List;

import com.google.gson.JsonParseException;

public class CommandTellRaw extends CommandAbstract {
	@Override
	public String getCommand() {
		return "tellraw";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.tellraw.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 2) {
			throw new class_cf("commands.tellraw.usage", new Object[0]);
		} else {
			class_lm var3 = a(var1, var2[0]);
			String var4 = a(var2, 1);

			try {
				IChatBaseComponent var5 = IChatBaseComponent.class_a_in_class_eu.a(var4);
				var3.a(class_ev.a(var1, var5, var3));
			} catch (JsonParseException var6) {
				throw a(var6);
			}
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().M()) : null;
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return var2 == 0;
	}
}
