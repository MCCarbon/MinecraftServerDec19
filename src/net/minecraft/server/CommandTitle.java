package net.minecraft.server;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonParseException;

public class CommandTitle extends CommandAbstract {
	private static final Logger a = LogManager.getLogger();

	@Override
	public String getCommand() {
		return "title";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.title.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 2) {
			throw new class_cf("commands.title.usage", new Object[0]);
		} else {
			if (var2.length < 3) {
				if ("title".equals(var2[1]) || "subtitle".equals(var2[1])) {
					throw new class_cf("commands.title.usage.title", new Object[0]);
				}

				if ("times".equals(var2[1])) {
					throw new class_cf("commands.title.usage.times", new Object[0]);
				}
			}

			class_lm var3 = a(var1, var2[0]);
			class_hw.class_a_in_class_hw var4 = class_hw.class_a_in_class_hw.a(var2[1]);
			if ((var4 != class_hw.class_a_in_class_hw.d) && (var4 != class_hw.class_a_in_class_hw.e)) {
				if (var4 == class_hw.class_a_in_class_hw.c) {
					if (var2.length != 5) {
						throw new class_cf("commands.title.usage", new Object[0]);
					} else {
						int var11 = a(var2[2]);
						int var12 = a(var2[3]);
						int var13 = a(var2[4]);
						class_hw var8 = new class_hw(var11, var12, var13);
						var3.a.a(var8);
						a(var1, this, "commands.title.success", new Object[0]);
					}
				} else if (var2.length < 3) {
					throw new class_cf("commands.title.usage", new Object[0]);
				} else {
					String var10 = a(var2, 2);

					class_eu var6;
					try {
						var6 = class_eu.class_a_in_class_eu.a(var10);
					} catch (JsonParseException var9) {
						throw a(var9);
					}

					class_hw var7 = new class_hw(var4, class_ev.a(var1, var6, var3));
					var3.a.a(var7);
					a(var1, this, "commands.title.success", new Object[0]);
				}
			} else if (var2.length != 2) {
				throw new class_cf("commands.title.usage", new Object[0]);
			} else {
				class_hw var5 = new class_hw(var4, (class_eu) null);
				var3.a.a(var5);
				a(var1, this, "commands.title.success", new Object[0]);
			}
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().M()) : (var2.length == 2 ? a(var2, class_hw.class_a_in_class_hw.a()) : null);
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return var2 == 0;
	}
}
