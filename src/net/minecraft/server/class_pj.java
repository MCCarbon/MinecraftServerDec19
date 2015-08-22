package net.minecraft.server;


public abstract class class_pj implements class_oq {
	private final String a;
	private final String b;

	public class_pj(String var1, String var2) {
		a = var1;
		b = var2;
	}

	@Override
	public class_dn a(class_on var1, class_dn var2, int var3) {
		if (var2.l(a).equals(b)) {
			var2 = b(var1, var2, var3);
		}

		return var2;
	}

	abstract class_dn b(class_on var1, class_dn var2, int var3);
}
