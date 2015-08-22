package net.minecraft.server;


public class class_ayl {
	private class_cj e;
	public class_ayl.class_a_in_class_ayl a;
	public class_cq b;
	public class_aym c;
	public class_qx d;

	public class_ayl(class_aym var1, class_cq var2, class_cj var3) {
		this(class_ayl.class_a_in_class_ayl.b, var1, var2, var3);
	}

	public class_ayl(class_aym var1, class_cq var2) {
		this(class_ayl.class_a_in_class_ayl.b, var1, var2, class_cj.a);
	}

	public class_ayl(class_qx var1) {
		this(var1, new class_aym(var1.s, var1.t, var1.u));
	}

	public class_ayl(class_ayl.class_a_in_class_ayl var1, class_aym var2, class_cq var3, class_cj var4) {
		a = var1;
		e = var4;
		b = var3;
		c = new class_aym(var2.a, var2.b, var2.c);
	}

	public class_ayl(class_qx var1, class_aym var2) {
		a = class_ayl.class_a_in_class_ayl.c;
		d = var1;
		c = var2;
	}

	public class_cj a() {
		return e;
	}

	@Override
	public String toString() {
		return "HitResult{type=" + a + ", blockpos=" + e + ", f=" + b + ", pos=" + c + ", entity=" + d + '}';
	}

	public static enum class_a_in_class_ayl {
		a,
		b,
		c;
	}
}
