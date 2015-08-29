package net.minecraft.server;


public enum class_ri {
	a(class_xx.class, 70, class_avq.a, false, false),
	b(EntityAnimal.class, 10, class_avq.a, true, true),
	c(class_uz.class, 15, class_avq.a, true, false),
	d(class_vq.class, 5, class_avq.h, true, false);

	private final Class e;
	private final int f;
	private final class_avq g;
	private final boolean h;
	private final boolean i;

	private class_ri(Class var3, int var4, class_avq var5, boolean var6, boolean var7) {
		e = var3;
		f = var4;
		g = var5;
		h = var6;
		i = var7;
	}

	public Class a() {
		return e;
	}

	public int b() {
		return f;
	}

	public boolean d() {
		return h;
	}

	public boolean e() {
		return i;
	}

}
