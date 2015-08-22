package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_adb extends Item {
	public class_adb() {
		this.d(1);
		this.a(class_abp.k);
	}

	public static List h(class_aco var0) {
		ArrayList var1 = Lists.newArrayList();
		var1.addAll(i(var0).b());
		if (var0.n() && var0.o().b("CustomPotionEffects", 9)) {
			class_du var2 = var0.o().c("CustomPotionEffects", 10);

			for (int var3 = 0; var3 < var2.c(); ++var3) {
				class_dn var4 = var2.b(var3);
				class_qr var5 = class_qr.b(var4);
				if (var5 != null) {
					var1.add(var5);
				}
			}
		}

		return var1;
	}

	@Override
	public class_aco a(class_aco var1, class_ago var2, class_rg var3) {
		class_yu var4 = var3 instanceof class_yu ? (class_yu) var3 : null;
		if ((var4 == null) || !var4.bI.d) {
			--var1.b;
		}

		if (!var2.D) {
			List var5 = h(var1);
			Iterator var6 = var5.iterator();

			while (var6.hasNext()) {
				class_qr var7 = (class_qr) var6.next();
				var3.c(new class_qr(var7));
			}
		}

		if (var4 != null) {
			var4.b(class_nh.c(Item.b(this)));
		}

		if ((var4 == null) || !var4.bI.d) {
			if (var1.b <= 0) {
				return new class_aco(Items.bE);
			}

			if (var4 != null) {
				var4.bq.a(new class_aco(Items.bE));
			}
		}

		return var1;
	}

	@Override
	public int e(class_aco var1) {
		return 32;
	}

	@Override
	public class_ady f(class_aco var1) {
		return class_ady.c;
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		var3.c(var4);
		return new class_px(class_pw.a, var1);
	}

	public static int a(Collection var0) {
		int var1 = 3694022;
		if (var0.isEmpty()) {
			return 3694022;
		} else {
			float var2 = 0.0F;
			float var3 = 0.0F;
			float var4 = 0.0F;
			int var5 = 0;
			Iterator var6 = var0.iterator();

			while (var6.hasNext()) {
				class_qr var7 = (class_qr) var6.next();
				if (var7.e()) {
					int var8 = var7.a().g();
					int var9 = var7.c() + 1;
					var2 += var9 * ((var8 >> 16) & 255) / 255.0F;
					var3 += var9 * ((var8 >> 8) & 255) / 255.0F;
					var4 += var9 * ((var8 >> 0) & 255) / 255.0F;
					var5 += var9;
				}
			}

			if (var5 == 0) {
				return 0;
			} else {
				var2 = (var2 / var5) * 255.0F;
				var3 = (var3 / var5) * 255.0F;
				var4 = (var4 / var5) * 255.0F;
				return ((int) var2 << 16) | ((int) var3 << 8) | (int) var4;
			}
		}
	}

	@Override
	public String a(class_aco var1) {
		return class_di.a(i(var1).a());
	}

	public static class_aec i(class_aco var0) {
		return !var0.n() ? class_aee.a : class_aec.a(var0.o().l("Potion"));
	}

	public static class_aco a(class_aco var0, class_aec var1) {
		class_ke var2 = (class_ke) class_aec.a.b(var1);
		if (var2 != null) {
			class_dn var3 = var0.n() ? var0.o() : new class_dn();
			var3.a("Potion", var2.toString());
			var0.d(var3);
		}

		return var0;
	}
}
