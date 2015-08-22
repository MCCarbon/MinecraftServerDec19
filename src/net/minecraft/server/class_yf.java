package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_yf {
	private static final Logger g = LogManager.getLogger();
	public static final class_rp a = (new class_rx((class_rp) null, "generic.maxHealth", 20.0D, 0.0D, 1024.0D)).a("Max Health").a(true);
	public static final class_rp b = (new class_rx((class_rp) null, "generic.followRange", 32.0D, 0.0D, 2048.0D)).a("Follow Range");
	public static final class_rp c = (new class_rx((class_rp) null, "generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).a("Knockback Resistance");
	public static final class_rp d = (new class_rx((class_rp) null, "generic.movementSpeed", 0.699999988079071D, 0.0D, 1024.0D)).a("Movement Speed").a(true);
	public static final class_rp e = new class_rx((class_rp) null, "generic.attackDamage", 2.0D, 0.0D, 2048.0D);
	public static final class_rp f = (new class_rx((class_rp) null, "generic.attackSpeed", 4.0D, 0.0D, 1024.0D)).a(true);

	public static class_du a(class_rt var0) {
		class_du var1 = new class_du();
		Iterator var2 = var0.a().iterator();

		while (var2.hasNext()) {
			class_rq var3 = (class_rq) var2.next();
			var1.a(a(var3));
		}

		return var1;
	}

	private static class_dn a(class_rq var0) {
		class_dn var1 = new class_dn();
		class_rp var2 = var0.a();
		var1.a("Name", var2.a());
		var1.a("Base", var0.b());
		Collection var3 = var0.c();
		if ((var3 != null) && !var3.isEmpty()) {
			class_du var4 = new class_du();
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				class_rr var6 = (class_rr) var5.next();
				if (var6.e()) {
					var4.a(a(var6));
				}
			}

			var1.a("Modifiers", var4);
		}

		return var1;
	}

	private static class_dn a(class_rr var0) {
		class_dn var1 = new class_dn();
		var1.a("Name", var0.b());
		var1.a("Amount", var0.d());
		var1.a("Operation", var0.c());
		var1.a("UUID", var0.a());
		return var1;
	}

	public static void a(class_rt var0, class_du var1) {
		for (int var2 = 0; var2 < var1.c(); ++var2) {
			class_dn var3 = var1.b(var2);
			class_rq var4 = var0.a(var3.l("Name"));
			if (var4 != null) {
				a(var4, var3);
			} else {
				g.warn("Ignoring unknown attribute \'" + var3.l("Name") + "\'");
			}
		}

	}

	private static void a(class_rq var0, class_dn var1) {
		var0.a(var1.k("Base"));
		if (var1.b("Modifiers", 9)) {
			class_du var2 = var1.c("Modifiers", 10);

			for (int var3 = 0; var3 < var2.c(); ++var3) {
				class_rr var4 = a(var2.b(var3));
				if (var4 != null) {
					class_rr var5 = var0.a(var4.a());
					if (var5 != null) {
						var0.c(var5);
					}

					var0.b(var4);
				}
			}
		}

	}

	public static class_rr a(class_dn var0) {
		UUID var1 = var0.a("UUID");

		try {
			return new class_rr(var1, var0.l("Name"), var0.k("Amount"), var0.h("Operation"));
		} catch (Exception var3) {
			g.warn("Unable to create attribute: " + var3.getMessage());
			return null;
		}
	}
}
