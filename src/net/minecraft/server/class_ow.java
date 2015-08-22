package net.minecraft.server;

import java.util.UUID;

public class class_ow implements class_ok {
	@Override
	public int a() {
		return 108;
	}

	@Override
	public class_dn a(class_dn var1) {
		if (var1.b("UUID", 8)) {
			var1.a("UUID", UUID.fromString(var1.l("UUID")));
		}

		return var1;
	}
}
