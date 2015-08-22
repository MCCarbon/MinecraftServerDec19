package net.minecraft.server;

import java.io.File;
import java.util.Iterator;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;

public class class_mj extends class_mi {
	public class_mj(File var1) {
		super(var1);
	}

	@Override
	protected class_mh a(JsonObject var1) {
		return new class_mk(var1);
	}

	public boolean a(GameProfile var1) {
		return this.d(var1);
	}

	@Override
	public String[] a() {
		String[] var1 = new String[e().size()];
		int var2 = 0;

		class_mk var4;
		for (Iterator var3 = e().values().iterator(); var3.hasNext(); var1[var2++] = ((GameProfile) var4.f()).getName()) {
			var4 = (class_mk) var3.next();
		}

		return var1;
	}

	protected String b(GameProfile var1) {
		return var1.getId().toString();
	}

	public GameProfile a(String var1) {
		Iterator var2 = e().values().iterator();

		class_mk var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (class_mk) var2.next();
		} while (!var1.equalsIgnoreCase(((GameProfile) var3.f()).getName()));

		return (GameProfile) var3.f();
	}

	// $FF: synthetic method
	@Override
	protected String a(Object var1) {
		return this.b((GameProfile) var1);
	}
}
