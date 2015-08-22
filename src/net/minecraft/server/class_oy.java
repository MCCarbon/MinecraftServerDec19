package net.minecraft.server;

import java.util.List;

import com.google.common.collect.Lists;

public class class_oy implements class_ok {
	private static final List a = Lists.newArrayList((Object[]) (new String[] { "MinecartRideable", "MinecartChest", "MinecartFurnace", "MinecartTNT", "MinecartSpawner", "MinecartHopper", "MinecartCommandBlock" }));

	@Override
	public int a() {
		return 106;
	}

	@Override
	public class_dn a(class_dn var1) {
		if ("Minecart".equals(var1.l("id"))) {
			String var2 = "MinecartRideable";
			int var3 = var1.h("Type");
			if ((var3 > 0) && (var3 < a.size())) {
				var2 = (String) a.get(var3);
			}

			var1.a("id", var2);
			var1.q("Type");
		}

		return var1;
	}
}
