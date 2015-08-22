package net.minecraft.server;


public class class_auq extends class_axj {
	private class_dn b = new class_dn();

	public class_auq(String var1) {
		super(var1);
	}

	@Override
	public void a(class_dn var1) {
		b = var1.o("Features");
	}

	@Override
	public void b(class_dn var1) {
		var1.a("Features", b);
	}

	public void a(class_dn var1, int var2, int var3) {
		b.a(b(var2, var3), var1);
	}

	public static String b(int var0, int var1) {
		return "[" + var0 + "," + var1 + "]";
	}

	public class_dn a() {
		return b;
	}
}
