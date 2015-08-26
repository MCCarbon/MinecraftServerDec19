package net.minecraft.server;

import java.util.UUID;

public abstract class class_pn {
	private final UUID g;
	protected IChatBaseComponent a;
	protected float b;
	protected class_pn.class_a_in_class_pn c;
	protected class_pn.class_b_in_class_pn d;
	protected boolean e;
	protected boolean f;

	public class_pn(UUID var1, IChatBaseComponent var2, class_pn.class_a_in_class_pn var3, class_pn.class_b_in_class_pn var4, boolean var5, boolean var6) {
		g = var1;
		a = var2;
		c = var3;
		d = var4;
		e = var5;
		f = var6;
		b = 1.0F;
	}

	public UUID d() {
		return g;
	}

	public IChatBaseComponent e() {
		return a;
	}

	public float f() {
		return b;
	}

	public void a(float var1) {
		b = var1;
	}

	public class_pn.class_a_in_class_pn g() {
		return c;
	}

	public class_pn.class_b_in_class_pn h() {
		return d;
	}

	public boolean i() {
		return e;
	}

	public boolean j() {
		return f;
	}

	public static enum class_b_in_class_pn {
		a,
		b,
		c,
		d,
		e;
	}

	public static enum class_a_in_class_pn {
		a,
		b,
		c,
		d,
		e,
		f,
		g;
	}
}
