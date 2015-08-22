package net.minecraft.server;


public class class_aea extends class_acm {
	public class_aea() {
		this.d(1);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		var3.a(var1);
		var3.b(class_nh.c(class_acm.b(this)));
		return new class_px(class_pw.a, var1);
	}

	public static boolean b(class_dn var0) {
		if (var0 == null) {
			return false;
		} else if (!var0.b("pages", 9)) {
			return false;
		} else {
			class_du var1 = var0.c("pages", 8);

			for (int var2 = 0; var2 < var1.c(); ++var2) {
				String var3 = var1.g(var2);
				if (var3 == null) {
					return false;
				}

				if (var3.length() > 32767) {
					return false;
				}
			}

			return true;
		}
	}
}
