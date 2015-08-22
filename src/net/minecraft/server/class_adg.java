package net.minecraft.server;


public class class_adg extends class_aci {
	private class_ail b;
	private class_ail c;

	public class_adg(int var1, float var2, class_ail var3, class_ail var4) {
		super(var1, var2, false);
		b = var3;
		c = var4;
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if ((var6 == class_cq.b) && var2.a(var4.a(var6), var6, var1) && (var3.p(var4).c() == c) && var3.d(var4.a())) {
			var3.a(var4.a(), b.S());
			--var1.b;
			return class_pw.a;
		} else {
			return class_pw.c;
		}
	}
}
