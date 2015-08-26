package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

public class class_ja implements Packet {
	private UUID a;

	public class_ja() {
	}

	public class_ja(UUID var1) {
		a = var1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.i();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
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
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
