package net.minecraft.server;

import java.io.IOException;

public class class_jx implements Packet {
	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
	}

	public void a(class_jv var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_jv) var1);
	}
}
