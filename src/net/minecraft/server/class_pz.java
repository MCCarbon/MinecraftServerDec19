package net.minecraft.server;


public class class_pz {
	public static final class_pz a = new class_pz("");
	private final String b;

	public class_pz(String var1) {
		b = var1;
	}

	public boolean a() {
		return (b == null) || b.isEmpty();
	}

	public String b() {
		return b;
	}

	public void a(class_dn var1) {
		var1.a("Lock", b);
	}

	public static class_pz b(class_dn var0) {
		if (var0.b("Lock", 8)) {
			String var1 = var0.l("Lock");
			return new class_pz(var1);
		} else {
			return a;
		}
	}
}
