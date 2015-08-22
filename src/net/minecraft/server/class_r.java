package net.minecraft.server;

import java.util.Date;
import java.util.List;

import com.mojang.authlib.GameProfile;

public class class_r extends class_i {
	@Override
	public String c() {
		return "ban";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.ban.usage";
	}

	@Override
	public boolean a(ICommandListener var1) {
		return MinecraftServer.P().ar().h().b() && super.a(var1);
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length >= 1) && (var2[0].length() > 0)) {
			MinecraftServer var3 = MinecraftServer.P();
			GameProfile var4 = var3.aH().a(var2[0]);
			if (var4 == null) {
				throw new class_bz("commands.ban.failed", new Object[] { var2[0] });
			} else {
				String var5 = null;
				if (var2.length >= 2) {
					var5 = a(var1, var2, 1).c();
				}

				class_mk var6 = new class_mk(var4, (Date) null, var1.e_(), (Date) null, var5);
				var3.ar().h().a(var6);
				class_lm var7 = var3.ar().a(var2[0]);
				if (var7 != null) {
					var7.a.c("You are banned from this server.");
				}

				a(var1, this, "commands.ban.success", new Object[] { var2[0] });
			}
		} else {
			throw new class_cf("commands.ban.usage", new Object[0]);
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length >= 1 ? a(var2, MinecraftServer.P().M()) : null;
	}
}
