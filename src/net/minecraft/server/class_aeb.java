package net.minecraft.server;


public class class_aeb extends class_acm {
	public class_aeb() {
		this.d(1);
	}

	public static boolean b(class_dn var0) {
		if (!class_aea.b(var0)) {
			return false;
		} else if (!var0.b("title", 8)) {
			return false;
		} else {
			String var1 = var0.l("title");
			return (var1 != null) && (var1.length() <= 32) ? var0.b("author", 8) : false;
		}
	}

	public static int h(class_aco var0) {
		return var0.o().h("generation");
	}

	@Override
	public String a(class_aco var1) {
		if (var1.n()) {
			class_dn var2 = var1.o();
			String var3 = var2.l("title");
			if (!class_of.b(var3)) {
				return var3;
			}
		}

		return super.a(var1);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (!var2.D) {
			this.a(var1, var3);
		}

		var3.a(var1);
		var3.b(class_nh.c(class_acm.b(this)));
		return new class_px(class_pw.a, var1);
	}

	private void a(class_aco var1, class_yu var2) {
		if ((var1 != null) && (var1.o() != null)) {
			class_dn var3 = var1.o();
			if (!var3.p("resolved")) {
				var3.a("resolved", true);
				if (b(var3)) {
					class_du var4 = var3.c("pages", 8);

					for (int var5 = 0; var5 < var4.c(); ++var5) {
						String var6 = var4.g(var5);

						Object var7;
						try {
							class_eu var11 = class_eu.class_a_in_class_eu.b(var6);
							var7 = class_ev.a(var2, var11, var2);
						} catch (Exception var9) {
							var7 = new class_fa(var6);
						}

						var4.a(var5, new class_ea(class_eu.class_a_in_class_eu.a((class_eu) var7)));
					}

					var3.a("pages", var4);
					if ((var2 instanceof class_lm) && (var2.bG() == var1)) {
						class_aas var10 = var2.bs.a(var2.bq, var2.bq.d);
						((class_lm) var2).a.a((new class_gg(0, var10.e, var1)));
					}

				}
			}
		}
	}
}
