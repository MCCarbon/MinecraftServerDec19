package net.minecraft.server;


public enum class_abt implements class_oe {
	a("WHITE", 0, 0, 15, "white", "white", class_avr.j, EnumChatFormat.WHITE),
	b("ORANGE", 1, 1, 14, "orange", "orange", class_avr.q, EnumChatFormat.GOLD),
	c("MAGENTA", 2, 2, 13, "magenta", "magenta", class_avr.r, EnumChatFormat.AQUA),
	d("LIGHT_BLUE", 3, 3, 12, "light_blue", "lightBlue", class_avr.s, EnumChatFormat.BLUE),
	e("YELLOW", 4, 4, 11, "yellow", "yellow", class_avr.t, EnumChatFormat.YELLOW),
	f("LIME", 5, 5, 10, "lime", "lime", class_avr.u, EnumChatFormat.GREEN),
	g("PINK", 6, 6, 9, "pink", "pink", class_avr.v, EnumChatFormat.LIGHT_PURPLE),
	h("GRAY", 7, 7, 8, "gray", "gray", class_avr.w, EnumChatFormat.DARK_GRAY),
	i("SILVER", 8, 8, 7, "silver", "silver", class_avr.x, EnumChatFormat.GRAY),
	j("CYAN", 9, 9, 6, "cyan", "cyan", class_avr.y, EnumChatFormat.DARK_AQUA),
	k("PURPLE", 10, 10, 5, "purple", "purple", class_avr.z, EnumChatFormat.DARK_PURPLE),
	l("BLUE", 11, 11, 4, "blue", "blue", class_avr.A, EnumChatFormat.DARK_BLUE),
	m("BROWN", 12, 12, 3, "brown", "brown", class_avr.B, EnumChatFormat.GOLD),
	n("GREEN", 13, 13, 2, "green", "green", class_avr.C, EnumChatFormat.DARK_GREEN),
	o("RED", 14, 14, 1, "red", "red", class_avr.D, EnumChatFormat.DARK_RED),
	p("BLACK", 15, 15, 0, "black", "black", class_avr.E, EnumChatFormat.BLACK);

	private static final class_abt[] q;
	private static final class_abt[] r;
	private final int s;
	private final int t;
	private final String u;
	private final String v;
	private final class_avr w;
	private final EnumChatFormat x;

	private class_abt(String name, int ordinal, int var3, int var4, String var5, String var6, class_avr var7, EnumChatFormat var8) {
		this(var3, var4, var5, var6, var7, var8);
	}

	private class_abt(int var3, int var4, String var5, String var6, class_avr var7, EnumChatFormat var8) {
		s = var3;
		t = var4;
		u = var5;
		v = var6;
		w = var7;
		x = var8;
	}

	public int a() {
		return s;
	}

	public int b() {
		return t;
	}

	public String d() {
		return v;
	}

	public class_avr e() {
		return w;
	}

	public static class_abt a(int var0) {
		if ((var0 < 0) || (var0 >= r.length)) {
			var0 = 0;
		}

		return r[var0];
	}

	public static class_abt b(int var0) {
		if ((var0 < 0) || (var0 >= q.length)) {
			var0 = 0;
		}

		return q[var0];
	}

	@Override
	public String toString() {
		return v;
	}

	@Override
	public String l() {
		return u;
	}

	static {
		q = new class_abt[values().length];
		r = new class_abt[values().length];
		class_abt[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			class_abt var3 = var0[var2];
			q[var3.a()] = var3;
			r[var3.b()] = var3;
		}

	}
}
