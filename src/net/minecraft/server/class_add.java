package net.minecraft.server;

import java.util.Map;

import com.google.common.collect.Maps;

public class class_add extends Item {
	private static final Map b = Maps.newHashMap();
	public final String a;

	protected class_add(String var1) {
		a = var1;
		i = 1;
		this.a(class_abp.f);
		b.put("records." + var1, this);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		class_apn var10 = var3.p(var4);
		if ((var10.c() == Blocks.aN) && !((Boolean) var10.b(class_ala.a)).booleanValue()) {
			if (!var3.D) {
				((class_ala) Blocks.aN).a(var3, var4, var10, var1);
				var3.a((class_yu) null, 1005, var4, Item.b(this));
				--var1.b;
				var2.b(class_nh.Y);
			}

			return class_pw.a;
		} else {
			return class_pw.b;
		}
	}

	@Override
	public class_adc g(class_aco var1) {
		return class_adc.c;
	}
}
