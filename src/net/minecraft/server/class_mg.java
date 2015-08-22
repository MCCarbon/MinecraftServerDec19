package net.minecraft.server;

import java.util.UUID;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;

public class class_mg extends class_mh {
	private final int a;
	private final boolean b;

	public class_mg(GameProfile var1, int var2, boolean var3) {
		super(var1);
		a = var2;
		b = var3;
	}

	public class_mg(JsonObject var1) {
		super(b(var1), var1);
		a = var1.has("level") ? var1.get("level").getAsInt() : 0;
		b = var1.has("bypassesPlayerLimit") && var1.get("bypassesPlayerLimit").getAsBoolean();
	}

	public int a() {
		return a;
	}

	public boolean b() {
		return b;
	}

	@Override
	protected void a(JsonObject var1) {
		if (f() != null) {
			var1.addProperty("uuid", ((GameProfile) f()).getId() == null ? "" : ((GameProfile) f()).getId().toString());
			var1.addProperty("name", ((GameProfile) f()).getName());
			super.a(var1);
			var1.addProperty("level", Integer.valueOf(a));
			var1.addProperty("bypassesPlayerLimit", Boolean.valueOf(b));
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
