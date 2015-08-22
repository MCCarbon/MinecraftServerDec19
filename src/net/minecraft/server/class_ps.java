package net.minecraft.server;

public enum class_ps {
	a(0, "options.difficulty.peaceful"),
	b(1, "options.difficulty.easy"),
	c(2, "options.difficulty.normal"),
	d(3, "options.difficulty.hard");

	private static final class_ps[] e;
	private final int f;
	private final String g;

	private class_ps(int var3, String var4) {
		f = var3;
		g = var4;
	}

	public int a() {
		return f;
	}

	public static class_ps a(int var0) {
		return e[var0 % e.length];
	}

	public String b() {
		return g;
	}

	static {
		e = new class_ps[values().length];
		class_ps[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			class_ps var3 = var0[var2];
			e[var3.f] = var3;
		}

	}
}
