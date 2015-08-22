package net.minecraft.server;

import java.util.Date;

import com.google.gson.JsonObject;

public class class_mc extends class_lz {
	public class_mc(String var1) {
		this(var1, (Date) null, (String) null, (Date) null, (String) null);
	}

	public class_mc(String var1, Date var2, String var3, Date var4, String var5) {
		super(var1, var2, var3, var4, var5);
	}

	public class_mc(JsonObject var1) {
		super(b(var1), var1);
	}

	private static String b(JsonObject var0) {
		return var0.has("ip") ? var0.get("ip").getAsString() : null;
	}

	@Override
	protected void a(JsonObject var1) {
		if (f() != null) {
			var1.addProperty("ip", (String) f());
			super.a(var1);
		}
	}
}
