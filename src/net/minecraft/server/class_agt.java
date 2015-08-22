package net.minecraft.server;

public class class_agt {
	public static final class_agt[] a = new class_agt[16];
	public static final class_agt b = (new class_agt(0, "default", 1)).i();
	public static final class_agt c = new class_agt(1, "flat");
	public static final class_agt d = new class_agt(2, "largeBiomes");
	public static final class_agt e = (new class_agt(3, "amplified")).j();
	public static final class_agt f = new class_agt(4, "customized");
	public static final class_agt g = new class_agt(5, "debug_all_block_states");
	public static final class_agt h = (new class_agt(8, "default_1_1", 0)).a(false);
	private final int i;
	private final String j;
	private final int k;
	private boolean l;
	private boolean m;
	private boolean n;

	private class_agt(int var1, String var2) {
		this(var1, var2, 0);
	}

	private class_agt(int var1, String var2, int var3) {
		j = var2;
		k = var3;
		l = true;
		i = var1;
		a[var1] = this;
	}

	public String a() {
		return j;
	}

	public int d() {
		return k;
	}

	public class_agt a(int var1) {
		return (this == b) && (var1 == 0) ? h : this;
	}

	private class_agt a(boolean var1) {
		l = var1;
		return this;
	}

	private class_agt i() {
		m = true;
		return this;
	}

	public boolean f() {
		return m;
	}

	public static class_agt a(String var0) {
		for (int var1 = 0; var1 < a.length; ++var1) {
			if ((a[var1] != null) && a[var1].j.equalsIgnoreCase(var0)) {
				return a[var1];
			}
		}

		return null;
	}

	public int g() {
		return i;
	}

	private class_agt j() {
		n = true;
		return this;
	}
}
