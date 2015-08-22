package net.minecraft.server;


public class class_ack extends class_acm {
	private final Class a;

	public class_ack(Class var1) {
		a = var1;
		this.a(class_abp.c);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		class_cj var10 = var4.a(var6);
		if ((var6 != class_cq.a) && (var6 != class_cq.b) && var2.a(var10, var6, var1)) {
			class_wt var11 = this.a(var3, var10, var6);
			if ((var11 != null) && var11.i()) {
				if (!var3.D) {
					var3.a(var11);
				}

				--var1.b;
			}

			return class_pw.a;
		} else {
			return class_pw.c;
		}
	}

	private class_wt a(class_ago var1, class_cj var2, class_cq var3) {
		return a == class_ww.class ? new class_ww(var1, var2, var3) : (a == class_wu.class ? new class_wu(var1, var2, var3) : null);
	}
}
