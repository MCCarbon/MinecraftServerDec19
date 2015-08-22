package net.minecraft.server;

import java.util.Random;

public class class_aby extends class_acm {
	@Override
	public boolean f_(class_aco var1) {
		return false;
	}

	@Override
	public class_adc g(class_aco var1) {
		return !h(var1).c_() ? class_adc.b : super.g(var1);
	}

	public class_du h(class_aco var1) {
		class_dn var2 = var1.o();
		return (var2 != null) && var2.b("StoredEnchantments", 9) ? (class_du) var2.c("StoredEnchantments") : new class_du();
	}

	public void a(class_aco var1, class_afm var2) {
		class_du var3 = h(var1);
		boolean var4 = true;

		for (int var5 = 0; var5 < var3.c(); ++var5) {
			class_dn var6 = var3.b(var5);
			if (class_afj.c(var6.g("id")) == var2.b) {
				if (var6.g("lvl") < var2.c) {
					var6.a("lvl", (short) var2.c);
				}

				var4 = false;
				break;
			}
		}

		if (var4) {
			class_dn var7 = new class_dn();
			var7.a("id", (short) class_afj.b(var2.b));
			var7.a("lvl", (short) var2.c);
			var3.a(var7);
		}

		if (!var1.n()) {
			var1.d(new class_dn());
		}

		var1.o().a("StoredEnchantments", var3);
	}

	public class_aco a(class_afm var1) {
		class_aco var2 = new class_aco(this);
		this.a(var2, var1);
		return var2;
	}

	public class_oj b(Random var1) {
		return this.a(var1, 1, 1, 1);
	}

	public class_oj a(Random var1, int var2, int var3, int var4) {
		class_aco var5 = new class_aco(class_acq.aN);
		class_afl.a(var1, var5, 30);
		return new class_oj(var5, var2, var3, var4);
	}
}
