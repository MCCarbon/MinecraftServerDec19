package net.minecraft.server;

import java.io.IOException;

public class class_iz implements Packet {
	private class_pu a;

	public class_iz() {
	}

	public class_iz(class_pu var1) {
		a = var1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = (class_pu) var1.a(class_pu.class);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public class_pu a() {
		return a;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
