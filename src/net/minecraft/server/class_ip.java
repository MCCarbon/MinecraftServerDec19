package net.minecraft.server;

import java.io.IOException;

public class class_ip implements Packet {
	private int a;

	public void a(class_id var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
	}

	public int a() {
		return a;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
