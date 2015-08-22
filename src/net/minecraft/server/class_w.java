package net.minecraft.server;

import java.util.List;

import com.mojang.authlib.GameProfile;

public class class_w extends class_i {
	@Override
	public String c() {
		return "deop";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public String c(class_m var1) {
		return "commands.deop.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if ((var2.length == 1) && (var2[0].length() > 0)) {
			MinecraftServer var3 = MinecraftServer.P();
			GameProfile var4 = var3.ar().m().a(var2[0]);
			if (var4 == null) {
				throw new class_bz("commands.deop.failed", new Object[] { var2[0] });
			} else {
				var3.ar().b(var4);
				a(var1, this, "commands.deop.success", new Object[] { var2[0] });
			}
		} else {
			throw new class_cf("commands.deop.usage", new Object[0]);
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().ar().n()) : null;
	}
}
