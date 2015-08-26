package net.minecraft.server;

import java.util.Arrays;
import java.util.List;

public class CommandTell extends CommandAbstract {
	@Override
	public List b() {
		return Arrays.asList(new String[] { "w", "msg" });
	}

	@Override
	public String getCommand() {
		return "tell";
	}

	@Override
	public int a() {
		return 0;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.message.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 2) {
			throw new class_cf("commands.message.usage", new Object[0]);
		} else {
			class_lm var3 = a(var1, var2[0]);
			if (var3 == var1) {
				throw new class_cd("commands.message.sameTarget", new Object[0]);
			} else {
				IChatBaseComponent var4 = b(var1, var2, 1, !(var1 instanceof class_yu));
				class_fb var5 = new class_fb("commands.message.display.incoming", new Object[] { var1.f_(), var4.f() });
				class_fb var6 = new class_fb("commands.message.display.outgoing", new Object[] { var3.f_(), var4.f() });
				var5.b().a(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
				var6.b().a(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
				var3.a(var5);
				var1.a(var6);
			}
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return a(var2, MinecraftServer.P().M());
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return var2 == 0;
	}
}
