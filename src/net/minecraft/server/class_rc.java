package net.minecraft.server;

public enum class_rc {
	a("MAINHAND", 0, class_rc.class_a_in_class_rc.a, 0, 0, "mainhand"),
	b("OFFHAND", 1, class_rc.class_a_in_class_rc.a, 1, 5, "offhand"),
	c("FEET", 2, class_rc.class_a_in_class_rc.b, 0, 1, "feet"),
	d("LEGS", 3, class_rc.class_a_in_class_rc.b, 1, 2, "legs"),
	e("TORSO", 4, class_rc.class_a_in_class_rc.b, 2, 3, "torso"),
	f("HEAD", 5, class_rc.class_a_in_class_rc.b, 3, 4, "head");

	private final class_rc.class_a_in_class_rc g;
	private final int h;
	private final int i;
	private final String j;

	private class_rc(String name, int ordinal, class_rc.class_a_in_class_rc var3, int var4, int var5, String var6) {
		this(var3, var4, var5, var6);
	}

	private class_rc(class_rc.class_a_in_class_rc var3, int var4, int var5, String var6) {
		g = var3;
		h = var4;
		i = var5;
		j = var6;
	}

	public class_rc.class_a_in_class_rc a() {
		return g;
	}

	public int b() {
		return h;
	}

	public int c() {
		return i;
	}

	public static enum class_a_in_class_rc {
		a,
		b;
	}
}
