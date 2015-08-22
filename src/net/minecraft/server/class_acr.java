package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_acr extends Item {
	public class_acr() {
		this.a(class_abp.i);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		Block var10 = var3.p(var4).c();
		if (!(var10 instanceof class_akb)) {
			return class_pw.b;
		} else {
			if (!var3.D) {
				a(var2, var3, var4);
			}

			return class_pw.a;
		}
	}

	public static boolean a(class_yu var0, class_ago var1, class_cj var2) {
		class_wv var3 = class_wv.b(var1, var2);
		boolean var4 = false;
		double var5 = 7.0D;
		int var7 = var2.n();
		int var8 = var2.o();
		int var9 = var2.p();
		List var10 = var1.a(class_rh.class, new class_ayk(var7 - var5, var8 - var5, var9 - var5, var7 + var5, var8 + var5, var9 + var5));
		Iterator var11 = var10.iterator();

		while (var11.hasNext()) {
			class_rh var12 = (class_rh) var11.next();
			if (var12.cu() && (var12.cv() == var0)) {
				if (var3 == null) {
					var3 = class_wv.a(var1, var2);
				}

				var12.a(var3, true);
				var4 = true;
			}
		}

		return var4;
	}
}
