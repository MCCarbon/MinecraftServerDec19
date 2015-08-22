package net.minecraft.server;

import java.util.Date;
import java.util.UUID;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;

public class class_mk extends class_lz {
	public class_mk(GameProfile var1) {
		this(var1, (Date) null, (String) null, (Date) null, (String) null);
	}

	public class_mk(GameProfile var1, Date var2, String var3, Date var4, String var5) {
		super(var1, var4, var3, var4, var5);
	}

	public class_mk(JsonObject var1) {
		super(b(var1), var1);
	}

	@Override
	protected void a(JsonObject var1) {
		if (f() != null) {
			var1.addProperty("uuid", ((GameProfile) f()).getId() == null ? "" : ((GameProfile) f()).getId().toString());
			var1.addProperty("name", ((GameProfile) f()).getName());
			super.a(var1);
		}
	}

	private static GameProfile b(JsonObject var0) {
		if (var0.has("uuid") && var0.has("name")) {
			String var1 = var0.get("uuid").getAsString();

			UUID var2;
			try {
				var2 = UUID.fromString(var1);
			} catch (Throwable var4) {
				return null;
			}

			return new GameProfile(var2, var0.get("name").getAsString());
		} else {
			return null;
		}
	}
}
