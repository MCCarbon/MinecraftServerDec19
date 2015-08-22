package net.minecraft.server;

import java.util.List;

import com.google.common.base.Predicate;

public class class_abf extends Item {
	public class_abf() {
		this.a(class_abp.k);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		List var5 = var2.a(class_qv.class, var3.aX().b(2.0D, 2.0D, 2.0D), new Predicate() {
			public boolean a(class_qv var1) {
				return (var1 != null) && var1.al() && (var1.s() instanceof class_vx);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_qv) var1);
			}
		});
		if (!var5.isEmpty()) {
			class_qv var8 = (class_qv) var5.get(0);
			var8.a(var8.i() - 0.5F);
			return new class_px(class_pw.a, this.a(var1, var3, new class_aco(Items.bF)));
		} else {
			class_ayl var6 = this.a(var2, var3, true);
			if (var6 == null) {
				return new class_px(class_pw.b, var1);
			} else {
				if (var6.a == class_ayl.class_a_in_class_ayl.b) {
					class_cj var7 = var6.a();
					if (!var2.a(var3, var7) || !var3.a(var7.a(var6.b), var6.b, var1)) {
						return new class_px(class_pw.b, var1);
					}

					if (var2.p(var7).c().v() == class_avq.h) {
						return new class_px(class_pw.a, this.a(var1, var3, new class_aco(Items.bB)));
					}
				}

				return new class_px(class_pw.b, var1);
			}
		}
	}

	protected class_aco a(class_aco var1, class_yu var2, class_aco var3) {
		--var1.b;
		var2.b(class_nh.c(Item.b(this)));
		if (var1.b <= 0) {
			return var3;
		} else {
			if (!var2.bq.a(var3)) {
				var2.a(var3, false);
			}

			return var1;
		}
	}
}
