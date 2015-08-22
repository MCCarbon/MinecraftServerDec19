package net.minecraft.server;

import java.util.List;

import com.mojang.authlib.GameProfile;

public class class_bw extends class_i {
	@Override
	public String c() {
		return "whitelist";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.whitelist.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 1) {
			throw new class_cf("commands.whitelist.usage", new Object[0]);
		} else {
			MinecraftServer var3 = MinecraftServer.P();
			if (var2[0].equals("on")) {
				var3.ar().a(true);
				a(var1, this, "commands.whitelist.enabled", new Object[0]);
			} else if (var2[0].equals("off")) {
				var3.ar().a(false);
				a(var1, this, "commands.whitelist.disabled", new Object[0]);
			} else if (var2[0].equals("list")) {
				var1.a(new class_fb("commands.whitelist.list", new Object[] { Integer.valueOf(var3.ar().l().length), Integer.valueOf(var3.ar().q().length) }));
				String[] var4 = var3.ar().l();
				var1.a(new class_fa(a(var4)));
			} else {
				GameProfile var5;
				if (var2[0].equals("add")) {
					if (var2.length < 2) {
						throw new class_cf("commands.whitelist.add.usage", new Object[0]);
					}

					var5 = var3.aH().a(var2[1]);
					if (var5 == null) {
						throw new class_bz("commands.whitelist.add.failed", new Object[] { var2[1] });
					}

					var3.ar().d(var5);
					a(var1, this, "commands.whitelist.add.success", new Object[] { var2[1] });
				} else if (var2[0].equals("remove")) {
					if (var2.length < 2) {
						throw new class_cf("commands.whitelist.remove.usage", new Object[0]);
					}

					var5 = var3.ar().k().a(var2[1]);
					if (var5 == null) {
						throw new class_bz("commands.whitelist.remove.failed", new Object[] { var2[1] });
					}

					var3.ar().c(var5);
					a(var1, this, "commands.whitelist.remove.success", new Object[] { var2[1] });
				} else if (var2[0].equals("reload")) {
					var3.ar().a();
					a(var1, this, "commands.whitelist.reloaded", new Object[0]);
				}
			}

		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		if (var2.length == 1) {
			return a(var2, new String[] { "on", "off", "list", "add", "remove", "reload" });
		} else {
			if (var2.length == 2) {
				if (var2[0].equals("remove")) {
					return a(var2, MinecraftServer.P().ar().l());
				}

				if (var2[0].equals("add")) {
					return a(var2, MinecraftServer.P().aH().a());
				}
			}

			return null;
		}
	}
}
