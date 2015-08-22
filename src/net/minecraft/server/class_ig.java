package net.minecraft.server;

import java.io.IOException;

public class class_ig implements class_ff {
	private String a;

	public class_ig() {
	}

	public class_ig(String var1) {
		if (var1.length() > 100) {
			var1 = var1.substring(0, 100);
		}

		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.c(100);
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public String a() {
		return a;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
