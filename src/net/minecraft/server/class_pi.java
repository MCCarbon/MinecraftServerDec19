package net.minecraft.server;


public class class_pi extends class_pj {
	private final String[] a;

	public class_pi(String var1, String... var2) {
		super("id", var1);
		a = var2;
	}

	@Override
	class_dn b(class_on var1, class_dn var2, int var3) {
		int var4 = 0;

		for (int var5 = a.length; var4 < var5; ++var4) {
			var2 = class_op.b(var1, var2, var3, a[var4]);
		}

		return var2;
	}
}
