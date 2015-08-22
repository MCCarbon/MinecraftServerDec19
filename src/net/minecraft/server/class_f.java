package net.minecraft.server;

import io.netty.util.ResourceLeakDetector;

public class class_f {
	public static final ResourceLeakDetector.Level a;
	public static final char[] b;

	public static boolean a(char var0) {
		return (var0 != 167) && (var0 >= 32) && (var0 != 127);
	}

	public static String a(String var0) {
		StringBuilder var1 = new StringBuilder();
		char[] var2 = var0.toCharArray();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			char var5 = var2[var4];
			if (a(var5)) {
				var1.append(var5);
			}
		}

		return var1.toString();
	}

	static {
		a = ResourceLeakDetector.Level.DISABLED;
		b = new char[] { '/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
		ResourceLeakDetector.setLevel(a);
	}
}
