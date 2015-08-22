package net.minecraft.server;

import java.util.List;

import com.mojang.authlib.GameProfile;

public class class_at extends class_i {
	@Override
	public String c() {
		return "pardon";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public String c(class_m var1) {
		return "commands.unban.usage";
	}

	@Override
	public boolean a(class_m var1) {
		return MinecraftServer.P().ar().h().b() && super.a(var1);
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if ((var2.length == 1) && (var2[0].length() > 0)) {
			MinecraftServer var3 = MinecraftServer.P();
			GameProfile var4 = var3.ar().h().a(var2[0]);
			if (var4 == null) {
				throw new class_bz("commands.unban.failed", new Object[] { var2[0] });
			} else {
				var3.ar().h().c(var4);
				a(var1, this, "commands.unban.success", new Object[] { var2[0] });
			}
		} else {
			throw new class_cf("commands.unban.usage", new Object[0]);
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().ar().h().a()) : null;
	}
}
