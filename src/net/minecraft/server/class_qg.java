package net.minecraft.server;


public class class_qg {
	private final class_qi a;
	private final int b;
	private final float c;
	private final float d;
	private final String e;
	private final float f;

	public class_qg(class_qi var1, int var2, float var3, float var4, String var5, float var6) {
		a = var1;
		b = var2;
		c = var4;
		d = var3;
		e = var5;
		f = var6;
	}

	public class_qi a() {
		return a;
	}

	public float c() {
		return c;
	}

	public boolean f() {
		return a.j() instanceof EntityLiving;
	}

	public String g() {
		return e;
	}

	public IChatBaseComponent h() {
		return a().j() == null ? null : a().j().f_();
	}

	public float j() {
		return a == class_qi.j ? Float.MAX_VALUE : f;
	}
}
