package net.minecraft.server;

import java.io.File;
import java.net.SocketAddress;

import com.google.gson.JsonObject;

public class class_mb extends class_mi {
	public class_mb(File var1) {
		super(var1);
	}

	@Override
	protected class_mh a(JsonObject var1) {
		return new class_mc(var1);
	}

	public boolean a(SocketAddress var1) {
		String var2 = this.c(var1);
		return this.d(var2);
	}

	public class_mc b(SocketAddress var1) {
		String var2 = this.c(var1);
		return (class_mc) this.b(var2);
	}

	private String c(SocketAddress var1) {
		String var2 = var1.toString();
		if (var2.contains("/")) {
			var2 = var2.substring(var2.indexOf(47) + 1);
		}

		if (var2.contains(":")) {
			var2 = var2.substring(0, var2.indexOf(58));
		}

		return var2;
	}
}
