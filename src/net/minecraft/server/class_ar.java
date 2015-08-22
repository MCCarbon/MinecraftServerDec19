package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

public class class_ar extends class_i {
	@Override
	public String c() {
		return "op";
	}

	@Override
	public int a() {
		return 3;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.op.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length == 1) && (var2[0].length() > 0)) {
			MinecraftServer var3 = MinecraftServer.P();
			GameProfile var4 = var3.aH().a(var2[0]);
			if (var4 == null) {
				throw new class_bz("commands.op.failed", new Object[] { var2[0] });
			} else {
				var3.ar().a(var4);
				a(var1, this, "commands.op.success", new Object[] { var2[0] });
			}
		} else {
			throw new class_cf("commands.op.usage", new Object[0]);
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		if (var2.length == 1) {
			String var4 = var2[var2.length - 1];
			ArrayList var5 = Lists.newArrayList();
			GameProfile[] var6 = MinecraftServer.P().N();
			int var7 = var6.length;

			for (int var8 = 0; var8 < var7; ++var8) {
				GameProfile var9 = var6[var8];
				if (!MinecraftServer.P().ar().h(var9) && a(var4, var9.getName())) {
					var5.add(var9.getName());
				}
			}

			return var5;
		} else {
			return null;
		}
	}
}
