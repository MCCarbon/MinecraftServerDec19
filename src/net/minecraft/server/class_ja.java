package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

public class class_ja implements class_ff {
	private UUID a;

	public class_ja() {
	}

	public class_ja(UUID var1) {
		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.i();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public Entity a(class_ll var1) {
		return var1.a(a);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
