package net.minecraft.server;


public class class_ou implements class_ok {
	@Override
	public int a() {
		return 111;
	}

	@Override
	public class_dn a(class_dn var1) {
		String var2 = var1.l("id");
		boolean var3 = "Painting".equals(var2);
		boolean var4 = "ItemFrame".equals(var2);
		if ((var3 || var4) && !var1.b("Facing", 99)) {
			class_cq var5;
			if (var1.b("Direction", 99)) {
				var5 = class_cq.b(var1.f("Direction"));
				var1.a("TileX", var1.h("TileX") + var5.g());
				var1.a("TileY", var1.h("TileY") + var5.h());
				var1.a("TileZ", var1.h("TileZ") + var5.i());
				var1.q("Direction");
				if (var4 && var1.b("ItemRotation", 99)) {
					var1.a("ItemRotation", (byte) (var1.f("ItemRotation") * 2));
				}
			} else {
				var5 = class_cq.b(var1.f("Dir"));
				var1.q("Dir");
			}

			var1.a("Facing", (byte) var5.b());
		}

		return var1;
	}
}
