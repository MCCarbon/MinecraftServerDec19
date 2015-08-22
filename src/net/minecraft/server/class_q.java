package net.minecraft.server;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class class_q extends class_i {
	public static final Pattern a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	@Override
	public String c() {
		return "ban-ip";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public boolean a(ICommandListener var1) {
		return MinecraftServer.P().ar().i().b() && super.a(var1);
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.banip.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length >= 1) && (var2[0].length() > 1)) {
			class_eu var3 = var2.length >= 2 ? a(var1, var2, 1) : null;
			Matcher var4 = a.matcher(var2[0]);
			if (var4.matches()) {
				this.a(var1, var2[0], var3 == null ? null : var3.c());
			} else {
				class_lm var5 = MinecraftServer.P().ar().a(var2[0]);
				if (var5 == null) {
					throw new class_cd("commands.banip.invalid", new Object[0]);
				}

				this.a(var1, var5.x(), var3 == null ? null : var3.c());
			}

		} else {
			throw new class_cf("commands.banip.usage", new Object[0]);
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().M()) : null;
	}

	protected void a(ICommandListener var1, String var2, String var3) {
		class_mc var4 = new class_mc(var2, (Date) null, var1.e_(), (Date) null, var3);
		MinecraftServer.P().ar().i().a(var4);
		List var5 = MinecraftServer.P().ar().b(var2);
		String[] var6 = new String[var5.size()];
		int var7 = 0;

		class_lm var9;
		for (Iterator var8 = var5.iterator(); var8.hasNext(); var6[var7++] = var9.e_()) {
			var9 = (class_lm) var8.next();
			var9.a.c("You have been IP banned.");
		}

		if (var5.isEmpty()) {
			a(var1, this, "commands.banip.success", new Object[] { var2 });
		} else {
			a(var1, this, "commands.banip.success.players", new Object[] { var2, a(var6) });
		}

	}
}
