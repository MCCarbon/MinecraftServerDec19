package net.minecraft.server;


public class class_agy extends class_oi.class_a_in_class_oi {
	private final class_dn b;

	public class_agy() {
		super(1);
		b = new class_dn();
		b.a("id", "Pig");
	}

	public class_agy(class_dn var1) {
		this(var1.b("Weight", 99) ? var1.h("Weight") : 1, var1.o("Entity"));
	}

	public class_agy(int var1, class_dn var2) {
		super(var1);
		b = var2;
	}

	public class_dn a() {
		class_dn var1 = new class_dn();
		var1.a("Entity", b);
		var1.a("Weight", a);
		return var1;
	}

	public class_dn b() {
		return b;
	}
}
